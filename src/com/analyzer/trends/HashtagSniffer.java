package com.analyzer.trends;

import com.analyzer.data.Post;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * HashtagSniffer, fist sorting list by number of views then by number of likes and lastly by number of comments.
 * then find the hashtag/s which appeared the most frequent.
 */

public class HashtagSniffer extends TrendFinder {
    private int max = 0; // max appearances of a hashtags
    private int finalMax = 0;

    public HashtagSniffer() throws IOException {
    } // Constructor

    /**
     * Returns a list of Hashtag trend results according to users top posts.
     * <p>
     * This implementation specific method analyzes the top user posts.
     * It then will determine useful information for the user to know
     * and returns a list of Hashtag Strings that appears most often
     * as a result for future output.
     *
     * @param numOfResultsToFind the maximum number of results to find
     * @return the list of String results
     * @see List
     */
    @Override
    public List<String> findTrend(int numOfResultsToFind) throws IOException {
        return getHashtagTrend(getHashtagList());
    }

    /**
     * Returns a list of String Hashtags from all selected top posts
     * and returns a list of all Hashtags within supplement posts
     * as a input for getHashtagTrend().
     *
     * @return the list of all the String Hashtags from supplement posts as results
     * @see List
     */

    public List<String> getHashtagList() {
        // sorting list, return a list of List<String> of hashtags for the top ${numOfResultsToFind} post/s.
        List<List<String>> list = getUserTopPostsFilteredByALimit().stream()
                .map(Post::getListOfHashTags)
                .collect(Collectors.toList());
        // flatten list into an list of string of all hashtags retrived.
        List<String> listOfHashtags = list.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        return listOfHashtags;
    }

    /**
     * Returns a list of Hashtags that appears most often from supplement posts
     *
     * @return the list of most popular Hashtags from supplement posts as results
     * @see List
     */

    public List<String> getHashtagTrend(List<String> listOfHashtags) {
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
        finalMax = max;
        int finalMax = max;
        List<String> modeOfHashtags = mod.entrySet().stream()
                .filter(c -> c.getKey() == finalMax)
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
        return modeOfHashtags;
    }
}



