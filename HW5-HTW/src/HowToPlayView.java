import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class HowToPlayView extends JFrame implements IView {
  private static final long serialVersionUID = -7083924619099998893L;

  private JLabel image;
  private JButton exitButton;
  private JPanel panel;
  
  /**
   * Constructor for view object. 
   * 
   * @param caption of frame
   * @throws IOException 
   */
  public HowToPlayView(String caption, ControllerX control) {
    super(caption);
    
    
    this.exitButton = new JButton("Exit");
   
    pack();
    
  }
  
  @Override
  public void setFeatures(Features f) {
    this.exitButton.addActionListener(l -> f.openIntro()); 
  }

  @Override
  public void setListener(ActionListener clicks, KeyListener keys) {
    exitButton.addActionListener(clicks);
  }

  @Override
  public void display() {
    this.panel = new JPanel();
    
    this.setLocation(500, 500);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    BoxLayout box = new BoxLayout(this.panel, BoxLayout.Y_AXIS);
    this.panel.setLayout(box);
    image = new JLabel(
        new ImageIcon("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/HTWgif2.gif"));

    this.panel.add(image);
    
    String htp = "Welcome to Hunt the Wumpus, this is how to play: \n"; 
    JLabel display = new JLabel(htp);
    display.setFont(new Font("Serif", Font.HANGING_BASELINE, 18));
    display.setForeground(Color.white);
    
    String htp2 = "Hunt down the wumpus with your arrows, but don’t let the wumpus eat you. \n";
    JLabel display2 = new JLabel(htp2);
    display2.setFont(new Font("Serif", Font.HANGING_BASELINE, 18));
    display2.setForeground(Color.white);
    
    String htp3 = "Be careful of pits as you may fall to the death. \n";
    JLabel display3 = new JLabel(htp3);
    display3.setFont(new Font("Serif", Font.HANGING_BASELINE, 18));
    display3.setForeground(Color.white);
    
    String htp4 = "Superbats may carry you to another location in the maze. \n";
    JLabel display4 = new JLabel(htp4);
    display4.setFont(new Font("Serif", Font.HANGING_BASELINE, 18));
    display4.setForeground(Color.white);
    
    String htp5 = "To move your player, click on a position in the maze or move with arrow keys,";
    JLabel display5 = new JLabel(htp5);
    display5.setFont(new Font("Serif", Font.HANGING_BASELINE, 18));
    display5.setForeground(Color.white);
    
    String htp8 = " if you select a viable position, ";
    JLabel display8 = new JLabel(htp8);
    display5.setFont(new Font("Serif", Font.HANGING_BASELINE, 18));
    display5.setForeground(Color.white);
    
    String htp6 = "your player would move; if not, your player stays put. \n";
    JLabel display6 = new JLabel(htp6);
    display6.setFont(new Font("Serif", Font.HANGING_BASELINE, 18));
    display6.setForeground(Color.white);
    
    String htp7 = "In two player mode, the first to kill the wumpus wins. ";
    JLabel display7 = new JLabel(htp7);
    display7.setFont(new Font("Serif", Font.HANGING_BASELINE, 18));
    display7.setForeground(Color.white);
    

    this.panel.add(display);
    this.panel.add(display2);
    this.panel.add(display3);
    this.panel.add(display4);
    this.panel.add(display5);
    this.panel.add(display8);
    this.panel.add(display6);
    this.panel.add(display7);
    this.panel.add(exitButton);
    

    
    this.panel.setBackground(Color.lightGray);
    this.panel.setOpaque(true);
    this.panel.setVisible(true);
    this.setSize(700, 400);
    this.add(panel);
    this.setVisible(true);
  }



  public ArrayList<Integer> getGameConfig() {
    ArrayList<Integer> gameConf = new ArrayList<Integer>();
    return gameConf;
  }

  @Override
  public void close() {
    //this.dispose();
    
    this.getContentPane().removeAll();
    this.repaint();
    this.dispose();
  }

  
}