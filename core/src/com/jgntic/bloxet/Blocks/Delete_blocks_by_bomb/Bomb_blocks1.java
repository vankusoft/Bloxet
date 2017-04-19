package com.jgntic.bloxet.Blocks.Delete_blocks_by_bomb;

import com.jgntic.bloxet.Blocks.Blocks_1;
import com.jgntic.bloxet.Blocks.Blocks_1_array;
import com.jgntic.bloxet.Blocks.Blocks_Manager;
import com.jgntic.bloxet.Blocks.Bomb_block;
import com.jgntic.bloxet.Blocks.Delete_Bomb_block;
import com.jgntic.bloxet.Managers.Grid;
import com.jgntic.bloxet.Managers.MiddleClassInformation;

/**
 * Created by IVAN on 9.5.2016 г..
 */
public class Bomb_blocks1 {

    public void Blocks_1_bombed(){

        for(Blocks_1 blocks_1: Blocks_1_array.getDelete_specific_body()) {

            if (blocks_1 != null && blocks_1.body.getUserData() != null) {
                if (Bomb_block.deleteBlock) {


                    if (blocks_1.body.getUserData().equals(Grid.array_position[Delete_Bomb_block.positionB_1][Delete_Bomb_block.positionB_2])) {

                        if(!blocks_1.landed)
                        {
                            Blocks_1.generate_block=true;
                            System.out.println("Blocks_1_bomb_landed:"+blocks_1.landed);
                        }

                        Blocks_1_array.deleteBlock(blocks_1);
                        Grid.grid[Delete_Bomb_block.positionB_1][Delete_Bomb_block.positionB_2] = 0;

                        MiddleClassInformation.coins_count+=2;
                        MiddleClassInformation.coins_collected+=2;
                        MiddleClassInformation.global_score+=10;
                        MiddleClassInformation.block_1_int+=1;
                        Blocks_Manager.level_score+=10;

                        System.out.println("B1_bomb");

                    }
                    if (Delete_Bomb_block.posC && (blocks_1.body.getUserData().equals(Grid.array_position[Delete_Bomb_block.positionC_1][Delete_Bomb_block.positionC_2]))) {
                        Blocks_1_array.deleteBlock(blocks_1);
                        Grid.grid[Delete_Bomb_block.positionC_1][Delete_Bomb_block.positionC_2] = 0;
                        System.out.println("C1_bomb");

                        MiddleClassInformation.coins_count+=2;
                        MiddleClassInformation.coins_collected+=2;
                        MiddleClassInformation.global_score+=10;
                        MiddleClassInformation.block_1_int+=1;
                        Blocks_Manager.level_score+=10;
                    }
                    if (Delete_Bomb_block.posD && (blocks_1.body.getUserData().equals(Grid.array_position[Delete_Bomb_block.positionD_1][Delete_Bomb_block.positionD_2]))) {
                        Blocks_1_array.deleteBlock(blocks_1);
                        Grid.grid[Delete_Bomb_block.positionD_1][Delete_Bomb_block.positionD_2] = 0;
                        System.out.println("D1_bomb");

                        MiddleClassInformation.coins_count+=2;
                        MiddleClassInformation.coins_collected+=2;
                        MiddleClassInformation.global_score+=10;
                        MiddleClassInformation.block_1_int+=1;
                        Blocks_Manager.level_score+=10;
                    }
                    if (Delete_Bomb_block.posE && (blocks_1.body.getUserData().equals(Grid.array_position[Delete_Bomb_block.positionE_1][Delete_Bomb_block.positionE_2]))) {
                        Blocks_1_array.deleteBlock(blocks_1);
                        Grid.grid[Delete_Bomb_block.positionE_1][Delete_Bomb_block.positionE_2] = 0;
                        System.out.println("E1_bomb");

                        MiddleClassInformation.coins_count+=2;
                        MiddleClassInformation.coins_collected+=2;
                        MiddleClassInformation.global_score+=10;
                        MiddleClassInformation.block_1_int+=1;
                        Blocks_Manager.level_score+=10;
                    }
                    if (Delete_Bomb_block.posF && (blocks_1.body.getUserData().equals(Grid.array_position[Delete_Bomb_block.positionF_1][Delete_Bomb_block.position_F2]))) {
                        Blocks_1_array.deleteBlock(blocks_1);
                        Grid.grid[Delete_Bomb_block.positionF_1][Delete_Bomb_block.position_F2] = 0;
                        System.out.println("F1_bomb");

                        MiddleClassInformation.coins_count+=2;
                        MiddleClassInformation.coins_collected+=2;
                        MiddleClassInformation.global_score+=10;
                        MiddleClassInformation.block_1_int+=1;
                        Blocks_Manager.level_score+=10;
                    }
                    if (Delete_Bomb_block.posG && (blocks_1.body.getUserData().equals(Grid.array_position[Delete_Bomb_block.positionG_1][Delete_Bomb_block.positionG_2]))) {
                        Blocks_1_array.deleteBlock(blocks_1);
                        Grid.grid[Delete_Bomb_block.positionG_1][Delete_Bomb_block.positionG_2] = 0;
                        System.out.println("G1_bomb");

                        MiddleClassInformation.coins_count+=2;
                        MiddleClassInformation.coins_collected+=2;
                        MiddleClassInformation.global_score+=10;
                        MiddleClassInformation.block_1_int+=1;
                        Blocks_Manager.level_score+=10;
                    }
                    if (Delete_Bomb_block.posH && (blocks_1.body.getUserData().equals(Grid.array_position[Delete_Bomb_block.positionH_1][Delete_Bomb_block.positionH_2]))) {
                        Blocks_1_array.deleteBlock(blocks_1);
                        Grid.grid[Delete_Bomb_block.positionH_1][Delete_Bomb_block.positionH_2] = 0;
                        System.out.println("H1_bomb");

                        MiddleClassInformation.coins_count+=2;
                        MiddleClassInformation.coins_collected+=2;
                        MiddleClassInformation.global_score+=10;
                        MiddleClassInformation.block_1_int+=1;
                        Blocks_Manager.level_score+=10;
                    }
                    if (Delete_Bomb_block.posI && (blocks_1.body.getUserData().equals(Grid.array_position[Delete_Bomb_block.positionI_1][Delete_Bomb_block.positionI_2]))) {
                        Blocks_1_array.deleteBlock(blocks_1);
                        Grid.grid[Delete_Bomb_block.positionI_1][Delete_Bomb_block.positionI_2] = 0;
                        System.out.println("I1_bomb");

                        MiddleClassInformation.coins_count+=2;
                        MiddleClassInformation.coins_collected+=2;
                        MiddleClassInformation.global_score+=10;
                        MiddleClassInformation.block_1_int+=1;
                        Blocks_Manager.level_score+=10;
                    }
                }
            }
        }
    }
}
