package mail_box.service.impl;

import mail_box.model.MailBox;
import mail_box.repository.IRepoMailBox;
import mail_box.service.IServiceMailBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceMailBox implements IServiceMailBox {
    @Autowired
    private IRepoMailBox repoMailBox;

    @Override
    public boolean updateMailBox(MailBox mailBox) {
        return repoMailBox.updateMailBox(mailBox);
    }

    @Override
    public List<String> languageList() {
        return repoMailBox.languageList();
    }

    @Override
    public List<String> sizeList() {
        return repoMailBox.sizeList();
    }
}
