package com.jgntic.bloxet.Managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.jgntic.bloxet.Blocks.Blocks_Manager;
import com.jgntic.bloxet.Bloxet;
import com.jgntic.bloxet.PlayScreen;
import com.jgntic.bloxet.Screens.MenuScreen;
import com.jgntic.bloxet.TouchInput;


/**
 * Created by IVAN on 30.5.2016 г..
 */
public class Play_Elements {

    public Stage stage,pause_menu,game_over_stage,bonus_stage,clock_stage,infinite_mode_game_over_stage,
    completed_mode_stage;

    Viewport viewport;
    Bloxet game;

    public boolean pause_menu_draw;
    public boolean game_over_draw;

    int coins_count;
    int score;
    int high_score;
    int chain_16s_int;

    Texture pause_button,coin,resume_button,menu_button,end_game_button,continue_button,
    game_over_back_texture,game_over_texture,pause_texture,mode_completed_texture;

    Image pause_button_image,coin_image,back_image,resume_button_image,menu_button_image,
    game_over_back_image,end_game_button_image,continue_button_image,game_over_image,pause_image,
    compl_chain_16s_image,compl_end_game_button,compl_back_image,mode_completed_image;

    Texture level_1_texture,level_2_texture,level_3_texture,level_4_texture,level_5_texture,level_6_texture,
            level_7_texture,level_8_texture,level_9_texture;
    Image level_1_image,level_2_image,level_3_image,level_4_image,level_5_image,level_6_image,
            level_7_image,level_8_image,level_9_image;

    Texture bonus_500,chain_16s,clock_5sec;
    Image bonus_500_image,chain_16s_image,clock_5sec_image;

    //infinity mode stage
    Image inf_game_over_back_image,inf_end_game_button,inf_game_over_image,inf_chain_16s_image;

    Label.LabelStyle font,score_font;

    Label coin_label,score_label,high_score_label,game_over_score,chain_16s_label,
            inf_game_over_score, inf_chain_16s_label,inf_high_score_label,
            compl_game_over_score,compl_chain_16s_label,compl_high_score_label;

    BitmapFont bitmapFont;

    GestureDetector gestureDetector;
    TouchInput touchInput;

    InputMultiplexer inputMultiplexer;

    Update_DataPreferences update_dataPreferences;
    boolean updateDataPrefs=false;
    boolean stopUpdating=false;

    PlayScreen playScreen;

