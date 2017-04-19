package com.jgntic.bloxet.Blocks.Time_Block;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jgntic.bloxet.Blocks.Blocks_1;
import com.jgntic.bloxet.Blocks.Blocks_Manager;
import com.jgntic.bloxet.Bloxet;
import com.jgntic.bloxet.Managers.Grid;
import com.jgntic.bloxet.Managers.MiddleClassInformation;
import com.jgntic.bloxet.Particle_Effects.ParticleEff_Clock;

/**
 * Created by IVAN on 11.5.2016 г..
 */
public class Delete_Time_Block {

    int rows = 18;
    int columns = 11;

    public static int positionA_1,positionA_2;

    ParticleEff_Clock particleEff_clock;

    Bloxet game;

    public Delete_Time_Block(Bloxet game)
    {
        this.game=game;
    }

    public void Delete_Time_Blocks(){

        for(Time_Block time_block: Time_Block_array.getDelete_specific_body()){

            if(time_block!=null && time_block.body.getUserData()!=null)
            {
                if(Time_Block.deleteBlock)
                {

                    for (int r = 0; r < rows; r++) {
                        for (int c = 0; c < columns; c++) {

                            if(Grid.grid[r][c]==5 && (r<18 && (Grid.grid[r+1][c]!=0)))
                            {
                                positionA_1=r;
                                positionA_2=c;
                            }
                        }
                    }

                    if (time_block.body.getUserData().equals(Grid.array_position[positionA_1][positionA_2]))
                    {
                        Time_Block_array.deleteBlock(time_block);
                        Grid.grid[positionA_1][positionA_2] = 0;
                        System.out.println("Time_Block_A");

                        MiddleClassInformation.coins_count+=2;
                        MiddleClassInformation.coins_collected+=2;
                        MiddleClassInformation.time_count-=1;
                        MiddleClassInformation.global_score+=20;
                        MiddleClassInformation.clock_int+=1;
                        Blocks_Manager.level_score+=20;

                        if(MiddleClassInformation.mute==0)
                        {
                            game.assetManager.get("sound_effects/clock.ogg", Sound.class).play();
                        }

                        particleEff_clock=new ParticleEff_Clock(time_block.body.getPosition().x,time_block.body.getPosition().y,game);
                    }
                }
            }
        }
        //*****************************************

        if(Time_Block.deleteBlock)
        {
            // check if all blocks are deleted
            if(Grid.grid[positionA_1][positionA_2]==0)
            {
                Time_Block.deleteBlock=false;
                System.out.println("------------------");
                System.out.println("");
            }
        }
    }

    public void update(SpriteBatch sb)
    {
        if(particleEff_clock!=null)
        {
            particleEff_clock.update_and_draw(sb);
        }
    }

    public void dispose()
    {
        particleEff_clock.dispose();
    }

}
