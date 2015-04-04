package nyc.c4q.ac21.ac20150322;

import java.net.URL;
import java.util.Scanner;

/**
 * Created by sufeizhao on 3/22/15.
 */
public class Google {

    public static void linkCrawl(URL url) {
        String document = HTTP.get(url);
        Scanner doc = new Scanner(document);

        String current, link;
        int indexBegin, indexEnd;

        while (doc.hasNextLine()) {
            current = doc.nextLine();
            if (current.contains("href=\"")) {
                indexBegin = current.indexOf("href=");
                indexEnd = current.indexOf("\"", indexBegin);
                link = current.substring(indexBegin + 6, indexEnd+1);
//                if (link.contains("http://"))
//                    continue;
//                else
//                    link = url.getHost() + link;
                System.out.println(link);
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String inputString, word;
        URL url;

        System.out.print("Enter URL: ");
        inputString = input.nextLine();
        url = HTTP.stringToURL(inputString);

        linkCrawl(url);
    }

}
