package com.javarush.task.task31.task3110;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * для получения списка всех файлов в какой-то папке
 */
public class FileManager {

    private Path rootPath; //корневой путь директории, файлы которой нас интересуют
    private List<Path> fileList; //список относительных путей файлов внутри rootPath

    FileManager(Path rootPath) throws IOException {
        this.rootPath = rootPath;
        fileList = new ArrayList<>();
        collectFileList(rootPath);
    }

    public List<Path> getFileList() {
        return fileList;
    }

    /**
     * Метод будет складывать в переменную класса fileList все файлы,
     * обнаруженные внутри переданного пути path,
     * вызывая сам себя для всех объектов,
     * в обнаруженных директориях.
     * @param path
     * @throws IOException
     */
    private void collectFileList(Path path) throws IOException {
        if (Files.isRegularFile(path)){ //если переданный путь path является обычным файлом
            fileList.add(rootPath.relativize(path)); //получить его относительный путь
        }
        if (Files.isDirectory(path)){ //Если переданный путь path, является директорией
            try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) { //пройтись по всему содержимому директории
                for (Path p : directoryStream) {
                    collectFileList(p);
                }
            }
        }
    }

}
