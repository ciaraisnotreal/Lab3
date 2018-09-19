package com.company;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
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

    public static int countWordOccur(final String words, final String look) {
        int count = 0;
        String s = words.replaceAll("\\p{Punct}", "");
        String[] arr = s.split(" ");
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].toLowerCase().contains(look.toLowerCase())){
                count++;
            }
        }
        return count;
    }

    public static int countWord(final String words) {
        boolean word = false;
        String s = words.replaceAll("\\p{Punct}", "");
        int track = 0, count = 0;

        for (int i = 0; i < s.length(); i++) {
            track = i;
            while (Character.isLetter(s.charAt(i)) || Character.isDigit(s.charAt(i))) {
                word = true;
                i++;
            }

            if (word) {
                count++;
                word = false;
            }

            while (s.charAt(i) == ' ') {
                i++;
            }
        }
        return count;
    }

    public static int uniqueNum(final String s) {
        LinkedList li = new LinkedList();
        boolean word = false;
        String temp = "";
        int tem = 0, i = 0;

        String str = s.replaceAll("\\p{Punct}", "");
        while (i < str.length()) {
            tem = i;
            while (Character.isLetter(str.charAt(i))) {
                word = true;
                i++;
            }

            if (word) {
                if (!li.contains(str.substring(tem, i))) {
                    li.add(str.substring(tem, i));
                }
                word = false;
            }

            while (i < str.length() && !Character.isLetter(str.charAt(i))) {
                i++;
            }
        }
        return li.size();
    }

    public static void main(String[] args) {
        System.out.println(urlToString("https://www.bls.gov/tus/charts/chart9.txt"));
        System.out.println(uniqueNum(urlToString("https://www.bls.gov/tus/charts/chart9.txt")));
        //countWordOccur(urlToString("http://erdani.com/tdpl/hamlet.txt"));


    }
}
