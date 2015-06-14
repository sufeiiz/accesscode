/**
 * Created by sufeizhao on 4/30/15.
 *
 * Refactor: Create the abstract class ReedPlayer, which extends Musician.
 * Port the functionality of ClarinetPlayer to ReedPlayer, including having the ReedPlayer keep a
 * ReedInstrument field set in the constructor.
 */

public abstract class ReedPlayer extends Musician<ReedInstrument>{

    ReedInstrument instrument;

    public ReedPlayer(ReedInstrument instrument) {
        this.instrument = instrument;
    }

    public void toggle_reed() {
        if (instrument.has_reed())
            instrument.remove_reed();
        else
            instrument.place_reed();
    }
}
