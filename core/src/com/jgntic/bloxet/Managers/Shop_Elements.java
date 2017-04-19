package com.jgntic.bloxet.Managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
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
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.jgntic.bloxet.Bloxet;
import com.jgntic.bloxet.Screens.MenuScreen;

/**
 * Created by IVAN on 29.5.2016 г..
 */
public class Shop_Elements {

    Stage stage;

    Texture back_texture,clock_shop,bomb_shop,back_button,coin,buy_bomb,buy_time;

    Image back_image,clock_shop_image,bomb_shop_image,back_image_2,text_back_image,back_button_image,
            coin_image, powerUps_count_back_image,powerUps_count_back_image_2,buy_bomb_image,buy_bomb_back,
    buy_time_image,buy_time_back;

    Viewport viewport2;

    Label.LabelStyle font,coin_font;
    Label text_label,text_label_2,power_ups_count_label,power_ups_count_label_2,power_ups_label,
    coin_label;

    BitmapFont bitmapFont;

    int time_count;
    int bomb_count;
    int coins_count=0;

    Bloxet game;

    long power_ups_id;

    public Shop_Elements(SpriteBatch batch,Bloxet game)
    {
        this.game=game;

        viewport2=new FitViewport(Bloxet.WIDTH,Bloxet.HEIGHT);
        stage=new Stage(viewport2,batch);

        Gdx.input.setInputProcessor(stage);

        back_texture=game.assetManager.get("dbg_block1.png");
        back_texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        clock_shop=game.assetManager.get("clock_shop.png");
        clock_shop.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        bomb_shop=game.assetManager.get("bomb_shop.png");
        bomb_shop.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        back_button=game.assetManager.get("buttons/back_button.png");
        back_button.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        coin=game.assetManager.get("coin.png");
        coin.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        buy_bomb=game.assetManager.get("100.png");
        buy_bomb.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        buy_time=game.assetManager.get("150.png");
        buy_time.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);


        back_image=new Image(back_texture);
        back_image.setSize(100,100);
        back_image.setPosition(80,400);
        back_image.setColor(1,1,1,0.3f);

        clock_shop_image=new Image(clock_shop);
        clock_shop_image.setSize(50,50);
        clock_shop_image.setPosition((back_image.getX()+back_image.getImageWidth()/2)+clock_shop_image.getWidth()/2,
                ( back_image.getY()+back_image.getImageHeight()/2)+clock_shop_image.getHeight()/2);

        back_image_2=new Image(back_texture);
        back_image_2.setSize(100,100);
        back_image_2.setPosition(300,400);
        back_image_2.setColor(1,1,1,0.3f);

        bomb_shop_image=new Image(bomb_shop);
        bomb_shop_image.setSize(50,50);
        bomb_shop_image.setPosition((back_image_2.getX()+back_image_2.getImageWidth()/2)+bomb_shop_image.getWidth()/2,
                ( back_image_2.getY()+back_image_2.getImageHeight()/2)+bomb_shop_image.getHeight()/2);

        text_back_image=new Image(back_texture);
        text_back_image.setSize(500,100);
        text_back_image.setPosition(0,0);
        text_back_image.setColor(1,1,1,0.7f);

        back_button_image=new Image(back_button);
        back_button_image.setSize(50,50);
        back_button_image.setPosition(20,735);

        coin_image=new Image(coin);
        coin_image.setSize(25,25);
        coin_image.setPosition(430,750);
        coin_image.setColor(1,1,1,0.8f);


        buy_bomb_image=new Image(buy_bomb);
        buy_bomb_image.setSize(190,100);
        buy_bomb_image.setPosition((back_image_2.getX()+back_image_2.getWidth()/2+5)-buy_bomb_image.getWidth()/2-10,
                (back_image_2.getY()-buy_bomb_image.getHeight())-buy_bomb_image.getHeight()/2+5);

