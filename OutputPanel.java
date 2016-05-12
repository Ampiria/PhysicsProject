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

public class OutputPanel extends JPanel {

    JLabel heatratetitle = new JLabel("Rate of Heat Transfer (W or J/s)");

    JLabel heatratelabel = new JLabel("0.0");

    JLabel totalheattitle = new JLabel("Total Heat Transferred (J)");

    public static JLabel totalheatlabel = new JLabel("0.0");

    JLabel outtemptitle = new JLabel("Outside Temperature (°C)");

    public static JLabel outtemp = new JLabel(String.valueOf(MainScreen.sidePanel.outsidetempslide.getValue()));

    JLabel intemptitle = new JLabel("Inside Temperature(°C)");

    JLabel intemp = new JLabel(String.valueOf(MainScreen.insideTemperature));

    Font titlefont = new Font("Arial", Font.BOLD, 18);
    Font outputfont = new Font("Arial", Font.BOLD, 24);

    public OutputPanel() {
        outtemptitle.setFont(titlefont);
        outtemptitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(outtemptitle);

        outtemp.setFont(outputfont);
        outtemp.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(outtemp);

        add(Box.createRigidArea(new Dimension(0,20)));

        add(Box.createRigidArea(new Dimension(0,20)));

        intemptitle.setFont(titlefont);
        intemptitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(intemptitle);

        intemp.setFont(outputfont);
        intemp.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(intemp);

        add(Box.createRigidArea(new Dimension(0,20)));

        heatratetitle.setFont(titlefont);
        heatratetitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(heatratetitle);

        heatratelabel.setFont(outputfont);
        heatratelabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(heatratelabel);

        add(Box.createRigidArea(new Dimension(0,20)));

        totalheattitle.setFont(titlefont);
        totalheattitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(totalheattitle);

        totalheatlabel.setFont(outputfont);
        totalheatlabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(totalheatlabel);
    }
}
