package storage;

import model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    private Resume[] sortedStorage;

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public void update(Resume r) {
        sortedStorage = binaryInsertionSorting(storage);
        int index = getIndex(r.getUuid());
        if (size >= STORAGE_LIMIT) {
            System.out.println("Невозможно сохранить. Предельное количество резюме достигнуто");
        } else if (index >= 0) {
            printAlreadyExists(r.getUuid());
        } else {
            sortedStorage[size] = r;
            size++;
        }
    }

    @Override
    public void save(Resume resume) {
        sortedStorage = binaryInsertionSorting(storage);
        int index = getIndex(resume.getUuid());
        if (index > -1) {
            sortedStorage[index] = resume;
        } else {
            printNotFound(resume.getUuid());
        }
    }

    @Override
    public void delete(String uuid) {
        sortedStorage = binaryInsertionSorting(storage);
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
        sortedStorage = binaryInsertionSorting(storage);
        return Arrays.copyOfRange(sortedStorage,0, size);
    }

    @Override
    protected int getIndex(String uuid) {
        sortedStorage = binaryInsertionSorting(storage);
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(sortedStorage, 0, size, searchKey);
    }

    private static Resume[] binaryInsertionSorting(Resume[] storage) {
    /*    for (int i = 1; i < size; i++) {
            int x = array[i];

            // Find location to insert
            // using binary search
            int j = Math.abs(
                    Arrays.binarySearch(array, 0,
                            i, x) + 1);

            // Shifting array to one
            // location right
            System.arraycopy(array, j,
                    array, j + 1, i - j);

            // Placing element at its
            // correct location
            array[j] = x;
        }  */
        return new Resume[0];
    }
}
