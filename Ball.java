import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
// import java.awt.Image;
import java.awt.image.BufferedImage;
// import javax.imageio.ImageIO;
// import java.io.File;
// import java.io.IOException;

/**
 * Pong, pong, pong, ping End of Year AP Computer Science Project and Learn
 * Better Project Pictures are property of Nintendo and their creators Emoji
 * Images are property of Apple Inc. and their creators Video method not created
 * by Matty Wolfson
 * 
 * @author Matty Wolfson
 * @version CURRENT
 */
public class Ball extends FullGameTest {

    // private static BufferedImage img;
    private static int mode = 0;
    // private static int posNeg;
    // private static int players = 1;
    // private static int bar3;
    // private static int status = 0;
    private static double angle = 0;
    private static boolean almost = false;
    // private static boolean comp = false;
    // private static boolean jBounced = true;
    // private static boolean nana;
    // private static boolean ignore = false;
    // private static FullGameTest run = FullGameTest.run();
    private int posX = 625; // 625
    private int posY = 610; // 610
    private int l = 12;
    private int h = 5;
    private boolean pause = false;
    private boolean single = true;
    private boolean jBounced = true;
    private boolean notRecent = true;
    private boolean notRecent2 = true;

    // private int j = 1;
    // private static int bar;
    // private static int bar2;

    /**
     * Creates Ball Object.
     */
    public Ball() {
        startAngle(false);
    }

    /**
     * Ball Setup method.
     * 
     * @param mode2 Mode # passed by main class
     */
    public Ball(int mode2) {
        mode = mode2;
        startAngle(false);
        if (mode == 2 || mode == 5) {
            posX = 625;
            posY = 335;
        }
    }

    /**
     * Sets whether there will be two balls.
     */
    public void setDouble() {
        single = false;
    }

    /**
     * Creates starting angle.
     * 
     * @param flip Whether or not to flip the angles (used for 2p mode)
     * @return double Returns the angle to move the ball.
     */
    public double startAngle(boolean flip) {

        angle = Math.random() * 4 + 3;
        l = (int) angle;
        angle = (int) (Math.random() * 4) + 3;
        h = (int) (angle / 2);
        angle = (int) (Math.random() * 99 + 1);
        l = l * -3;
        h = h * -3;
        return angle;
    }

    /**
     * Resets the position of the ball.
     */
    public void resetBall() {
        posX = 640;
        posY = 350;
        l = 12;
        h = 5;
        // comp = false;
    }

    /**
     * Run Method.
     * 
     * @param g Graphics object
     * @param img Image for ball
     * @param mode Mode #
     * @param speed Speed #
     */
    public void run(Graphics g, BufferedImage img, int mode, int speed) {
        if (!getPause()) {
            increaseBall();
            addToDebugger("L: " + l + " | H: " + h);
            if (mode == 4 || mode == 5 || mode == 6
                    || mode == 8 || mode == 10) {
                g.setFont(new Font("TimesRoman", Font.PLAIN, 400));
                g.setColor(Color.BLACK);
                g.drawString("DEMO", 50, 400);
                this.requestFocusInWindow();
            }
            if (mode == 3 || mode == 6) {
                for (int m = 0; m < 3; m++) {
                    for (int j = 0; j < 10; j++) {
                        if (trumpPosX1(j, m) <= posX
                                && trumpPosX2(j, m) >= posX
                                && trumpPosY1(j, m) <= posY
                                && trumpPosY2(j, m) >= posY
                                && getRecent()
                                || trumpPosX1(j, m) <= posX + 30
                                        && trumpPosX2(j, m) >= posX + 30
                                        && trumpPosY1(j, m) <= posY
                                        && trumpPosY2(j, m) >= posY
                                        && getRecent()) {
                            if (FullGameTest.addB() && getRecent()) {
                                flipH();
                                setRecent(false);
                            }
                        }
                    }
                }
            }
            if (posY <= 0) {
                h = -h;
            }
            if (mode == 1 || mode == 3 || mode == 4 || mode == 6 || mode == 9
                    || mode == 10) {
                if (posX <= 0) {
                    l = -l;
                }
                if (posX >= 1250) {
                    l = -l;
                }
                if (posY > 615) {
                    setRecent(true);
                    if (platL() < posX && posX < platL() + getBarLength()) {
                        h = -h;
                    }
                }
                if (posY > 640) {
                    gameOver(4);
                }
            }
            if (mode == 2) {
                if (posY > 650) {
                    h = -h;
                }
                if (posY < 15) {
                    addToDebugger("FLIP");
                    h = -h;
                }
                if (posX < 45) {
                    if (plat2R() < posY && posY < plat2R() + getBarLength()) {
                        l = -l;
                    }
                }
                if (posX > 1210) {
                    if (plat3R() < posY && posY < plat3R() + getBarLength()) {
                        l = -l;
                    }
                }
                if (posX < 0) {
                    gameOver(2);
                }
                if (posX > 1250) {
                    gameOver(1);
                }
            }
            if (mode == 7 || mode == 8) {
                if (posY > 650) {
                    h = -h;
                    notRecent2 = true;
                    notRecent = true;
                }
                if (single) { // left side
                    if (posX < 15 && notRecent2) {
                        notRecent2 = false;
                        lifeCounts(1);

                    }
                    if (posX < 45) {
                        if (plat2R() < posY
                                && posY < plat2R() + getBarLength()) {
                            l = -l;
                        }
                    }
                } else { // right side
                    if (jBounced) {
                        if (FullGameTest.colCheck2P()) {
                            jBounced = false;
                        }
                    }
                    if (posX > 1270 && notRecent) {
                        notRecent = false;
                        lifeCounts(2);

                    }
                    if (posX > 1210) {
                        if (plat3R() < posY
                                && posY < plat3R() + getBarLength()) {
                            l = -l;
                            jBounced = true;
                        }
                    }
                }
            }
            
        }
        g.drawImage(img, posX, posY, 30, 30, FullGameTest.frame());
    }

