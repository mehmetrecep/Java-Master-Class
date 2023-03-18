package com.javamasterclass.user;

import java.io.FileNotFoundException;

public interface IUserDAO {
    User[] getUsers() throws FileNotFoundException;
}
