package management_book.service;

import management_book.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {
    Page<Book> displayALl(Pageable pageable);

    Book findById(int id);

    Book order(Book book);

    void save(Book book);
}
