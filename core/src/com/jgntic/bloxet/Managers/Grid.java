package com.jgntic.bloxet.Managers;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by IVAN on 19.4.2016 г..
 */
public class Grid {

    public static Vector2[][] array_position;

    public static int[][] grid;

    public static int[][] extra_positions;

    public static int[][] pos_numeration;


    public Grid() {

        array_position = new Vector2[19][11];

        grid = new int[19][11];

        extra_positions=new int[19][11];

        pos_numeration =new int[19][11];

        int count=0;

        //array position;
        Vector2 position = new Vector2(20.85f, 20.85f);

        for (int r = 0; r < 19; r++)
        {
            for (int c = 0; c < 11; c++)
            {
                array_position[r][c] = new Vector2(position);
                position.x += 43.7f;

                pos_numeration[r][c]=count;
                count+=1;
            }

            position.y += 43.7f;
        }
    }
}
