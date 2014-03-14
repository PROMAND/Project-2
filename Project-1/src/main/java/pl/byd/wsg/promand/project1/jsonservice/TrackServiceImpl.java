package pl.byd.wsg.promand.project1.jsonservice;

import com.google.gson.Gson;

import java.util.List;

import pl.byd.wsg.promand.project1.domain.entity.Track;
import pl.byd.wsg.promand.project1.domain.list.TrackList;
import pl.byd.wsg.promand.project1.jsonmock.TrackJsonService;
import pl.byd.wsg.promand.project1.jsonmock.TrackJsonServiceImpl;

public class TrackServiceImpl implements TrackService{

    private TrackJsonService trackJsonService = new TrackJsonServiceImpl();

    @Override
    public List<Track> getTrackList() {
        String trackJson = trackJsonService.getTrackList();
        return new Gson().fromJson(trackJson, TrackList.class).getTrackList();
    }
}
