package pl.byd.wsg.promand.project1.jsonmock;

import com.google.gson.Gson;

import java.util.Arrays;

import pl.byd.wsg.promand.project1.domain.entity.Company;
import pl.byd.wsg.promand.project1.domain.entity.Profile;
import pl.byd.wsg.promand.project1.domain.entity.ProfileType;
import pl.byd.wsg.promand.project1.domain.entity.Speaker;
import pl.byd.wsg.promand.project1.domain.list.ProfileList;
import pl.byd.wsg.promand.project1.domain.list.SpeakerList;

public class SpeakerJsonServiceImpl implements SpeakerJsonService {

    private SpeakerList speakerList = new SpeakerList();

    public SpeakerJsonServiceImpl() {
        speakerList.add(
                new Speaker(1, "Tom", "Cruise",
                        "http://www.national-geographic.pl/assets/empty-avatar.png?1362501645",
                        new Company("Hollywood", "http://www.national-geographic.pl/assets/empty-avatar.png?1362501645"),
                        "Actor", new ProfileList(Arrays.asList(new Profile(ProfileType.LINKEDIN, "https://www.linkedin.com/")))));
        speakerList.add(
                new Speaker(2, "Chuck", "Noris",
                        "http://www.national-geographic.pl/assets/empty-avatar.png?1362501645",
                        new Company("Hollywood", "http://www.national-geographic.pl/assets/empty-avatar.png?1362501645"),
                        "Actor", new ProfileList(Arrays.asList(new Profile(ProfileType.LINKEDIN, "https://www.linkedin.com/")))));
    }

    @Override
    public String getSpeakerList() {
        return new Gson().toJson(speakerList);
    }
}
