package com.jgntic.bloxet.Blocks.Delete_blocks_by_bomb;

import com.jgntic.bloxet.Blocks.Blocks_3;
import com.jgntic.bloxet.Blocks.Blocks_3_array;
import com.jgntic.bloxet.Blocks.Blocks_Manager;
import com.jgntic.bloxet.Blocks.Bomb_block;
import com.jgntic.bloxet.Blocks.Delete_Bomb_block;
import com.jgntic.bloxet.Managers.Grid;
import com.jgntic.bloxet.Managers.MiddleClassInformation;

/**
 * Created by IVAN on 9.5.2016 г..
 */
public class Bomb_blocks3 {

    public void Blocks3_bombed(){
        for(Blocks_3 blocks_3: Blocks_3_array.getDelete_specific_body()) {

            if (blocks_3 != null && blocks_3.body.getUserData() != null) {
                if (Bomb_block.deleteBlock) {

                    if (blocks_3.body.getUserData().equals(Grid.array_position[Delete_Bomb_block.positionB_1][Delete_Bomb_block.positionB_2]))
                    {
                        if(!blocks_3.landed)
                        {
                            Blocks_3.generate_block=true;
                            System.out.println("Blocks_3_bomb_landed:"+blocks_3.landed);
                        }

                        Blocks_3_array.deleteBlock(blocks_3);
                        Grid.grid[Delete_Bomb_block.positionB_1][Delete_Bomb_block.positionB_2] = 0;
                        System.out.println("B3_bomb");

                        MiddleClassInformation.coins_count+=2;
                        MiddleClassInformation.coins_collected+=2;
                        MiddleClassInformation.global_score+=10;
                        MiddleClassInformation.block_3_int+=1;
                        Blocks_Manager.level_score+=10;

                    }
                    if (Delete_Bomb_block.posC && (blocks_3.body.getUserData().equals(Grid.array_position[Delete_Bomb_block.positionC_1][Delete_Bomb_block.positionC_2])))
                    {
                        Blocks_3_array.deleteBlock(blocks_3);
                        Grid.grid[Delete_Bomb_block.positionC_1][Delete_Bomb_block.positionC_2] = 0;
                        System.out.println("C3_bomb");

                        MiddleClassInformation.coins_count+=2;
                        MiddleClassInformation.coins_collected+=2;
                        MiddleClassInformation.global_score+=10;
                        MiddleClassInformation.block_3_int+=1;
                        Blocks_Manager.level_score+=10;
                    }
                    if (Delete_Bomb_block.posD && (blocks_3.body.getUserData().equals(Grid.array_position[Delete_Bomb_block.positionD_1][Delete_Bomb_block.positionD_2])))
                    {
                        Blocks_3_array.deleteBlock(blocks_3);
                        Grid.grid[Delete_Bomb_block.positionD_1][Delete_Bomb_block.positionD_2] = 0;
                        System.out.println("D3_bomb");

                        MiddleClassInformation.coins_count+=2;
                        MiddleClassInformation.coins_collected+=2;
                        MiddleClassInformation.global_score+=10;
                        MiddleClassInformation.block_3_int+=1;
                        Blocks_Manager.level_score+=10;
                    }
                    if (Delete_Bomb_block.posE && (blocks_3.body.getUserData().equals(Grid.array_position[Delete_Bomb_block.positionE_1][Delete_Bomb_block.positionE_2])))
                    {
                        Blocks_3_array.deleteBlock(blocks_3);
                        Grid.grid[Delete_Bomb_block.positionE_1][Delete_Bomb_block.positionE_2] = 0;
                        System.out.println("E3_bomb");

                        MiddleClassInformation.coins_count+=2;
                        MiddleClassInformation.coins_collected+=2;
                        MiddleClassInformation.global_score+=10;
                        MiddleClassInformation.block_3_int+=1;
                        Blocks_Manager.level_score+=10;
                    }
                    if (Delete_Bomb_block.posF && (blocks_3.body.getUserData().equals(Grid.array_position[Delete_Bomb_block.positionF_1][Delete_Bomb_block.position_F2])))
                    {
                        Blocks_3_array.deleteBlock(blocks_3);
                        Grid.grid[Delete_Bomb_block.positionF_1][Delete_Bomb_block.position_F2] = 0;
                        System.out.println("F3_bomb");

                        MiddleClassInformation.coins_count+=2;
                        MiddleClassInformation.coins_collected+=2;
                        MiddleClassInformation.global_score+=10;
                        MiddleClassInformation.block_3_int+=1;
                        Blocks_Manager.level_score+=10;
                    }
                    if (Delete_Bomb_block.posG && (blocks_3.body.getUserData().equals(Grid.array_position[Delete_Bomb_block.positionG_1][Delete_Bomb_block.positionG_2])))
                    {
                        Blocks_3_array.deleteBlock(blocks_3);
                        Grid.grid[Delete_Bomb_block.positionG_1][Delete_Bomb_block.positionG_2] = 0;
                        System.out.println("G3_bomb");

                        MiddleClassInformation.coins_count+=2;
                        MiddleClassInformation.coins_collected+=2;
                        MiddleClassInformation.global_score+=10;
                        MiddleClassInformation.block_3_int+=1;
                        Blocks_Manager.level_score+=10;
                    }
                    if (Delete_Bomb_block.posH && (blocks_3.body.getUserData().equals(Grid.array_position[Delete_Bomb_block.positionH_1][Delete_Bomb_block.positionH_2])))
                    {
                        Blocks_3_array.deleteBlock(blocks_3);
                        Grid.grid[Delete_Bomb_block.positionH_1][Delete_Bomb_block.positionH_2] = 0;
                        System.out.println("H3_bomb");

                        MiddleClassInformation.coins_count+=2;
                        MiddleClassInformation.coins_collected+=2;
                        MiddleClassInformation.global_score+=10;
                        MiddleClassInformation.block_3_int+=1;
                        Blocks_Manager.level_score+=10;
                    }
                    if (Delete_Bomb_block.posI && (blocks_3.body.getUserData().equals(Grid.array_position[Delete_Bomb_block.positionI_1][Delete_Bomb_block.positionI_2])))
                    {
                        Blocks_3_array.deleteBlock(blocks_3);
                        Grid.grid[Delete_Bomb_block.positionI_1][Delete_Bomb_block.positionI_2] = 0;
                        System.out.println("I3_bomb");

                        MiddleClassInformation.coins_count+=2;
                        MiddleClassInformation.coins_collected+=2;
                        MiddleClassInformation.global_score+=10;
                        MiddleClassInformation.block_3_int+=1;
                        Blocks_Manager.level_score+=10;
                    }
                }

            }
        }
    }
}
