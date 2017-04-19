package com.jgntic.bloxet.Blocks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jgntic.bloxet.Blocks.Delete_blocks_by_bomb.Bomb_blocks1;
import com.jgntic.bloxet.Blocks.Delete_blocks_by_bomb.Bomb_blocks2;
import com.jgntic.bloxet.Blocks.Delete_blocks_by_bomb.Bomb_blocks3;
import com.jgntic.bloxet.Blocks.Delete_blocks_by_bomb.Bomb_blocks6;
import com.jgntic.bloxet.Blocks.Delete_blocks_by_bomb.Bomb_time;
import com.jgntic.bloxet.Bloxet;
import com.jgntic.bloxet.Managers.Grid;
import com.jgntic.bloxet.Managers.MiddleClassInformation;
import com.jgntic.bloxet.Particle_Effects.ParticleEff_Bomb;

/**
 * Created by IVAN on 8.5.2016 г..
 */
public class Delete_Bomb_block {

    int rows = 18;
    int columns = 11;

    public static int positionA_1,positionA_2,
            positionB_1,positionB_2,
            positionC_1,positionC_2,
            positionD_1,positionD_2,
            positionE_1,positionE_2,
            positionF_1,position_F2,
            positionG_1,positionG_2,
            positionH_1,positionH_2,
            positionI_1,positionI_2;

    public static boolean posC,posD,posE,posF,posG,posH,posI;

    Bomb_blocks1 bomb_blocks1;
    Bomb_blocks2 bomb_blocks2;
    Bomb_blocks3 bomb_blocks3;
    Bomb_blocks6 bomb_blocks6;
    Bomb_time bomb_time;

    ParticleEff_Bomb particleEff_bomb;

    float stateTimer=0;

    Bloxet game;

    public Delete_Bomb_block(Bloxet game){
        this.game=game;

        bomb_blocks1=new Bomb_blocks1();
        bomb_blocks2=new Bomb_blocks2();
        bomb_blocks3=new Bomb_blocks3();
        bomb_blocks6=new Bomb_blocks6();
        bomb_time=new Bomb_time();

        posC=posD=posE=posF=posG=posH=posI=false;
    }

