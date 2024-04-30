package aiss.restclient;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import aiss.restclient.model.channel.ChannelSnippet;
import aiss.restclient.service.ChannelSnippetService;

public class ChannelSnippetServiceTest {

    ChannelSnippetService channelService = new ChannelSnippetService();

    @Test
    @DisplayName("Get channels")
    void testFindAllChannels() {
        List<ChannelSnippet> users = channelService.findAllChannels();
        assertFalse(users.isEmpty(), "The list of users is empty!");
        System.out.println(users);
    }

    public static void main(String[] args) {
        ChannelSnippetServiceTest c = new ChannelSnippetServiceTest();
        c.testFindAllChannels();
    }

}
