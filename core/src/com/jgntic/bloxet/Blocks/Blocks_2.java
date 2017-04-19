package com.jgntic.bloxet.Blocks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.TimeUtils;
import com.jgntic.bloxet.Bloxet;
import com.jgntic.bloxet.Managers.Grid;
import com.jgntic.bloxet.Managers.MiddleClassInformation;
import com.jgntic.bloxet.Managers.NextLevel;
import com.jgntic.bloxet.Managers.RandomBodyCreated;

/**
 * Created by IVAN on 7.4.2016 г..
 */
public class Blocks_2 extends Blocks {

    public static boolean deleteBlock;
    public static boolean generate_block;
    public static boolean move_left,move_right,move_down;
    public boolean landed, start;

    public  int y_down;
    public  int x_movement;

    public boolean fast_down=false;
    float interval;

    Image ghost_image;
    int ghost_image_y_down;

    Bloxet game;

    long block_id;

    boolean infinity;

    public Blocks_2( World world, float x, float y,Bloxet game,boolean infinity) {
        super( world, x, y,game,infinity);

        this.game=game;
        this.infinity=infinity;

        texture=game.assetManager.get("block_2.png");
        blocksRegion=new TextureRegion(texture,0,0,67,67);

        sensorsSetToFalse();

        Blocks_2_array.delete_specific_body.add(this);

        current_position();

        interval=0.8f;

        ghost_block();
    }

    private void current_position(){
        if(RandomBodyCreated.ready && !infinity)
        {
            y_down=18;
            x_movement=5;

            start=true;
        }
        else
        {
            y_down=RandomBodyCreated.y_position;
            x_movement=RandomBodyCreated.x_position;
        }
    }

    private void sensorsSetToFalse(){

        deleteBlock=false;
        generate_block=false;
        landed=false;
        start=false;

        move_left=false;
        move_right=false;
        move_down=false;

    }

    private void down_movement(){

        if(y_down==0)
        {
                Grid.grid[y_down][x_movement] = 2;
        }
        else
        {
            if(Grid.grid[y_down-1][x_movement]==0)
            {

                    Grid.grid[y_down][x_movement] = 0;

                    y_down -= 1;

                    if(y_down>0 && (Grid.grid[y_down-1][x_movement]==4))
                    {
                        Grid.grid[y_down][x_movement]= 0;
                    }
                    else
                    {
                        Grid.grid[y_down][x_movement]= 2;
                    }

                    body.setTransform(new Vector2(Grid.array_position[0][x_movement].x / Bloxet.PPM, Grid.array_position[y_down][0].y / Bloxet.PPM), 0);

            }
            else
            {
                Grid.grid[y_down][x_movement]=2;

            }
        }
    }

    private void right_movement(){
        //Handle collision and right movement
        if((Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) || move_right)
        {
            if(y_down>0 && Grid.grid[y_down-1][x_movement]==0)
            {
                if (y_down==18)
                {
                    if (x_movement == 10) {
                        Grid.grid[y_down][x_movement] = 2;
                    }
                    else
                    {
                        if (Grid.grid[y_down][x_movement + 1] == 0)
                        {
                            body.setTransform(new Vector2(Grid.array_position[0][x_movement].x / Bloxet.PPM, Grid.array_position[y_down][0].y / Bloxet.PPM), 0);

                            Grid.grid[y_down][x_movement] = 0;
                            Grid.grid[y_down][x_movement+1]=2;
                            x_movement += 1;
                        }
                        else
                        {
                            Grid.grid[y_down][x_movement] = 2;
                        }
                    }
                }
                else if (y_down<18 &&Grid.grid[y_down + 1][x_movement] == 0)
                {
                    if (x_movement == 10) {
                        Grid.grid[y_down][x_movement] = 2;
                    }
                    else
                    {
                        if (Grid.grid[y_down][x_movement + 1] == 0)
                        {
                            body.setTransform(new Vector2(Grid.array_position[0][x_movement].x / Bloxet.PPM, Grid.array_position[y_down][0].y / Bloxet.PPM), 0);

                            Grid.grid[y_down][x_movement] = 0;
                            Grid.grid[y_down][x_movement+1]=2;
                            x_movement += 1;
                        }
                        else
                        {
                            Grid.grid[y_down][x_movement] = 2;
                        }
                    }
                }
            }
            move_right=false;
        }

        else
        {

            body.setTransform(new Vector2(Grid.array_position[0][x_movement].x / Bloxet.PPM, Grid.array_position[y_down][0].y / Bloxet.PPM), 0);

        }
        //************************************
    }

