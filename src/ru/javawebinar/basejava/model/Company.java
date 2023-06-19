package ru.javawebinar.basejava.model;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Company {
    private final String companyName;
    private URL link;
    private List<Period> periods;
    private final List<Position> positions = new ArrayList<>();

    public Company(String companyName, URL link, List<Period> periods) {
        Objects.requireNonNull(companyName, "companyName must not be null");
        this.companyName = companyName;
        this.link = link;
        this.periods = periods;
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

        if (!companyName.equals(company.companyName)) return false;
        return periods.equals(company.periods);
    }

    @Override
    public int hashCode() {
        int result = companyName.hashCode();
        result = 31 * result + periods.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyName='" + companyName + '\'' +
                ", link=" + link +
                ", periods=" + periods +
                '}';
    }
}
