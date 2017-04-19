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
 * Created by IVAN on 8.5.2016 г..
 */
public class BG_Block8 extends BG {

    public BG_Block8(World world, float x, float y,Bloxet game) {
        super(world, x, y,game);

        texture=game.assetManager.get("dbg_block2.png");
        dynamic_block1=new TextureRegion(texture,0,0,563,563);
    }

    @Override
    public void setTextureBounds() {
        setBounds(0,0,90/ Bloxet.PPM,90/ Bloxet.PPM);
    }

    @Override
    public void update() {
        super.update();

        if(body.getPosition().x< -80/ Bloxet.PPM){
            body.setTransform(800/ Bloxet.PPM,400/ Bloxet.PPM,0);
        }
    }

    @Override
    public void setLinearVelocity() {
        body.setLinearVelocity(-0.35f,0);
    }

    @Override
    public void defineBlocks() {
        super.defineBlocks();

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
