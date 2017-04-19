package com.jgntic.bloxet.Particle_Effects;

import com.badlogic.gdx.utils.Array;
import com.jgntic.bloxet.Bloxet;

/**
 * Created by IVAN on 1.6.2016 г..
 */
public class ParticleEff_array_Green {

    Array<ParticleEff_Green> particleEff_greens;

    public ParticleEff_array_Green(){
        particleEff_greens =new Array<ParticleEff_Green>();
    }

    public void update(Bloxet game){
        if(particleEff_greens !=null)
        {
            for(ParticleEff_Green particleEff: particleEff_greens)
            {
                particleEff.update_and_draw(game.batch);
            }
        }
    }

    public void dispose()
    {
        if(particleEff_greens !=null)
        {
            for(ParticleEff_Green particleEff: particleEff_greens)
            {
                particleEff.dispose();
            }
        }
    }


    public Array<ParticleEff_Green> getParticleEff_greens() {
        return particleEff_greens;
    }
}
