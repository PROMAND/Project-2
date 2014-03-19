package pl.byd.wsg.promand.project1.dao;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import pl.byd.wsg.promand.project1.dao.columns.TableName;
import pl.byd.wsg.promand.project1.dao.columns.TalkTrackColumn;
import pl.byd.wsg.promand.project1.dao.columns.TrackColumn;
import pl.byd.wsg.promand.project1.domain.entity.Talk;
import pl.byd.wsg.promand.project1.domain.entity.TalkTrack;
import pl.byd.wsg.promand.project1.domain.entity.Track;
import pl.byd.wsg.promand.project1.jsonservice.TalkServiceImpl;

public class TalkTrackDao extends AbstractDao<TalkTrack>{

    public TalkTrackDao(DatabaseSqlHelper databaseSqlHelper) {
        super(databaseSqlHelper, TableName.TALK_TRACK.toString());
    }

    @Override
    public void save(TalkTrack item) {
        open();
        saveWithoutOpenAndClose(item);
        close();
    }

    @Override
    public List<TalkTrack> findAll() {
        open();
        Cursor cursor = getDatabase().query(getTableName(), TalkTrackColumn.getColumnNames(), null, null, null, null, null);
        List<TalkTrack> talkTrackList = cursorToList(cursor);
        close();
        return talkTrackList;
    }
    private List<TalkTrack> cursorToList(Cursor cursor) {
        List<TalkTrack> talkTrackList = new ArrayList<TalkTrack>();
        while (cursor.moveToNext()) {
            TalkTrack talkTrack = new TalkTrack();
            talkTrack.setTalkId(cursor.getLong(cursor.getColumnIndex(TalkTrackColumn.ID_TALK.toString())));
            talkTrack.setTrackId(cursor.getLong(cursor.getColumnIndex(TalkTrackColumn.ID_TRACK.toString())));
            talkTrackList.add(talkTrack);
        }
        return talkTrackList;
    }

    @Override
    protected void saveWithoutOpenAndClose(TalkTrack item) {
        ContentValues values = new ContentValues();
        values.put(TalkTrackColumn.ID_TALK.toString(), item.getTalkId());
        values.put(TalkTrackColumn.ID_TRACK.toString(), item.getTrackId());
        long id = getDatabase().insert(getTableName(), null, values);
    }

    private void saveFromTalk(Talk talk) {
        for(Long trackId: talk.getTrackList()) {
            ContentValues values = new ContentValues();
            values.put(TalkTrackColumn.ID_TALK.toString(), talk.getId());
            values.put(TalkTrackColumn.ID_TRACK.toString(), trackId);
            getDatabase().insert(getTableName(), null, values);
        }
    }

    public void saveFromTalkList(List<Talk> talkList) {
        open();
        for(Talk talk : talkList) {
            saveFromTalk(talk);
        }
        close();
    }

}
