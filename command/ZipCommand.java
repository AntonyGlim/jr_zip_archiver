package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Базовый класс для комад,
 * которые  работают непосредственно с архивом
 * (не являются вспомогательными)
 */
public abstract class ZipCommand implements Command {
    public ZipFileManager getZipFileManager() throws Exception{
        ConsoleHelper.writeMessage("Необходимо ввести полный путь файла архива");
        Path fullPath = Paths.get(ConsoleHelper.readString());
        return new ZipFileManager(fullPath) ;
    }
}
