package edu.sun.app;

import edu.sun.entity.Page;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * User: sunqipeng
 * Date: 12-8-7
 */
public class Main {
    public static void main(String[] args) {
        CacheUtils.addUrl(new Page("http://www.163.com", 0));
        new Main().process();
    }

    private void process() {

        while (true) {
            Page page = CacheUtils.getNextPage();

            Connection connection = Jsoup.connect(page.getPageUrl()).followRedirects(true);
            try {
                //Document document = Jsoup.connect(page.getPageUrl()).get();
                Document document = connection.get();
                parseLinks(document, page);
                page.setPageTitle(document.title());
                page.setH1Count(document.getElementsByTag("h1").size());
                page.setH2Count(document.getElementsByTag("h2").size());
                page.setPageSize(document.html().length());
                page.setResponseCode(connection.response().statusCode());
                CacheUtils.saveVisitedUrl(page);
            } catch (IOException e) {
                page.setResponseCode(connection.response().statusCode());
                CacheUtils.saveVisitedUrl(page);
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }

    private void parseLinks(Document document, Page page) {
        Elements elements = document.getElementsByTag("a");
        List<Page> result = new ArrayList<Page>();
        for (Element element : elements) {
            String url = StringUtils.trim(element.attr("href"));
            if (!UrlUtils.isValidUrl(url))
                continue;
            url = UrlUtils.buildPath(page.getPageUrl(), url);
            result.add(new Page(url, page.getPageDepth() + 1));
        }
        CacheUtils.addUrls(result);
    }
}
