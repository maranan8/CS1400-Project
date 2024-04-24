import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI {
    private int numOfBW = 0;
    private int numOfAP = 0;
    private int numOfMC = 0;
    private int discount = 0;

    private JButton bwButton = new JButton("Bathwater: 0");
    private JButton apButton = new JButton("Airpods: 0");
    private JButton mcButton = new JButton("Minecraft: Java Edition: 0");
    private JButton checkOut = new JButton("Checkout");

    private JLabel label = new JLabel("Click on the items you want!");
    private JLabel codeText = new JLabel("Coupon Code:");

    private JTextField code = new JTextField(1);

    private JFrame frame = new JFrame();

    public GUI() {
        bwButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numOfBW++;
                bwButton.setText("Bathwater: x" + numOfBW);
            }
        });

        apButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numOfAP++;
                apButton.setText("Airpods: x" + numOfAP);
            }
        });

        mcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numOfMC++;
                mcButton.setText("Minecraft: Java Edition: x" + numOfMC);
            }
        });

        JPanel panel = new JPanel();

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));

        panel.add(label);
        panel.add(bwButton);
        panel.add(apButton);
        panel.add(mcButton);
        panel.add(codeText);
        panel.add(code);
        panel.add(checkOut);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Market");
        frame.pack();
        frame.setSize(400,300);
        frame.setVisible(true);

        checkOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String codeInput = code.getText();
                if (codeInput.equals("SAVE"))
                    discount = 5;
                String youSaved = " ";
                if (discount > 0)
                    youSaved += "(You saved $" + discount + ")";

                panel.removeAll();
                panel.updateUI();

                JLabel bwLabel = new JLabel(numOfBW + "x Bathwater");
                JLabel apLabel = new JLabel(numOfAP + "x Airpods");
                JLabel mcLabel = new JLabel(numOfMC + "x Minecraft: Java Edition");
                JLabel empty = new JLabel("Cart is Empty");
                JLabel total = new JLabel("Total: $" + ((numOfBW * 5) + (numOfAP * 250) + (numOfMC * 30) - discount) + youSaved + "\uD83D\uDE33");

                if (numOfBW > 0)
                    panel.add(bwLabel);
                if (numOfAP > 0)
                    panel.add(apLabel);
                if (numOfMC > 0)
                    panel.add(mcLabel);
                if (numOfMC == 0 && numOfAP == 0 && numOfBW == 0)
                    panel.add(empty);
                panel.add(total);
            }
        });
    }
    public static void main(String[] args) {
        new GUI();
    }
}
