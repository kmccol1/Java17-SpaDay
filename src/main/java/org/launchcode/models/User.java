package org.launchcode.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class User
{
    private int id;
    private static int nextID;
    @NotBlank(message = "Username is required!")
    @Size(min = 5, max = 15, message = "Username must be between 5 and 15 characters.")
    private String username;
    @Email(message = "Invalid email. Please try again.")
    private String email;
    @NotBlank(message = "Password is required!")
    @Size(min = 6, message = "Password must be at least six characters.")
    private String password;

    @NotNull(message = "Passwords do not match.")
    private String verifyPassword;

    public User(String username, String email, String password)
    {
        this();
        this.username = username;
        this.email = email;
    }

    public User()
    {
        this.id = nextID;
        nextID++;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        checkPassword();
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword();
    }

    private void checkPassword()
    {
        if ( !(this.getPassword().isEmpty())
                && !(this.getVerifyPassword().isEmpty())
                && !(this.password.equals(this.verifyPassword)))
        {
            verifyPassword = null;
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
