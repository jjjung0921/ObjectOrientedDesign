package Composite;

import Composite.src.Directory;
import Composite.src.File;

public class Main {
    public static void main(String[] args){
        System.out.println("Making root entries...");
        Directory rootDir = new Directory("root");
        Directory binDir = new Directory("bin");
        Directory tmpDir = new Directory("tmp");
        Directory usrDir = new Directory("usr");
        rootDir.add(binDir);
        rootDir.add(tmpDir);
        rootDir.add(usrDir);
        binDir.add(new File("vi", 10000));
        binDir.add(new File("latex", 20000));
        rootDir.printList();
        System.out.println("");

        System.out.println("Making user entries...");
        Directory KimDir = new Directory("Kim");
        Directory LeeDir = new Directory("Lee");
        Directory ParkDir = new Directory("Park");
        usrDir.add(KimDir);
        usrDir.add(LeeDir);
        usrDir.add(ParkDir);
        KimDir.add(new File("diary.html", 100));
        KimDir.add(new File("Composite.java", 200));
        usrDir.printList();
    }
}