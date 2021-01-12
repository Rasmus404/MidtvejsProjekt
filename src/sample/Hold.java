package sample;

public class Hold {

    private String holdNavn = null;
    private String score = null;
    private String placering = null;

    public Hold() {
    }

    public Hold(String holdNavn, String score, String placering) {
        this.holdNavn = holdNavn;
        this.score = score;
        this.placering = placering;
    }

    public String getHoldNavn() {
        return holdNavn;
    }

    public void setHoldNavn(String holdNavn) {
        this.holdNavn = holdNavn;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getPlacering() {
        return placering;
    }

    public void setPlacering(String placering) {
        this.placering = placering;
    }
}
