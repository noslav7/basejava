import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        Arrays.fill(storage, null);
    }

    void save(Resume r) {
        storage = getResumesWithoutNulls();
        Resume[] newStorage = Arrays.copyOf(storage, storage.length + 1);
        newStorage[newStorage.length - 1] = r;
        storage = newStorage;
    }

    Resume get(String uuid) {
        Resume[] getStorage = getResumesWithoutNulls();
        int index = -1;
        for (int i = 0; i < getStorage.length; i++) {
            if (getStorage[i].getUuid().equals(uuid)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            return getStorage[index];
        } else {
            return null;
        }
    }

    void delete(String uuid) {
        int index = -1;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].uuid.equals(uuid)) {
                index = i;
                break;
            }
        }
        Resume[] newStorage = new Resume[storage.length - 1];
        for (int i = 0, k = 0; i < storage.length; i++) {
            if (i != index) {
                newStorage[k] = storage[i];
                k++;
            }
        }
        storage = newStorage;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        storage = getResumesWithoutNulls();
        return Arrays.copyOf(storage, storage.length);
    }

    int size() {
        int size = 0;
        for (Resume resume : storage) {
            if (resume != null) {
                size++;
            }
        }
        return size;
    }

    private Resume[] getResumesWithoutNulls() {
        int actualSize = size();
        Resume[] getStorage = new Resume[actualSize];
        int k = 0;
        for (Resume resume : storage) {
            if (resume != null) {
                getStorage[k] = resume;
                k++;
            }
        }
        return getStorage;
    }
}
