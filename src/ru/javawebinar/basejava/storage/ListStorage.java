package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    protected final List<Resume> resumesList;

    public ListStorage(List<Resume> resumesList) {
        this.resumesList = resumesList;
    }

    @Override
    public void clear() {
        resumesList.clear();
    }

    @Override
    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index < 0) {
            throw new NotExistStorageException(r.getUuid());
        } else {
            resumesList.set(index, r);
        }
    }

    @Override
    public void save(Resume r) {
            resumesList.add(r);
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        } else {
            resumesList.remove(index);
        }
    }

    @Override
    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return resumesList.get(index);
    }

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < resumesList.size(); i++) {
            if (uuid.equals(resumesList.get(i).getUuid())) {
                return i;
            }
        }
        return -1;
    }

    public List<Resume> getAllfromList() {
        return new ArrayList<Resume>(resumesList);
    }
}
