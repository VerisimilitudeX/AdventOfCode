package Day7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Part2 {
    public static void main(String[] args) throws IOException {
        String input = Files.readString(Paths.get("src/day7/input.txt"));
        String[] lines = input.split("\r\n");

        Node curr_dir = new Directory(new ArrayList<>(), "/", null);
        Node top_dir = curr_dir;

        for (int i = 1; i < lines.length; i++) {
            String line = lines[i];
            String[] words = line.split(" ");
            if (words[0].equals("$")) {
                switch (words[1]) {
                    case "cd":
                        if (words[2].equals("..")) {
                            curr_dir = curr_dir.parent;
                            break;
                        }
                        if (words[2].equals("/")) {
                            curr_dir = top_dir;
                            break;
                        }
                        for (Node c : curr_dir.children) {
                            if (c.name.equals(words[2])) {
                                curr_dir = c;
                                break;
                            }
                        }
                    case "ls":
                        for (int j = i + 1; j < lines.length; j++) {
                            if (lines[j].startsWith("$")) {
                                break;
                            }
                            if (lines[j].startsWith("dir")) {
                                curr_dir.addChild(new Directory(new ArrayList<>(), lines[j].split(" ")[1], curr_dir));
                            } else {
                                curr_dir.addChild(new NodeFile(Integer.parseInt(lines[j].split(" ")[0]),
                                        new ArrayList<>(), lines[j].split(" ")[1], curr_dir));
                            }
                        }
                }
            }
        }
        // int total = idfk(top_dir);
        // System.out.println(total);
        ArrayList<Node> dirs = new ArrayList<>();
        recursion_pt2(top_dir, dirs);
        int total = 0;
        for (Node n : dirs) {
            if (n.getSize() <= 100000) {
                total += n.getSize();
            }
        }
        System.out.println(total);
    }

    public static int idfk(Node n) {
        int total = 0;
        if (n.getSize() <= 100000 && n instanceof Directory) {
            total += n.getSize();
        }
        for (Node child : n.children) {
            if (child.getSize() <= 100000 && child instanceof Directory) {
                total += idfk(child);
            }
        }
        return total;
    }

    public static void recursion_pt2(Node n, ArrayList<Node> list) {
        if (n instanceof Directory) {
            list.add(n);
        }
        for (Node c : n.children) {
            recursion_pt2(c, list);
        }
    }
}

abstract class Node {
    String name;
    ArrayList<Node> children;
    Node parent;

    public Node(ArrayList<Node> children, String name, Node parent) {
        this.children = children;
        this.name = name;
        this.parent = parent;
    }

    public void addChild(Node c) {
        this.children.add(c);
    }

    public int getSize() {
        if (this instanceof NodeFile) {
            return ((NodeFile) this).size;
        } else {
            int total = 0;
            for (Node c : this.children) {
                total += c.getSize();
            }
            return total;
        }
    }

    @Override
    public String toString() {
        return String.valueOf(this.getSize());
    }
}

class Directory extends Node {
    public Directory(ArrayList<Node> children, String name, Node parent) {
        super(children, name, parent);
    }
}

class NodeFile extends Node {
    int size;

    public NodeFile(int size, ArrayList<Node> children, String name, Node parent) {
        super(children, name, parent);
        this.size = size;
    }
}
