package com.jgntic.bloxet.Managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.jgntic.bloxet.Bloxet;
import com.jgntic.bloxet.PlayScreen;
import com.jgntic.bloxet.Screens.ShopScreen;

/**
 * Created by IVAN on 28.5.2016 г..
 */
public class Menu_Elements {

        Stage stage,little_menu_stage,stats_stage,credits_stage,mode_stage;

        Help_Menu_Elements help_menu_elements;

        Bloxet game;

        Viewport viewport;

        Texture play_button_texture,shop_button_texture,help_button_texture,more_button_texture,
        mute_button_texture,stats_button_texture,credits_button_texture,mute_button_mute_texture,
        music_button,music_button_mute;

        Texture bloxet_title,extra_menus_texture;

        Texture back_button_texture,coin,block_1_texture,block_2_texture,block_3_texture,block_6_texture,
        bomb_texture,clock_texture;

        Texture medium_button_texture,hard_button_texture,panel_texture,new_game_texture,infinity_button_texture;
        Image medium_button_image,hard_button_image,panel_image,new_game_image,infinity_button_image;

        //MAIN STAGE
        Image more_button_image,play_button_image,help_button_image,shop_button_image,
        mute_button_image,stats_button_image,credits_button_image,extra_menus_image,
        music_button_image;

        //STATS STAGE
        Image back_button_image_stats,coin_image,block_1_image,block_2_image,block_3_image,block_6_image,
        bomb_image,clock_image;

        //CREDITS STAGE
        Image back_button_credits,background_credits;

        Label.LabelStyle coin_font,font;

        Label coin_label,total_blocks,block_1_label,block_2_label,block_3_label,block_6_label,
        bomb_label,clock_label,highest_score_label,coins_collected_label,highest_block_chain_label,
        credits_label,developed_label,ivan_label,music_label,music_name_label,
        email_label,email_label_2;

        BitmapFont bitmapFont;

        int coins_count;
        int total_blocks_int,block_1_int,block_2_int,block_3_int,block_6_int,bomb_int,clock_int;
        int highest_score,coins_collected,highest_block_chain;
        int total_block_chain;

        public boolean moreButton_up;
        public boolean stats_button_pressed=false;
        public boolean credits_button_pressed=false;
        public static boolean help_button_pressed=false;
        public boolean play_button_pressed=false;

        int mute=0;
        int music_mute=0;

        InputMultiplexer inputMultiplexer;

