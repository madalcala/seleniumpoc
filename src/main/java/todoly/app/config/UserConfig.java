package todoly.app.config;

import org.apache.log4j.Logger;
import todoly.app.entities.User;
import todoly.core.utils.JsonReader;

import java.io.File;

import static todoly.app.constants.CommonConstants.ADMIN_USER;
import static todoly.app.constants.CommonConstants.TEST_USER;

/**
 * This class manages the users configurations.
 *
 * @author Maday Alcala
 * @since 06/26/2021
 */
public class UserConfig {

    private Logger log = Logger.getLogger(getClass());

    private static final String USER_EMAIL = "email";
    private static final String USER_PASSWORD = "password";
    private final String format = "%s%s%s%s%s";

    // Users
    private User adminUser = new User();
    private User testUser = new User();

    private static UserConfig instance;

    /**
     * Gets instance of UserConfig.
     *
     * @return A current instance or a new instance.
     */
    public static UserConfig getInstance() {
        if (instance == null) {
            instance = new UserConfig();
        }
        return instance;
    }

    private final String usersConfigFilename = String.format(format, System.getProperty("user.dir"),
            File.separator, "config", File.separator,  "users.json");

    /**
     * Reads values from json file.
     */
    public void initialize()  {
        log.info("Read user credentials settings");
        JsonReader usersReader = new JsonReader(usersConfigFilename);

        // Get Admin User credentials
        adminUser.setEmailAddress(usersReader.getKeyValue(ADMIN_USER, USER_EMAIL));
        adminUser.setPassword(usersReader.getKeyValue(ADMIN_USER, USER_PASSWORD));

        // Get Test User credentials
        adminUser.setEmailAddress(usersReader.getKeyValue(TEST_USER, USER_EMAIL));
        adminUser.setPassword(usersReader.getKeyValue(TEST_USER, USER_PASSWORD));
    }

    /**
     * Gets user using a user type.
     *
     * @param userType - The user type to match.
     * @return The matched user.
     */
    public User getUserByUserType(final String userType) {
        switch (userType) {
            case ADMIN_USER:
                return adminUser;
            case TEST_USER:
                return testUser;
            default:
                return null;
        }
    }
}