    public Play_Elements(SpriteBatch spriteBatch,Bloxet game,PlayScreen playScreen)
    {
        this.game=game;
        this.playScreen=playScreen;

        pause_menu_draw=false;
        game_over_draw=false;

        viewport=new FitViewport(Bloxet.WIDTH,Bloxet.HEIGHT);

        stage=new Stage(viewport,spriteBatch);
        pause_menu=new Stage(viewport,spriteBatch);
        game_over_stage=new Stage(viewport,spriteBatch);
        bonus_stage=new Stage(viewport,spriteBatch);
        clock_stage=new Stage(viewport,spriteBatch);
        infinite_mode_game_over_stage=new Stage(viewport,spriteBatch);
        completed_mode_stage=new Stage(viewport,spriteBatch);

        //Input processors
        inputMultiplexer=new InputMultiplexer();

        touchInput=new TouchInput(game);
        gestureDetector=new GestureDetector(touchInput);

        inputMultiplexer.addProcessor(stage);
        inputMultiplexer.addProcessor(gestureDetector);
        //Input processor


        pause_button =game.assetManager.get("buttons/pause_button.png");
        pause_button.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        pause_button_image =new Image(pause_button);
        pause_button_image.setSize(50, 50);
        pause_button_image.setPosition(20, 735);
        pause_button_image.setColor(1, 1, 1, 0.8f);

        coin=game.assetManager.get("coin.png");
        coin.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        coin_image=new Image(coin);
        coin_image.setSize(25,25);
        coin_image.setPosition(430,750);
        coin_image.setColor(1,1,1,0.8f);

        game_over_back_texture=game.assetManager.get("background_picture.png");

        back_image=new Image(game_over_back_texture);
        back_image.setSize(480,800);
        back_image.setPosition(0,0);
        back_image.setColor(0.3f,0.3f,0.4f,0.8f);

        game_over_back_image=new Image(game_over_back_texture);
        game_over_back_image.setSize(480,800);
        game_over_back_image.setPosition(0,0);
        game_over_back_image.setColor(0.3f,0.3f,0.4f,0.8f);

        resume_button=game.assetManager.get("buttons/resume_button_test.png");
        resume_button.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        resume_button_image=new Image(resume_button);
        resume_button_image.setSize(250,100);
        resume_button_image.setPosition(back_image.getWidth()/2-resume_button_image.getWidth()/2,350);

        menu_button=game.assetManager.get("buttons/menu_button_test.png");
        menu_button.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        menu_button_image=new Image(menu_button);
        menu_button_image.setSize(250,100);
        menu_button_image.setPosition(back_image.getWidth()/2-menu_button_image.getWidth()/2,200);

        end_game_button=game.assetManager.get("buttons/end_game_button.png");
        end_game_button.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        end_game_button_image=new Image(end_game_button);
        end_game_button_image.setSize(250,100);
        end_game_button_image.setPosition((game_over_back_image.getX()+game_over_back_image.getWidth()/2)-end_game_button_image.getWidth()/2,
                ( game_over_back_image.getY()+end_game_button_image.getHeight()*2));

        continue_button=game.assetManager.get("buttons/continue_button.png");
        continue_button.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        continue_button_image=new Image(continue_button);
        continue_button_image.setSize(250,100);
        continue_button_image.setPosition((game_over_back_image.getX()+game_over_back_image.getWidth()/2)-continue_button_image.getWidth()/2,
                (game_over_back_image.getY())+continue_button_image.getHeight()-30);

        bitmapFont=game.assetManager.get("font/bloxet_font.fnt");

        font=new Label.LabelStyle(new BitmapFont(), Color.YELLOW);
        font.font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear,Texture.TextureFilter.Linear);

