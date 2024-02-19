package org.sorel.designpattern.creational.builder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class HTMLBuilder extends Builder {
    private String fileName;
    private PrintWriter writer;

    @Override
    protected void buildTitle(String title) {
        fileName = title + ".html";
        try {
            writer = new PrintWriter(new FileWriter(fileName));
            writer.println("<meta http-equiv=\"Content-Type\" content=\"text/html;charset=utf-8\"/>");
            writer.println("<html><head><title>" + title + "</title></head><body>");
            writer.println("<h1>" + title + "</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void buildString(String string) {
        writer.println("<p>" + string + "</p>");
    }

    @Override
    protected void buildItems(String[] items) {
        writer.println("<ul>");
        for (String item : items) {
            writer.println("<li>" + item + "</li>");
        }
        writer.println("</ul>");
    }

    @Override
    protected void buildDone() {
        writer.write("</body></html>");
        writer.close();
    }

    public String getResult() {
        return fileName;
    }
}
