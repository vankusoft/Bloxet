package com.jgntic.bloxet.Blocks;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Filter;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.TimeUtils;
import com.jgntic.bloxet.Bloxet;

/**
 * Created by IVAN on 7.4.2016 г..
 */
public abstract class Blocks extends Sprite {

    public Body body;
    public World world;

    float x,y;
    public TextureRegion blocksRegion;
    public Texture texture;

    public long startTime=0;
    public long convert_in_nanoseconds=1000000000;

    public Blocks(World world,float x,float y,Bloxet game,boolean infinity)
    {
        this.world=world;
        this.x=x;
        this.y=y;

        startTime= TimeUtils.nanoTime();

        defineBlocks();
        setBounds(0,0,39/ Bloxet.PPM,39/ Bloxet.PPM);
    }
    public void update()
    {
        setPosition(body.getPosition().x-getWidth()/2,body.getPosition().y-getHeight()/2);
    }

    private void defineBlocks()
    {
        BodyDef bodyDef=new BodyDef();
        bodyDef.type= BodyDef.BodyType.StaticBody;
        bodyDef.position.set(x,y);

        body=world.createBody(bodyDef);

        body.setGravityScale(2);

        PolygonShape polygonShape=new PolygonShape();
        polygonShape.setAsBox(20.85f/ Bloxet.PPM,20.85f/ Bloxet.PPM);

        FixtureDef fixtureDef=new FixtureDef();
        fixtureDef.shape=polygonShape;

        body.createFixture(fixtureDef);
    }

    public void draw(SpriteBatch batch)
    {
        super.draw(batch);
    }

    public abstract void dispose();
}
