package nyc.c4q.sufeiiz;

import java.util.HashMap;

/**
 * Created by sufeizhao on 10/18/15.
 */
public class Hash {


    // Given a list of integers {1, 1, 1, 1, 2, 2, 3, 3, 5}
    // count how many times a given integer occurs
    public static HashMap countInt(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int num : nums) {
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }

        return map;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 1, 1, 1, 2, 2, 3, 3, 5};

        System.out.println(countInt(nums));
    }

    class Person {
        String name;
        String lastName;
        int age;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person)) return false;

            Person person = (Person) o;

            if (age != person.age) return false;
            if (lastName != null ? !lastName.equals(person.lastName) : person.lastName != null) return false;
            if (name != null ? !name.equals(person.name) : person.name != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
            result = 31 * result + age;
            return result;
        }
    }
}
