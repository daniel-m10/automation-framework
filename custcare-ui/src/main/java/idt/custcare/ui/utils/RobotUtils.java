package idt.custcare.ui.utils;

import idt.custcare.ui.config.ReservedWords;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.AWTException;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Performs actions using the Robot java class.
 */
public final class RobotUtils {
    private static final Logger LOGGER = LogManager.getLogger(RobotUtils.class.getSimpleName());
    private static final ClipboardOwner OWNER = null;
    private static final int AUTO_DELAY = 50;
    private static final int ROBOT_START_ACTIONS_DELAY = 2000;

    /**
     * Private constructor for {@link RobotUtils} utility class.
     */
    private RobotUtils() {
    }

    /**
     * Performs the Login with parametrized credentials.
     *
     * @param user     username.
     * @param password password.
     */
    public static void loginWithCredentials(final String user, final String password) {
        try {
            Robot robot = new Robot();
            robot.setAutoDelay(AUTO_DELAY);
            robot.delay(ROBOT_START_ACTIONS_DELAY);
            StringSelection clipboardContent = new StringSelection(user);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(clipboardContent, OWNER);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            clipboardContent = new StringSelection(password);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(clipboardContent, OWNER);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            LOGGER.error(ReservedWords.LOGIN_FAILED.val());
            LOGGER.error(e.getMessage());
        }
    }
}
