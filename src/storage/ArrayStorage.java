package storage;

import model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private final Resume[] STORAGE_LIMIT = new Resume[10000];
    private int size;

    public void clear() {
        Arrays.fill(STORAGE_LIMIT, 0, size, null);
        size = 0;
    }

    public void save(Resume r) {
        if (size == STORAGE_LIMIT.length) {
            System.out.println("Невозможно сохранить. Предельное количество резюме достигнуто");
            return;
        }
        for (int i = 0; i < size; i++) {
            if (STORAGE_LIMIT[i].getUuid().equals(r.getUuid())) {
                printAlreadyExists(r.getUuid());
                return;
            }
        }
        STORAGE_LIMIT[size] = r;
        size++;
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index > -1) {
            STORAGE_LIMIT[index] = resume;
        } else {
            printNotFound(resume.getUuid());
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            printNotFound(uuid);
        }
        return null;
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index > -1) {
            STORAGE_LIMIT[index] = STORAGE_LIMIT[size - 1];
            STORAGE_LIMIT[size - 1] = null;
            size--;
        } else {
            printNotFound(uuid);
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOf(STORAGE_LIMIT, size);
    }

    public void printNotFound(String uuid) {
        System.out.println("Резюме с uuid " + uuid + " не найдено");
    }

    public void printAlreadyExists(String uuid) {
        System.out.println("Резюме с uuid " + uuid + " уже существует");
    }

    public int getIndex(String uuid) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (STORAGE_LIMIT[i].getUuid().equals(uuid)) {
                index = i;
            }
        }
        return index;
    }

    public int getSize() {
        return size;
    }
}
