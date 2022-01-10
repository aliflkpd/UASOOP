import javafx.beans.property.SimpleStringProperty;

public class Database {
    public final SimpleStringProperty Nama;
    public final SimpleStringProperty EmailAkun;
    public final SimpleStringProperty Pass;
    public final SimpleStringProperty Nick;

    public Database(String fNama, String fEmailAkun, String fPass, String fNick){
        this.Nama = new SimpleStringProperty(fNama);
        this.EmailAkun = new SimpleStringProperty(fEmailAkun);
        this.Pass = new SimpleStringProperty(fPass);
        this.Nick = new SimpleStringProperty(fNick);
    }

    public String getNama() {
        return Nama.get();
    }

    public void setNama(String Value) {
        Nama.set(Value);
    }

    public String getEmailAkun() {
        return EmailAkun.get();
    }

    public void setEmailAkun(String Value) {
        EmailAkun.set(Value);
    }

    public String getPass() {
        return Pass.get();
    }

    public void setPass(String Value) {
        Pass.set(Value);
    }

    public String getNick() {
        return Nick.get();
    }

    public void setNick(String Value) {
        Nick.set(Value);
    }

}
