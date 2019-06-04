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
        // 获取id 对应book 信息
        return bookMapper.findById(i);
    }

    public List<Book> likeName(String name, int page) {
        // 分页获取模糊搜索信息 每页8个
        int size = 8;
        int start = page * size;
        return bookMapper.likeName(name, start, size);
    }

    public String catalog(int id) {
        // 获取id对应book目录
        return bookResource.getCatalog(id);
    }

    public String chapter(int id, int page) {
        // 获取id对应book指定章节
        if (page < 1)
            page = 1;
        return bookResource.getChapter(id, page).toString();
    }

    public List<Book> findTypeById(int type_id, int page) {
        // 分页获取id对应type类型book 每页 9个
        int size = 9;
        int start = page * size;
        return bookMapper.findByTypeId(type_id, start, size);
    }

    public List<Book> findNewBook(int page) {
        // 获取最新book信息每页8个
        int size = 8;
        int start = size * page;
        return bookMapper.findByNewBook(start, size);
    }

    public List<Book> findOverBook(int page) {
        // 获取完结book信息每页8个
        int size = 8;
        int start = size * page;
        return bookMapper.findOverBook(1, start, size);
    }
}
