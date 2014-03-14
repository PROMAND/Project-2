package pl.byd.wsg.promand.project1.jsonmock;

import com.google.gson.Gson;
import pl.byd.wsg.promand.project1.domain.list.TalkList;

public class TalkJsonServiceImpl implements TalkJsonService {

    private TalkList talkList = new TalkList();

    public TalkJsonServiceImpl() {
        //TODO : talkList.add();
    }

    @Override
    public String getTalkList() {
        return new Gson().toJson(talkList);
    }
}
