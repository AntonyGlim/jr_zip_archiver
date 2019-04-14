package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.exception.PathIsNotFoundException;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Менеджер архива.
 * Он будет совершать операции над файлом архива
 * (файлом, который будет храниться на диске и иметь расширение zip)
 */
public class ZipFileManager {

    private Path zipFile; //полный путь к архиву, с которым будем работать (в нем будем зранить ф-лы)

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    /**
     * Метод создаст новый архив и добавит в него файл
     * @param source - это путь к чему-то, что мы будем архивировать
     * @throws Exception
     */
    public void createZip(Path source) throws Exception{
        if(!Files.exists(zipFile.getParent())){ // директория не существует?
            Files.createDirectories(zipFile.getParent());
        }

        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile))){ //новый поток архива
            if (Files.isRegularFile(source)) {
                addNewZipEntry(zipOutputStream, source.getParent(), source.getFileName());
            } else if (Files.isDirectory(source)){
                FileManager fileManager = new FileManager(source);
                List<Path> fileNames = fileManager.getFileList();
                for (Path path : fileNames) {
                    addNewZipEntry(zipOutputStream, source, path);
                }

            } else {
                throw new PathIsNotFoundException();
            }
        }
    }

    private void addNewZipEntry(ZipOutputStream zipOutputStream, Path filePath, Path fileName) throws Exception{
        try (InputStream inputStream = Files.newInputStream(filePath.resolve(fileName))) {
            ZipEntry zipEntry = new ZipEntry(fileName.toString());
            zipOutputStream.putNextEntry(zipEntry);
            copyData(inputStream, zipOutputStream);
            zipOutputStream.closeEntry();
        }
    }

    /**
     * Он должен читать данные из in и записывать в out, пока не вычитает все.
     * @param in
     * @param out
     * @throws Exception
     */
    private void copyData(InputStream in, OutputStream out) throws Exception{
        byte[] buffer = new byte[4096];
        int len;
        while ((len = in.read(buffer)) > 0){
            out.write(buffer, 0, len);
        }
    }

}
