package com.jgntic.bloxet.Particle_Effects;

import com.badlogic.gdx.utils.Array;
import com.jgntic.bloxet.Bloxet;

/**
 * Created by IVAN on 1.6.2016 г..
 */
public class ParticleEff_array_Blue {

    Array<ParticleEff_Blue> particleEff_blues;

    public ParticleEff_array_Blue(){
        particleEff_blues =new Array<ParticleEff_Blue>();
    }

    public void update(Bloxet game){
        if(particleEff_blues !=null)
        {
            for(ParticleEff_Blue particleEff: particleEff_blues)
            {
                particleEff.update_and_draw(game.batch);
            }
        }
    }

    public void dispose(){
        if(particleEff_blues !=null)
        {
            for(ParticleEff_Blue particleEff: particleEff_blues)
            {
                particleEff.dispose();
            }
        }
    }


    public Array<ParticleEff_Blue> getParticleEff_blues() {
        return particleEff_blues;
    }


}
