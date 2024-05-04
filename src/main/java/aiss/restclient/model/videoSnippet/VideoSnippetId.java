
package aiss.restclient.model.videoSnippet;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VideoSnippetId {

    @JsonProperty("videoId")
    private String videoId;

    @JsonProperty("videoId")
    public String getVideoId() {
        return videoId;
    }

    @JsonProperty("videoId")
    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(((this.videoId == null)?"<null>":this.videoId));
        return sb.toString();
    }

}
