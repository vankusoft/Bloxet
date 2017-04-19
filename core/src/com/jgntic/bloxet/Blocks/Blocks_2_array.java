package com.jgntic.bloxet.Blocks;

import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.jgntic.bloxet.Bloxet;

/**
 * Created by IVAN on 7.4.2016 г..
 */
public class Blocks_2_array {

    static Array<Blocks_2> blocks_2;
    static Array<Blocks_2> blocks_2_toRemove;
    static Array<Blocks_2> delete_specific_body;

    World world;
    Bloxet game;

    public Blocks_2_array(World world,Bloxet game){
        this.game=game;
        this.world=world;

        blocks_2=new Array<Blocks_2>();
        blocks_2_toRemove=new Array<Blocks_2>();
        delete_specific_body=new Array<Blocks_2>();
    }

    public void addBlock(float x,float y,boolean infinity)
    {
        blocks_2.add(new Blocks_2(world,x,y,game,infinity));
    }

    public static void deleteBlock(Blocks_2 value)
    {
        delete_specific_body.removeValue(value,true);
        blocks_2_toRemove.add(value);
        blocks_2.removeValue(value,true);

    }

    public Array<Blocks_2> getBlocks_2() {
        return blocks_2;
    }

    public Array<Blocks_2> getBlocks_2_toRemove() {
        return blocks_2_toRemove;
    }

    public static Array<Blocks_2> getDelete_specific_body() {
        return delete_specific_body;
    }
}
