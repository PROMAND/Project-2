package pl.byd.wsg.promand.project1.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pl.byd.wsg.promand.project1.dao.columns.TableName;
import pl.byd.wsg.promand.project1.dao.columns.TalkColumn;
import pl.byd.wsg.promand.project1.domain.entity.Talk;
import pl.byd.wsg.promand.project1.utils.DateUtils;

public class TalkDao extends AbstractDao<Talk>{


    public TalkDao(DatabaseSqlHelper databaseSqlHelper) {
        super(databaseSqlHelper, TableName.TALK.toString());
    }

    @Override
    public void save(Talk item) {
        open();
        saveWithoutOpenAndClose(item);
        close();
    }

    @Override
    protected void saveWithoutOpenAndClose(Talk talk){
        ContentValues values = new ContentValues();
        values.put(TalkColumn.TITLE.toString(), talk.getTitle());
        values.put(TalkColumn.DESCRIPTION.toString(), talk.getDescription());
        values.put(TalkColumn.START_TIME.toString(), DateUtils.convertToDatabaseFormat(talk.getStartTime()));
        values.put(TalkColumn.END_TIME.toString(), DateUtils.convertToDatabaseFormat(talk.getEndTime()));
        long id = getDatabase().insert(getTableName(), null, values);
    }

    @Override
    public List<Talk> findAll(){
        open();
        Cursor cursor = getDatabase().query(getTableName(), TalkColumn.getColumnNames(), null, null, null, null, null);
        List<Talk> talkList = cursorToList(cursor);
        close();
        return talkList;
    }
    private List<Talk> cursorToList(Cursor cursor) {
        List<Talk> talkList = new ArrayList<Talk>();
        while (cursor.moveToNext()) {
            Talk talk = new Talk();
            talk.setId(cursor.getLong(cursor.getColumnIndex(TalkColumn.ID.toString())));
            talk.setTitle(cursor.getString(cursor.getColumnIndex(TalkColumn.TITLE.toString())));
            talk.setDescription(cursor.getString(cursor.getColumnIndex(TalkColumn.DESCRIPTION.toString())));
            talk.setStartTime(DateUtils.convertFromDatabaseFormat(cursor.getString(cursor.getColumnIndex(TalkColumn.START_TIME.toString()))));
            talk.setEndTime(DateUtils.convertFromDatabaseFormat(cursor.getString(cursor.getColumnIndex(TalkColumn.END_TIME.toString()))));
            talkList.add(talk);
        }
        return talkList;
    }
}
