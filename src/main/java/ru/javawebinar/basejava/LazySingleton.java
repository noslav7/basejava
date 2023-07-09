package ru.javawebinar.basejava;

public class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {
    }

    private static class LazySingletonHolder {
        private static final LazySingleton INSTANCE = new LazySingleton();
    }
//    private static LazySingleton getInstance() {
//        if (instance == null) {
//            synchronized (LazySingleton.class) {
//                if (instance == null) {
//                    instance = new LazySingleton();
//                }
//            }
//        }
//        return instance;
//    }

    public LazySingleton getInstance() {
        return LazySingletonHolder.INSTANCE;
    }

}
