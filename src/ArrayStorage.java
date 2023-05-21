import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = size();

    void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    void save(Resume r) {
        storage = Arrays.copyOf(storage, size + 1);
        storage[storage.length - 1] = r;
        size++;
    }

    Resume get(String uuid) {
        storage = Arrays.copyOf(storage, size);
        int index = -1;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            return storage[index];
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
        size--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size);
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
}
