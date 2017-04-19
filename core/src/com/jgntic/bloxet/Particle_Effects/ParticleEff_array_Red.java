package com.jgntic.bloxet.Particle_Effects;

import com.badlogic.gdx.utils.Array;
import com.jgntic.bloxet.Bloxet;

/**
 * Created by IVAN on 1.6.2016 г..
 */
public class ParticleEff_array_Red {

    Array<ParticleEff_Red> particleEff_red;

    public ParticleEff_array_Red(){
        particleEff_red =new Array<ParticleEff_Red>();
    }

    public void update(Bloxet game){
        if(particleEff_red !=null)
        {
            for(ParticleEff_Red particleEff: particleEff_red)
            {
                particleEff.update_and_draw(game.batch);
            }
        }
    }

    public void dispose(){
        if(particleEff_red !=null)
        {
            for(ParticleEff_Red particleEff: particleEff_red)
            {
                particleEff.dispose();
            }
        }
    }

    public Array<ParticleEff_Red> getParticleEff_reds() {
        return particleEff_red;
    }
}
