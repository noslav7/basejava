package storage;

import model.Resume;
import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume r) {
        if (size == storage.length) {
            System.out.println("Невозможно сохранить. Предельное количество резюме достигнуто");
            return;
        }
        for (int i = 0; i < size; i++) {
            if (storage[i].equals(r)) {
                System.out.println("Резюме с uuid " + r.getUuid() + " уже существует");
                return;
            }
        }
        storage[size] = r;
        size++;
    }

    public void update(Resume resume) {
        boolean uuidExists = false;
        for (int i = 0; i < size; i++) {
            if (storage[i].equals(resume)) {
                //верна ли сигнатура метода update?
                //storage[i] = resume; ?
                return;
            }
        }
        if (!uuidExists) {
            printNotFound(resume.getUuid());
        }
    }

    public Resume get(String uuid) {
        boolean uuidExists = false;
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return storage[i];
            }
        }
        if (!uuidExists) {
            printNotFound(uuid);
        }
        return null;
    }

    public void delete(String uuid) {
        int index = -1;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                index = i;
                break;
            }
        }
        if (index > -1) {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("Резюме с uuid " + uuid + " не существует");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public void printNotFound(String uuid) {
        System.out.println("Резюме с uuid " + uuid + " не найдено");
    }

    public int getSize() {
        return size;
    }
}
