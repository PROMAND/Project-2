package pl.byd.wsg.promand.project1.jsonmock;

import pl.byd.wsg.promand.project1.domain.entity.Track;

public interface TalkJsonService {
    public String getTalkList();
    public String getTalkListByTrack(Track track);
}
