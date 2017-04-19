package com.jgntic.bloxet.Managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

/**
 * Created by IVAN on 14.6.2016 г..
 */
public class DataPreferences {

    public Preferences coins_count_prefs,time_count_prefs,bomb_count_prefs,global_high_score_prefs,
    mute_prefs,block_1_int_prefs,block_2_int_prefs,block_3_int_prefs, block_6_int_prefs,
    bomb_int_prefs,clock_int_prefs,coins_collected_prefs,total_block_chain_prefs,chain16s_prefs,
    music_prefs;

    public DataPreferences()
    {
        coins_count_prefs= Gdx.app.getPreferences("COINS_COUNT");
        time_count_prefs= Gdx.app.getPreferences("TIME_COUNT");
        bomb_count_prefs= Gdx.app.getPreferences("BOMB_COUNT");

        global_high_score_prefs= Gdx.app.getPreferences("GLOBAL_HIGH_SCORE");

        mute_prefs= Gdx.app.getPreferences("MUTE");
        music_prefs=Gdx.app.getPreferences("MUSIC");

        block_1_int_prefs= Gdx.app.getPreferences("BLOCK_1_INT");
        block_2_int_prefs= Gdx.app.getPreferences("BLOCK_2_INT");
        block_3_int_prefs= Gdx.app.getPreferences("BLOCK_3_INT");
        block_6_int_prefs= Gdx.app.getPreferences("BLOCK_6_INT");
        bomb_int_prefs= Gdx.app.getPreferences("BOMB_INT");
        clock_int_prefs= Gdx.app.getPreferences("TIME_INT");

        coins_collected_prefs= Gdx.app.getPreferences("COINS_COLLECTED");

        total_block_chain_prefs= Gdx.app.getPreferences("TOTAL_BLOCK_CHAIN");
        chain16s_prefs= Gdx.app.getPreferences("CHAIN_16s");
    }
}
