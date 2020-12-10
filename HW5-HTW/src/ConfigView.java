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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ConfigView extends JFrame implements IView {
  private static final long serialVersionUID = -7083924619099998893L;

  private JLabel display, image, image2, label;
  private JButton submit;
  private JButton exitButton;
  private JTextField inputRow, inputCol, inputRem, inputType, inputPits, inputSB;
  
  /**
   * Constructor for view object. 
   * 
   * @param caption of frame
   * @throws IOException 
   */
  public ConfigView(String caption) throws IOException {
    super(caption);
    setSize(400, 400);
    setLocation(100,100);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    submit = new JButton("Play");
    submit.setActionCommand("Play");
    pack();
    
  }

  @Override
  public void setDisp(String s) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void setListener(ActionListener clicks, KeyListener keys) {
    // TODO Auto-generated method stub
    submit.addActionListener(clicks);
  }

  @Override
  public void display() {
    image = new JLabel(new ImageIcon("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/wumpus.png"));
    image2 = new JLabel(new ImageIcon("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/wumpus.png"));

    this.add(image);
    this.add(image2);

    
    display = new JLabel("Number of Rows in Dungeon, (max 8):");
    this.add(display);
    // the text field
    inputRow = new JTextField(10);
    this.add(inputRow);
    
    display = new JLabel("Number of Columns in Dungeon, (max 8):");
    this.add(display);
    // the text field
    inputCol = new JTextField(10);
    this.add(inputCol);
    
    display = new JLabel("Number of Remaining walls in Dungeon, (max 8):");
    this.add(display);
    // the text field
    inputRem = new JTextField(10);
    this.add(inputRem);
    
    display = new JLabel("Type of Maze:");
    this.add(display);
    // the text field
    inputType = new JTextField(10);
    this.add(inputType);
    
    display = new JLabel("Number of Pits:");
    this.add(display);
    // the text field
    inputPits = new JTextField(10);
    this.add(inputPits);
    
    display = new JLabel("Number of Superbats:");
    this.add(display);
    // the text field
    inputSB = new JTextField(10);
    this.add(inputSB);
    
    this.add(submit);


    this.setLayout(new GridLayout(10,2));
    this.setSize(550, 300);
    this.setVisible(true);
  }

  public void revealPic() {
    this.getContentPane().removeAll();
    this.repaint();
    
    JLabel images = new JLabel(new ImageIcon("/Users/ugoslight/Downloads/res/wumpus.png"));
    this.add(images);

  }

  public ArrayList<Integer> getGameConfig() {
    ArrayList<Integer> gameConf = new ArrayList<Integer>();
    gameConf.add(Integer.parseInt(inputRow.getText()));
    gameConf.add(Integer.parseInt(inputCol.getText()));
    gameConf.add(Integer.parseInt(inputRem.getText()));
    gameConf.add(Integer.parseInt(inputType.getText()));
    gameConf.add(Integer.parseInt(inputPits.getText()));
    gameConf.add(Integer.parseInt(inputSB.getText()));
    
    return gameConf;
  }

  @Override
  public void close() {
    this.dispose();
    
  }
}