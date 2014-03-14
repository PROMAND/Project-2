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

    public void setName(String name) {
        this.name = name;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }
}
