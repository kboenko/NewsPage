package ru.yradio.kiosk;

import com.google.common.collect.Lists;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import javax.servlet.http.Part;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.yradio.kiosk.dao.NewsRepository;
import ru.yradio.kiosk.dao.NewsService;
import ru.yradio.kiosk.domain.News;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/**
 *
 * Request's controller
 *
 * @author k.boenko
 * @since 27.03.17.
 */
@Controller
public class NewsController {

    private static final Logger log = Logger.getLogger(NewsController.class);

    @Autowired
    private NewsService newsService;

    @RequestMapping("")
    public String index() {
        return "news/list";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody List<News> allNews() {
        return newsService.findAll();
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public String addPage(Model model) {
        News news = new News();
        model.addAttribute("news", news);
        return "news/add";
    }

    @RequestMapping(value = "/create", method=RequestMethod.POST)
    public String addNews(News news, BindingResult bindingResult, Model model, @RequestParam(value="file", required = false) Part file) {
        log.info("Creating news...");
        if(bindingResult.hasErrors()){
            log.error("Can't add news!");
            model.addAttribute("news", news);
            return "news/add";
        }

        model.asMap().clear();

        if(file != null) {
            log.info("File name: " + file.getName());
            log.info("File size: " + file.getSize());
            log.info("File content type: " + file.getContentType());
            byte[] fileContent;
            try {
                InputStream inputStream = file.getInputStream();
                if (inputStream == null)
                    log.info("File is null!");
                fileContent = IOUtils.toByteArray(inputStream);
                news.setPicture(fileContent);
            } catch (IOException ioe) {
                log.error("Error saving uploaded file: " + ioe);
            }
        }

        newsService.save(news);
        log.info("News has been added. ID=" + news.getId());
        return "redirect:/";
    }

    @RequestMapping(value="/picture/{id}", method = RequestMethod.GET)
    @ResponseBody
    public byte[] loadPicture(@PathVariable("id") Long id){
        News news = newsService.findById(id);
        if(news.getPicture() != null) {
            log.info("Loading picture for id: " + news.getId());
        }
        return news.getPicture();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public String showNews(@PathVariable("id") Long id, Model model) {
        News news = newsService.findById(id);
        model.addAttribute("news", news);
        return "news/show";
    }

    @RequestMapping(value = "/back", method = RequestMethod.GET)
    public String goBack() {
        return "redirect:/";
    }
}