    public void Bomb_block_explode(){

        for(Bomb_block bomb_block: Bomb_block_array.getDelete_specific_body()){

            if(bomb_block!=null && bomb_block.body.getUserData()!=null)
            {
                if(Bomb_block.deleteBlock)
                {

                    for (int r = 0; r < rows; r++) {
                        for (int c = 0; c < columns; c++) {

                            //SQUARE 3x3
                            if (Grid.grid[r][c] == 4 && (r<18 && (Grid.grid[r+1][c] != 0)))
                            {
                                positionA_1 = r;
                                positionA_2 = c;

                                positionB_1 = r + 1;
                                positionB_2 = c;

                                if(r>0)
                                {
                                    posC=true;
                                    positionC_1 = r - 1;
                                    positionC_2 = c;
                                }

                                if(c<10)
                                {
                                    posD=true;
                                    positionD_1 = r;
                                    positionD_2 = c + 1;
                                }

                                if(c>0)
                                {
                                    posE=true;
                                    positionE_1 = r;
                                    positionE_2 = c - 1;
                                }
                                if(r<18 && c>0)
                                {
                                    posF=true;
                                    positionF_1 = r + 1;
                                    position_F2 = c - 1;
                                }

                                if(r<18 && c<10)
                                {
                                    posG=true;
                                    positionG_1 = r + 1;
                                    positionG_2 = c + 1;
                                }

                                if(r>0 && c>0)
                                {
                                    posH=true;
                                    positionH_1 = r - 1;
                                    positionH_2 = c - 1;
                                }

                                if(r>0 && c<10)
                                {
                                    posI=true;
                                    positionI_1 = r - 1;
                                    positionI_2 = c + 1;
                                }
                            }
                        }
                    }

                    if (bomb_block.body.getUserData().equals(Grid.array_position[positionA_1][positionA_2]))
                    {
                        Bomb_block_array.deleteBlock(bomb_block);
                        Grid.grid[positionA_1][positionA_2] = 0;
                        System.out.println("A_Bomb");

                        MiddleClassInformation.coins_count+=4;
                        MiddleClassInformation.coins_collected+=4;
                        MiddleClassInformation.bomb_count-=1;
                        MiddleClassInformation.global_score+=30;
                        MiddleClassInformation.bomb_int+=1;
                        Blocks_Manager.level_score+=30;

                        if(MiddleClassInformation.mute==0)
                        {
                            game.assetManager.get("sound_effects/bomb_explosion.ogg",Sound.class).play();
                        }

                        particleEff_bomb=new ParticleEff_Bomb(bomb_block.body.getPosition().x,bomb_block.body.getPosition().y,game);
                    }
                    if (bomb_block.body.getUserData().equals(Grid.array_position[positionB_1][positionB_2]))
                    {
                        Bomb_block_array.deleteBlock(bomb_block);
                        Grid.grid[positionB_1][positionB_2] = 0;
                        System.out.println("B_bomb");

                        MiddleClassInformation.coins_count+=4;
                        MiddleClassInformation.coins_collected+=4;
                        MiddleClassInformation.bomb_count-=1;
                        MiddleClassInformation.global_score+=60;
                        MiddleClassInformation.bomb_int+=1;
                        Blocks_Manager.level_score+=60;

                        particleEff_bomb=new ParticleEff_Bomb(bomb_block.body.getPosition().x,bomb_block.body.getPosition().y,game);
                    }
                    if (posC && (bomb_block.body.getUserData().equals(Grid.array_position[positionC_1][positionC_2])))
                    {
                        Bomb_block_array.deleteBlock(bomb_block);
                        Grid.grid[positionC_1][positionC_2] = 0;
                        System.out.println("C_bomb");

                        MiddleClassInformation.coins_count+=4;
                        MiddleClassInformation.coins_collected+=4;
                        MiddleClassInformation.bomb_count-=1;
                        MiddleClassInformation.global_score+=60;
                        MiddleClassInformation.bomb_int+=1;
                        Blocks_Manager.level_score+=60;

                        particleEff_bomb=new ParticleEff_Bomb(bomb_block.body.getPosition().x,bomb_block.body.getPosition().y,game);
                    }
                    if (posD && (bomb_block.body.getUserData().equals(Grid.array_position[positionD_1][positionD_2])))
                    {
                        Bomb_block_array.deleteBlock(bomb_block);
                        Grid.grid[positionD_1][positionD_2] = 0;
                        System.out.println("D_bomb");

                        MiddleClassInformation.coins_count+=4;
                        MiddleClassInformation.coins_collected+=4;
                        MiddleClassInformation.bomb_count-=1;
                        MiddleClassInformation.global_score+=60;
                        MiddleClassInformation.bomb_int+=1;
                        Blocks_Manager.level_score+=60;

                        particleEff_bomb=new ParticleEff_Bomb(bomb_block.body.getPosition().x,bomb_block.body.getPosition().y,game);
                    }
                    if (posE && (bomb_block.body.getUserData().equals(Grid.array_position[positionE_1][positionE_2])))
                    {
                        Bomb_block_array.deleteBlock(bomb_block);
                        Grid.grid[positionE_1][positionE_2] = 0;
                        System.out.println("E_bomb");

                        MiddleClassInformation.coins_count+=4;
                        MiddleClassInformation.coins_collected+=4;
                        MiddleClassInformation.bomb_count-=1;
                        MiddleClassInformation.global_score+=60;
                        MiddleClassInformation.bomb_int+=1;
                        Blocks_Manager.level_score+=60;

                        particleEff_bomb=new ParticleEff_Bomb(bomb_block.body.getPosition().x,bomb_block.body.getPosition().y,game);
                    }
                    if (posF && (bomb_block.body.getUserData().equals(Grid.array_position[positionF_1][position_F2])))
                    {
                        Bomb_block_array.deleteBlock(bomb_block);
                        Grid.grid[positionF_1][position_F2] = 0;
                        System.out.println("F_bomb");

                        MiddleClassInformation.coins_count+=4;
                        MiddleClassInformation.coins_collected+=4;
                        MiddleClassInformation.bomb_count-=1;
                        MiddleClassInformation.global_score+=60;
                        MiddleClassInformation.bomb_int+=1;
                        Blocks_Manager.level_score+=60;

                        particleEff_bomb=new ParticleEff_Bomb(bomb_block.body.getPosition().x,bomb_block.body.getPosition().y,game);
                    }
                    if (posG && (bomb_block.body.getUserData().equals(Grid.array_position[positionG_1][positionG_2])))
                    {
                        Bomb_block_array.deleteBlock(bomb_block);
                        Grid.grid[positionG_1][positionG_2] = 0;
                        System.out.println("G_bomb");

                        MiddleClassInformation.coins_count+=4;
                        MiddleClassInformation.coins_collected+=4;
                        MiddleClassInformation.bomb_count-=1;
                        MiddleClassInformation.global_score+=60;
                        MiddleClassInformation.bomb_int+=1;
                        Blocks_Manager.level_score+=60;

                        particleEff_bomb=new ParticleEff_Bomb(bomb_block.body.getPosition().x,bomb_block.body.getPosition().y,game);
                    }
                    if (posH && (bomb_block.body.getUserData().equals(Grid.array_position[positionH_1][positionH_2])))
                    {
                        Bomb_block_array.deleteBlock(bomb_block);
                        Grid.grid[positionH_1][positionH_2] = 0;
                        System.out.println("H_bomb");

                        MiddleClassInformation.coins_count+=4;
                        MiddleClassInformation.coins_collected+=4;
                        MiddleClassInformation.bomb_count-=1;
                        MiddleClassInformation.global_score+=60;
                        MiddleClassInformation.bomb_int+=1;
                        Blocks_Manager.level_score+=60;

                        particleEff_bomb=new ParticleEff_Bomb(bomb_block.body.getPosition().x,bomb_block.body.getPosition().y,game);
                    }
                    if (posI && (bomb_block.body.getUserData().equals(Grid.array_position[positionI_1][positionI_2])))
                    {
                        Bomb_block_array.deleteBlock(bomb_block);
                        Grid.grid[positionI_1][positionI_2] = 0;
                        System.out.println("I_bomb");

                        MiddleClassInformation.coins_count+=4;
                        MiddleClassInformation.coins_collected+=4;
                        MiddleClassInformation.bomb_count-=1;
                        MiddleClassInformation.global_score+=60;
                        MiddleClassInformation.bomb_int+=1;
                        Blocks_Manager.level_score+=60;

                        particleEff_bomb=new ParticleEff_Bomb(bomb_block.body.getPosition().x,bomb_block.body.getPosition().y,game);
                    }
                }
            }
        }
        //*****************************************

        bomb_blocks1.Blocks_1_bombed();
        bomb_blocks2.Blocks2_bombed();
        bomb_blocks3.Blocks3_bombed();
        bomb_blocks6.Blocks6_bombed();
        bomb_time.Time_bombed();

        if(Bomb_block.deleteBlock)
        {
            stateTimer+= Gdx.graphics.getDeltaTime();

            if (stateTimer>0.2f)
            {
                System.out.println("------------------");
                System.out.println("");

                posC=posD=posE=posF=posG=posH=posI=false;

                Bomb_block.deleteBlock = false;

                stateTimer=0;
            }
        }
    }

    public void update(SpriteBatch sb)
    {
        if(particleEff_bomb!=null)
        {
            particleEff_bomb.update_and_draw(sb);
        }
    }
    public void dispose()
    {
        if(particleEff_bomb!=null)
        {
            particleEff_bomb.dispose();
        }
    }
}
