package aiss.restclient.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import aiss.restclient.model.Youtube.channel.Channel;
import aiss.restclient.model.Youtube.channel.ChannelSearch;
import aiss.restclient.service.YoutubeService;

@Controller
@RequestMapping("/api/")
public class YoutubeController {
    
    //@Autowired
    YoutubeService youtubeService = new YoutubeService();

    @PostMapping("/{id}")
    public Channel post(@PathVariable String id) {
        String token = "1a91f47a52a63df97b35f0694c7bf4cb";
        String part = "snippet,contentDetails,statistics";
        ChannelSearch channel = youtubeService.getChannelWithId(token, part, id);
        return new Channel(channel.getName(), channel.getDescription(), channel.getCreatedTime(), new ArrayList<>());
    }

}
