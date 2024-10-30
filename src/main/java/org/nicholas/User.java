package org.nicholas;


/**
 * Класс реализует пользователя со свойствами <b>name</b>, <b>email</b>, <b>password</b>
 */
public class User {
    public enum UserRole {
        USER,
        ADMIN
    }
    private String name;
    private String email;
    private String password;
    private UserRole role;

    /**
     * Конструктор с тремя параметрами
     * @param name имя пользователя
     * @param email адрес электронной почты
     * @param password пароль
     */
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    /**
     * Метод получения поля name
     * @return имя пользователя
     */
    public String getName() {
        return name;
    }

    /**
     * Метод получения поля email
     * @return адрес электронной почты
     */
    public String getEmail() {
        return email;
    }

    /**
     * Метод получения поля password
     * @return пароль
     */
    public String getPassword() {
        return password;
    }

    public UserRole getRole() {
        return role;
    }
}

