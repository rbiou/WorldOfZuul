import java.util.Timer;
import java.util.TimerTask;

public class MyTimer{
    public static void main(Game myGame) {
        Timer timer = new Timer();
        timer.schedule(new App(myGame), 0, myGame.getPlayer().getCurrentRoom().getPlanet().getTime()*1000);
        //timer.schedule(myGame.getPlayer().kill(), myGame.getPlayer().getCurrentRoom().getPlanet().getTime()*1000);
    }
}

class App extends TimerTask {
    int countdown;
    public App(Game myGame)
    {
        int countdown = myGame.getPlayer().getCurrentRoom().getPlanet().getTime();
    }

    public void run() {
        countdown = countdown - 1;
        System.out.println(countdown);
    }

}