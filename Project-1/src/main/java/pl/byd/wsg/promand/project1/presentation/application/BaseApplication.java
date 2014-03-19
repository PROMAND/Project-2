package pl.byd.wsg.promand.project1.presentation.application;

import android.app.Application;

import pl.byd.wsg.promand.project1.dao.DatabaseSqlHelper;
import pl.byd.wsg.promand.project1.dao.TalkDao;
import pl.byd.wsg.promand.project1.dao.TalkTrackDao;
import pl.byd.wsg.promand.project1.dao.TrackDao;
import pl.byd.wsg.promand.project1.domain.entity.Track;

public class BaseApplication extends Application {

    private static DatabaseSqlHelper databaseSqlHelper;
    private static TalkDao talkDao;
    private static TrackDao trackDao;
    private static TalkTrackDao talkTrackDao;

    @Override
    public void onCreate() {
        super.onCreate();
        databaseSqlHelper = new DatabaseSqlHelper(this);
        talkDao = new TalkDao(databaseSqlHelper);
        trackDao = new TrackDao(databaseSqlHelper);
        talkTrackDao = new TalkTrackDao(databaseSqlHelper);
    }

    public static TalkDao getTalkDao() {
        return talkDao;
    }

    public static TrackDao getTrackDao() {
        return trackDao;
    }

    public static TalkTrackDao getTalkTrackDao() {
        return talkTrackDao;
    }
}
