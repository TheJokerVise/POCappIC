/*
 * Copyright (c)
 * Created by Luca Visentin - yyi4216
 * 28/05/18 17.06
 *
 */

package mobile.intranet.infocamere.it.pocappic.utils;

import android.content.Context;
import android.preference.PreferenceManager;

public class UnlockerSettings {

    private final static String PREF_UNLOCKED = "UNLOCKED";
    private final static String DONT_LOOK_AT_THIS = "lucavise";

    public static boolean isUnlocked(Context context){
        return PreferenceManager.getDefaultSharedPreferences(
                context).getBoolean("UNLOCKED", false);
    }

    public static boolean tryUnlock(Context context, String code){
        if (DONT_LOOK_AT_THIS.equals(code)){
            PreferenceManager.getDefaultSharedPreferences(
                    context).edit().putBoolean(PREF_UNLOCKED, true).apply();
            return true;
        }
        return false;
    }
}
