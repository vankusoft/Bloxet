package com.jgntic.bloxet.Managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.jgntic.bloxet.Bloxet;

import javax.swing.MenuElement;

/**
 * Created by IVAN on 8.6.2016 г..
 */
public class Help_Menu_Elements {

    public Stage help_menu_stage;

    Texture background_texture;
    Texture block1_texture,block2_texture,back_button_texture;

    Image block1_1,block1_2,block1_3,block1_4,block2_1,block2_2,block2_3,block2_4;
    Image backButton_image,background_image;

    BitmapFont bitmapFont;

    Label.LabelStyle font;
    Label explain_label,explain_label_2,case_1_label,case_2_label,tip_label,tip_label2;

    Bloxet game;

    public Help_Menu_Elements(SpriteBatch batch,Viewport viewport,Bloxet game)
    {
        this.game=game;

        help_menu_stage=new Stage(viewport,batch);

        background_texture=game.assetManager.get("background_picture.png");

        background_image=new Image(background_texture);
        background_image.setPosition(0,0);
        background_image.setSize(480,800);
        background_image.setColor(0.3f, 0.3f, 0.4f, 0.9f);

        block1_texture=game.assetManager.get("block_1.png");

        block1_1=new Image(block1_texture);
        block1_1.setSize(50,50);
        block1_1.setPosition(100,340);

        block1_2=new Image(block1_texture);
        block1_2.setSize(50,50);
        block1_2.setPosition(100,280);

        block1_3=new Image(block1_texture);
        block1_3.setSize(50,50);
        block1_3.setPosition(160,340);

        block1_4=new Image(block1_texture);
        block1_4.setSize(50,50);
        block1_4.setPosition(160,280);

        block2_texture=game.assetManager.get("block_2.png");

        block2_1=new Image(block2_texture);
        block2_1.setSize(50,50);
        block2_1.setPosition(300,460);

        block2_2=new Image(block2_texture);
        block2_2.setSize(50,50);
        block2_2.setPosition(300,400);

        block2_3=new Image(block2_texture);
        block2_3.setSize(50,50);
        block2_3.setPosition(300,340);

        block2_4=new Image(block2_texture);
        block2_4.setSize(50,50);
        block2_4.setPosition(300,280);

        back_button_texture=game.assetManager.get("buttons/back_button.png");
        back_button_texture.setFilter(Texture.TextureFilter.Linear,Texture.TextureFilter.Linear);

        backButton_image=new Image(back_button_texture);
        backButton_image.setSize(50,50);
        backButton_image.setPosition(20,735);

        bitmapFont=game.assetManager.get("font/bloxet_font.fnt");
        font=new Label.LabelStyle(bitmapFont, Color.WHITE);
        font.font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear,Texture.TextureFilter.Linear);

        explain_label=new Label("COLLIDE FOUR BLOCKS TO",font);
        explain_label.setPosition(Bloxet.WIDTH/2-explain_label.getWidth()/1.5f-20,650);
        explain_label.setFontScale(1.5f);

        explain_label_2=new Label("CLEAR THEM.",font);
        explain_label_2.setPosition(Bloxet.WIDTH/2-explain_label_2.getWidth()/1.5f-20,600);
        explain_label_2.setFontScale(1.5f);

        case_1_label=new Label("CASE 1",font);
        case_1_label.setPosition(115,230);
        case_1_label.setFontScale(1.2f);

        case_2_label=new Label("CASE 2",font);
        case_2_label.setPosition(285,230);
        case_2_label.setFontScale(1.2f);

        tip_label=new Label("TIP: IN INFINITY MODE DO NOT LET THE LEVEL",font);
        tip_label.setPosition(15,100);
        tip_label.setFontScale(1f);

        tip_label2=new Label("OF THE BLOCKS TO INCREASE.",font);
        tip_label2.setPosition(15,50);
        tip_label2.setFontScale(1f);

        button_listener();

        //add actors to stage
        help_menu_stage.addActor(background_image);

        help_menu_stage.addActor(block1_1);
        help_menu_stage.addActor(block1_2);
        help_menu_stage.addActor(block1_3);
        help_menu_stage.addActor(block1_4);

        help_menu_stage.addActor(block2_1);
        help_menu_stage.addActor(block2_2);
        help_menu_stage.addActor(block2_3);
        help_menu_stage.addActor(block2_4);

        help_menu_stage.addActor(backButton_image);

        help_menu_stage.addActor(explain_label);
        help_menu_stage.addActor(explain_label_2);
        help_menu_stage.addActor(case_1_label);
        help_menu_stage.addActor(case_2_label);
        help_menu_stage.addActor(tip_label);
        help_menu_stage.addActor(tip_label2);
    }

    void button_listener()
    {
        backButton_image.addListener(
                new InputListener(){
                    @Override
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                        System.out.println("BACK_BUTTON");
                        backButton_image.setColor(1,1,1,0.4f);

                        if(MiddleClassInformation.mute==0)
                        {
                            game.assetManager.get("sound_effects/button_click.ogg", Sound.class).play();
                        }

                        return true;
                    }

                    @Override
                    public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                        if(Menu_Elements.help_button_pressed)
                        {
                            Menu_Elements.help_button_pressed=false;

                        }
                        backButton_image.setColor(1,1,1,1f);
                    }
                });
    }

    public void draw()
    {
        help_menu_stage.draw();
    }

    public void dispose()
    {
        block1_texture.dispose();
        block2_texture.dispose();
        back_button_texture.dispose();
        background_texture.dispose();

        bitmapFont.dispose();

        help_menu_stage.dispose();
    }
}
