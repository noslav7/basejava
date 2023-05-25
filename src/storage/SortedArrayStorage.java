package storage;

import model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    private Resume[] sortedStorage;

    @Override
    public void clear() {
        Arrays.fill(sortedStorage, 0, size, null);
        size = 0;
    }

    @Override
    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (size >= STORAGE_LIMIT) {
            System.out.println("Невозможно сохранить. Предельное количество резюме достигнуто");
        } else if (index >= 0) {
            printAlreadyExists(r.getUuid());
        } else {
            sortedStorage[size] = r;
            size++;
        }
        if (size > 1) {
            binaryInsertionSorting(sortedStorage);
        }
    }

    @Override
    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index > -1) {
            sortedStorage[index] = resume;
        } else {
            printNotFound(resume.getUuid());
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
    }
}
