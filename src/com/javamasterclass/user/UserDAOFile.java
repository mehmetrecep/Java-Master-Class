//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.javamasterclass.user;

import com.javamasterclass.user.IUserDAO;
import com.javamasterclass.user.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.UUID;
import java.util.regex.Pattern;

public class UserDAOFile implements IUserDAO {
    private static User[] users;

    public UserDAOFile() {
    }

    public User[] getUsers() throws FileNotFoundException {
        String path = "src/com/carbooking/users.csv";
        users = new User[5];
        int index = 0;
        Pattern pattern1 = Pattern.compile("^[0-9a-fA-F]{8}\\b-[0-9a-fA-F]{4}\\b-[0-9a-fA-F]{4}\\b-[0-9a-fA-F]{4}\\b-[0-9a-fA-F]{12}$");
        Pattern pattern2 = Pattern.compile("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$");
        File file = new File(path);

        User user;
        for(Scanner scanner = new Scanner(file); scanner.hasNext(); users[index++] = user) {
            String[] nextLine = scanner.nextLine().split(",");
            user = new User(nextLine[1], UUID.fromString(nextLine[0]));
        }

        return users;
    }
}

