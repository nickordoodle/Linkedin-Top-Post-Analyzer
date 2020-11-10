package com.analyzer.trends;

import com.analyzer.data.Post;
import com.analyzer.io.LinkedInUserCSVReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * HashtagSniffer, fist sorting list by number of views then by number of likes and lastly by number of comments.
 * then find the hashtag/s which appeared the most frequent.
 */

public class HashtagSniffer {
    private String dataFilePath;
    //List<Post> result = new ArrayList<>();

    public HashtagSniffer(String dataFilePath) throws IOException {
        this.dataFilePath = dataFilePath;
    }

    // This looks like it returns the top number of posts according to limit
    // Doesn't do anything with hashTags yet, maybe rename method
    // TODO rename method more accurately?
    public List<Post> hashtagSniffer(int limit) throws IOException {

        LinkedInUserCSVReader reader = new LinkedInUserCSVReader(dataFilePath);
        List<Post> temp = reader.load();

        List<Post> list = temp.stream()
                .sorted(Comparator.comparing(Post::getNumOfViews).reversed()
                        .thenComparing(Post::getNumOfLikes).reversed()
                        .thenComparing(Post::getNumOfComments).reversed()) // Sort list by number of views then by number of likes and lastly by number of comments
                .limit(limit) // limit outputs to limits that set by user. e.g. first 5.
                .collect(Collectors.toList());

        //result.addAll(list);
        return list;
    }
}
