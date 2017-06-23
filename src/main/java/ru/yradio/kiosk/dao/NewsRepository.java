package ru.yradio.kiosk.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.yradio.kiosk.domain.News;

import java.util.List;

/**
 *
 * @author k.boenko
 * @since 27.03.17.
 */

public interface NewsRepository extends PagingAndSortingRepository<News, Long> {
}

/*public interface NewsRepository extends JpaRepository<News, Long> {
}*/
