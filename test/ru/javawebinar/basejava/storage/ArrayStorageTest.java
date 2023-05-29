package ru.javawebinar.basejava.storage;

import org.junit.Assert;
import org.junit.Before;
import ru.javawebinar.basejava.model.Resume;

public class ArrayStorageTest extends AbstractArrayStorageTest {

    @Before
    public void setUp() {
        storage = new ArrayStorage();
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));

    }

    @Override
    public void save() {
        storage.save(RESUME_4);
        assertGet(RESUME_4);
        assertSize(4);
    }

    @Override
    public void delete() {
        storage.delete(UUID_1);
        Assert.assertArrayEquals(new Resume[] {new Resume("UUID_3"), new Resume("UUID_2")},
                storage.getAll());
        assertSize(2);
    }
}