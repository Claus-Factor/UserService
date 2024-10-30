package org.nicholas;

/**
 * Класс валидации входных данных пользователя
 */
public class UserValidator {
    private static final String EMAIL_REGEX = "[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,}";
    private static final String PASSWORD_REGEX = "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,}";

    /**
     * Статический метод валидации регистрационных данных
     * @param user пользователь для проверки
     * @throws InvalidEmailException выбрасывается в случае некорректного формата эл. почты
     * @throws WeakPasswordException выбрасывается в случае слишком простого пароля
     */
    public static void validate(User user) throws InvalidEmailException, WeakPasswordException {
        if (user.getName() == null || user.getName().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустой строкой");
        }

        if (!user.getEmail().matches(EMAIL_REGEX)) {
            throw new InvalidEmailException("Неправильный формат электронной почты");
        }

        if (!user.getPassword().matches(PASSWORD_REGEX)) {
            throw new WeakPasswordException("Пароль слишком простой!");
        }

    }
}