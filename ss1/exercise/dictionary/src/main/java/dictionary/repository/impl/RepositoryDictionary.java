package dictionary.repository.impl;

import dictionary.model.DictionaryApp;
import dictionary.repository.IRepoDictionary;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositoryDictionary implements IRepoDictionary {
    private static List<DictionaryApp> dictonaryAppList = new ArrayList<>();
    static {
        dictonaryAppList.add(new DictionaryApp("book","quyển sách"));
        dictonaryAppList.add(new DictionaryApp("note","ghi chú"));
        dictonaryAppList.add(new DictionaryApp("pen","cây viết"));
        dictonaryAppList.add(new DictionaryApp("apple","quả táo"));
        dictonaryAppList.add(new DictionaryApp("orange","quả cam"));
    }


    @Override
    public List<DictionaryApp> getListDictionary() {
        return dictonaryAppList;
    }
}
