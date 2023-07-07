package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.*;

import java.time.Month;

public class ResumeTestData {

    public Resume writeInResume(String uuid, String fullName) {
        Resume resume = new Resume(uuid, fullName);

        resume.addContact(ContactType.PHONE, "55555");
        resume.addSection(SectionType.PERSONAL, new TextSection("Private qualities"));
        resume.addSection(SectionType.OBJECTIVE, new TextSection("ObjectiveX"));
        resume.addSection(SectionType.ACHIEVEMENT, new ListSection("Small achievement",
                "Average achievement", "Great achievement"));
        resume.addSection(SectionType.QUALIFICATIONS, new ListSection("Java", "JavaScript", "SQL", "Git"));
        resume.addSection(SectionType.EDUCATION, new OrganizationSection(
                new Organization("Ural Federal University", null,
                        new Organization.Position(1999, Month.SEPTEMBER, 2004, Month.JULY,
                                "student", "IT department"))));
        resume.addSection(SectionType.EXPERIENCE, new OrganizationSection(
                new Organization("Horns and Hooves", null,
                        new Organization.Position(2005, Month.JANUARY, 2008, Month.AUGUST,
                                "Junior java developer", "Bug fixing"))));

        return resume;
    }
}
