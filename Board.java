//Ioanna-Maria Avanidi
//A.M. 4977

import java.util.Random;
import java.util.ArrayList;

class Board{

    private int NoP; 
    private int NoC;
    private int [] myArray;
			
	public Board(int NoP){
        this.NoP = NoP;
        this.NoC = 2*NoP;
        myArray = new int[2*NoP];

        Random numb = new Random();
		
		for (int i=0; i<NoP; i++){
			myArray[i]=i;
		}
		 
		for (int i=0; i<NoP; i++){
			myArray[i + NoP]=i;
		}

        for (int i=0; i<myArray.length; i++){
			
            int rndPos = numb.nextInt(myArray.length);
            int temp = myArray[i];
            
			myArray[i] = myArray[rndPos];
            myArray[rndPos] = temp;
        }
    }
	
	
	public void epikefalida(){
		for (int i=0; i<myArray.length; i++){
			System.out.printf("%3d ", i);
		}
		System.out.println();
		
		for(int i=0; i<myArray.length; i++){
			System.out.print("----");
		}
		System.out.println();
	}
	
	public void printStar(){
		for (int i=0; i<myArray.length; i++){
			if(ContainsCard(i)){
				System.out.print(" *" +" ");
			} else {
				System.out.print("    ");
			}
		}
	}
	
	public void print(){
		epikefalida();
		printStar();
	}

	private void delay(int sec){
		try {
			Thread.currentThread().sleep(1000*sec);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void flash(int c1, int c2){
		print();
		
		System.out.print("\r");
		
		for (int i=0; i<myArray.length; i++){
			if (i==c1 || i==c2){
				System.out.printf("%3d ", myArray[i]);
			}else if (ContainsCard(i)){
				System.out.print(" *" +" ");
			} else {
				System.out.print("    ");
			}
		}
		
		delay(5);
		
		System.out.print("\r");
		
		printStar();
	}
	
	public int getRandomPosition(){
		System.out.println( ); 
		
		Random rand = new Random();

		int x=rand.nextInt(2*NoP);
		
		if (ContainsCard(x)){
				return x;
		} else {
			while(!ContainsCard(x)){
				x=rand.nextInt(2*NoP);
			
				if (ContainsCard(x)){
					return x;
				} 
			}
		}
		return x;
	} 

	public int getRandomPosition(int C){
		System.out.println( ); 
		
		Random rand = new Random();

		int x=rand.nextInt(2*NoP);
		
		if (ContainsCard(x) && C!=x){
				return x;
		} else {
			while(!ContainsCard(x) || C==x){
				x=rand.nextInt(2*NoP);
			
				if (ContainsCard(x) && C!=x){
					return x;
				} 
			}
		}
		return x;
	}

	public boolean ContainsCard(int C3){
		for (int i=0; i<myArray.length; i++){
			if (myArray[C3]==i){
				return true;
			} 
		}return false;
	}

	public int getCard(int C4){
		//System.out.println(myArray[C4]);
		return myArray[C4];
	}

	public boolean allPairsFound(){
		if (myArray==null){
			return true;
		} return false;
	}
	
	public boolean openPositions(int cd1, int cd2){
		System.out.println();
		
		if (myArray[cd1]==myArray[cd2]){
			System.out.println("Pair found (" +myArray[cd1] +"," +myArray[cd2] +")");
			
			myArray[cd1]=-3;
			myArray[cd2]=-3;
			
			print();
			
			return true;
		}
		
		flash(cd1, cd2);
		return false;
	}
	
	public static void main (String[] args){
		Board brd = new Board(3);
		
		brd.print();
		
		for (int i=0; i<6; i++){
			brd.getCard(i);
		}

		int ela = brd.getRandomPosition();
		int elb = brd.getRandomPosition(ela);
		
		brd.flash(ela, elb);
		
		brd.openPositions(4, 5);
		brd.openPositions(0, 1);
		
		brd.ContainsCard(1);
		brd.ContainsCard(4);
		
		brd.openPositions(2 ,3);
		
		ela = brd.getRandomPosition();
		elb = brd.getRandomPosition(ela);
		brd.openPositions(ela, elb);
		
		brd.allPairsFound();
	}
}