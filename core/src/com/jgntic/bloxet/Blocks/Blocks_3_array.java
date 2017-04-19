package com.jgntic.bloxet.Blocks;

import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.jgntic.bloxet.Bloxet;

/**
 * Created by IVAN on 8.5.2016 г..
 */
public class Blocks_3_array {

    static Array<Blocks_3> blocks_3;
    static Array<Blocks_3> blocks_3_toRemove;
    static Array<Blocks_3> delete_specific_body;

    World world;
    Bloxet game;

    public Blocks_3_array(World world,Bloxet game)
    {
        this.game=game;
        this.world=world;

        blocks_3 =new Array<Blocks_3>();
        blocks_3_toRemove =new Array<Blocks_3>();
        delete_specific_body=new Array<Blocks_3>();

    }

    public void addBlock(float x,float y,boolean infinity)
    {
        blocks_3.add(new Blocks_3(world, x, y,game,infinity));

    }

    public static void deleteBlock(Blocks_3 value)
    {

        delete_specific_body.removeValue(value,true);
        blocks_3_toRemove.add(value);
        blocks_3.removeValue(value, true);

    }

    public Array<Blocks_3> getBlocks_3()
    {
        return blocks_3;
    }

    public Array<Blocks_3> getBlocks_3_toRemove()
    {
        return blocks_3_toRemove;
    }

    public static Array<Blocks_3> getDelete_specific_body() {
        return delete_specific_body;
    }
}
