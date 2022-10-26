package management_book.service;

import management_book.model.Book;
import management_book.model.Orders;

import java.util.List;

public interface IOrderService {
    List<Orders> displayALl();

    Orders findById(int id);

    void update(Orders orders);

    void save(Orders orders);
}