    private void left_movement(){
        //Handle collision and right movement
        if((Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) || move_left)
        {
            if(y_down>0 && Grid.grid[y_down-1][x_movement]==0)
            {
                if (y_down==18)
                {
                    if (x_movement == 0)
                    {
                        Grid.grid[y_down][x_movement] = 2;
                    }
                    else
                    {
                        if (Grid.grid[y_down][x_movement - 1] == 0)
                        {
                            body.setTransform(new Vector2(Grid.array_position[0][x_movement].x / Bloxet.PPM, Grid.array_position[y_down][0].y / Bloxet.PPM), 0);

                            Grid.grid[y_down][x_movement] = 0;
                            Grid.grid[y_down][x_movement - 1] = 2;
                            x_movement -= 1;
                        }
                        else
                        {
                            Grid.grid[y_down][x_movement] = 2;
                        }
                    }
                }
                else if (y_down<18 && Grid.grid[y_down + 1][x_movement] == 0)
                {
                    if (x_movement == 0)
                    {
                        Grid.grid[y_down][x_movement] = 2;
                    }
                    else
                    {
                        if (Grid.grid[y_down][x_movement - 1] == 0)
                        {
                            body.setTransform(new Vector2(Grid.array_position[0][x_movement].x / Bloxet.PPM, Grid.array_position[y_down][0].y / Bloxet.PPM), 0);

                            Grid.grid[y_down][x_movement] = 0;
                            Grid.grid[y_down][x_movement - 1] = 2;
                            x_movement -= 1;
                        }
                        else
                        {
                            Grid.grid[y_down][x_movement] = 2;
                        }
                    }
                }
            }
            move_left=false;
        }

        else
        {

            body.setTransform(new Vector2(Grid.array_position[0][x_movement].x / Bloxet.PPM, Grid.array_position[y_down][0].y / Bloxet.PPM), 0);

        }
        //************************************
    }

    private void collision_detection(){

            //SQUARE
            if(Grid.grid[y_down][x_movement]==2 && (x_movement<10 &&(Grid.grid[y_down][x_movement+1]==2))
                    && (y_down<18 && (Grid.grid[y_down+1][x_movement]==2)) && (x_movement<10 && y_down<18 &&(Grid.grid[y_down+1][x_movement+1]==2)))
            {
                deleteBlock=true;
            }

            //VERTICAL
            else if ((y_down<15) && (Grid.grid[y_down][x_movement] == 2 && Grid.grid[y_down+1][x_movement] == 2
                    && Grid.grid[y_down+2][x_movement] == 2 && Grid.grid[y_down+3][x_movement] == 2))
            {
                deleteBlock=true;
            }

    }

    private void generate_block()
    {
        if(!landed)
        {
            if( (y_down>0 && (Grid.grid[y_down-1][x_movement]!=0)) || (y_down==0))
            {
                if(MiddleClassInformation.mute==0 )
                {

                        block_id=game.assetManager.get("sound_effects/block_landed.ogg",Sound.class).play();
                        game.assetManager.get("sound_effects/block_landed.ogg",Sound.class).setVolume(block_id,0.5f);

                }

                generate_block=true;
                landed=true;
            }
        }
    }

    private void fast_down()
    {
        down_movement();
    }

    void ghost_block()
    {
        ghost_image=new Image(texture);
        ghost_image.setSize(39/Bloxet.PPM,39/Bloxet.PPM);
        ghost_image.setPosition((Grid.array_position[0][x_movement].x/Bloxet.PPM)-ghost_image.getWidth()/2,
                (Grid.array_position[y_down][0].y/Bloxet.PPM)-ghost_image.getHeight()/2);

        ghost_image_y_down=17;

    }

    void ghost_block_update()
    {
        if(ghost_image_y_down<18 && (Grid.grid[ghost_image_y_down][x_movement]!=0))
        {
            ghost_image_y_down += 1;

            if(ghost_image_y_down<18 && (Grid.grid[ghost_image_y_down][x_movement]==0))
            {
                ghost_image.setPosition((Grid.array_position[0][x_movement].x/Bloxet.PPM)-ghost_image.getWidth()/2,
                        (Grid.array_position[ghost_image_y_down][0].y/Bloxet.PPM)-ghost_image.getHeight()/2);
            }
        }

        if(ghost_image_y_down<y_down)
        {
            if(ghost_image_y_down==0)
            {
                ghost_image.setPosition((Grid.array_position[0][x_movement].x/Bloxet.PPM)-ghost_image.getWidth()/2,
                        (Grid.array_position[ghost_image_y_down][0].y/Bloxet.PPM)-ghost_image.getHeight()/2);
            }
            else
            {
                if(ghost_image_y_down>0 &&(Grid.grid[ghost_image_y_down-1][x_movement]==0))
                {
                    ghost_image_y_down -= 1;
                }
                else
                {
                    if(ghost_image_y_down>0)
                    {
                        ghost_image.setPosition((Grid.array_position[0][x_movement].x/Bloxet.PPM)-ghost_image.getWidth()/2,
                                (Grid.array_position[ghost_image_y_down][0].y/Bloxet.PPM)-ghost_image.getHeight()/2);
                    }
                }
            }
        }
    }

    @Override
    public void update() {
        super.update();
        setRegion(blocksRegion);

        ghost_block_update();

        //Handle movement, collision and set user data to body
        if(start)
        {
            generate_block();
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN) || move_down)
        {
            if(!landed && start)
            {
                fast_down=true;
            }

        }
        if(TimeUtils.timeSinceNanos(startTime)>interval *convert_in_nanoseconds)
        {
            down_movement();

            body.setUserData(Grid.array_position[y_down][x_movement]);

            startTime = TimeUtils.nanoTime();
        }

        if(!landed && start)
        {
            left_movement();
            right_movement();
        }

        if(fast_down)
        {
            if(landed)
            {
                fast_down=false;
                move_down=false;
                body.setUserData(Grid.array_position[y_down][x_movement]);
            }

            fast_down();
        }

        collision_detection();
        //****************************


    }


    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);

        if(!landed && start)
        {
            ghost_image.draw(batch,0.5f);
        }
    }

    @Override
    public void dispose() {
        texture.dispose();
    }
}
