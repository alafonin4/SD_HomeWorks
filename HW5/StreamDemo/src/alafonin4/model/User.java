package alafonin4.model;

import java.util.*;

public class User {
    private final long id;
    private String firstName;
    private String lastName;
    private int age;
    private String nationality;

    public void setAge(int age) {
        this.age = age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public User(long id, String firstName, String lastName, int age, String nationality) {
        this.id = id;
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setNationality(nationality);
    }
    public static User generateRandomUser(Random random, int numberOfUsers) {
        long id = random.nextLong(numberOfUsers / 3) + 1;
        String[] firstNames = {"Даниил", "Максим", "Владислав", "Никита", "Артем", "Иван", "Кирилл", "Егор", "Илья", "Андрей"};
        String randomFirstName = firstNames[random.nextInt(firstNames.length)];
        String[] lastNames = {"Иванов", "Смирнов", "Кузнецов", "Попов", "Васильев", "Петров", "Соколов", "Лазарев", "Медведев", "Ершов"};
        String randomLastName = lastNames[random.nextInt(lastNames.length)];
        int age = random.nextInt(1, 150);
        String[] loc = {"Русские", "Узбеки", "Беларусы", "Таджики", "Молдоване", "Китайцы", "Японцы"};
        String location = loc[random.nextInt(loc.length)];
        return new User(id, randomFirstName, randomLastName, age, location);
    }
    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getNationality() {
        return nationality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) {
            return false;
        }
        return (getId() == user.getId())
                && (getAge() == user.getAge())
                && getFirstName().equals(user.getFirstName())
                && getLastName().equals(user.getLastName())
                && getNationality().equals(user.getNationality());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getAge(), getNationality());
    }

    @Override
    public String toString() {
        return "Id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", nationality='" + nationality + '\'';
    }
}
