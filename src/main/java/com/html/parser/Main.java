package com.html.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.File;
import java.io.IOException;

public class Main {



    private static String CHARSET_NAME = "utf8";

    public static void main(String[] args) {

        String resourcePath = "/home/vitalii/Documents/test/startbootstrap-sb-admin-2-examples/";//sample-2-container-and-clone.html";//sample-1-evil-gemini.html";//sample-0-origin.html";//"./samples/startbootstrap-freelancer-gh-pages-cut.html";
        String [] resourceFiles={
                "sample-0-origin.html",
                "sample-1-evil-gemini.html",
                "sample-2-container-and-clone.html",
                "sample-3-the-escape.html",
                "sample-4-the-mash.html"
        };
        String className="panel-body";
        String buttonName = "Make everything OK";

        for (int i=0;i<resourceFiles.length-1;i++) {
            findElementByClassAndButtonName(new File(resourcePath + resourceFiles[i]), className, buttonName);
        }
    }

    private static void findElementByClassAndButtonName(File htmlFile,String className,String buttonName) {
        try {
            Document doc = Jsoup.parse(
                    htmlFile,
                    CHARSET_NAME,
                    htmlFile.getAbsolutePath());
            Elements elements=doc.getElementsByClass(className);

            for (Element element:elements){
                Elements foundElement= element.getElementsByTag("a");
                if (htmlFile.getName().equalsIgnoreCase("sample-4-the-mash.html")){
                    foundElement= element.getElementsByTag("button");
                }
                for (Element element1:foundElement){
                    String text=element1.text();
                    if (text.equalsIgnoreCase(buttonName)){
                        System.out.println(element1.toString());
                    }
                }
            }

        } catch (IOException e) {

        }
    }
    }

