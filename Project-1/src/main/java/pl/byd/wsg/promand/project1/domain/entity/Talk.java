package pl.byd.wsg.promand.project1.domain.entity;

import java.util.Date;
import java.util.List;

public class Talk {

    private long id;
    private String title;
    private String description;
    private Date startTime;
    private Date endTime;
    private List<Long> trackList;
    private List<Long> speakerList;

    public Talk(long id, String title, String description, Date startTime, Date endTime, List<Long> trackList, List<Long> speakerList) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.trackList = trackList;
        this.speakerList = speakerList;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public List<Long> getTrackList() {
        return trackList;
    }

    public List<Long> getSpeakerList() {
        return speakerList;
    }
}
