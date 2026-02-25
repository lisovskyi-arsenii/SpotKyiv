package org.lisovskyi.backend.constants;

public final class EntityConstraints {
    private EntityConstraints() {
        throw new UnsupportedOperationException("EntityConstraints cannot be instantiated - utility class");
    }

    // 1. Users entity constraints
    public static final class Users {
        private Users() {
            throw new UnsupportedOperationException("EntityConstraints.Users cannot be instantiated - utility class");
        }

        public static final int USERNAME_MAX_LENGTH = 50;
        public static final int EMAIL_MAX_LENGTH = 100;
        public static final int PASSWORD_MAX_LENGTH = 255;
        public static final int ROLE_MAX_LENGTH = 10;
    }

    // 2. UsersProfile entity constraints
    public static final class UsersProfile {
        private UsersProfile() {
            throw new UnsupportedOperationException("EntityConstraints.UserProfile cannot be instantiated - utility class");
        }

        public static final int NAME_MAX_LENGTH = 50;
        public static final int PHONE_NUMBER_MAX_LENGTH = 20;
        public static final int PROFILE_PICTURE_URL_MAX_LENGTH = 500;
    }

    // 3. UserOauthProvider entity constraints
    public static final class UserOauthProvider {
        private UserOauthProvider() {
            throw new UnsupportedOperationException("EntityConstraints.UserOauthProvider cannot be instantiated - utility class");
        }

        public static final int PROVIDER_MAX_LENGTH = 50;
        public static final int PROVIDER_UID_MAX_LENGTH = 255;
    }

    // 4. UserSocialLinks entity constraints
    public static final class UserSocialLinks {
        private UserSocialLinks() {
            throw new UnsupportedOperationException("EntityConstraints.UserSocialLinks cannot be instantiated - utility class");
        }

        public static final int PLATFORM_MAX_LENGTH = 50;
        public static final int URL_MAX_LENGTH = 500;
    }

    // 5. Locations entity constraints
    public static final class Locations {
        private Locations() {
            throw new UnsupportedOperationException("EntityConstraints.Locations cannot be instantiated - utility class");
        }

        public static final int NAME_MAX_LENGTH = 255;
        public static final int LATITUDE_PRECISION = 10;
        public static final int LATITUDE_SCALE = 8;
        public static final int LONGITUDE_PRECISION = 11;
        public static final int LONGITUDE_SCALE = 8;
    }

    // 6. UserFavourites entity constraints

    // 7. Interests entity constraints
     public static final class Interests {
        private Interests() {
            throw new UnsupportedOperationException("EntityConstraints.Interests cannot be instantiated - utility class");
        }

        public static final int NAME_MAX_LENGTH = 100;
    }

    // 8.

}
