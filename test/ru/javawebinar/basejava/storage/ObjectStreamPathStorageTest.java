package ru.javawebinar.basejava.storage;

import java.io.File;

public class ObjectStreamPathStorageTest extends AbstractStorageTest {

    public ObjectStreamPathStorageTest() {
        super(new ObjectStreamStorage(new File(STORAGE_DIR.getAbsolutePath())));
    }
}