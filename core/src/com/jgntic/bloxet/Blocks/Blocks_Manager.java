package com.jgntic.bloxet.Blocks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.TimeUtils;
import com.jgntic.bloxet.Blocks.Blocks_6.Blocks_6;
import com.jgntic.bloxet.Blocks.Blocks_6.Blocks_6_array;
import com.jgntic.bloxet.Blocks.Blocks_6.Delete_group_of_Blocks_6;
import com.jgntic.bloxet.Blocks.Time_Block.Delete_Time_Block;
import com.jgntic.bloxet.Blocks.Time_Block.Time_Block;
import com.jgntic.bloxet.Blocks.Time_Block.Time_Block_array;
import com.jgntic.bloxet.Bloxet;
import com.jgntic.bloxet.Managers.Grid;
import com.jgntic.bloxet.Managers.MiddleClassInformation;
import com.jgntic.bloxet.Managers.Play_Elements;
import com.jgntic.bloxet.Managers.RandomBodyCreated;
import com.jgntic.bloxet.Managers.RandomGenerator;

/**
 * Created by IVAN on 8.5.2016 г..
 */
public class Blocks_Manager {

    Blocks_1_array blocks1;
    Blocks_2_array blocks2;
    Blocks_3_array blocks3;
    Blocks_6_array blocks6;
    Bomb_block_array bomb_block_array;
    Time_Block_array time_block_array;

    Delete_group_of_Blocks_1 delete_group_of_blocks_1;
    Delete_group_of_Blocks_2 delete_group_of_blocks_2;
    Delete_group_of_Blocks_3 delete_group_of_blocks_3;
    Delete_group_of_Blocks_6 delete_group_of_blocks_6;
    Delete_Bomb_block delete_bomb_block;
    Delete_Time_Block delete_time_block;

    RandomGenerator randomGenerator;

    World world;

    public static boolean doNotGenerate_B1,doNotGenerateB2,doNotGenerateB3,doNotGenerateB6;
    boolean bool1,bool2,bool3,bool6;
    int target_1,target_2,target_3,target_6;
    int B1_random_value,B2_random_value,B3_random_value,B6_random_value;

    int next_block;
    int previous;
    int block_turn;

    public static int random_x;
    int next_random_x;
    int previous_random_x;

    public int bomb_count;
    public int time_count;
    public boolean can_generate=true;
    boolean generate_next_power_up;

    float stateTimer=0;
    float generateTimer=0;

    public static int level_score;

    Bloxet game;

    boolean infinity=false;

    public Blocks_Manager(World world,Bloxet game)
    {
        this.game=game;
        this.world=world;

        blocks1=new Blocks_1_array(world,game);
        blocks2=new Blocks_2_array(world,game);
        blocks3=new Blocks_3_array(world,game);
        blocks6=new Blocks_6_array(world,game);
        bomb_block_array=new Bomb_block_array(world,game);
        time_block_array=new Time_Block_array(world,game);

        delete_group_of_blocks_1=new Delete_group_of_Blocks_1(game);
        delete_group_of_blocks_2=new Delete_group_of_Blocks_2(game);
        delete_group_of_blocks_3=new Delete_group_of_Blocks_3(game);
        delete_group_of_blocks_6=new Delete_group_of_Blocks_6(game);
        delete_bomb_block=new Delete_Bomb_block(game);
        delete_time_block=new Delete_Time_Block(game);

        randomGenerator=new RandomGenerator();

        doNotGenerate_B1=doNotGenerateB2=doNotGenerateB3=doNotGenerateB6=false;
        bool1=bool2=bool3=bool6=false;
        target_1=target_2=target_3=target_6=0;

        B1_random_value=0;
        B2_random_value=1;
        B3_random_value=2;
        B6_random_value=3;

        bomb_count=0;
        time_count=0;

        level_score=0;

        generate_next_power_up=false;
    }

