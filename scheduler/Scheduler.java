package jobrunr.scheduler;

import java.util.*;
import java.util.concurrent.*;

public class Scheduler {
    public static void main(String[] args) {

        Runnable task1 = new Command("task1");

        System.out.println("Current time:" + Calendar.getInstance().get(Calendar.SECOND));

        ScheduledThreadPoolExecutor threadPool = new ScheduledThreadPoolExecutor(2);
        threadPool.schedule(task1, 5, TimeUnit.SECONDS);

        threadPool.shutdown();
    }    
}

class Command implements Runnable {

    String taskName;
    
    public Command(String taskName)
    {
        this.taskName = taskName;
    }
    
    public void run()
    {
        System.out.println(
            "Task name : " + this.taskName + " Current time: "
            + Calendar.getInstance().get(Calendar.SECOND));
    }
}
