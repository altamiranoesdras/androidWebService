package com.example.usuario.pruebawebsservice.helpers;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Usuario on 25/10/2016.
 */

public class PreferencesManager {

    /**
     * Name of our SharedPreferences
     */
    private static final String SHARED_PREFERENCES_NAME="ipmPreferences";
    private static final String TERMS_CONDITION_ACCEPTED="acceptedTermsCondition";


    public static boolean getTermsConditions(Context context){

        SharedPreferences sharedPreferences= context.getSharedPreferences(SHARED_PREFERENCES_NAME,context.MODE_PRIVATE);

        return sharedPreferences.getBoolean(TERMS_CONDITION_ACCEPTED,false);
    }

    public static void setTermsConditionAccepted(Context context,boolean termsConditions){
        SharedPreferences sharedPreferences= context.getSharedPreferences(SHARED_PREFERENCES_NAME,context.MODE_PRIVATE);

        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putBoolean(TERMS_CONDITION_ACCEPTED,termsConditions);
        editor.apply();
    }



}
