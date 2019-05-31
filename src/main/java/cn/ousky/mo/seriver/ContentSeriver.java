package cn.ousky.mo.seriver;

import cn.ousky.mo.entity.Book;
import cn.ousky.mo.mapper.IBookMapper;
import cn.ousky.mo.resource.BookResource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ContentSeriver {
    @Resource
    private IBookMapper bookMapper;
    @Resource
    private BookResource bookResource;

    public Book findById(int i) {
        return bookMapper.findById(i);
    }

    public List<Book> likeName(String name, int page) {
        int size = 8;
        int start = page * size;
        return bookMapper.likeName(name, start, size);
    }

    public String catalog(int id) {
        return bookResource.getCatalog(id);
    }

    public String chapter(int id, int page) {
        if (page < 1)
            page = 1;
        return bookResource.getChapter(id, page).toString();
    }

    public List<Book> findTypeById(int type_id, int page) {
        int size = 9;
        int start = page * size;
        return bookMapper.findByTypeId(type_id, start, size);
    }

    public List<Book> findNewBook(int page) {
        int size = 8;
        int start = size * page;
        return bookMapper.findByNewBook(start, size);
    }

    public List<Book> findOverBook(int page) {
        int size = 8;
        int start = size * page;
        return bookMapper.findOverBook(1, start, size);
    }
}
