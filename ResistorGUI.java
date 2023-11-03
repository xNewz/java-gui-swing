import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class ResistorGUI {
    private Resistor resistor;

    private JFrame frame;
    private JButton generateButton;
    private JLabel colorLabel;
    private JLabel resistanceLabel;
    private JLabel toleranceLabel;

    public ResistorGUI() {
        resistor = new Resistor();
        frame = new JFrame("Resistor Color Code");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(null);

        generateButton = new JButton("Generate Color Code");
        generateButton.setBounds(150, 20, 200, 30);
        frame.add(generateButton);

        colorLabel = new JLabel("Resistor Colors:");
        colorLabel.setBounds(20, 60, 300, 30);
        frame.add(colorLabel);

        resistanceLabel = new JLabel("Resistance:");
        resistanceLabel.setBounds(20, 90, 200, 30);
        frame.add(resistanceLabel);

        toleranceLabel = new JLabel("Tolerance:");
        toleranceLabel.setBounds(20, 120, 200, 30);
        frame.add(toleranceLabel);

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] colors = resistor.randomColor();
                double resistance = resistor.calculateResistance(colors);
                String tolerance = resistor.calculateTolerance(colors);

                colorLabel.setText("Resistor Colors: " + Arrays.toString(colors));
                resistanceLabel.setText("Resistance: " + resistor.formatResistance(resistance) + " ohms");
                toleranceLabel.setText("Tolerance: " + resistor.formatTolerance(tolerance));
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ResistorGUI();
            }
        });
    }
}
