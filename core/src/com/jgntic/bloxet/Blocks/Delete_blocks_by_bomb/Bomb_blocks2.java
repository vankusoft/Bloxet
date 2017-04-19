package com.jgntic.bloxet.Blocks.Delete_blocks_by_bomb;

import com.jgntic.bloxet.Blocks.Blocks_2;
import com.jgntic.bloxet.Blocks.Blocks_2_array;
import com.jgntic.bloxet.Blocks.Blocks_Manager;
import com.jgntic.bloxet.Blocks.Bomb_block;
import com.jgntic.bloxet.Blocks.Delete_Bomb_block;
import com.jgntic.bloxet.Managers.Grid;
import com.jgntic.bloxet.Managers.MiddleClassInformation;

/**
 * Created by IVAN on 9.5.2016 г..
 */
public class Bomb_blocks2 {

    public void Blocks2_bombed(){
        for(Blocks_2 blocks_2: Blocks_2_array.getDelete_specific_body()) {

            if (blocks_2 != null && blocks_2.body.getUserData() != null) {
                if (Bomb_block.deleteBlock) {

                    if (blocks_2.body.getUserData().equals(Grid.array_position[Delete_Bomb_block.positionB_1][Delete_Bomb_block.positionB_2])) {

                        if(!blocks_2.landed)
                        {
                            Blocks_2.generate_block=true;
                            System.out.println("Blocks_2_bomb_landed:"+blocks_2.landed);
                        }

                        Blocks_2_array.deleteBlock(blocks_2);
                        Grid.grid[Delete_Bomb_block.positionB_1][Delete_Bomb_block.positionB_2] = 0;
                        System.out.println("B2_bomb");

                        MiddleClassInformation.coins_count+=2;
                        MiddleClassInformation.coins_collected+=2;
                        MiddleClassInformation.global_score+=10;
                        MiddleClassInformation.block_2_int+=1;
                        Blocks_Manager.level_score+=10;

                    }
                    if (Delete_Bomb_block.posC && (blocks_2.body.getUserData().equals(Grid.array_position[Delete_Bomb_block.positionC_1][Delete_Bomb_block.positionC_2]))) {
                        Blocks_2_array.deleteBlock(blocks_2);
                        Grid.grid[Delete_Bomb_block.positionC_1][Delete_Bomb_block.positionC_2] = 0;
                        System.out.println("C2_bomb");

                        MiddleClassInformation.coins_count+=2;
                        MiddleClassInformation.coins_collected+=2;
                        MiddleClassInformation.global_score+=10;
                        MiddleClassInformation.block_2_int+=1;
                        Blocks_Manager.level_score+=10;
                    }
                    if (Delete_Bomb_block.posD && (blocks_2.body.getUserData().equals(Grid.array_position[Delete_Bomb_block.positionD_1][Delete_Bomb_block.positionD_2]))) {
                        Blocks_2_array.deleteBlock(blocks_2);
                        Grid.grid[Delete_Bomb_block.positionD_1][Delete_Bomb_block.positionD_2] = 0;
                        System.out.println("D2_bomb");

                        MiddleClassInformation.coins_count+=2;
                        MiddleClassInformation.coins_collected+=2;
                        MiddleClassInformation.global_score+=10;
                        MiddleClassInformation.block_2_int+=1;
                        Blocks_Manager.level_score+=10;
                    }
                    if (Delete_Bomb_block.posE && (blocks_2.body.getUserData().equals(Grid.array_position[Delete_Bomb_block.positionE_1][Delete_Bomb_block.positionE_2]))) {
                        Blocks_2_array.deleteBlock(blocks_2);
                        Grid.grid[Delete_Bomb_block.positionE_1][Delete_Bomb_block.positionE_2] = 0;
                        System.out.println("E2_bomb");

                        MiddleClassInformation.coins_count+=2;
                        MiddleClassInformation.coins_collected+=2;
                        MiddleClassInformation.global_score+=10;
                        MiddleClassInformation.block_2_int+=1;
                        Blocks_Manager.level_score+=10;
                    }
                    if (Delete_Bomb_block.posF && (blocks_2.body.getUserData().equals(Grid.array_position[Delete_Bomb_block.positionF_1][Delete_Bomb_block.position_F2]))) {
                        Blocks_2_array.deleteBlock(blocks_2);
                        Grid.grid[Delete_Bomb_block.positionF_1][Delete_Bomb_block.position_F2] = 0;
                        System.out.println("F2_bomb");

                        MiddleClassInformation.coins_count+=2;
                        MiddleClassInformation.coins_collected+=2;
                        MiddleClassInformation.global_score+=10;
                        MiddleClassInformation.block_2_int+=1;
                        Blocks_Manager.level_score+=10;
                    }
                    if (Delete_Bomb_block.posG && (blocks_2.body.getUserData().equals(Grid.array_position[Delete_Bomb_block.positionG_1][Delete_Bomb_block.positionG_2]))) {
                        Blocks_2_array.deleteBlock(blocks_2);
                        Grid.grid[Delete_Bomb_block.positionG_1][Delete_Bomb_block.positionG_2] = 0;
                        System.out.println("G2_bomb");

                        MiddleClassInformation.coins_count+=2;
                        MiddleClassInformation.coins_collected+=2;
                        MiddleClassInformation.global_score+=10;
                        MiddleClassInformation.block_2_int+=1;
                        Blocks_Manager.level_score+=10;

                    }
                    if (Delete_Bomb_block.posH && (blocks_2.body.getUserData().equals(Grid.array_position[Delete_Bomb_block.positionH_1][Delete_Bomb_block.positionH_2]))) {
                        Blocks_2_array.deleteBlock(blocks_2);
                        Grid.grid[Delete_Bomb_block.positionH_1][Delete_Bomb_block.positionH_2] = 0;
                        System.out.println("H2_bomb");

                        MiddleClassInformation.coins_count+=2;
                        MiddleClassInformation.coins_collected+=2;
                        MiddleClassInformation.global_score+=10;
                        MiddleClassInformation.block_2_int+=1;
                        Blocks_Manager.level_score+=10;
                    }
                    if (Delete_Bomb_block.posI && (blocks_2.body.getUserData().equals(Grid.array_position[Delete_Bomb_block.positionI_1][Delete_Bomb_block.positionI_2]))) {
                        Blocks_2_array.deleteBlock(blocks_2);
                        Grid.grid[Delete_Bomb_block.positionI_1][Delete_Bomb_block.positionI_2] = 0;
                        System.out.println("I2_bomb");

                        MiddleClassInformation.coins_count+=2;
                        MiddleClassInformation.coins_collected+=2;
                        MiddleClassInformation.global_score+=10;
                        MiddleClassInformation.block_2_int+=1;
                        Blocks_Manager.level_score+=10;
                    }
                }
            }
        }
    }
}
