package mail_box.repository;

import mail_box.model.MailBox;

import java.util.List;

public interface IRepoMailBox {
    boolean updateMailBox(MailBox mailBox);
    List<String> languageList();
    List<String> sizeList();
}
