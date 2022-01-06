package lesson3.task1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    static File src;
    static File res;
    static  File savegames;
    static File temp;
    static  File main;
    static File test;
    static  File fileMain;
    static  File fileUtils;
    static File drawables;
    static File vectors;
    static File icons;
    static File fileTemp;

    public static void main(String[] args) {
        StringBuilder log = new StringBuilder();
        newDir( src, "C://Games/src",log);
        newDir( res, "C://Games/res", log);
        newDir( savegames, "C://Games/savegames",log);
        newDir( temp, "C://Games/temp", log);
        newDir( main, "C://Games/src/main", log);
        newDir( test, "C://Games/src/test",log);
        newFile(fileMain,"C://Games/src/main//Main.java", log );
        newFile(fileUtils,"C://Games/src/main//Utils.java", log );
        newDir( drawables, "C://Games/res/drawables", log);
        newDir( vectors, "C://Games/src/vectors", log);
        newDir( icons, "C://Games/src/icons",log);
        newFile(fileTemp,"C://Games/temp//temp.txt",log );
        try (FileWriter writer = new FileWriter("C://Games/temp//temp.txt", true)){
            writer.write(log.toString()+"\n");
        } catch (IOException e) {
            e.getMessage();
        }


    }
    public static void newDir(File dir, String path, StringBuilder log){
     dir = new File(path);
     if(dir.mkdir()){
      log.append("Дерриктория "+dir.getName()+" создана \n");
     }
    }
    public static void newFile(File file, String path, StringBuilder log){
        file = new File(path);
        try {
            if(file.createNewFile()){
                log.append("Файл "+file.getName()+" создан \n");
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }

}
