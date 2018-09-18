import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
public class Main {

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static int wordCount(String stuff) {
        int count = 0;
        for (int i = 0; i < stuff.length() - 1; i++) {
            if (stuff.substring(i, i + 1).equals(" ")) {
                count +=1;
            }
        }
        return count;
    }

    public static int uniqueWordCount(String stuff, String word) {
        int count = 0;
        for (int i = 0; i < stuff.length() - word.length(); i++) {
            if (stuff.substring(i, i + word.length()).equalsIgnoreCase(word)) {
                count +=1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("Word count of http://erdani.com/tdpl/hamlet.txt");
        System.out.println(wordCount(urlToString("http://erdani.com/tdpl/hamlet.txt")));
        System.out.println("Word count of https://www.bls.gov/tus/charts/chart9.txt");
        System.out.println(wordCount(urlToString("https://www.bls.gov/tus/charts/chart9.txt")));
        System.out.println("Word count of http://tgftp.nws.noaa.gov/data/raw/fz/fzus53.klot.srf.lot.txt");
        System.out.println(wordCount(urlToString("http://tgftp.nws.noaa.gov/data/raw/fz/fzus53.klot.srf.lot.txt")));

        System.out.println("Word count of \"prince\" in http://erdani.com/tdpl/hamlet.txt");
        System.out.println(uniqueWordCount(urlToString("http://erdani.com/tdpl/hamlet.txt"), "prince"));
    }
}
