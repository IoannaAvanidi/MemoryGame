//Ioanna-Maria Avanidi
//A.M. 4977
 
import java.util.Scanner;

class MemoryGame{
	
    public static void main(String[] args){
		int cla = Integer.parseInt(args[0]);
		
        Board brd2 = new Board(cla);
		
        System.out.println("Do you want a game between Computer and Player(type CP) or between two players(type PP)? :");
        Scanner keyboard = new Scanner(System.in);
        String b = keyboard.nextLine();

        if (b.equals("PP")){
            HumanPlayer HP =new HumanPlayer("Ioanna");
            
            HumanPlayer HP2 = new HumanPlayer("Elena");
			
			brd2.print();
			
			System.out.println();

            while(!brd2.allPairsFound()){

				System.out.println();

                HP.play(brd2);
				System.out.println();
				brd2.print();
				
				System.out.println();
            
                HP2.play(brd2);
				System.out.println();
				brd2.print();
				
				System.out.println();

                int p3=HP.getPoints();
				System.out.println(HP.toString() +"points: " +p3 +" ");
				
                int p4=HP2.getPoints();
				System.out.println(HP2.toString() +"points: " +p4 +" ");
            }
			
			if (brd2.allPairsFound()){
                    System.out.println("All pairs found! Game ends!");
                    if (HP.getPoints()>HP2.getPoints()){
                        System.out.println("Congratulations" +HP.toString() +"You are the winner!");
                    } else if (HP.getPoints()<HP2.getPoints()){
                        System.out.println("Congratulations" +HP2.toString() +"You are the winner!");
                    } else {
						System.out.println("It's a draw!");
					}
                }
        } else if (b.equals("CP")){
            HumanPlayer HP3 =new HumanPlayer("Ioanna");

            ComputerPlayer CP = new ComputerPlayer("HAL", cla);
			
			brd2.print();

            while(!brd2.allPairsFound()){

                HP3.play(brd2);
				System.out.println();
				brd2.print();
               
                CP.play(brd2);
				System.out.println();
				brd2.print();
				
				System.out.println();

                int p1=HP3.getPoints();
				System.out.println(HP3.toString() +"points: " +HP3.getPoints());
				
                int p2=CP.getPoints();
				System.out.println(CP.toString() +"points: " +CP.getPoints());
            }
			if (brd2.allPairsFound()){
                System.out.println("All pairs found! Game ends!");
                if (HP3.getPoints()>CP.getPoints()){
                   System.out.println("Congratulations" +HP3.toString() +"You are the winner!");
				} else if(HP3.getPoints()<CP.getPoints()){
                    System.out.println("Congratulations" +CP.toString() +"You are the winner!");
                } else {
					System.out.println("It's a draw!");
				}
            }
		}
	}
}
