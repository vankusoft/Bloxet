package com.jgntic.bloxet.Blocks.Blocks_6;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.jgntic.bloxet.Blocks.Blocks_Manager;
import com.jgntic.bloxet.Bloxet;
import com.jgntic.bloxet.Managers.Grid;
import com.jgntic.bloxet.Managers.MiddleClassInformation;
import com.jgntic.bloxet.Particle_Effects.ParticleEff_Yellow;
import com.jgntic.bloxet.Particle_Effects.ParticleEff_array_Yellow;

/**
 * Created by IVAN on 18.5.2016 г..
 */
public class Delete_group_of_Blocks_6  {

    int rows = 18;
    int columns = 10;

    int positionA_1,positionA_2,
            positionB_1,positionB_2,
            positionC_1,positionC_2,
            positionD_1,positionD_2;

    boolean search=false;

    float time=0;
    float delta_time=0;

    int high_block_chain;
    int block_chain=0;

    ParticleEff_array_Yellow particleEff_array_yellow;

    Bloxet game;

    public Delete_group_of_Blocks_6(Bloxet game){
        this.game=game;

        particleEff_array_yellow =new ParticleEff_array_Yellow();
    }

    public void update(){
       particleEff_array_yellow.update(game);
    }

    public void dispose()
    {
        particleEff_array_yellow.dispose();
    }

