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

	/**
	 * Returns a boolean to see if the keyword is a conjunction or not.
	 * Checks against a popular 'all conjunctions' data set represented here
	 * as an inner class named EnglishDictionary.
	 *
	 * @param keyword the String word to check
	 * @return a boolean showing if the keyword is a conjunction or not.
	 */
	public static boolean isConjunction(String keyword) {
		EnglishDictionary.all_conjunctions.forEach(String::toLowerCase);
		return EnglishDictionary.all_conjunctions.contains(keyword.toLowerCase());
	}

	/**
	 * Returns a boolean to see if the keyword is a preposition or not.
	 * Checks against a popular 'all preposition' data set represented here
	 * as an inner class named EnglishDictionary.
	 *
	 * @param keyword the String word to check
	 * @return a boolean showing if the keyword is a preposition or not.
	 */
	public static boolean isPreposition(String keyword) {
		EnglishDictionary.all_prepositions.forEach(String::toLowerCase);
		return EnglishDictionary.all_prepositions.contains(keyword.toLowerCase());
	}

	/**
	 * Returns a boolean to see if the keyword is a pronoun or not.
	 * Checks against a popular 'all pronouns' data set represented here
	 * as an inner class named EnglishDictionary.
	 *
	 * @param keyword the String word to check
	 * @return a boolean showing if the keyword is a pronoun or not.
	 */
	public static boolean isPronoun(String keyword) {
		EnglishDictionary.all_pronouns.forEach(String::toLowerCase);
		return EnglishDictionary.all_pronouns.contains(keyword.toLowerCase());
	}

	/**
	 * Represents an English Dictionary public static class to be accessed
	 * across packages. Contains hard coded data used in the container class.
	 *
	 * @author Nick Scherer
	 * @author Jason Zhang
	 * @version 1.0
	 * @since 1.0
	 */
	public static class EnglishDictionary {

		/**
		 * Represents an English conjunctions data list retrieved from internet source.
		 */
		public static final List<String> all_conjunctions = Arrays.asList(
				"all", "as though", "if when", "now that", "supposing", "whenever", "who", "as",
				"before", "inasmuch", "once", "that", "whereas", "as long as", "even if", "just as",
				"provided that", "though", "wherever", "as soon as", "if", "now", "since", "until",
				"which", "for", "and", "nor", "but", "or", "yet", "so"
		);


		/**
		 * Represents an English prepositions data list retrieved from internet source.
		 */
		public static final List<String> all_prepositions = Arrays.asList(
				"all", "about", "above", "across", "after", "against", "along", "amid", "among",
				"anti", "around", "as", "at", "before", "behind", "below", "beneath", "beside", "besides",
				"between", "beyond", "but", "by", "concerning", "considering", "despite", "down", "during", "except", "excepting",
				"excluding", "following", "for", "from", "in", "inside", "into", "like", "minus", "near",
				"of", "off", "on", "onto", "opposite", "outside", "over", "past", "per", "plus", "regarding",
				"round", "save", "since", "than", "through", "to", "toward", "towards", "under", "underneath",
				"unlike", "until", "up", "upon", "versus", "via", "with", "within", "without"
		);

		/**
		 * Represents an English pronouns data list retrieved from internet source.
		 */
		public static final List<String> all_pronouns = Arrays.asList(
				"all", "another", "any", "anybody", "anyone", "anything", "as", "aught", "both", "each",
				"each other", "either", "enough", "everybody", "everyone", "everything", "few", "he", "her",
				"hers", "herself", "him", "himself", "his", "I", "idem", "it", "its", "itself", "many", "me",
				"mine", "most", "my", "myself", "naught", "neither", "no one", "nobody", "none", "nothing",
				"nought", "one", "one another", "other", "others", "ought", "our", "ours", "ourself", "ourselves",
				"several", "she", "some", "somebody", "someone", "something", "somewhat", "such", "suchlike",
				"that", "thee", "their", "theirs", "theirself", "theirselves", "them", "themself", "themselves",
				"there", "these", "they", "thine", "this", "those", "thou", "thy", "thyself", "us", "we", "what",
				"whatever", "whatnot", "whatsoever", "whence", "where", "whereby", "wherefrom", "wherein", "whereinto",
				"whereof", "whereon", "wherever", "wheresoever", "whereto", "whereunto", "wherewith", "wherewithal",
				"whether", "which", "whichever", "whichsoever", "who", "whoever", "whom", "whomever", "whomso",
				"whomsoever", "whose", "whosever", "whosesoever", "whoso", "whosoever", "ye", "yon", "yonder",
				"you", "your", "yours", "yourself", "yourselves");
	}

}