        public Menu_Elements(SpriteBatch sb, final Bloxet game){
            this.game=game;

            viewport=new FitViewport(Bloxet.WIDTH,Bloxet.HEIGHT);

            stage=new Stage(viewport,sb);
            little_menu_stage=new Stage(viewport,sb);
            stats_stage=new Stage(viewport,sb);
            credits_stage=new Stage(viewport,sb);
            mode_stage=new Stage(viewport,sb);

            help_menu_elements=new Help_Menu_Elements(sb,viewport,game);

            inputMultiplexer=new InputMultiplexer();
            inputMultiplexer.addProcessor(stage);
            inputMultiplexer.addProcessor(little_menu_stage);

            mute=MiddleClassInformation.mute;
            music_mute=MiddleClassInformation.music;

            moreButton_up=true;

            total_block_chain=MiddleClassInformation.total_block_chain;

            play_button_texture =game.assetManager.get("buttons/play_button_new.png");
            play_button_texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

            shop_button_texture=game.assetManager.get("buttons/power_ups_button.png");
            shop_button_texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

            help_button_texture=game.assetManager.get("buttons/help_button.png");
            help_button_texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

            bloxet_title=game.assetManager.get("bloxet_title_test.png");
            bloxet_title.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

            Image bloxet_title_image=new Image(bloxet_title);
            bloxet_title_image.setSize(500,300);
            bloxet_title_image.setPosition(Bloxet.WIDTH / 2 - bloxet_title_image.getWidth() / 2,480);


            //PLAY BUTTON
            play_button_image=new Image(play_button_texture);
            play_button_image.setSize(250,160);
            play_button_image.setPosition(Bloxet.WIDTH / 2  - play_button_image.getWidth() / 2, 350 );
            play_button_image.setColor(1,1,1,1f);

            //SHOP BUTTON
            shop_button_image=new Image(shop_button_texture);
            shop_button_image.setSize(250,160);
            shop_button_image.setPosition(Bloxet.WIDTH/2-shop_button_image.getWidth()/2,200);
            shop_button_image.setColor(1,1,1,1f);

            //HELP BUTTON
            help_button_image=new Image(help_button_texture);
            help_button_image.setSize(250,160);
            help_button_image.setPosition(Bloxet.WIDTH/2-help_button_image.getWidth()/2,50);
            help_button_image.setColor(1,1,1,1f);

            more_button_texture=game.assetManager.get("buttons/back_button.png");
            more_button_texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

            more_button_image=new Image(more_button_texture);
            more_button_image.setSize(50,50);
            more_button_image.setPosition(415,60);
            more_button_image.setRotation(-90f);

            mute_button_texture=game.assetManager.get("buttons/mute_button.png");
            mute_button_texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

            mute_button_mute_texture=game.assetManager.get("buttons/mute_button_mute.png");
            mute_button_mute_texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

            mute_button_image=new Image();
            mute_button_image.setSize(50,50);
            mute_button_image.setPosition(415,70);

            music_button=game.assetManager.get("buttons/music_button.png");
            music_button.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

            music_button_mute=game.assetManager.get("buttons/music_button_mute.png");
            music_button_mute.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

            music_button_image=new Image();
            music_button_image.setSize(50,50);
            music_button_image.setPosition(415,130);

            stats_button_texture=game.assetManager.get("buttons/stats_button.png");
            stats_button_texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

            stats_button_image=new Image(stats_button_texture);
            stats_button_image.setSize(50,50);
            stats_button_image.setPosition(415,190);

            credits_button_texture=game.assetManager.get("buttons/credits_button.png");
            credits_button_texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

            credits_button_image=new Image(credits_button_texture);
            credits_button_image.setSize(50,50);
            credits_button_image.setPosition(415,250);

            extra_menus_texture=game.assetManager.get("background_picture.png");
            extra_menus_texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

            extra_menus_image=new Image(extra_menus_texture);
            extra_menus_image.setPosition(0,0);
            extra_menus_image.setSize(480,800);
            extra_menus_image.setColor(0.3f,0.3f,0.4f,0.9f);

            back_button_texture=game.assetManager.get("buttons/back_button.png");
            back_button_texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

            back_button_image_stats=new Image(back_button_texture);
            back_button_image_stats.setSize(50,50);
            back_button_image_stats.setPosition(20,735);

            coin=game.assetManager.get("coin.png");
            coin.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

            coin_image=new Image(coin);
            coin_image.setSize(25,25);
            coin_image.setPosition(430,750);
            coin_image.setColor(1,1,1,0.8f);

            coin_font=new Label.LabelStyle(new BitmapFont(), Color.YELLOW);
            coin_font.font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear,Texture.TextureFilter.Linear);

            coin_label=new Label(""+coins_count,coin_font);
            coin_label.setPosition(coin_image.getX()-20,coin_image.getY()+coin_label.getHeight()-15);
            coin_label.setFontScale(2f);

            block_1_texture=game.assetManager.get("block_1.png");
            block_1_texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

            block_1_image=new Image(block_1_texture);
            block_1_image.setSize(60,60);
            block_1_image.setPosition(50,600);

            block_2_texture=game.assetManager.get("block_2.png");
            block_2_texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

            block_2_image=new Image(block_2_texture);
            block_2_image.setSize(60,60);
            block_2_image.setPosition(50,520);

