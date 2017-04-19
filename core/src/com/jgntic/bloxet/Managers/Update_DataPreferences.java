package com.jgntic.bloxet.Managers;

import com.jgntic.bloxet.Bloxet;

/**
 * Created by IVAN on 14.6.2016 г..
 */
public class Update_DataPreferences {

    Bloxet game;

    public Update_DataPreferences(Bloxet game)
    {
        this.game=game;

        game.dataPreferences.coins_count_prefs.putInteger("COINS_COUNT",MiddleClassInformation.coins_count);
        game.dataPreferences.coins_count_prefs.flush();

        game.dataPreferences.time_count_prefs.putInteger("TIME_COUNT",MiddleClassInformation.time_count);
        game.dataPreferences.time_count_prefs.flush();

        game.dataPreferences.bomb_count_prefs.putInteger("BOMB_COUNT",MiddleClassInformation.bomb_count);
        game.dataPreferences.bomb_count_prefs.flush();

        game.dataPreferences.global_high_score_prefs.putInteger("GLOBAL_HIGH_SCORE",MiddleClassInformation.global_high_score);
        game.dataPreferences.global_high_score_prefs.flush();

        game.dataPreferences.mute_prefs.putInteger("MUTE",MiddleClassInformation.mute);
        game.dataPreferences.mute_prefs.flush();

        game.dataPreferences.music_prefs.putInteger("MUSIC",MiddleClassInformation.music);
        game.dataPreferences.music_prefs.flush();

        game.dataPreferences.block_1_int_prefs.putInteger("BLOCK_1_INT",MiddleClassInformation.block_1_int);
        game.dataPreferences.block_1_int_prefs.flush();

        game.dataPreferences.block_2_int_prefs.putInteger("BLOCK_2_INT",MiddleClassInformation.block_2_int);
        game.dataPreferences.block_2_int_prefs.flush();

        game.dataPreferences.block_3_int_prefs.putInteger("BLOCK_3_INT",MiddleClassInformation.block_3_int);
        game.dataPreferences.block_3_int_prefs.flush();

        game.dataPreferences.block_6_int_prefs.putInteger("BLOCK_6_INT",MiddleClassInformation.block_6_int);
        game.dataPreferences.block_6_int_prefs.flush();

        game.dataPreferences.bomb_int_prefs.putInteger("BOMB_INT",MiddleClassInformation.bomb_int);
        game.dataPreferences.bomb_int_prefs.flush();

        game.dataPreferences.clock_int_prefs.putInteger("TIME_INT",MiddleClassInformation.clock_int);
        game.dataPreferences.clock_int_prefs.flush();

        game.dataPreferences.coins_collected_prefs.putInteger("COINS_COLLECTED",MiddleClassInformation.coins_collected);
        game.dataPreferences.coins_collected_prefs.flush();

        game.dataPreferences.total_block_chain_prefs.putInteger("TOTAL_BLOCK_CHAIN",MiddleClassInformation.total_block_chain);
        game.dataPreferences.total_block_chain_prefs.flush();

        game.dataPreferences.chain16s_prefs.putInteger("CHAIN_16s",MiddleClassInformation.chain16s);
        game.dataPreferences.chain16s_prefs.flush();
    }

}
