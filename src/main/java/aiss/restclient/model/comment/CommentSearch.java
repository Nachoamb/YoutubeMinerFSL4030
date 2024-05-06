
package aiss.restclient.model.comment;

import com.fasterxml.jackson.annotation.*;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentSearch {

    @JsonProperty("nextPageToken")
    private String nextPageToken;
    @JsonProperty("items")
    private List<YoutubeComment> items;

    @JsonProperty("nextPageToken")
    public String getNextPageToken() {
        return nextPageToken;
    }

    @JsonProperty("nextPageToken")
    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }

    @JsonProperty("items")
    public List<YoutubeComment> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(List<YoutubeComment> items) {
        this.items = items;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n           nextPageToken");
        sb.append('=');
        sb.append(((this.nextPageToken == null)?"<null>":this.nextPageToken));
        sb.append("\n           items");
        sb.append('=');
        sb.append(((this.items == null)?"<null>":this.items));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
