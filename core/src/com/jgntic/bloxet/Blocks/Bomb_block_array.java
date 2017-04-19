package com.jgntic.bloxet.Blocks;

import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.jgntic.bloxet.Bloxet;

/**
 * Created by IVAN on 8.5.2016 г..
 */
public class Bomb_block_array  {

    static Array<Bomb_block> bomb_block;
    static Array<Bomb_block> bomb_block_toRemove;
    static Array<Bomb_block> delete_specific_body;

    World world;
    Bloxet game;

    public Bomb_block_array(World world,Bloxet game)
    {
        this.game=game;
        this.world=world;

        bomb_block=new Array<Bomb_block>();
        bomb_block_toRemove=new Array<Bomb_block>();
        delete_specific_body=new Array<Bomb_block>();

    }

    public void addBlock(float x,float y,boolean infinity)
    {
        bomb_block.add(new Bomb_block(world, x, y,game,infinity));

    }

    public static void deleteBlock(Bomb_block value)
    {

        delete_specific_body.removeValue(value,true);
        bomb_block_toRemove.add(value);
        bomb_block.removeValue(value,true);

    }

    public Array<Bomb_block> getBomb_block()
    {
        return bomb_block;
    }

    public Array<Bomb_block> getBomb_block_toRemove()
    {
        return bomb_block_toRemove;
    }

    public static Array<Bomb_block> getDelete_specific_body() {
        return delete_specific_body;
    }
}
