import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class IntroView extends JFrame implements IView {
  private static final long serialVersionUID = -7083924619099998893L;

  private JLabel display, image, label;
  private JButton howToPlay, play, menu;
  private JButton exitButton;
  private JPanel panel;
  
  /**
   * Constructor for view object. 
   * 
   * @param caption of frame
   * @throws IOException 
   */
  public IntroView(String caption) throws IOException {
//    setTitle("JPanelBackgroundColor Test");
//    panel = new JPanel();
//    panel.setBackground(Color.black);
//    
//    image = new JLabel(new ImageIcon("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/HTWGIF.gif"));
//    panel.add(image);
//    
//    howToPlay = new JButton("How to Play!");
//    panel.add(howToPlay);
//    menu = new JButton("Menu");
//    panel.add(menu);
//    play = new JButton("Play!");
//    panel.add(play);
//    
//    
//    add(panel, BorderLayout.CENTER);
//    setSize(1000, 500);
//    setLocationRelativeTo(null);
//    this.setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
//    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    setVisible(true);
    super(caption);
    setSize(400, 400);
    setLocation(100,100);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    howToPlay = new JButton("How to Play!");
    howToPlay.setActionCommand("HowToPlay");
    
    
    play = new JButton("Play!");
    play.setActionCommand("Setup");
    
    
    
    pack();
    
  }

  @Override
  public void setDisp(String s) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void setListener(ActionListener clicks, KeyListener keys) {
    howToPlay.addActionListener(clicks);
    play.addActionListener(clicks);
  }

  @Override
  public void display() {
    image = new JLabel(new ImageIcon("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/HTWGIF.gif"));

    this.add(image);

    

    this.add(howToPlay);
    
    this.add(play);
    
    

    
    this.setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
    this.setSize(800, 500);
    this.setBackground(Color.RED);
    this.setVisible(true);
  }


  public void revealPic() {
    this.getContentPane().removeAll();
    this.repaint();
    
  }

  public ArrayList<Integer> getGameConfig() {
    ArrayList<Integer> gameConf = new ArrayList<Integer>();
//    gameConf.add(Integer.parseInt(inputRow.getText()));
//    gameConf.add(Integer.parseInt(inputCol.getText()));
//    gameConf.add(Integer.parseInt(inputRem.getText()));
//    gameConf.add(Integer.parseInt(inputType.getText()));
//    gameConf.add(Integer.parseInt(inputPits.getText()));
//    gameConf.add(Integer.parseInt(inputSB.getText()));
    
    return gameConf;
  }

  @Override
  public void close() {
    this.dispose();
    
  }
}