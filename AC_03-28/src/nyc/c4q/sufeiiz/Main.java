package nyc.c4q.sufeiiz;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Kennel myKennel = new Kennel();

        Dog spot = new Dog("spot");
        myKennel.addDog(spot);
        Dog fido = new Dog("fido");
        myKennel.addDog(fido);
        Dog sport = new Dog("sport");
        myKennel.addDog(sport);
        Dog missy = new Dog("missy");
        myKennel.addDog(missy);
        Dog max = new Dog("max");
        myKennel.addDog(max);
        Dog sleepy = new Dog("sleepy");
        myKennel.addDog(sleepy);
        Dog sport2 = new Dog("sport");
        myKennel.addDog(sport2);

    }
}
