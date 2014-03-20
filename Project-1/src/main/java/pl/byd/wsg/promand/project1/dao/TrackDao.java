package pl.byd.wsg.promand.project1.dao;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import pl.byd.wsg.promand.project1.dao.columns.TableName;
import pl.byd.wsg.promand.project1.dao.columns.TrackColumn;
import pl.byd.wsg.promand.project1.domain.entity.Track;
import pl.byd.wsg.promand.project1.jsonservice.TrackServiceImpl;

public class TrackDao extends AbstractDao<Track>{


    public TrackDao(DatabaseSqlHelper databaseSqlHelper) {
        super(databaseSqlHelper, TableName.TRACK.toString());
    }

    @Override
    protected void saveWithoutOpenAndClose(Track track){
        ContentValues values = new ContentValues();
        values.put(TrackColumn.ID.toString(), track.getId());
        values.put(TrackColumn.TITLE.toString(), track.getTitle());
        long id = getDatabase().insert(getTableName(), null, values);
    }

    @Override
    public void save(Track item) {
        open();
        saveWithoutOpenAndClose(item);
        close();
    }

    @Override
    public List<Track> findAll() {
        open();
        Cursor cursor = getDatabase().query(getTableName(), TrackColumn.getColumnNames(), null, null, null, null, null);
        List<Track> trackList = cursorToList(cursor);
        close();
        return trackList;
    }

    private List<Track> cursorToList(Cursor cursor) {
        List<Track> talkList = new ArrayList<Track>();
        while (cursor.moveToNext()) {
            Track track = new Track();
            track.setId(cursor.getLong(cursor.getColumnIndex(TrackColumn.ID.toString())));
            track.setTitle(cursor.getString(cursor.getColumnIndex(TrackColumn.TITLE.toString())));
            talkList.add(track);
        }
        return talkList;
    }

    public void saveFromTrackList(List<Track> trackList) {
        open();
        for(Track track : trackList) {
            saveWithoutOpenAndClose(track);
        }
        close();
    }
}
