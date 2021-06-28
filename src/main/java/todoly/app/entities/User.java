package todoly.app.entities;

/**
 * Class that handles the User entity.
 *
 * @author Maday Alcala
 * @since 06/26/2021
 */
public class User {
    private String userName;
    private String emailAddress = "";
    private String password;

    /**
     * Gets the user name.
     *
     * @return the current user name.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the user name.
     *
     * @param userName user name to set.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

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
    public void setEmailAddress(String emailAddress) {
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
    public void setPassword(String password) {
        this.password = password;
    }
}
