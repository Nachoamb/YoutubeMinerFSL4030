package aiss.restclient;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import aiss.restclient.model.Youtube.channel.ChannelSearch;
import aiss.restclient.service.ChannelSearchService;

public class ChannelSearchServiceTest {

    ChannelSearchService channelService = new ChannelSearchService();

    @Test
    @DisplayName("Get commits authenticated")
    void testFindAllChannels() {
        List<ChannelSearch> users = channelService.findAllChannels();
        assertFalse(users.isEmpty(), "The list of users is empty!");
        System.out.println(users);
    }

    public static void main(String[] args) {
        ChannelSearchServiceTest c = new ChannelSearchServiceTest();
        c.testFindAllChannels();
    }

}
