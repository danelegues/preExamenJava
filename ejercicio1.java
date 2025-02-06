import java.awt.Color;

import javax.swing.*;

public class ejercicio1 extends JFrame{

    public static void main(String[] args) {
        ejercicio1 ventana = new ejercicio1();
        ventana.ejercicio1();
    }
    public void ejercicio1() {
      setTitle("Nire lehen interfazea");
      setSize(400, 400);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLayout(null);

      JLabel adinaJLabel = new JLabel("Adina: ");
      adinaJLabel.setBounds(10, 10, 80, 25);
      add(adinaJLabel);

      JLabel izenaLabel = new JLabel("Izena: ");
      izenaLabel.setBounds(150, 10, 80, 25);
      add(izenaLabel);

      JComboBox<String> adinaJComboBox = new JComboBox<>();

      for (int i = 0; i < 120; i++) {
        adinaJComboBox.addItem(String.valueOf(i));
      }
      adinaJComboBox.setSelectedIndex(1);

      adinaJComboBox.setBounds(10, 45, 80, 25);
      add(adinaJComboBox);

      JTextField izenaJTextField = new JTextField();
      izenaJTextField.setBounds(150, 45, 80, 25);
      add(izenaJTextField);

      JPanel panel = new JPanel();
      panel.setBounds(10, 115, 200, 180);
      panel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
      panel.setLayout(null);
      add(panel);

      JLabel sexuaJLabel = new JLabel("Sexua: ");
      sexuaJLabel.setBounds(10, 10, 80, 25);
      panel.add(sexuaJLabel);

      ButtonGroup buttonGroup = new ButtonGroup();
      JRadioButton gizona = new JRadioButton("Gizona");
      JRadioButton emakumea = new JRadioButton("Emakumea");
      JRadioButton Zehaztugabea = new JRadioButton("Zehaztugabea");

      buttonGroup.add(gizona);
      buttonGroup.add(emakumea);
      buttonGroup.add(Zehaztugabea);

      gizona.setBounds(10, 35, 100, 25);
      emakumea.setBounds(10, 60, 100, 25);
      Zehaztugabea.setBounds(10, 85, 120, 25);

      panel.add(gizona);
      panel.add(emakumea);
      panel.add(Zehaztugabea);

      JButton gorde = new JButton("Gorde");
      gorde.setBounds(10, 270, 80, 25);
      add(gorde);

      setVisible(true);
    }
}
