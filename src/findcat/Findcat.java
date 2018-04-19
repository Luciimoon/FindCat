package findcat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

/**
 * @author compsci
 */
public class Findcat extends JFrame {

    /**
     * @param args the command line arguments
     */
    JLabel label0 = new JLabel();
    JLabel label1 = new JLabel();
    JLabel label2 = new JLabel();

    JLabel label3 = new JLabel();
    JLabel label4 = new JLabel();
    JLabel label5 = new JLabel();

    JLabel label6 = new JLabel();
    JLabel label7 = new JLabel();
    JLabel label8 = new JLabel();

    JLabel label9 = new JLabel();
    JLabel label10 = new JLabel();
    JLabel label11 = new JLabel();

    JLabel label12 = new JLabel();
    JLabel label13 = new JLabel();
    JLabel label14 = new JLabel();

    JLabel label15 = new JLabel();
    JLabel label16 = new JLabel();
    JLabel label17 = new JLabel();

    JLabel label18 = new JLabel();
    JLabel label19 = new JLabel();
    JLabel label20 = new JLabel();

    JLabel label21 = new JLabel();
    JLabel label22 = new JLabel();
    JLabel label23 = new JLabel();

    JLabel label24 = new JLabel();
    JLabel label25 = new JLabel();
    JLabel label26 = new JLabel();

    JLabel label27 = new JLabel();
    JLabel label28 = new JLabel();
    JLabel label29 = new JLabel();

    JLabel label30 = new JLabel();
    JLabel label31 = new JLabel();

    JLabel count = new JLabel();

    JLabel[][] choiceLabel = new JLabel[6][6];
    ImageIcon cat = new ImageIcon(getClass().getResource("Catt.jpg"));
    JButton newButton = new JButton();
    int catLocationCol, catLocationRow, l, Counter = 0;

    Random myRandom = new Random();

    String msg = "What are your dimensions?";
    String dim = (JOptionPane.showInputDialog(null, msg));
    int coll = Character.getNumericValue(dim.charAt(0));
    int roww = Character.getNumericValue(dim.charAt(2));

    public Findcat() {

        //frame constructor
        setTitle("Find the Cat");
        setResizable(false);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                exitForm(e);
            }
        });
        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints gridConstraints;

        choiceLabel[0][0] = label0;
        choiceLabel[1][0] = label1;
        choiceLabel[2][0] = label2;
        choiceLabel[3][0] = label3;
        choiceLabel[4][0] = label4;

        choiceLabel[0][1] = label5;
        choiceLabel[1][1] = label6;
        choiceLabel[2][1] = label7;
        choiceLabel[3][1] = label8;
        choiceLabel[4][1] = label9;

        choiceLabel[0][2] = label10;
        choiceLabel[1][2] = label11;
        choiceLabel[2][2] = label12;
        choiceLabel[3][2] = label13;
        choiceLabel[4][2] = label14;

        choiceLabel[0][3] = label15;
        choiceLabel[1][3] = label16;
        choiceLabel[2][3] = label17;
        choiceLabel[3][3] = label18;
        choiceLabel[4][3] = label19;

        choiceLabel[0][4] = label20;
        choiceLabel[1][4] = label21;
        choiceLabel[2][4] = label22;
        choiceLabel[3][4] = label23;
        choiceLabel[4][4] = label24;

        choiceLabel[0][5] = label25;
        choiceLabel[1][5] = label26;
        choiceLabel[2][5] = label27;
        choiceLabel[3][5] = label28;
        choiceLabel[4][5] = label29;

        for (int i = 0; i < coll; i++) {

            for (int j = 0; j < roww; j++) {
                gridConstraints = new GridBagConstraints();
                choiceLabel[i][j].setPreferredSize(new Dimension(cat.getIconWidth(), cat.getIconHeight()));
                choiceLabel[i][j].setOpaque(true);
                choiceLabel[i][j].setBackground(Color.MAGENTA);
                gridConstraints.gridx = i;
                gridConstraints.gridy = j;
                gridConstraints.insets = new Insets(10, 10, 10, 10);
                getContentPane().add(choiceLabel[i][j], gridConstraints);
                choiceLabel[i][j].addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        labelMouseClicked(e);
                    }
                });
                l += 1;
            }
        }

        newButton.setText("Play Again");
        gridConstraints = new GridBagConstraints();

        count.setText("Number of Clicks = " + Counter);
        gridConstraints.gridx = roww / 2 - 1;
        gridConstraints.gridy = coll + 1;
        gridConstraints.insets = new Insets(10, 10, 10, 10);
        getContentPane().add(count, gridConstraints);

        gridConstraints.gridx = roww / 2;
        gridConstraints.gridy = coll + 1;
        gridConstraints.insets = new Insets(10, 10, 10, 10);
        getContentPane().add(newButton, gridConstraints);
        newButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newButtonActionPerformed(e);
            }

        });

        pack();
        //setSize(500,500);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((int) (.5 * (screenSize.width - getWidth())), (int) (.5 * (screenSize.height - getHeight())), getWidth(), getHeight());

    }

    public static void main(String[] args) {
        // create frame
        new Findcat().setVisible(true);
    }

    private void exitForm(WindowEvent e) {
        System.exit(0);
    }

    private void labelMouseClicked(MouseEvent e) {
        Component clickedComponent = e.getComponent();
        int row, col;
        for (row = 0; row < coll; row++) {
            for (col = 0; col < roww; col++) {
                if (clickedComponent == choiceLabel[row][col]) {
                    choiceLabel[row][col].setBackground(Color.CYAN);
                    Counter++;
                    count.setText("Number of Clicks = " + Counter);
                    break;
                }
            }

            if (col == catLocationCol && row == catLocationRow) {
                choiceLabel[row][col].setIcon(cat);
                count.setText("You won in " + Counter + " Clicks!");
                newButton.setEnabled(true);
            }
        }
    }

    private void newButtonActionPerformed(ActionEvent e) {
        for (int i = 0; i < coll; i++) {
            for (int k = 0; k < roww; k++) {

                choiceLabel[i][k].setIcon(null);
                choiceLabel[i][k].setBackground(Color.MAGENTA);
            }
        }
        Counter = 0;
        count.setText("Number of Clicks = " + Counter);
        catLocationCol = myRandom.nextInt(coll);
        catLocationRow = myRandom.nextInt(roww);
        newButton.setEnabled(false);
    }
}
