package com.jgntic.bloxet.Managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.jgntic.bloxet.Blocks.Time_Block.Time_Block;
import com.jgntic.bloxet.Bloxet;

/**
 * Created by IVAN on 31.5.2016 г..
 */
public class TIMER extends Stage{

    Stage stage;
    Viewport viewport;
    Bloxet game;

    Texture back_texture,texture_1,texture_2,texture_3;
    Image count_down_image,image_1,image_2,image_3;

    Label.LabelStyle font;
    Label count_down_label;

    BitmapFont bitmapFont;

    int minutes;
    int seconds;

    float stateTimer;
    float count_down_timer;

    public static boolean stop_timer;

    RandomBodyCreated randomBodyCreated;

    boolean count_timer;

    Update_DataPreferences update_dataPreferences;

    boolean game_over=false;
    boolean stop_updating_data_preferences=false;

    public TIMER(SpriteBatch spriteBatch,Bloxet game,RandomBodyCreated randomBodyCreated)
    {
        this.randomBodyCreated=randomBodyCreated;
        this.game=game;

        stop_timer=false;
        count_timer=false;

        timer_set();

        viewport=new FitViewport(Bloxet.WIDTH,Bloxet.HEIGHT);
        stage=new Stage(viewport,spriteBatch);

        stateTimer=0;
        count_down_timer=0;

        back_texture=game.assetManager.get("dbg_block1.png");
        back_texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        count_down_image=new Image(back_texture);
        count_down_image.setSize(100,50);
        count_down_image.setPosition(Bloxet.WIDTH/2-count_down_image.getWidth()/2,735);
        count_down_image.setColor(1,1,1,0.2f);

        bitmapFont=game.assetManager.get("font/bloxet_font.fnt");

        font=new Label.LabelStyle(bitmapFont, Color.WHITE);
        font.font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear,Texture.TextureFilter.Linear);

        count_down_label=new Label("0"+minutes +":"+ seconds,font);
        count_down_label.setPosition((Bloxet.WIDTH/2-count_down_label.getWidth()/2)-15,745);
        count_down_label.setFontScale(1.5f);

        texture_1=game.assetManager.get("timer/1.png");
        texture_1.setFilter(Texture.TextureFilter.Linear,Texture.TextureFilter.Linear);

        image_1=new Image(texture_1);
        image_1.setSize(100/Bloxet.PPM,150/Bloxet.PPM);
        image_1.setPosition((Bloxet.WIDTH/2/Bloxet.PPM)-image_1.getWidth()/2,300/Bloxet.PPM);

        texture_2=game.assetManager.get("timer/2.png");
        texture_2.setFilter(Texture.TextureFilter.Linear,Texture.TextureFilter.Linear);

        image_2=new Image(texture_2);
        image_2.setSize(100/Bloxet.PPM,150/Bloxet.PPM);
        image_2.setPosition((Bloxet.WIDTH/2/Bloxet.PPM)-image_2.getWidth()/2,300/Bloxet.PPM);

        texture_3=game.assetManager.get("timer/3.png");
        texture_3.setFilter(Texture.TextureFilter.Linear,Texture.TextureFilter.Linear);

        image_3=new Image(texture_3);
        image_3.setSize(100/Bloxet.PPM,150/Bloxet.PPM);
        image_3.setPosition((Bloxet.WIDTH/2/Bloxet.PPM)-image_3.getWidth()/2,300/Bloxet.PPM);

