import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.util.Timer;


public class ButtonPanel extends JPanel {

    public static boolean isrunning = false;

    Timer timer;

    JButton startbutton = new JButton("Start");

    JButton resetbutton = new JButton("Reset");

    public ButtonPanel () {

        startbutton.setMaximumSize(new Dimension(80,100));
        add(startbutton);

        startbutton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (isrunning == false) {

                    isrunning = true;
                    startbutton.setText("Stop");
                    timer = new Timer();
                    timer.schedule(new updateTime(), 0, 100);

                }

                else {
                    isrunning = false;
                    startbutton.setText("Start");

                    timer.cancel();
                    timer.purge();

                }
            }
        });

        add(Box.createRigidArea(new Dimension(40,0)));

        resetbutton.setMaximumSize(new Dimension(80,100));
        add(resetbutton);

        resetbutton.addActionListener(new ActionListener() {

            public void actionPerformed (ActionEvent e) {
                MainScreen.setTime(0.0);
                MainScreen.sidePanel.outsidetempslide.setValue(50);
                MainScreen.sidePanel.walltempslide.setValue(50);
            }
        });

    }

    public static boolean getRunning() {
        return isrunning;
    }

}

