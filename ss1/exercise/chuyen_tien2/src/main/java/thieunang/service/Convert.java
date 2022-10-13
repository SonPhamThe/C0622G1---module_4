package thieunang.service;


import org.springframework.stereotype.Service;

@Service
public class Convert implements IConvert {
    @Override
    public Double convertMoney(double money) {
        return money * 23000;
    }
}
