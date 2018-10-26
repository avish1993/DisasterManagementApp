package io.github.project_travel_mate.utilities;

import java.io.IOException;
import java.net.URL;
import java.net.MalformedURLException;

import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class FetchNDTV {
    final String SOURCE_URL = "https://www.ndtv.com/topic/natural-disaster";
    public List<String> summaries = new ArrayList<String>();
    public List<String> titles = new ArrayList<String>();
    public List<String> urls = new ArrayList<String>();
    public List<String> imageLinks = new ArrayList<String>();
    public List<String> source_link = new ArrayList<String>();

    public void printFetchedContents() {
        System.out.println(imageLinks.size());
        for (String t : imageLinks)
            System.out.println(t);

        System.out.println(urls.size());
        for (String t : urls)
            System.out.println(t);

        System.out.println(source_link.size());
        for (String t : source_link)
            System.out.println(t);

        System.out.println(summaries.size());
        for (String t : summaries)
            System.out.println(t);

        System.out.println(titles.size());
        for (String t : titles)
            System.out.println(t);
    }

    public void fetchNews() throws IOException {
        Document doc = Jsoup.connect(SOURCE_URL).get();

        Element newsItems = doc.getElementById("news_list");
        Elements links = newsItems.select("a[href]");
        Elements images = newsItems.select("img[src]");
        Elements intro = newsItems.getElementsByClass("intro");

        for (Element link : links) {
            String t = link.attr("title");
            String u = link.attr("abs:href");
            if (t.length() != 0) {
                titles.add(t);
                urls.add(u);
            }

        }

        for (Element link : links) {
            String t = link.attr("title");
            String u = link.attr("abs:href");
            if (t.length() == 0 && u.length() != 0) {
                source_link.add(u);
            }

        }

        for (Element link : images) {
            String t = link.attr("abs:src");
            if (t.length() != 0) {
                imageLinks.add(t);
            }

        }

        for (Element link : intro) {
            String t = link.text();
            summaries.add(t);
        }

    }
}
