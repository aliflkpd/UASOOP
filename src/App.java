import static javafx.scene.control.TableView.CONSTRAINED_RESIZE_POLICY;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
 
 

public class App extends Application {
    TableView<Database> tableView = new TableView<Database>();
    public TableView tblView;
    private Text txtInfo;
    private Label lblTitle,lblData,lblNama,lblEmailAkun,lblPass,lblNick,lblSearch;
    public TextField txtNama,txtEmailAkun,txtNick,txtPass,txtSearch;
    public TableColumn tblColumn1,tblColumn2,tblColumn3,tblColumn4;
    private SplitPane splitPaneH;
    private VBox panevbox,panevbox2;
    private AnchorPane pane;
    private GridPane grid;
    private HBox panehbox,searchbox;
    private Button btnAdd,btnUpdate,btnDelete,btnClear,btnClose,btnRefresh;
    Database modelDb;
    ObservableList data = FXCollections.observableArrayList();

    public void initComponent(){
        //========================================================================
          lblData    = new Label("FORM DATA");
          lblTitle   = new Label();
          lblNama     = new Label("Nama");
          lblEmailAkun    = new Label("Email Akun");
          lblPass = new Label("Password Akun");
          lblNick  = new Label("Nickname ingame");
          lblSearch    = new Label("Cari data :");
          txtInfo    = new Text("data not available");
          tblColumn1 = new TableColumn("Nama");
          tblColumn2 = new TableColumn("EmailAkun");
          tblColumn3 = new TableColumn("Pass");
          tblColumn4 = new TableColumn("Nick");
          txtNama     = new TextField();
          txtEmailAkun    = new TextField();
          txtPass = new TextField();
          txtNick  = new TextField();
          txtSearch    = new TextField();
          splitPaneH = new SplitPane();
          pane       = new AnchorPane();
          panevbox   = new VBox();
          panevbox2  = new VBox();
          grid       = new GridPane();
          panehbox   = new HBox(5);
          searchbox  = new HBox(5);
          tblView    = new TableView();
          btnAdd     = new Button("ADD");
          btnUpdate  = new Button("UPDATE");
          btnDelete  = new Button("DELETE");
          btnClear   = new Button("CLEAR");
          btnClose   = new Button("CLOSE");
          btnRefresh = new Button("REFRESH");
             //========================================================================
        tblColumn1.setCellValueFactory(new PropertyValueFactory("Nama"));
        tblColumn2.setCellValueFactory(new PropertyValueFactory("EmailAkun"));
        tblColumn3.setCellValueFactory(new PropertyValueFactory("Pass"));
        tblColumn4.setCellValueFactory(new PropertyValueFactory("Nick"));
       
        txtNama.setPromptText("Masukkan Nama");
        txtEmailAkun.setPromptText("Masukkan Email Akun");
        txtPass.setPromptText("Masukkan Password");
        txtNick.setPromptText("Masukkan Nickname");
        txtSearch.setPromptText("Masukkan data yang ingin dicari");
       
        lblSearch.setPadding(new Insets(10));
        lblSearch.setFont(Font.font("Franklin Gothic Demi", FontWeight.MEDIUM, 12));
        lblSearch.setAlignment(Pos.CENTER);
        lblSearch.setUnderline(true);
       
        lblData.setPadding(new Insets(10));
        lblData.setFont(Font.font("Franklin Gothic Demi", FontWeight.MEDIUM, 22));
        lblData.setUnderline(true);
        lblData.setAlignment(Pos.CENTER);
       
        lblTitle.setText("Database GamingJoki");
        lblTitle.setUnderline(true);
        lblTitle.setPadding(new Insets(10));
        lblTitle.setFont(Font.font("Franklin Gothic Demi", FontWeight.MEDIUM, 22));
        lblTitle.setAlignment(Pos.CENTER);
       
        lblNama.setPrefSize(100, 30);
        lblEmailAkun.setPrefSize(100, 30);
        lblPass.setPrefSize(100, 30);
        lblNick.setPrefSize(100, 30);
       
        txtNama.setPrefSize(250, 30);
        txtEmailAkun.setPrefSize(250, 30);
        txtPass.setPrefSize(250, 30);
        txtNick.setPrefSize(250, 30);
        txtSearch.setPrefSize(250, 30);
       
        tblView.setColumnResizePolicy(CONSTRAINED_RESIZE_POLICY);
        tblView.setPlaceholder(txtInfo);
        tblView.setPadding(new Insets(10));
        tblView.getColumns().addAll(tblColumn1,tblColumn2,tblColumn3,tblColumn4);
        tblView.setPrefHeight(250);
        tblView.setBackground(new Background(
                new BackgroundFill(Color.LIGHTBLUE,new CornerRadii(15),Insets.EMPTY)));
       
        panehbox.setAlignment(Pos.CENTER);
        panehbox.setPadding(new Insets(10));
        panehbox.setLayoutX(23);
        panehbox.setLayoutY(194);
        panehbox.getChildren().addAll(btnAdd,btnUpdate,btnDelete,btnClear,btnClose);
        panehbox.setBackground(new Background(new BackgroundFill(
                Color.DARKGRAY, new CornerRadii(10), Insets.EMPTY)));
       
        searchbox.setAlignment(Pos.CENTER_LEFT);
        searchbox.setPadding(new Insets(5));
        searchbox.getChildren().addAll(lblSearch,txtSearch,btnRefresh);
        searchbox.setBackground(new Background(new BackgroundFill(
                Color.DARKGRAY, new CornerRadii(10), Insets.EMPTY)));
       
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setLayoutX(5);
        grid.setLayoutY(5);
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(10));
        grid.addRow(1, lblNama,txtNama);
        grid.addRow(2, lblEmailAkun,txtEmailAkun);
        grid.addRow(3, lblPass,txtPass);
        grid.addRow(4, lblNick,txtNick);
        grid.setGridLinesVisible(false);
       
