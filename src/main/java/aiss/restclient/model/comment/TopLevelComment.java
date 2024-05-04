
package aiss.restclient.model.comment;


import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TopLevelComment {

    @JsonProperty("id")
    private String id;
    @JsonProperty("snippet")
    private CommentSnippet__1 snippet;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("snippet")
    public CommentSnippet__1 getSnippet() {
        return snippet;
    }

    @JsonProperty("snippet")
    public void setSnippet(CommentSnippet__1 snippet) {
        this.snippet = snippet;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n                       id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append("\n                       snippet");
        sb.append('=');
        sb.append(((this.snippet == null)?"<null>":this.snippet));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
