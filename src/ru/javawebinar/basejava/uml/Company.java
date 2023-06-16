package ru.javawebinar.basejava.uml;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Company {
    private String companyName;
    private URL link;
    private List<Period> periods = new ArrayList<>();

    public Company(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public URL getLink() {
        return link;
    }

    public List<Period> getPeriods() {
        return periods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(companyName, company.companyName) && Objects.equals(link, company.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyName, link);
    }
}
