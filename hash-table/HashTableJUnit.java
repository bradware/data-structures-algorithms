import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;


public class HashTableJUnit {
	
	
	@Test
	public void testEquals1(){
		TableEntry<Integer, String> entry1 = new TableEntry<Integer, String>(5,"Brad");
		TableEntry<Integer, String> entry2 = new TableEntry<Integer, String>(6,"Brad");
		System.out.println(entry1.equals(entry2));
	}
	@Test
	public void testEquals2(){
		TableEntry<Integer, String> entry1 = new TableEntry<Integer, String>(5,"Brad");
		TableEntry<Integer, String> entry2 = new TableEntry<Integer, String>(5,"Will");
		System.out.println(entry1.equals(entry2));
	}
	@Test
	public void testEquals3(){
		TableEntry<Integer, String> entry1 = new TableEntry<Integer, String>(5,"Brad");
		TableEntry<Integer, String> entry2 = new TableEntry<Integer, String>(5,"Brad");
		System.out.println(entry1.equals(entry2));
	}

	@Test
	public void testEquals5(){
		TableEntry<Integer, String> entry1 = new TableEntry<Integer, String>(5,"Brad");
		TableEntry<Integer, String> entry2 = null;
		System.out.println(entry1.equals(entry2));
	}
	
	@Test
	public void testEquals6(){
		TableEntry<Integer, String> entry1 = new TableEntry<Integer, String>(5,"Brad");
		Integer entry2 = new Integer(2);
		System.out.println(entry1.equals(entry2));
	}
	
	@Test
	public void testSetValue1(){
		TableEntry<Integer, String> entry1 = new TableEntry<Integer, String>(5,"Brad");
		String oldValue = entry1.setValue("Chris");
		System.out.println(oldValue + ", " + entry1.getValue());
	}
	
	@Test
	public void testPut1(){
		System.out.println("Test Put 1 ------");
		LinearProbingHashtable<Integer, String> table1 = new LinearProbingHashtable<Integer, String>(5);
		int hashCode = new Integer(1).hashCode();
		table1.put(1, "Brad");
		System.out.println("Brad's index: " + hashCode%(table1.getArray().length));
		table1.drawTable();
		System.out.println();

	}
	
	@Test
	public void testPut2(){
		System.out.println("Test Put 2 ------");
		LinearProbingHashtable<Integer, String> table1 = new LinearProbingHashtable<Integer, String>(5);
		int hashCode = new Integer(1).hashCode();
		table1.put(1, "Brad");
		table1.put(2, "James");
		table1.put(3, "Smeag");
		table1.drawTable();
		System.out.println();
	}
	
	@Test
	public void testPut3(){
		System.out.println("Test Put 3 ------");
		LinearProbingHashtable<Integer, String> table1 = new LinearProbingHashtable<Integer, String>(5);
		int hashCode = new Integer(1).hashCode();
		table1.put(1, "Brad");
		table1.put(2, "James");
		table1.put(3, "Smeag");
		table1.put(2, "Ian");
		table1.drawTable();
		System.out.println();
	}
	
	
	@Test
	public void testPut4(){
		System.out.println("Test Put 4 ------");
		LinearProbingHashtable<Integer, String> table1 = new LinearProbingHashtable<Integer, String>(5);
		table1.put(1, "Brad");
		table1.put(2, "James");
		table1.put(3, "Smeag");
		table1.put(4, "Ian");
		table1.put(5, "Greg");
		table1.drawTable();
		System.out.println();
	}
	@Test
	public void testPut5(){
		System.out.println("Test Put 5 ------");
		LinearProbingHashtable<Integer, String> table1 = new LinearProbingHashtable<Integer, String>(5);
		table1.put(1, "Brad");
		table1.put(2, "James");
		table1.put(3, "Smeag");
		table1.put(4, "Ian");
		table1.put(5, "Greg");
		table1.put(2, "Paula");
		table1.drawTable();
		System.out.println();
	}
	
	@Test
	public void testPut6(){
		System.out.println("Test Put 6 ------");
		LinearProbingHashtable<Integer, String> table1 = new LinearProbingHashtable<Integer, String>(5);
		table1.put(1, "Brad");
		table1.put(2, "James");
		table1.put(3, "Smeag");
		table1.put(4, "Ian");
		table1.put(5, "Greg");
		table1.put(2, "Paula");
		table1.put(-1, "Joe");
		table1.put(100, "Bob");
		table1.put(22,"Joel");
		table1.put(32, "Seth");
		table1.put(4, "newIan");
		table1.drawTable();
		System.out.println();
		
	}
	
	@Test
	public void testRemove1(){
		System.out.println("Test Remove 1 ------");
		LinearProbingHashtable<Integer, String> table1 = new LinearProbingHashtable<Integer, String>(5);
		table1.put(1, "Brad");
		table1.remove(1);
		table1.drawTable();
		System.out.println();
	}
	
