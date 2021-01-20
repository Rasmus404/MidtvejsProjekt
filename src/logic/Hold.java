package logic;

public class Hold {

    private int hold_id;
    private String holdNavn;
    private int score;
    private int placering;

   /* public Hold (String holdNavn) {

        this.holdNavn = holdNavn;
    }*/

    public int getId() {
        return hold_id;
    }

    public void setId(int hold_id) {
        this.hold_id = hold_id;
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