    private void search_in_grid()
    {
        if(!MiddleClassInformation.infinity_mode)
        {
            for (int r = 0; r < 10; r++)
            {
                for (int c = 0 ; c < 11; c++)
                {
                    if(Grid.grid[r][c]==1)
                    {
                        target_1++;
                    }
                    if(Grid.grid[r][c]==2)
                    {
                        target_2++;
                    }
                    if(Grid.grid[r][c]==3)
                    {
                        target_3++;
                    }
                    if(Grid.grid[r][c]==6)
                    {
                        target_6++;
                    }
                }
            }

            if(target_1==0 && !bool1)
            {
                doNotGenerate_B1=true;
                if(randomGenerator.blocks_to_generate>1)
                {
                    randomGenerator.blocks_to_generate-=1;
                }
                bool1=true;
            }
            if(target_2==0 && !bool2)
            {
                doNotGenerateB2=true;
                if(randomGenerator.blocks_to_generate>1)
                {
                    randomGenerator.blocks_to_generate-=1;
                }
                bool2=true;
            }
            if(target_3==0 && !bool3)
            {
                doNotGenerateB3=true;
                if(randomGenerator.blocks_to_generate>1)
                {
                    randomGenerator.blocks_to_generate-=1;
                }
                bool3=true;
            }
            if(target_6==0 && !bool6)
            {
                doNotGenerateB6=true;
                if(randomGenerator.blocks_to_generate>1)
                {
                    randomGenerator.blocks_to_generate-=1;
                }
                bool6=true;
            }
            if(doNotGenerate_B1)
            {
                B2_random_value=0;
                B3_random_value=1;
                B6_random_value=2;
            }
            if(doNotGenerateB2)
            {
                if(doNotGenerate_B1)
                {
                    B3_random_value=0;
                    B6_random_value=1;
                }
                else
                {
                    B3_random_value=1;
                    B6_random_value=2;
                }
            }
            if(doNotGenerateB3)
            {
                if(doNotGenerate_B1 && doNotGenerateB2)
                {
                    B6_random_value=0;
                }
                else if(doNotGenerate_B1)
                {
                    B6_random_value=1;
                }
                else if(doNotGenerateB2)
                {
                    B6_random_value=1;
                }
                else
                {
                    B6_random_value=2;
                }
            }

            target_1=target_2=target_3=target_6=0;
        }
    }

    private void generate_blocks(){

        stateTimer+=Gdx.graphics.getDeltaTime();

        if(stateTimer>15)
        {
            generate_next_power_up=true;

        }
        //power_ups position random generator
        next_random_x=randomGenerator.getX_random();
        if(previous_random_x!=next_random_x)
        {
            random_x=next_random_x;
        }
        //blocks random generator
        next_block=randomGenerator.getBlock_turn();
        if((previous!=next_block) || randomGenerator.blocks_to_generate==1)
        {
            block_turn=next_block;
        }
        //GENERATE BLOCKS
            if((Blocks_1.generate_block || Blocks_2.generate_block || Blocks_3.generate_block || Blocks_6.generate_block
                    || Bomb_block.generate_block || Time_Block.generate_block )){

                if(can_generate)
                {
                    previous_random_x=random_x;

                    if(generate_next_power_up &&((MiddleClassInformation.bomb_count>=1) && (bomb_count<5) &&  (randomGenerator.getBomb_turn() == 5)))
                    {

                        bomb_block_array.addBlock(Grid.array_position[0][random_x].x / Bloxet.PPM, Grid.array_position[18][0].y / Bloxet.PPM,infinity);

                        if(!MiddleClassInformation.infinity_mode)
                        {
                            bomb_count+=1;
                        }

                        generate_next_power_up=false;
                        stateTimer=0;
                        generateTimer=0;

                    }
                    else if (!MiddleClassInformation.infinity_mode && generate_next_power_up && ((MiddleClassInformation.time_count>=1) &&(time_count<3) && (randomGenerator.getTime_turn()==6)))
                    {

                        time_block_array.addBlock(Grid.array_position[0][random_x].x / Bloxet.PPM, Grid.array_position[18][0].y / Bloxet.PPM,infinity);


                        time_count+=1;


                        generate_next_power_up=false;
                        stateTimer=0;
                        generateTimer=0;
                    }
                    else
                    {
                        previous=block_turn;

                        if (!doNotGenerate_B1 && (block_turn == B1_random_value ))
                        {
                            blocks1.addBlock(Grid.array_position[0][5].x / Bloxet.PPM, Grid.array_position[18][0].y / Bloxet.PPM,infinity);
                            generateTimer=0;
                        }
                        else if (!doNotGenerateB2  && (block_turn == B2_random_value ))
                        {
                            blocks2.addBlock(Grid.array_position[0][5].x / Bloxet.PPM, Grid.array_position[18][0].y / Bloxet.PPM,infinity);
                            generateTimer=0;
                        }
                        else if (!doNotGenerateB3 && (block_turn == B3_random_value))
                        {
                            blocks3.addBlock(Grid.array_position[0][5].x / Bloxet.PPM, Grid.array_position[18][0].y / Bloxet.PPM,infinity);
                            generateTimer=0;
                        }
                        else if (!doNotGenerateB6 && (block_turn == B6_random_value))
                        {
                            blocks6.addBlock(Grid.array_position[0][5].x / Bloxet.PPM, Grid.array_position[18][0].y / Bloxet.PPM,infinity);
                            generateTimer=0;
                        }
                    }
                }

                if(Blocks_1.generate_block)
                {
                    Blocks_1.generate_block=false;
                }
                if(Blocks_2.generate_block)
                {
                    Blocks_2.generate_block=false;
                }
                if(Blocks_3.generate_block)
                {
                    Blocks_3.generate_block=false;
                }
                if(Blocks_6.generate_block)
                {
                    Blocks_6.generate_block=false;
                }
                if(Bomb_block.generate_block)
                {
                    Bomb_block.generate_block=false;
                }
                if(Time_Block.generate_block)
                {
                    Time_Block.generate_block=false;
                }
            }


    }

