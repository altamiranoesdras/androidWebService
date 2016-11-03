package com.example.usuario.pruebawebsservice.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Usuario on 27/10/2016.
 */

public class DataBaseManager extends SQLiteOpenHelper {

    // General DataBase Syntax
    public static final String CREATE_TABLE = "CREATE TABLE ";
    public static final String ALTER_TABLE = "ALTER TABLE ";
    public static final String ADD_COLUMN = " ADD COLUMN ";

    public static final String PRIMARY_KEY = " PRIMARY KEY";
    public static final String PRIMARY_KEY_INT = " INTEGER PRIMARY KEY";
    public static final String PRIMARY_KEY_AUTO = " INTEGER PRIMARY KEY AUTOINCREMENT";
    public static final String AUTOINCREMENT = " AUTOINCREMENT";
    public static final String FOREIGN_KEY = " FOREIGN KEY";
    public static final String REFERENCES = " REFERENCES ";
    public static final String UNIQUE = " UNIQUE";
    public static final String NOT_NULL = " NOT NULL";

    public static final String TYPE_TEXT = " TEXT";
    public static final String TYPE_INTEGER = " INTEGER";
    public static final String TYPE_NUMERIC = " NUMERIC";
    public static final String TYPE_FECHA = " CURRENT_DATE";
    public static final String TYPE_HORA = " CURRENT_TIME";
    public static final String TYPE_DATE = " CURRENT_TIMESTAMP";

    // DataTables
    public static final String DETAIL_TABLE = "DetailTable";
    public static final String DETAIL_FIELD_ID = "DetailId";
    public static final String DETAIL_FIELD_NUMBER = "DetailNumber";
    public static final String DETAIL_FIELD_DESCRIPTION = "DetailDescription";
    public static final String DETAIL_FIELD_DATE = "DetailDate";
    public static final String DETAIL_FIELD_USER = "DetailAppUser";

    public static final String SHORT_DETAIL_TABLE = "ShortDetailTable";
    public static final String SHORT_DETAIL_FIELD_ID = "ShortDetailId";
    public static final String SHORT_DETAIL_FIELD_DESCRIPTION = "ShortDetailDescription";
    public static final String SHORT_DETAIL_FIELD_DATE = "ShortDetailDate";
    public static final String SHORT_DETAIL_FIELD_DETAIL = "ShortDetailDetail";

    private static final String DATA_BASE_NAME="IPM_DataBase.db";
    private static final int DATA_BASE_VERSION = 1;

    /*
    Converion table
     */
    public static final String CONVERTION_TABLE="convertion";
    public static final String CONVERTION_FIEL_ID="id";
    public static final String CONVERTION_FIEL_FROM_UNIT ="from_unit";
    public static final String CONVERTION_FIEL_FROM_WEIGHT ="from_weight";
    public static final String CONVERTION_FIEL_TO_UNIT ="to_unit";
    public static final String CONVERTION_FIEL_TO_WEIGHT ="to_weight";

    public DataBaseManager(Context context){
        super(context,DATA_BASE_NAME,null,DATA_BASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE + CONVERTION_TABLE +
          "(" + CONVERTION_FIEL_ID + PRIMARY_KEY_AUTO +","+
                CONVERTION_FIEL_FROM_UNIT + TYPE_TEXT +","+
                CONVERTION_FIEL_FROM_WEIGHT + TYPE_NUMERIC +","+
                CONVERTION_FIEL_TO_UNIT + TYPE_TEXT +","+
                CONVERTION_FIEL_TO_WEIGHT + TYPE_NUMERIC + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