        buy_bomb_back=new Image(back_texture);
        buy_bomb_back.setSize(190,110);
        buy_bomb_back.setPosition((back_image_2.getX()+back_image_2.getWidth()/2)-buy_bomb_image.getWidth()/2,
                (back_image_2.getY()-buy_bomb_image.getHeight())-buy_bomb_image.getHeight()/2);
        buy_bomb_back.setColor(1,1,1,0.3f);

        buy_time_image=new Image(buy_time);
        buy_time_image.setSize(190,100);
        buy_time_image.setPosition((back_image.getX()+back_image.getWidth()/2+5)-buy_time_image.getWidth()/2-10,
                (back_image.getY()-buy_time_image.getHeight())-buy_time_image.getHeight()/2+5);

        buy_time_back=new Image(back_texture);
        buy_time_back.setSize(190,110);
        buy_time_back.setPosition((back_image.getX()+back_image.getWidth()/2)-buy_time_image.getWidth()/2,
                (back_image.getY()-buy_time_image.getHeight())-buy_time_image.getHeight()/2);
        buy_time_back.setColor(1,1,1,0.3f);


        powerUps_count_back_image =new Image(back_texture);
        powerUps_count_back_image.setSize(30, 30);
        powerUps_count_back_image.setPosition(back_image.getX()-5,
                (back_image.getY()+back_image.getHeight())- powerUps_count_back_image.getHeight()+5);

        powerUps_count_back_image_2 =new Image(back_texture);
        powerUps_count_back_image_2.setSize(30, 30);
        powerUps_count_back_image_2.setPosition(back_image_2.getX()-5,
                (back_image_2.getY()+back_image_2.getHeight())- powerUps_count_back_image_2.getHeight()+5);

        bitmapFont=game.assetManager.get("font/bloxet_font.fnt");

