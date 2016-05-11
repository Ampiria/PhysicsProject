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
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class ButtonPanel extends JPanel {

    JButton startbutton = new JButton("Start");

    JButton resetbutton = new JButton("Reset");

    public ButtonPanel () {

        startbutton.setMaximumSize(new Dimension(80,100));
        add(startbutton);

        add(Box.createRigidArea(new Dimension(40,0)));

        resetbutton.setMaximumSize(new Dimension(80,100));
        add(resetbutton);

    }
}
