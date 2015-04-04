package nyc.c4q.sufeiiz;

import java.util.HashSet;

public class SocialNetwork {

    public static void main(String[] args) {
        HashSet<String> yours = new HashSet();
        yours.add("Eve");
        yours.add("Yelena");
        yours.add("Jamal");
        HashSet<String> mine = new HashSet();
        mine.add("Sebastian");
        mine.add("Mala");
        mine.add("Eve");

        // You should be able to run all of these in a row:
        //System.out.println( allFriends(yours, mine) );
        //System.out.println( mutualFriends(yours, mine) );
        //System.out.println( yourFriends(yours, mine) );
        //System.out.println( myFriends(yours, mine) );
        //System.out.println( exclusiveFriends(yours, mine) );
        //System.out.println( yourFriendsAreMine(yours, mine) );
        //System.out.println( youHaveFriends(yours) );
        System.out.println(matchmaker(yours, mine));
        System.out.println(powerPair(yours, mine));
    }

    public static HashSet<String> allFriends(HashSet<String> yours, HashSet<String> mine) {
        // Yelena, Jamal, Eve, Sebastian, Mala
        HashSet<String> all = new HashSet<String>(yours);

        all.addAll(mine);
        return all;
    }

    public static HashSet<String> mutualFriends(HashSet<String> yours, HashSet<String> mine) {
        // Eve
        HashSet<String> notMutual = new HashSet<String>(yours);
        HashSet<String> cloneYours = new HashSet<String>(yours);

        notMutual.removeAll(mine);
        cloneYours.removeAll(notMutual);
        return cloneYours;
    }

    public static HashSet<String> yourFriends(HashSet<String> yours, HashSet<String> mine) {
        // Yelena, Jamal
        HashSet<String> justYours = new HashSet<String>(yours);
        justYours.removeAll(mine);
        return justYours;
    }

    public static HashSet<String> myFriends(HashSet<String> yours, HashSet<String> mine) {
        // Sebastian, Mala
        HashSet<String> justMine = new HashSet<String>(mine);
        justMine.removeAll(yours);
        return justMine;
    }

    public static HashSet<String> exclusiveFriends(HashSet<String> yours, HashSet<String> mine) {
        // Yelena, Jamal, Sebastian, Mala
        HashSet<String> exclusive = new HashSet<String>();
        exclusive.addAll(yourFriends(yours, mine));
        exclusive.addAll(myFriends(yours, mine));
        return exclusive;

    }

    public static boolean yourFriendsAreMine(HashSet<String> yours, HashSet<String> mine) {
        // true if all your friends are also my friends

        for (String friend : yours) {
            if (!mine.contains(friend)) {
                return false;
            }
        }

        return true;
    }

    public static boolean youHaveFriends(HashSet<String> yours) {
        // true if you have any friends
        return !yours.isEmpty();
    }

    public static HashSet<HashSet<String>> matchmaker(HashSet<String> yours, HashSet<String> mine) {
        // should return these sets:

        // Sebastian, Jamal
        // Jamal, Mala
        // Jamal, Eve

        // Sebastian, Yelena
        // Yelena, Mala
        // Yelena, Eve

        // Sebastian, Eve
        // Mala, Eve

        HashSet<HashSet<String>> matches = new HashSet<HashSet<String>>();
        HashSet<String> pairs = new HashSet<String>();

        for (String friend : yours) {

            for (String buddy : mine) {
                if (buddy.equals(friend)) {
                    continue;
                }
                pairs.add(friend + " : " + buddy);

            }

        }
        matches.add(pairs);
        return matches;
    }

    public static HashSet<HashSet<String>> powerPair(HashSet<String> yours, HashSet<String> mine) {

        HashSet<HashSet<String>> matches = new HashSet<HashSet<String>>();
        HashSet<String> pairs = new HashSet<String>();

        HashSet<String> allFriends = new HashSet<String>(allFriends(yours, mine));
        HashSet<String> allFriends2 = new HashSet<String>(allFriends(yours, mine));

        for (String friend : allFriends) {

            for (String buddy : allFriends2) {
                if (buddy.equals(friend)) {
                    continue;
                } else if (pairs.contains(buddy + " : " + friend)) {
                    continue;
                }
                pairs.add(friend + " : " + buddy);

            }

        }
        matches.add(pairs);
        return matches;
    }
}
