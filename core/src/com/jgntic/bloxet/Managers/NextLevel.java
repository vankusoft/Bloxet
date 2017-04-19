package com.jgntic.bloxet.Managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.jgntic.bloxet.Blocks.Blocks_Manager;
import com.jgntic.bloxet.Bloxet;
import com.jgntic.bloxet.PlayScreen;

import aurelienribon.tweenengine.Tween;

/**
 * Created by IVAN on 26.5.2016 г..
 */
public class NextLevel {

    public static boolean next_level;
    public boolean game_over_18=false;
    public boolean completed=false;

    float stateTimer=0;

    Bloxet game;
    World world;

    public NextLevel(Bloxet game,World world)
    {
        this.game=game;
        this.world=world;

        next_level=false;
    }

    public void switch_to_next_level(Bloxet game)
    {
        if(!next_level && ((Grid.grid[0][0]==0) && (Grid.grid[0][1]==0) && (Grid.grid[0][2]==0) && (Grid.grid[0][3]==0)
                && (Grid.grid[0][4]==0) && (Grid.grid[0][5]==0) && (Grid.grid[0][6]==0) && (Grid.grid[0][7]==0)
                && (Grid.grid[0][8]==0) && (Grid.grid[0][9]==0) && (Grid.grid[0][10]==0) ||
                (Blocks_Manager.doNotGenerate_B1 && Blocks_Manager.doNotGenerateB2 && Blocks_Manager.doNotGenerateB3
                && Blocks_Manager.doNotGenerateB6)))
        {
            if(!MiddleClassInformation.infinity_mode)
            {
                next_level=true;
            }
        }

        if(Transitions_Sprite.generate_next_level)
        {
            if(MiddleClassInformation.rows<17)
            {
                MiddleClassInformation.rows+=2;
            }

            if(MiddleClassInformation.level<9)
            {
                MiddleClassInformation.level+=1;

                game.setScreen(new PlayScreen(game));
                game.dispose();
            }
            else
            {
                completed=true;
            }
        }

        if(((Grid.grid[17][0]!=0) && (Grid.grid[18][0]!=0)) || ((Grid.grid[17][1]!=0) && (Grid.grid[18][1]!=0))
            || ((Grid.grid[17][2]!=0) && (Grid.grid[18][2]!=0)) || ((Grid.grid[17][3]!=0) && (Grid.grid[18][3]!=0))
            || ((Grid.grid[17][4]!=0) && (Grid.grid[18][4]!=0)) || ((Grid.grid[17][5]!=0) && (Grid.grid[18][5]!=0))
            || ((Grid.grid[17][6]!=0) && (Grid.grid[18][6]!=0)) || ((Grid.grid[17][7]!=0) && (Grid.grid[18][7]!=0))
            || ((Grid.grid[17][8]!=0) && (Grid.grid[18][8]!=0)) || ((Grid.grid[17][9]!=0) && (Grid.grid[18][9]!=0))
            || ((Grid.grid[17][10]!=0) && (Grid.grid[18][10]!=0))
        )
        {
            game_over_18=true;
        }
    }

}
