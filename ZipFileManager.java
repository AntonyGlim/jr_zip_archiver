package com.javarush.task.task31.task3110;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
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
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile))){ //новый поток архива
            ZipEntry zipEntry = new ZipEntry(source.getFileName().toString());
            zipOutputStream.putNextEntry(zipEntry); //Добавим в поток архива созданный элемент архива.
            try (InputStream inputStream = Files.newInputStream(source)){
                byte[] buffer = new byte[4096];
                int len;
                while ((len = inputStream.read(buffer)) > 0){
                    zipOutputStream.write(buffer, 0, len);
                }
            }
            zipOutputStream.closeEntry();
        }
    }
}
