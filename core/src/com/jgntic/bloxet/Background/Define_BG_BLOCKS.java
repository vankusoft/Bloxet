package com.jgntic.bloxet.Background;

import com.badlogic.gdx.physics.box2d.World;
import com.jgntic.bloxet.Bloxet;

/**
 * Created by IVAN on 6.5.2016 г..
 */
public class Define_BG_BLOCKS {

    BG_Block1 bg_block1;
    BG_Block2 bg_block2;
    BG_Block3 bg_block3;
    BG_Block4 bg_block4;
    BG_Block5 bg_block5;
    BG_Block6 bg_block6;
    BG_Block7 bg_block7;
    BG_Block8 bg_block8;
    BG_Block9 bg_block9;
    BG_Block10 bg_block10;
    BG_Block11 bg_block11;
    BG_Block12 bg_block12;
    BG_Block13 bg_block13;

    public Define_BG_BLOCKS(World world,Bloxet game){

        //light
        bg_block1 =new BG_Block1(world,300/ Bloxet.PPM,850/ Bloxet.PPM,game);

        bg_block2 =new BG_Block2(world,-70/ Bloxet.PPM,150/ Bloxet.PPM,game);
        bg_block3=new BG_Block3(world,-30/ Bloxet.PPM,670/ Bloxet.PPM,game);
        bg_block4=new BG_Block4(world,-60/ Bloxet.PPM,560/ Bloxet.PPM,game);
        bg_block5=new BG_Block5(world,-100/ Bloxet.PPM,165/ Bloxet.PPM,game);
        bg_block6=new BG_Block6(world,-20/ Bloxet.PPM,300/ Bloxet.PPM,game);
        bg_block7=new BG_Block7(world,250/ Bloxet.PPM,620/ Bloxet.PPM,game);
        bg_block8=new BG_Block8(world,400/ Bloxet.PPM,400/ Bloxet.PPM,game);
        bg_block9=new BG_Block9(world,315/ Bloxet.PPM,600/ Bloxet.PPM,game);
        bg_block10=new BG_Block10(world,480/Bloxet.PPM,740/Bloxet.PPM,game);
        bg_block11=new BG_Block11(world,55/Bloxet.PPM,165/Bloxet.PPM,game);
        bg_block12=new BG_Block12(world,390/Bloxet.PPM,500/Bloxet.PPM,game);
        bg_block13=new BG_Block13(world,20/Bloxet.PPM,400/Bloxet.PPM,game);
    }

    public void update(){
        bg_block1.update();
        bg_block2.update();
        bg_block3.update();
        bg_block4.update();
        bg_block5.update();
        bg_block6.update();
        bg_block7.update();
        bg_block8.update();
        bg_block9.update();
        bg_block10.update();
        bg_block11.update();
        bg_block12.update();
        bg_block13.update();
    }

    public void draw(Bloxet game){
        bg_block2.draw(game.batch);
        bg_block1.draw(game.batch);

        bg_block4.draw(game.batch);
        bg_block3.draw(game.batch);
        bg_block5.draw(game.batch);
        bg_block6.draw(game.batch);
        bg_block7.draw(game.batch);
        bg_block8.draw(game.batch);
        bg_block9.draw(game.batch);
        bg_block10.draw(game.batch);
        bg_block11.draw(game.batch);
        bg_block12.draw(game.batch);
        bg_block13.draw(game.batch);

    }

    public void dispose(){
        bg_block1.dispose();
        bg_block2.dispose();
        bg_block3.dispose();
        bg_block4.dispose();
        bg_block5.dispose();
        bg_block6.dispose();
        bg_block7.dispose();
        bg_block8.dispose();
        bg_block9.dispose();
        bg_block10.dispose();
        bg_block11.dispose();
        bg_block12.dispose();
        bg_block13.dispose();
    }

}
