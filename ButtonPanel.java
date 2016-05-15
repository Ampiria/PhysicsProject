import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Component;
import java.util.Timer;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


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
                MainScreen.wall1type = String.valueOf(MainScreen.sidePanel.wall1menu.getSelectedItem());
                MainScreen.wall1 = new Walls(120,90, MainScreen.wall1type);
                MainScreen.wall1.drawWalls(MainScreen.bufferedGraphics);

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