        stage.addActor(count_down_image);
        stage.addActor(count_down_label);
    }

    void timer_set()
    {
        if(!MiddleClassInformation.infinity_mode)
        {
            if(MiddleClassInformation.level==1)
            {
                if(MiddleClassInformation.medium_mode)
                {
                    minutes=1;
                    seconds=20;
                }
                else if(MiddleClassInformation.hard_mode)
                {
                    minutes=0;
                    seconds=38;
                }

            }
            else if (MiddleClassInformation.level==2)
            {
                if(MiddleClassInformation.medium_mode)
                {
                    minutes=1;
                    seconds=45;
                }
                else if(MiddleClassInformation.hard_mode)
                {
                    minutes=1;
                    seconds=10;
                }
            }
            else if(MiddleClassInformation.level==3)
            {
                if(MiddleClassInformation.medium_mode)
                {
                    minutes=1;
                    seconds=59;
                }
                else if(MiddleClassInformation.hard_mode)
                {
                    minutes=1;
                    seconds=25;
                }
            }
            else if(MiddleClassInformation.level==4)
            {
                if(MiddleClassInformation.medium_mode)
                {
                    minutes=2;
                    seconds=30;
                }
                else if(MiddleClassInformation.hard_mode)
                {
                    minutes=1;
                    seconds=45;
                }
            }
            else if(MiddleClassInformation.level==5)
            {
                if(MiddleClassInformation.medium_mode)
                {
                    minutes=2;
                    seconds=55;
                }
                else if(MiddleClassInformation.hard_mode)
                {
                    minutes=2;
                    seconds=10;
                }
            }
            else if(MiddleClassInformation.level==6)
            {
                if(MiddleClassInformation.medium_mode)
                {
                    minutes=3;
                    seconds=25;
                }
                else if(MiddleClassInformation.hard_mode)
                {
                    minutes=2;
                    seconds=35;
                }
            }
            else if(MiddleClassInformation.level==7)
            {
                if(MiddleClassInformation.medium_mode)
                {
                    minutes=3;
                    seconds=30;
                }
                else if(MiddleClassInformation.hard_mode)
                {
                    minutes=2;
                    seconds=40;
                }
            }
            else if(MiddleClassInformation.level==8)
            {
                if(MiddleClassInformation.medium_mode)
                {
                    minutes=4;
                    seconds=10;
                }
                else if(MiddleClassInformation.hard_mode)
                {
                    minutes=3;
                    seconds=20;
                }
            }
            else if(MiddleClassInformation.level==9)
            {
                if(MiddleClassInformation.medium_mode)
                {
                    minutes=3;
                    seconds=40;
                }
                else if(MiddleClassInformation.hard_mode)
                {
                    minutes=3;
                    seconds=15;
                }
            }
            else
            {
                minutes=0;
                seconds=0;
            }
        }
        else
        {
            minutes=1;
            seconds=20;
        }
    }

    public void update(){

          if(count_timer)
          {
              stateTimer+=Gdx.graphics.getDeltaTime();

              if(!stop_timer && stateTimer>=1 )
              {
                  seconds -=1;

                  if(seconds<10)
                  {
                      count_down_label.setText("0"+minutes +":0"+ seconds);
                      if(seconds==0 && minutes>0)
                      {
                          minutes-=1;
                          seconds=59;

                          count_down_label.setText("0"+minutes +":"+ seconds);
                      }
                      else if( seconds==0 && minutes==0 )
                      {
                          if(!MiddleClassInformation.infinity_mode)
                          {
                              stop_timer=true;
                              System.out.println("GAME OVER");
                              game_over=true;
                          }
                          else
                          {
                              infinity_mode_generate(randomBodyCreated);

                              if(MiddleClassInformation.mute==0)
                              {
                                  game.assetManager.get("sound_effects/block_generate.ogg", Sound.class).play();
                              }

                             if(MiddleClassInformation.global_score>1000 && MiddleClassInformation.global_score<=4000)
                             {
                                 minutes=1;
                                 seconds=10;
                             }
                             else if(MiddleClassInformation.global_score>4000 && MiddleClassInformation.global_score<=7000)
                             {
                                 minutes=0;
                                 seconds=59;
                             }
                             else if(MiddleClassInformation.global_score>7000 && MiddleClassInformation.global_score<=10000)
                             {
                                 minutes=0;
                                 seconds=50;
                             }
                             else if(MiddleClassInformation.global_score>10000 && MiddleClassInformation.global_score<=20000)
                             {
                                 minutes=0;
                                 seconds=45;
                             }
                             else if(MiddleClassInformation.global_score>20000)
                             {
                                 minutes=0;
                                 seconds=30;
                             }
                             else
                             {
                                 minutes=1;
                                 seconds=20;
                             }
                          }
                      }
                  }
                  else
                  {
                      count_down_label.setText("0"+minutes +":"+ seconds);
                  }

                  stateTimer=0;
              }
          }

          if(Time_Block.deleteBlock)
          {
              seconds+=5;
          }

          if(game_over && !stop_updating_data_preferences)
          {
              update_dataPreferences=new Update_DataPreferences(game);
              stop_updating_data_preferences=true;
          }

    }

    public void infinity_mode_generate(RandomBodyCreated randomBodyCreated)
    {
        if(MiddleClassInformation.infinity_mode)
        {
           randomBodyCreated.infinity_rows_higher=0;

           randomBodyCreated.createBodies();

        }

    }

    public void draw()
    {
        stage.draw();
    }

    public void draw_countdown(SpriteBatch spriteBatch)
    {
        if(RandomBodyCreated.ready )
        {
            count_down_timer+=Gdx.graphics.getDeltaTime();

            if(count_down_timer<=1)
            {
                image_3.draw(spriteBatch,1);
            }
            else if(count_down_timer>1 && count_down_timer<=2)
            {
                image_2.draw(spriteBatch,1);
            }
            else if (count_down_timer>2 && count_down_timer<=3)
            {
                image_1.draw(spriteBatch,1);
            }
            else if(count_down_timer>3)
            {
                count_timer=true;
            }
        }
    }

    public void dispose()
    {
        back_texture.dispose();
        texture_1.dispose();
        texture_2.dispose();
        texture_3.dispose();

        bitmapFont.dispose();
    }

}
