package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.Config;

public class SqlStorageTest extends AbstractStorageTest {
    public SqlStorageTest() {
        super(Config.get().getStorage());
    }
}