package pl.byd.wsg.promand.project1.jsonservice;

import com.google.gson.Gson;

import java.util.List;

import pl.byd.wsg.promand.project1.domain.entity.Talk;
import pl.byd.wsg.promand.project1.domain.list.TalkList;
import pl.byd.wsg.promand.project1.jsonmock.TalkJsonService;
import pl.byd.wsg.promand.project1.jsonmock.TalkJsonServiceImpl;

public class TalkServiceImpl implements TalkService{

    private TalkJsonService talkJsonService = new TalkJsonServiceImpl();

    @Override
    public List<Talk> getTalkList() {
        String talkJson = talkJsonService.getTalkList();
        return new Gson().fromJson(talkJson, TalkList.class).getTalkList();
    }
}
