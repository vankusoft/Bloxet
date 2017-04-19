package com.jgntic.bloxet.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.jgntic.bloxet.Bloxet;

/**
 * Created by IVAN on 13.6.2016 г..
 */
public class IntroScreen implements Screen {

    Bloxet game;

    Viewport viewport,stage_viewport;
    OrthographicCamera cam;

    Texture jgntic_logo_texture;
    Image jgntic_logo_image;

    boolean switch_to_menu=false;

    float stateTimer=0;

    Stage stage;

    public IntroScreen(Bloxet game)
    {
        this.game=game;

        cam=new OrthographicCamera();
        viewport=new FitViewport(Bloxet.WIDTH/ Bloxet.PPM, Bloxet.HEIGHT/ Bloxet.PPM,cam);
        cam.position.set(viewport.getWorldWidth()/2,viewport.getWorldHeight()/2,0);

        stage_viewport=new FitViewport(Bloxet.WIDTH,Bloxet.HEIGHT);

        stage=new Stage(stage_viewport,game.batch);

        jgntic_logo_texture=game.assetManager.get("jgntic_logo.png");
        jgntic_logo_texture.setFilter(Texture.TextureFilter.Linear,Texture.TextureFilter.Linear);

        jgntic_logo_image=new Image(jgntic_logo_texture);
        jgntic_logo_image.setPosition(Bloxet.WIDTH/2-175,400);
        jgntic_logo_image.setSize(350,80);

        stage.addActor(jgntic_logo_image);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        game.batch.setProjectionMatrix(cam.combined);

        stage.draw();

        stateTimer+=delta;

        if(stateTimer>5 && !switch_to_menu)
        {
            game.setScreen(new MenuScreen(game));
            switch_to_menu=true;
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

        game.assetManager.dispose();

    }
}
