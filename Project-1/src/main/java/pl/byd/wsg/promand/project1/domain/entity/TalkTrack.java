package pl.byd.wsg.promand.project1.domain.entity;

public class TalkTrack {

    private long id;
    private long talkId;
    private long trackId;
    private int isAdded;

    public TalkTrack() {
    }

    public TalkTrack(long talkId, long trackId) {
        this.talkId = talkId;
        this.trackId = trackId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTalkId() {
        return talkId;
    }

    public void setTalkId(long talkId) {
        this.talkId = talkId;
    }

    public long getTrackId() {
        return trackId;
    }

    public void setTrackId(long trackId) {
        this.trackId = trackId;
    }

    public boolean getIsAdded() {
        return isAdded > 0;
    }

    public void setIsAdded(boolean isAdded) {
        this.isAdded = isAdded == true ? 1 : 0;
    }
    public void setIsAddedByInt(int isAdded) {
        this.isAdded = isAdded;
    }

}
