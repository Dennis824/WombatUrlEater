package com.example.wombaturleater.services;

import com.example.wombaturleater.entities.Url;
import com.example.wombaturleater.repository.UrlRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
@Transactional(readOnly = true)
public class UrlService {
    private final UrlRepository urlRepository;
//    private final BaseConversion conversion;


    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public List<Url> findAll() {
        System.out.println("Finding all");
        return urlRepository.findAll();
    }

    public void save(Url url) {
        System.out.println("saving  " + url.getLongUrl());
        urlRepository.save(url);
    }

    @Transactional
    public void delete(int id) {
        System.out.println("deleting " + id);
        urlRepository.deleteById(id);
    }

    public Url findOne(int id) {
        System.out.println("finding " + id);
        Optional<Url> foundUrl = urlRepository.findById(id);
        return foundUrl.orElse(null);
    }


//    public String convertToShortUrl(UrlDto urlDto) {
//        var url = new Url();
//        url.setLongUrl(urlDto.getLongUrl());
//        url.setCreatedDate(new Date());
//        var entity = urlRepository.save(url);
//
//        return conversion.encode(entity.getId());
//    }

//    public String getOriginalUrl(String shortUrl) {
//        var id = conversion.decode(shortUrl);
//        var entity = urlRepository.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException("There is no entity with " + shortUrl));
//
//        return entity.getLongUrl();
//    }
}
