package aiss.restclient.model.caption;

import com.fasterxml.jackson.annotation.*;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CaptionSearch {

    @JsonProperty("items")
    private List<YoutubeCaption> items;

    @JsonProperty("items")
    public List<YoutubeCaption> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(List<YoutubeCaption> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n       items");
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
