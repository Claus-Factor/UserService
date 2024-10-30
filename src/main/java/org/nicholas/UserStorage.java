package org.nicholas;

import java.util.*;

public class UserStorage {
    private Map<String, User> map;

    public UserStorage() {
        map = new HashMap<>();
    }

    public void addUser(User user) throws InvalidEmailException, WeakPasswordException, UserAlreadyExistsException {
        UserValidator.validate(user);

        if (map.containsKey(user.getEmail())) {
            throw new UserAlreadyExistsException("Пользователь с такой почтой уже зарегистрирован");
        }

        map.put(user.getEmail(), user);
    }
    public void removeUser(String email) throws Exception {
        if (!map.containsKey(email)) {
            throw new Exception("Данного пользователя не существует в информационной базе");
        }
        map.remove(email);
    }

    public User getUser(String email) {
        return map.get(email);
    }

}
