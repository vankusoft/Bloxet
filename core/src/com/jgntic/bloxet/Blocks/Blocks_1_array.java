package com.jgntic.bloxet.Blocks;

import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.jgntic.bloxet.Bloxet;

/**
 * Created by IVAN on 7.4.2016 г..
 */
public class Blocks_1_array {

    static Array<Blocks_1> blocks_1;
    static Array<Blocks_1> blocks_1_toRemove;
    static Array<Blocks_1> delete_specific_body;

    World world;
    Bloxet game;

    public Blocks_1_array(World world,Bloxet game)
    {
        this.game=game;
        this.world=world;

        blocks_1=new Array<Blocks_1>();
        blocks_1_toRemove=new Array<Blocks_1>();
        delete_specific_body=new Array<Blocks_1>();

    }

    public void addBlock(float x,float y,boolean infinity)
    {
        blocks_1.add(new Blocks_1(world, x, y,game,infinity));

    }

    public static void deleteBlock(Blocks_1 value)
    {

        delete_specific_body.removeValue(value,true);
        blocks_1_toRemove.add(value);
        blocks_1.removeValue(value,true);

    }

    public Array<Blocks_1> getBlocks_1()
    {
        return blocks_1;
    }

    public Array<Blocks_1> getBlocks_1_toRemove()
    {
        return blocks_1_toRemove;
    }

    public static Array<Blocks_1> getDelete_specific_body() {
        return delete_specific_body;
    }
}