    /**
     * Moves the ball.
     */
    public void increaseBall() {
        posX += l;
        posY += h;
    }

    /**
     * Returns x position.
     * 
     * @return int Returns x position
     */
    public int x() {
        return posX;
    }

    /**
     * Returns value of y.
     * 
     * @return int Returns y
     */
    public int y() {
        return posY;
    }

    /**
     * Returns value of L (length).
     * 
     * @return int Returns l
     */
    public int l() {
        return l;
    }

    /**
     * Returns value of h (height).
     * 
     * @return int Returns h
     */
    public int h() {
        return h;
    }

    /**
     * Reflects length variable.
     */
    public void reflect() {
        l = -l;
    }

    /**
     * Flips X variable.
     * 
     * @return int Returns new X.
     */
    public int flipX() {
        trump();
        h = -h;
        return posX;
    }

    /**
     * Flips Y variable.
     * 
     * @return int Returns new Y.
     */
    public int flipY() {
        l = -l;
        return posY;
    }

    /**
     * Reflects height variable.
     * 
     * @return int Returns reflected value
     */
    public int refl() {
        h = -(Math.abs(h - (14 / 10)));
        return h;
    }

    /**
     * Toggles Almost variable to false.
     */
    public void almost() {
        System.out.println("Almost " + almost);
        almost = false;
    }

    /**
     * Checks for columns when Wall Breaker is enabled.
     */
    public void trump() {
        if (mode == 3 || mode == 6) {
            FullGameTest.columnCheck(posX);
        }
    }

    /**
     * Toggles pause variable.
     */
    public void pause() {
        pause = !pause;
    }

    /**
     * Changes the position of the ball.
     * 
     * @param posX New X coord
     * @param posY New Y coord
     * @return String returns a debug string
     */
    public String changePos(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        return "changePos Changed: " + posX + "   " + posY;
    }

    /**
     * Returns string with a position printout.
     * 
     * @return String Position statement
     */
    public String toString() {
        return "posX: " + posX + " || posY: " + posY;
    }

    /**
     * Prints another debug String.
     */
    public void specs() {
        System.out.println("L: " + l + " || H: " + h
                + " || X: " + posX + " || Y: " + posY);
    }

    /**
     * Sets X to new coord.
     * 
     * @param posX New coord to set X to
     */
    public void setX(int posX) {
        this.posX = posX;
    }

    /**
     * Sets Y to new coord.
     * 
     * @param posY New coord to set Y to
     */
    public void setY(int posY) {
        this.posY = posY;
    }

    /**
     * Sets L to length.
     * 
     * @param l New length to set L to
     */
    public void setL(int l) {
        this.l = l;
    }

    /**
     * Sets H to new height.
     * 
     * @param h New height to set H to
     */
    public void setH(int h) {
        this.h = h;
    }

    /**
     * Flips L and prints out debug statement.
     */
    public void flipL() {
        l = -l;
        System.out.println("flipped L: " + posX);
    }

    /**
     * Flips H and prints out debug statement.
     */
    public void flipH() {
        h = -h;
        System.out.println("flipped h: " + posY);

        // System.out.println("FLIPPED H: " + posY);
    }
}
