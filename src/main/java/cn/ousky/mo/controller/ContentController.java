package cn.ousky.mo.controller;

import cn.ousky.mo.entity.Book;
import cn.ousky.mo.seriver.ContentSeriver;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ContentController {

    @Resource
    private ContentSeriver contentSeriver;

    /**
     * 通过id查找作品信息
     *
     * @param bookId 作品id
     * @return Book
     */
    @RequestMapping("/{bookId}/info")
    public Book findBookById(@PathVariable("bookId") int bookId) {
        return contentSeriver.findById(bookId);
    }

    /**
     * 通过作品名模糊搜索作品信息
     *
     * @param name 作品名
     * @param page 页位置
     * @return List<Book>
     */
    @RequestMapping("/lken")
    public List<Book> likeBookName(@RequestParam("lname") String name,
                                   @RequestParam(value = "p", required = false, defaultValue = "0") int page) {
        return contentSeriver.likeName(name, page);
    }

    /**
     * 通过作品id查找作品目录
     *
     * @param bookId 作品id
     * @return Catalog
     */
    @RequestMapping("/{bookId}/catalog")
    public String catalog(@PathVariable("bookId") int bookId) {
        return contentSeriver.catalog(bookId);
    }

    /**
     * 通过作品id以及章节序号查找指定章节内容
     *
     * @param bookId 作品id
     * @param page   章节序号
     * @return Content
     */
    @RequestMapping("/{bookId}/chapter")
    public String chapter(@PathVariable("bookId") int bookId, @RequestParam("p") int page) {
        return contentSeriver.chapter(bookId, page);
    }

    /**
     * 获得对应类型book信息
     *
     * @param typeId 类型id
     * @param page   页数
     * @return List<Book>
     */
    @RequestMapping("/ftb")
    public List<Book> findTypeById(@RequestParam("tid") int typeId,
                                   @RequestParam("p") int page) {
        return contentSeriver.findTypeById(typeId, page);
    }

    /**
     * 新作品信息
     *
     * @param page 页位置
     * @return List<book>
     */
    @RequestMapping("/new")
    public List<Book> findByNewBook(@RequestParam("p") int page) {
        return contentSeriver.findNewBook(page);
    }

    /**
     * 完结作品信息
     *
     * @param page 页位置
     * @return List<Book>
     */
    @RequestMapping("/over")
    public List<Book> findByOverBook(@RequestParam("p") int page) {
        return contentSeriver.findOverBook(page);
    }

}
