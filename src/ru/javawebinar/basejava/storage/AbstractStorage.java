package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorage {
    public abstract void clear();

    public abstract void update(Resume r);

    public abstract int size();

    public abstract void save(Resume r);

    public abstract void delete(String uuid);

    public abstract Resume get(String uuid);

    protected abstract int getIndex(String uuid);
}