	@Test
	public void testRemove2(){
		System.out.println("Test Remove 2 ------");
		LinearProbingHashtable<Integer, String> table1 = new LinearProbingHashtable<Integer, String>(5);
		table1.put(1, "Brad");
		table1.put(2, "James");
		table1.put(3, "Smeag");
		table1.remove(2);
		table1.remove(1);
		table1.drawTable();
		System.out.println();
		System.out.println("size: " + table1.size());
		System.out.println();
	}
	
	@Test
	public void testRemove3(){
		System.out.println("Test Remove 3 ------");
		LinearProbingHashtable<Integer, String> table1 = new LinearProbingHashtable<Integer, String>(5);
		int hashCode = new Integer(1).hashCode();
		table1.put(1, "Brad");
		table1.put(2, "James");
		table1.put(3, "Smeag");
		table1.remove(1);
		table1.put(4, "Ian");
		table1.put(66, "Pedro");
		table1.drawTable();
		System.out.println();
	}
	
	@Test
	public void testRemove5(){
		System.out.println("Test Remove 5 ------");
		LinearProbingHashtable<Integer, String> table1 = new LinearProbingHashtable<Integer, String>(5);
		table1.put(1, "Brad");
		table1.put(2, "James");
		table1.remove(2);
		table1.put(3, "Smeag");
		table1.put(2, "Paula");
		table1.put(4, "Ian");
		table1.put(5, "Greg");
		table1.drawTable();
		System.out.println();
		System.out.println("size: " + table1.size());
		System.out.println();
	}
	
	@Test
	public void testRemove6(){
		System.out.println("Test Remove 6 ------");
		LinearProbingHashtable<Integer, String> table1 = new LinearProbingHashtable<Integer, String>(5);
		table1.put(1, "Brad");
		table1.put(2, "James");
		table1.put(3, "Smeag");
		table1.put(4, "Ian");
		table1.put(5, "Greg");
		table1.put(2, "Paula");
		table1.put(-1, "Joe");
		table1.remove(5);
		table1.remove(66);
		table1.remove(2);
		table1.put(2, "Callie");
		table1.put(100, "Bob");
		table1.put(22,"Joel");
		table1.put(32, "Seth");
		table1.put(4, "newIan");
		table1.remove(4);
		table1.drawTable();
		System.out.println();
		System.out.println("size: " + table1.size());
		System.out.println();
	}
	
	@Test
	public void testContainsValue1(){
		System.out.println("Test Contains Value 1 ------");
		LinearProbingHashtable<Integer, String> table1 = new LinearProbingHashtable<Integer, String>(5);
		table1.put(1, "Brad");
		table1.put(2, "James");
		table1.put(3, "Smeag");
		table1.put(4, "Ian");
		table1.put(5, "Greg");
		table1.put(2, "Paula");
		table1.put(-1, "Joe");
		table1.remove(5);
		table1.remove(66);
		table1.remove(2);
		table1.put(2, "Callie");
		System.out.println("Should be false: " +table1.containsValue("Greg"));
		table1.put(100, "Bob");
		table1.put(22,"Joel");
		table1.put(32, "Seth");
		table1.put(4, "newIan");
		table1.remove(4);
		table1.drawTable();
		System.out.println();
		System.out.println("size: " + table1.size());
		System.out.println();
		System.out.println("Should be true: " +table1.containsValue("Joe"));
		System.out.println("Should be false: " +table1.containsValue("Asshole"));


	}
	
	@Test
	public void testContainsKey1(){
		System.out.println("Test Contains Key 1 ------");
		LinearProbingHashtable<Integer, String> table1 = new LinearProbingHashtable<Integer, String>(5);
		table1.put(1, "Brad");
		table1.put(2, "James");
		table1.put(3, "Smeag");
		table1.put(4, "Ian");
		table1.put(5, "Greg");
		table1.put(2, "Paula");
		table1.put(-1, "Joe");
		table1.remove(5);
		table1.remove(66);
		table1.remove(2);
		table1.put(2, "Callie");
		System.out.println("Should be false: " +table1.containsKey(5));
		table1.put(100, "Bob");
		table1.put(22,"Joel");
		table1.put(32, "Seth");
		table1.remove(4);
		table1.put(4, "newIan");
		table1.drawTable();
		System.out.println();
		System.out.println("size: " + table1.size());
		System.out.println();
		System.out.println("Should be true: " +table1.containsKey(-1));
		System.out.println("Should be true: " +table1.containsKey(4));
	}
	
