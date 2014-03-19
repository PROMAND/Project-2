package pl.byd.wsg.promand.project1.dao;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

import pl.byd.wsg.promand.project1.domain.entity.Talk;

abstract class AbstractDao<T> {

    private SQLiteOpenHelper helper;
    private SQLiteDatabase database;
    private final String TABLE_NAME;

    public AbstractDao(DatabaseSqlHelper databaseSqlHelper, String tableName) {
        TABLE_NAME = tableName;
        helper = databaseSqlHelper;
    }

    protected void open(){
        database = helper.getWritableDatabase();
    }

    protected void close(){
        database.close();
    }

    public abstract void save(T item);
    public abstract List<T> findAll();
    protected abstract void saveWithoutOpenAndClose(T item);


    public SQLiteOpenHelper getHelper() {
        return helper;
    }

    public SQLiteDatabase getDatabase() {
        return database;
    }

    public String getTableName() {
        return TABLE_NAME;
    }
}