            block_3_texture=game.assetManager.get("block_3.png");
            block_3_texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

            block_3_image=new Image(block_3_texture);
            block_3_image.setSize(60,60);
            block_3_image.setPosition(50,440);

            block_6_texture=game.assetManager.get("block_6.png");
            block_6_texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

            block_6_image=new Image(block_6_texture);
            block_6_image.setSize(60,60);
            block_6_image.setPosition(50,360);

            bomb_texture=game.assetManager.get("block_bomb.png");
            bomb_texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

            bomb_image=new Image(bomb_texture);
            bomb_image.setSize(60,60);
            bomb_image.setPosition(50,280);

            clock_texture=game.assetManager.get("clock.png");
            clock_texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

            clock_image=new Image(clock_texture);
            clock_image.setSize(60,60);
            clock_image.setPosition(50,200);

            bitmapFont=game.assetManager.get("font/bloxet_font.fnt");

            font=new Label.LabelStyle(bitmapFont, Color.WHITE);
            font.font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear,Texture.TextureFilter.Linear);

            total_blocks=new Label("BLOCKS CLEARED "+total_blocks_int,font);
            total_blocks.setPosition(50,680);
            total_blocks.setFontScale(1.3f);

            block_1_label=new Label(""+block_1_int,font);
            block_1_label.setPosition(125,(block_1_image.getY()+block_1_image.getHeight()/2)-block_1_label.getHeight()/2);
            block_1_label.setFontScale(2f);

            block_2_label=new Label(""+block_2_int,font);
            block_2_label.setPosition(125,(block_2_image.getY()+block_2_image.getHeight()/2)-block_2_label.getHeight()/2);
            block_2_label.setFontScale(2f);

            block_3_label=new Label(""+block_3_int,font);
            block_3_label.setPosition(125,(block_3_image.getY()+block_3_image.getHeight()/2)-block_3_label.getHeight()/2);
            block_3_label.setFontScale(2f);

            block_6_label=new Label(""+block_6_int,font);
            block_6_label.setPosition(125,(block_6_image.getY()+block_6_image.getHeight()/2)-block_6_label.getHeight()/2);
            block_6_label.setFontScale(2f);

            bomb_label=new Label(""+bomb_int,font);
            bomb_label.setPosition(125,(bomb_image.getY()+bomb_image.getHeight()/2)-bomb_label.getHeight()/2);
            bomb_label.setFontScale(2f);

            clock_label=new Label(""+clock_int,font);
            clock_label.setPosition(125,(clock_image.getY()+clock_image.getHeight()/2)-clock_label.getHeight()/2);
            clock_label.setFontScale(2f);

            highest_score_label=new Label("HIGHEST SCORE "+highest_score,font);
            highest_score_label.setPosition(50,150);
            highest_score_label.setFontScale(1.3f);

            coins_collected_label=new Label("COINS COLLECTED "+coins_collected,font);
            coins_collected_label.setPosition(50,100);
            coins_collected_label.setFontScale(1.3f);

            highest_block_chain_label=new Label("HIGHEST BLOCK CHAIN "+highest_block_chain,font);
            highest_block_chain_label.setPosition(50,50);
            highest_block_chain_label.setFontScale(1.3f);

            //credits stage
            background_credits=new Image(extra_menus_texture);
            background_credits.setPosition(0,0);
            background_credits.setSize(480,800);
            background_credits.setColor(0.3f, 0.3f, 0.4f, 0.9f);

            back_button_credits=new Image(back_button_texture);
            back_button_credits.setSize(50,50);
            back_button_credits.setPosition(20,735);

            credits_label=new Label("CREDITS",font);
            credits_label.setPosition(Bloxet.WIDTH/2-credits_label.getWidth()-10,650);
            credits_label.setFontScale(2);

            developed_label=new Label("DEVELOPED BY JGNTIC",font);
            developed_label.setPosition(Bloxet.WIDTH/2-developed_label.getWidth()/1.5f-25,530);
            developed_label.setFontScale(1.5f);

            ivan_label=new Label("IVAN GEORGIEV",font);
            ivan_label.setPosition(Bloxet.WIDTH/2-ivan_label.getWidth()/1.9f-10,490);
            ivan_label.setFontScale(1.1f);

            music_label=new Label("MUSIC BY",font);
            music_label.setPosition(Bloxet.WIDTH/2-music_label.getWidth()/1.5f-15,420);
            music_label.setFontScale(1.5f);

            music_name_label=new Label("http://www.freesfx.co.uk",font);
            music_name_label.setPosition(Bloxet.WIDTH/2-music_name_label.getWidth()/1.9f-10,380);
            music_name_label.setFontScale(1.1f);

            email_label=new Label("IF THERE ARE ANY PROBLEMS WITH THE GAME",font);
            email_label.setPosition(Bloxet.WIDTH/2-email_label.getWidth()/2f,100);
            email_label.setFontScale(1f);

            email_label_2=new Label("PLEASE CONTACT ME: ijgntic@gmail.com",font);
            email_label_2.setPosition(Bloxet.WIDTH/2-email_label_2.getWidth()/1.9f-10,50);
            email_label_2.setFontScale(1.1f);

            panel_texture=game.assetManager.get("background_picture.png");
            panel_texture.setFilter(Texture.TextureFilter.Linear,Texture.TextureFilter.Linear);

            panel_image=new Image(panel_texture);
            panel_image.setSize(480,800);
            panel_image.setColor(0.3f,0.3f,0.4f,0.9f);
            panel_image.setPosition(0,0);

            medium_button_texture=game.assetManager.get("buttons/medium_button.png");
            medium_button_texture.setFilter(Texture.TextureFilter.Linear,Texture.TextureFilter.Linear);

            medium_button_image=new Image(medium_button_texture);
            medium_button_image.setSize(280,100);
            medium_button_image.setPosition(panel_image.getWidth()/2-medium_button_image.getWidth()/2,400);

            hard_button_texture=game.assetManager.get("buttons/hard_button.png");
            hard_button_texture.setFilter(Texture.TextureFilter.Linear,Texture.TextureFilter.Linear);

            hard_button_image=new Image(hard_button_texture);
            hard_button_image.setSize(280,100);
            hard_button_image.setPosition(panel_image.getWidth()/2-hard_button_image.getWidth()/2,250);

            infinity_button_texture=game.assetManager.get("buttons/infinity_button.png");
            infinity_button_texture.setFilter(Texture.TextureFilter.Linear,Texture.TextureFilter.Linear);

            infinity_button_image=new Image(infinity_button_texture);
            infinity_button_image.setSize(280,100);
            infinity_button_image.setPosition(panel_image.getWidth()/2-hard_button_image.getWidth()/2,100);

            new_game_texture=game.assetManager.get("new_game.png");
            new_game_texture.setFilter(Texture.TextureFilter.Linear,Texture.TextureFilter.Linear);

            new_game_image=new Image(new_game_texture);
            new_game_image.setSize(400,100);
            new_game_image.setPosition(panel_image.getWidth()/2-new_game_image.getWidth()/2,600);

            listeners();

            stage.addActor(play_button_image);
            stage.addActor(shop_button_image);
            stage.addActor(help_button_image);
            stage.addActor(bloxet_title_image);
            stage.addActor(more_button_image);

            little_menu_stage.addActor(mute_button_image);
            little_menu_stage.addActor(stats_button_image);
            little_menu_stage.addActor(credits_button_image);
            little_menu_stage.addActor(music_button_image);

            stats_stage.addActor(extra_menus_image);
            stats_stage.addActor(back_button_image_stats);
            stats_stage.addActor(coin_image);
            stats_stage.addActor(coin_label);
            stats_stage.addActor(block_1_image);
            stats_stage.addActor(block_2_image);
            stats_stage.addActor(block_3_image);
            stats_stage.addActor(block_6_image);
            stats_stage.addActor(bomb_image);
            stats_stage.addActor(clock_image);
            stats_stage.addActor(total_blocks);
            stats_stage.addActor(block_1_label);
            stats_stage.addActor(block_2_label);
            stats_stage.addActor(block_3_label);
            stats_stage.addActor(block_6_label);
            stats_stage.addActor(bomb_label);
            stats_stage.addActor(clock_label);
            stats_stage.addActor(highest_score_label);
            stats_stage.addActor(coins_collected_label);
            stats_stage.addActor(highest_block_chain_label);

            credits_stage.addActor(background_credits);
            credits_stage.addActor(back_button_credits);
            credits_stage.addActor(credits_label);
            credits_stage.addActor(developed_label);
            credits_stage.addActor(ivan_label);
            credits_stage.addActor(music_label);
            credits_stage.addActor(music_name_label);
            credits_stage.addActor(email_label);
            credits_stage.addActor(email_label_2);

            mode_stage.addActor(panel_image);
            mode_stage.addActor(medium_button_image);
            mode_stage.addActor(hard_button_image);
            mode_stage.addActor(new_game_image);
            mode_stage.addActor(infinity_button_image);

        }

        void listeners()
        {
            play_button_image.addListener(new InputListener(){
                @Override
                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                    play_button_image.setColor(1,1,1,1f);
                    MiddleClassInformation.global_score=0;
                    MiddleClassInformation.level=1;

                    play_button_pressed=true;
                }

                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    System.out.println("PLAY_BUTTON");
                    play_button_image.setColor(1,1,1,0.4f);

                    if(mute==0)
                    {
                        game.assetManager.get("sound_effects/button_click.ogg", Sound.class).play();
                    }

                    return true;
                }
            });

            shop_button_image.addListener(new InputListener(){
                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    System.out.println("SHOP_BUTTON");
                    shop_button_image.setColor(1,1,1,0.4f);

                    if(mute==0)
                    {
                        game.assetManager.get("sound_effects/button_click.ogg", Sound.class).play();
                    }
                    return true;
                }

                @Override
                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                    shop_button_image.setColor(1,1,1,1f);
                    game.setScreen(new ShopScreen(game));
                }
            });

            help_button_image.addListener(new InputListener(){
                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    System.out.println("HELP_BUTTON");
                    help_button_image.setColor(1,1,1,0.4f);

                    if(mute==0)
                    {
                        game.assetManager.get("sound_effects/button_click.ogg", Sound.class).play();
                    }
                    return true;
                }

                @Override
                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {

                    if(help_button_pressed)
                    {
                        help_button_pressed=false;
                    }
                    else
                    {
                        help_button_pressed=true;
                    }

                    help_button_image.setColor(1,1,1,1f);
                }
            });

            more_button_image.addListener(
                    new InputListener(){
                        @Override
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                            more_button_image.setColor(1,1,1,0.5f);

                            if(mute==0)
                            {
                                game.assetManager.get("sound_effects/button_click.ogg", Sound.class).play();
                            }
                            return true;
                        }

                        @Override
                        public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                            more_button_image.setColor(1,1,1,1f);

                            if(moreButton_up)
                            {
                                more_button_image.setRotation(90f);
                                more_button_image.setPosition(465,10);
                                moreButton_up=false;
                            }
                            else
                            {
                                more_button_image.setRotation(-90f);
                                more_button_image.setPosition(415,60);
                                moreButton_up=true;
                            }
                        }
                    }
            );

            mute_button_image.addListener(
                    new InputListener(){
                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                    if(!moreButton_up)
                    {
                        System.out.println("MUTE_BUTTON");
                        mute_button_image.setColor(1,1,1,0.4f);
                    }

                    return true;
                }

                @Override
                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {

                    if(!moreButton_up)
                    {
                        mute_button_image.setColor(1,1,1,1f);
                        if(mute==0)
                        {
                            mute_button_image.setDrawable(new SpriteDrawable(new Sprite(mute_button_texture)));
                            mute=1;

                        }
                        else
                        {
                            game.assetManager.get("sound_effects/button_click.ogg", Sound.class).play();

                            mute_button_image.setDrawable(new SpriteDrawable(new Sprite(mute_button_mute_texture)));
                            mute=0;

                        }
                    }
                }
            });

            music_button_image.addListener(
                    new InputListener(){
                        @Override
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                            if(!moreButton_up)
                            {
                                System.out.println("MUSIC_BUTTON");
                                music_button_image.setColor(1,1,1,0.4f);
                            }

                            return true;
                        }

                        @Override
                        public void touchUp(InputEvent event, float x, float y, int pointer, int button) {

                            if(!moreButton_up)
                            {

                                if(mute==0)
                                {
                                    game.assetManager.get("sound_effects/button_click.ogg", Sound.class).play();
                                }
                                music_button_image.setColor(1,1,1,1f);

                                if(music_mute==0)
                                {
                                    music_button_image.setDrawable(new SpriteDrawable(new Sprite(music_button)));
                                    music_mute=1;

                                    game.assetManager.get("music/swing_mode.ogg", Music.class).setVolume(0);
                                    game.assetManager.get("music/matrix.ogg",Music.class).setVolume(0);
                                }
                                else
                                {
                                    music_button_image.setDrawable(new SpriteDrawable(new Sprite(music_button_mute)));
                                    music_mute=0;

                                    game.assetManager.get("music/swing_mode.ogg", Music.class).setVolume(0.3f);
                                    game.assetManager.get("music/matrix.ogg",Music.class).setVolume(0.3f);
                                }
                            }
                        }
                    }
            );


            stats_button_image.addListener(
                    new InputListener(){
                        @Override
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                            if(!moreButton_up)
                            {
                                System.out.println("STATS_BUTTON");
                                stats_button_image.setColor(1,1,1,0.4f);
                            }

                            if(!moreButton_up)
                            {
                                if(mute==0)
                                {
                                    game.assetManager.get("sound_effects/button_click.ogg", Sound.class).play();
                                }
                            }

                            return true;
                        }

                        @Override
                        public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                            if(!moreButton_up)
                            {
                                if(stats_button_pressed)
                                {
                                    stats_button_pressed=false;
                                }
                                else
                                {
                                    stats_button_pressed=true;
                                }
                                stats_button_image.setColor(1,1,1,1f);
                            }
                        }
                    });

            credits_button_image.addListener(
                    new InputListener(){
                        @Override
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                            if (!moreButton_up) {
                                System.out.println("CREDITS_BUTTON");
                                credits_button_image.setColor(1, 1, 1, 0.4f);
                            }

                            if(!moreButton_up)
                            {
                                if(mute==0)
                                {
                                    game.assetManager.get("sound_effects/button_click.ogg", Sound.class).play();
                                }
                            }

                            return true;
                        }

                        @Override
                        public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                            if(!moreButton_up)
                            {
                                if(credits_button_pressed)
                                {
                                    credits_button_pressed=false;
                                }
                                else
                                {
                                    credits_button_pressed=true;
                                }
                                credits_button_image.setColor(1,1,1,1f);
                            }
                        }
                    });

            back_button_image_stats.addListener(
                    new InputListener(){
                        @Override
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                            if(stats_button_pressed)
                            {
                                System.out.println("BACK_BUTTON");
                                back_button_image_stats.setColor(1,1,1,0.4f);
                            }

                            if(mute==0)
                            {
                                game.assetManager.get("sound_effects/button_click.ogg", Sound.class).play();
                            }


                            return true;
                        }

                        @Override
                        public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                            if(stats_button_pressed)
                            {
                                stats_button_pressed=false;
                                back_button_image_stats.setColor(1,1,1,1f);
                            }
                        }
                    });

            back_button_credits.addListener(
                    new InputListener(){
                        @Override
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                            if(credits_button_pressed)
                            {
                                System.out.println("BACK_BUTTON");
                                back_button_credits.setColor(1,1,1,0.4f);
                            }

                            if(mute==0)
                            {
                                game.assetManager.get("sound_effects/button_click.ogg", Sound.class).play();
                            }

                            return true;
                        }

                        @Override
                        public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                            if(credits_button_pressed)
                            {
                                credits_button_pressed=false;
                                back_button_credits.setColor(1,1,1,1f);
                            }
                        }
                    });

            medium_button_image.addListener(
                    new InputListener(){
                        @Override
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                            medium_button_image.setColor(1,1,1,0.5f);
                            MiddleClassInformation.hard_mode=false;
                            MiddleClassInformation.infinity_mode=false;
                            MiddleClassInformation.medium_mode=true;

                            if(mute==0)
                            {
                                game.assetManager.get("sound_effects/button_click.ogg", Sound.class).play();
                            }

                            return true;
                        }

                        @Override
                        public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                            medium_button_image.setColor(1,1,1,1f);
                            game.setScreen(new PlayScreen(game));
                        }
                    }
            );

            hard_button_image.addListener(
                    new InputListener(){
                        @Override
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                            hard_button_image.setColor(1,1,1,0.5f);
                            MiddleClassInformation.medium_mode=false;
                            MiddleClassInformation.infinity_mode=false;
                            MiddleClassInformation.hard_mode=true;

                            if(mute==0)
                            {
                                game.assetManager.get("sound_effects/button_click.ogg", Sound.class).play();
                            }

                            return true;
                        }

                        @Override
                        public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                            hard_button_image.setColor(1,1,1,1f);
                            game.setScreen(new PlayScreen(game));
                        }
                    }
            );

            infinity_button_image.addListener(
                    new InputListener()
                    {
                        @Override
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                            infinity_button_image.setColor(1,1,1,0.5f);

                            MiddleClassInformation.medium_mode=false;
                            MiddleClassInformation.hard_mode=false;
                            MiddleClassInformation.infinity_mode=true;

                            if(mute==0)
                            {
                                game.assetManager.get("sound_effects/button_click.ogg", Sound.class).play();
                            }

                            return true;
                        }

                        @Override
                        public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                            infinity_button_image.setColor(1,1,1,1f);
                            game.setScreen(new PlayScreen(game));
                        }
                    }
            );

        }

        void input_processors()
        {
            if(stats_button_pressed)
            {
                Gdx.input.setInputProcessor(stats_stage);
            }
            else if(credits_button_pressed)
            {
                Gdx.input.setInputProcessor(credits_stage);
            }
            else if(help_button_pressed)
            {
                Gdx.input.setInputProcessor(help_menu_elements.help_menu_stage);
            }
            else if(play_button_pressed)
            {
                Gdx.input.setInputProcessor(mode_stage);
            }
            else
            {
                Gdx.input.setInputProcessor(inputMultiplexer);
            }
        }

        void mute_button()
        {
            if(mute==0)
            {
                mute_button_image.setDrawable(new SpriteDrawable(new Sprite(mute_button_texture)));
            }
            else
            {
                mute_button_image.setDrawable(new SpriteDrawable(new Sprite(mute_button_mute_texture)));
            }
        }

        void music_button()
        {
            if(music_mute==0)
            {
                music_button_image.setDrawable(new SpriteDrawable(new Sprite(music_button)));
            }
            else
            {
                music_button_image.setDrawable(new SpriteDrawable(new Sprite(music_button_mute)));
            }
        }

        public void update()
        {
            input_processors();

            MiddleClassInformation.mute=mute;
            MiddleClassInformation.music=music_mute;

            mute_button();

            music_button();

            coin_update();

            update_block_chain();

            stats_update();

        }

        public void stats_update()
        {
            block_1_int=MiddleClassInformation.block_1_int;
            block_2_int=MiddleClassInformation.block_2_int;
            block_3_int=MiddleClassInformation.block_3_int;
            block_6_int=MiddleClassInformation.block_6_int;
            bomb_int=MiddleClassInformation.bomb_int;
            clock_int=MiddleClassInformation.clock_int;

            highest_score=MiddleClassInformation.global_high_score;
            coins_collected=MiddleClassInformation.coins_collected;

            highest_score_label.setText("HIGHEST SCORE "+highest_score);
            coins_collected_label.setText("COINS COLLECTED "+coins_collected);

            total_blocks_int=block_1_int+block_2_int+block_3_int+block_6_int+bomb_int+clock_int;
            total_blocks.setText("BLOCKS CLEARED "+total_blocks_int);

            highest_block_chain=total_block_chain;
            highest_block_chain_label.setText("HIGHEST BLOCK CHAIN "+highest_block_chain);

            block_1_label.setText(""+block_1_int);
            block_2_label.setText(""+block_2_int);
            block_3_label.setText(""+block_3_int);
            block_6_label.setText(""+block_6_int);
            bomb_label.setText(""+bomb_int);
            clock_label.setText(""+clock_int);
        }

        public void coin_update()
        {
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
        }

        public void update_block_chain()
        {
            if(total_block_chain<MiddleClassInformation.highest_block_1_chain)
            {
                total_block_chain=MiddleClassInformation.highest_block_1_chain;
                MiddleClassInformation.total_block_chain=total_block_chain;
            }
            else if(total_block_chain<MiddleClassInformation.highest_block_2_chain)
            {
                total_block_chain=MiddleClassInformation.highest_block_2_chain;
                MiddleClassInformation.total_block_chain=total_block_chain;
            }
            else if(total_block_chain<MiddleClassInformation.highest_block_3_chain)
            {
                total_block_chain=MiddleClassInformation.highest_block_3_chain;
                MiddleClassInformation.total_block_chain=total_block_chain;
            }
            else if(total_block_chain<MiddleClassInformation.highest_block_6_chain)
            {
                total_block_chain=MiddleClassInformation.highest_block_6_chain;
                MiddleClassInformation.total_block_chain=total_block_chain;
            }
        }

        public void draw(){
            stage.draw();
        }

        public void draw_little_menu()
        {
            little_menu_stage.draw();
        }

        public void draw_stats()
        {
            stats_stage.draw();
        }

        public void draw_credits(){credits_stage.draw();}

        public void draw_help_menu()
        {
            help_menu_elements.draw();
        }

        public void draw_mode_stage()
        {
            mode_stage.draw();
        }

        public void dispose(){

            help_button_texture.dispose();
            play_button_texture.dispose();
            shop_button_texture.dispose();
            bloxet_title.dispose();
            more_button_texture.dispose();
            mute_button_texture.dispose();
            stats_button_texture.dispose();
            credits_button_texture.dispose();
            back_button_texture.dispose();
            coin.dispose();
            block_1_texture.dispose();
            block_2_texture.dispose();
            block_3_texture.dispose();
            block_6_texture.dispose();
            bomb_texture.dispose();
            clock_texture.dispose();
            mute_button_mute_texture.dispose();
            extra_menus_texture.dispose();
            medium_button_texture.dispose();
            hard_button_texture.dispose();
            panel_texture.dispose();
            new_game_texture.dispose();

            bitmapFont.dispose();

            stage.dispose();
            little_menu_stage.dispose();
            stats_stage.dispose();
            credits_stage.dispose();
            mode_stage.dispose();
            help_menu_elements.dispose();
        }

    }

