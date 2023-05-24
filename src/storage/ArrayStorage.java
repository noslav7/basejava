package storage;

import model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private final Resume[] storage = new Resume[STORAGE_LIMIT];
    private int size;

    protected static final int STORAGE_LIMIT = 10000;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (size == storage.length) {
            System.out.println("Невозможно сохранить. Предельное количество резюме достигнуто");
        } else if (index >= 0) {
            printAlreadyExists(r.getUuid());
        } else {
            storage[size] = r;
            size++;
        }
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index > -1) {
            storage[index] = resume;
        } else {
            printNotFound(resume.getUuid());
        }
    }

    public Resume get(String uuid) {
        Resume resume = null;
        int index = getIndex(uuid);
        if (index == -1) {
            printNotFound(uuid);
            return null;
        } else {
            return storage[index];
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index > -1) {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else {
            printNotFound(uuid);
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public void printNotFound(String uuid) {
        System.out.println("Резюме с uuid " + uuid + " не найдено");
    }

    public void printAlreadyExists(String uuid) {
        System.out.println("Резюме с uuid " + uuid + " уже существует");
    }

    public int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    public int getSize() {
        return size;
    }
}
