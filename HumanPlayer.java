//Ioanna-Maria Avanidi
//A.M. 4977

import java.util.Scanner;

class HumanPlayer{

    private String name;
    private int points;
	

    public HumanPlayer(String name){
        this.name=name;
    }

    public void play(Board HP){
		
		System.out.println();
		
        Scanner numbers = new Scanner(System.in);
        System.out.print(name +" select two positions to open:");
        int first = numbers.nextInt();
        int second = numbers.nextInt();

        while ((!HP.ContainsCard(first) || !HP.ContainsCard(second))|| first==second ){
            System.out.println("Invalid Selection");
			
			System.out.println();
			
            numbers = new Scanner(System.in);
            System.out.print(name +" select two positions to open:");
            first = numbers.nextInt();
            second = numbers.nextInt();
        }
		
		HP.openPositions(first, second);
		
		if (HP.openPositions(first, second)){
			points++;
		}
    }

    public int getPoints(){
        return points;
    }

    public String toString(){
        return name +" ";
    }
}