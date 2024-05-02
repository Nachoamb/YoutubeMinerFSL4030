package aiss.restclient.service;

import aiss.restclient.model.caption.CaptionSearch;
import aiss.restclient.model.channel.Channel;
import aiss.restclient.model.channel.ChannelSearch;
import aiss.restclient.model.comment.CommentSearch;
import aiss.restclient.model.videoSnippet.VideoSnippetSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class YoutubeService {
    @Autowired
    RestTemplate restTemplate;

    public HttpEntity<Channel> auth (String token){
        HttpHeaders headers = new HttpHeaders();
        headers.set("key", token);
        return new HttpEntity<>(null, headers);
    }
    public ChannelSearch getChannelWithId(String token,String part, String id) {
        String uri = String.format("https://www.googleapis.com/youtube/v3/channels?key=%s&part=%s&id=%s",token,part,id);
        /*
        HttpEntity<Channel> entity = auth(token);
        ResponseEntity<Channel> response = restTemplate.exchange(uri, HttpMethod.GET, entity, Channel.class);
        return response.getBody();
        */
        ResponseEntity<ChannelSearch> entity = restTemplate.getForEntity(uri, ChannelSearch.class);
        return entity.getBody();
    }

    public VideoSnippetSearch getVideos(String token, String part, String playListId, String maxResults) {
        String uri = String.format("https://youtube.googleapis.com/youtube/v3/playlistItems?key=%s&part=%s&playlistId=%s&maxResults=%s", token, part.replace("%2C", ","), playListId, maxResults);
        ResponseEntity<VideoSnippetSearch> entity = restTemplate.exchange(uri, HttpMethod.GET,null, VideoSnippetSearch.class);
        return entity.getBody();
    }

    public CaptionSearch getCaptions(String token, String part, String videoId) {
        String uri = String.format("https://www.googleapis.com/youtube/v3/comments?key=%s&part=%s&parentId=%s", token, part, videoId);
        ResponseEntity<CaptionSearch> entity = restTemplate.getForEntity(uri, CaptionSearch.class);
        return entity.getBody();
    }

    public CommentSearch getComments(String token, String part, String videoId) {
        String uri = String.format("https://www.googleapis.com/youtube/v3/comments?key=%s&part=%s&videoId=%s", token, part, videoId);
        ResponseEntity<CommentSearch> entity = restTemplate.getForEntity(uri, CommentSearch.class);
        return entity.getBody();
    }
}
