
import java.awt.Color;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * ConfigVIew class represents the view that is shown before the game starts. It
 * collects information about the game.
 * 
 * @author ugoslight
 *
 */
public class ConfigView extends JFrame implements IView {
  private static final long serialVersionUID = -7083924619099998893L;

  private String difficulty;
  private int playerNum;
  private GridBagConstraints gbc;
  private JPanel panel;
  private JButton start;
  private JButton easy;
  private JButton medium;
  private JButton realistic;
  private JButton goBack;
  private JButton one;
  private JButton two;
  private ArrayList<Integer> info;

  /**
   * Constructor for view object.
   * 
   * @param caption of frame, controller to use
   */
  public ConfigView(String caption, ControllerX controller) throws IOException {
    super(caption);

    if (caption == null) {
      caption = "Config View";
    }
    if (controller == null) {
      throw new IllegalArgumentException("Please provide this view a controller.");
    }

    this.panel = new JPanel();

    this.setLocation(500, 500);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.info = new ArrayList<Integer>();

    GridBagLayout layout = new GridBagLayout();
    this.panel.setLayout(layout);
    this.gbc = new GridBagConstraints();

    // Default settings
    this.difficulty = "Easy";
    this.playerNum = 1;

    // Buttons
    start = new JButton("START!");
    start.setForeground(Color.PINK);

    goBack = new JButton("Go Back");
    easy = new JButton("Easy");
    easy.setForeground(Color.GREEN);
    // easy.setOpaque(true);

    ActionListener easyListener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        setDifficulty("Easy");
      }
    };
    easy.addActionListener(easyListener);

    medium = new JButton("Medium");
    medium.setForeground(Color.CYAN);
    // medium.setOpaque(true);
    ActionListener mediumListener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        setDifficulty("Medium");
      }
    };
    medium.addActionListener(mediumListener);

    realistic = new JButton("Realistic");
    realistic.setForeground(Color.RED);
    // realistic.setOpaque(true);
    ActionListener realListener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        setDifficulty("Hard");
      }
    };
    realistic.addActionListener(realListener);

    one = new JButton("1 player");
    ActionListener oneListener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        setNoPlayers(1);
      }
    };
    one.addActionListener(oneListener);

    two = new JButton("2 players");
    ActionListener twoListener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        JOptionPane.showMessageDialog(null,
            "Two player game development reserved for future versions.");
      }
    };
    two.addActionListener(twoListener);

    pack();

  }

  public void setDifficulty(String difficulty) {
    this.difficulty = difficulty;
  }

  public void setNoPlayers(int playerNo) {
    this.playerNum = playerNo;
  }

  /**
   * Sets up the configuration of the maze.
   */
  public ArrayList<Integer> mazeInfo() {
    if (this.difficulty.equals("Easy")) {
      info.add(this.playerNum);
      info.add(6); //Rows
      info.add(6); //Columns
      info.add(4); //Walls
      info.add(1); //Maze
      info.add(2); //Pits
      info.add(2); //Bats
      info.add(12); //Arrows
      info.add(1);  //Difficulty
    }
    if (this.difficulty.equals("Medium")) {
      info.add(this.playerNum);
      info.add(7);
      info.add(7);
      info.add(6);
      info.add(1);
      info.add(6);
      info.add(5);
      info.add(10);
      info.add(2);
    }
    if (this.difficulty.equals("Hard")) {
      info.add(this.playerNum);
      info.add(8);
      info.add(8);
      info.add(10);
      info.add(1);
      info.add(10);
      info.add(8);
      info.add(10);
      info.add(3);
    }

    return this.info;
  }

  @Override
  public void setFeatures(Features f) {
    this.start.addActionListener(l -> f.startGame(mazeInfo(), false, false));
    this.goBack.addActionListener(l -> f.backToIntro());
  }

  @Override
  public void display() {
    JLabel image = new JLabel(
        new ImageIcon("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/HTWgif2.gif"));
    gbc.gridx = 0;
    gbc.gridy = 0;
    this.panel.add(image, gbc);
    this.gbc.fill = GridBagConstraints.HORIZONTAL;
    
    JLabel image2 = new JLabel(
        new ImageIcon("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/boo2.gif"));
    gbc.gridx = 0;
    gbc.gridy = 3;
    this.panel.add(image2, gbc);
    this.gbc.fill = GridBagConstraints.HORIZONTAL;

    JLabel display = new JLabel("Set Game Difficulty");
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

    JLabel players = new JLabel("Set number of players");
    gbc.gridx = 3;
    gbc.gridy = 4;
    this.panel.add(players, gbc);
    gbc.gridx = 2;
    gbc.gridy = 5;
    this.panel.add(one, gbc);
    gbc.gridx = 3;
    gbc.gridy = 5;
    this.panel.add(two, gbc);

    gbc.gridx = 3;
    gbc.gridy = 8;
    this.panel.add(start, gbc);
    gbc.gridx = 4;
    gbc.gridy = 8;
    this.panel.add(goBack, gbc);

    this.panel.setBackground(Color.ORANGE);
    this.panel.setOpaque(true);
    this.panel.setVisible(true);
    this.add(panel);
    this.setSize(1100, 300);
    this.setVisible(true);

  }

  /**
   * Returns game configuration.
   */
  public ArrayList<Integer> getGameConfig() {
    return null;
  }

  @Override
  public void close() {
    this.dispose();

  }

}