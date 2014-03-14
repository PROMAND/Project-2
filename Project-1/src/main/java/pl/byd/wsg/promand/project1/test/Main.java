package pl.byd.wsg.promand.project1.test;

import java.util.List;

import pl.byd.wsg.promand.project1.domain.entity.Track;
import pl.byd.wsg.promand.project1.jsonservice.TrackService;
import pl.byd.wsg.promand.project1.jsonservice.TrackServiceImpl;

public class Main {

    public static void main(String[] args) {

        TrackService trackService = new TrackServiceImpl();
        List<Track> tracks = trackService.getTrackList();
        for(Track track : tracks){
            System.out.println(track.toString());
        }
    }
}
