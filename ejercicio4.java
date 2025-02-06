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


/* public class Photographer {
    private int PhotographerId;
    private String name;
    private Boolean Awarded;

    public Photographer(int photographerId, String name, Boolean awarded) {
        PhotographerId = photographerId;
        this.name = name;
        Awarded = awarded;
    }

    public int getPhotographerId() {
        return PhotographerId;
    }

    public Boolean getAwarded() {
        return Awarded;
    }

    @Override
    public String toString() {
        return name ;
    }
}



import java.sql.Date;

public class Picture {
    private int pictureId;
    private String title;
    private Date date;
    private String file;
    private int visits;
    private Photographer photographer;

    public Picture(int pictureId, String title, Date date, String file, int visits, Photographer photographer) {
        this.pictureId = pictureId;
        this.title = title;
        this.date = date;
        this.file = file;
        this.visits = visits;
        this.photographer = photographer;
    }

    public int getPictureId() {
        return pictureId;
    }

    public String getTitle() {
        return title;
    }

    public String getFile() {
        return file;
    }

    public Photographer getPhotographer() {
        return photographer;
    }

    public int getVisits() {
        return visits;
    }

    @Override
    public String toString() {
        return title;
    }
}






import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PicturesManager {
    // JDBC driver name and database
    static final String SERVER_IP = "localhost";
    static final String DB_NAME = "photography";
    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    static final String DB_URL = "jdbc:mariadb://" + SERVER_IP + ":3308/" + DB_NAME;

    // Database credentials
    static final String USER = "root";
    static final String PASS = "root";
    private Connection conn;
    public PicturesManager(){
        try{
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected.");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void close() {
        try {
            conn.close();
            System.out.println("Disconnected form db.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Photographer[] photographers(){
        Photographer[] photographerArray;
        PreparedStatement select;
        try{
            select = conn.prepareStatement("SELECT * FROM Photographers;");
            ResultSet rs = select.executeQuery();

            // It moves to the last row, get the number of rows in the ResultSet
            // and comes back to the before first position.
            rs.last();
            int photographersLength = rs.getRow();
            rs.beforeFirst();

            photographerArray = new Photographer[photographersLength];
            int i = 0;

            while (rs.next()){
                int photographerId = rs.getInt("PhotographerId");
                String name = rs.getString("Name");
                Boolean awarded = rs.getBoolean("Awarded");

                Photographer photographer = new Photographer(photographerId, name, awarded);

                photographerArray[i] = photographer;
                i++;
            }
            select.close();
            rs.close();
            return photographerArray;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public List<Picture> pictures(Photographer photographer, Date date){
        List<Picture> pictures = new ArrayList<>();
        PreparedStatement select;
        try {
            if (date != null) {
                select = conn.prepareStatement("SELECT * FROM pictures WHERE Photographer = ? AND DatePicture >= ?;");
                select.setInt(1, photographer.getPhotographerId());
                select.setDate(2, date);
            }else {
                select = conn.prepareStatement("SELECT * FROM pictures WHERE Photographer = ?;");
                select.setInt(1, photographer.getPhotographerId());
            }
                ResultSet rs = select.executeQuery();

            while (rs.next()) {
                int pictureId = rs.getInt("PictureId");
                String title = rs.getString("Title");
                Date datePicture = rs.getDate("DatePicture");
                String file = rs.getString("File");
                int visits = rs.getInt("Visits");

                Picture picture = new Picture(pictureId, title, date, file, visits, photographer);
                pictures.add(picture);
            }
            select.close();
            rs.close();

            return pictures;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void incrementVisits(Picture picture){
        PreparedStatement update;
        try{
            update = conn.prepareStatement("UPDATE Pictures SET Visits = Visits + 1 WHERE PictureId = ?;");
            update.setInt(1, picture.getPictureId());
            update.executeUpdate();
            update.close();
        }catch (SQLException e){
            System.err.println("ERROR UPDATING");
            e.printStackTrace();
        }
    }

    public HashMap<Integer, Integer> createVisitsMap(){
        List<Picture> pictures = new ArrayList<>();
        PreparedStatement select;
        HashMap<Integer, Integer> visitsMap = new HashMap<>();
        try {
            select = conn.prepareStatement("SELECT Photographer, Visits FROM pictures;");
            ResultSet rs = select.executeQuery();

            int lastVisits = 0;
            while (rs.next()) {
                int photographerId = rs.getInt("Photographer");
                int visits = rs.getInt("Visits");

                if (visitsMap.containsKey(photographerId)){
                    visits+=lastVisits;
                }
                visitsMap.put(photographerId,visits);
                lastVisits= visits;
            }
            select.close();
            rs.close();

            return visitsMap;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }


    public void awardPhotographers(int minVisits){
        PreparedStatement update;
        Photographer[] photographers = photographers();
        // I know it is a lambda function. I haven't used chatGPT, I promise.
        createVisitsMap().forEach((photographerID, visits) ->
        {
            if (visits>=minVisits) {
                awardPhotographerDB(photographerID);
            }
        });
        
    }

    public void awardPhotographerDB(int photographerID){
        PreparedStatement update;
        try{
            update = conn.prepareStatement("UPDATE photographers SET Awarded = true WHERE PhotographerId = ?;");
            update.setInt(1, photographerID);
            update.executeUpdate();
            update.close();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Something went wrong trying to update the photographer with id " + photographerID, "Alert", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    public void deletePictures(Picture picture){
        PreparedStatement ps;
        try{
            ps = conn.prepareStatement("DELETE FROM pictures WHERE PictureID = ?");
            ps.setInt(1, picture.getPictureId());
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public List<Picture> noVisitsNoAwardedPictures(){
        List<Picture> noVisitsNoAwardedPictures = new ArrayList<>();
        for (Picture picture :allPictures()){
            //  pictures that have never been displayed AND correspond to nonawarded photographers
            if (!picture.getPhotographer().getAwarded() && picture.getVisits() == 0) {
                noVisitsNoAwardedPictures.add(picture);
            }
        }
        return noVisitsNoAwardedPictures;

    }

    public List<Picture> allPictures(){
        List<Picture> pictures = new ArrayList<>();
        PreparedStatement select;
        PreparedStatement selectPhotographer;
        try {
            select = conn.prepareStatement("SELECT * FROM pictures;");
            ResultSet rs = select.executeQuery();

            while (rs.next()) {
                int pictureId = rs.getInt("PictureId");
                String title = rs.getString("Title");
                Date datePicture = rs.getDate("DatePicture");
                String file = rs.getString("File");
                int visits = rs.getInt("Visits");
                int photographerId = rs.getInt("Photographer");


                Picture picture = new Picture(pictureId, title, datePicture, file, visits, getPhotographerDB(photographerId));
                pictures.add(picture);
            }
            select.close();
            rs.close();

            return pictures;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public Photographer getPhotographerDB(int photographerId){
        PreparedStatement ps;
        try{
            ps = conn.prepareStatement("SELECT * FROM photographers WHERE PhotographerId = ?;");
            ps.setInt(1, photographerId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                String name = rs.getString("Name");
                Boolean awarded = rs.getBoolean("Awarded");

                return new Photographer(photographerId, name, awarded);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {
        PicturesManager pc = new PicturesManager();
        HashMap<Integer,Integer> hashMap = pc.createVisitsMap();
        hashMap.forEach(
                (k,v) -> System.out.println("ID:" + k + " Visits: " + v)
        );
    }
}






import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.util.List;


import org.jdesktop.swingx.JXDatePicker;


public class PictureViewer extends JFrame implements ActionListener {
    PicturesManager picturesManager = new PicturesManager();
    JComboBox<Photographer> photographerJComboBox;
    JXDatePicker datePicker;
    DefaultListModel<Object> model = new DefaultListModel<>();
    JList<Object> pictureList;
    JLabel photoLabel;
    JPanel area1;
    JPanel area2;
    JPanel area3;
    JPanel area4;
    JPanel areaButtonAward;
    JPanel areaButtonRemove;
    public PictureViewer(){

        // initialize
        this.setVisible(true);
        this.setLayout(new GridLayout(3,2));
        this.setPreferredSize(new Dimension(800,400));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //
        createButtonAwardArea();

        //
        createButtonRemoveArea();

        // Area 1
        createArea1();

        // Area 2
        createArea2();

        // Area 3
        createArea3();

        // Area 4
        createArea4();

        // Close database and application
        finish();
    }
    public void createButtonAwardArea(){
        areaButtonAward = new JPanel();
        areaButtonAward.setLayout(new BorderLayout());
        JButton awardButton = new JButton("AWARD");
        awardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == awardButton){
                    try {
                        int minVisits = Integer.parseInt(JOptionPane.showInputDialog("Minimum no of visist for getting a prize:"));
                        picturesManager.awardPhotographers(minVisits);
                    }catch(NumberFormatException exception){
                        JOptionPane.showMessageDialog(null, "Wrong input, try again.", "Alert", JOptionPane.ERROR_MESSAGE);
                        exception.printStackTrace();
                    }
                }
            }
        });
        areaButtonAward.add(awardButton, BorderLayout.CENTER);
        this.add(areaButtonAward);
    }
    public void createButtonRemoveArea(){
        areaButtonRemove = new JPanel();
        areaButtonRemove.setLayout(new BorderLayout());
        JButton removeButton = new JButton("REMOVE");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == removeButton){
                    for(Picture picture : picturesManager.noVisitsNoAwardedPictures()){
                        int option = JOptionPane.showConfirmDialog(null, "Do you want to delete the picture " + picture.getTitle(), "Delete Pictures" , JOptionPane.YES_NO_OPTION);
                        if (option < 1){
                            picturesManager.deletePictures(picture);
                            JOptionPane.showMessageDialog(null, "Picture" + picture.getTitle() +" deleted!");
                        }
                    }
                }
            }
        });
        areaButtonRemove.add(removeButton, BorderLayout.CENTER);
        this.add(areaButtonRemove);
    }
    public void createArea1(){
        area1 = new JPanel();
        JLabel photographerLabel = new JLabel("Photographer: ");
        Photographer[] photographers = picturesManager.photographers();
        photographerJComboBox = new JComboBox<>(photographers);
        photographerJComboBox.setSelectedItem(null);
        photographerJComboBox.addActionListener(this);
        photographerJComboBox.setPreferredSize(new Dimension(250,30));

        area1.add(photographerLabel);
        area1.add(photographerJComboBox);

        this.add(area1);
    }
    public void createArea2(){
        area2 = new JPanel();
        JLabel dateLabel = new JLabel("Photos after ");
        datePicker = new JXDatePicker();
        datePicker.addActionListener(this);
        datePicker.setPreferredSize(new Dimension(150,30));
        area2.add(dateLabel);
        area2.add(datePicker);

        this.add(area2);
    }
    public void createArea3(){
        area3 = new JPanel();

        pictureList = new JList<>();
        pictureList.setModel(model);
        pictureList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2){
                    changeImage();
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(pictureList, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(220,100));
        area3.add(scrollPane);

        this.add(area3);
    }

    public void changeImage(){
        Picture selectedPicture = (Picture) pictureList.getSelectedValue();
        ImageIcon imageIcon = new ImageIcon(selectedPicture.getFile());
        Image image = imageIcon.getImage().getScaledInstance(200,80,Image.SCALE_SMOOTH);
        photoLabel.setIcon(new ImageIcon(image));
        picturesManager.incrementVisits(selectedPicture);
    }

    public void createArea4(){
        area4 = new JPanel();
        area4.setLayout(new FlowLayout());
        photoLabel = new JLabel();
        area4.add(photoLabel);

        this.add(area4);
    }
    public void finish(){
        this.pack();
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                picturesManager.close();
            }
        });
    }

    public static void main(String[] args) {
        PictureViewer pictureViewer = new PictureViewer();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == photographerJComboBox || e.getSource() == datePicker) {
            model.clear();
            Photographer photographer = (Photographer) photographerJComboBox.getSelectedItem();
            Date dateUtil = datePicker.getDate();
            List<Picture> picturesList;
            if (dateUtil == null){
                // All the pictures
                picturesList = picturesManager.pictures(photographer, null);
            }else {
                // Casting from util.Date to sql.Date
                java.sql.Date dateSQL = new java.sql.Date(dateUtil.getTime());
                // Only pictures since selected date
                picturesList = picturesManager.pictures(photographer, dateSQL);
            }
            model.addAll(picturesList);
        }
    }
}


*/