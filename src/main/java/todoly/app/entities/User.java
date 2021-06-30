package todoly.app.entities;

/**
 * Class that handles the User entity.
 *
 * @author Maday Alcala
 * @since 06/26/2021
 */
public class User {
    private String emailAddress = "";
    private String password;

    /**
     * Gets email address.
     *
     * @return User's email address.
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets email address.
     *
     * @param emailAddress - User's email address.
     */
    public void setEmailAddress(final String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Gets the user password.
     *
     * @return the current user password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the user password.
     *
     * @param password user password to set.
     */
    public void setPassword(final String password) {
        this.password = password;
    }
}
