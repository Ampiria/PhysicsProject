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
    private Graphics2D bufferedGraphics;
    public Walls wall1, wall2;
    public double outsideTemperature;
    public double wallTemperature;
    public static final int WALL_AREA = 320;
    public static double time = 0.0;

    public MainScreen(){
        super();
        setPreferredSize(new Dimension(WIDTH - 250,HEIGHT));
        image = new BufferedImage(WIDTH,HEIGHT, BufferedImage.TYPE_INT_RGB);
        bufferedGraphics = image.createGraphics();
        wall1 = new Walls(120,90, Walls.Type.COPPER);
        wall2 = new Walls(210,90, Walls.Type.ALUMINUM);
        requestFocus();
    }

    public double wall1MaterialHeat(){
        double wall1heat;
        wall1heat = wall1.materialType.specificHeat * WALL_AREA * 3;
        return wall1heat;
    }

    public double wall2MaterialHeat(){
        double wall2heat;
        wall2heat = wall2.materialType.specificHeat * WALL_AREA * 3;
        return wall2heat;
    }

    public double wall1RateOfHeatTransfer(){
        double wall1roht;
        wall1roht = wall1.materialType.thermalConductivity*WALL_AREA*3/wall1.WALL_DEPTH;
        return wall1roht;
    }

    public double wall2RateOfHeatTransfer(){
        double wall2roht;
        wall2roht = wall1.materialType.thermalConductivity*WALL_AREA*3/wall2.WALL_DEPTH;
        return wall2roht;
    }

    public void setOutsideTemperature(double outsideTemperature) {
        this.outsideTemperature = outsideTemperature;
    }

    public double getWallTemperature() {
        return wallTemperature;
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
        g.drawImage(image,0,0,this);
        Toolkit.getDefaultToolkit().sync();
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("Thermodynamics");
        JFrame outputFrame = new JFrame("Outputs");

        MainScreen c = new MainScreen();
        JPanel wallpanel = new JPanel();
        wallpanel.add(c);
        wallpanel.setPreferredSize(new Dimension (WIDTH - 250, 600));
        wallpanel.setVisible(true);

        JPanel sidePanel = new SidePanel();
        sidePanel.setPreferredSize(new Dimension(250,600));
        sidePanel.setVisible(true);

        BoxLayout boxlayout = new BoxLayout(sidePanel, BoxLayout.Y_AXIS);
        sidePanel.setLayout(boxlayout);

        sidePanel.setBorder(new EmptyBorder(new Insets(40, 20, 40, 20)));

        JPanel containerPanel = new JPanel();
        containerPanel.add(wallpanel);
        containerPanel.add(sidePanel);
        containerPanel.setPreferredSize(new Dimension (WIDTH, HEIGHT));

        frame.add(containerPanel);

        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel outputPanel = new OutputPanel();
        outputPanel.setPreferredSize(new Dimension(320,300));
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