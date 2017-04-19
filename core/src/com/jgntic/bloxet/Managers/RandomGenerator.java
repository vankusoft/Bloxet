package com.jgntic.bloxet.Managers;

import java.util.Random;

/**
 * Created by IVAN on 25.4.2016 г..
 */
public class RandomGenerator {

    Random random;

    int block_turn;

    int time_turn;
    int bomb_turn;

    int x_random;

    int max=10;
    int min=1;

    public int blocks_to_generate=4;

    public RandomGenerator()
    {
        random=new Random();
    }

    public void RandomXGenerator_update()
    {
        x_random =random.nextInt(max - min) + min;

        block_turn=random.nextInt(blocks_to_generate);
        bomb_turn=random.nextInt(6);
        time_turn=random.nextInt(25);

    }

    public int getBlock_turn() {
        return block_turn;
    }

    public int getX_random() {
        return x_random;
    }

    public int getBomb_turn() {
        return bomb_turn;
    }

    public int getTime_turn() {
        return time_turn;
    }
}
