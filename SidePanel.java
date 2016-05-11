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

/**
 * Created by nigel on 5/5/2016.
 */
public class SidePanel extends JPanel implements MouseListener, ActionListener{

    JButton startbut = new JButton("Start");

    JSlider outsidetempslide = new JSlider(0,100,50);

    JLabel menu1title = new JLabel("Wall 1 Material");

    JLabel menu2title = new JLabel("Wall 2 Material");

    JLabel slidertitle = new JLabel("Outside Temperature");
    JLabel sliderundertitle = new JLabel("°C");

    JLabel timetitle = new JLabel("Time");

    JLabel timelabel = new JLabel("0.0");

    JPanel buttonpanel = new ButtonPanel();
    BoxLayout boxlayout3 = new BoxLayout(buttonpanel, BoxLayout.X_AXIS);

    String[] choices = { "Aluminum","Copper", "Glass","Ice","Iron/Steel","Lead","Wood"};
    final JComboBox<String> wall1menu = new JComboBox<String>(choices);
    final JComboBox<String> wall2menu = new JComboBox<String>(choices);

    Font sliderfont = new Font("Serif", Font.BOLD, 15);
    Font titlefont = new Font("Arial", Font.BOLD, 18);
    Font outputfont = new Font("Arial", Font.BOLD, 24);

    public SidePanel() {

        menu1title.setFont(titlefont);
        menu1title.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(menu1title);

        add(Box.createRigidArea(new Dimension(0,10)));

        wall1menu.setSize(100,20);
        wall1menu.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(wall1menu);

        add(Box.createRigidArea(new Dimension(0,60)));

        menu2title.setFont(titlefont);
        menu2title.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(menu2title);

        add(Box.createRigidArea(new Dimension(0,10)));

        wall2menu.setSize(100,20);
        wall2menu.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(wall2menu);

        add(Box.createRigidArea(new Dimension(0,60)));

        slidertitle.setFont(titlefont);
        slidertitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(slidertitle);

        add(Box.createRigidArea(new Dimension(0,10)));

        outsidetempslide.setMajorTickSpacing(20);
        outsidetempslide.setPaintTicks(true);
        outsidetempslide.setFont(sliderfont);
        outsidetempslide.setPaintLabels(true);
        outsidetempslide.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(outsidetempslide);

        sliderundertitle.setFont(sliderfont);
        sliderundertitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(sliderundertitle);

        add(Box.createRigidArea(new Dimension(0,50)));

        buttonpanel.setLayout(boxlayout3);
        add(buttonpanel);

        add(Box.createRigidArea(new Dimension(0,50)));

        timetitle.setFont(titlefont);
        timetitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(timetitle);

        timelabel.setFont(outputfont);
        timelabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(timelabel);


        //this.setBorder(BorderFactory.createLineBorder(Color.black, 4));

    }


    @Override public void actionPerformed(ActionEvent e){}

    @Override public void mousePressed(MouseEvent e) {}

    @Override public void mouseReleased(MouseEvent e) {}

    @Override public void mouseEntered(MouseEvent e) {}

    @Override public void mouseExited(MouseEvent e) {}

    @Override public void mouseClicked(MouseEvent e) { }
}