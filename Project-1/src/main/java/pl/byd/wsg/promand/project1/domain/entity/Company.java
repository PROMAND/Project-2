package pl.byd.wsg.promand.project1.domain.entity;

public class Company {

    private String name;
    private String logoUrl;

    public Company(String name, String logoUrl) {
        this.name = name;
        this.logoUrl = logoUrl;
    }

    public String getName() {
        return name;
    }

    public String getLogoUrl() {
        return logoUrl;
    }
}
