package com.jgntic.bloxet;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.jgntic.bloxet.Blocks.Blocks_1;
import com.jgntic.bloxet.Blocks.Blocks_2;
import com.jgntic.bloxet.Blocks.Blocks_3;
import com.jgntic.bloxet.Blocks.Blocks_6.Blocks_6;
import com.jgntic.bloxet.Managers.MiddleClassInformation;

/**
 * Created by IVAN on 10.5.2016 г..
 */
public class TouchInput implements GestureDetector.GestureListener{

    float movement =0;

    Bloxet game;

    public TouchInput(Bloxet game)
    {
        this.game=game;
    }

    // pan
    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {

        movement +=deltaX;

            if (movement > 100)
            {
                // move right
                Blocks_1.move_right=true;
                Blocks_2.move_right=true;
                Blocks_3.move_right=true;
                Blocks_6.move_right=true;

                if(MiddleClassInformation.mute==0)
                {
                    game.assetManager.get("sound_effects/blocks_move.ogg", Sound.class).play();
                }

                movement =0;

            } else if (movement < -100)
            {
                // move left
                Blocks_1.move_left = true;
                Blocks_2.move_left = true;
                Blocks_3.move_left = true;
                Blocks_6.move_left = true;

                if (MiddleClassInformation.mute == 0)
                {
                    game.assetManager.get("sound_effects/blocks_move.ogg", Sound.class).play();
                }

                movement = 0;
            }

        return false;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {

        return false;
    }

    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {
        return false;
    }

    @Override
    public boolean longPress(float x, float y) {
        return false;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {

        if(velocityY>300)
        {
            Blocks_1.move_down=true;
            Blocks_2.move_down=true;
            Blocks_3.move_down=true;
            Blocks_6.move_down=true;
        }

        return false;
    }

    @Override
    public boolean zoom(float initialDistance, float distance) {
        return false;
    }

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
        return false;
    }
}
