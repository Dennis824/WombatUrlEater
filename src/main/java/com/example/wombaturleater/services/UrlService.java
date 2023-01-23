package com.example.wombaturleater.services;

import com.example.wombaturleater.dto.UrlDto;
import com.example.wombaturleater.entities.Url;
import com.example.wombaturleater.repository.UrlRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class UrlService {
    private final UrlRepository urlRepository;
    private final BaseConversion conversion;

    public UrlService(UrlRepository urlRepository, BaseConversion baseConversion) {
        this.urlRepository = urlRepository;
        this.conversion = baseConversion;
    }

    public String convertToShortUrl(UrlDto urlDto) {
        var url = new Url();
        url.setLongUrl(urlDto.getLongUrl());
        url.setCreatedDate(new Date());
        var entity = urlRepository.save(url);

        return conversion.encode(entity.getId());
    }

    public String getOriginalUrl(String shortUrl) {
        var id = conversion.decode(shortUrl);
        var entity = urlRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("There is no entity with " + shortUrl));

        return entity.getLongUrl();
    }
}
