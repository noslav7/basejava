package ru.javawebinar.basejava.storage;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                ArrayStorageTest.class,
                SortedArrayStorageTest.class,
                ListStorageTest.class,
                MapUuidStorageTest.class,
                MapUuidStorageTest.class,
                ObjectStreamStorageTest.class
        })
public class AllStorageTest {
}