    private void update_and_delete_blocks_1(){
        //BLOCKS 1 ARRAYS UPDATE AND DELETE
        for (Blocks_1 blocks1 : this.blocks1.getBlocks_1_toRemove())
        {
            if(!blocks1.world.isLocked())
            {
                blocks1.world.destroyBody(blocks1.body);
            }
        }

        blocks1.getBlocks_1_toRemove().clear();

        for(Blocks_1 blocks1 : this.blocks1.getBlocks_1())
        {
            blocks1.update();

            if (generateTimer>15)
            {
                if(!blocks1.landed)
                {
                    Blocks_1.generate_block=true;
                }
            }
        }
        //**********************************
    }

    private void update_and_delete_blocks_2(){
        //BLOCKS 2 ARRAYS UPDATE AND DELETE

        for (Blocks_2 blocks2 : this.blocks2.getBlocks_2_toRemove())
        {
            blocks2.world.destroyBody(blocks2.body);
        }

        blocks2.getBlocks_2_toRemove().clear();

        for(Blocks_2 blocks_2:blocks2.getBlocks_2()){
            blocks_2.update();

            if (generateTimer>15)
            {
                if(!blocks_2.landed)
                {
                    Blocks_2.generate_block=true;
                }
            }
        }
        //**********************************
    }

    private void update_and_delete_blocks_3(){
        //BLOCKS 1 ARRAYS UPDATE AND DELETE
        for (Blocks_3 blocks3 : this.blocks3.getBlocks_3_toRemove())
        {
            blocks3.world.destroyBody(blocks3.body);
        }

        blocks3.getBlocks_3_toRemove().clear();

        for(Blocks_3 blocks3 : this.blocks3.getBlocks_3())
        {
            blocks3.update();

            if (generateTimer>15)
            {
                if(!blocks3.landed)
                {
                    Blocks_3.generate_block=true;
                }
            }
        }
        //**********************************
    }

    private void update_and_delete_blocks_6(){
        //BLOCKS 1 ARRAYS UPDATE AND DELETE
        for (Blocks_6 blocks6 : this.blocks6.getBlocks_6_toRemove())
        {
            blocks6.world.destroyBody(blocks6.body);
        }

        blocks6.getBlocks_6_toRemove().clear();

        for(Blocks_6 blocks6 : this.blocks6.getBlocks_6())
        {
            blocks6.update();

            if (generateTimer>15)
            {
                if(!blocks6.landed)
                {
                    Blocks_6.generate_block=true;
                }
            }
        }
        //**********************************
    }

