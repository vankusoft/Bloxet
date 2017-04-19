package com.jgntic.bloxet.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.jgntic.bloxet.Background.BG;
import com.jgntic.bloxet.Background.Background_picture;
import com.jgntic.bloxet.Background.Define_BG_BLOCKS;
import com.jgntic.bloxet.Bloxet;
import com.jgntic.bloxet.Managers.Menu_Elements;
import com.jgntic.bloxet.Managers.Shop_Elements;

/**
 * Created by IVAN on 29.5.2016 г..
 */
public class ShopScreen implements Screen {

    Bloxet game;

    Viewport viewport;
    OrthographicCamera cam;

    World world;
    Box2DDebugRenderer box2DDebugRenderer;

    Define_BG_BLOCKS define_bg_blocks;

    Background_picture background_picture;

    Shop_Elements shop_elements;

    public ShopScreen(Bloxet game)
    {
        this.game=game;

        cam=new OrthographicCamera();
        viewport=new FitViewport(Bloxet.WIDTH/ Bloxet.PPM, Bloxet.HEIGHT/ Bloxet.PPM,cam);
        cam.position.set(viewport.getWorldWidth()/2,viewport.getWorldHeight()/2,0);

        world=new World(new Vector2(0,-10),true);

        box2DDebugRenderer=new Box2DDebugRenderer();

        define_bg_blocks=new Define_BG_BLOCKS(world,game);

        background_picture =new Background_picture(0,0,game);

        shop_elements=new Shop_Elements(game.batch,game);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        shop_elements.update();

        game.batch.setProjectionMatrix(cam.combined);

        world.step(1/60f,2,6);

        box2DDebugRenderer.render(world,cam.combined);
        box2DDebugRenderer.setDrawBodies(false);
        box2DDebugRenderer.setDrawContacts(false);

        define_bg_blocks.update();

        //DRAW
        game.batch.begin();

        background_picture.draw(game.batch);
        define_bg_blocks.draw(game);

        game.batch.end();

        shop_elements.draw();
        //END DRAW

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
        define_bg_blocks.dispose();
        shop_elements.dispose();

        game.assetManager.dispose();

        game.batch.dispose();
    }
}
