package ru.yradio.kiosk.dao;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.yradio.kiosk.domain.News;

import java.util.List;

/**
 *
 * @author k.boenko
 * @since 28.03.17.
 */
@Repository
@Transactional
public class NewsServiceImpl implements NewsService{
    private NewsRepository newsRepository;

    @Autowired
    public void setNewsRepository(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<News> findAll() {
        return Lists.newArrayList(newsRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public News findById(Long id) {
        return newsRepository.findOne(id);
    }

    @Override
    public News save(News news) {
        return newsRepository.save(news);
    }

    @Override
    public Page<News> findAllByPage(Pageable pageable) {
        return newsRepository.findAll(pageable);
    }
}
