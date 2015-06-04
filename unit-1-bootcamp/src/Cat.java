/**
 * Created by alexandraqin on 4/14/15.
 */
public class Cat {

  private String name;
  private String favoriteFood;
  private int age;
  private Person owner;

  public Cat() {
  }

  public Cat(String name) {
    this.name = name;
  }

  public String getFavoriteFood() {
    return favoriteFood;
  }

  public void setFavoriteFood(String favoriteFood) {
    this.favoriteFood = favoriteFood;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setOwner(Person owner) {
    this.owner = owner;
  }

  public Person getOwner() {
    return owner;
  }
}
