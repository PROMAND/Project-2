package pl.byd.wsg.promand.project1.domain.entity;

import pl.byd.wsg.promand.project1.domain.list.ProfileList;

public class Speaker {

    private long id;
    private String name;
    private String surname;
    private String photoUrl;
    private Company company;
    private String description;
    private ProfileList profileList;


    public Speaker(long id, String name, String surname, String photoUrl, Company company, String description, ProfileList profileList) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.photoUrl = photoUrl;
        this.company = company;
        this.description = description;
        this.profileList = profileList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProfileList getProfileList() {
        return profileList;
    }

    public void setProfileList(ProfileList profileList) {
        this.profileList = profileList;
    }
}
