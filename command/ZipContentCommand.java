package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.FileProperties;
import com.javarush.task.task31.task3110.ZipFileManager;

/**
 * Команда просмотра содержимого архива
 */
public class ZipContentCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("Просмотр содержимого архива.");
        ZipFileManager zipFileManager = getZipFileManager();
        ConsoleHelper.writeMessage("Содержимое архива:");
        for (FileProperties fileProperty : zipFileManager.getFilesList()) {
            ConsoleHelper.writeMessage(fileProperty.toString());
        }
        ConsoleHelper.writeMessage("Содержимое архива прочитано.");
    }
}
