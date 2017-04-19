package com.jgntic.bloxet.Particle_Effects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jgntic.bloxet.Bloxet;

/**
 * Created by IVAN on 1.6.2016 г..
 */
public class ParticleEff_Yellow {

    ParticleEffect particleEffect;
    ParticleEff_array_Yellow particleEff_array_yellow;

    float x;
    float y;

    public ParticleEff_Yellow(float x, float y,Bloxet game)
    {
        this.x=x;
        this.y=y;

        particleEffect=new ParticleEffect();
        particleEffect.load(Gdx.files.internal("effects/yellow_explosion.p"),Gdx.files.internal("effects"));
        particleEffect.scaleEffect(0.008f);
        particleEffect.setDuration(2);
        particleEffect.setPosition(x,y);
        particleEffect.start();

        particleEff_array_yellow =new ParticleEff_array_Yellow();
    }

    public void update_and_draw(SpriteBatch sb)
    {
        if(!particleEffect.isComplete()) {
            particleEffect.draw(sb, Gdx.graphics.getDeltaTime());

        }else
        {
            particleEff_array_yellow.getParticleEff_yellows().removeValue(this,true);
        }
    }

    public void dispose(){
        particleEffect.dispose();
    }
}
