package com.jgntic.bloxet.Blocks.Delete_blocks_by_bomb;

import com.jgntic.bloxet.Blocks.Blocks_1;
import com.jgntic.bloxet.Blocks.Blocks_1_array;
import com.jgntic.bloxet.Blocks.Blocks_Manager;
import com.jgntic.bloxet.Blocks.Bomb_block;
import com.jgntic.bloxet.Blocks.Delete_Bomb_block;
import com.jgntic.bloxet.Blocks.Time_Block.Time_Block;
import com.jgntic.bloxet.Blocks.Time_Block.Time_Block_array;
import com.jgntic.bloxet.Managers.Grid;
import com.jgntic.bloxet.Managers.MiddleClassInformation;

/**
 * Created by IVAN on 11.5.2016 г..
 */
public class Bomb_time {

    public void Time_bombed(){
        for(Time_Block time_block: Time_Block_array.getDelete_specific_body()) {

            if (time_block != null && time_block.body.getUserData() != null) {
                if (Bomb_block.deleteBlock) {


                    if (time_block.body.getUserData().equals(Grid.array_position[Delete_Bomb_block.positionB_1][Delete_Bomb_block.positionB_2])) {
                        Time_Block_array.deleteBlock(time_block);
                        Grid.grid[Delete_Bomb_block.positionB_1][Delete_Bomb_block.positionB_2] = 0;

                        MiddleClassInformation.coins_count+=4;
                        MiddleClassInformation.coins_collected+=4;
                        MiddleClassInformation.global_score+=40;
                        MiddleClassInformation.clock_int+=1;
                        Blocks_Manager.level_score+=40;

                        System.out.println("TB1");
                    }
                    if (Delete_Bomb_block.posC && (time_block.body.getUserData().equals(Grid.array_position[Delete_Bomb_block.positionC_1][Delete_Bomb_block.positionC_2]))) {
                        Time_Block_array.deleteBlock(time_block);
                        Grid.grid[Delete_Bomb_block.positionC_1][Delete_Bomb_block.positionC_2] = 0;
                        System.out.println("TC1");

                        MiddleClassInformation.coins_count+=4;
                        MiddleClassInformation.coins_collected+=4;
                        MiddleClassInformation.global_score+=40;
                        MiddleClassInformation.clock_int+=1;
                        Blocks_Manager.level_score+=40;
                    }
                    if (Delete_Bomb_block.posD && (time_block.body.getUserData().equals(Grid.array_position[Delete_Bomb_block.positionD_1][Delete_Bomb_block.positionD_2]))) {
                        Time_Block_array.deleteBlock(time_block);
                        Grid.grid[Delete_Bomb_block.positionD_1][Delete_Bomb_block.positionD_2] = 0;
                        System.out.println("TD1");

                        MiddleClassInformation.coins_count+=4;
                        MiddleClassInformation.coins_collected+=4;
                        MiddleClassInformation.global_score+=40;
                        MiddleClassInformation.clock_int+=1;
                        Blocks_Manager.level_score+=40;
                    }
                    if (Delete_Bomb_block.posE && (time_block.body.getUserData().equals(Grid.array_position[Delete_Bomb_block.positionE_1][Delete_Bomb_block.positionE_2]))) {
                        Time_Block_array.deleteBlock(time_block);
                        Grid.grid[Delete_Bomb_block.positionE_1][Delete_Bomb_block.positionE_2] = 0;
                        System.out.println("TE1");

                        MiddleClassInformation.coins_count+=4;
                        MiddleClassInformation.coins_collected+=4;
                        MiddleClassInformation.global_score+=40;
                        MiddleClassInformation.clock_int+=1;
                        Blocks_Manager.level_score+=40;
                    }
                    if (Delete_Bomb_block.posF && (time_block.body.getUserData().equals(Grid.array_position[Delete_Bomb_block.positionF_1][Delete_Bomb_block.position_F2]))) {
                        Time_Block_array.deleteBlock(time_block);
                        Grid.grid[Delete_Bomb_block.positionF_1][Delete_Bomb_block.position_F2] = 0;
                        System.out.println("TF1");

                        MiddleClassInformation.coins_count+=4;
                        MiddleClassInformation.coins_collected+=4;
                        MiddleClassInformation.global_score+=40;
                        MiddleClassInformation.clock_int+=1;
                        Blocks_Manager.level_score+=40;
                    }
                    if (Delete_Bomb_block.posG && (time_block.body.getUserData().equals(Grid.array_position[Delete_Bomb_block.positionG_1][Delete_Bomb_block.positionG_2]))) {
                        Time_Block_array.deleteBlock(time_block);
                        Grid.grid[Delete_Bomb_block.positionG_1][Delete_Bomb_block.positionG_2] = 0;
                        System.out.println("TG1");

                        MiddleClassInformation.coins_count+=4;
                        MiddleClassInformation.coins_collected+=4;
                        MiddleClassInformation.global_score+=40;
                        MiddleClassInformation.clock_int+=1;
                        Blocks_Manager.level_score+=40;
                    }
                    if (Delete_Bomb_block.posH && (time_block.body.getUserData().equals(Grid.array_position[Delete_Bomb_block.positionH_1][Delete_Bomb_block.positionH_2]))) {
                        Time_Block_array.deleteBlock(time_block);
                        Grid.grid[Delete_Bomb_block.positionH_1][Delete_Bomb_block.positionH_2] = 0;
                        System.out.println("TH1");

                        MiddleClassInformation.coins_count+=4;
                        MiddleClassInformation.coins_collected+=4;
                        MiddleClassInformation.global_score+=40;
                        MiddleClassInformation.clock_int+=1;
                        Blocks_Manager.level_score+=40;
                    }
                    if (Delete_Bomb_block.posI && (time_block.body.getUserData().equals(Grid.array_position[Delete_Bomb_block.positionI_1][Delete_Bomb_block.positionI_2]))) {
                        Time_Block_array.deleteBlock(time_block);
                        Grid.grid[Delete_Bomb_block.positionI_1][Delete_Bomb_block.positionI_2] = 0;
                        System.out.println("TI1");

                        MiddleClassInformation.coins_count+=4;
                        MiddleClassInformation.coins_collected+=4;
                        MiddleClassInformation.global_score+=40;
                        MiddleClassInformation.clock_int+=1;
                        Blocks_Manager.level_score+=40;
                    }
                }
            }
        }
    }
}
