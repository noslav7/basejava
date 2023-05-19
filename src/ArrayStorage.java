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
        Resume[] new_storage = Arrays.copyOf(storage, storage.length + 1);
        new_storage[new_storage.length - 1] = r;
        storage = new_storage;
    }

    Resume get(String uuid) {
        Resume resume = null;
        for (Resume value : storage) {
            if (value.uuid.equals(uuid)) {
                resume = value;
            }
        }
        return resume;
    }

    void delete(String uuid) {
        int index = -1;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].uuid.equals(uuid)) {
                index = i;
            }
        }
        Resume[] new_storage = new Resume[storage.length - 1];
        for (int i = 0, k = 0; i < storage.length; i++) {
            if (i != index) {
                new_storage[k] = storage[i];
                k++;
            }
        }
        storage = new_storage;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, storage.length);
    }

    int size() {
        int size = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                size++;
            }
        }
        return size;
    }
}
