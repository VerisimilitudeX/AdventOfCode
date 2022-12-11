package Day7;

import java.util.ArrayList;

public class Directory {
    public String name;
    public int size;
    public int parentDirectoryLineNum;
    public ArrayList<FileType> files;
    public ArrayList<Directory> subdirectories;
    public boolean topLevel;

    public Directory() {
        this.name = "";
        this.size = 0;
        this.parentDirectoryLineNum = 0;
        this.files = new ArrayList<FileType>();
        this.subdirectories = new ArrayList<Directory>();
        this.topLevel = false;
    }
}
