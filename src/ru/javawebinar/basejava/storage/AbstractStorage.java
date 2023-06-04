package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorage {

    public void update(Resume r) {
        int index = (int) getSearchKey(r.getUuid());
        if (index < 0) {
            throw new NotExistStorageException(r.getUuid());
        } else {
            resumesList.set(index, r);
        }
    }

    public void save(Resume r) {
        resumesList.add(r);
    }

    public void delete(String uuid) {
        int index = getSearchKey(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        } else {
            resumesList.remove(index);
        }
    }

    public Resume get(String uuid) {
        int index = (int) getSearchKey(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return resumesList.get(index);
    }
}
