package com.jgntic.bloxet.Particle_Effects;

import com.badlogic.gdx.utils.Array;
import com.jgntic.bloxet.Bloxet;

/**
 * Created by IVAN on 1.6.2016 г..
 */
public class ParticleEff_array_Yellow {

    Array<ParticleEff_Yellow> particleEff_yellows;

    public ParticleEff_array_Yellow(){
        particleEff_yellows =new Array<ParticleEff_Yellow>();
    }

    public void update(Bloxet game){
        if(particleEff_yellows !=null)
        {
            for(ParticleEff_Yellow particleEff: particleEff_yellows)
            {
                particleEff.update_and_draw(game.batch);
            }
        }
    }

    public void dispose(){
        if(particleEff_yellows !=null)
        {
            for(ParticleEff_Yellow particleEff: particleEff_yellows)
            {
                particleEff.dispose();
            }
        }
    }

    public Array<ParticleEff_Yellow> getParticleEff_yellows() {
        return particleEff_yellows;
    }
}
