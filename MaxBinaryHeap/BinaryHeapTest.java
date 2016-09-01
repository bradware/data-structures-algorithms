import static org.junit.Assert.assertEquals;



import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import org.junit.Test;


@SuppressWarnings("unused")
public class BinaryHeapTest {
	
	@SuppressWarnings("unchecked")
	@Test
	public void addTest1(){
		System.out.println("Add Test 1 -----");
		BinaryHeap heap1 = new BinaryHeap();
		heap1.add(1);
		for(int i = 0; i < heap1.size(); i++){
			System.out.print(heap1.getData()[i] + ", ");
		}
		System.out.println();
		heap1.add(40);
		for(int i = 0; i < heap1.size(); i++){
			System.out.print(heap1.getData()[i] + ", ");
		}
		System.out.println();
		heap1.add(23);
		for(int i = 0; i < heap1.size(); i++){
			System.out.print(heap1.getData()[i] + ", ");
		}
		System.out.println();
		heap1.add(62);
		for(int i = 0; i < heap1.size(); i++){
			System.out.print(heap1.getData()[i] + ", ");
		}
		System.out.println();
		heap1.add(0);
		for(int i = 0; i < heap1.size(); i++){
			System.out.print(heap1.getData()[i] + ", ");
		}
		System.out.println();
		heap1.add(-2);
		for(int i = 0; i < heap1.size(); i++){
			System.out.print(heap1.getData()[i] + ", ");
		}
		System.out.println();
		heap1.add(null);
		for(int i = 0; i < heap1.size(); i++){
			System.out.print(heap1.getData()[i] + ", ");
		}
		System.out.println();
		System.out.println("Root of heap: " + heap1.peek());
		System.out.println();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void addTest2(){
		System.out.println("Add Test 2-----");
		BinaryHeap heap1 = new BinaryHeap();
		heap1.add(null);//Added to empty list
		for(int i = 0; i < heap1.size(); i++){
			System.out.print(heap1.getData()[i] + ", ");
		}
		System.out.println();
		heap1.add(1);
		for(int i = 0; i < heap1.size(); i++){
			System.out.print(heap1.getData()[i] + ", ");
		}
		System.out.println();
		heap1.add(2);
		for(int i = 0; i < heap1.size(); i++){
			System.out.print(heap1.getData()[i] + ", ");
		}
		System.out.println();
		heap1.add(3);
		heap1.add(4);
		heap1.add(5);
		heap1.add(6);
		heap1.add(7);
		heap1.add(8);
		heap1.add(9);
		heap1.add(10);//Need to resize after this
		for(int i = 0; i < heap1.size(); i++){
			System.out.print(heap1.getData()[i] + ", ");
		}
		System.out.println();
		heap1.add(11);
		for(int i = 0; i < heap1.size(); i++){
			System.out.print(heap1.getData()[i] + ", ");
		}
		System.out.println();
		System.out.println(heap1.size());
		System.out.println(heap1.isEmpty());
		System.out.println();
		

	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void addTest3(){
		System.out.println("Add Test 3");
		BinaryHeap heap1 = new BinaryHeap();
		heap1.add(-1);//Added to empty list
		for(int i = 0; i < heap1.size(); i++){
			System.out.print(heap1.getData()[i] + ", ");
		}
		System.out.println();
		heap1.add(-2);
		for(int i = 0; i < heap1.size(); i++){
			System.out.print(heap1.getData()[i] + ", ");
		}
		System.out.println();
		heap1.add(-3);
		for(int i = 0; i < heap1.size(); i++){
			System.out.print(heap1.getData()[i] + ", ");
		}
		System.out.println();
		heap1.add(-4);
		for(int i = 0; i < heap1.size(); i++){
			System.out.print(heap1.getData()[i] + ", ");
		}
		System.out.println();
		heap1.add(-5);
		for(int i = 0; i < heap1.size(); i++){
			System.out.print(heap1.getData()[i] + ", ");
		}
		System.out.println();
		heap1.add(-6);
		for(int i = 0; i < heap1.size(); i++){
			System.out.print(heap1.getData()[i] + ", ");
		}
		System.out.println();
		heap1.add(-7);
		for(int i = 0; i < heap1.size(); i++){
			System.out.print(heap1.getData()[i] + ", ");
		}
		System.out.println();
		heap1.add(-8);
		for(int i = 0; i < heap1.size(); i++){
			System.out.print(heap1.getData()[i] + ", ");
		}
		System.out.println();
		heap1.add(-9);
		for(int i = 0; i < heap1.size(); i++){
			System.out.print(heap1.getData()[i] + ", ");
		}
		System.out.println();
		heap1.add(-10);
		for(int i = 0; i < heap1.size(); i++){
			System.out.print(heap1.getData()[i] + ", ");
		}
		System.out.println();
		heap1.add(-11);//Need to resize after this
		for(int i = 0; i < heap1.size(); i++){
			System.out.print(heap1.getData()[i] + ", ");
		}
		System.out.println();
		heap1.add(0);
		for(int i = 0; i < heap1.size(); i++){
			System.out.print(heap1.getData()[i] + ", ");
		}
		System.out.println();
		System.out.println(heap1.size());
		System.out.println(heap1.isEmpty());
		System.out.println();
		

	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void addTest4(){
		System.out.println("test add 4 -----");
		BinaryHeap heap1 = new BinaryHeap();
		for(int i = 0; i < 50; i++){
			heap1.add(i);
		}
		System.out.println();
		for(int i = 0; i < heap1.size(); i++){
			System.out.print(heap1.getData()[i] + ", ");
		}
		System.out.println();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void addTest5(){
		System.out.println();
		System.out.println("Test add 5-----");
		BinaryHeap heap1 = new BinaryHeap(null);
		heap1.add(-1000);
		heap1.add(5);
		System.out.println();
		for(int i = 0; i < heap1.size(); i++){
			System.out.print(heap1.getData()[i] + ", ");
		}
		System.out.println();
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void testRemove1(){
		System.out.println("Test Remove 1");
		BinaryHeap heap1 = new BinaryHeap();
		heap1.add(1);
		heap1.add(40);
		heap1.add(23);
		heap1.add(62);
		heap1.add(0);
		heap1.add(-2);
		heap1.add(75);
		for(int i = 0; i < heap1.size(); i++){
			System.out.print(heap1.getData()[i] + ", ");
		}
		System.out.println();
		System.out.println("Root of heap: " + heap1.peek());
		System.out.println("Now removing!");
		Integer dataRemoved = (Integer)heap1.remove();
		System.out.println(dataRemoved);
		for(int i = 0; i < heap1.size(); i++){
			System.out.print(heap1.getData()[i] + ", ");
		}
		System.out.println();
		heap1.remove();
		for(int i = 0; i < heap1.size(); i++){
			System.out.print(heap1.getData()[i] + ", ");
		}
		System.out.println();
		heap1.remove();
		for(int i = 0; i < heap1.size(); i++){
			System.out.print(heap1.getData()[i] + ", ");
		}
		System.out.println();
		heap1.remove();
		for(int i = 0; i < heap1.size(); i++){
			System.out.print(heap1.getData()[i] + ", ");
		}
		System.out.println();
		heap1.remove();
		for(int i = 0; i < heap1.size(); i++){
			System.out.print(heap1.getData()[i] + ", ");
		}
		System.out.println();
		heap1.remove();
		for(int i = 0; i < heap1.size(); i++){
			System.out.print(heap1.getData()[i] + ", ");
		}
		heap1.remove();
		for(int i = 0; i < heap1.size(); i++){
			System.out.print(heap1.getData()[i] + ", ");
		}
		System.out.println();
		System.out.println(heap1.size());
		System.out.println(heap1.isEmpty());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void RemoveTest2(){
		System.out.println("Remove Test 2");
		BinaryHeap heap1 = new BinaryHeap();
		heap1.add(null);//Added to empty list
		heap1.add(1);
		heap1.add(2);
		heap1.add(3);
		heap1.add(4);
		heap1.add(5);
		heap1.add(6);
		heap1.add(7);
		heap1.add(8);
		heap1.add(9);
		heap1.add(10);//Need to resize after this
		heap1.add(11);
		for(int i = 0; i < heap1.size(); i++){
			System.out.print(heap1.getData()[i] + ", ");
		}
		System.out.println();
		System.out.println("NOW REMOVING ------");
		System.out.println();
		heap1.remove();
		for(int i = 0; i < heap1.size(); i++){
			System.out.print(heap1.getData()[i] + ", ");
		}
		System.out.println();
		heap1.remove();
		for(int i = 0; i < heap1.size(); i++){
			System.out.print(heap1.getData()[i] + ", ");
		}
		System.out.println();
		heap1.remove();
		for(int i = 0; i < heap1.size(); i++){
			System.out.print(heap1.getData()[i] + ", ");
		}
		System.out.println();
		System.out.println(heap1.size());
		System.out.println(heap1.isEmpty());
		System.out.println();
		

	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void addRemove3(){
		System.out.println("Test Remove 3 ------");
		BinaryHeap heap1 = new BinaryHeap();
		heap1.add(-1);//Added to empty list
		heap1.add(-2);
		heap1.add(-3);		
		heap1.add(-4);
		heap1.add(-5);
		heap1.add(-6);
		heap1.add(-7);
		heap1.add(-8);
		heap1.add(-9);
		heap1.add(-10);
		heap1.add(-11);//Need to resize after this
		heap1.add(0);
		for(int i = 0; i < heap1.size(); i++){
			System.out.print(heap1.getData()[i] + ", ");
		}
		System.out.println();
		System.out.println("Now Removing ----");
		heap1.remove();
		for(int i = 0; i < heap1.size(); i++){
			System.out.print(heap1.getData()[i] + ", ");
		}
		System.out.println();
		heap1.remove();
		for(int i = 0; i < heap1.size(); i++){
			System.out.print(heap1.getData()[i] + ", ");
		}
		System.out.println();
		System.out.println(heap1.size());
		System.out.println(heap1.isEmpty());
		System.out.println();
		

	}
	
	@Test
	public void testRemove4(){
		System.out.println("Test Remove 4 ------");
		BinaryHeap heap1 = new BinaryHeap();
		heap1.add(5);
		heap1.remove();
		for(int i = 0; i < heap1.size(); i++){
			System.out.print(heap1.getData()[i] + ", ");
		}
		System.out.println();
	}
	@Test
	public void testRemove5(){
		System.out.println("Test Remove 5 ------");
		BinaryHeap<Integer> heap1 = new BinaryHeap<Integer>();
		Integer removedData = heap1.remove();
		System.out.println(removedData);
		for(int i = 0; i < heap1.size(); i++){
			System.out.print(heap1.getData()[i] + ", ");
		}
		System.out.println();
	}
	
	
	
	//NOW TEST HEAP SORT
	
	@SuppressWarnings("unchecked")
	@Test
	public void heapSort1(){
		System.out.println("HeapSort Test 1------");
		BinaryHeap heap1 = new BinaryHeap();
		heap1.add(1);
		heap1.add(40);
		heap1.add(23);
		heap1.add(62);
		heap1.add(0);
		heap1.add(-2);
		heap1.add(null);
		boolean answer = heap1.heapSortWorked(heap1.heapSort());
		System.out.println(answer);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void heapSort2(){
		System.out.println("Heap Sort Test 2 -------");
		BinaryHeap heap1 = new BinaryHeap();
		heap1.add(null);
		heap1.add(1);
		heap1.add(2);
		heap1.add(3);
		heap1.add(4);
		heap1.add(5);
		heap1.add(6);
		heap1.add(7);
		heap1.add(8);
		heap1.add(9);
		heap1.add(10);//Need to resize after this
		heap1.add(11);
		for(int i = 0; i < heap1.size(); i++){
			System.out.print(heap1.getData()[i] + ", ");
		}
		System.out.println();
		System.out.println(heap1.size());
		System.out.println(heap1.isEmpty());
		System.out.println("Is the data in increasing order?");
		Object[] arraySorted = heap1.heapSort();
		boolean answer = heap1.heapSortWorked(arraySorted);
		System.out.println(answer);
		for(int i = 0; i < arraySorted.length; i++){
			System.out.print(arraySorted[i] + ", ");
		}
		System.out.println("Old List is still the same?");
		for(int i = 0; i < heap1.size(); i++){
			System.out.print(heap1.getData()[i] + ", ");
		}
		System.out.println();
		System.out.println();
		

	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void heapSort3(){
		System.out.println("Heap Sort Test 3 -------");
		BinaryHeap heap1 = new BinaryHeap();
		heap1.add(-1);//Added to empty list
		heap1.add(-2);
		heap1.add(-3);
		heap1.add(-4);
		heap1.add(-5);
		heap1.add(-6);
		heap1.add(-7);
		heap1.add(-8);
		heap1.add(-9);
		heap1.add(-10);
		heap1.add(-11);//Need to resize after this
		heap1.add(0);
		System.out.println();
		System.out.println(heap1.size());
		System.out.println(heap1.isEmpty());
		System.out.println();
		Object[] arraySorted = heap1.heapSort();
		boolean answer = heap1.heapSortWorked(arraySorted);
		System.out.println(answer);
		for(int i = 0; i < arraySorted.length; i++){
			System.out.print(arraySorted[i] + ", ");
		}
		System.out.println();
		System.out.println("Old List is still the same?");
		for(int i = 0; i < heap1.size(); i++){
			System.out.print(heap1.getData()[i] + ", ");
		}
		System.out.println();
	}
	

	@SuppressWarnings("unchecked")
	@Test
	public void heapSort4(){
		System.out.println("Heap Sort Test 4 -----");
		BinaryHeap heap1 = new BinaryHeap();
		for(int i = 0; i < 50; i++){
			heap1.add(i);
		}
		System.out.println();
		Object[] arraySorted = heap1.heapSort();
		boolean answer = heap1.heapSortWorked(arraySorted);
		System.out.println(answer);
		for(int i = 0; i < arraySorted.length; i++){
			System.out.print(arraySorted[i] + ", ");
		}
		System.out.println();
	}
	

	@SuppressWarnings("unchecked")
	@Test
	public void heapSort5(){
		System.out.println("Heap Sort Test 5 -----");
		BinaryHeap heap1 = new BinaryHeap();
		heap1.add(5);
		System.out.println();
		Object[] arraySorted = heap1.heapSort();
		boolean answer = heap1.heapSortWorked(arraySorted);
		System.out.println(answer);
		for(int i = 0; i < arraySorted.length; i++){
			System.out.print(arraySorted[i] + ", ");
		}
		System.out.println();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void heapSort6(){
		System.out.println("Heap Sort Test 6 -----");
		BinaryHeap heap1 = new BinaryHeap();
		heap1.add(null);
		System.out.println();
		Object[] arraySorted = heap1.heapSort();
		boolean answer = heap1.heapSortWorked(arraySorted);
		System.out.println(answer);
		for(int i = 0; i < arraySorted.length; i++){
			System.out.print(arraySorted[i] + ", ");
		}
		System.out.println();
	}
	
	
	
}
