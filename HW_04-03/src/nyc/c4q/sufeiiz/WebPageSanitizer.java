package nyc.c4q.sufeiiz;

import java.net.URL;

/**
 * Created by sufeizhao on 3/28/15.
 * When we make a GET request for a webpage, the HTML that is returned can also contain tags
 * like script which often do not correspond to the displayable content on the webpage.
 * Information inside script tags is not used by scapers and they often ignore these tags in the HTML.
 * Write a class called WebPageSanitizer which implements a static method called String sanitize(String html)
 * which removes all script tags and the information that they encapsulate and returns a sanitized version
 * of the HTML string.
 */

public class WebPageSanitizer {

    // using Alex Samuel's code to get html document from url path
    public static String urlToDocument(String website) {
        URL url = HTTP.stringToURL(website);
        String html = HTTP.get(url);

        return html;
    }

    // removes <script> tags and content from html document
    public static String sanitize(String html) {

        // search for "<script" instead of "<script>" because there are "<script src>"
        String startTag = "<script", endTag = "</script>", delete;
        int count, startIndex, endIndex;

        count = HTTP.countWord(html, startTag);

        // will loop the exact amount of times "<script" appears in html
        for (int i=0; i<count; i++) {
            startIndex = html.indexOf(startTag);
            endIndex = html.indexOf(endTag, startIndex) + 9; // 9 = length of endTag

            delete = html.substring(startIndex, endIndex);

            html = html.replace(delete, "");
        }

        return html;
    }

    public static void main(String[] args) {
        String html = urlToDocument("http://en.wikipedia.org/wiki/Web_scraping");
        System.out.println(sanitize(html));
    }
}
