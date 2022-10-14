package thieunang.service;

import org.springframework.stereotype.Service;

@Service
public class ConvertService implements IConvert {

    @Override
    public Double convertMoney(double money) {
        return money * 23000;
    }
}
