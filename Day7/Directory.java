package Day7;

import java.util.ArrayList;

public class Directory {
    public Directory() {
        this.name = "";
        this.size = 0;
        this.files = new ArrayList<FileType>();
        this.subdirectories = new ArrayList<Directory>();
    }

    String name;
    int size;
    ArrayList<FileType> files;
    ArrayList<Directory> subdirectories;
}
