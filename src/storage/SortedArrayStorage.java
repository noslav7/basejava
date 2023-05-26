package storage;

import model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    private Resume[] sortedStorage = new Resume[STORAGE_LIMIT];

    @Override
    public void clear() {
        Arrays.fill(sortedStorage, 0, size, null);
        size = 0;
    }

    @Override
    public void save(Resume resume) {
        int index;
        if (size > 0) {
            index = getIndex(resume.getUuid());
        } else {
            index = -1;
        }
        if (size >= STORAGE_LIMIT) {
            System.out.println("Невозможно сохранить. Предельное количество резюме достигнуто");
        } else if (index >= 0) {
            printAlreadyExists(resume.getUuid());
        } else {
            sortedStorage[size] = resume;
            size++;
        }
        if (size > 1) {
            binaryInsertionSorting(sortedStorage);
        }
    }

    @Override
    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index > -1) {
            storage[index] = r;
        } else {
            printNotFound(r.getUuid());
        }
        if (size > 1) {
            binaryInsertionSorting(sortedStorage);
        }
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index > -1) {
            sortedStorage[index] = sortedStorage[size - 1];
            sortedStorage[size - 1] = null;
            size--;
        } else {
            printNotFound(uuid);
        }
    }

    @Override
    public Resume[] getAll() {
        return Arrays.copyOfRange(sortedStorage,0, size);
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(sortedStorage, 0, size, searchKey);
    }

    private void binaryInsertionSorting(Resume[] storage) {
        for (int i = 1; i < size; i++) {
             String temporary = storage[i].getUuid();
             String previous = storage[i - 1].getUuid();
             int j = i;

             while (j - 1 >= 0 && temporary.compareTo(storage[j].getUuid()) < 0) {
                 storage[j] = storage[j - 1];
                 j--;
             }

             storage[i].setUuid(temporary);
        }
    }
}
