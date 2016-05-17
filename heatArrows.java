import java.awt.*;
import java.util.TimerTask;

public class heatArrows extends TimerTask{
    public void run(){
        if (MainScreen.rateOfHeatTransfer()>0){
            MainScreen.bufferedGraphics.setColor(Color.black);
            MainScreen.bufferedGraphics.drawLine(270, MainScreen.HEIGHT/2, 460, MainScreen.HEIGHT/2);

        }else if(MainScreen.rateOfHeatTransfer()<0){
            MainScreen.bufferedGraphics.setColor(Color.black);
            MainScreen.bufferedGraphics.drawLine(270, MainScreen.HEIGHT/2, 460, MainScreen.HEIGHT/2);
        }
    }

}
