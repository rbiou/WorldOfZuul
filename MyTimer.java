import java.util.Timer;
import java.util.TimerTask;

public class MyTimer extends Game{
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new App(), 0, 1000);
    }
    
    // /**
     // * Start a timer when the player changing room, with a limited time which correspond to the time available in the
     // * planet. If the player keeps too long on the planet, he is killed.
     // **/
    // public void startTimer()
    // {
        // Room currentRoom = getPlayer().getCurrentRoom();
        // Room room_during_timer = currentRoom;
        // long original = System.currentTimeMillis();
        // while (room_during_timer == currentRoom) {
            // System.out.println("1");
            // room_during_timer = getPlayer().getCurrentRoom(); 
            // time_less = (getPlayer().getCurrentRoom().getPlanet().getTime()*1000) - (System.currentTimeMillis() - original);
            // if (time_less <= 0) {
                // getPlayer().looseHP(100);
                // break;
            // }
            // try 
            // {
                // Thread.sleep(1000);
            // } 
            // catch(InterruptedException e)
            // {}
        // } 
    // }
}

class App extends TimerTask {
    int countdown = 100;
    public void run() {
        countdown = countdown - 1;
        System.out.println(countdown);
    }

}