        font=new Label.LabelStyle(bitmapFont, Color.WHITE);
        font.font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear,Texture.TextureFilter.Linear);


        text_label=new Label("",font);
        text_label.setPosition(20,70);
        text_label.setFontScale(1.5f);

        text_label_2=new Label("",font);
        text_label_2.setPosition(70, 40);
        text_label_2.setFontScale(1.5f);

        power_ups_count_label=new Label(""+time_count,font);
        power_ups_count_label.setPosition((powerUps_count_back_image.getX()+powerUps_count_back_image.getWidth()/2)
                        -power_ups_count_label.getWidth()/2-5,
                (powerUps_count_back_image.getY()+powerUps_count_back_image.getHeight()/2)-power_ups_count_label.getHeight()/2);
        power_ups_count_label.setFontScale(1);

        power_ups_count_label_2=new Label(""+bomb_count,font);
        power_ups_count_label_2.setPosition((powerUps_count_back_image_2.getX()+powerUps_count_back_image_2.getWidth()/2)
                        -power_ups_count_label_2.getWidth()/2-5,
                (powerUps_count_back_image_2.getY()+powerUps_count_back_image_2.getHeight()/2)-power_ups_count_label_2.getHeight()/2);
        power_ups_count_label_2.setFontScale(1);

        power_ups_label=new Label("POWER-UPS",font);
        power_ups_label.setPosition((Bloxet.WIDTH/2)-power_ups_label.getWidth(),550);
        power_ups_label.setFontScale(2f);

        coin_font=new Label.LabelStyle(new BitmapFont(), Color.YELLOW);
        coin_font.font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear,Texture.TextureFilter.Linear);

        coin_label=new Label(""+coins_count,coin_font);
        coin_label.setPosition(coin_image.getX()-20,coin_image.getY()+coin_label.getHeight()-15);
        coin_label.setFontScale(2);

        listeners();

        stage.addActor(back_image);
        stage.addActor(back_image_2);
        stage.addActor(clock_shop_image);
        stage.addActor(bomb_shop_image);
        stage.addActor(text_back_image);
        stage.addActor(text_label);
        stage.addActor(text_label_2);
        stage.addActor(back_button_image);
        stage.addActor(coin_image);
        stage.addActor(powerUps_count_back_image);
        stage.addActor(powerUps_count_back_image_2);
        stage.addActor(power_ups_count_label);
        stage.addActor(power_ups_count_label_2);
        stage.addActor(power_ups_label);
        stage.addActor(coin_label);
        stage.addActor(buy_bomb_back);
        stage.addActor(buy_bomb_image);
        stage.addActor(buy_time_back);
        stage.addActor(buy_time_image);

    }

    void listeners()
    {
        clock_shop_image.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                text_label.setText("GIVES YOU EXTRA TIME");

                text_label_2.setText("");

                if(MiddleClassInformation.coins_count>=150)
                {
                    MiddleClassInformation.coins_count-=150;

                    MiddleClassInformation.time_count+=1;

                    if(MiddleClassInformation.mute==0)
                    {
                        power_ups_id=game.assetManager.get("sound_effects/buy_power_ups.ogg", Sound.class).play();
                        game.assetManager.get("sound_effects/buy_power_ups.ogg", Sound.class).setVolume(power_ups_id,0.5f);

                    }


                }



                return true;
            }
        });

        bomb_shop_image.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                text_label.setText("BLAST EVERYTHING");
                text_label.setPosition(20,70);

                text_label_2.setText("AROUND IT");
                text_label_2.setPosition(20,40);

                if(MiddleClassInformation.coins_count>=100)
                {
                    MiddleClassInformation.coins_count-=100;

                    MiddleClassInformation.bomb_count+=1;

                    if(MiddleClassInformation.mute==0)
                    {
                        power_ups_id=game.assetManager.get("sound_effects/buy_power_ups.ogg", Sound.class).play();
                        game.assetManager.get("sound_effects/buy_power_ups.ogg", Sound.class).setVolume(power_ups_id,0.5f);
                    }


                }
                return true;
            }
        });

        back_button_image.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                back_button_image.setColor(1,1,1,0.5f);

                if(MiddleClassInformation.mute==0)
                {
                    game.assetManager.get("sound_effects/button_click.ogg", Sound.class).play();
                }

                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                back_button_image.setColor(1,1,1,1);
                game.setScreen(new MenuScreen(game));
            }
        });
    }

    public void update(){

        coin_label.setText(""+coins_count);

        if(coins_count<10)
        {
            coin_label.setPosition(coin_image.getX()-20,coin_image.getY()+coin_label.getHeight()-15);
        }
        if(coins_count>=10)
        {
            coin_label.setPosition(coin_image.getX()-35,coin_image.getY()+coin_label.getHeight()-15);
        }
        if(coins_count>=100)
        {
            coin_label.setPosition(coin_image.getX()-50,coin_image.getY()+coin_label.getHeight()-15);
        }
        if(coins_count>=1000)
        {
            coin_label.setPosition(coin_image.getX()-65,coin_image.getY()+coin_label.getHeight()-15);
        }
        if(coins_count>=10000)
        {
            coin_label.setPosition(coin_image.getX()-80,coin_image.getY()+coin_label.getHeight()-15);
        }
        if(coins_count>=100000)
        {
            coin_label.setPosition(coin_image.getX()-95,coin_image.getY()+coin_label.getHeight()-15);
        }
        if(coins_count>=1000000)
        {
            coin_label.setPosition(coin_image.getX()-110,coin_image.getY()+coin_label.getHeight()-15);
        }

        coins_count=MiddleClassInformation.coins_count;

        power_ups_count_label.setText(""+MiddleClassInformation.time_count);
        power_ups_count_label_2.setText(""+MiddleClassInformation.bomb_count);

    }

    public void draw(){
        stage.draw();
    }

    public void dispose(){

        back_texture.dispose();
        clock_shop.dispose();
        bomb_shop.dispose();
        back_button.dispose();
        coin.dispose();
        buy_bomb.dispose();

        bitmapFont.dispose();
    }

}
