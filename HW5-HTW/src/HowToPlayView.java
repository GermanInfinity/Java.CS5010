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

public class HowToPlayView extends JFrame implements IView {
  private static final long serialVersionUID = -7083924619099998893L;

  private JLabel display;
  private JButton exitButton;
  private JPanel panel;
  
  /**
   * Constructor for view object. 
   * 
   * @param caption of frame
   * @throws IOException 
   */
  public HowToPlayView(String caption) throws IOException {
    super(caption);
    setSize(400, 400);
    setLocation(100,100);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    exitButton = new JButton("Exit");
    exitButton.setActionCommand("Exit");
   
    pack();
    
  }

  @Override
  public void setDisp(String s) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void setListener(ActionListener clicks, KeyListener keys) {
    exitButton.addActionListener(clicks);

  }

  @Override
  public void display() {
    display = new JLabel("Welcome to Hunt the Wumpus, this is how to play: ");
    this.add(display);
    
    this.add(exitButton);
    
    this.setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
    this.setBackground(Color.red);
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