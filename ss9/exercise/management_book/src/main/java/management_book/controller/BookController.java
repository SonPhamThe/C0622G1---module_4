package management_book.controller;

import management_book.model.Book;
import management_book.model.Orders;
import management_book.service.IBookService;
import management_book.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private IBookService bookService;

    @Autowired
    private IOrderService orderService;

    @GetMapping("")
    public String displayListBook(@PageableDefault(value = 3) Pageable pageable, Model model) {
        model.addAttribute("bookList", bookService.displayALl(pageable));
        return "home";
    }

    @GetMapping("/{id}/order")
    public String formOrderBook(@PathVariable int id, Model model) {
        Orders orders = new Orders();

        long code = (long) (Math.random() * (99999 - 10000) + 10000);
        orders.setCode(code);

        long millis = System.currentTimeMillis();
        orders.setDate(new Date(millis));

        orders.setBooks(bookService.findById(id));

        orderService.save(orders);

        model.addAttribute("order", orders);

        model.addAttribute("bookOrder", bookService.findById(id));
        return "borrow";
    }

    @PostMapping("/order")
    public String submitOrder(@RequestParam int id, @PageableDefault(value = 3) Pageable pageable, Book book, Model model) {
        Book books = bookService.findById(id);
        books.setCount(books.getCount() - 1);
        bookService.save(books);
        model.addAttribute("bookList", bookService.displayALl(pageable));
        return "home";
    }
}
