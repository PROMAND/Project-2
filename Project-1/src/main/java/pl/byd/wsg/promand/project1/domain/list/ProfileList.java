package pl.byd.wsg.promand.project1.domain.list;

import java.util.ArrayList;
import java.util.List;

import pl.byd.wsg.promand.project1.domain.entity.Profile;

public class ProfileList {

    private List<Profile> profileList = new ArrayList<Profile>();

    public void add(Profile profile) {
        profileList.add(profile);
    }

    public List<Profile> getProfileList() {
        return profileList;
    }
}
