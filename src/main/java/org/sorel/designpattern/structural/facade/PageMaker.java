package org.sorel.designpattern.structural.facade;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PageMaker {
    private PageMaker() {

    }

    public static void makeWelcomePage(String mailAddress, String fileName) {
        try {
            Properties mailProperties = Database.getProperties("maildata");
            String userName = mailProperties.getProperty(mailAddress);
            // 文件默认生成到 /target/classes 目录下
            fileName = PageMaker.class.getClassLoader().getResource("").getPath() + fileName;
            HtmlWriter writer = new HtmlWriter(new FileWriter(fileName));
            writer.title("Welcome to " + userName + "'s page!");
            writer.paragraph("欢迎来到" + userName + "的主页。");
            writer.paragraph("等着你的邮件哦！");
            writer.mailto(mailAddress, userName);
            writer.close();
            System.out.println(fileName + " is created for " + mailAddress + " (" + userName + ")");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
