public class Person {
  private final String name;
  private final int age;
     
  /**
   * Creates a person with the specified name and age.
   *
   * @param name the name
   * @param age the age
   * @throws IllegalArgumentException if the age is not greater than zero
   */
  public Person(String name, int age) {
    this.name = name;
    this.age = age;
    if (age <= 0) {
      throw new IllegalArgumentException("Invalid age:" + age);
    }
  }
}