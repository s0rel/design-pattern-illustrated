package org.sorel.designpattern.creational.abstractfactory.factory;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public abstract class Page implements HTMLable {
    protected String title;
    protected String author;
    protected List<Item> contents = new ArrayList<>();

    public Page(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void add(Item item) {
        contents.add(item);
    }

    public void output() {
        String fileName = title + ".html";
        try (Writer writer = new FileWriter(fileName)) {
            writer.write(this.makeHTML());
            System.out.println(fileName + "编写完成");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
