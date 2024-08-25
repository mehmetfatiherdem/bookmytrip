package com.virtuous.bookmytripuserservice.converter;

import com.virtuous.bookmytripuserservice.dto.response.CustomUserDetail;
import com.virtuous.bookmytripuserservice.model.User;

public class UserDetailConverter {
    public static CustomUserDetail toUserDetail(User user) {
        return new CustomUserDetail(user);
    }
}
