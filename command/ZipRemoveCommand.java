package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Команда удаления файла из архива
 */
public class ZipRemoveCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {

        ConsoleHelper.writeMessage("Удаление из архива.");

        ZipFileManager zipFileManager = getZipFileManager();

        ConsoleHelper.writeMessage("Введите имя файла, который необходимо удалить:");
        Path filePath = Paths.get(ConsoleHelper.readString());
        zipFileManager.removeFile(filePath);

        ConsoleHelper.writeMessage("Архив был распакован.");

    }
}
