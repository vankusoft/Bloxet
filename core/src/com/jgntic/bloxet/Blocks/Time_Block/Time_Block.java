package com.jgntic.bloxet.Blocks.Time_Block;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.jgntic.bloxet.Blocks.Blocks;
import com.jgntic.bloxet.Blocks.Blocks_Manager;
import com.jgntic.bloxet.Blocks.Bomb_block_array;
import com.jgntic.bloxet.Bloxet;
import com.jgntic.bloxet.Managers.Grid;
import com.jgntic.bloxet.Managers.MiddleClassInformation;

/**
 * Created by IVAN on 11.5.2016 г..
 */
public class Time_Block extends Blocks {

    public static boolean deleteBlock;
    public static boolean generate_block;
    public boolean landed;
    public static boolean draw_bonus_time=false;

    public int y_down=18;
    public int x_movement= Blocks_Manager.random_x;

    float stateTimer;

    Array<TextureRegion> frames;
    Animation time_block_animation;

    Texture time_block_invert;
    TextureRegion time_block_invert_region;

    Bloxet game;

    long block_id;

    public Time_Block(World world, float x, float y,Bloxet game,boolean infinity) {
        super(world, x, y,game,infinity);

        this.game=game;

        stateTimer=0;

        texture=game.assetManager.get("clock.png");
        blocksRegion=new TextureRegion(texture,0,0,65,65);

        time_block_invert=game.assetManager.get("clock_invert.png");
        time_block_invert_region=new TextureRegion(time_block_invert,0,0,65,65);

        frames=new Array<TextureRegion>();
        frames.add(blocksRegion);
        frames.add(time_block_invert_region);

        time_block_animation=new Animation(0.2f,frames);

        deleteBlock=false;

        Time_Block_array.delete_specific_body.add(this);
    }

    public void down_movement(){

        if(y_down==0)
        {
            Grid.grid[y_down][x_movement] = 5;
        }
        else
        {
            if(Grid.grid[y_down-1][x_movement]==0)
            {

                Grid.grid[y_down][x_movement]=0;

                y_down -= 1;

                Grid.grid[y_down][x_movement]=5;

            }
            else
            {
                Grid.grid[y_down][x_movement]=5;
            }
        }
        body.setTransform(new Vector2(Grid.array_position[0][x_movement].x / Bloxet.PPM, Grid.array_position[y_down][0].y / Bloxet.PPM), 0);
    }

    public void collision_detection(){

        if(Grid.grid[y_down][x_movement]==5 && ( y_down<18 &&(Grid.grid[y_down+1][x_movement]!=0 )))

        {
            deleteBlock=true;
            draw_bonus_time=true;
            System.out.println("Time ++");
        }
    }

    private void generate_block()
    {
        if(!landed)
        {
            if( (y_down>0 && (Grid.grid[y_down-1][x_movement]!=0)) || (y_down==0))
            {
                if(MiddleClassInformation.mute==0)
                {
                    block_id=game.assetManager.get("sound_effects/block_landed.ogg",Sound.class).play();
                    game.assetManager.get("sound_effects/block_landed.ogg",Sound.class).setVolume(block_id,0.5f);
                }

                generate_block=true;
                landed=true;
            }
        }
    }

    @Override
    public void update() {
        super.update();

        stateTimer+=Gdx.graphics.getDeltaTime();

        setRegion(time_block_animation.getKeyFrame(stateTimer,true));

        //Handle movement, collision and set user data to body
        if(TimeUtils.timeSinceNanos(startTime)>0.05 * convert_in_nanoseconds)
        {
            down_movement();

            body.setUserData(Grid.array_position[y_down][x_movement]);

            startTime = TimeUtils.nanoTime();
        }
        //****************************

        collision_detection();

        generate_block();
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
    }

    @Override
    public void dispose() {
        texture.dispose();
    }
}
