package com.example.Project2.controller;


import org.springframework.ui.Model;
import com.example.Project2.dao.BookDAO;
import com.example.Project2.dao.PersonDAO;
import com.example.Project2.integration.Book;
import com.example.Project2.integration.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/books")
public class BooksController {
    private final PersonDAO personDAO;
    private final BookDAO bookDAO;

    @Autowired
    public BooksController(PersonDAO personDAO, BookDAO bookDAO) {
        this.personDAO = personDAO;
        this.bookDAO = bookDAO;
    }

    @GetMapping
    public String showBooks(@RequestParam(value = "page", required = false, defaultValue = "-1") int page,
                            @RequestParam(value = "books_per_page", required = false, defaultValue = "-1") int booksPerPage,
                            @RequestParam(value = "sort_by_year", required = false, defaultValue = "false") boolean sortByYear,
                            Model model) {
        List<Book> books;
        if (page != -1 && booksPerPage != -1) {
            books = sortByYear
                    ? bookService.findAndPageAndSortByYear(page, booksPerPage)
                    : bookService.findAndPage(page, booksPerPage);
        } else if (page == -1 && booksPerPage == -1 && sortByYear) {
            books = bookService.findAndSortByYear();
        } else {
            books = bookService.findAll();
        }
        model.addAttribute("books", books);
        return "books/show";
    }

    @GetMapping("/{id}")
    public String showBook(@PathVariable("id") int id, Model model,
                           @ModelAttribute("person") Person person) {
        Book book = bookDAO.showBook(id);
        model.addAttribute("book", book);
        if (book.getPerson_id() != null) {
            model.addAttribute("reader", personDAO.showPerson(book.getPerson_id()));
        } else {
            model.addAttribute("people", personDAO.showPeople());
        }
        return "books/profile";
    }

    @GetMapping("/new")
    public String addBook(@ModelAttribute("book") Book book) {
        return "books/new";
    }

    @PostMapping()
    public String createBook(@ModelAttribute("book") @Valid Book book,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "books/new";
        bookDAO.save(book);
        return "redirect:/books";
    }

    @GetMapping("/{id}/edit")
    public String editBook(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookDAO.showBook(id));
        return "books/edit";
    }

    @PatchMapping("/{id}")
    public String updateBook(@ModelAttribute("book") @Valid Book book,
                             BindingResult bindingResult,
                             @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) return "books/edit";
        bookDAO.update(id, book);
        return "redirect:/books";
    }

    @PatchMapping("/{id}/person")
    public String addBookToPerson(@ModelAttribute("person") Person person,
                                  @PathVariable("id") int id) {
        Book book = bookDAO.showBook(id);
        book.setPerson_id(person.getId());
        bookDAO.update(id, book);
        return "redirect:/books/{id}";
    }

    @PatchMapping("/{id}/free")
    public String freeBook(@PathVariable("id") int id) {
        bookDAO.free(id);
        return "redirect:/books/{id}";
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        bookDAO.delete(id);
        return "redirect:/books";
    }


}
