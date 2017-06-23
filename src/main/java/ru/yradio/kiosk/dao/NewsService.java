package ru.yradio.kiosk.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.yradio.kiosk.domain.News;

import java.util.List;

/**
 *
 * @author k.boenko
 * @since 28.03.17.
 */
public interface NewsService {
    List<News> findAll();
    News findById(Long id);
    News save(News news);
    Page<News> findAllByPage(Pageable pageable);
}
