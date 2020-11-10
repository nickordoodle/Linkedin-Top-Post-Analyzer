package com.analyzer.trends;

import com.analyzer.data.Post;
import com.analyzer.io.LinkedInUserCSVReader;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * HashtagSniffer, fist sorting list by number of views then by number of likes and lastly by number of comments.
 * then find the hashtag/s which appeared the most frequent.
 */

public class HashtagSniffer extends TrendFinder {
    private int max = 0; // max number of hashtags appearances

    public HashtagSniffer() throws IOException {

    }

    /**
     * Returns a list of trend results according to users top posts.
     * <p>
     * This implementation specific method analyzes the top user posts.
     * It then will determine useful information for the user to know
     * and returns a list of Strings as a result for future output.
     *
     * @param numOfResultsToFind the maximum number of results to find
     * @return the list of String results
     * @see List
     */
    @Override
    public List<String> findTrend(int numOfResultsToFind) throws IOException {
        // sorting list, return a list of List<String> of hashtags for the top ${numOfResultsToFind} post/s.
        List<List<String>> list = getUserTopPostsFilteredByALimit().stream()
                .map(Post::getListOfHashTags)
                .collect(Collectors.toList());

        // flatten list into an list of string of all hashtags retrived.
        List<String> listOfHashtags = list.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        // Insert listOfHashtags into Map<Integer, String>
        Map<Integer, String> mod = new HashMap<>();
        for (int i = 0; i < listOfHashtags.size(); i++) {
            int count = 0;
            for (int j = 0; j < listOfHashtags.size(); j++) {
                if (listOfHashtags.get(i).equals(listOfHashtags.get(j))) {
                    ++count;
                }
            }
            // insert number of appearance as key, and the Hashtag itself as its value] into HashMap mod.
            mod.put(count, listOfHashtags.get(i));
        }


        // Find out the maximum appearances numbers.
        for (int count : mod.keySet()) {
            if (count > max) {
                max = count;
            }
        }

        int finalMax = max;
        /*   // a sneak peak of the result of Map mode.
            for (Map.Entry<Integer,String> key: mod.entrySet()){
            System.out.println(key.getValue() +" appeared "+ key.getKey() +" time/s");
        }*/
        List<String> modeOfHashtags = mod.entrySet().stream()
                .filter(c -> c.getKey() == finalMax)
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());

        return modeOfHashtags;
    }
}
