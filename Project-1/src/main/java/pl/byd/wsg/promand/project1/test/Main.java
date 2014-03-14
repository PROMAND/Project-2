package pl.byd.wsg.promand.project1.test;

import java.util.List;

import pl.byd.wsg.promand.project1.domain.entity.Speaker;
import pl.byd.wsg.promand.project1.jsonmock.SpeakerJsonService;
import pl.byd.wsg.promand.project1.jsonmock.SpeakerJsonServiceImpl;
import pl.byd.wsg.promand.project1.jsonservice.SpeakerService;
import pl.byd.wsg.promand.project1.jsonservice.SpeakerServiceImpl;

public class Main {

    public static void main(String[] args) {
        SpeakerService speakerService = new SpeakerServiceImpl();
        List<Speaker> speakerList = speakerService.getSpeakerList();
        for(Speaker speaker : speakerList){
            System.out.println(speaker);
        }
    }
}
