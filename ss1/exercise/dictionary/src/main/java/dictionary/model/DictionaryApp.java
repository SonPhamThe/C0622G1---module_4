package dictionary.model;

public class DictionaryApp {
    private String en;
    private String vie;

    public DictionaryApp() {
    }

    public DictionaryApp(String en, String vie) {
        this.en = en;
        this.vie = vie;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getVie() {
        return vie;
    }

    public void setVie(String vie) {
        this.vie = vie;
    }
}
