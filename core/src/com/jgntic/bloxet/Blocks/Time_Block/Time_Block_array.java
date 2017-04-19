package com.jgntic.bloxet.Blocks.Time_Block;

import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.jgntic.bloxet.Blocks.Bomb_block;
import com.jgntic.bloxet.Bloxet;

/**
 * Created by IVAN on 11.5.2016 г..
 */
public class Time_Block_array {

    static Array<Time_Block> time_block;
    static Array<Time_Block> time_block_toRemove;
    static Array<Time_Block> delete_specific_body;

    World world;
    Bloxet game;

    public Time_Block_array(World world,Bloxet game)
    {
        this.game=game;
        this.world=world;

        time_block=new Array<Time_Block>();
        time_block_toRemove=new Array<Time_Block>();
        delete_specific_body=new Array<Time_Block>();
    }

    public void addBlock(float x,float y,boolean infinity)
    {
        time_block.add(new Time_Block(world, x, y,game,infinity));
    }

    public static void deleteBlock(Time_Block value)
    {
        delete_specific_body.removeValue(value,true);
        time_block_toRemove.add(value);
        time_block.removeValue(value,true);
    }

    public Array<Time_Block> getTime_block()
    {
        return time_block;
    }

    public Array<Time_Block> getTime_block_toRemove()
    {
        return time_block_toRemove;
    }

    public static Array<Time_Block> getDelete_specific_body() {
        return delete_specific_body;
    }
}
