package com.analyzer.helper;

import java.util.Arrays;
import java.util.List;

/**
 * Represents a helper class with English dictionary utility methods.
 *
 * @author Nick Scherer
 * @author Jason Zhang
 * @version 1.0
 * @since 1.0
 */
public class Grammar {
    public static boolean isConjunction(String keyword) {
        EnglishDictionary.all_conjunctions.forEach(String::toLowerCase);
        return EnglishDictionary.all_conjunctions.contains(keyword.toLowerCase());
    }

    public static boolean isPreposition(String keyword) {
        EnglishDictionary.all_prepositions.forEach(String::toLowerCase);
        return EnglishDictionary.all_prepositions.contains(keyword.toLowerCase());
    }

    public static boolean isPronoun(String keyword) {
        EnglishDictionary.all_pronouns.forEach(String::toLowerCase);
        return EnglishDictionary.all_pronouns.contains(keyword.toLowerCase());
    }

    public static class EnglishDictionary {
        static final List<String> all_conjunctions = Arrays.asList("all",
                "As though",
                "If when",
                "Now that",
                "Supposing",
                "Whenever",
                "Who",
                "As",
                "Before",
                "Inasmuch",
                "Once",
                "That",
                "Whereas",
                "As long as",
                "Even if",
                "Just as",
                "Provided that",
                "Though",
                "Wherever",
                "As soon as",
                "If",
                "Now",
                "Since",
                "Until",
                "Which",
                "for",
                "and",
                "nor",
                "but",
                "or",
                "yet",
                "so"
        );


        static final List<String> all_prepositions = Arrays.asList(
                "all",
                "about",
                "above",
                "across",
                "after",
                "against",
                "along",
                "amid",
                "among",
                "anti",
                "around",
                "as",
                "at",

                "before",
                "behind",
                "below",
                "beneath",
                "beside",
                "besides",
                "between",
                "beyond",
                "but",
                "by",

                "concerning",
                "considering",

                "despite",
                "down",
                "during",

                "except",
                "excepting",
                "excluding",

                "following",
                "for",
                "from",

                "in",
                "inside",
                "into",

                "like",

                "minus",

                "near",

                "of",
                "off",
                "on",
                "onto",
                "opposite",
                "outside",
                "over",

                "past",
                "per",
                "plus",

                "regarding",
                "round",

                "save",
                "since",

                "than",
                "through",
                "to",
                "toward",
                "towards",

                "under",
                "underneath",
                "unlike",
                "until",
                "up",
                "upon",

                "versus",
                "via",

                "with",
                "within",
                "without"
        );


        static final List<String> all_pronouns = Arrays.asList(
                "all",
                "another",
                "any",
                "anybody",
                "anyone",
                "anything",
                "as",
                "aught",
                "both",
                "each",
                "each other",
                "either",
                "enough",
                "everybody",
                "everyone",
                "everything",
                "few",
                "he",
                "her",
                "hers",
                "herself",
                "him",
                "himself",
                "his",
                "I",
                "idem",
                "it",
                "its",
                "itself",
                "many",
                "me",
                "mine",
                "most",
                "my",
                "myself",
                "naught",
                "neither",
                "no one",
                "nobody",
                "none",
                "nothing",
                "nought",
                "one",
                "one another",
                "other",
                "others",
                "ought",
                "our",
                "ours",
                "ourself",
                "ourselves",
                "several",
                "she",
                "some",
                "somebody",
                "someone",
                "something",
                "somewhat",
                "such",
                "suchlike",
                "that",
                "thee",
                "their",
                "theirs",
                "theirself",
                "theirselves",
                "them",
                "themself",
                "themselves",
                "there",
                "these",
                "they",
                "thine",
                "this",
                "those",
                "thou",
                "thy",
                "thyself",
                "us",
                "we",
                "what",
                "whatever",
                "whatnot",
                "whatsoever",
                "whence",
                "where",
                "whereby",
                "wherefrom",
                "wherein",
                "whereinto",
                "whereof",
                "whereon",
                "wherever",
                "wheresoever",
                "whereto",
                "whereunto",
                "wherewith",
                "wherewithal",
                "whether",
                "which",
                "whichever",
                "whichsoever",
                "who",
                "whoever",
                "whom",
                "whomever",
                "whomso",
                "whomsoever",
                "whose",
                "whosever",
                "whosesoever",
                "whoso",
                "whosoever",
                "ye",
                "yon",
                "yonder",
                "you",
                "your",
                "yours",
                "yourself",
                "yourselves");
    }
}
