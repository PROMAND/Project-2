package pl.byd.wsg.promand.project1.jsonservice;

import java.util.List;

import pl.byd.wsg.promand.project1.domain.entity.Talk;
import pl.byd.wsg.promand.project1.domain.entity.Track;

public interface TalkService {
    public List<Talk> getTalkList();
    public List<Talk> getTalkListByTrack(Track track);
}
