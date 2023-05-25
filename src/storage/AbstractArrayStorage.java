package storage;

import model.Resume;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Resume " + uuid + " does not exist");
            return null;
        }
        return storage[index];
    }

    protected abstract int getIndex(String uuid);

    public void printNotFound(String uuid) {
        System.out.println("Резюме с uuid " + uuid + " не найдено");
    }

    public void printAlreadyExists(String uuid) {
        System.out.println("Резюме с uuid " + uuid + " уже существует");
    }
}
