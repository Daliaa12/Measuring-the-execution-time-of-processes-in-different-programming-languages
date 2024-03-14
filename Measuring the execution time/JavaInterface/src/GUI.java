import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;


public class GUI {
    private JFrame frame= new JFrame("Vizualizarea timpului de executie pentru diferite programe");
    private JButton buttonAccesMC = new JButton("Acces Memorie C");
    private JButton buttonAccesMJava = new JButton("Acces Memorie Java");
    private JButton buttonAccesMPython = new JButton("Acces Memorie Python");

    private JButton buttonAlocMemorieC = new JButton("Alocare memorie C");
    private JButton buttonAlocMemorieJava = new JButton("Alocare memorie Java");
    private JButton buttonAlocMemoriePython = new JButton("Alocare memorie Python");

    private JButton buttonCreareTC = new JButton("Creare threaduri C");
    private JButton buttonCreareTJava = new JButton("Creare threaduri Java");
    private JButton buttonCreareTPython = new JButton("Creare threaduri Python");


    public GUI()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.setLayout(new GridLayout(3, 3, 10, 10)); // 3x3 grid with gaps
        frame.getContentPane().setBackground(new Color(183, 232, 224));

        addObjects();
        createObjects2();
        createActionListener();
        frame.setVisible(true);

    }
    private void addObjects() {
        frame.add(createPanel(buttonAccesMC, buttonAlocMemorieC, buttonCreareTC));
        frame.add(createPanel(buttonAccesMJava, buttonAlocMemorieJava, buttonCreareTJava));
        frame.add(createPanel(buttonAccesMPython, buttonAlocMemoriePython, buttonCreareTPython));
    }
    private void createObjects2() {
        Font buttonFont = new Font("Arial", Font.PLAIN, 16);
        Color buttonColor = new Color(89, 217, 195);

        for (Component comp : frame.getContentPane().getComponents()) {
            if (comp instanceof JButton) {
                JButton button = (JButton) comp;
                button.setFont(buttonFont);
                button.setBackground(buttonColor);
                button.setFocusPainted(false);
            }
        }
    }
    private JPanel createPanel(JButton button1, JButton button2, JButton button3) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panel.setBackground(new Color(183, 232, 224));
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        return panel;
    }
    private void createActionListener() {
        buttonAccesMC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFile("C:\\Users\\dalia\\OneDrive\\Desktop\\SSC-project.1\\AccesMemorie_c.txt");
            }
        });

        buttonAlocMemorieC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFile("C:\\Users\\dalia\\OneDrive\\Desktop\\SSC-project.1\\AlocareMemorie_c.txt");
            }
        });
        buttonCreareTC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFile("C:\\Users\\dalia\\OneDrive\\Desktop\\SSC-project.1\\CreareThreaduri_c.txt");
            }
        });

        buttonAccesMPython.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFile("C:\\Users\\dalia\\OneDrive\\Desktop\\SSC-project.1\\AccesMemorie_Python.txt");
            }
        });
        buttonAlocMemoriePython.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFile("C:\\Users\\dalia\\OneDrive\\Desktop\\SSC-project.1\\AlocareaMemoriei_Python.txt");
            }
        });
        buttonCreareTPython.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFile("C:\\Users\\dalia\\OneDrive\\Desktop\\SSC-project.1\\CreareThreaduriPyton.txt");
            }
        });

        buttonAccesMJava.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFile("C:\\Users\\dalia\\OneDrive\\Desktop\\SSC-project.1\\AccesMemorie_Java.txt");
            }
        });
        buttonAlocMemorieJava.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFile("C:\\Users\\dalia\\OneDrive\\Desktop\\SSC-project.1\\AlocareaMemoriei_Java.txt");
            }
        });
        buttonCreareTJava.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFile("C:\\Users\\dalia\\OneDrive\\Desktop\\SSC-project.1\\CreareThreaduriJava.txt");
            }
        });

        }

    private void openFile(String filePath) {
        try {
            File file = new File(filePath);

            if (!file.exists()) {
                JOptionPane.showMessageDialog(frame, "File not found: " + filePath, "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Desktop.getDesktop().open(file);
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error opening file", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GUI());
    }





}