        score_font=new Label.LabelStyle(bitmapFont, Color.WHITE);
        score_font.font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear,Texture.TextureFilter.Linear);

        coin_label=new Label(""+coins_count,font);
        coin_label.setPosition(coin_image.getX()-20,coin_image.getY()+coin_label.getHeight()-15);
        coin_label.setFontScale(2);

        score_label=new Label("SCORE: "+score,score_font);
        score_label.setPosition(back_image.getX()+20,750);
        score_label.setFontScale(1.5f);

        game_over_score=new Label("SCORE: "+score,score_font);
        game_over_score.setPosition((game_over_back_image.getX()+40),
                (game_over_back_image.getY()+game_over_back_image.getHeight())-game_over_score.getHeight()-250);
        game_over_score.setFontScale(1.5f);

        high_score_label=new Label("HIGH SCORE: "+high_score,score_font);
        high_score_label.setPosition((game_over_back_image.getX()+40),
                (game_over_back_image.getY()+game_over_back_image.getHeight())-high_score_label.getHeight()-310);
        high_score_label.setFontScale(1.8f);

        bonus_500 =game.assetManager.get("bonus_500.png");
        bonus_500.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        bonus_500_image =new Image(bonus_500);
        bonus_500_image.setSize(250, 150);
        bonus_500_image.setPosition(Bloxet.WIDTH/2- bonus_500_image.getWidth()/2,Bloxet.HEIGHT/2- bonus_500_image.getHeight()/2);

        chain_16s=game.assetManager.get("chain_16s.png");
        chain_16s.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        chain_16s_image=new Image(chain_16s);
        chain_16s_image.setSize(140,80);
        chain_16s_image.setPosition(high_score_label.getX(),high_score_label.getY()-chain_16s_image.getHeight()-20);

        chain_16s_label=new Label(": "+chain_16s_int,score_font);
        chain_16s_label.setPosition(chain_16s_image.getX()+chain_16s_image.getWidth()-10,chain_16s_image.getY()+15);
        chain_16s_label.setFontScale(2);

        game_over_texture=game.assetManager.get("game_over.png");
        game_over_texture.setFilter(Texture.TextureFilter.Linear,Texture.TextureFilter.Linear);

        game_over_image=new Image(game_over_texture);
        game_over_image.setPosition(game_over_back_image.getWidth()/2-game_over_image.getWidth()/2+67,game_over_back_image.getHeight()-200);
        game_over_image.setSize(400,100);

        pause_texture=game.assetManager.get("pause.png");
        pause_texture.setFilter(Texture.TextureFilter.Linear,Texture.TextureFilter.Linear);

        pause_image=new Image(pause_texture);
        pause_image.setPosition(back_image.getWidth()/2-pause_image.getWidth()/2+10,550);
        pause_image.setSize(300,100);

        clock_5sec=game.assetManager.get("clock_5sec.png");
        clock_5sec.setFilter(Texture.TextureFilter.Linear,Texture.TextureFilter.Linear);

        clock_5sec_image=new Image(clock_5sec);
        clock_5sec_image.setPosition(Bloxet.WIDTH/2- clock_5sec_image.getWidth()/2-20,Bloxet.HEIGHT/2- clock_5sec_image.getHeight()/2+50);
        clock_5sec_image.setSize(150,80);

        //infinity mode game over stage
        inf_game_over_back_image=new Image(game_over_back_texture);
        inf_game_over_back_image.setSize(480,800);
        inf_game_over_back_image.setPosition(0,0);
        inf_game_over_back_image.setColor(0.3f,0.3f,0.4f,0.8f);

        inf_game_over_image=new Image(game_over_texture);
        inf_game_over_image.setPosition(inf_game_over_back_image.getWidth()/2-inf_game_over_image.getWidth()/2+67,inf_game_over_back_image.getHeight()-200);
        inf_game_over_image.setSize(400,100);

        inf_end_game_button=new Image(end_game_button);
        inf_end_game_button.setSize(250,100);
        inf_end_game_button.setPosition((inf_game_over_back_image.getX()+inf_game_over_back_image.getWidth()/2)-inf_end_game_button.getWidth()/2,
                ( inf_game_over_back_image.getY()+inf_end_game_button.getHeight()*2));

        inf_game_over_score=new Label("SCORE: "+score,score_font);
        inf_game_over_score.setPosition((inf_game_over_back_image.getX()+40),
                (inf_game_over_back_image.getY()+inf_game_over_back_image.getHeight())-inf_game_over_score.getHeight()-250);
        inf_game_over_score.setFontScale(1.5f);

        inf_high_score_label=new Label("HIGH SCORE: "+high_score,score_font);
        inf_high_score_label.setPosition((inf_game_over_back_image.getX()+40),
                (inf_game_over_back_image.getY()+inf_game_over_back_image.getHeight())-inf_high_score_label.getHeight()-310);
        inf_high_score_label.setFontScale(1.8f);

        inf_chain_16s_image=new Image(chain_16s);
        inf_chain_16s_image.setSize(140,80);
        inf_chain_16s_image.setPosition(inf_high_score_label.getX(),inf_high_score_label.getY()-inf_chain_16s_image.getHeight()-20);

        inf_chain_16s_label=new Label(": "+chain_16s_int,score_font);
        inf_chain_16s_label.setPosition(inf_chain_16s_image.getX()+inf_chain_16s_image.getWidth()-10,inf_chain_16s_image.getY()+15);
        inf_chain_16s_label.setFontScale(2);

        //completed mode stage
        compl_back_image=new Image(game_over_back_texture);
        compl_back_image.setSize(480,800);
        compl_back_image.setPosition(0,0);
        compl_back_image.setColor(0.3f,0.3f,0.4f,0.8f);

        compl_end_game_button=new Image(end_game_button);
        compl_end_game_button.setSize(250,100);
        compl_end_game_button.setPosition((compl_back_image.getX()+compl_back_image.getWidth()/2)-compl_end_game_button.getWidth()/2,
                ( compl_back_image.getY()+compl_end_game_button.getHeight()*2));

        compl_game_over_score=new Label("SCORE: "+score,score_font);
        compl_game_over_score.setPosition((compl_back_image.getX()+40),
                (compl_back_image.getY()+compl_back_image.getHeight())-compl_game_over_score.getHeight()-250);
        compl_game_over_score.setFontScale(1.5f);

        compl_high_score_label=new Label("HIGH SCORE: "+high_score,score_font);
        compl_high_score_label.setPosition((compl_back_image.getX()+40),
                (compl_back_image.getY()+compl_back_image.getHeight())-compl_high_score_label.getHeight()-310);
        compl_high_score_label.setFontScale(1.8f);

        compl_chain_16s_image=new Image(chain_16s);
        compl_chain_16s_image.setSize(140,80);
        compl_chain_16s_image.setPosition(compl_high_score_label.getX(),compl_high_score_label.getY()-compl_chain_16s_image.getHeight()-20);

        compl_chain_16s_label=new Label(": "+chain_16s_int,score_font);
        compl_chain_16s_label.setPosition(compl_chain_16s_image.getX()+compl_chain_16s_image.getWidth()-10,compl_chain_16s_image.getY()+15);
        compl_chain_16s_label.setFontScale(2);

        mode_completed_texture=game.assetManager.get("mode_completed.png");
        mode_completed_texture.setFilter(Texture.TextureFilter.Linear,Texture.TextureFilter.Linear);

        mode_completed_image=new Image(mode_completed_texture);
        mode_completed_image.setPosition(Bloxet.WIDTH/2-mode_completed_image.getWidth()/2+65,compl_back_image.getHeight()-200);
        mode_completed_image.setSize(400,100);

        levels();

        listeners();

        stage.addActor(pause_button_image);
        stage.addActor(coin_image);
        stage.addActor(coin_label);

        pause_menu.addActor(back_image);
        pause_menu.addActor(resume_button_image);
        pause_menu.addActor(menu_button_image);
        pause_menu.addActor(score_label);
        pause_menu.addActor(pause_image);

        game_over_stage.addActor(game_over_back_image);
        game_over_stage.addActor(end_game_button_image);
        game_over_stage.addActor(continue_button_image);
        game_over_stage.addActor(game_over_score);
        game_over_stage.addActor(high_score_label);
        game_over_stage.addActor(chain_16s_image);
        game_over_stage.addActor(chain_16s_label);
        game_over_stage.addActor(game_over_image);

        bonus_stage.addActor(bonus_500_image);
        clock_stage.addActor(clock_5sec_image);

        infinite_mode_game_over_stage.addActor(inf_game_over_back_image);
        infinite_mode_game_over_stage.addActor(inf_end_game_button);
        infinite_mode_game_over_stage.addActor(inf_game_over_image);
        infinite_mode_game_over_stage.addActor(inf_game_over_score);
        infinite_mode_game_over_stage.addActor(inf_high_score_label);
        infinite_mode_game_over_stage.addActor(inf_chain_16s_image);
        infinite_mode_game_over_stage.addActor(inf_chain_16s_label);

        completed_mode_stage.addActor(compl_back_image);
        completed_mode_stage.addActor(compl_end_game_button);
        completed_mode_stage.addActor(compl_game_over_score);
        completed_mode_stage.addActor(compl_high_score_label);
        completed_mode_stage.addActor(compl_chain_16s_image);
        completed_mode_stage.addActor(compl_chain_16s_label);
        completed_mode_stage.addActor(mode_completed_image);
    }

    void levels()
    {
        level_1_texture=game.assetManager.get("levels/level_1.png");
        level_1_texture.setFilter(Texture.TextureFilter.Linear,Texture.TextureFilter.Linear);

        level_1_image=new Image(level_1_texture);
        level_1_image.setSize(200/Bloxet.PPM,80/Bloxet.PPM);
        level_1_image.setPosition(Bloxet.WIDTH/2/Bloxet.PPM-level_1_image.getWidth()/2,500/Bloxet.PPM);

        level_2_texture=game.assetManager.get("levels/level_2.png");
        level_2_texture.setFilter(Texture.TextureFilter.Linear,Texture.TextureFilter.Linear);

        level_2_image=new Image(level_2_texture);
        level_2_image.setSize(200/Bloxet.PPM,80/Bloxet.PPM);
        level_2_image.setPosition(Bloxet.WIDTH/2/Bloxet.PPM-level_2_image.getWidth()/2,500/Bloxet.PPM);

        level_3_texture=game.assetManager.get("levels/level_3.png");
        level_3_texture.setFilter(Texture.TextureFilter.Linear,Texture.TextureFilter.Linear);

        level_3_image=new Image(level_3_texture);
        level_3_image.setSize(200/Bloxet.PPM,80/Bloxet.PPM);
        level_3_image.setPosition(Bloxet.WIDTH/2/Bloxet.PPM-level_3_image.getWidth()/2,500/Bloxet.PPM);

        level_4_texture=game.assetManager.get("levels/level_4.png");
        level_4_texture.setFilter(Texture.TextureFilter.Linear,Texture.TextureFilter.Linear);

        level_4_image=new Image(level_4_texture);
        level_4_image.setSize(200/Bloxet.PPM,80/Bloxet.PPM);
        level_4_image.setPosition(Bloxet.WIDTH/2/Bloxet.PPM-level_4_image.getWidth()/2,500/Bloxet.PPM);

        level_5_texture=game.assetManager.get("levels/level_5.png");
        level_5_texture.setFilter(Texture.TextureFilter.Linear,Texture.TextureFilter.Linear);

        level_5_image=new Image(level_5_texture);
        level_5_image.setSize(200/Bloxet.PPM,80/Bloxet.PPM);
        level_5_image.setPosition(Bloxet.WIDTH/2/Bloxet.PPM-level_5_image.getWidth()/2,500/Bloxet.PPM);

        level_6_texture=game.assetManager.get("levels/level_6.png");
        level_6_texture.setFilter(Texture.TextureFilter.Linear,Texture.TextureFilter.Linear);

        level_6_image=new Image(level_6_texture);
        level_6_image.setSize(200/Bloxet.PPM,80/Bloxet.PPM);
        level_6_image.setPosition(Bloxet.WIDTH/2/Bloxet.PPM-level_6_image.getWidth()/2,500/Bloxet.PPM);

        level_7_texture=game.assetManager.get("levels/level_7.png");
        level_7_texture.setFilter(Texture.TextureFilter.Linear,Texture.TextureFilter.Linear);

        level_7_image=new Image(level_7_texture);
        level_7_image.setSize(200/Bloxet.PPM,80/Bloxet.PPM);
        level_7_image.setPosition(Bloxet.WIDTH/2/Bloxet.PPM-level_7_image.getWidth()/2,500/Bloxet.PPM);

        level_8_texture=game.assetManager.get("levels/level_8.png");
        level_8_texture.setFilter(Texture.TextureFilter.Linear,Texture.TextureFilter.Linear);

        level_8_image=new Image(level_8_texture);
        level_8_image.setSize(200/Bloxet.PPM,80/Bloxet.PPM);
        level_8_image.setPosition(Bloxet.WIDTH/2/Bloxet.PPM-level_8_image.getWidth()/2,500/Bloxet.PPM);

        level_9_texture=game.assetManager.get("levels/level_9.png");
        level_9_texture.setFilter(Texture.TextureFilter.Linear,Texture.TextureFilter.Linear);

        level_9_image=new Image(level_9_texture);
        level_9_image.setSize(200/Bloxet.PPM,80/Bloxet.PPM);
        level_9_image.setPosition(Bloxet.WIDTH/2/Bloxet.PPM-level_9_image.getWidth()/2,500/Bloxet.PPM);
    }

    public void listeners(){

        pause_button_image.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                pause_button_image.setColor(1, 1, 1, 0.3f);

                if(MiddleClassInformation.mute==0)
                {
                    game.assetManager.get("sound_effects/button_click.ogg", Sound.class).play();
                }

                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                pause_button_image.setColor(1, 1, 1, 0.6f);

                Gdx.input.setInputProcessor(pause_menu);
                pause_menu_draw=true;

            }
        });

        resume_button_image.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                resume_button_image.setColor(1, 1, 1, 0.5f);

                if(MiddleClassInformation.mute==0)
                {
                    game.assetManager.get("sound_effects/button_click.ogg", Sound.class).play();
                }

                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                resume_button_image.setColor(1, 1, 1, 1f);

                Gdx.input.setInputProcessor(stage);

                pause_menu_draw=false;

            }
        });

        menu_button_image.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                menu_button_image.setColor(1, 1, 1, 0.5f);

                if(MiddleClassInformation.mute==0)
                {
                    game.assetManager.get("sound_effects/button_click.ogg", Sound.class).play();
                }

                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                menu_button_image.setColor(1, 1, 1, 1f);

                MiddleClassInformation.rows=0;
                game.setScreen(new MenuScreen(game));
            }
        });

        end_game_button_image.addListener(
                new InputListener() {
                    @Override
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        end_game_button_image.setColor(1, 1, 1, 0.5f);

                        if(MiddleClassInformation.mute==0)
                        {
                            game.assetManager.get("sound_effects/button_click.ogg", Sound.class).play();
                        }

                        return true;
                    }

                    @Override
                    public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                        end_game_button_image.setColor(1, 1, 1, 1f);

                        MiddleClassInformation.rows=0;
                        game.setScreen(new MenuScreen(game));
                    }
                }
        );

        inf_end_game_button.addListener(
                new InputListener() {
                    @Override
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        inf_end_game_button.setColor(1, 1, 1, 0.5f);

                        if(MiddleClassInformation.mute==0)
                        {
                            game.assetManager.get("sound_effects/button_click.ogg", Sound.class).play();
                        }

                        return true;
                    }

                    @Override
                    public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                        inf_end_game_button.setColor(1, 1, 1, 1f);

                        MiddleClassInformation.rows=0;
                        game.setScreen(new MenuScreen(game));
                    }
                }
        );

        continue_button_image.addListener(
                new InputListener() {
                    @Override
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        continue_button_image.setColor(1, 1, 1, 0.5f);

                        if(MiddleClassInformation.mute==0)
                        {
                            game.assetManager.get("sound_effects/button_click.ogg", Sound.class).play();
                        }

                        return true;
                    }

                    @Override
                    public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                        continue_button_image.setColor(1, 1, 1, 1f);

                        if(MiddleClassInformation.coins_count>=100)
                        {
                            MiddleClassInformation.coins_count-=100;
                            MiddleClassInformation.global_score-= Blocks_Manager.level_score;
                            Blocks_Manager.level_score=0;

                            game.setScreen(new PlayScreen(game));
                        }

                    }
                }
        );

        compl_end_game_button.addListener(
                new InputListener() {
                    @Override
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        compl_end_game_button.setColor(1, 1, 1, 0.5f);

                        if(MiddleClassInformation.mute==0)
                        {
                            game.assetManager.get("sound_effects/button_click.ogg", Sound.class).play();
                        }

                        return true;
                    }

                    @Override
                    public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                        compl_end_game_button.setColor(1, 1, 1, 1f);

                        MiddleClassInformation.rows=0;
                        game.setScreen(new MenuScreen(game));
                    }
                }
        );
    }

    public void update()
    {
        coins_count=MiddleClassInformation.coins_count;

        score=MiddleClassInformation.global_score;

        chain_16s_int=MiddleClassInformation.chain16s;

        if(TIMER.stop_timer || playScreen.nextLevel.game_over_18 || playScreen.nextLevel.completed)
        {
            high_score=MiddleClassInformation.global_high_score;

            if(high_score<score)
            {
                high_score=score;
                MiddleClassInformation.global_high_score=high_score;

                high_score_label.setText("HIGH SCORE: "+high_score);
                inf_high_score_label.setText("HIGH SCORE: "+high_score);
                compl_high_score_label.setText("HIGH SCORE: "+high_score);
            }
            else
            {
                high_score_label.setText("HIGH SCORE: "+high_score);
                inf_high_score_label.setText("HIGH SCORE: "+high_score);
                compl_high_score_label.setText("HIGH SCORE: "+high_score);
            }

            updateDataPrefs=true;

            if(!playScreen.nextLevel.completed)
            {
                game_over_draw=true;
            }

            if(MiddleClassInformation.infinity_mode)
            {
                Gdx.input.setInputProcessor(infinite_mode_game_over_stage);

            }
            else if(playScreen.nextLevel.completed)
            {
                Gdx.input.setInputProcessor(completed_mode_stage);
            }
            else
            {
                Gdx.input.setInputProcessor(game_over_stage);
            }
        }
        else
        {
            Gdx.input.setInputProcessor(inputMultiplexer);
        }

        if(updateDataPrefs && !stopUpdating)
        {
            update_dataPreferences=new Update_DataPreferences(game);
            stopUpdating=true;
        }

        coin_label.setText(""+coins_count);
        score_label.setText("SCORE: "+score);
        game_over_score.setText("SCORE: "+score);
        chain_16s_label.setText(": "+chain_16s_int);

        inf_game_over_score.setText("SCORE: "+score);
        inf_chain_16s_label.setText(": "+chain_16s_int);

        compl_game_over_score.setText("SCORE: "+score);
        compl_chain_16s_label.setText(": "+chain_16s_int);

       coin_position();

    }

    private void coin_position()
    {
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
    }

    public void draw(){
        stage.draw();
    }

    public void draw_pause_menu(){
        pause_menu.draw();
    }

    public void draw_game_over_stage(){
        game_over_stage.draw();
    }

    public void draw_infinite_mode_game_over_stage()
    {
        infinite_mode_game_over_stage.draw();
    }

    public void draw_completed_mode_stage(){
        completed_mode_stage.draw();
    }

    public void draw_levels(RandomBodyCreated randomBodyCreated)
    {
       if(!MiddleClassInformation.infinity_mode)
       {
           if(MiddleClassInformation.level==1)
           {
               if(randomBodyCreated.generate)
               {
                   level_1_image.draw(game.batch,1);
               }
           }
           else if(MiddleClassInformation.level==2)
           {
               if(randomBodyCreated.generate)
               {
                   level_2_image.draw(game.batch,1);
               }
           }
           else if(MiddleClassInformation.level==3)
           {
               if(randomBodyCreated.generate)
               {
                   level_3_image.draw(game.batch,1);
               }
           }
           else if(MiddleClassInformation.level==4)
           {
               if(randomBodyCreated.generate)
               {
                   level_4_image.draw(game.batch,1);
               }
           }
           else if(MiddleClassInformation.level==5)
           {
               if(randomBodyCreated.generate)
               {
                   level_5_image.draw(game.batch,1);
               }
           }
           else if(MiddleClassInformation.level==6)
           {
               if(randomBodyCreated.generate)
               {
                   level_6_image.draw(game.batch,1);
               }
           }
           else if(MiddleClassInformation.level==7)
           {
               if(randomBodyCreated.generate)
               {
                   level_7_image.draw(game.batch,1);
               }
           }
           else if(MiddleClassInformation.level==8)
           {
               if(randomBodyCreated.generate)
               {
                   level_8_image.draw(game.batch,1);
               }
           }
           else if(MiddleClassInformation.level==9)
           {
               if(randomBodyCreated.generate)
               {
                   level_9_image.draw(game.batch,1);
               }
           }
       }

    }

    public void draw_bonus_stage()
    {
        bonus_stage.draw();
    }

    public void draw_clock_stage()
    {
        clock_stage.draw();
    }

    public void dispose(){

        pause_button.dispose();
        coin.dispose();
        resume_button.dispose();
        menu_button.dispose();
        end_game_button.dispose();
        continue_button.dispose();
        game_over_back_texture.dispose();
        game_over_texture.dispose();
        pause_texture.dispose();
        bonus_500.dispose();
        chain_16s.dispose();
        clock_5sec.dispose();

        level_1_texture.dispose();
        level_2_texture.dispose();
        level_3_texture.dispose();
        level_4_texture.dispose();
        level_5_texture.dispose();
        level_6_texture.dispose();
        level_7_texture.dispose();
        level_8_texture.dispose();
        level_9_texture.dispose();

        bitmapFont.dispose();

        stage.dispose();
        pause_menu.dispose();
        game_over_stage.dispose();
        bonus_stage.draw();

    }
}
