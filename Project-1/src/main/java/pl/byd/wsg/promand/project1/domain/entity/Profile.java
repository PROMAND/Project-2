package pl.byd.wsg.promand.project1.domain.entity;

public class Profile {

    private ProfileType profileType;
    private String profileUrl;

    public Profile(ProfileType profileType, String profileUrl) {
        this.profileType = profileType;
        this.profileUrl = profileUrl;
    }

    public ProfileType getProfileType() {
        return profileType;
    }

    public String getProfileUrl() {
        return profileUrl;
    }
}
