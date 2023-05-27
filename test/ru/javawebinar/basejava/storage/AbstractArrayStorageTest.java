package ru.javawebinar.basejava.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import static org.junit.Assert.*;

public abstract class AbstractArrayStorageTest {
    Storage storage;
    static final String UUID_1 = "UUID_1";
    static final String UUID_2 = "UUID_2";
    static final String UUID_3 = "UUID_3";
    static final Resume RESUME_3_UPDATED = new Resume("UUID_3");

    @Before
    public void setUp() {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    public void size() {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void clear() {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void update() {
        storage.update(RESUME_3_UPDATED);
        Assert.assertEquals("UUID_3", storage.get(UUID_3).getUuid());
    }

    @Test
    public void getAll() {
        Assert.assertEquals(new Resume[] {new Resume("UUID_1"), new Resume("UUID_2"),
                new Resume("UUID_3")}, storage.getAll());
    }

    @Test
    public abstract void save();

    @Test
    public abstract void delete();

    @Test
    public void get() {
        Assert.assertEquals(new Resume("UUID_2"), storage.get("UUID_2"));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }
}