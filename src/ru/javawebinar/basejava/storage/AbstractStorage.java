package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void update(Resume r) {
        Object searchKey = getSearchKey(r.getUuid());
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(r.getUuid());
        } else {
            doUpdate(r, searchKey);
        }
    }

    protected abstract Object getSearchKey(String uuid);

    protected abstract void doUpdate(Resume r, Object searchKey);

    protected abstract boolean isExist(Object searchKey);

    public void save(Resume r) {
        Object searchKey = getSearchKey(r.getUuid());
        if (!isExist(searchKey)) {
            throw new ExistStorageException(r.getUuid());
        } else {
            doSave(r, searchKey);
        }
    }

    protected abstract void doSave(Resume r, Object searchKey);

    public void delete(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        } else {
            doDelete(searchKey);
        }
    }

    protected abstract void doDelete(Object searchKey);

    public Resume get(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        } else {
            return doGet(searchKey);
        }
    }

    protected abstract Resume doGet(Object searchKey);
}
