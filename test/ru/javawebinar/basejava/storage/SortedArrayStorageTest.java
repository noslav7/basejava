package ru.javawebinar.basejava.storage;

import org.junit.Assert;
import org.junit.Before;
import ru.javawebinar.basejava.model.Resume;

import static org.junit.Assert.*;

public class SortedArrayStorageTest extends AbstractArrayStorageTest {
    static final Resume RESUME_2_SAVE = new Resume("UUID_2");

    @Before
    public void setUp() {
        storage = new SortedArrayStorage();
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Override
    public void save() {
        storage.delete("UUID_1");
        storage.delete("UUID_2");
        storage.save(RESUME_2_SAVE);
        Assert.assertEquals(new Resume[] {new Resume("UUID_2"),
                        new Resume("UUID_3")}, storage.getAll());
    }

    @Override
    public void delete() {
        storage.delete("UUID_1");
        Assert.assertEquals(new Resume[] {new Resume("UUID_2"), new Resume("UUID_3")},
                storage.getAll());
    }
}