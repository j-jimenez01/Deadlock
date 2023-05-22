import java.util.concurrent.*;
class Main {
  public static void main(String[] args) {
    System.out.println("Project 3\nCreated by Jose Jimenez\nDate: November 11, 2022\nID# 026176889\n");
		Semaphore sem = new Semaphore(1);//creating a semaphore object
		for(int i = 0;i < 3;i++){//repeating the loop 3 times
			//creating two threads
			East_village east = new East_village(sem);
			West_village west = new West_village(sem);
			Thread thread1 = new Thread(east);
			Thread thread2 = new Thread(west);
			//starting the threads
			thread1.start();
			thread2.start();
		}
  }//end of main
}//end of class