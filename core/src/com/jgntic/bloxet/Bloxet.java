package com.jgntic.bloxet;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.jgntic.bloxet.Managers.DataPreferences;
import com.jgntic.bloxet.Managers.MiddleClassInformation;
import com.jgntic.bloxet.Screens.IntroScreen;
import com.jgntic.bloxet.Screens.MenuScreen;

import java.awt.Color;

public class Bloxet extends Game  {

    //Pixel per meter
    public static final float PPM=100;

    public static final int WIDTH=480;
    public static final int HEIGHT=800;

    public SpriteBatch batch;

    public AssetManager assetManager= new AssetManager();

    public DataPreferences dataPreferences;

    public boolean start_music=true;

	@Override
	public void create () {
        batch = new SpriteBatch();

        //textures
        assetManager.load("100.png",Texture.class);
        assetManager.load("150.png",Texture.class);
        assetManager.load("bonus_500.png",Texture.class);
        assetManager.load("background.png",Texture.class);
        assetManager.load("background_picture.png",Texture.class);
        assetManager.load("block_1.png",Texture.class);
        assetManager.load("block_2.png",Texture.class);
        assetManager.load("block_3.png",Texture.class);
        assetManager.load("block_6.png",Texture.class);
        assetManager.load("block_bomb.png",Texture.class);
        assetManager.load("block_bomb_invert.png",Texture.class);
        assetManager.load("bloxet_title_test.png",Texture.class);
        assetManager.load("bomb_shop.png",Texture.class);
        assetManager.load("clock.png",Texture.class);
        assetManager.load("clock_invert.png",Texture.class);
        assetManager.load("clock_shop.png",Texture.class);
        assetManager.load("coin.png",Texture.class);
        assetManager.load("dbg_block1.png",Texture.class);
        assetManager.load("dbg_block2.png",Texture.class);
        assetManager.load("dbg_block6.png",Texture.class);
        assetManager.load("transition_screen.png",Texture.class);
        assetManager.load("chain_16s.png",Texture.class);
        assetManager.load("clock_5sec.png",Texture.class);
        assetManager.load("game_over.png",Texture.class);
        assetManager.load("pause.png",Texture.class);
        assetManager.load("new_game.png",Texture.class);
        //buttons
        assetManager.load("buttons/back_button.png",Texture.class);
        assetManager.load("buttons/continue_button.png",Texture.class);
        assetManager.load("buttons/credits_button.png",Texture.class);
        assetManager.load("buttons/end_game_button.png",Texture.class);
        assetManager.load("buttons/help_button.png",Texture.class);
        assetManager.load("buttons/menu_button_test.png",Texture.class);
        assetManager.load("buttons/mute_button.png",Texture.class);
        assetManager.load("buttons/mute_button_mute.png",Texture.class);
        assetManager.load("buttons/pause_button.png",Texture.class);
        assetManager.load("buttons/play_button_new.png",Texture.class);
        assetManager.load("buttons/power_ups_button.png",Texture.class);
        assetManager.load("buttons/resume_button_test.png",Texture.class);
        assetManager.load("buttons/stats_button.png",Texture.class);
        assetManager.load("buttons/medium_button.png",Texture.class);
        assetManager.load("buttons/hard_button.png",Texture.class);
        assetManager.load("buttons/music_button.png",Texture.class);
        assetManager.load("buttons/music_button_mute.png",Texture.class);
        assetManager.load("buttons/infinity_button.png",Texture.class);
        assetManager.load("mode_completed.png",Texture.class);
        //levels
        assetManager.load("levels/level_1.png",Texture.class);
        assetManager.load("levels/level_2.png",Texture.class);
        assetManager.load("levels/level_3.png",Texture.class);
        assetManager.load("levels/level_4.png",Texture.class);
        assetManager.load("levels/level_5.png",Texture.class);
        assetManager.load("levels/level_6.png",Texture.class);
        assetManager.load("levels/level_7.png",Texture.class);
        assetManager.load("levels/level_8.png",Texture.class);
        assetManager.load("levels/level_9.png",Texture.class);
        //timer
        assetManager.load("timer/1.png",Texture.class);
        assetManager.load("timer/2.png",Texture.class);
        assetManager.load("timer/3.png",Texture.class);

        //fonts
        assetManager.load("font/bloxet_font.fnt",BitmapFont.class);
        assetManager.load("font/font_score.fnt",BitmapFont.class);
        //JGNTIC LOGO
        assetManager.load("jgntic_logo.png",Texture.class);

        //sound effects
        assetManager.load("sound_effects/block_landed.ogg", Sound.class);
        assetManager.load("sound_effects/blocks_cleared.ogg",Sound.class);
        assetManager.load("sound_effects/bomb_explosion.ogg",Sound.class);
        assetManager.load("sound_effects/button_click.ogg",Sound.class);
        assetManager.load("sound_effects/buy_power_ups.ogg",Sound.class);
        assetManager.load("sound_effects/clock.ogg",Sound.class);
        assetManager.load("sound_effects/blocks_move.ogg",Sound.class);
        assetManager.load("sound_effects/block_generate.ogg",Sound.class);

        //music
        assetManager.load("music/swing_mode.ogg", Music.class);
        assetManager.load("music/matrix.ogg",Music.class);

        assetManager.finishLoading();

        dataPreferences=new DataPreferences();

        set_saved_data();

        setScreen(new IntroScreen(this));

	}

