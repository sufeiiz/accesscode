package nyc.c4q.sufeiiz.WebCrawler;

public class SpiderTest {
    /**
     * This is our test. It creates a spider (which creates spider legs) and crawls the web.
     *
     * @param args
     *            - not used
     */
    public static void main(String[] args) {
        Spider spider = new Spider();
        spider.search("http://www.c4q.nyc/", "access");
    }

    // What affects the number of iterations in the while loop in Spider.search(...)?
    // While loop is effected by number of links found on the page, and also will not run anymore
    // if the number of links found is larger than the max number to search

    // Explain in plain English how SpiderLeg.crawl(...) works.
    // crawl() first checks the connection to make sure the url successfully retrieved HTML.
    // Then it looks for all <a href> links on the page and adds them to a list.
}