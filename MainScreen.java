import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.border.EmptyBorder;
import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by nigel on 5/5/2016.
 */

public class MainScreen extends JPanel {
    public static final int HEIGHT = 600;
    public static final int WIDTH = 900;
    private BufferedImage image;
    public static Graphics2D bufferedGraphics;
    public static Walls wall1, wall2;
    public static double outsideTemperature;
    public static double insideTemperature, totalHeat;
    public static final int WALL_AREA = 320;
    public static double time = 0.0;
    public static String wall1type, wall2type;

    public MainScreen(){
        super();
        setPreferredSize(new Dimension(WIDTH - 250,HEIGHT));
        image = new BufferedImage(WIDTH,HEIGHT, BufferedImage.TYPE_INT_RGB);
        bufferedGraphics = image.createGraphics();
        wall1type = String.valueOf(sidePanel.wall1menu.getSelectedItem());
        wall2type = String.valueOf(sidePanel.wall1menu.getSelectedItem());
        wall1 = new Walls(179,0, wall1type);
        wall2 = new Walls(260,0, wall2type);
        bufferedGraphics.setColor(Color.red);
        bufferedGraphics.drawLine(200,90,200,490);
        requestFocus();
    }

    public void setOutsideTemperature() {
        this.outsideTemperature = sidePanel.getOutsideTemp();
    }

    public double getInsideTemperature() {
        return insideTemperature;
    }

    public void setInsideTemperature(){
        this.insideTemperature = 9;
    }
    public static void setTotalHeat(){
        double outsideHeat;

    }

    public double getOutsideTemperature() {
        return outsideTemperature;
    }
    @Override public void paintComponent(Graphics g){
        super.paintComponent(g);
        bufferedGraphics.clearRect(0,0,WIDTH - 250, HEIGHT);
        bufferedGraphics.setColor(Color.WHITE);
        bufferedGraphics.fillRect(0,0,WIDTH - 250,HEIGHT);
        wall1.drawWalls(bufferedGraphics);
        wall2.drawWalls(bufferedGraphics);
        g.setColor(Color.red);
        g.drawLine(200,90,200,490);
        g.drawImage(image,0,0,this);
        Toolkit.getDefaultToolkit().sync();
    }
    public static SidePanel sidePanel;
    public static JFrame frame;
    public static MainScreen c;
    public static  JPanel wallpanel,containerPanel;
    public static BoxLayout boxlayout;
    public double rateOfHeatTransfer(){
        return (MainScreen.outsideTemperature-MainScreen.insideTemperature)/((wall1.WALL_WIDTH/wall1.materialType.thermalConductivity)+(wall2.WALL_WIDTH/wall2.materialType.thermalConductivity));
    }
    public static void main(String[] args){
        frame = new JFrame("Thermodynamics");
        JFrame outputFrame = new JFrame("Outputs");

        c = new MainScreen();
        wallpanel = new JPanel();
        wallpanel.add(c);
        wallpanel.setPreferredSize(new Dimension (WIDTH - 250, 600));
        wallpanel.setVisible(true);

        sidePanel = new SidePanel();
        sidePanel.setPreferredSize(new Dimension(250,600));
        sidePanel.setVisible(true);

        boxlayout = new BoxLayout(sidePanel, BoxLayout.Y_AXIS);
        sidePanel.setLayout(boxlayout);

        sidePanel.setBorder(new EmptyBorder(new Insets(40, 20, 40, 20)));

        containerPanel = new JPanel();
        containerPanel.add(wallpanel);
        containerPanel.add(sidePanel);
        containerPanel.setPreferredSize(new Dimension (WIDTH, HEIGHT));

        frame.add(containerPanel);

        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel outputPanel = new OutputPanel();
        outputPanel.setPreferredSize(new Dimension(320,350));
        outputPanel.setVisible(true);

        BoxLayout boxlayout2 = new BoxLayout(outputPanel, BoxLayout.Y_AXIS);
        outputPanel.setLayout(boxlayout2);
        outputPanel.setBorder(new EmptyBorder(new Insets(20, 20, 20, 20)));

        outputFrame.add(outputPanel);

        outputFrame.pack();
        outputFrame.setResizable(false);
        outputFrame.setVisible(true);
        outputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static boolean getRunning() {
        return SidePanel.getRunning();
    }

    public static void setTime(double aTime) {
        time = aTime;
        SidePanel.timelabel.setText(Double.toString(time));
    }
}