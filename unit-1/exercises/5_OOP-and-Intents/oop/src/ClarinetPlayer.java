/**
 * Created by sufeizhao on 4/30/15.
 *
 * Create the concrete class ClarinetPlayer, which extends Musician.
 * The ClarinetPlayer constructor should take in a Clarinet, and save it in a field called myClarinet.
 * Add a method toggle_reed, which puts a reed on the Clarinet if it doesn't have one, and takes the reed off it if does.
 * Implement the play_instrument method such that if the instrument doesn't have a reed on, it returns null,
 * and otherwise plays the instrument sound.
 */

public class ClarinetPlayer extends ReedPlayer {

    public ClarinetPlayer(Clarinet myClarinet) {
        super(myClarinet);
    }

    @Override
    public String play_instrument() {
        if (!this.instrument.has_reed())
            return null;
        else
            return this.instrument.play();
    }
}
