
public class MergeSort {

	/**
	 * Merges two sorted arrays, and compute the difference in scores
	 * 
	 * @param person1 a sorted array of medals
	 * @param person2 a sorted array of medals
	 * @return the difference in score of person1 and person2
	 */
	
	// Given arrays are sorted from least to greatest
	// No two medals will be of equal value, all will be unique
	public static <T extends Comparable<? super T>> int merge(T[] person1, T[] person2) {
		if(person1 == null || person2 == null){
			throw new NullPointerException("None of the array can be null");
		}
		int scoreCounter = 0;
		int person1Index = 0;
		int person2Index = 0;
		int person1Score = 0;
		int person2Score = 0;
		T[] finalArray = (T[])new Comparable[person1.length + person2.length];
		while (person1Index < person1.length && person2Index < person2.length) {
			if (person1[person1Index].compareTo(person2[person2Index]) < 0) {
				finalArray[scoreCounter] = person1[person1Index];
				person1Index++;
				person1Score += ++scoreCounter;
					
			} else {
				finalArray[scoreCounter] = person2[person2Index];
				person2Index++;
				person2Score += ++scoreCounter;
			}
		}
		if (person1Index == person1.length && person2Index == person2.length) {
			return person1Score - person2Score;
		} else if (person1Index == person1.length){
			for (int i = person2Index; i < person2.length; i++) {
				finalArray[i] = person2[i];
				person2Score += ++scoreCounter;
			}
			return person1Score - person2Score;
		} else {
			for (int i = person1Index; i < person1.length; i++) {
				finalArray[i] = person1[i];
				person1Score += ++scoreCounter;
			}
			return person1Score - person2Score;
		}
	}
	
}
