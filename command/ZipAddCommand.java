package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;
import com.javarush.task.task31.task3110.exception.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Команда добавления файла в архив
 */
public class ZipAddCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try{
            ConsoleHelper.writeMessage("Добавление файла в архив.");

            ZipFileManager zipFileManager = getZipFileManager();

            ConsoleHelper.writeMessage("Введите полный путь файла который хотите обавить:");
            Path sourcePath = Paths.get(ConsoleHelper.readString());
            try {
                zipFileManager.addFile(sourcePath);
            } catch (PathIsNotFoundException e){
                ConsoleHelper.writeMessage("Файл не найден.");
            }

            ConsoleHelper.writeMessage("Операция добавления завершена.");
        } catch (PathIsNotFoundException e){
            ConsoleHelper.writeMessage("Файл не был найден.");
        }
    }
}
