package aiss.restclient.controller;

import java.util.ArrayList;
import java.util.List;
import aiss.restclient.model.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import aiss.restclient.model.Channel;
import aiss.restclient.model.channel.YoutubeChannel;
import aiss.restclient.model.channel.ChannelSearch;
import aiss.restclient.service.YoutubeService;

@Controller
@RequestMapping("/apipath/")
public class YoutubeController {
    
    //@Autowired
    YoutubeService youtubeService = new YoutubeService();

    @PostMapping("channels/{id}")
    public List<Channel> post(@PathVariable String id) {
        String token = "1a91f47a52a63df97b35f0694c7bf4cb";
        String part = "snippet,contentDetails,statistics";
        ChannelSearch channelSearch = youtubeService.getChannelWithId(token, part, id);
        List<Channel> channels = new ArrayList<>();
        for (YoutubeChannel channel: channelSearch.getItems()) {
            Channel newChannel = new Channel();
            newChannel.setId(channel.getId());
            newChannel.setName(channel.getSnippet().getTitle());
            newChannel.setDescription(channel.getSnippet().getDescription());
            newChannel.setCreatedTime(channel.getSnippet().getPublishedAt());
            newChannel.setVideoList(new ArrayList<>());
            channels.add(newChannel);
        }
        return channels;
    }

}
