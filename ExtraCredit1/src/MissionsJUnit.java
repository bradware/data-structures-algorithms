import org.junit.Test;


public class MissionsJUnit {
	
	
	@Test
	public void Mission1Test1(){
		System.out.println("Mission1 Test 1 ------");
		Integer[] arr = {2, 44, 5, 1, 79, 82, -13, 23, 4};
		MissionOne.inplaceSort(arr);
		for(int i = 0; i < arr.length; i++){
			System.out.print( arr[i] + ", ");
		}
		System.out.println();

	}
	
	@Test
	public void Mission1Test2(){
		System.out.println("Mission1 Test 2 ------");
		Integer[] arr = {5, 5, 5, 5, 5, 5};
		MissionOne.inplaceSort(arr);
		for(int i = 0; i < arr.length; i++){
			System.out.print( arr[i] + ", ");
		}
		System.out.println();

	}
	
	@Test
	public void Mission1Test3(){
		System.out.println("Mission1 Test 3 ------");
		Integer[] arr = {5, 5, 5, 5, 5, 5, 6, 6, 6, 6};
		MissionOne.inplaceSort(arr);
		for(int i = 0; i < arr.length; i++){
			System.out.print( arr[i] + ", ");
		}
		System.out.println();

	}
	
	@Test
	public void Mission1Test4(){
		System.out.println("Mission1 Test 4 ------");
		Integer[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		MissionOne.inplaceSort(arr);
		for(int i = 0; i < arr.length; i++){
			System.out.print( arr[i] + ", ");
		}
		System.out.println();

	}
	
	@Test
	public void Mission1Test5(){
		System.out.println("Mission1 Test 5 ------");
		Integer[] arr = {0, -22, 44, -21, Integer.MAX_VALUE, Integer.MIN_VALUE, 44, 32, 2100, 1332, -32, -44, 100};
		MissionOne.inplaceSort(arr);
		for(int i = 0; i < arr.length; i++){
			System.out.print( arr[i] + ", ");
		}
		System.out.println();

	}
	
	@Test
	public void Mission1Test6(){
		System.out.println("Mission1 Test 6 ------");
		Integer[] arr = {};
		MissionOne.inplaceSort(arr);
		for(int i = 0; i < arr.length; i++){
			System.out.print( arr[i] + ", ");
		}
		System.out.println();

	}
	
	@Test
	public void Mission1Test7(){
		System.out.println("Mission1 Test 7 ------");
		Integer[] arr = {1};
		MissionOne.inplaceSort(arr);
		for(int i = 0; i < arr.length; i++){
			System.out.print( arr[i] + ", ");
		}
		System.out.println();

	}
	
	
	@Test
	public void Mission3Test1(){
		System.out.println();
		System.out.println();
		System.out.println("Mission3 Test 1 ******");
		Integer[] person1 = {1,2, 44};
		Integer[] person2 = {-2,0, 3};							
		int result = MissionThree.merge(person1, person2);
		System.out.println("Result: " + result);  //THIS IS RIGHT

	}
	
	@Test
	public void Mission3Test2(){
		System.out.println("Mission3 Test 2 ******");
		Integer[] person1 = {12, 22, 34, 55};
		Integer[] person2 = {-6, 24, 26, 58, 69};
		int result = MissionThree.merge(person1, person2);
		System.out.println("Result: " + result);  //THIS IS RIGHT

	}
	
	@Test
	public void Mission3Test3(){
		System.out.println("Mission3 Test 3 ******");
		Integer[] person1 = {};
		Integer[] person2 = {};
		int result = MissionThree.merge(person1, person2);
		System.out.println("Result: " + result);  //THIS IS RIGHT

	}
	
	@Test
	public void Mission3Test4(){
		System.out.println("Mission3 Test 4 ******");
		Integer[] person1 = {-1};
		Integer[] person2 = {};
		int result = MissionThree.merge(person1, person2);
		System.out.println("Result: " + result);  //THIS IS RIGHT

	}
	
	@Test
	public void Mission3Test5(){
		System.out.println("Mission3 Test 5 ******");
		Integer[] person1 = {1, 2, 3, 5};
		Integer[] person2 = {};
		int result = MissionThree.merge(person1, person2);
		System.out.println("Result: " + result);  //THIS IS RIGHT

	}
	
	@Test
	public void Mission3Test6(){
		System.out.println("Mission3 Test 6******");
		Integer[] person1 = {21, 32, 45, 67, 89};
		Integer[] person2 = {-4, 15, 81, 87};
		int result = MissionThree.merge(person1, person2);
		System.out.println("Result: " + result);  //THIS IS RIGHT

	}
	

	@Test
	public void Mission3Test7(){
		System.out.println("Mission3 Test 7******");
		Integer[] person1 = {21, 32, 45, 67, 89};
		Integer[] person2 = {-4, 15, 34, 95};
		int result = MissionThree.merge(person1, person2);
		System.out.println("Result: " + result);  //THIS IS RIGHT

	}
	
	@Test
	public void Mission3Test8(){
		System.out.println("Mission3 Test 8******");
		Integer[] person1 = {-4, 15, 34, 55};
		Integer[] person2 = {21, 32, 45, 67, 89};
		int result = MissionThree.merge(person1, person2);
		System.out.println("Result: " + result);  //THIS IS RIGHT

	}
	@Test
	public void Mission3Test9(){
		System.out.println("Mission3 Test 9******");
		Integer[] person1 = {};
		Integer[] person2 = {21, 32, 45, 67, 89};
		int result = MissionThree.merge(person1, person2);
		System.out.println("Result: " + result);  //THIS IS RIGHT

	}
	@Test
	public void Mission2Test1(){
		System.out.println("Mission2 TestAdd 1 $$$$$$");
		MissionTwo circularBuffer = new MissionTwo(10);
		circularBuffer.add(new Integer(2));
		circularBuffer.add(new Integer(4));
		circularBuffer.add(new Integer(1));
		for(int i = 0; i < circularBuffer.getData().length; i++){
			System.out.print( circularBuffer.getData()[i]+ ", ");
		}
		System.out.println();

	}
	
	@Test
	public void Mission2Test2(){
		System.out.println("Mission2 TestAdd 2 $$$$$$");
		MissionTwo circularBuffer = new MissionTwo(10);
		circularBuffer.add(new Integer(0));
		circularBuffer.add(new Integer(5));
		circularBuffer.add(new Integer(2));			//Test adding to full list and replacing largest value with new incoming 
		circularBuffer.add(new Integer(88));		//element
		circularBuffer.add(new Integer(99));		// Passed!
		circularBuffer.add(new Integer(-16));
		circularBuffer.add(new Integer(43));
		circularBuffer.add(new Integer(42));
		circularBuffer.add(new Integer(45));
		circularBuffer.add(new Integer(12));
		circularBuffer.add(new Integer(Integer.MIN_VALUE));
		for(int i = 0; i < circularBuffer.getData().length; i++){
			System.out.print( circularBuffer.getData()[i]+ ", ");
		}
		System.out.println();

	}
	
	@Test
	public void Mission2Test3(){
		System.out.println("Mission2 TestAdd 3 $$$$$$");
		MissionTwo circularBuffer = new MissionTwo(10);
		circularBuffer.add(new Integer(0));
		circularBuffer.add(new Integer(5));
		circularBuffer.add(new Integer(2));			 
		circularBuffer.add(new Integer(88));		
		circularBuffer.add(new Integer(99));		
		circularBuffer.add(new Integer(-16));
		circularBuffer.add(new Integer(43));
		circularBuffer.add(new Integer(43));		//Handles duplicate elements added to the tree very well
		circularBuffer.add(new Integer(42));
		circularBuffer.add(new Integer(45));
		circularBuffer.add(new Integer(110));
		circularBuffer.add(new Integer(250));
		circularBuffer.add(new Integer(-16));
		circularBuffer.add(new Integer(22));
		circularBuffer.add(new Integer(11));
		circularBuffer.add(new Integer(42));
		for(int i = 0; i < circularBuffer.getData().length; i++){
			System.out.print( circularBuffer.getData()[i]+ ", ");
		}
		System.out.println();

	}
	
	@Test
	public void Mission2Test4(){
		System.out.println("Mission2 TestAdd 4 $$$$$$");
		MissionTwo circularBuffer = new MissionTwo(10);
		circularBuffer.add(new Integer(0));
		for(int i = 0; i < circularBuffer.getData().length; i++){
			System.out.print( circularBuffer.getData()[i]+ ", ");
		}
		System.out.println();

	}
	
	@Test
	public void Mission2Test5(){
		System.out.println("Mission2 TestAdd 5 $$$$$$");
		MissionTwo circularBuffer = new MissionTwo(10);
		circularBuffer.add(null);
		for(int i = 0; i < circularBuffer.getData().length; i++){
			System.out.print( circularBuffer.getData()[i]+ ", ");
		}
		System.out.println();

	}
	
	@Test
	public void Mission2Test6(){
		System.out.println("Mission2 TestRemove 1 $$$$$$");
		MissionTwo circularBuffer = new MissionTwo(10);
		Integer removedData = (Integer)circularBuffer.remove();
		for(int i = 0; i < circularBuffer.getData().length; i++){
			System.out.print( circularBuffer.getData()[i]+ ", ");
		}
		System.out.println();
		System.out.println("SHould be null: " + removedData);
		System.out.println();

	}
	
	@Test
	public void Mission2Test7(){
		System.out.println("Mission2 TestRemove 2 $$$$$$");
		MissionTwo circularBuffer = new MissionTwo(10);
		circularBuffer.add(new Integer(2));
		circularBuffer.add(new Integer(4));
		circularBuffer.add(new Integer(1));
		for(int i = 0; i < circularBuffer.getData().length; i++){
			System.out.print( circularBuffer.getData()[i]+ ", ");
		}
		System.out.println();
		Integer removedData = (Integer)circularBuffer.remove();
		Integer removedData2 = (Integer)circularBuffer.remove();
		for(int i = 0; i < circularBuffer.getData().length; i++){
			System.out.print( circularBuffer.getData()[i]+ ", ");
		}
		System.out.println();
		System.out.println("Should be 1: " + removedData);
		System.out.println("Should be 2: " + removedData2);
		System.out.println("Start should be 2: " + circularBuffer.getStart());
		System.out.println();

	}
	
	@Test
	public void Mission2Test8(){
		System.out.println("Mission2 TestRemove 3 $$$$$$");
		MissionTwo circularBuffer = new MissionTwo(10);
		circularBuffer.add(new Integer(0));
		circularBuffer.add(new Integer(5));
		circularBuffer.add(new Integer(2));			 
		circularBuffer.add(new Integer(88));		
		circularBuffer.add(new Integer(99));		
		circularBuffer.add(new Integer(-16));
		circularBuffer.add(new Integer(43));
		circularBuffer.add(new Integer(43));		//Handles duplicate elements added to the tree very well
		circularBuffer.add(new Integer(42));
		circularBuffer.add(new Integer(45));
		circularBuffer.add(new Integer(110));
		circularBuffer.add(new Integer(250));
		circularBuffer.add(new Integer(-16));
		circularBuffer.add(new Integer(22));
		circularBuffer.add(new Integer(11));
		circularBuffer.add(new Integer(42));
		for(int i = 0; i < circularBuffer.getData().length; i++){
			System.out.print( circularBuffer.getData()[i]+ ", ");
		}
		System.out.println();
		Integer firstRemoved = (Integer)circularBuffer.remove();
		System.out.println("Should be -16: " + firstRemoved);
		for(int i = 0; i < circularBuffer.getData().length; i++){
			System.out.print( circularBuffer.getData()[i]+ ", ");
		}
		System.out.println();
		Integer secondRemoved = (Integer)circularBuffer.remove();
		System.out.println("Should be -16: " + secondRemoved);
		for(int i = 0; i < circularBuffer.getData().length; i++){
			System.out.print( circularBuffer.getData()[i]+ ", ");
		}
		System.out.println();
		Integer thirdRemoved = (Integer)circularBuffer.remove();
		System.out.println("Should be 0: " + thirdRemoved);
		for(int i = 0; i < circularBuffer.getData().length; i++){
			System.out.print( circularBuffer.getData()[i]+ ", ");
		}
		System.out.println();
		Integer fourthRemoved = (Integer)circularBuffer.remove();
		System.out.println("Should be 2: " + fourthRemoved);
		for(int i = 0; i < circularBuffer.getData().length; i++){
			System.out.print( circularBuffer.getData()[i]+ ", ");
		}
		System.out.println();
		System.out.println("Start Index should be 4: " + circularBuffer.getStart());
		System.out.println("End Index should be 9: " + circularBuffer.getEnd());
		circularBuffer.remove();
		circularBuffer.remove();
		circularBuffer.remove();
		circularBuffer.remove();
		circularBuffer.remove();
		System.out.println("Start Index should be 9: " + circularBuffer.getStart());
		System.out.println("End Index should be 9: " + circularBuffer.getEnd());
		circularBuffer.remove();
		for(int i = 0; i < circularBuffer.getData().length; i++){
			System.out.print( circularBuffer.getData()[i]+ ", ");
		}
		System.out.println();
		System.out.println("Start Index should be 0: " + circularBuffer.getStart());
		System.out.println("End Index should be 0: " + circularBuffer.getEnd());
		System.out.println("Now Adding again!");
		System.out.println();
		circularBuffer.add(42);
		circularBuffer.add(21);
		for(int i = 0; i < circularBuffer.getData().length; i++){
			System.out.print( circularBuffer.getData()[i]+ ", ");
		}
		
	}
	
	
	 
}
