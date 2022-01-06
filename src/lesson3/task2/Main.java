package lesson3.task2;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class Main {
    public static void main(String[] args) {
        GameProgress game1 = new GameProgress(80, 70, 4, 34);
        GameProgress game2 = new GameProgress(70, 40, 5, 40);
        GameProgress game3 = new GameProgress(45, 50, 6, 45);
        saveGame("C://Games/savegames//game1.dat", game1);
        saveGame("C://Games/savegames//game2.dat", game2);
        saveGame("C://Games/savegames//game3.dat", game3);
File savegames = new File("C://Games/savegames");
zipFiles("C://Games/savegames/zip.zip", savegames.listFiles());
    }

    public static void saveGame(String path, GameProgress gameSave) {
        try (FileOutputStream out = new FileOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(out)) {
            oos.writeObject(gameSave);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void zipFiles(String pathZip, File [] files) {



        try (ZipOutputStream zout = new ZipOutputStream
                (new FileOutputStream(pathZip))){
            for (File item: files
                 ) {
                byte[] buffer;
                try (FileInputStream fis = new FileInputStream(item.getPath())) {
                    ZipEntry entry = new ZipEntry(item.getName());
                    zout.putNextEntry(entry);
                    buffer = new byte[fis.available()];
                    fis.read(buffer);
                }
                zout.write(buffer);
                zout.closeEntry();
               item.delete();
            }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

}