        pane.setBorder(new Border(new BorderStroke(
                Color.WHITESMOKE,BorderStrokeStyle.DASHED,
                new CornerRadii(15),new BorderWidths(5),Insets.EMPTY)));
        pane.setBackground(new Background(new BackgroundFill(
                Color.LIGHTGRAY, new CornerRadii(15),Insets.EMPTY)));
        pane.getChildren().addAll(grid,panehbox);
       
        panevbox.getChildren().addAll(lblTitle,tblView,searchbox);
        panevbox.setPadding(new  Insets(5));
        panevbox.setSpacing(5);
        panevbox.minWidthProperty().bind(splitPaneH.widthProperty().multiply(0.70));
        panevbox.maxWidthProperty().bind(splitPaneH.widthProperty().multiply(0.70));
       
        panevbox2.getChildren().addAll(lblData,pane);
        panevbox2.setPadding(new Insets(5));
        panevbox2.setSpacing(5);
       
        splitPaneH.setOrientation(Orientation.HORIZONTAL);
        splitPaneH.getItems().addAll(panevbox,panevbox2);
        splitPaneH.setPadding(new Insets(2));
        splitPaneH.setBackground(new Background(
                   new BackgroundFill(Color.GRAY,CornerRadii.EMPTY,Insets.EMPTY)));
        splitPaneH.setDividerPositions(0.5);
    }
    /**=======================================================================================
     *                       UNTUK MENAMPUNG DATA DARI DATABASE
     * =======================================================================================
     **/
   
    private ObservableList loadData(){
            ObservableList listData = FXCollections.observableArrayList();
            try {
            Connection c    = DatabaseConnector.tryConnect();
            String sql1     = "select * from dbgamingjoki;";
            ResultSet rs1   = c.createStatement().executeQuery(sql1);
            while(rs1.next()){
                modelDb         = new Database(rs1.getString(1),rs1.getString(2),
                                                    rs1.getString(3),rs1.getString(4));
                listData.add(modelDb);
            }
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
            return listData;
           
    }
   
    private ObservableList searchByNama(String n){
        ObservableList listData = FXCollections.observableArrayList();
        try {
            Connection c = DatabaseConnector.tryConnect();
            String sql2 = " select distinct * from dbgamingjoki where nama like '%"+n+"%';";
            ResultSet rs2 = c.createStatement().executeQuery(sql2);
            while(rs2.next()){
                modelDb         = new Database(rs2.getString(1),rs2.getString(2),
                                                    rs2.getString(3),rs2.getString(4));
                listData.add(modelDb);
            }
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listData;
    }
    //=======================================================================================
   
    /**======================================================================================
     *                      UNTUK MELAKUKAN INSERT, DELETE DAN UPDATE
     *              DIMANA DATA DIAMBIL DARI FORM KEMUDIAN DIKUMPULKAN DI MODEL
     * ======================================================================================
     **/
    private void insert(Database m){
        Connection c = DatabaseConnector.tryConnect();
        PreparedStatement ps;
        try {
            String sql = "insert into dbgamingjoki values (?,?,?,?);";
            ps  = c.prepareStatement(sql);
            ps.setString(1,m.getNama());
            ps.setString(2,m.getEmailAkun());
            ps.setString(3,m.getPass());
            ps.setString(4,m.getNick());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error");
        }
    }
   
    private void delete(Database m){
        try {
            Connection c = DatabaseConnector.tryConnect();
            PreparedStatement ps;
            String sql = "delete from dbgamingjoki where nama = ?;";
            ps = c.prepareStatement(sql);
            ps.setString(1, m.getNama());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
   
    private void update(Database m){
        try {
            Connection c = DatabaseConnector.tryConnect();
            PreparedStatement ps;
            String sql = "update dbgamingjoki set nickname = ? ,password = ? , email akun = ? where nama = ? ;";
            ps = c.prepareStatement(sql);
            ps.setString(1, m.getNick());
            ps.setString(2, m.getPass());
            ps.setString(3, m.getEmailAkun());
            ps.setString(4, m.getNama());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //=======================================================================================
   
    /**======================================================================================
     *                                   ACTIONEVENT  
     * ======================================================================================
     **/
    private void selectData(){
        modelDb = (Database) tblView.getSelectionModel().getSelectedItems().get(0);
        txtNama.setText(modelDb.getNama());
        txtEmailAkun.setText(modelDb.getNick());
        txtPass.setText(modelDb.getPass());
        txtNick.setText(modelDb.getNick());
        txtNama.setDisable(true);
    }
   
    private void deleteData(){
        modelDb = new Database(txtNama.getText(), "", "", "");
        delete(modelDb);
        clearData();
        showData();
    }
   
    private void updateData(){
        modelDb = new Database(txtNama.getText(),txtEmailAkun.getText(),
                                    txtPass.getText(),txtNick.getText());
        update(modelDb);
        clearData();
        showData();
    }
   
    private void searchbyNama(){
        data.clear(); // <- menghapus data pada penampung data
        data = searchByNama(txtSearch.getText().trim());
        tblView.setItems(data); // <- menaruh data pada tabel agar bisa tampil
        tblView.getSelectionModel().clearSelection(); // <- menghapus seleksi baris pada tabel
    }
   
    private void refresh(){
        showData();
        clearData();
        txtSearch.clear();
    }
   
    private void showData(){
        data.clear();
        data = loadData();
        tblView.setItems(data);
        tblView.getSelectionModel().clearSelection();
    }
   
    private void clearData(){
        txtNama.clear();
        txtEmailAkun.clear();
        txtPass.clear();
        txtNick.clear();
        txtNama.setDisable(false);
        tblView.getSelectionModel().clearSelection();
    }
   
    private void addData(){
        // mengambil data dari form, kemudian disusun seperti array
        modelDb = new Database(txtNama.getText(),txtEmailAkun.getText(),
                                    txtPass.getText(),txtNama.getText());
        insert(modelDb); //<- data dikirim ke SQL
        showData();
        clearData();
    }
  //====================================================================================    
    @Override
    public void start(Stage primaryStage) {
        initComponent(); // <- VIEW
        showData();     // <- MENAMPILKAN DATA
        tblView.setOnMousePressed((MouseEvent event) -> {
            selectData(); // <- EVENT BARIS KETIKA DIPILIH
        });
        btnAdd.setOnAction((ActionEvent e) -> {
            addData(); // <- INSERT DATA
        });
        btnClear.setOnAction((ActionEvent e) -> {
            clearData(); // <- CLEAR FIELD INPUT DATA
        });
        btnClose.setOnAction((ActionEvent e) -> {
            primaryStage.close(); // <- CLOSE SCENE WINDOW
        });
        btnUpdate.setOnAction((ActionEvent e) -> {
            updateData(); // <- UPDATE DATA
        });
        btnDelete.setOnAction((ActionEvent e) -> {
            deleteData(); // <- DELETE DATA
        });
        btnRefresh.setOnAction((ActionEvent e) -> {
            refresh(); // <- MENGEMBALIKAN TAMPILAN SEPERTI SEMULA
        });
        txtSearch.setOnKeyTyped((KeyEvent ke) -> {
            searchbyNama(); // <- SEARCH DATA BY Nama
        });
        Scene scene = new Scene(splitPaneH, 1216, 618);
        scene.setFill(null);
        primaryStage.setScene(scene);

        primaryStage.setTitle("CRUD APPLICATION WITH JAVAFX");
        // primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setFullScreen(true);
    }
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        launch(args);
       
    }
   
}
