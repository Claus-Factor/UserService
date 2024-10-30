package org.nicholas;

/**
 * Класс {@code UserService} реализует сервис с регистрацией и авторизацией пользователей
 * @author NicholasVolkhin
 * @version 1.0.0
 */
public class UserService {
    /**
     * Поле хранения зарегистрированных пользователей
     */
    private static final UserStorage storage = new UserStorage();
    /**
     * Поле для хренения текущего пользователя
     */
    private User currentUser = null;

    /**
     * Метод регистрации пользователей
     * @param name имя пользователя
     * @param email адрес  электронной почты
     * @param password пароль
     * @throws InvalidEmailException выбрасывает исключение о некорректности эл. почты
     * @throws WeakPasswordException выбрасывает исключение о тривиальности пароля
     * @throws UserAlreadyExistsException выбрасывает исключение о существующей записи пользователя
     */
    public void register(String name, String email, String password) throws InvalidEmailException, WeakPasswordException, UserAlreadyExistsException {
        User user = new User(name, email, password);
        UserValidator.validate(user);
        storage.addUser(user);

        System.out.println("Пользователь успешно зарегистрирован: " + email);

    }

    public void authenticate(String email, String password) throws AuthenticationException {
        User user = storage.getUser(email);
        if (user == null) {
            throw new AuthenticationException("На найдено пользователя с таким адресом электронной почты");
        }
        if (!email.equals(user.getEmail())) {
            throw new AuthenticationException("Неверный пароль!");
        }
        currentUser = user;

        System.out.println("Авторизация прошла успешно! Осуществлен вход в аккаунт: " + user.getName());
        String greetingUser  = user.getRole()==User.UserRole.ADMIN?"Администратор!":"Пользователь!";
        System.out.println("Добро пожаловать, " + greetingUser);
    }

    public void removeUser(String email) throws Exception {
        if (currentUser == null) {
            throw new AuthenticationException("Не осуществлен вход в аккаунт");
        }
        if (currentUser.getRole() != User.UserRole.ADMIN) {
            throw new AuthenticationException("Текущий пользователь не обладает достаточными правами для удаления аккаунтов");
        }
        storage.removeUser(email);

    }

}