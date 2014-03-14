package pl.byd.wsg.promand.project1.domain.list;

import java.util.ArrayList;
import java.util.List;

import pl.byd.wsg.promand.project1.domain.entity.Speaker;

public class SpeakerList {

    private List<Speaker> speakerList = new ArrayList<Speaker>();

    public void add(Speaker speaker) {
        speakerList.add(speaker);
    }

    public List<Speaker> getSpeakerList() {
        return speakerList;
    }
}
