package ru.javawebinar.basejava.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractArrayStorageTest {
    protected final Storage storage;
    protected static final String UUID_1 = "UUID_1";
    protected static final String UUID_2 = "UUID_2";
    protected static final String UUID_3 = "UUID_3";
    protected static final String UUID_4 = "UUID_4";
    protected static final Resume RESUME_1 = new Resume(UUID_1);
    protected static final Resume RESUME_2 = new Resume(UUID_2);
    protected static final Resume RESUME_3 = new Resume(UUID_3);
    protected static final Resume RESUME_4 = new Resume(UUID_4);
    protected static final Resume[] expected = new Resume[] {RESUME_1, RESUME_2, RESUME_3};
    protected static final String UUID_NOT_EXIST = "dummy";

    protected AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

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
        Resume newResume = new Resume(UUID_1);
        storage.update(newResume);
        Assert.assertSame(newResume, storage.get(UUID_1));
    }

    @Test
    public void getAll() {
        Assert.assertArrayEquals(expected, storage.getAll());
    }

    @Test
    public void save() {
        storage.save(RESUME_4);
        assertGet(RESUME_4);
        assertSize(4);
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        storage.delete(UUID_1);
        Assert.assertArrayEquals(new Resume[] {RESUME_3, RESUME_2},
                storage.getAll());
        assertSize(2);
        storage.get(UUID_1);
    }

    @Test
    public void get() {
        assertGet(RESUME_1);
        assertGet(RESUME_2);
        assertGet(RESUME_3);
    }

    public void assertGet(Resume resume) {
        Assert.assertEquals(resume, storage.get(resume.getUuid()));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get(UUID_NOT_EXIST);
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        storage.update(RESUME_4);
    }

    @Test(expected = StorageException.class)
    public void saveOverflow() {
        storage.clear();
        int uuidNumber = 0;
        try {
            for (int i = 0; i < 10_000; i++) {
                storage.save(new Resume("UUID_" + uuidNumber++));
            }
        } catch (StorageException storageException) {
            Assert.fail("Premature StorageException");
        }
        storage.save(new Resume("UUID_10001"));
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete(UUID_NOT_EXIST);
    }

    @Test(expected = NotExistStorageException.class)
    public void deletedElementNotExist() {
        storage.delete(UUID_3);
        assertSize(2);
        storage.get(UUID_3);
    }

    @Test(expected = StorageException.class)
    public void saveAlreadyExisting() {
        storage.save(RESUME_2);
    }
}