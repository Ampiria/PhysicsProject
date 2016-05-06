import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;



/**
 * Created by nigel on 5/5/2016.
 */
public class MainScreen extends JPanel implements ActionListener, MouseMotionListener, MouseListener, KeyListener {
    public static final int HEIGHT = 600;
    public static final int WIDTH = 900;
    private BufferedImage image;
    private Graphics2D bufferedGraphics;
    private Timer time;
    private Walls wall1, wall2;

    public MainScreen(){
        super();
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        image = new BufferedImage(WIDTH,HEIGHT, BufferedImage.TYPE_INT_RGB);
        bufferedGraphics = image.createGraphics();
        time = new Timer(15, this);
        wall1 = new Walls(120,90, Walls.Type.COPPER);
        wall2 = new Walls(210,90, Walls.Type.ALUMINUM);
        addMouseMotionListener(this);
        addMouseListener(this);
        addKeyListener(this);
        requestFocus();
    }
    @Override public void paintComponent(Graphics g){
        super.paintComponent(g);
        bufferedGraphics.clearRect(0,0,WIDTH, HEIGHT);
        bufferedGraphics.setColor(Color.WHITE);
        bufferedGraphics.fillRect(0,0,WIDTH,HEIGHT);
        wall1.drawWalls(bufferedGraphics);
        wall2.drawWalls(bufferedGraphics);
        g.drawImage(image,0,0,this);
        Toolkit.getDefaultToolkit().sync();
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("Thermodynamics");
        MainScreen c = new MainScreen();
        frame.add(c);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
