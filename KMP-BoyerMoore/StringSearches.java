import java.util.ArrayList;
import java.util.Arrays;

public class StringSearches {

	/**
	 * Return the last function table. Remember to use the Character-Jump
	 * Heuristic you saw in recitation.
	 * 
	 * Here is a quick review: map[c] = needle.length() - 1 - index of the last
	 * occurrence of c If c does not exist in the table, initialize map[c] =
	 * needle.length()
	 * 
	 * Remember you can use the fill() method of the Arrays utility class to
	 * fill in an array with some value.
	 * 
	 * THIS IS NOT THE SAME AS IT IS IN YOUR BOOK!!
	 * 
	 * @param string to be processed into the last function table
	 * @return a last function table
	 */
	public static int[] buildLastFunction(String needle) {
		int [] failureList;
		if (needle == null || needle.length() == 0) {
			failureList = new int[0];
			return failureList;
		}
		failureList = new int[Character.MAX_VALUE + 1];
		Arrays.fill(failureList, needle.length());
		int index = 0;
		for (Character c : needle.toCharArray()) {
			failureList[c] = Math.max(needle.length() - index - 1, 1);
			index++;
		}
		return failureList;
	}

	/**
	 * Run Boyer-Moore on the given strings, and look for ALL occurrences of the
	 * needle in the haystack. Return an array that contains all of the indices
	 * where the needle occurs in the haystack.
	 * 
	 * Suppose that you find matches at index 4, 7, and 9. The array you return
	 * will have the values 4, 7, 9. You must return an empty array if there are
	 * no matches
	 * 
	 * The running time will be tested, so if you implement this algorithm
	 * incorrectly, you will lose points
	 * 
	 * @param haystack
	 *            to search through for occurrences of the needle
	 * @param needle
	 *            the pattern you wish to match in the haystack
	 * @return an array with all the occurrences of the needle in the haystack
	 */
	public static int[] boyerMoore(String haystack, String needle) {
		int[] arrayMatches;
		if (needle == null || haystack == null || needle.length() == 0
				|| haystack.length() == 0
				|| (haystack.length() < needle.length())) {
			arrayMatches = new int[0];
			return arrayMatches;
		}
		char[] haystackArray = haystack.toCharArray();
		char[] needleArray = needle.toCharArray();
		int skip;
		ArrayList<Integer> matches = new ArrayList<Integer>();
		for (int i = 0; i <= (haystack.length() - needle.length()); i += skip) {
			skip = 0;
			for (int j = needle.length() - 1; j >= 0; j--) {
				if (needleArray[j] != haystackArray[i + j]) {
					int[] failureTable = StringSearches
							.buildLastFunction(needle);
					skip = failureTable[haystackArray[i + j]];
					break;
				}
			}
			if (skip == 0) { // String matched
				matches.add(i);
				i++;
			}
		}
		arrayMatches = new int[matches.size()];
		int index = 0;
		for (Integer i : matches) {
			arrayMatches[index] = i;
			index++;
		}
		return arrayMatches;
	}

	/**
	 * Return the last function table for use with the KMP algorithm. Remember
	 * that table[i] is the length of the longest prefix that matches a suffix
	 * of needle.substring(0, i).
	 * 
	 * @param needle
	 *            to build the prefix function from
	 * @return the prefix function
	 */
	public static int[] buildPrefixFunction(String needle) {
		int[] prefixTable;
		if (needle == null || needle.length() == 0) {
			prefixTable = new int[0];
			return prefixTable;
		}
		prefixTable = new int[needle.length()];
		prefixTable[0] = -1;
		if (needle.length() == 1) {
			return prefixTable;
		} else {
			prefixTable[1] = 0;
		}
		int i = 0;
		int j = 2;
		int count = 0;
		while (j < needle.length()) {
			if (needle.charAt(i) == needle.charAt(j - 1)) {
				count++;
				i++;
			} else if (count != 0) {
				count--;
				i--;
				continue;
			} else {
				i = 0;
				count = 0;
			}
			prefixTable[j] = count;
			j++;
		}
		return prefixTable;

	}

	/**
	 * Run the Knuth-Morris-Pratt Algorithm (KMP) on the haystack. Return ALL
	 * occurances of the needle in the haystack. You must return an array that
	 * consists of all of the indices where the needle occurs in the haystack.
	 * 
	 * Suppose that you find matches at index 4, 7, and 9. The array you return
	 * will have the values 4, 7, 9. You must return an empty array if there are
	 * no matches.
	 * 
	 * @param haystack
	 *            to search through for occurrences of the needle
	 * @param needle
	 *            the patttern you wish to match in the haystack
	 * @return an array with all the occurrences of the needle in they haystack
	 */
	public static int[] kmp(String haystack, String needle) {
		int[] arrayMatches;
		if (needle == null || haystack == null || needle.length() == 0
				|| haystack.length() == 0
				|| (haystack.length() < needle.length())) {
			arrayMatches = new int[0];
			return arrayMatches;
		}
		ArrayList<Integer> matches = new ArrayList<Integer>();
		int i = 0; // index haystack
		int j = 0; // index needle
		while (i < haystack.length()) {
			if (haystack.charAt(i) != needle.charAt(j)) {
				if (j != 0) {
					j = StringSearches.buildPrefixFunction(needle)[j];
				} else {
					i++;
				}
			} else {
				if (j == needle.length() - 1) {// match found
					matches.add(i - needle.length() + 1);
					j = 0;
					if(needle.length() == 1){
						i++;
					}
				} else {
					j++;
					i++;
				}
			}
		}
		arrayMatches = new int[matches.size()];
		int index = 0;
		for (Integer num : matches) {
			arrayMatches[index] = num;
			index++;
		}
		return arrayMatches;
	}
}
