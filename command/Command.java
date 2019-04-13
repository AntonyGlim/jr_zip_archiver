package com.javarush.task.task31.task3110.command;

/**
 * Для каждой команды мы создадим свой собственный класс.
 * Все классы команд должны реализовывать (быть унаследованы) интерфейс Command
 */
@FunctionalInterface
public interface Command {
    void execute() throws Exception;
}
