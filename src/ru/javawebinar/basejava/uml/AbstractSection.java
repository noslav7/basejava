package ru.javawebinar.basejava.uml;

import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractSection {

    protected abstract void update(Resume resume, Integer searchKey);

    protected abstract void save(Resume resume);

    protected abstract void delete(Integer searchKey);

    protected abstract Resume get(Integer searchKey);
}
