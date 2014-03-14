package pl.byd.wsg.promand.project1.domain.list;

import java.util.ArrayList;
import java.util.List;

import pl.byd.wsg.promand.project1.domain.entity.Track;

public class TrackList {

    private List<Track> trackList = new ArrayList<Track>();


    public void add(Track track) {
        trackList.add(track);
    }

    public List<Track> getTrackList(){
        return trackList;
    }
}
