package idt.custcare.ui.base.login;

/**
 * Handles methods that pages of Login type should implement.
 */
public interface ILoginPage {
  /**
   * Login user in a specific portal.
   *
   * @param username     the username that will login in the portal.
   * @param password     password for User to logint in the portal.
   * @param baseLoginUrl the url to login in the portal.
   */
  void loginUserInPortal(String username, String password, String baseLoginUrl);

  /**
   * Verifies if portal login page is displayed.
   *
   * @return True if portal login page is displayed.
   */
  boolean isLoginPage();
}
