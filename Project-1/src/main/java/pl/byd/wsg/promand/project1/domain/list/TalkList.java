package pl.byd.wsg.promand.project1.domain.list;

import java.util.ArrayList;
import java.util.List;

import pl.byd.wsg.promand.project1.domain.entity.Talk;

public class TalkList {

    private List<Talk> talkList = new ArrayList<Talk>();

    public void add(Talk talk) {
        talkList.add(talk);
    }

    public List<Talk> getTalkList() {
        return talkList;
    }
}
