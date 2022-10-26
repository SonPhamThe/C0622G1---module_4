package management_book.service.impl;

import management_book.model.Orders;
import management_book.repository.IOrderRepository;
import management_book.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private IOrderRepository orderRepository;

    @Override
    public List<Orders> displayALl() {
        return orderRepository.findAll();
    }

    @Override
    public Orders findById(int id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Orders orders) {
        orderRepository.save(orders);
    }

    @Override
    public void save(Orders orders) {
        orderRepository.save(orders);
    }
}
