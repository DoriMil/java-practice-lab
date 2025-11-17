package com.dorotamiler.streams.adultusers;

import java.util.List;

public class UsersRepository {
    public static List<User> listUsers() {
        return List.of(
                new User("Ala", 30, "Gdańsk"),
                new User("Kasia", 17, "Kraków"),
                new User("Adam", 25, "Warszawa")
        );
    }
}