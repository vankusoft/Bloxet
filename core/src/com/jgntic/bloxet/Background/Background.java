package com.jgntic.bloxet.Background;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.jgntic.bloxet.Bloxet;

/**
 * Created by IVAN on 4.5.2016 г..
 */
public class Background extends Sprite {

    TextureRegion bg;
    Texture background;
    float x,y;


    public Background(float x,float y,Bloxet game)
    {
        this.x=x;
        this.y=y;

        background=game.assetManager.get("background.png");
        bg=new TextureRegion(background,0,0,2015,3330);

        setColor(1,1,1,0.2f);

        setBounds(0,0,480/ Bloxet.PPM,800/ Bloxet.PPM);
    }

    public void update()
    {
        setRegion(bg);
        setPosition(x-getWidth()/2,y-getHeight()/2);
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
