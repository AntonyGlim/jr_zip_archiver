package com.javarush.task.task31.task3110;

import java.nio.file.Path;

/**
 * Менеджер архива.
 * Он будет совершать операции над файлом архива
 * (файлом, который будет храниться на диске и иметь расширение zip)
 */
public class ZipFileManager {

    private Path zipFile; //полный путь к архиву, с которым будем работать

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    /**
     *
     * @param source - это путь к чему-то, что мы будем архивировать
     * @throws Exception
     */
    public void createZip(Path source) throws Exception{

    }
}
