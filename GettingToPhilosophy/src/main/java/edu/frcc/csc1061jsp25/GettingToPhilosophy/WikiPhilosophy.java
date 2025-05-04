package edu.frcc.csc1061jsp25.GettingToPhilosophy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;


public class WikiPhilosophy {

    final static List<String> visited = new ArrayList<String>();
    final static WikiFetcher wf = new WikiFetcher();

    /**
     * Tests a conjecture about Wikipedia and Philosophy.
     *
     * https://en.wikipedia.org/wiki/Wikipedia:Getting_to_Philosophy
     *
     * 1. Clicking on the first non-parenthesized, non-italicized link
     * 2. Ignoring external links, links to the current page, or red links
     * 3. Stopping when reaching "Philosophy", a page with no links or a page
     *    that does not exist, or when a loop occurs
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String destination = "https://en.wikipedia.org/wiki/Philosophy";
        String source = "https://en.wikipedia.org/wiki/Java_(programming_language)";

        testConjecture(destination, source, 10);
    }

    /**
     * Starts from given URL and follows first link until it finds the destination or exceeds the limit.
     *
     * @param destination
     * @param source
     * @throws IOException
     */
    public static void testConjecture(String destination, String source, int limit) throws IOException {
        if (limit <= 0) {
            System.out.println("Step limit exceeded.");
            return;
        }

        if (visited.contains(source)) {
            System.out.println("Loop detected. Already visited: " + source);
            return;
        }

        System.out.println("Visiting: " + source);
        visited.add(source);

        if (source.equals(destination)) {
            System.out.println("Reached destination!");
            return;
        }

        Document doc;
        try {
        	doc = wf.fetchWikipediaDocument(source);
        } catch (Exception e) {
            System.out.println("Error fetching page.");
            return;
        }

        Element content = doc.getElementById("mw-content-text");
        Elements paragraphs = content.select("p");

        int parenDepth = 0;

        for (Element para : paragraphs) {
            Iterable<Node> iter = new WikiNodeIterable(para);
            for (Node node : iter) {
                if (node instanceof TextNode) {
                    String text = ((TextNode) node).text();
                    for (char c : text.toCharArray()) {
                        if (c == '(') parenDepth++;
                        if (c == ')' && parenDepth > 0) parenDepth--;
                    }
                }

                if (node instanceof Element) {
                    Element el = (Element) node;

                    if (el.tagName().equals("a")) {
                        if (parenDepth > 0 || isItalic(el) || isRedLink(el)) continue;

                        String relHref = el.attr("href");
                        if (relHref.startsWith("/wiki/") && !relHref.contains(":") && !relHref.contains("#")) {
                            String absUrl = "https://en.wikipedia.org" + relHref;

                            
                            testConjecture(destination, absUrl, limit - 1);
                            return;
                        }
                    }
                }
            }
        }

        System.out.println("No valid links found on this page.");
    }

    /**
     * Checks if the given element or any of its parents are italicized.
     */
    private static boolean isItalic(Element el) {
        for (Element parent = el; parent != null; parent = parent.parent()) {
            String tag = parent.tagName();
            if (tag.equals("i") || tag.equals("em")) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the given element is a red link (nonexistent page).
     */
    private static boolean isRedLink(Element el) {
        return el.classNames().contains("new");
    }
}