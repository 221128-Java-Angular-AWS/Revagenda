package com.revature.pojos;

import java.util.Objects;

public class User implements Comparable<User>{
    private Integer userId;
    private String firstName;
    private String lastName;
    private String username;
    private String password;


    public User() {
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(Integer userId, String firstName, String lastName, String username, String password) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    public User(String firstName, String lastName, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(username, user.username) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, lastName, username, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public int compareTo(User that) {
        //return negative if this < that
        //return positive that < this
        //return zero if equal

        // User1 < User2 when user1.getLastName() < user2.getLastName() alphabetically, with first name
        //being used the same way as a tiebreaker

        if(this.equals(that)) {
            return 0;
        }

        if(this.getLastName().equals(that.getLastName())) {
            if(this.getFirstName().equals(that.getFirstName())) {
                return 0;
            }
        } else {
            return alphabeticalCompare(this.getFirstName(), that.getFirstName());
        }

        return alphabeticalCompare(this.getLastName(), that.getLastName());
    }

    private int alphabeticalCompare(String a, String b) {
        int size;
        char shorter = 'z';
        if(a.length() <= b.length()) {
            size = a.length();
            shorter = 'a';
        } else {
            size = b.length();
            shorter = 'b';
        }

        for(int i = 0; i < size; i++) {
            if(a.charAt(i) < b.charAt(i)) {
                return -1;
            } else if(a.charAt(i) > b.charAt(i)) {
                return 1;
            }
        }

        if(shorter == 'z') {
            return 0;
        } else if (shorter == 'a') {
            return -1;
        } else {
            return 1;
        }
    }
}