    private void update_and_delete_bomb_blocks(){

        for (Bomb_block bomb_block : bomb_block_array.getBomb_block_toRemove())
        {
            bomb_block.world.destroyBody(bomb_block.body);
        }

        bomb_block_array.getBomb_block_toRemove().clear();

        for(Bomb_block bomb_block: bomb_block_array.getBomb_block())
        {
            bomb_block.update();

            if (generateTimer>15)
            {
                if(!bomb_block.landed)
                {
                    Bomb_block.generate_block=true;
                }
            }
        }
        //**********************************
    }

    private void update_and_delete_time_block(){
        for (Time_Block time_block: time_block_array.getTime_block_toRemove())
        {
            time_block.world.destroyBody(time_block.body);
        }

        time_block_array.getTime_block_toRemove().clear();

        for(Time_Block time_block: time_block_array.getTime_block())
        {
            time_block.update();

            if (generateTimer>15)
            {
                if(!time_block.landed)
                {
                    Time_Block.generate_block=true;
                }
            }
        }
    }


    public void update(float dt){

        randomGenerator.RandomXGenerator_update();

        generateTimer+=Gdx.graphics.getDeltaTime();

        search_in_grid();
        generate_blocks();

        delete_group_of_blocks_1.DeleteGroupBlocks_1();
        delete_group_of_blocks_2.DeleteGroupBlocks_2();
        delete_group_of_blocks_3.DeleteGroupBlocks_3();
        delete_group_of_blocks_6.DeleteGroupBlocks_6();

        delete_bomb_block.Bomb_block_explode();
        delete_time_block.Delete_Time_Blocks();

        update_and_delete_blocks_1();
        update_and_delete_blocks_2();
        update_and_delete_blocks_3();
        update_and_delete_blocks_6();
        update_and_delete_bomb_blocks();
        update_and_delete_time_block();

    }

    public void render(Bloxet game,float dt){

        for(Blocks_1 blocks1 : this.blocks1.getBlocks_1())
        {
            if(blocks1!=null)
            {
                blocks1.draw(game.batch);
            }
        }
        for(Blocks_2 blocks_2:blocks2.getBlocks_2())
        {
            if(blocks2!=null)
            {
                blocks_2.draw(game.batch);
            }

        }
        for(Blocks_3 blocks_3:blocks3.getBlocks_3())
        {
            if(blocks_3!=null)
            {
                blocks_3.draw(game.batch);
            }

        }
        for(Blocks_6 blocks_6:blocks6.getBlocks_6())
        {
            if(blocks_6!=null)
            {
                blocks_6.draw(game.batch);
            }

        }
        for(Bomb_block bomb_block:bomb_block_array.getBomb_block())
        {
            if(bomb_block!=null)
            {
                bomb_block.draw(game.batch);
            }

        }
        for(Time_Block time_block:time_block_array.getTime_block())
        {
            if(time_block!=null)
            {
                time_block.draw(game.batch);
            }

        }

        delete_group_of_blocks_1.update();
        delete_group_of_blocks_2.update();
        delete_group_of_blocks_3.update();
        delete_group_of_blocks_6.update();

        delete_time_block.update(game.batch);
        delete_bomb_block.update(game.batch);
    }

    public void dispose(){

        for(Blocks_1 blocks1 : this.blocks1.getBlocks_1())
        {
            blocks1.dispose();
        }
        for(Blocks_2 blocks_2:blocks2.getBlocks_2())
        {
            blocks_2.dispose();
        }
        for(Blocks_3 blocks_3:blocks3.getBlocks_3())
        {
            blocks_3.dispose();
        }
        for(Blocks_6 blocks_6:blocks6.getBlocks_6())
        {
            blocks_6.dispose();
        }
        for(Bomb_block bomb_block:bomb_block_array.getBomb_block())
        {
            bomb_block.dispose();
        }
        for(Time_Block time_block:time_block_array.getTime_block())
        {
            time_block.dispose();
        }

        delete_bomb_block.dispose();
        delete_time_block.dispose();

        delete_group_of_blocks_1.dispose();
        delete_group_of_blocks_2.dispose();
        delete_group_of_blocks_3.dispose();
        delete_group_of_blocks_6.dispose();
    }

}
