package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    protected List<Resume> resumesList = new ArrayList<>();

    public ListStorage(List<Resume> resumesList) {
        this.resumesList = resumesList;
    }

    public void clear() {
        resumesList.clear();
    }

    public int size() {
        return resumesList.size();
    }

    public Object getSearchKey(String uuid) {
        for (int i = 0; i < resumesList.size(); i++) {
            if (uuid.equals(resumesList.get(i).getUuid())) {
                return i;
            }
        }
        return -1;

    public List<Resume> getAllFromList() {
        return new ArrayList<Resume>(resumesList);
    }
}
