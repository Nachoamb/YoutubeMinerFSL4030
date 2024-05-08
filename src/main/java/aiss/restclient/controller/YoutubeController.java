package aiss.restclient.controller;

import java.util.ArrayList;
import java.util.List;

import aiss.restclient.model.comment.AuthorChannelId;
import aiss.restclient.model.comment.CommentSnippet;
import aiss.restclient.model.comment.CommentSnippet__1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import aiss.restclient.model.VideoMiner.*;
import aiss.restclient.model.channel.YoutubeChannel;
import aiss.restclient.model.channel.ChannelSearch;
import aiss.restclient.service.YoutubeService;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/apipath")
public class YoutubeController {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    YoutubeService youtubeService;

    @GetMapping("/channels/{id}")
    public ChannelSearch get(@PathVariable String id){
        String token = "AIzaSyBMFf0FXcHTGGud3hXJeFKD6bEksvPNcMw";
        String part = "snippet,contentDetails,statistics";
        return youtubeService.getChannelWithId(token, part, id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/channels/{id}")
    public List<Channel> post(@PathVariable String id) {
        String token = "AIzaSyBMFf0FXcHTGGud3hXJeFKD6bEksvPNcMw";
        String part = "snippet,contentDetails,statistics";
        ChannelSearch channelSearch = youtubeService.getChannelWithId(token, part, id);
        List<Channel> channels = new ArrayList<>();
        for (YoutubeChannel channel: channelSearch.getItems()) {
            Channel newChannel = new Channel();
            newChannel.setId(channel.getId());
            newChannel.setName(channel.getSnippet().getTitle());
            newChannel.setDescription(channel.getSnippet().getDescription());
            newChannel.setCreatedTime(channel.getSnippet().getPublishedAt());
            if(channel.getVideos() != null && !channel.getVideos().isEmpty()) {
                channel.getVideos().forEach(video -> {
                    Video vid = new Video();
                    vid.setId(video.getId().getVideoId());
                    vid.setName(video.getSnippet().getTitle());
                    vid.setDescription(video.getSnippet().getDescription());
                    vid.setReleaseTime(video.getSnippet().getPublishedAt());
                    vid.setCaptions(new ArrayList<>());
                    if(video.getCaptions() != null && !video.getCaptions().isEmpty()){
                        video.getCaptions().forEach(caption -> {
                            Caption capt = new Caption();
                            capt.setId(caption.getId());
                            capt.setName(caption.getSnippet().getName());
                            capt.setLanguage(caption.getSnippet().getLanguage());
                            vid.getCaptions().add(capt);
                        });
                    }
                    vid.setComments(new ArrayList<>());
                    if(video.getComments() != null && !video.getComments().isEmpty()) {
                        video.getComments().forEach(comment -> {
                            Comment comm = new Comment();
                            CommentSnippet__1 commentAndUserData = comment.getCommentSnippet().getTopLevelComment().getSnippet();
                            comm.setId(comment.getCommentSnippet().getTopLevelComment().getId());
                            comm.setText(commentAndUserData.getTextOriginal());
                            comm.setCreatedOn(commentAndUserData.getPublishedAt());
                            User user = new User();
                            user.setName(commentAndUserData.getAuthorDisplayName());
                            user.setUser_link(commentAndUserData.getAuthorChannelUrl());
                            user.setPicture_link(commentAndUserData.getAuthorProfileImageUrl());
                            comm.setAuthor(user);
                            vid.getComments().add(comm);
                        });
                    }
                    newChannel.getVideos().add(vid);
                });
            }
            Channel VideoChannel = restTemplate.postForObject("http://localhost:8080/videominer/channels", newChannel, Channel.class);
            channels.add(VideoChannel);
        }
        return channels;
    }

}
