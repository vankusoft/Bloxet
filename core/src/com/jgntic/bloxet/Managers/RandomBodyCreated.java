package com.jgntic.bloxet.Managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.jgntic.bloxet.Blocks.Blocks_1;
import com.jgntic.bloxet.Blocks.Blocks_1_array;
import com.jgntic.bloxet.Blocks.Blocks_2;
import com.jgntic.bloxet.Blocks.Blocks_2_array;
import com.jgntic.bloxet.Blocks.Blocks_3;
import com.jgntic.bloxet.Blocks.Blocks_3_array;
import com.jgntic.bloxet.Blocks.Blocks_6.Blocks_6;
import com.jgntic.bloxet.Blocks.Blocks_6.Blocks_6_array;
import com.jgntic.bloxet.Bloxet;
import com.jgntic.bloxet.Particle_Effects.ParticleEff_Block_generate;
import com.jgntic.bloxet.Particle_Effects.ParticleEff_array_Block_generate;

import java.util.Random;

/**
 * Created by IVAN on 29.4.2016 г..
 */
public class RandomBodyCreated {

    Blocks_1_array blocks1;
    Blocks_2_array blocks2;
    Blocks_3_array blocks3;
    Blocks_6_array blocks6;

    public int global_rows= MiddleClassInformation.rows;

    int rows = global_rows;
    int columns = 10;

    public static int y_position;
    public static int x_position;

    public static boolean ready;
    boolean array_ready;
    public boolean generate=true;

    Random rand;
    int block_turn;
    int previous;

    World world;

    float stateTimer;
    float readyTimer;

    Bloxet game;

    boolean infinity=false;

    int rows_high;
    int infinity_rows_higher;

    ParticleEff_array_Block_generate particleEff_array_block_generate;

    public RandomBodyCreated(World world,Bloxet game) {

        this.game=game;
        this.world=world;

        blocks1 = new Blocks_1_array(world,game);
        blocks2 = new Blocks_2_array(world,game);
        blocks3 = new Blocks_3_array(world,game);
        blocks6 = new Blocks_6_array(world,game);

        particleEff_array_block_generate=new ParticleEff_array_Block_generate();

        ready = false;
        array_ready=false;

        rand = new Random();

        stateTimer=0;
        readyTimer=0;

        if(MiddleClassInformation.infinity_mode)
        {
           rows=6;
        }
        else
        {
            rows=global_rows;
        }

    }

    void infinity_mode_search()
    {
        if(MiddleClassInformation.infinity_mode )
        {
            for(Blocks_1 blocks_1:blocks1.getBlocks_1())
            {
                if(blocks_1.landed)
                {
                    rows_high=blocks_1.y_down;

                    if(infinity_rows_higher<rows_high)
                    {
                        infinity_rows_higher=rows_high;

                        System.out.println(infinity_rows_higher);
                    }
                }
            }

            for(Blocks_2 blocks_2:blocks2.getBlocks_2())
            {
                if(blocks_2.landed)
                {
                    rows_high=blocks_2.y_down;

                    if(infinity_rows_higher<rows_high)
                    {
                        infinity_rows_higher=rows_high;

                        System.out.println(infinity_rows_higher);
                    }

                }
            }

            for(Blocks_3 blocks_3:blocks3.getBlocks_3())
            {
                if(blocks_3.landed)
                {
                    rows_high=blocks_3.y_down;

                    if(infinity_rows_higher<rows_high)
                    {
                        infinity_rows_higher=rows_high;

                        System.out.println(infinity_rows_higher);
                    }

                }
            }

            for(Blocks_6 blocks_6:blocks6.getBlocks_6())
            {
                if(blocks_6.landed)
                {
                    rows_high=blocks_6.y_down;

                    if(infinity_rows_higher<rows_high)
                    {
                        infinity_rows_higher=rows_high;

                        System.out.println(infinity_rows_higher);
                    }

                }
            }

        }
    }


    public void dispose_effects()
    {
        particleEff_array_block_generate.dispose();
    }

