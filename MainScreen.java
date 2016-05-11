import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.border.EmptyBorder;


/**
 * Created by nigel on 5/5/2016.
 */
public class MainScreen extends JPanel implements ActionListener, MouseMotionListener, MouseListener, KeyListener {
    public static final int HEIGHT = 600;
    public static final int WIDTH = 900;
    private BufferedImage image;
    private Graphics2D bufferedGraphics;
    private Timer time;
    public Walls wall1, wall2;
    public double outsideTemperature;
    public double wallTemperature;
    public static final int WALL_AREA = 320;

    public MainScreen(){
        super();
        setPreferredSize(new Dimension(WIDTH - 250,HEIGHT));
        image = new BufferedImage(WIDTH,HEIGHT, BufferedImage.TYPE_INT_RGB);
        bufferedGraphics = image.createGraphics();
        time = new Timer(10, this);
        wall1 = new Walls(120,90, Walls.Type.COPPER);
        wall2 = new Walls(210,90, Walls.Type.ALUMINUM);
        addMouseMotionListener(this);
        addMouseListener(this);
        addKeyListener(this);
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
        JFrame outputframe = new JFrame("Outputs");

        MainScreen c = new MainScreen();
        JPanel wallpanel = new JPanel();
        wallpanel.add(c);
        wallpanel.setPreferredSize(new Dimension (WIDTH - 250, 600));
        wallpanel.setVisible(true);

        JPanel sidepanel = new SidePanel();
        sidepanel.setPreferredSize(new Dimension(250,600));
        sidepanel.setVisible(true);

        BoxLayout boxlayout = new BoxLayout(sidepanel, BoxLayout.Y_AXIS);
        sidepanel.setLayout(boxlayout);

        sidepanel.setBorder(new EmptyBorder(new Insets(10, 20, 10, 20)));

        JPanel containerpanel = new JPanel();
        containerpanel.add(wallpanel);
        containerpanel.add(sidepanel);
        containerpanel.setPreferredSize(new Dimension (WIDTH, HEIGHT));

        frame.add(containerpanel);

        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel outputpanel = new OutputPanel();
        outputpanel.setPreferredSize(new Dimension(250,300));
        outputpanel.setVisible(true);

        BoxLayout boxlayout2 = new BoxLayout(outputpanel, BoxLayout.Y_AXIS);
        outputpanel.setLayout(boxlayout2);
        outputpanel.setBorder(new EmptyBorder(new Insets(20, 20, 20, 20)));

        outputframe.add(outputpanel);

        outputframe.pack();
        outputframe.setResizable(false);
        outputframe.setVisible(true);
        outputframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override public void actionPerformed(ActionEvent e){}

    @Override public void mouseMoved(MouseEvent e){}

    @Override public void mouseDragged(MouseEvent e){}

    @Override public void mouseClicked(MouseEvent e){}

    @Override public void mousePressed(MouseEvent e) {}

    @Override public void mouseReleased(MouseEvent e) {}

    @Override public void mouseEntered(MouseEvent e) {}

    @Override public void mouseExited(MouseEvent e) {}

    @Override public void keyReleased(KeyEvent e){}

    @Override public void keyTyped(KeyEvent e){}

    @Override public void keyPressed(KeyEvent e){}

}