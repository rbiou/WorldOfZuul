import java.util.Timer;
import java.util.TimerTask;

public class MyTimer{
    public static void main(Game myGame) {
        Timer timer = new Timer();
        timer.schedule(new App(myGame, timer), 0, 1000);
        //timer.schedule(myGame.getPlayer().kill(), myGame.getPlayer().getCurrentRoom().getPlanet().getTime()*1000);
    }
}

class App extends TimerTask {
    int countdown;
    Timer timer;
    Room currentRoom;
    Game game;
    
    public App(Game myGame, Timer myTimer)
    {
        int countdown = myGame.getPlayer().getCurrentRoom().getPlanet().getTime();
        currentRoom = myGame.getPlayer().getCurrentRoom();
        timer = myTimer;
        game = myGame;
    }

    public void run() {
        countdown = countdown - 1;
        if (countdown == 0)
        {
            //kill the player
            timer.cancel();
            timer.purge();
        }
        else if (currentRoom != game.getPlayer().getCurrentRoom())
        {
            timer.cancel();
            timer.purge();
        }
        System.out.println(countdown);
    }

}