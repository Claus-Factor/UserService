package org.nicholas;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidEmailException, WeakPasswordException {

        UserService service = new UserService(); // Экзмепляр сервиса

        System.out.println("Серсис компьютерных курсов\n ****************");

        boolean isContinued = true;
        while (isContinued) {
            System.out.println("Выберите действие:\n1. Авторизация\n2. Регистрация");
            Scanner scanner = new Scanner(System.in);
            try {
                int chose = scanner.nextInt();
                switch (chose) {
                    case 1 -> {

                        String email = scanner.next();
                        String password = scanner.next();

                        try {
                            service.authenticate(email, password);

                        } catch (AuthenticationException e) {
                            System.out.println(e.getMessage());
                        }

                    }

                    case 2 -> {
                        String name = scanner.next();
                        String email = scanner.next();
                        String password = scanner.next();

                        try {
                            service.register(name, email, password);
                        }
                        catch (IllegalArgumentException | InvalidEmailException | WeakPasswordException |
                               UserAlreadyExistsException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    default -> {
                        isContinued = false;
                    }

                }
                System.out.println(" ****************");

            } catch (InputMismatchException e) {
                break;
            }


        }
    }
}