package ru.javawebinar.basejava.storage;

import org.junit.Assert;
import org.junit.Before;
import ru.javawebinar.basejava.model.Resume;

public class SortedArrayStorageTest extends AbstractArrayStorageTest {
    static final Resume RESUME_2_SAVE = new Resume("UUID_2");

    public SortedArrayStorageTest() {
        super(new SortedArrayStorage());
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Override
    public void save() {
        storage.delete(UUID_1);
        storage.delete(UUID_2);
        storage.save(RESUME_2_SAVE);
        Assert.assertArrayEquals(new Resume[] {new Resume("UUID_2"),
                        new Resume("UUID_3")}, storage.getAll());
        assertSize(2);
    }

    @Override
    public void delete() {
        storage.delete(UUID_1);
        Assert.assertArrayEquals(new Resume[] {new Resume("UUID_2"), new Resume("UUID_3")},
                storage.getAll());
        assertSize(2);
    }
}