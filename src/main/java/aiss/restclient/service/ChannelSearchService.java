package aiss.restclient.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import aiss.restclient.model.channel.ChannelSearch;

@Service
public class ChannelSearchService {

    // @Autowired
    RestTemplate restTemplate = new RestTemplate();

    // PONER EL TOKEN BIEN Y COMPROBAR LAS URI.

    public List<ChannelSearch> findAllChannels() {
        String uri = "https://www.googleapis.com/youtube/v3/channels?key=AIzaSyC0ypA5q3CD-YKibZHLxWK3PhVPgggvlqA&part=snippet&forHandle=GoogleDevelopers";

        ChannelSearch channels = restTemplate.getForObject(uri, ChannelSearch.class);
        return Arrays.asList(channels);
    }

    public ChannelSearch findOneChannel(String id) {
        ChannelSearch canal = null;
        String uri = "https://www.googleapis.com/youtube/v3/channels?key=AIzaSyC0ypA5q3CD-YKibZHLxWK3PhVPgggvlqA&part=snippet&forHandle=GoogleDevelopers/"
                + id;

        ResponseEntity<ChannelSearch> channel = restTemplate.exchange(uri, HttpMethod.GET,
                null, ChannelSearch.class);
        canal = channel.getBody();
        return canal;
    }

}
