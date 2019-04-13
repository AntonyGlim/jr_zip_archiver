package com.javarush.task.task31.task3110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;

/**
 * Главный класс приложения "Архиватор"
 */
public class Archiver {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите полный путь к архиву, в котором будет храниться файл");
        String pathToArchive = reader.readLine();

        ZipFileManager zipFileManager = new ZipFileManager(Paths.get(pathToArchive));

        System.out.println("Введите полный путь к файлу, который требуется архивировать");
        String pathToFile = reader.readLine();

        try {
            zipFileManager.createZip(Paths.get(pathToFile));
        } catch (Exception e) {
            e.printStackTrace();
        }

        reader.close();
    }

}
