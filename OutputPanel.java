import javax.swing.*;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Component;
public class OutputPanel extends JPanel {

    JLabel heatratetitle = new JLabel("Rate of Heat Transfer (W or J/s)");

    JLabel heatratelabel = new JLabel(String.valueOf(MainScreen.rateOfHeatTransfer()));

    JLabel totalheattitle = new JLabel("Total Heat Transferred (J)");

    public static JLabel totalheatlabel = new JLabel(String.valueOf(MainScreen.totalHeatTransfered()));

    JLabel outtemptitle = new JLabel("Outside Temperature (°C)");
    JLabel walltemptitle = new JLabel("Wall Temperature (°C)");

    public static JLabel outtemp = new JLabel(String.valueOf(MainScreen.sidePanel.outsidetempslide.getValue()));
    public static JLabel walltemp = new JLabel(String.valueOf(MainScreen.sidePanel.walltempslide.getValue()));

    JLabel intemptitle = new JLabel("Inside Temperature(°C)");

    JLabel intemp = new JLabel(String.valueOf(MainScreen.getInsideTemperature()));

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

        walltemptitle.setFont(titlefont);
        walltemptitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(walltemptitle);

        walltemp.setFont(outputfont);
        walltemp.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(walltemp);


        add(Box.createRigidArea(new Dimension(0,20)));

        intemptitle.setFont(titlefont);
        intemptitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(intemptitle);

        intemp.setFont(outputfont);
        intemp.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(intemp);
        while (ButtonPanel.getRunning()==true){
            intemp.setText(String.valueOf(MainScreen.getInsideTemperature()));
        }

        add(Box.createRigidArea(new Dimension(0,20)));

        heatratetitle.setFont(titlefont);
        heatratetitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(heatratetitle);

        heatratelabel.setFont(outputfont);
        heatratelabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(heatratelabel);
        while (ButtonPanel.getRunning()==true){
            heatratelabel.setText(String.valueOf(MainScreen.rateOfHeatTransfer()));
        }

        add(Box.createRigidArea(new Dimension(0,20)));

        totalheattitle.setFont(titlefont);
        totalheattitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(totalheattitle);

        totalheatlabel.setFont(outputfont);
        totalheatlabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(totalheatlabel);
        while (ButtonPanel.getRunning()==true){
            MainScreen.updateHeat(String.valueOf(MainScreen.totalHeatTransfered()));
        }
    }
}
