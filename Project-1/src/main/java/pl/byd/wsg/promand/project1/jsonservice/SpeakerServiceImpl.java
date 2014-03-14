package pl.byd.wsg.promand.project1.jsonservice;

import com.google.gson.Gson;

import java.util.List;

import pl.byd.wsg.promand.project1.domain.entity.Speaker;
import pl.byd.wsg.promand.project1.domain.list.SpeakerList;
import pl.byd.wsg.promand.project1.jsonmock.SpeakerJsonService;
import pl.byd.wsg.promand.project1.jsonmock.SpeakerJsonServiceImpl;

public class SpeakerServiceImpl implements SpeakerService{

    private SpeakerJsonService speakerJsonService = new SpeakerJsonServiceImpl();


    @Override
    public List<Speaker> getSpeakerList() {
        String trackJson = speakerJsonService.getSpeakerList();
        return new Gson().fromJson(trackJson, SpeakerList.class).getSpeakerList();
    }
}
