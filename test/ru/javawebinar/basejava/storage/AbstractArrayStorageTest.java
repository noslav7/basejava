package ru.javawebinar.basejava.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractArrayStorageTest {
    protected Storage storage;
    protected static final String UUID_1 = "UUID_1";
    protected static final String UUID_2 = "UUID_2";
    protected static final String UUID_3 = "UUID_3";
    protected static final String UUID_4 = "UUID_4";
    protected static final Resume RESUME_1 = new Resume(UUID_1);
    protected static final Resume RESUME_2 = new Resume(UUID_2);
    protected static final Resume RESUME_3 = new Resume(UUID_3);
    protected static final Resume RESUME_4 = new Resume(UUID_4);
    protected static final Resume[] expected = new Resume[] {RESUME_1, RESUME_2, RESUME_3};

    @Before
    public void setUp() {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Test
    public void size() {
        assertSize(3);
    }

    public void assertSize(int size) {
        Assert.assertEquals(size, storage.size());
    }

    @Test
    public void clear() {
        storage.clear();
        assertSize(0);
        Assert.assertArrayEquals(new Resume[0], storage.getAll());
    }

    @Test
    public void update() {
        storage.update(new Resume(UUID_1));
        Assert.assertSame(UUID_1, storage.get(UUID_1).getUuid());
    }

    @Test
    public void getAll() {
        Assert.assertArrayEquals(expected, storage.getAll());
    }

    @Test
    public abstract void save();

    @Test
    public abstract void delete();

    @Test
    public void get() {
        assertGet(RESUME_2);
    }

    public void assertGet(Resume resume) {
        Assert.assertEquals(resume, storage.get(resume.getUuid()));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }

    @Test(expected = NotExistStorageException.class)
    public void whenUpdatedWithNewUUIDThanDoNotExist() {
        storage.update(RESUME_4);
    }

    @Test(expected = StorageException.class)
    public void whenSaveIntoFullArrayThanStorageException() {
        int uuidNumber = 4;
        for (int i = 0; i < 9997; i++) {
            storage.save(new Resume("UUID_" + uuidNumber++));
        }
        storage.save(new Resume("UUID_10001"));
    }

    @Test(expected = NotExistStorageException.class)
    public void whenDeleteUnknownIndexThanStorageException() {
        storage.delete("UUID_10001");
    }
}