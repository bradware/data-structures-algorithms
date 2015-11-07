import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;


public class TextSearch {

	public static int comparision; // Increment this every time a comparision is made
	public static String str;
	
	/**
	 * Table of delta values for p
	 * @param p
	 * @return array of last tables
	 */
	public static int[] last(String p) {
		int[] last = new int[Character.MAX_VALUE + 1];
		str = "";
		for(int j = 0; j < p.length(); j++){
			last[p.charAt(j)] = p.length() - j - 1;
			str += p.charAt(j);
		}
		return last;
	}
	
	/**
	 * Table of next vals for p
	 * 
	 * @param p
	 * @return failures table
	 */
	public static int[] failure(String p) {
		int[] fail = new int[Character.MAX_VALUE + 1];
		fail[0] = -1;//base case
		int j = -1;
		int i = 0;
		while(i<p.length()-1){
			if(j==-1){
				i++;
				j++;
				fail[i]=j;
			}
			while(p.charAt(i)==p.charAt(j) && i< p.length()-1){
				i++;
				j++;
				fail[i]=j;
			}
			//if breaks out of while loop, prefix has ended, j!=i
			j = fail[j]; //reset j
		}
		return fail;
	}
	/**
	 * Searches the text using Brute Force
	 * 
	 * @param t
	 * @param p
	 * @return index of where the first letter was found; -1 if not found
	 */
	public static int runBruteForce(String t, String p) {
		TextSearch.comparision = 0;
		
		if(t == null || p == null)
			return -1;
		if(t.length() == 0 || p.length()==0)
			return -1;
		
		int i = 0;
		int j = 0;
		int temp = i;
		while(i < t.length()){
				if(t.charAt(i) == p.charAt(j) && j == 0)
					temp = i;
					
				if(t.charAt(i) == p.charAt(j) && j == p.length() - 1){
					TextSearch.comparision++;
					return temp;
				} 
				else if(t.charAt(i) == p.charAt(j)){
					i++;
					j++;
				}
				else if(t.charAt(i) != p.charAt(j) && j > 0){
					j = 0;
				}
				else{
					j = 0;
					i++;
				}
				TextSearch.comparision++;	
			}
		return -1;
	}
	/**
	 * Searches the text using Boyer Moore
	 * 
	 * @param t
	 * @param p
	 * @return index of where the first letter was found; -1 if not found
	 */
	public static int runBoyerMoore(String t, String p) {
		TextSearch.comparision = 0;
		
		if(t == null || p == null)
			return -1;
		if(t.length() == 0 || p.length()==0)
			return -1;
		
		int[] array = last(p);
		int i = 0;
		int j = 0;
		
			i = p.length() - 1;
			while(i < t.length()){
				j = p.length() - 1;
				while(j >= 0 && t.charAt(i) == p.charAt(j)){
					i--;
					j--;
					TextSearch.comparision++;
				}
				if(j == -1){
					return i+1;
				}
				if(!str.contains(t.substring(i+1)))
					i = i + p.length();
				else
					i = i + Math.max(array[t.charAt(i)], p.length()-j);
					
				TextSearch.comparision++;
				
			}
			return -1;
	}

	/**
	 * Searches the text using KMP
	 * 
	 * @param t
	 * @param p
	 * @return index of where the first letter was found; -1 if not found
	 */
	public static int runKMP(String t, String p) {
		TextSearch.comparision = 0;
		
		int j = 0;
		int match; 
		if(t.length() == 0||p.length()==0)
			return -1;
		int[] array = failure(p);
		
		for(int i = 0; i < t.length(); i++){
			while(j>0 && p.charAt(j) != t.charAt(i)){
				j = array[j];
			}
			if(p.charAt(j)==t.charAt(i)){
				j++;
				TextSearch.comparision++;
			}
			if(j==p.length()){
				match = i-p.length()+1;
				return match;
			}
		}
		return -1;
	}

	// DO NOT edit code below this line

	public static void resetComp() {
		comparision = 0;
	}

	public static int getComp() {
		return comparision;
	}

}