
import java.awt.Color;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
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

public class ConfigView extends JFrame implements IView {
  private static final long serialVersionUID = -7083924619099998893L;

  private JLabel display, image, image2, label;
  private String difficulty;
  private GridBagConstraints gbc;
  private JPanel panel;
  private JButton start, easy, medium, realistic, goBack;
  private JTextField inputRow, inputCol, inputRem, inputType, inputPits, inputSB;
  
  /**
   * Constructor for view object. 
   * 
   * @param caption of frame
   * @throws IOException 
   */
  public ConfigView(String caption, ControllerX controller) throws IOException {
    super(caption);
    this.panel = new JPanel();
    
    this.setLocation(500, 500);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    GridBagLayout layout = new GridBagLayout();
    this.panel.setLayout(layout);
    this.gbc = new GridBagConstraints(); 
    this.difficulty = "Easy";
    
    // Buttons
    start = new JButton("START!");
 
    goBack = new JButton("Go Back");
    easy = new JButton("Easy");
    easy.setBackground(Color.GREEN);
    easy.setOpaque(true);
    ActionListener easyListener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
          setDifficulty("Easy");
      }
    };
    easy.addActionListener(easyListener);
    
    medium = new JButton("Medium");
    medium.setBackground(Color.CYAN);
    medium.setOpaque(true);
    ActionListener mediumListener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
          setDifficulty("Medium");
      }
    };
    medium.addActionListener(mediumListener);
    
    realistic = new JButton("Realistic");
    realistic.setBackground(Color.RED);
    realistic.setOpaque(true);
    ActionListener realListener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
          setDifficulty("Medium");
      }
    };
    realistic.addActionListener(realListener);
    
    
    pack();
    
  }
  
  public void setDifficulty(String difficulty){
    this.difficulty = difficulty;
  }

  @Override
  public void setFeatures(Features f) {
    this.start.addActionListener(l -> f.startGame(this.difficulty, false)); 
    this.goBack.addActionListener(l -> f.backToIntro()); 
  }
  
  @Override
  public void setListener(ActionListener clicks, KeyListener keys) {
    // TODO Auto-generated method stub
    start.addActionListener(clicks);
  }

  @Override
  public void display() {
    image = new JLabel(new ImageIcon("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/HTWgif2.gif"));
    gbc.gridx = 0;
    gbc.gridy = 0;
    this.panel.add(image, gbc);
    this.gbc.fill = GridBagConstraints.HORIZONTAL;
    
    
    display = new JLabel("Set Game Difficulty");
    gbc.gridx = 3;
    gbc.gridy = 2;
    this.panel.add(display, gbc);
    gbc.gridx = 2;
    gbc.gridy = 3;
    this.panel.add(easy, gbc);
    gbc.gridx = 3;
    gbc.gridy = 3;
    this.panel.add(medium, gbc);
    gbc.gridx = 4;
    gbc.gridy = 3;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    this.panel.add(realistic, gbc);
    
    
    this.panel.setBackground(Color.ORANGE);
    gbc.gridx = 3;
    gbc.gridy = 7;
    this.panel.add(start, gbc);
    gbc.gridx = 4;
    gbc.gridy = 7;
    
    this.panel.add(goBack, gbc);
    this.panel.setOpaque(true);
    this.panel.setVisible(true);
    this.add(panel);
    this.setSize(1100, 300);
    this.setVisible(true);

    
  }



  public ArrayList<Integer> getGameConfig() {
    return null;
  }

  @Override
  public void close() {
    this.dispose();
    
  }

}