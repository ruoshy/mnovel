package cn.ousky.mo.resource;

import cn.ousky.mo.model.Content;
import cn.ousky.mo.resource.util.ReadFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BookResource {

    @Value("${book.resourcePath}")
    private String resourcePath;

    public String getCatalog(int id) {
        // 获取本地book目录内容
        return new ReadFile().getContent(resourcePath + "/" + id + "/0.txt");
    }

    public Content getChapter(int id, int page) {
        // 获取本地book章节内容
        Content content = new Content();
        content.setContent(new ReadFile().getContent(resourcePath + "/" + id + "/" + page + ".txt"));
        return content;
    }
}
