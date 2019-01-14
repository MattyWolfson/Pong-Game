import java.awt.event.MouseEvent;

import javax.swing.JFrame;

/**
 * Pong, pong, pong, ping End of Year AP Computer Science Project and Learn
 * Better Project Pictures are property of Nintendo and their creators Emoji
 * Images are property of Apple Inc. and their creators Video method not created
 * by Matty Wolfson
 * 
 * @author Matty Wolfson
 * @version CURRENT
 */
public class MouseActions extends FullGameTest {

    /**
     * Menu image register.
     *
     * @param e Passthrough
     * @param menu Passthrough
     * @param frame Passthrough
     * @param run Passthrough
     * @param mode Passthrough
     */
    public static void imageLoader(MouseEvent e, int menu, JFrame frame,
            FullGameTest run, int mode) {
        int index = 0;
        for (int x = 40; x <= 1120; x += 120) {
            for (int y = 95; y <= 465; y += 120) {
                if (e.getX() >= x && e.getX() <= x + 110 && e.getY() >= y
                        && e.getY() <= y + 110) {
                    if (menu == 6) {
                        setImg(index);
                    } else if (menu == 3) {
                        if (mode == 7) {
                            set2Img(index);
                        } else {
                            setImg(index);
                        }
                        frame.setContentPane(run);
                        setBlank(false);
                        setMenu(-1);
                        run(index + 1, frame, mode);
                    }
                }
                index++;
            }
        }
        if (e.getX() >= 150 && e.getX() <= 1200
                && e.getY() >= 590 && e.getY() <= 660) {
            run.exitGame();
        }
        if (e.getX() >= 40 && e.getX() <= 140
                && e.getY() >= 570 && e.getY() <= 660) {
            setBlank(false);
            if (mode != 2 && menu != 7) {
                setMenu(2);
            } else {
                setMenu(0);
            }
            frame.repaint();
        }
    }

    /**
     * Mouse Listener for Speed Menu.
     *
     * @param e Passthrough
     * @param frame Passthrough
     * @param run Passthrough
     */
    public static void speedMenu(MouseEvent e, JFrame frame, FullGameTest run) {
        if (e.getX() >= 40 && e.getX() <= 600
                && e.getY() >= 95 && e.getY() <= 325) {
            setSpeed(1);
            setBlank(false);
            setMenu(3);
            frame.repaint();
        }
        if (e.getX() >= 40 && e.getX() <= 600
                && e.getY() >= 345 && e.getY() <= 575) {
            setSpeed(3);
            setBlank(false);
            setMenu(3);
            frame.repaint();
        }
        if (e.getX() >= 640 && e.getX() <= 1200
                && e.getY() >= 95 && e.getY() <= 325) {
            setSpeed(2);
            setBlank(false);
            setMenu(3);
            frame.repaint();
        }
        if (e.getX() >= 640 && e.getX() <= 1200
                && e.getY() >= 345 && e.getY() <= 575) {
            setSpeed(4);
            setBlank(false);
            setMenu(3);
            frame.repaint();
        }
        if (e.getX() >= 150 && e.getX() <= 1200
                && e.getY() >= 590 && e.getY() <= 660) {
            run.exitGame();
        }
        if (e.getX() >= 40 && e.getX() <= 140
                && e.getY() >= 570 && e.getY() <= 660) {
            setBlank(false);
            setMenu(0);
            frame.repaint();
        }
    }

    /**
     * Mouse Listener for Dmeo Menu.
     *
     * @param e Passthrough
     * @param frame Passthrough
     * @param run Passthrough
     */
    public static void demoMenu(MouseEvent e, JFrame frame, FullGameTest run) {
        if (e.getX() >= 40 && e.getX() <= 420
                && e.getY() >= 95 && e.getY() <= 325) {
            frame.setContentPane(run);
            setSpeed(3);
            setBlank(false);
            setMenu(-1);
            run(1, frame, 4);
        }
        if (e.getX() >= 40 && e.getX() <= 420
                && e.getY() >= 345 && e.getY() <= 575) {
            frame.setContentPane(run);
            setSpeed(3);
            setBlank(false);
            setMenu(-1);
            run(1, frame, 6);
        }
        if (e.getX() >= 430 && e.getX() <= 810
                && e.getY() >= 95 && e.getY() <= 325) {
            frame.setContentPane(run);
            setSpeed(3);
            setBlank(false);
            setMenu(-1);
            run(1, frame, 5);
        }
        if (e.getX() >= 430 && e.getX() <= 810
                && e.getY() >= 345 && e.getY() <= 575) {
            frame.setContentPane(run);
            setSpeed(4);
            setBlank(false);
            setMenu(-1);
            run(1, frame, 8);
        }
        if (e.getX() >= 820 && e.getX() <= 1200
                && e.getY() >= 95 && e.getY() <= 325) {
            frame.setContentPane(run);
            setSpeed(3);
            setBlank(false);
            setMenu(-1);
            run(1, frame, 10);
        }
        if (e.getX() >= 820 && e.getX() <= 1200
                && e.getY() >= 345 && e.getY() <= 575) {
            frame.setContentPane(run);
            setSpeed(4);
            setBlank(false);
            setMenu(-1);
            run(1, frame, 8);
        }
        if (e.getX() >= 150 && e.getX() <= 1200
                && e.getY() >= 590 && e.getY() <= 660) {
            run.exitGame();
        }
        if (e.getX() >= 40 && e.getX() <= 140
                && e.getY() >= 570 && e.getY() <= 660) {
            setBlank(false);
            setMenu(0);
            frame.repaint();
        }
    }
}
