import java.awt.*;
import javax.swing.*;

public class ejercicio4 extends JFrame {
    private JScrollBar scrollBarGorria;
    private JScrollBar scrollBarUrdina; 
    private JScrollBar scrollBarBerdea;

    public static void main(String[] args) {
       ejercicio4 ventana = new ejercicio4();
       ventana.setVisible(true);
    }

    public ejercicio4() {
       setTitle("Kolore-nahasgailua");
       setSize(300, 400);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

       JPanel gorria = new JPanel();
       gorria.setLayout(new FlowLayout(FlowLayout.LEFT));
       gorria.setPreferredSize(new Dimension(300, 30));
       gorria.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
       add(gorria);

       JPanel urdina = new JPanel();
       urdina.setLayout(new FlowLayout(FlowLayout.LEFT));
       urdina.setPreferredSize(new Dimension(300, 30));
       urdina.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
       add(urdina);

       JPanel berde = new JPanel();
       berde.setLayout(new FlowLayout(FlowLayout.LEFT));
       berde.setPreferredSize(new Dimension(300, 30));
       berde.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
       add(berde);

       JPanel mezcla = new JPanel();
       mezcla.setPreferredSize(new Dimension(180, 180));
       mezcla.setMaximumSize(new Dimension(180, 180));
       mezcla.setBackground(Color.BLACK);
       add(mezcla);

       gorria.add(new JLabel("Gorria: "));
       scrollBarGorria = new JScrollBar(JScrollBar.HORIZONTAL, 0, 0, 0, 255);
       scrollBarGorria.setPreferredSize(new Dimension(150, 20));
       JTextField txtGorria = new JTextField(3);
       scrollBarGorria.addAdjustmentListener(e -> {
           txtGorria.setText(String.valueOf(scrollBarGorria.getValue()));
           actualizarColor(mezcla, scrollBarGorria.getValue(), scrollBarUrdina.getValue(), scrollBarBerdea.getValue());
       });
       gorria.add(scrollBarGorria);
       gorria.add(txtGorria);

       urdina.add(new JLabel("Urdina: "));
       scrollBarUrdina = new JScrollBar(JScrollBar.HORIZONTAL, 0, 0, 0, 255);
       scrollBarUrdina.setPreferredSize(new Dimension(150, 20));
       JTextField txtUrdina = new JTextField(3);
       scrollBarUrdina.addAdjustmentListener(e -> {
           txtUrdina.setText(String.valueOf(scrollBarUrdina.getValue()));
           actualizarColor(mezcla, scrollBarGorria.getValue(), scrollBarUrdina.getValue(), scrollBarBerdea.getValue());
       });
       urdina.add(scrollBarUrdina);
       urdina.add(txtUrdina);

       berde.add(new JLabel("Berdea: "));
       scrollBarBerdea = new JScrollBar(JScrollBar.HORIZONTAL, 0, 0, 0, 255);
       scrollBarBerdea.setPreferredSize(new Dimension(150, 20));
       JTextField txtBerdea = new JTextField(3);
       scrollBarBerdea.addAdjustmentListener(e -> {
           txtBerdea.setText(String.valueOf(scrollBarBerdea.getValue()));
           actualizarColor(mezcla, scrollBarGorria.getValue(), scrollBarUrdina.getValue(), scrollBarBerdea.getValue());
       });
       berde.add(scrollBarBerdea);
       berde.add(txtBerdea);
    }

    private void actualizarColor(JPanel panel, int r, int g, int b) {
        panel.setBackground(new Color(r, g, b));
        panel.repaint();
    }
}