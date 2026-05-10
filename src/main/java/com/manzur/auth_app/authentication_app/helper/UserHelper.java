package com.manzur.auth_app.authentication_app.helper;

import java.util.UUID;

public class UserHelper {
    public static UUID parseUUID(String uuid) {
        return UUID.fromString(uuid);
    }
}
