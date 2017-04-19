package com.jgntic.bloxet.Managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.jgntic.bloxet.Bloxet;


/**
 * Created by IVAN on 27.5.2016 г..
 */

 public class Transitions_Sprite extends Sprite {

    TextureRegion textureRegion;
    Texture texture;

    public float set_alpha=1f;
    boolean stop;
    public static boolean generate_next_level;

    public Transitions_Sprite(Bloxet game)
    {
        texture=game.assetManager.get("transition_screen.png");
        textureRegion=new TextureRegion(texture,0,0,480,800);

        stop=false;
        generate_next_level=false;

        setColor(1,1,1,set_alpha);

        setBounds(0,0,800/ Bloxet.PPM,1600/Bloxet.PPM);

        setRegion(textureRegion);

        setPosition(getX()-getWidth()/512,getY()-getHeight()/512);
    }

    public void  update(){

        if(!stop && RandomBodyCreated.ready )
        {
            set_alpha-=0.1f;
            setColor(1,1,1,set_alpha);

            if(set_alpha==0.09999993f)
            {
                 stop=true;
            }
        }

        if(NextLevel.next_level)
        {
            set_alpha+=0.1f;
            setColor(1,1,1,set_alpha);

            if(set_alpha==1.0f)
            {
                NextLevel.next_level=false;
                generate_next_level=true;

            }
        }
    }

    public void draw(SpriteBatch batch)
    {
        super.draw(batch);
    }

    public void dispose()
    {
        texture.dispose();
    }
 }

