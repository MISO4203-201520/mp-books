package co.edu.uniandes.csw.bookmp.api;

import co.edu.uniandes.csw.bookmp.dtos.BookDTO;
import java.util.List;

public interface IBookLogic {
    public int countBooks();
    public List<BookDTO> getBooks(Integer page, Integer maxRecords);
    public BookDTO getBook(Long id);
    public BookDTO createBook(BookDTO dto);
    public BookDTO updateBook(BookDTO dto);
    public void deleteBook(Long id);
    public List<BookDTO> findByName(String name);
}
