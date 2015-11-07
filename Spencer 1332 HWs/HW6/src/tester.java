public class tester {
	public static <T> void main(String[] args){
		Sort ll = new Sort();
		
		Comparable[] array = {"Yo", "Me", "Meow", "bob", "Bob"};
		Comparable[] array1 = {11, 5, 4, 9, 22, 17, 35, 15};
		Comparable[] array2 = {};
		Comparable[] array3 = new Comparable[3];
		
		System.out.println(ll.isEmpty(array2));
		System.out.println(ll.isEmpty(array3));
		System.out.println(ll.isEmpty(array));
		
		//Comparable[] array4 = ll.subArray(array1, 4, 6);
		//for(int i = 0; i < array4.length; i++)
			//System.out.print(" " + array4[i]);
		
		System.out.println("");
		System.out.println(" Boom");
		
		ll.insertionSort(array1);
		System.out.println(ll.insertionCount);
		for(int i = 0; i < array1.length; i++)
			System.out.print(" " + array1[i]);
		
			
	}
}