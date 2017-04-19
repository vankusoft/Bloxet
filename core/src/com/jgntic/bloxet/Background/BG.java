package com.jgntic.bloxet.Background;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.jgntic.bloxet.Bloxet;

/**
 * Created by IVAN on 6.5.2016 г..
 */
public abstract class BG extends Sprite {

    public Body body;
    public World world;

    float x,y;
    Texture texture;
    TextureRegion dynamic_block1;

    public BG(World world, float x, float y,Bloxet game)
    {
        this.world=world;
        this.x=x;
        this.y=y;

        defineBlocks();

        setTextureBounds();

    }
    public abstract void setTextureBounds();

    public void update()
    {
        setColor(1,1,1,0.2f);

        setLinearVelocity();

        setRegion(texture);
        setPosition(body.getPosition().x-getWidth()/2,body.getPosition().y-getHeight()/2);

    }
    public abstract void setLinearVelocity();


    public void defineBlocks()
    {
        BodyDef bodyDef=new BodyDef();
        bodyDef.type= BodyDef.BodyType.KinematicBody;
        bodyDef.position.set(x,y);

        body=world.createBody(bodyDef);

    }

    public void draw(SpriteBatch batch)
    {
       super.draw(batch);
    }

    public abstract void dispose();


}
