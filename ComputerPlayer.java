//Ioanna-Maria Avanidi
//A.M. 4977

import java.util.Random;

class ComputerPlayer{

    private String cName;
	private int points=0;
	private int pairs;

	private int[] cpArray;
	
	public ComputerPlayer(String cName, int pairs){
		this.cName=cName;
		this.pairs=pairs;
		
		cpArray = new int[pairs];
		for(int i=0; i<cpArray.length; i++){
			cpArray[i]=-1;
		}
	}
	
	public void play(Board CP){
		System.out.print(cName +" select two position to open: ");
		
		int firstC = CP.getRandomPosition();
		int secondC;
		int firstC1 = CP.getCard(firstC);
		
		if ((cpArray[firstC1]!=-1) && cpArray[firstC1]!=firstC){
			secondC = cpArray[firstC1];
		} else {
			secondC = CP.getRandomPosition(firstC);
		}
		
		if (!CP.openPositions(firstC, secondC)){
			cpArray[CP.getCard(firstC)] = firstC;
			cpArray[CP.getCard(secondC)] = secondC;
		} else{
			points++;
		}
	}
    
    public int getPoints(){
        return points;
    }

    public String toString(){
        return cName +" ";
    }
	
	public static void main(String[] args){
		Board Cplay = new Board(1);
		Board Cplay1 = new Board(2);
		Board Cplay2 = new Board(3);
		Board Cplay3 = new Board(4);
		
		
		ComputerPlayer Cplayer = new ComputerPlayer("HAL", 9);
		ComputerPlayer Cplayer1 = new ComputerPlayer("HAL", 8);
		ComputerPlayer Cplayer2 = new ComputerPlayer("HAL", 7);
		ComputerPlayer Cplayer3 = new ComputerPlayer("HAL", 6);
		
		Cplayer.play(Cplay);
		Cplayer1.play(Cplay1);
		Cplayer2.play(Cplay2);
		Cplayer3.play(Cplay3);
	}
}