	@Override
	public void render () {
       super.render();

        music();
	}

    private void music()
    {
        if(dataPreferences.music_prefs.getInteger("MUSIC")==1)
        {
            assetManager.get("music/swing_mode.ogg",Music.class).setOnCompletionListener(
                    new Music.OnCompletionListener() {
                        @Override
                        public void onCompletion(Music music) {
                            music.stop();
                            assetManager.get("music/matrix.ogg",Music.class).play();
                            assetManager.get("music/matrix.ogg",Music.class).setVolume(0f);
                        }
                    }
            );
            assetManager.get("music/matrix.ogg",Music.class).setOnCompletionListener(
                    new Music.OnCompletionListener(){
                        @Override
                        public void onCompletion(Music music) {
                            music.stop();
                            assetManager.get("music/swing_mode.ogg",Music.class).play();
                            assetManager.get("music/swing_mode.ogg",Music.class).setVolume(0f);
                        }
                    }
            );
        }
        else if(dataPreferences.music_prefs.getInteger("MUSIC")==0)
        {
            assetManager.get("music/swing_mode.ogg",Music.class).setOnCompletionListener(
                    new Music.OnCompletionListener() {
                        @Override
                        public void onCompletion(Music music) {
                            music.stop();
                            assetManager.get("music/matrix.ogg",Music.class).play();
                            assetManager.get("music/matrix.ogg",Music.class).setVolume(0.3f);
                        }
                    }
            );
            assetManager.get("music/matrix.ogg",Music.class).setOnCompletionListener(
                    new Music.OnCompletionListener(){
                        @Override
                        public void onCompletion(Music music) {
                            music.stop();
                            assetManager.get("music/swing_mode.ogg",Music.class).play();
                            assetManager.get("music/swing_mode.ogg",Music.class).setVolume(0.3f);
                        }
                    }
            );
        }

    }

    public void set_saved_data()
    {
        MiddleClassInformation.coins_count=dataPreferences.coins_count_prefs.getInteger("COINS_COUNT",0);
        MiddleClassInformation.time_count=dataPreferences.time_count_prefs.getInteger("TIME_COUNT",0);
        MiddleClassInformation.bomb_count=dataPreferences.bomb_count_prefs.getInteger("BOMB_COUNT",0);

        MiddleClassInformation.global_high_score=dataPreferences.global_high_score_prefs.getInteger("GLOBAL_HIGH_SCORE",0);

        MiddleClassInformation.mute=dataPreferences.mute_prefs.getInteger("MUTE",0);
        MiddleClassInformation.music=dataPreferences.music_prefs.getInteger("MUSIC",0);

        MiddleClassInformation.block_1_int=dataPreferences.block_1_int_prefs.getInteger("BLOCK_1_INT",0);
        MiddleClassInformation.block_2_int=dataPreferences.block_2_int_prefs.getInteger("BLOCK_2_INT",0);
        MiddleClassInformation.block_3_int=dataPreferences.block_3_int_prefs.getInteger("BLOCK_3_INT",0);
        MiddleClassInformation.block_6_int=dataPreferences.block_6_int_prefs.getInteger("BLOCK_6_INT",0);
        MiddleClassInformation.bomb_int=dataPreferences.bomb_int_prefs.getInteger("BOMB_INT",0);
        MiddleClassInformation.clock_int=dataPreferences.clock_int_prefs.getInteger("TIME_INT",0);

        MiddleClassInformation.coins_collected=dataPreferences.coins_collected_prefs.getInteger("COINS_COLLECTED",0);

        MiddleClassInformation.total_block_chain=dataPreferences.total_block_chain_prefs.getInteger("TOTAL_BLOCK_CHAIN",0);
        MiddleClassInformation.chain16s=dataPreferences.chain16s_prefs.getInteger("CHAIN_16s",0);

    }
}