	@Test
	public void testGet1(){
		System.out.println("Test Get 1 ------");
		LinearProbingHashtable<Integer, String> table1 = new LinearProbingHashtable<Integer, String>(5);
		table1.put(1, "Brad");
		table1.put(2, "James");
		table1.put(3, "Smeag");
		table1.put(4, "Ian");
		table1.put(5, "Greg");
		table1.put(2, "Paula");
		table1.put(-1, "Joe");
		table1.remove(5);
		table1.remove(66);
		table1.remove(2);
		table1.put(2, "Callie");
		System.out.println("Should be null: " +table1.get(5));
		table1.put(100, "Bob");
		table1.put(22,"Joel");
		table1.put(32, "Seth");
		table1.remove(4);
		table1.put(4, "newIan");
		table1.drawTable();
		System.out.println();
		System.out.println("size: " + table1.size());
		System.out.println();
		System.out.println("Should be Joe: " +table1.get(-1));
		System.out.println("Should be newIan: " +table1.get(4));
		System.out.println("Should be null: " +table1.get(1000));
	}
	
	@Test
	public void testreHash1(){
		System.out.println("Test reHash 1 ------");
		LinearProbingHashtable<Integer, String> table1 = new LinearProbingHashtable<Integer, String>(4);
		table1.put(1, "Brad");
		table1.put(2, "James");
		table1.put(3, "Smeag");
		table1.drawTable();
		System.out.println("Should now resize");
		table1.put(4, "Ian");
		table1.drawTable();
		table1.put(5, "Greg");
		table1.put(200, "Paula");
		System.out.println("Should now resize");
		table1.put(-1, "Joe");
		table1.drawTable();
		table1.put(76, "Callie");
		table1.put(100, "Bob");
		table1.put(22,"Joel");
		table1.put(32, "Seth");
		table1.put(44, "newIan");
		table1.drawTable();
		System.out.println("Should now resize");
		table1.put(41, "wah");
		table1.drawTable();
		System.out.println();
		System.out.println("size: " + table1.size());
		System.out.println();
		
	}
	
	@Test
	public void testPutAll1(){
		System.out.println("Test Put All 1 ------");
		LinearProbingHashtable<Integer, String> table1 = new LinearProbingHashtable<Integer, String>();
		table1.put(1, "Brad");
		table1.put(2, "James");
		table1.remove(2);
		table1.put(3, "Smeag");
		table1.put(2, "Paula");
		table1.put(4, "Ian");
		table1.put(5, "Greg");
		table1.drawTable();
		LinearProbingHashtable<Integer, String> table2 = new LinearProbingHashtable<Integer, String>();
		table2.put(1, "newBrad");
		table2.put(55, "New");
		table2.put(98, "New1");
		table2.put(198, "New2");
		table2.put(495, "New3");
		table2.put(5, "newGreg");
		table2.put(213, "New4");
		System.out.println("Should redraw here");
		table1.putAll(table2);
		table1.drawTable();
		System.out.println();
		System.out.println("size: " + table1.size());
		System.out.println();
	}
	
	@Test
	public void testSetView1(){
		System.out.println("Test Set View 1 ------");
		LinearProbingHashtable<Integer, String> table1 = new LinearProbingHashtable<Integer, String>();
		table1.put(1, "Brad");
		table1.put(2, "James");
		table1.remove(2);
		table1.put(3, "Smeag");
		table1.put(2, "Paula");
		table1.put(4, "Ian");
		table1.put(5, "Greg");
		table1.put(1000, "Yo");
		table1.put(245, "new");
		table1.put(321, "new1");
		table1.remove(2);
		table1.put(248, "new2");
		table1.put(879, "lastnew");
		table1.remove(879);
		table1.drawTable();
		HashSet<Map.Entry<Integer,String>> newSet = (HashSet<Entry<Integer, String>>)table1.entrySet();
		for(Map.Entry<Integer, String> current: newSet){
			System.out.print(current.getKey() + "," + current.getValue() + " - ");
		}
		System.out.println();
		System.out.println("Set size: " + newSet.size());
		System.out.println();
		System.out.println("size: " + table1.size());
		System.out.println();
	}
	
	@Test
	public void testCollectionValues1(){
		System.out.println("Test Collection Values 1 ------");
		LinearProbingHashtable<Integer, String> table1 = new LinearProbingHashtable<Integer, String>();
		table1.put(1, "Brad");
		table1.put(2, "James");
		table1.remove(2);
		table1.put(3, "Smeag");
		table1.put(2, "Paula");
		table1.put(4, "Ian");
		table1.put(5, "Greg");
		table1.put(1000, "Yo");
		table1.put(245, "new");
		table1.put(321, "new1");
		table1.remove(2);
		table1.put(248, "new2");
		table1.put(879, "lastnew");
		table1.remove(879);
		table1.drawTable();
		ArrayList<String> list = (ArrayList<String>)table1.values();
		for(String current: list){
			System.out.print(current + " - ");
		}
		System.out.println();
		System.out.println("Collection size: " + list.size());
		System.out.println();
		System.out.println("size: " + table1.size());
		System.out.println();
	}

	

}
