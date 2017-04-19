package com.jgntic.bloxet.Particle_Effects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jgntic.bloxet.Bloxet;

/**
 * Created by IVAN on 2.6.2016 г..
 */
public class ParticleEff_Bomb {

    ParticleEffect particleEffect;

    float x;
    float y;

    public ParticleEff_Bomb(float x, float y,Bloxet game)
    {
        this.x=x;
        this.y=y;

        particleEffect=new ParticleEffect();
        particleEffect.load(Gdx.files.internal("effects/bomb_effect.p"),Gdx.files.internal("effects"));
        particleEffect.scaleEffect(0.009f);
        particleEffect.setDuration(2);
        particleEffect.setPosition(x,y);
        particleEffect.start();

    }

    public void update_and_draw(SpriteBatch sb)
    {
        if (!particleEffect.isComplete()) {
            particleEffect.draw(sb, Gdx.graphics.getDeltaTime());

        }
    }

    public void dispose()
    {
        particleEffect.dispose();
    }
}
