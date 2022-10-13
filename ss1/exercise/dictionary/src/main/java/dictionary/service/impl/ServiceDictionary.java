package dictionary.service.impl;

import dictionary.model.DictionaryApp;
import dictionary.repository.IRepoDictionary;
import dictionary.service.IServiceDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceDictionary implements IServiceDictionary {
    @Autowired
    private IRepoDictionary repoDictionary;

    @Override
    public String findWord(String word) {
        List<DictionaryApp> dictonaryAppList = repoDictionary.getListDictionary();
        for(DictionaryApp dictonaryApp:dictonaryAppList){
            if(dictonaryApp.getEn().equals(word)){
                return dictonaryApp.getVie();
            }
        }
        return "Not found word";
    }
}