    public void DeleteGroupBlocks_6(){


        //DELETE GROUP OF 4 BLOCK(COLLISION)
        for(Blocks_6 blocks_6: Blocks_6_array.getDelete_specific_body()){

            if(blocks_6!=null && blocks_6.body.getUserData()!=null)
            {
                if(Blocks_6.deleteBlock)
                {
                    for (int r = 0; r < rows; r++) {
                        for (int c = 0; c <= columns; c++) {

                            //SQUARE
                            if(Grid.grid[r][c]==6 && (c<10 &&(Grid.grid[r][c+1]==6)) && Grid.grid[r+1][c]==6
                                    && (c<10 &&(Grid.grid[r+1][c+1]==6)))
                            {
                                positionA_1=r;
                                positionA_2=c;
                                positionB_1=r;
                                positionB_2=c+1;
                                positionC_1=r+1;
                                positionC_2=c;
                                positionD_1=r+1;
                                positionD_2=c+1;

                                search=true;

                            }

                            //VERTICAL
                            else if((r<15) &&(Grid.grid[r][c]==6 && Grid.grid[r+1][c]==6 && Grid.grid[r+2][c]==6 && Grid.grid[r+3][c]==6))
                            {
                                positionA_1=r;
                                positionA_2=c;
                                positionB_1=r+1;
                                positionB_2=c;
                                positionC_1=r+2;
                                positionC_2=c;
                                positionD_1=r+3;
                                positionD_2=c;

                                search=true;

                            }

                        }

                    }

                    if (blocks_6.body.getUserData().equals(Grid.array_position[positionA_1][positionA_2]))
                    {
                        Blocks_6_array.deleteBlock(blocks_6);
                        Grid.grid[positionA_1][positionA_2] = 0;
                        System.out.println("A6");

                        MiddleClassInformation.coins_count+=1;
                        MiddleClassInformation.coins_collected+=1;
                        MiddleClassInformation.global_score+=5;
                        MiddleClassInformation.block_6_int+=1;
                        Blocks_Manager.level_score+=5;

                        if(MiddleClassInformation.mute==0)
                        {
                            game.assetManager.get("sound_effects/blocks_cleared.ogg",Sound.class).play();
                        }

                        particleEff_array_yellow.getParticleEff_yellows().add(new ParticleEff_Yellow(blocks_6.body.getPosition().x,blocks_6.body.getPosition().y,game));

                    }

                    else if (blocks_6.body.getUserData().equals(Grid.array_position[positionB_1][positionB_2]))
                    {
                        Blocks_6_array.deleteBlock(blocks_6);
                        Grid.grid[positionB_1][positionB_2] = 0;
                        System.out.println("B6");

                        MiddleClassInformation.coins_count+=1;
                        MiddleClassInformation.coins_collected+=1;
                        MiddleClassInformation.global_score+=5;
                        MiddleClassInformation.block_6_int+=1;
                        Blocks_Manager.level_score+=5;

                        particleEff_array_yellow.getParticleEff_yellows().add(new ParticleEff_Yellow(blocks_6.body.getPosition().x, blocks_6.body.getPosition().y,game));

                    }

                    else if (blocks_6.body.getUserData().equals(Grid.array_position[positionC_1][positionC_2]))
                    {
                        Blocks_6_array.deleteBlock(blocks_6);
                        Grid.grid[positionC_1][positionC_2] = 0;
                        System.out.println("C6");

                        MiddleClassInformation.coins_count+=1;
                        MiddleClassInformation.coins_collected+=1;
                        MiddleClassInformation.global_score+=5;
                        MiddleClassInformation.block_6_int+=1;
                        Blocks_Manager.level_score+=5;

                        particleEff_array_yellow.getParticleEff_yellows().add(new ParticleEff_Yellow(blocks_6.body.getPosition().x, blocks_6.body.getPosition().y,game));

                    }

                    else if (blocks_6.body.getUserData().equals(Grid.array_position[positionD_1][positionD_2]))
                    {
                        Blocks_6_array.deleteBlock(blocks_6);
                        Grid.grid[positionD_1][positionD_2] = 0;
                        System.out.println("D6");

                        MiddleClassInformation.coins_count+=1;
                        MiddleClassInformation.coins_collected+=1;
                        MiddleClassInformation.global_score+=5;
                        MiddleClassInformation.block_6_int+=1;
                        Blocks_Manager.level_score+=5;

                        particleEff_array_yellow.getParticleEff_yellows().add(new ParticleEff_Yellow(blocks_6.body.getPosition().x, blocks_6.body.getPosition().y,game));

                    }
                    //delete blocks end condition
                }

////////////////////////////////////////////////////////////////////////////////////////////////////
                for (int r = 0; r < rows; r++) {
                    for (int c = 0 ; c <= columns; c++) {

                        if(search)
                        {
                            if(((Grid.pos_numeration[r][c]!=Grid.pos_numeration[positionA_1][positionA_2]))
                                    && ((Grid.pos_numeration[r][c]!=Grid.pos_numeration[positionB_1][positionB_2]))
                                    && ((Grid.pos_numeration[r][c]!=Grid.pos_numeration[positionC_1][positionC_2]))
                                    && ((Grid.pos_numeration[r][c]!=Grid.pos_numeration[positionD_1][positionD_2]))
                            )
                            {
                                if(
                                        (
                                                        (
                                                                           (r>0  && (Grid.grid[r][c]==Grid.extra_positions[r-1][c]))
                                                                        || (c>0  && (Grid.grid[r][c]==Grid.extra_positions[r][c-1]))
                                                                        || (r<18 && (Grid.grid[r][c]==Grid.extra_positions[r+1][c]))
                                                                        || (c<10 && (Grid.grid[r][c]==Grid.extra_positions[r][c+1]))

                                                        )

                                                        ||

                                                        (
                                                                (r>0 && (Grid.pos_numeration[r-1][c]==Grid.pos_numeration[positionA_1][positionA_2]))
                                                                        || (r>0 && (Grid.pos_numeration[r-1][c]==Grid.pos_numeration[positionB_1][positionB_2]))
                                                                        || (r>0 && (Grid.pos_numeration[r-1][c]==Grid.pos_numeration[positionC_1][positionC_2]))
                                                                        || (r>0 && (Grid.pos_numeration[r-1][c]==Grid.pos_numeration[positionD_1][positionD_2]))
                                                        )

                                                        ||

                                                        (
                                                                (c>0 &&(Grid.pos_numeration[r][c-1]==Grid.pos_numeration[positionA_1][positionA_2]))
                                                                        || (c>0 &&(Grid.pos_numeration[r][c-1]==Grid.pos_numeration[positionB_1][positionB_2]))
                                                                        || (c>0 &&(Grid.pos_numeration[r][c-1]==Grid.pos_numeration[positionC_1][positionC_2]))
                                                                        || (c>0 &&(Grid.pos_numeration[r][c-1]==Grid.pos_numeration[positionD_1][positionD_2]))
                                                        )

                                                        ||

                                                        (
                                                                (c<10 &&(Grid.pos_numeration[r][c+1]==Grid.pos_numeration[positionA_1][positionA_2]))
                                                                        || (c<10 &&(Grid.pos_numeration[r][c+1]==Grid.pos_numeration[positionB_1][positionB_2]))
                                                                        || (c<10 &&(Grid.pos_numeration[r][c+1]==Grid.pos_numeration[positionC_1][positionC_2]))
                                                                        || (c<10 &&(Grid.pos_numeration[r][c+1]==Grid.pos_numeration[positionD_1][positionD_2]))
                                                        )

                                                        ||

                                                        (
                                                                (r<18 &&(Grid.pos_numeration[r+1][c]==Grid.pos_numeration[positionA_1][positionA_2]))
                                                                        || (r<18 &&(Grid.pos_numeration[r+1][c]==Grid.pos_numeration[positionB_1][positionB_2]))
                                                                        || (r<18 &&(Grid.pos_numeration[r+1][c]==Grid.pos_numeration[positionC_1][positionC_2]))
                                                                        || (r<18 &&(Grid.pos_numeration[r+1][c]==Grid.pos_numeration[positionD_1][positionD_2]))
                                                        )


                                        ) && Grid.grid[r][c]==6
                                )
                                {
                                    Grid.extra_positions[r][c]=6;
                                }
                            }
                            if(Grid.extra_positions[r][c]==6)
                            {

                                if( ((Grid.pos_numeration[r][c]!=Grid.pos_numeration[positionA_1][positionA_2]))
                                        && ((Grid.pos_numeration[r][c]!=Grid.pos_numeration[positionB_1][positionB_2]))
                                        && ((Grid.pos_numeration[r][c]!=Grid.pos_numeration[positionC_1][positionC_2]))
                                        && ((Grid.pos_numeration[r][c]!=Grid.pos_numeration[positionD_1][positionD_2]))
                                )
                                {
                                    if (blocks_6.body.getUserData().equals(Grid.array_position[r][c]))
                                    {
                                        if(!blocks_6.landed)
                                        {
                                            blocks_6.landed=true;

                                        }


                                        Blocks_6_array.deleteBlock(blocks_6);
                                        Grid.grid[r][c] = 0;

                                        System.out.println(r+" "+c);

                                        MiddleClassInformation.coins_count+=2;
                                        MiddleClassInformation.coins_collected+=2;
                                        MiddleClassInformation.global_score+=10;
                                        MiddleClassInformation.block_6_int+=1;
                                        Blocks_Manager.level_score+=10;

                                        high_block_chain+=1;

                                        block_chain+=1;

                                        particleEff_array_yellow.getParticleEff_yellows().add(new ParticleEff_Yellow(blocks_6.body.getPosition().x,blocks_6.body.getPosition().y,game));

                                    }
                                }

                            }
                        }
                        //END SEARCH
                    }
                }
                //END second FOR LOOP

////////////////////////////////////////////////////////////////////////////////////////////////////
            }

        }
        //*****************************************

        if(Blocks_6.deleteBlock)
        {
            // check if all blocks are deleted
            if(Grid.grid[positionA_1][positionA_2]==0 && Grid.grid[positionB_1][positionB_2]==0
                    && Grid.grid[positionC_1][positionC_2]==0 && Grid.grid[positionD_1][positionD_2]==0)
            {

                System.out.println("BLock6------------------");
                System.out.println("");

                Blocks_6.deleteBlock=false;
            }
        }
        
        search_time();
    }

    private void search_time()
    {
        if(search)
        {

            delta_time= Gdx.graphics.getDeltaTime();
            time+=delta_time;

            if(0.2f<time)
            {
                search=false;

                if(block_chain>=16)
                {
                    MiddleClassInformation.chain_16s=true;
                    MiddleClassInformation.chain16s+=1;
                    MiddleClassInformation.coins_collected+=500;
                    MiddleClassInformation.coins_count+=500;
                }

               if( MiddleClassInformation.highest_block_6_chain<high_block_chain)
               {
                   MiddleClassInformation.highest_block_6_chain=high_block_chain;
               }
                high_block_chain=0;
                block_chain=0;

                delta_time=0;
                time=0;
            }
        }
        else
        {
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c <= columns; c++) {

                    if(Grid.extra_positions[r][c]==6)
                    {
                        Grid.extra_positions[r][c]=0;
                    }

                }
            }
        }
    }
}
