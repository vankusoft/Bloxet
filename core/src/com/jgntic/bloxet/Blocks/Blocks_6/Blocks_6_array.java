package com.jgntic.bloxet.Blocks.Blocks_6;

import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.jgntic.bloxet.Blocks.Blocks_1;
import com.jgntic.bloxet.Bloxet;

/**
 * Created by IVAN on 18.5.2016 г..
 */
public class Blocks_6_array {

    static Array<Blocks_6> blocks_6;
    static Array<Blocks_6> blocks_6_toRemove;
    static Array<Blocks_6> delete_specific_body;

    World world;
    Bloxet game;

    public Blocks_6_array(World world,Bloxet game)
    {
        this.game=game;
        this.world=world;

        blocks_6=new Array<Blocks_6>();
        blocks_6_toRemove=new Array<Blocks_6>();
        delete_specific_body=new Array<Blocks_6>();

    }

    public void addBlock(float x,float y,boolean infinity)
    {
        blocks_6.add(new Blocks_6(world, x, y,game,infinity));

    }

    public static void deleteBlock(Blocks_6 value)
    {

        delete_specific_body.removeValue(value,true);
        blocks_6_toRemove.add(value);
        blocks_6.removeValue(value,true);

    }

    public Array<Blocks_6> getBlocks_6()
    {
        return blocks_6;
    }

    public Array<Blocks_6> getBlocks_6_toRemove()
    {
        return blocks_6_toRemove;
    }

    public static Array<Blocks_6> getDelete_specific_body() {
        return delete_specific_body;
    }
}
