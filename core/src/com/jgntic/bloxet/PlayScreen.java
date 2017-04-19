package com.jgntic.bloxet;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.jgntic.bloxet.Background.BG;
import com.jgntic.bloxet.Background.Background;
import com.jgntic.bloxet.Background.Background_picture;
import com.jgntic.bloxet.Background.Define_BG_BLOCKS;
import com.jgntic.bloxet.Blocks.Blocks_Manager;
import com.jgntic.bloxet.Blocks.Time_Block.Time_Block;
import com.jgntic.bloxet.Managers.Grid;
import com.jgntic.bloxet.Managers.MiddleClassInformation;
import com.jgntic.bloxet.Managers.NextLevel;
import com.jgntic.bloxet.Managers.Play_Elements;
import com.jgntic.bloxet.Managers.RandomBodyCreated;
import com.jgntic.bloxet.Managers.TIMER;
import com.jgntic.bloxet.Managers.Transitions_Sprite;
import com.jgntic.bloxet.Managers.Update_DataPreferences;

/**
 * Created by IVAN on 6.4.2016 г..
 */
public class PlayScreen implements Screen {

    Bloxet game;

    Viewport viewport;
    OrthographicCamera cam;

    World world;
    Box2DDebugRenderer box2DDebugRenderer;

    Grid grid;
    Blocks_Manager blocks_manager;

    public RandomBodyCreated randomBodyCreated;

    Background background;
    Background_picture background_picture;
    Define_BG_BLOCKS define_bg_blocks;

    public NextLevel nextLevel;

    Transitions_Sprite transitions_sprite;

    Play_Elements play_elements;
    TIMER timer;

    float bonus16sTimer=0;
    float clockBonusTimer=0;

    Update_DataPreferences update_dataPreferences;

    public PlayScreen(Bloxet game){
        this.game=game;

        cam=new OrthographicCamera();
        viewport=new FitViewport(Bloxet.WIDTH/ Bloxet.PPM, Bloxet.HEIGHT/ Bloxet.PPM,cam);
        cam.position.set(viewport.getWorldWidth()/2,viewport.getWorldHeight()/2,0);

        world=new World(new Vector2(0,-10),true);

        box2DDebugRenderer=new Box2DDebugRenderer();

        grid=new Grid();

        blocks_manager=new Blocks_Manager(world,game);

        randomBodyCreated=new RandomBodyCreated(world,game);
        randomBodyCreated.createBodies();

        background=new Background(240/ Bloxet.PPM,400/ Bloxet.PPM,game);
        background_picture=new Background_picture(0,0,game);

        define_bg_blocks=new Define_BG_BLOCKS(world,game);

        nextLevel=new NextLevel(game,world);

        transitions_sprite=new Transitions_Sprite(game);

        play_elements=new Play_Elements(game.batch,game,this);
        timer=new TIMER(game.batch,game,randomBodyCreated);

        update_dataPreferences=new Update_DataPreferences(game);

    }

    @Override
    public void show() {

    }

    public void update(float dt){

        if(!play_elements.pause_menu_draw  && !nextLevel.completed)
        {
            randomBodyCreated.update();

            if(!play_elements.game_over_draw)
            {
                blocks_manager.update(dt);

                background.update();

                transitions_sprite.update();

                play_elements.update();
            }
        }
        else if(nextLevel.completed)
        {
            play_elements.update();
        }

        define_bg_blocks.update();
    }

    @Override
    public void render(float delta) {
        update(delta);

        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        world.step(1/60f,2,6);

        game.batch.setProjectionMatrix(cam.combined);

        box2DDebugRenderer.render(world,cam.combined);
        box2DDebugRenderer.setDrawBodies(false);
        box2DDebugRenderer.setDrawContacts(false);

        //DRAW *********************
        game.batch.begin();

        background_picture.draw(game.batch);

        define_bg_blocks.draw(game);

        background.draw(game.batch);

        blocks_manager.render(game,delta);

        randomBodyCreated.update_effects();

        transitions_sprite.draw(game.batch);

        if(!play_elements.pause_menu_draw )
        {
            timer.draw_countdown(game.batch);
        }
        play_elements.draw_levels(randomBodyCreated);

        game.batch.end();
        //END DRAW *****************

        timer.draw();

        play_elements.draw();

        update_render();

    }

    void update_render()
    {
        if (play_elements.pause_menu_draw)
        {
            play_elements.draw_pause_menu();
            blocks_manager.can_generate=false;
        }
        else
        {
            blocks_manager.can_generate=true;
        }

        if(play_elements.game_over_draw)
        {
            if(!MiddleClassInformation.infinity_mode)
            {
                play_elements.draw_game_over_stage();
            }
            else
            {
                play_elements.draw_infinite_mode_game_over_stage();
            }
        }

        if(MiddleClassInformation.chain_16s)
        {
            bonus16sTimer+=Gdx.graphics.getDeltaTime();

            if(bonus16sTimer<1.5f)
            {
                play_elements.draw_bonus_stage();
            }
            else
            {
                MiddleClassInformation.chain_16s=false;
                bonus16sTimer=0;
            }
        }

        if(Time_Block.draw_bonus_time)
        {
            clockBonusTimer+=Gdx.graphics.getDeltaTime();

            if(clockBonusTimer<1.5f)
            {
                play_elements.draw_clock_stage();
            }
            else
            {
                Time_Block.draw_bonus_time=false;
                clockBonusTimer=0;
            }
        }

        if(!nextLevel.completed)
        {
            nextLevel.switch_to_next_level(game);
        }

        if(!play_elements.pause_menu_draw && !play_elements.game_over_draw && !nextLevel.completed)
        {
            timer.update();
        }

        if(nextLevel.completed)
        {
            play_elements.draw_completed_mode_stage();
        }

    }

    @Override
    public void resize(int width, int height) {

        viewport.update(width,height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

        blocks_manager.dispose();
        box2DDebugRenderer.dispose();
        world.dispose();
        background.dispose();
        background_picture.dispose();
        define_bg_blocks.dispose();
        transitions_sprite.dispose();
        play_elements.dispose();
        timer.dispose();

        game.assetManager.dispose();
        randomBodyCreated.dispose_effects();

        game.batch.dispose();

    }


}
