import java.util.Random;
import java.util.concurrent.*;
public class East_village implements Runnable{
	Semaphore sem;
	String tasks[] = {"playing cards","reading jjk","eating donuts","drinking wine"};//random tasks
	public East_village(Semaphore sem){
		this.sem = sem;
	}//end of east village
	public void work(int num){
		Random rand = new Random();//setting up to make a random number
		int taskNum = rand.nextInt(4);//getting a random task
		try{
			//aquiring the lock
			sem.acquire();
			Thread.sleep(rand.nextInt(1000));//allowing the thread to switch if possible
			System.out.println("East_village_"+num+" is traveling on the road.");//haveing the village pass through
			Thread.sleep(rand.nextInt(1000));
			System.out.println("East_village_"+num+" "+tasks[taskNum]);//doing task
			Thread.sleep(rand.nextInt(1000));
		}
		catch(InterruptedException e){
			System.out.println(e);
		}
		finally{
			System.out.println("East_village_"+num+" Finished the exchange");//village done on the road
			sem.release();//releasing
		}
	}//end of work
	@Override
	public void run(){
		//switching the village numbers
		for(int i = 1; i <= 3; i++){
			work(i);
		}
	}//end of run
}//end of class