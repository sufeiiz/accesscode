package nyc.c4q.sufeiiz;

import java.util.HashMap;

/**
 * Created by sufeizhao on 3/29/15.
 */
public class MoonsAndPlanets {

    private static HashMap<String, Integer> numOfMoons;

    public static HashMap<String, Integer> getNumberOfMoons() {
        numOfMoons = new HashMap<String, Integer>();

        numOfMoons.put("Mercury", 0);
        numOfMoons.put("Venus", 0);
        numOfMoons.put("Earth", 1);
        numOfMoons.put("Mars", 2);
        numOfMoons.put("Jupiter", 67);
        numOfMoons.put("Saturn", 62);
        numOfMoons.put("Uranus", 27);
        numOfMoons.put("Neptune", 14);

        return numOfMoons;
    }

    public static boolean isPlanet(String name) {
        return numOfMoons.containsKey(name);
    }

    public static void main(String[] args) {
        numOfMoons = new HashMap<String, Integer>();
        System.out.println(numOfMoons.get("Mars"));
    }

}
