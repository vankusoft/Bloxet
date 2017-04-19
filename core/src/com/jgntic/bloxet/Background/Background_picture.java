package com.jgntic.bloxet.Background;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.jgntic.bloxet.Bloxet;

/**
 * Created by IVAN on 28.5.2016 г..
 */
public class Background_picture extends Sprite {

    TextureRegion bg;
    Texture background;
    float x,y;

    public Background_picture(float x, float y,Bloxet game)
    {
        this.x=x;
        this.y=y;

        background=game.assetManager.get("background_picture.png");
        bg=new TextureRegion(background,0,0,1002,1669);

        setColor(0.3f,0.3f,0.4f,1f);

        setBounds(0,0,480/ Bloxet.PPM,800/ Bloxet.PPM);
        setRegion(bg);
        setPosition(x,y);
    }


    public void draw(SpriteBatch batch)
    {
        super.draw(batch);
    }

    public void dispose()
    {
        background.dispose();
    }
}
