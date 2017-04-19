package com.jgntic.bloxet.Background;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.jgntic.bloxet.Bloxet;

/**
 * Created by IVAN on 6.5.2016 г..
 */
public class BG_Block1 extends BG {

    public BG_Block1(World world, float x, float y,Bloxet game) {
        super(world, x, y,game);

        texture=game.assetManager.get("dbg_block1.png");
        dynamic_block1=new TextureRegion(texture,0,0,563,563);


    }

    @Override
    public void defineBlocks() {
        super.defineBlocks();
    }

    @Override
    public void setTextureBounds() {
        setBounds(0,0,80/ Bloxet.PPM,80/ Bloxet.PPM);
    }

    @Override
    public void update() {
        super.update();

    }

    @Override
    public void setLinearVelocity() {

    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
    }

    @Override
    public void dispose() {
        texture.dispose();
    }
}
