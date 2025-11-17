package com.dorotamiler.streams.adultusers;

import java.util.List;

import static com.dorotamiler.streams.adultusers.UsersRepository.listUsers;

public class AdultUsers {

    public static List<String> getAdultUsers() {
        return listUsers().stream()
                .filter(user -> user.age() >= 18)
                .filter(user -> user.city().equals("Gdańsk"))
                .map(user -> user.name())
                .sorted()
                .toList();
    }
}