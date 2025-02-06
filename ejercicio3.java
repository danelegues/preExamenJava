import java.awt.*;
import javax.swing.*;

public class ejercicio3 extends JFrame{
    public static void main(String[] args) {
        ejercicio3 ventana = new ejercicio3();
        ventana.setVisible(true);
    }

    public ejercicio3(){
       setTitle("Nire hirugarren interfazea");
       setSize(600, 300);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setLayout(new GridLayout(1,3));

       JPanel panel1 = new JPanel();
       panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
       JPanel panel2 = new JPanel();
       panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
       JPanel panel3 = new JPanel();
       panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));

       add(panel1);
       panel1.setSize(200, 300);
       add(panel2);
       panel2.setSize(200, 300);
       add(panel3); 
       panel3.setSize(200, 300);

       JLabel izenaLabel = new JLabel("Sartu izena: ");
       izenaLabel.setPreferredSize(new Dimension(200, 30));
       panel1.add(izenaLabel);
       
       JTextField izenaField = new JTextField();
       izenaField.setPreferredSize(new Dimension(150, 30));
       panel1.add(izenaField);
       
       JLabel ordainketaLabel = new JLabel("Aukeratu ordainketa mota: ");
       ordainketaLabel.setPreferredSize(new Dimension(200, 30));
       panel1.add(ordainketaLabel);

       String[] ordainketaMota = {"Dirua", "Txartela", "Bizum"};
       JComboBox<String> ordainketaCombo = new JComboBox<>(ordainketaMota);
       ordainketaCombo.setPreferredSize(new Dimension(150, 30));
       panel1.add(ordainketaCombo);
       
       ImageIcon pizzaIcon = new ImageIcon("pizza.jpg");
       JLabel pizzaLabel = new JLabel(pizzaIcon);
       pizzaLabel.setPreferredSize(new Dimension(200, 30));
       panel1.add(pizzaLabel);
       
       JButton eskaeraButton = new JButton("Eskaera egin ");
       eskaeraButton.setPreferredSize(new Dimension(150, 30));
       panel1.add(eskaeraButton);

       JLabel masaLabel = new JLabel("Aukeratu masa mota:");
       masaLabel.setPreferredSize(new Dimension(200, 30));
       panel2.add(masaLabel);
       panel2.add(Box.createRigidArea(new Dimension(0, 10)));
       
       JRadioButton originalRadio = new JRadioButton("Originala");
       originalRadio.setPreferredSize(new Dimension(150, 30));
       panel2.add(originalRadio);
       panel2.add(Box.createRigidArea(new Dimension(0, 10)));
       
       JRadioButton finaRadio = new JRadioButton("Fina");
       finaRadio.setPreferredSize(new Dimension(150, 30));
       panel2.add(finaRadio);
       panel2.add(Box.createRigidArea(new Dimension(0, 10)));
       
       JRadioButton baserrikoaRadio = new JRadioButton("Baserrikoa");
       baserrikoaRadio.setPreferredSize(new Dimension(150, 30));
       panel2.add(baserrikoaRadio);
       panel2.add(Box.createRigidArea(new Dimension(0, 10)));
       
       JRadioButton beteaRadio = new JRadioButton("Betea");
       beteaRadio.setPreferredSize(new Dimension(150, 30));
       panel2.add(beteaRadio);

       JLabel osagaiakLabel = new JLabel("Osagaiak: ");
       osagaiakLabel.setPreferredSize(new Dimension(200, 30));
       panel3.add(osagaiakLabel);
       panel3.add(Box.createRigidArea(new Dimension(0, 10)));
       
       JCheckBox gaztaCheck = new JCheckBox("Gazta extra");
       gaztaCheck.setPreferredSize(new Dimension(150, 30));
       panel3.add(gaztaCheck);
       panel3.add(Box.createRigidArea(new Dimension(0, 10)));
       
       JCheckBox urdaiazpikoCheck = new JCheckBox("Urdaiazpiko egosia");
       urdaiazpikoCheck.setPreferredSize(new Dimension(150, 30));
       panel3.add(urdaiazpikoCheck);
       panel3.add(Box.createRigidArea(new Dimension(0, 10)));
       
       JCheckBox txampinoiakCheck = new JCheckBox("Txanpinoiak");
       txampinoiakCheck.setPreferredSize(new Dimension(150, 30));
       panel3.add(txampinoiakCheck);
       panel3.add(Box.createRigidArea(new Dimension(0, 10)));
       
       JCheckBox tipulaCheck = new JCheckBox("Tipula");
       tipulaCheck.setPreferredSize(new Dimension(150, 30));
       panel3.add(tipulaCheck);
       panel3.add(Box.createRigidArea(new Dimension(0, 10)));
       
       JCheckBox oilaskoaCheck = new JCheckBox("Oilaskoa");
       oilaskoaCheck.setPreferredSize(new Dimension(150, 30));
       panel3.add(oilaskoaCheck);
       panel3.add(Box.createRigidArea(new Dimension(0, 10)));
       
       JCheckBox piperCheck = new JCheckBox("Piper gorria");
       piperCheck.setPreferredSize(new Dimension(150, 30));
       panel3.add(piperCheck);
    }
}
