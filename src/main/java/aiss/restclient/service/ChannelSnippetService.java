package aiss.restclient.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import aiss.restclient.model.channel.ChannelSnippet;

public class ChannelSnippetService {

    // @Autowired
    RestTemplate restTemplate = new RestTemplate();

    // PONER EL TOKEN BIEN Y COMPROBAR LAS URI.

    public List<ChannelSnippet> findAllChannels() {
        String uri = "https://www.googleapis.com/youtube/v3/channels?key=AIzaSyC0ypA5q3CD-YKibZHLxWK3PhVPgggvlqA&part=snippet&forHandle=GoogleDevelopers";

        ChannelSnippet[] channels = restTemplate.getForObject(uri, ChannelSnippet[].class);
        return Arrays.asList(channels);
    }

    public ChannelSnippet findOneChannel(String id) {
        ChannelSnippet canal = null;
        String uri = "https://www.googleapis.com/youtube/v3/channels?key=AIzaSyC0ypA5q3CD-YKibZHLxWK3PhVPgggvlqA&part=snippet&forHandle=GoogleDevelopers/"
                + id;

        ResponseEntity<ChannelSnippet> channel = restTemplate.exchange(uri, HttpMethod.GET,
                null, ChannelSnippet.class);
        canal = channel.getBody();
        return canal;
    }

}
