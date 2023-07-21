package com.example.wombaturleater.services;

import com.example.wombaturleater.entities.Link;
import com.example.wombaturleater.repository.LinksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URL;
import java.util.List;
import java.util.Optional;


@Service
@Transactional(readOnly = true)
public class LinksService {

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    private static final int    BASE     = ALPHABET.length();


    private final LinksRepository linksRepository;
//    private final BaseConversion conversion;


    @Autowired
    public LinksService(LinksRepository linksRepository) {
        this.linksRepository = linksRepository;
    }

    public List<Link> findAll() {
        return linksRepository.findAll();
    }

    @Transactional
    public void save(Link link) {
        linksRepository.save(link);
    }

    //todo return type URL
    public void cutter(URL url){
        StringBuffer sb = new StringBuffer();
        String result = null;
        String strURL = url.toString();
        URL aURL = url;
        sb.append(url);

//            System.out.println("*** -> " + strURL.substring(19));
        String host = cutParts(aURL);

        result = host +"/"+ encode(decode(strURL.substring(getProtocol(aURL)+ host.length())));
        System.out.println(result);


    }


    // todo
//    public Optional<Url> getUrlByLongUrl(String longUrl) {
//        return urlRepository.findByUrlLongName(longUrl);
//    }
    @Transactional
    public void delete(int id) {
        linksRepository.deleteById(id);
    }

    public Link findOne(int id) {
        Optional<Link> foundUrl = linksRepository.findById(id);
        return foundUrl.orElse(null);
    }


    public static String encode(int num) {
        StringBuilder sb = new StringBuilder();
        while ( num > 0 ) {
            sb.append( ALPHABET.charAt( num % BASE ) );
            num /= BASE;
        }
        return sb.reverse().toString();
    }

    //todo
    public static int decode(String str) {
        int num = 0;
        for ( int i = 0; i < str.length(); i++ )
            num = num * BASE + ALPHABET.indexOf(str.charAt(i));
        return num;
    }

    public static String cutParts(URL url) {
        URL aURL = null;
        aURL = url;
        return aURL.getHost();
    }

    public static int getProtocol(URL url){
        return url.getProtocol().length();
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
