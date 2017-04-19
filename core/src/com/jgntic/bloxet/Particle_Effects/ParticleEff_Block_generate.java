package com.jgntic.bloxet.Particle_Effects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jgntic.bloxet.Bloxet;

/**
 * Created by IVAN on 18.6.2016 г..
 */
public class ParticleEff_Block_generate {

    ParticleEffect particleEffect;
    ParticleEff_array_Block_generate particleEff_array_block_generate;

    float x;
    float y;

    public ParticleEff_Block_generate(float x, float y,Bloxet game)
    {
        this.x=x;
        this.y=y;

        particleEffect=new ParticleEffect();
        particleEffect.load(Gdx.files.internal("effects/block_generate.p"),Gdx.files.internal("effects"));
        particleEffect.scaleEffect(0.015f);
        particleEffect.setDuration(2);
        particleEffect.setPosition(x,y);
        particleEffect.start();

        particleEff_array_block_generate =new ParticleEff_array_Block_generate();
    }

    public void update_and_draw(SpriteBatch sb)
    {
        if(!particleEffect.isComplete()) {
            particleEffect.draw(sb, Gdx.graphics.getDeltaTime());

        }else
        {
            particleEff_array_block_generate.getParticleEff_block_generate().removeValue(this,true);
        }
    }

    public void dispose(){
        particleEffect.dispose();
    }
}
