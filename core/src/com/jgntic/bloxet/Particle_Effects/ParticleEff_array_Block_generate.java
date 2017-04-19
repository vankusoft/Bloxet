package com.jgntic.bloxet.Particle_Effects;

import com.badlogic.gdx.utils.Array;
import com.jgntic.bloxet.Bloxet;

/**
 * Created by IVAN on 18.6.2016 г..
 */
public class ParticleEff_array_Block_generate {

    Array<ParticleEff_Block_generate> particleEff_block_generate;

    public ParticleEff_array_Block_generate(){
        particleEff_block_generate =new Array<ParticleEff_Block_generate>();
    }

    public void update(Bloxet game){
        if(particleEff_block_generate !=null)
        {
            for(ParticleEff_Block_generate particleEff: particleEff_block_generate)
            {
                particleEff.update_and_draw(game.batch);
            }
        }
    }

    public void dispose(){
        if(particleEff_block_generate !=null)
        {
            for(ParticleEff_Block_generate particleEff: particleEff_block_generate)
            {
                particleEff.dispose();
            }
        }
    }


    public Array<ParticleEff_Block_generate> getParticleEff_block_generate() {
        return particleEff_block_generate;
    }

}
