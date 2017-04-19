package com.jgntic.bloxet.Particle_Effects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.*;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.jgntic.bloxet.Bloxet;

/**
 * Created by IVAN on 1.6.2016 г..
 */
public class ParticleEff_Blue {

    ParticleEffect particleEffect;
    ParticleEff_array_Blue particleEff_array_blue;

    float x;
    float y;

     public ParticleEff_Blue(float x, float y,Bloxet game)
    {
        this.x=x;
        this.y=y;

        particleEffect=new ParticleEffect();
        particleEffect.load(Gdx.files.internal("effects/blue_explosion.p"),Gdx.files.internal("effects"));
        particleEffect.scaleEffect(0.008f);
        particleEffect.setDuration(5);
        particleEffect.setPosition(x,y);
        particleEffect.start();

        particleEff_array_blue =new ParticleEff_array_Blue();
    }

    public void update_and_draw(SpriteBatch sb)
    {
        if(!particleEffect.isComplete()) {
            particleEffect.draw(sb, Gdx.graphics.getDeltaTime());

        }else
        {
            particleEff_array_blue.getParticleEff_blues().removeValue(this,true);
        }
    }

    public void dispose(){
        particleEffect.dispose();
    }
}
