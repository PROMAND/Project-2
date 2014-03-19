package pl.byd.wsg.promand.project1.presentation.application;

import android.app.Application;

import pl.byd.wsg.promand.project1.dao.DatabaseSqlHelper;
import pl.byd.wsg.promand.project1.dao.TalkDao;

public class BaseApplication extends Application {

    private static DatabaseSqlHelper databaseSqlHelper;
    private static TalkDao talkDao;

    @Override
    public void onCreate() {
        super.onCreate();
        databaseSqlHelper = new DatabaseSqlHelper(this);
        talkDao = new TalkDao(databaseSqlHelper);
    }

    public static TalkDao getTalkDao() {
        return talkDao;
    }
}
