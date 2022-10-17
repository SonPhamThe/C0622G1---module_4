package mail_box.service;

import mail_box.model.MailBox;

import java.util.List;

public interface IServiceMailBox {
    boolean updateMailBox(MailBox mailBox);
    List<String> languageList();
    List<String> sizeList();
}