    public void createBodies(){

        infinity_mode_search();

        if(MiddleClassInformation.infinity_mode && ready)
        {
            if((infinity_rows_higher+2)<17)
            {
                rows=infinity_rows_higher+2;
            }
        }

        for (int r = 0; r <= rows; r++) {

            for (int c = 0; c <= columns; c++) {

                    x_position = c;
                    y_position = r;

                    previous=block_turn;
                    block_turn=rand.nextInt(4);

                    if(MiddleClassInformation.infinity_mode || (previous!=block_turn))
                    {
                        if (block_turn==0)
                        {
                            if(MiddleClassInformation.infinity_mode && ready)
                            {
                                infinity=true;
                            }

                            if(Grid.grid[r][c]==0)
                            {
                                if(MiddleClassInformation.infinity_mode)
                                {
                                    particleEff_array_block_generate.getParticleEff_block_generate()
                                            .add(new ParticleEff_Block_generate((Grid.array_position[0][c].x)/Bloxet.PPM,
                                                    (Grid.array_position[r][0].y)/Bloxet.PPM ,game));
                                }

                                blocks1.addBlock(Grid.array_position[0][c].x / Bloxet.PPM, Grid.array_position[r][0].y / Bloxet.PPM,infinity);
                                Grid.grid[r][c]=1;
                            }

                            infinity=false;
                        }
                        else if (block_turn==1 )
                        {
                            if(MiddleClassInformation.infinity_mode && ready)
                            {
                                infinity=true;
                            }

                            if(Grid.grid[r][c]==0)
                            {
                                if(MiddleClassInformation.infinity_mode)
                                {
                                    particleEff_array_block_generate.getParticleEff_block_generate()
                                            .add(new ParticleEff_Block_generate((Grid.array_position[0][c].x)/Bloxet.PPM,
                                                    (Grid.array_position[r][0].y)/Bloxet.PPM ,game));
                                }

                                blocks2.addBlock(Grid.array_position[0][c].x / Bloxet.PPM, Grid.array_position[r][0].y / Bloxet.PPM,infinity);
                                Grid.grid[r][c]=2;
                            }

                            infinity=false;
                        }
                        else if (block_turn==2)
                        {
                            if(MiddleClassInformation.infinity_mode && ready)
                            {
                                infinity=true;
                            }

                            if(Grid.grid[r][c]==0)
                            {
                                if(MiddleClassInformation.infinity_mode)
                                {
                                    particleEff_array_block_generate.getParticleEff_block_generate()
                                            .add(new ParticleEff_Block_generate((Grid.array_position[0][c].x)/Bloxet.PPM,
                                                    (Grid.array_position[r][0].y)/Bloxet.PPM ,game));
                                }

                                blocks3.addBlock(Grid.array_position[0][c].x / Bloxet.PPM, Grid.array_position[r][0].y / Bloxet.PPM,infinity);
                                Grid.grid[r][c]=3;
                            }

                            infinity=false;
                        }
                        else if (block_turn==3)
                        {
                            if(MiddleClassInformation.infinity_mode && ready)
                            {
                                infinity=true;
                            }

                            if(Grid.grid[r][c]==0)
                            {
                                if(MiddleClassInformation.infinity_mode)
                                {
                                    particleEff_array_block_generate.getParticleEff_block_generate()
                                            .add(new ParticleEff_Block_generate((Grid.array_position[0][c].x)/Bloxet.PPM,
                                                    (Grid.array_position[r][0].y)/Bloxet.PPM ,game));
                                }

                                blocks6.addBlock(Grid.array_position[0][c].x / Bloxet.PPM, Grid.array_position[r][0].y / Bloxet.PPM,infinity);
                                Grid.grid[r][c]=6;
                            }

                            infinity=false;
                        }
                    }

                    if (r == global_rows && c == 10) {
                        array_ready = true;

                        System.out.println("Ready");

                    }
            }
        }
        //
    }
    public void update_effects()
    {
        particleEff_array_block_generate.update(game);
    }

    public void update()
    {
        if(array_ready)
        {
            readyTimer+=Gdx.graphics.getRawDeltaTime();

            if(readyTimer>1f)
            {
                ready=true;

                stateTimer+= Gdx.graphics.getRawDeltaTime();

                if(stateTimer>3 && generate )
                {
                    if (block_turn==0)
                    {
                        Blocks_1.generate_block=true;
                    }
                    else if (block_turn==1)
                    {
                        Blocks_2.generate_block=true;
                    }
                    else if (block_turn==2)
                    {
                        Blocks_3.generate_block=true;
                    }
                    else if (block_turn==3 )
                    {
                        Blocks_6.generate_block=true;
                    }
                    generate=false;
                }
            }

        }
    }


}
