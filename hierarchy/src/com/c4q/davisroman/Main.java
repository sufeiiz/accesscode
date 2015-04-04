package com.c4q.davisroman;

public class Main {

    public static com.c4q.davisroman.Principal createHierarchy(){
        com.c4q.davisroman.Principal judy          = new Principal("judy");

        Teacher msDiaz          = new Teacher("Ms.Diaz");
        Teacher msArcentales    = new Teacher("Ms.Arcentales");
        Teacher msLui           = new Teacher("Ms.Lui");

        Student kevin           = new Student("kevin");
        Student amanda          = new Student("amanda");
        Student billy           = new Student("billy");
        Student ray             = new Student("ray");
        Student mike            = new Student("mike");
        Student stacy           = new Student("stacy");
        Student jackie          = new Student("jackie");
        Student laura           = new Student("laura");
        Student tommy           = new Student("tommy");

        Lunchbox redLunchbox    = new Lunchbox("red");
        Lunchbox yellowLunchbox = new Lunchbox("yellow");
        Lunchbox blackLunchBox  = new Lunchbox("black");
        Lunchbox greenLunchbox  = new Lunchbox("green");
        Lunchbox pinkLunchBox   = new Lunchbox("pink");
        Lunchbox blueLunchbox   = new Lunchbox("blue");

        kevin.setLunchBox(redLunchbox);
        kevin.setNumOfPencilsInPocket(2);

        amanda.setLunchBox(yellowLunchbox);
        amanda.setNumOfPencilsInPocket(3);

        billy.setLunchBox(blackLunchBox);
        billy.setNumOfPencilsInPocket(2);

        ray.setLunchBox(blackLunchBox);
        ray.setNumOfPencilsInPocket(3);

        mike.setLunchBox(greenLunchbox);
        mike.setNumOfPencilsInPocket(3);

        stacy.setLunchBox(pinkLunchBox);
        stacy.setNumOfPencilsInPocket(3);

        jackie.setLunchBox(greenLunchbox);
        jackie.setNumOfPencilsInPocket(3);

        laura.setLunchBox(yellowLunchbox);
        laura.setNumOfPencilsInPocket(2);

        tommy.setLunchBox(blueLunchbox);
        tommy.setNumOfPencilsInPocket(4);


        msDiaz.addStudent(kevin);
        msDiaz.addStudent(amanda);
        msDiaz.addStudent(billy);

        msArcentales.addStudent(ray);
        msArcentales.addStudent(mike);
        msArcentales.addStudent(stacy);

        msLui.addStudent(jackie);
        msLui.addStudent(laura);
        msLui.addStudent(tommy);

        judy.addTeacher(msDiaz);
        judy.addTeacher(msArcentales);
        judy.addTeacher(msLui);

        return judy;

    }

    public static void main(String[] args) {

        Principal judy = createHierarchy();

        System.out.println("Number of students with a red lunchbox: " +
                judy.numOfStudentsWithCertainColorLunchbox("red")  );

        judy.studentsWithCertainColorLunchbox("yellow");

        System.out.println("Ray's teacher is: " + judy.whoIsThisStudentsTeacher("ray"));

        System.out.println("Teachers that have students with less than 3 pencils in their pocket:");
        judy.teachersThatHaveStudentsWithLessThanACertainNumberOfPencils(3);


    }
}
