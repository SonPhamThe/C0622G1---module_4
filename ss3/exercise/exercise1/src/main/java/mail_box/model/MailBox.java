package mail_box.model;

public class MailBox {
    private int id;
    private String language;
    private Integer size;
    private String spamFilter;
    private String signature;

    public MailBox() {
    }

    public MailBox(int id, String language, Integer size, String spamFilter, String signature) {
        this.id = id;
        this.language = language;
        this.size = size;
        this.spamFilter = spamFilter;
        this.signature = signature;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getSpamFilter() {
        return spamFilter;
    }

    public void setSpamFilter(String spamFilter) {
        this.spamFilter = spamFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
