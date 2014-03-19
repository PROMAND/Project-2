package pl.byd.wsg.promand.project1.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import pl.byd.wsg.promand.project1.dao.columns.TableName;
import pl.byd.wsg.promand.project1.dao.columns.TalkColumn;
import pl.byd.wsg.promand.project1.dao.columns.TalkTrackColumn;
import pl.byd.wsg.promand.project1.dao.columns.TrackColumn;
import pl.byd.wsg.promand.project1.domain.entity.Talk;
import pl.byd.wsg.promand.project1.domain.entity.Track;

public class DatabaseSqlHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "schedule.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TALK_TABLE_CREATE =
            "CREATE TABLE " + TableName.TALK + " (" +
                    TalkColumn.ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    TalkColumn.TITLE + " TEXT," +
                    TalkColumn.DESCRIPTION + " TEXT," +
                    TalkColumn.START_TIME + " TEXT," +
                    TalkColumn.END_TIME + " TEXT" +
                    " )";
    private static final String TRACK_TABLE_CREATE =
            "CREATE TABLE " + TableName.TRACK + " " +
                    TrackColumn.ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    TrackColumn.TITLE + " TEXT" +
                    " )";

    private static final String TALK_TRACK_TABLE_CREATE =
            "CREATE TABLE " + TableName.TALK_TRACK + " (" +
                    TalkTrackColumn.ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    TalkTrackColumn.ID_TALK + " INTEGER," +
                    TalkTrackColumn.ID_TRACK + " INTEGER," +
                    " )";

    public DatabaseSqlHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TALK_TABLE_CREATE);
        sqLiteDatabase.execSQL(TRACK_TABLE_CREATE);
        sqLiteDatabase.execSQL(TALK_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
         for(TableName tableName : TableName.values()) {
             sqLiteDatabase.execSQL("DROP TABLE IF EXIST " + tableName);
         }
         //sqLiteDatabase.execSQL("DROP TABLE IF EXIST " + TableName.TALK);
         onCreate(sqLiteDatabase);
    }

}
