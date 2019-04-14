package com.javarush.task.task31.task3110;

/**
 * Класс призван отвечать за свойства каждого файла в архиве.
 * Свойства - это набор, состоящий из:
 * имя файла, размер файла до и после сжатия, метод сжатия.
 */
public class FileProperties {

    private String name; //Имя файла
    private long size; //Размер в байтах
    private long compressedSize; //Размер после сжатия в байтах
    private int compressionMethod; //Метод сжатия

    public FileProperties(String name, long size, long compressedSize, int compressionMethod) {
        this.name = name;
        this.size = size;
        this.compressedSize = compressedSize;
        this.compressionMethod = compressionMethod;
    }

    /**
     * будет считать степень сжатия по формуле
     * @return
     */
    public long getCompressionRatio(){
        return 100 - ((compressedSize * 100) / size);
    }

    /***/
    @Override
    public String toString() {
        String s = name;
        if (size > 0){
            s = String.format("%s %d Kb (%d Kb) сжатие: %d%%",
                    name,
                    (size / 1024),
                    (compressedSize / 1024),
                    getCompressionRatio());
        }
        return s;
    }

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    public long getCompressedSize() {
        return compressedSize;
    }

    public int getCompressionMethod() {
        return compressionMethod;
    }
}
