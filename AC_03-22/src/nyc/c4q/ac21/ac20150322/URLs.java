package nyc.c4q.ac21.ac20150322;

import java.net.URL;

/**
 * Created by sufeizhao on 3/22/15.
 */
public class URLs {

    public static URL makeHttpUrl(String host, String path) {
        int port = 80;
        return makeHttpUrl(host, port, path);
    }

    public static URL makeHttpUrl(String host, int port, String path) {
        String url = "http://" + host;

        if (port != 80) {
            url += ":" + port;
        }

        url += host;
        return HTTP.stringToURL(url);
    }

    public static void printURL(URL url) {
        System.out.println("Protocol: " + url.getProtocol());
        System.out.println("Host: " + url.getHost());
        System.out.println("Port: " + url.getPort());
        System.out.println("Path: " + url.getPath());
    }

    public static void main(String[] args) {
        URL url = HTTP.stringToURL("http://alexsamuel.net");
        System.out.println(url.getHost());

        System.out.println(makeHttpUrl("google.com", 80, "/fonts/"));
    }

}
