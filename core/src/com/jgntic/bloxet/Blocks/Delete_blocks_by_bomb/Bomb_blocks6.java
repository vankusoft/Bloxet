package com.jgntic.bloxet.Blocks.Delete_blocks_by_bomb;



import com.jgntic.bloxet.Blocks.Blocks_6.Blocks_6;
import com.jgntic.bloxet.Blocks.Blocks_6.Blocks_6_array;
import com.jgntic.bloxet.Blocks.Blocks_Manager;
import com.jgntic.bloxet.Blocks.Bomb_block;
import com.jgntic.bloxet.Blocks.Delete_Bomb_block;
import com.jgntic.bloxet.Managers.Grid;
import com.jgntic.bloxet.Managers.MiddleClassInformation;

/**
 * Created by IVAN on 25.5.2016 г..
 */
public class Bomb_blocks6 {

    public void Blocks6_bombed(){
        for(Blocks_6 blocks_6: Blocks_6_array.getDelete_specific_body()) {

            if (blocks_6 != null && blocks_6.body.getUserData() != null) {
                if (Bomb_block.deleteBlock) {

                    if (blocks_6.body.getUserData().equals(Grid.array_position[Delete_Bomb_block.positionB_1][Delete_Bomb_block.positionB_2]))
                    {
                        if(!blocks_6.landed)
                        {
                            Blocks_6.generate_block=true;
                            System.out.println("Blocks_6_bomb_landed:"+blocks_6.landed);
                        }

                        Blocks_6_array.deleteBlock(blocks_6);
                        Grid.grid[Delete_Bomb_block.positionB_1][Delete_Bomb_block.positionB_2] = 0;
                        System.out.println("B6_bomb");

                        MiddleClassInformation.coins_count+=2;
                        MiddleClassInformation.coins_collected+=2;
                        MiddleClassInformation.global_score+=10;
                        MiddleClassInformation.block_6_int+=1;
                        Blocks_Manager.level_score+=10;

                    }
                    if (Delete_Bomb_block.posC && (blocks_6.body.getUserData().equals(Grid.array_position[Delete_Bomb_block.positionC_1][Delete_Bomb_block.positionC_2])))
                    {
                        Blocks_6_array.deleteBlock(blocks_6);
                        Grid.grid[Delete_Bomb_block.positionC_1][Delete_Bomb_block.positionC_2] = 0;
                        System.out.println("C6_bomb");

                        MiddleClassInformation.coins_count+=2;
                        MiddleClassInformation.coins_collected+=2;
                        MiddleClassInformation.global_score+=10;
                        MiddleClassInformation.block_6_int+=1;
                        Blocks_Manager.level_score+=10;
                    }
                    if (Delete_Bomb_block.posD && (blocks_6.body.getUserData().equals(Grid.array_position[Delete_Bomb_block.positionD_1][Delete_Bomb_block.positionD_2])))
                    {
                        Blocks_6_array.deleteBlock(blocks_6);
                        Grid.grid[Delete_Bomb_block.positionD_1][Delete_Bomb_block.positionD_2] = 0;
                        System.out.println("D6_bomb");

                        MiddleClassInformation.coins_count+=2;
                        MiddleClassInformation.coins_collected+=2;
                        MiddleClassInformation.global_score+=10;
                        MiddleClassInformation.block_6_int+=1;
                        Blocks_Manager.level_score+=10;
                    }
                    if (Delete_Bomb_block.posE && (blocks_6.body.getUserData().equals(Grid.array_position[Delete_Bomb_block.positionE_1][Delete_Bomb_block.positionE_2])))
                    {
                        Blocks_6_array.deleteBlock(blocks_6);
                        Grid.grid[Delete_Bomb_block.positionE_1][Delete_Bomb_block.positionE_2] = 0;
                        System.out.println("E6_bomb");

                        MiddleClassInformation.coins_count+=2;
                        MiddleClassInformation.coins_collected+=2;
                        MiddleClassInformation.global_score+=10;
                        MiddleClassInformation.block_6_int+=1;
                        Blocks_Manager.level_score+=10;
                    }
                    if (Delete_Bomb_block.posF && (blocks_6.body.getUserData().equals(Grid.array_position[Delete_Bomb_block.positionF_1][Delete_Bomb_block.position_F2])))
                    {
                        Blocks_6_array.deleteBlock(blocks_6);
                        Grid.grid[Delete_Bomb_block.positionF_1][Delete_Bomb_block.position_F2] = 0;
                        System.out.println("F6_bomb");

                        MiddleClassInformation.coins_count+=2;
                        MiddleClassInformation.coins_collected+=2;
                        MiddleClassInformation.global_score+=10;
                        MiddleClassInformation.block_6_int+=1;
                        Blocks_Manager.level_score+=10;
                    }
                    if (Delete_Bomb_block.posG && (blocks_6.body.getUserData().equals(Grid.array_position[Delete_Bomb_block.positionG_1][Delete_Bomb_block.positionG_2])))
                    {
                        Blocks_6_array.deleteBlock(blocks_6);
                        Grid.grid[Delete_Bomb_block.positionG_1][Delete_Bomb_block.positionG_2] = 0;
                        System.out.println("G6_bomb");

                        MiddleClassInformation.coins_count+=2;
                        MiddleClassInformation.coins_collected+=2;
                        MiddleClassInformation.global_score+=10;
                        MiddleClassInformation.block_6_int+=1;
                        Blocks_Manager.level_score+=10;
                    }
                    if (Delete_Bomb_block.posH && (blocks_6.body.getUserData().equals(Grid.array_position[Delete_Bomb_block.positionH_1][Delete_Bomb_block.positionH_2])))
                    {
                        Blocks_6_array.deleteBlock(blocks_6);
                        Grid.grid[Delete_Bomb_block.positionH_1][Delete_Bomb_block.positionH_2] = 0;
                        System.out.println("H6_bomb");

                        MiddleClassInformation.coins_count+=2;
                        MiddleClassInformation.coins_collected+=2;
                        MiddleClassInformation.global_score+=10;
                        MiddleClassInformation.block_6_int+=1;
                        Blocks_Manager.level_score+=10;
                    }
                    if (Delete_Bomb_block.posI && (blocks_6.body.getUserData().equals(Grid.array_position[Delete_Bomb_block.positionI_1][Delete_Bomb_block.positionI_2])))
                    {
                        Blocks_6_array.deleteBlock(blocks_6);
                        Grid.grid[Delete_Bomb_block.positionI_1][Delete_Bomb_block.positionI_2] = 0;
                        System.out.println("I6_bomb");

                        MiddleClassInformation.coins_count+=2;
                        MiddleClassInformation.coins_collected+=2;
                        MiddleClassInformation.global_score+=10;
                        MiddleClassInformation.block_6_int+=1;
                        Blocks_Manager.level_score+=10;
                    }
                }

            }
        }
    }
}
