package com.vra.bookshelf.controller;

import com.vra.bookshelf.entity.BookshelfEntity;
import com.vra.bookshelf.model.BookService;
import com.vra.bookshelf.model.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class BookController {

    @Autowired
    public BookService bookService;

    @RequestMapping(value = "/books/search{pid}", method = {RequestMethod.POST, RequestMethod.GET})
    public String search(@PathVariable(value = "pid") int pid,
                         @RequestParam(value = "search") String s,
                         @RequestParam(value = "isRead") String isRead,
                         @RequestParam(value = "after", defaultValue = "0") String after,
                         @RequestParam(value = "before", defaultValue = "2500") String before,
                         Model model) {
        List<String> search = new ArrayList<String>();
        search.add(s);
        search.add(isRead);
        search.add(after);
        search.add(before);

        //отображаем найденные
        List<BookshelfEntity> listOfFindBooks = bookService.findBook(search);
        model.addAttribute("books", listOfFindBooks);
        int countOfPages = (int) (Math.ceil(((double) listOfFindBooks.size()) / 10));

        addAttrForPagination(pid, model, countOfPages);
        return "searchlist";
    }

    // обрабатывает get запрос по адресу /
    // то есть по адресу http://localhost:8887/ откроется bookslist.html (возвращаем имя jsp, html)
    @GetMapping(value = "/")
    public String bookshelf() {
        return "redirect:/books/page1";
    }

    //рабочий примитивный вариант потсраничного вывода
    @GetMapping(value = "/books/page{pid}")
    public String getAllBooks(@PathVariable(value = "pid") int pid,
                              Model model) {
        model.addAttribute("book", new BookshelfEntity());   // чтобы поля на форме были пустыми
        int countOfPages = bookService.getCountOfPages();
        model.addAttribute("books", bookService.getListBookByPid(pid));     // 10 записей (pid=1:1-10, pid=2:10-20)

        addAttrForPagination(pid, model, countOfPages);
        return "bookslist";
    }

    //добавляем аттрибуты пейджинга в модель для методов getAllBooks and search
    private void addAttrForPagination(int pid, Model model, int countOfPages) {
       // System.out.println(countOfPages);
        model.addAttribute("countOfPages", countOfPages); // количество страниц (размер BD/10)
        model.addAttribute("pid", pid);
        model.addAttribute("currPage", pid); //текущая стр
        if (pid == 1) {
            model.addAttribute("prevPage", pid);
        } else {
            model.addAttribute("prevPage", pid - 1);
        }
        if (pid >= countOfPages) {
            model.addAttribute("nextPage", pid);
        } else {
            model.addAttribute("nextPage", pid + 1);
        }
    }

    @GetMapping(value = "/books/currPage{pid}/edit{id}")
    public String editBook(@PathVariable(value = "id") Integer id,
                           @PathVariable(value = "pid") Integer pid,
                           @ModelAttribute("book") @Valid BookshelfEntity book,
                           BindingResult bindingResult,
                           Model model) {
        if (!bindingResult.hasErrors()) {
            model.addAttribute("book", bookService.getBookById(id));
        }
        return "edit";
    }

    @GetMapping(value = "/books/currPage{pid}/readalready{id}")
    public String changeReady(@PathVariable(value = "id") Integer id,
                              @PathVariable(value = "pid") Integer pid) {
        bookService.changeReadAlready(id);
        return "redirect:/books/page" + pid;
    }


    @PostMapping(value = "/books/addBook{pid}")
    public String addBook(@PathVariable(value = "pid") Integer pid,
                          @ModelAttribute("book") @Valid BookshelfEntity book,
                          BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        //  System.out.println("Нет ошибки");
        bookService.addBook(book);
        return "redirect:/books/page" + pid;

    }

    @GetMapping(value = "/books/currPage{pid}/delete{id}")
    public String deleteBook(@PathVariable(value = "id") int id,
                             @PathVariable(value = "pid") int pid) {
        bookService.deleteBook(id);
        return "redirect:/books/page" + pid;
    }

    //    So, @ModelAttribute is effectively needed in two cases:
//    To specify name of the attribute. If @ModelAttribute is omitted or has the empty value, default name is used
// (type name of the argument with the first letter decapitalized).
//    If type of the argument has a special meaning. For example, if your domain object passed as attribute extends
// java.security.Principal, you need to annotate it, otherwise Spring will pass a result of HttpServletRequest.getUserPrincipal() instead.
//    Some people tend to use @ModelAttribute without actual need in order to document the meaning of arguments.


}
