package com.hometest.pknayak.pratyushhometest.utils.storage;

import com.hometest.pknayak.pratyushhometest.models.User;

public interface Storage {

    User loadUser();

    void saveUser(User user);

    void resetUser();

}
