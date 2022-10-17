package mail_box.repository.impl;

import mail_box.model.MailBox;
import mail_box.repository.IRepoMailBox;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepoMailBox implements IRepoMailBox {
    @Override
    public boolean updateMailBox(MailBox mailBox) {
        return false;
    }

    @Override
    public List<String> languageList() {
        List<String> languageList = new ArrayList<>();
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Japanese");
        languageList.add("Chinese");
        return languageList;
    }

    @Override
    public List<String> sizeList() {
        List<String> sizeList = new ArrayList<>();
        sizeList.add("5");
        sizeList.add("10");
        sizeList.add("15");
        sizeList.add("25");
        sizeList.add("50");
        sizeList.add("100");
        return sizeList;
    }
}
