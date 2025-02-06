import java.awt.Dimension;
import javax.swing.*;

public class ejercicio2 extends JFrame{
    public static void main(String[] args) {
        ejercicio2 ventana = new ejercicio2();
        ventana.setVisible(true);
    }
    
    public ejercicio2(){
        setTitle("Nire bigarren interfazea");
        setSize(350, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JLabel zerrenda = new JLabel("Zerrenda:");
        zerrenda.setPreferredSize(new Dimension(0, 30));
        add(zerrenda);

        String[] elementos = new String[100];
        for(int i = 0; i < elementos.length; i++) {
            elementos[i] = "Elementua " + (i+1);
        }

        JList<String> lista = new JList<>(elementos);
        lista.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        int[] selectedIndices = {1, 3, 5, 7}; 
        lista.setSelectedIndices(selectedIndices);
        
        JScrollPane scrollPane = new JScrollPane(lista);
        add(scrollPane);

        JLabel testua = new JLabel("Testua:");
        testua.setPreferredSize(new Dimension(0, 30));
        add(testua);

        JTextArea testuaArea = new JTextArea(10, 30);
        JScrollPane textScrollPane = new JScrollPane(testuaArea);
        textScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        textScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(textScrollPane);
    }
}
