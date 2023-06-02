package ru.javawebinar.basejava.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;

public class ListStorageTest {
    protected static ListStorage resumesList = new ListStorage(new ArrayList<>());
    protected static final String UUID_1 = "UUID_1";
    protected static final String UUID_2 = "UUID_2";
    protected static final String UUID_3 = "UUID_3";
    protected static final String UUID_4 = "UUID_4";
    private static final Resume RESUME_1;
    private static final Resume RESUME_2;
    private static final Resume RESUME_3;
    private static final Resume RESUME_4;

    static {
        RESUME_1 = new Resume(UUID_1);
        RESUME_2 = new Resume(UUID_2);
        RESUME_3 = new Resume(UUID_3);
        RESUME_4 = new Resume(UUID_4);
    }

    @Before
    public void setUp() {
        resumesList.clear();
        resumesList.save(RESUME_1);
        resumesList.save(RESUME_2);
        resumesList.save(RESUME_3);
    }

    public void assertGet(Resume resume) {
        Assert.assertEquals(resume, resumesList.get(resume.getUuid()));
    }

    @Test
    public void clear() {
        resumesList.clear();
        Assert.assertEquals(0, resumesList.size());
    }

    @Test
    public void update() {
        Resume newResume = new Resume(UUID_1);
        resumesList.update(newResume);
        Assert.assertSame(newResume, resumesList.get(UUID_1));
    }

    @Test
    public void save() {
        resumesList.save(RESUME_4);
        assertGet(RESUME_4);
        Assert.assertEquals(4, resumesList.size());
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        resumesList.delete(UUID_1);
        Assert.assertEquals(2, resumesList.size());
        resumesList.get(UUID_1);
    }

    @Test
    public void get() {
        assertGet(RESUME_1);
        assertGet(RESUME_2);
        assertGet(RESUME_3);
    }
}