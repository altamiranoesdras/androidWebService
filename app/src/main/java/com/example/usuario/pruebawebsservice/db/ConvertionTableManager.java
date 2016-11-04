package com.example.usuario.pruebawebsservice.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.usuario.pruebawebsservice.objects.Convertion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Usuario on 27/10/2016.
 */

public class ConvertionTableManager {

    public  static boolean saveConvertion(Context context, Convertion convertion) {
        boolean result = false;

        ContentValues cv = new ContentValues();
        cv.put(DataBaseManager.CONVERTION_FIEL_FROM_UNIT, convertion.getFromUnit());
        cv.put(DataBaseManager.CONVERTION_FIEL_FROM_WEIGHT, convertion.getFromWeight());
        cv.put(DataBaseManager.CONVERTION_FIEL_TO_UNIT, convertion.getToUnit());
        cv.put(DataBaseManager.CONVERTION_FIEL_TO_WEIGHT, convertion.getToWeight());

        DataBaseManager db = new DataBaseManager(context);
        SQLiteDatabase database = db.getWritableDatabase();

        result = (database.insert(DataBaseManager.CONVERTION_TABLE,null,cv) != -1);

        database.close();
        db.close();

        return result;
    }

    public static List<Convertion> getConvertions(Context context){
        List <Convertion> convertionList=new ArrayList<>();

        DataBaseManager dataBaseManager=new DataBaseManager(context);
        SQLiteDatabase database=dataBaseManager.getWritableDatabase();

        Cursor cursor= database.query(DataBaseManager.CONVERTION_TABLE,
                new String[]{DataBaseManager.CONVERTION_FIEL_FROM_UNIT,
                        DataBaseManager.CONVERTION_FIEL_TO_UNIT,
                        DataBaseManager.CONVERTION_FIEL_TO_WEIGHT,
                        DataBaseManager.CONVERTION_FIEL_FROM_WEIGHT,
                        DataBaseManager.CONVERTION_FIEL_ID},
                null,null,null,null,null);
        Convertion tempConvertion;
        if(cursor.moveToFirst()){
            do {
                tempConvertion = new Convertion();
                tempConvertion.setFromUnit(cursor.getString(0));
                tempConvertion.setToUnit(cursor.getString(1));
                tempConvertion.setToWeight(cursor.getDouble(2));
                tempConvertion.setFromWeight(cursor.getDouble(3));
                tempConvertion.setId(cursor.getInt(4));

                convertionList.add(tempConvertion);
            }while(cursor.moveToNext());
        }

        database.close();
        dataBaseManager.close();

        return convertionList;
    }

    public static boolean deleteConvertion(Context context, Convertion convertion){
        boolean result =false;
        DataBaseManager dataBaseManager=new DataBaseManager(context);
        SQLiteDatabase database=dataBaseManager.getWritableDatabase();

        result=(database.delete(DataBaseManager.CONVERTION_TABLE,
                DataBaseManager.CONVERTION_FIEL_ID + "=?",
                new String[]{Integer.toString(convertion.getId())})>=1);

        database.close();
        dataBaseManager.close();

        return  result;
    }
}
