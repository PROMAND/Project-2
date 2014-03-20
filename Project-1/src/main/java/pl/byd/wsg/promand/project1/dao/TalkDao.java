package pl.byd.wsg.promand.project1.dao;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import pl.byd.wsg.promand.project1.dao.columns.TableName;
import pl.byd.wsg.promand.project1.dao.columns.TalkColumn;
import pl.byd.wsg.promand.project1.dao.columns.TalkTrackColumn;
import pl.byd.wsg.promand.project1.dao.columns.TrackColumn;
import pl.byd.wsg.promand.project1.domain.entity.Talk;
import pl.byd.wsg.promand.project1.domain.entity.TalkTrack;
import pl.byd.wsg.promand.project1.domain.entity.Track;
import pl.byd.wsg.promand.project1.presentation.application.BaseApplication;
import pl.byd.wsg.promand.project1.utils.DateUtils;

public class TalkDao extends AbstractDao<Talk> {


    public TalkDao(DatabaseSqlHelper databaseSqlHelper) {
        super(databaseSqlHelper, TableName.TALK.toString());
    }

    @Override//DONE
    public void save(Talk item) {
        open();
        saveWithoutOpenAndClose(item);
        close();
    }

    @Deprecated
    @Override//DONE
    public List<Talk> findAll() {
        throw new UnsupportedOperationException();
    }

    @Override//DONE
    protected void saveWithoutOpenAndClose(Talk talk) {
        ContentValues values = new ContentValues();
        values.put(TalkColumn.ID.toString(), talk.getId());
        values.put(TalkColumn.TITLE.toString(), talk.getTitle());
        values.put(TalkColumn.DESCRIPTION.toString(), talk.getDescription());
        values.put(TalkColumn.START_TIME.toString(), DateUtils.convertToDatabaseFormat(talk.getStartTime()));
        values.put(TalkColumn.END_TIME.toString(), DateUtils.convertToDatabaseFormat(talk.getEndTime()));
        long id = getDatabase().insert(getTableName(), null, values);
    }

    //DONE
    public void saveFromTalkList(List<Talk> talkList) {
        open();
        for (Talk talk : talkList) {
            saveWithoutOpenAndClose(talk);
        }
        close();
    }
    @Deprecated
    private List<Long> makeTrackListForTalk(Long talkId, TalkTrackDao talkTrackDao){
        List<Long> trackList = new ArrayList<Long>();
        open();
        Cursor cursor = getDatabase().query(
                TableName.TALK_TRACK.toString(),
                TalkTrackColumn.getColumnNames(),
                TalkTrackColumn.ID_TALK + " = " + talkId,
                null, null, null, null);
        while (cursor.moveToNext()) {
            trackList.add(cursor.getLong(cursor.getColumnIndex(TalkTrackColumn.ID_TRACK.toString())));
        }
        close();
        return trackList;
    }
    //DONE
    private List<Talk> cursorToList(Cursor cursor, List<TalkTrack> talkTrackList){
        List<Talk> talkList = new ArrayList<Talk>();
        while (cursor.moveToNext()) {
            Talk talk = new Talk();
            long talkId = cursor.getLong(cursor.getColumnIndex(TalkColumn.ID.toString()));
            talk.setId(talkId);
            talk.setTitle(cursor.getString(cursor.getColumnIndex(TalkColumn.TITLE.toString())));
            talk.setDescription(cursor.getString(cursor.getColumnIndex(TalkColumn.DESCRIPTION.toString())));
            talk.setStartTime(DateUtils.convertFromDatabaseFormat(cursor.getString(cursor.getColumnIndex(TalkColumn.START_TIME.toString()))));
            talk.setEndTime(DateUtils.convertFromDatabaseFormat(cursor.getString(cursor.getColumnIndex(TalkColumn.END_TIME.toString()))));

            List<Long> trackIdList = new ArrayList<Long>();
            for(TalkTrack talkTrack : talkTrackList) {
                if(talkId == talkTrack.getTalkId()){
                    trackIdList.add(talkTrack.getTrackId());
                }
            }
            talk.setTrackList(trackIdList);
            talkList.add(talk);
        }
        return talkList;
    }
    public List<Talk> findTalksByTrack(Track track, List<TalkTrack> talkTrackList){
        List<TalkTrack> filteredList = new ArrayList<TalkTrack>();
        for(TalkTrack talkTrack : talkTrackList) {
            if(talkTrack.getTrackId() == track.getId()) {
                filteredList.add(talkTrack);
            }
        }
        return findAll(filteredList);
    }


    public List<Talk> findAll(List<TalkTrack> talkTrackList) {
        open();
        Cursor cursor = getDatabase().query(getTableName(), TalkColumn.getColumnNames(), null, null, null, null, null);
        List<Talk> talkList = cursorToList(cursor, talkTrackList);
        close();
        return talkList;
    }

    /*@Deprecated
    private List<Talk> findByTrack(Track track) { //TODO:
        List<Talk> talkList = new ArrayList<Talk>();
        String talkJoinTrack =
                "SELECT * " +
                        "FROM ( " + TableName.TALK + " AS TA " +
                        " INNER JOIN " + TableName.TALK_TRACK +
                        " AS TT ON TA." + TalkColumn.ID + " = TT." + TalkTrackColumn.ID_TALK + " ) " +
                        " INNER JOIN " + TableName.TRACK +
                        " AS TR ON TR." + TrackColumn.ID + " = TT." + TalkTrackColumn.ID_TRACK +
                        "WHERE TR." + TrackColumn.ID + " = " + track.getId();
        open();
        Cursor cursor = getDatabase().rawQuery(talkJoinTrack, null);
        while (cursor.moveToNext()) {
            Talk talk = new Talk();
            talk.setId(cursor.getLong(cursor.getColumnIndex("TA." + TalkColumn.ID)));
            talk.setTitle(cursor.getString(cursor.getColumnIndex("TA." + TalkColumn.TITLE)));
            talk.setDescription(cursor.getString(cursor.getColumnIndex("TA." + TalkColumn.DESCRIPTION)));
            talk.setStartTime(DateUtils.convertFromDatabaseFormat(cursor.getString(cursor.getColumnIndex("TA." + TalkColumn.START_TIME))));
            talk.setStartTime(DateUtils.convertFromDatabaseFormat(cursor.getString(cursor.getColumnIndex("TA." + TalkColumn.END_TIME))));
            talkList.add(talk);
        }
        close();
        return talkList;
    }*/

    /*@Deprecated
    public List<Talk> findTalkListByTrack(Track track, TrackDao trackDao) {
        List<Talk> talkList = findAll();
        List<Track> trackList = trackDao.findAll();
        return null;
    }*/


}
