import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
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
public class PaintMenus extends FullGameTest {

    /**
     * Runs Menus Graphics.
     *
     * @param g Passthrough
     * @param menu Passthrough
     * @param frame Passthrough
     * @param mode Passthrough
     * @param img2X Passthrough
     * @param img2Y Passthrough
     * @param imgArr Passthrough
     * @param name Passthrough
     * @param score Passthrough
     * @param scoresArr Passthrough
     * @param wMode Passthrough
     * @param oldScore Passthrough
     */
    public static void runMenus(Graphics g,
            int menu, JFrame frame, int mode, int img2X, int img2Y,
            ArrayList<BufferedImage> imgArr, String name, int score,
            List<String> scoresArr, int wMode, int oldScore) {
        int imgX = img2X;
        int imgY = img2Y;
        int size = 0;
        addToDebugger("Menu " + menu + " Called");
        if (menu == 0 || menu == 2 || menu == 3 || menu == 6 || menu == 10
                || menu == 11) {
            g.setColor(Color.MAGENTA);
            g.fillRect(0, 0, 1280, 700);
        }
        if (menu == 0 || menu == 2 || menu == 10) {
            g.setColor(Color.BLACK);
            g.fillRect(40, 10, 1160, 70);
            g.fillRect(40, 95, 560, 230);
            g.fillRect(640, 95, 560, 230);
            g.fillRect(40, 345, 560, 230);
            g.fillRect(640, 345, 560, 230);
            if (menu == 0) {
                g.fillRect(40, 590, 1160, 70);
            } else {
                g.fillRect(140, 590, 1160, 70);
            }
            g.setColor(Color.RED);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
            g.drawString("Exit Game!", 520, 640);
        }
        if (menu == 0) {
            g.setColor(Color.RED);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
            g.drawString("What game would you like to play?", 300, 55);
            g.setColor(Color.BLACK);
            loadMenuImages(menu, g, frame);
        }
        if (menu == 2) {
            g.setColor(Color.RED);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
            g.drawString("Difficulty", 540, 55);
            g.setColor(Color.BLACK);
            loadMenuImages(menu, g, frame);
        }
        if (menu == 3 || menu == 6) {
            try {
                g.drawImage(ImageIO.read(new File("Menus/back.png")),
                        40, 570, 100, 110, frame);
            } catch (Exception ex) {
            }
            g.setColor(Color.BLACK);
            g.fillRect(40, 10, 1160, 70);
            int x = 40;
            int y = 95;
            while (x <= 1120 && y <= 455) {
                // System.out.println("X: " + x + " | Y: " + y);
                g.fillRect(x, y, 110, 110);
                y += 120;
                if (y > 455) {
                    y = 95;
                    x += 120;
                }
            }
            g.fillRect(150, 590, 1050, 70);
            g.setColor(Color.RED);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
            if (mode == 7 && menu == 6) {
                g.drawString("Player 1 - Choose Icon!", 430, 55);
            } else if (mode == 7 && menu == 3) {
                g.drawString("Player 2 - Choose Icon!", 430, 55);
            } else {
                g.drawString("Choose your icon!", 430, 55);
            }
            g.drawString("Exit Game!", 520, 640);
            g.setColor(Color.BLACK);
            int imgPos = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 4; j++) {
                    imgX = 40 + (120 * i);
                    imgY = 95 + (120 * j);
                    g.drawImage(imgArr.get(imgPos),
                            imgX, imgY, 110, 110, frame);
                    imgPos++;
                }
            }
        }
        if (menu == 4) {
            runwMode(g, wMode, menu, oldScore, score);
        }
        if (menu == 8) {
            g.setColor(Color.CYAN);
            g.fillRect(0, 0, 1280, 700);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
            g.setColor(Color.BLACK);
            g.drawString("Enter your name:", 80, 160);
            g.drawString(name, 80, 250);
            g.drawString("Scoreboard:", 920, 160);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 100));
            g.drawString("Score: " + score, 360, 80);
            g.fillRect(1030, 170, 10, 450);
            g.fillRect(930, 170, 210, 10);
            g.fillRect(930, 170, 10, 450);
            g.fillRect(1140, 170, 10, 460);
            if (scoresArr.size() < 10) {
                size = scoresArr.size();
            } else {
                size = 10;
            }
            for (int i = 0; i < size; i++) {
                g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
                for (int j = 0; j < scoresArr.get(i).length(); j++) {
                    if (scoresArr.get(i).charAt(j) == ',') {
                        g.drawString(i + 1 + ". "
                                + scoresArr.get(i).substring(0, j),
                                950, 45 * i + 205);
                        g.fillRect(930, 45 * i + 215, 210, 10);
                        if (scoresArr.get(i).length() > 12) {
                            g.drawString(scoresArr.get(i).substring(
                                    j + 1, 10)
                                    + "...", 1050, 45 * i + 205);
                        } else {
                            g.drawString(scoresArr.get(i).substring(
                                    j + 1, scoresArr.get(i).length()),
                                    1050, 45 * i + 205);
                        }
                    }
                }
            }
        }
        if (menu == 10) {
            g.setColor(Color.RED);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
            g.drawString("Specials Menu", 500, 55);
            g.setColor(Color.BLACK);
            loadMenuImages(menu, g, frame);
        }
        if (menu == 11) {
            g.setColor(Color.BLACK);
            g.fillRect(40, 10, 1160, 70);
            g.fillRect(40, 95, 380, 230);
            g.fillRect(430, 95, 380, 230);
            g.fillRect(40, 345, 380, 230);
            g.fillRect(430, 345, 380, 230);
            g.fillRect(820, 95, 380, 230);
            g.fillRect(820, 345, 380, 230);
            g.fillRect(150, 590, 1050, 70);
            g.setColor(Color.RED);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
            g.drawString("DEMO MODE", 480, 55);
            g.drawString("Exit Game!", 520, 640);
            g.setColor(Color.BLACK);
            loadMenuImages(menu, g, frame);
        }
    }

    /**
     * Loads Images on Menus.
     * 
     * @param menu Passthrough
     * @param g Passthrough
     * @param frame Passthrough
     */
    public static void loadMenuImages(int menu, Graphics g, JFrame frame) {
        if (menu == 0) {
            try {
                g.drawImage(ImageIO.read(new File("Menus/pong.png")),
                        60, 95, 520, 230, frame);
            } catch (Exception ex) {
            }
            try {
                g.drawImage(ImageIO.read(new File("Menus/2p.png")),
                        660, 95, 520, 230, frame);
            } catch (Exception ex) {
            }
            try {
                g.drawImage(ImageIO.read(new File("Menus/specials.png")),
                        60, 345, 520, 230, frame);
            } catch (Exception ex) {
            }
            try {
                g.drawImage(ImageIO.read(new File("Menus/demo.png")),
                        660, 345, 520, 230, frame);
            } catch (Exception ex) {
            }
        }
        if (menu == 2) {
            try {
                g.drawImage(ImageIO.read(new File("Menus/easy.png")),
                        180, 95, 280, 230, frame);
            } catch (Exception ex) {                
            }
            try {
                g.drawImage(ImageIO.read(new File("Menus/medium.png")),
                        790, 95, 280, 230, frame);
            } catch (Exception ex) {
            }
            try {
                g.drawImage(ImageIO.read(new File("Menus/hard.png")),
                        180, 345, 280, 230, frame);
            } catch (Exception ex) {
            }
            try {
                g.drawImage(ImageIO.read(new File("Menus/extreme.png")),
                        790, 345, 280, 230, frame);
            } catch (Exception ex) {
            }
            try {
                g.drawImage(ImageIO.read(new File("Menus/back.png")),
                        40, 570, 100, 110, frame);
            } catch (Exception ex) {
            }
        }
        if (menu == 10) {
            try {
                g.drawImage(ImageIO.read(new File("Menus/breaker.png")),
                        60, 95, 520, 230, frame);
            } catch (Exception ex) {
            }
            try {
                g.drawImage(ImageIO.read(new File("Menus/wb.png")),
                        660, 95, 520, 230, frame);
            } catch (Exception ex) {
            }
            try {
                g.drawImage(ImageIO.read(new File(
                        "Menus/powerups.png")),
                        60, 345, 520, 230, frame);
            } catch (Exception ex) {
            }
            try {
                g.drawImage(ImageIO.read(new File(
                        "Menus/comingsoon.png")),
                        660, 345, 520, 230, frame);
            } catch (Exception ex) {
            }
            try {
                g.drawImage(ImageIO.read(new File("Menus/back.png")),
                        40, 570, 100, 110, frame);
            } catch (Exception ex) {
            }
        }
        if (menu == 11) {
            try {
                g.drawImage(ImageIO.read(new File(
                        "Menus/demosingle.png")),
                        55, 95, 350, 230, frame);
            } catch (Exception ex) {
            }
            try {
                g.drawImage(ImageIO.read(new File(
                        "Menus/demotwo.png")),
                        445, 95, 350, 230, frame);
            } catch (Exception ex) {
            }
            try {
                g.drawImage(ImageIO.read(new File(
                        "Menus/demobreaker.png")),
                        55, 345, 350, 230, frame);
            } catch (Exception ex) {
            }
            try {
                g.drawImage(ImageIO.read(new File(
                        "Menus/wbdemo.png")),
                        445, 345, 350, 230, frame);
            } catch (Exception ex) {
            }
            try {
                g.drawImage(ImageIO.read(new File(
                        "Menus/powerdemo.png")),
                        835, 95, 350, 230, frame);
            } catch (Exception ex) {
            }
            try {
                g.drawImage(ImageIO.read(new File(
                        "Menus/comingsoon.png")),
                        835, 345, 350, 230, frame);
            } catch (Exception ex) {
            }
            try {
                g.drawImage(ImageIO.read(new File("Menus/back.png")),
                        40, 570, 100, 110, frame);
            } catch (Exception ex) {
            }
        }
    }

    /**
     * Handles wMode Graphics.
     *
     * @param g Passthrough
     * @param wMode Passthrough
     * @param menu Passthrough
     * @param oldScore Passthrough
     * @param score Passthrough
     */
    public static void runwMode(Graphics g, int wMode,
            int menu, int oldScore, int score) {
        if (wMode == 1 || wMode == 2) {
            g.setColor(Color.RED);
            g.fillRect(0, 0, 1280, 700);
        } else {
            g.setColor(Color.CYAN);
            g.fillRect(0, 0, 1280, 700);
        }
        if (wMode == 1) {

            g.setFont(new Font("TimesRoman", Font.PLAIN, 100));
            g.setColor(Color.BLACK);
            g.drawString("Player 1 wins!", 360, 80);
            g.drawString("Play again?", 430, 190);
            g.setColor(Color.GREEN);
            g.fillRect(300, 300, 200, 100);
            g.setColor(Color.RED.darker());
            g.fillRect(780, 300, 200, 100);
            g.setColor(Color.BLACK);
            g.drawString("Yes", 320, 380);
            g.drawString("No", 820, 380);

            addToDebugger("Player 1 wins Menu Called");

        } else if (wMode == 2) {
            g.setFont(new Font("TimesRoman", Font.PLAIN, 100));
            g.setColor(Color.BLACK);
            g.drawString("Player 2 wins!", 360, 80);
            g.drawString("Play again?", 430, 190);
            g.setColor(Color.GREEN);
            g.fillRect(300, 300, 200, 100);
            g.setColor(Color.RED.darker());
            g.fillRect(780, 300, 200, 100);
            g.setColor(Color.BLACK);
            g.drawString("Yes", 320, 380);
            g.drawString("No", 820, 380);
            addToDebugger("Player 2 wins Menu Called");

        } else if (wMode == 3) {
            addToDebugger("WMODE = 3, menu = " + menu);
            g.setColor(Color.BLACK);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 100));
            g.setColor(Color.BLACK);
            g.drawString("You win!", 450, 80);
            g.drawString("Play again?", 430, 190);
            g.setColor(Color.GREEN);
            g.fillRect(300, 300, 200, 100);
            g.setColor(Color.RED);
            g.fillRect(780, 300, 200, 100);
            g.setColor(Color.BLACK);
            g.drawString("Yes", 320, 380);
            g.drawString("No", 820, 380);

            addToDebugger("You Win Menu Called");

        } else if (wMode == 4) {
            addToDebugger("WMODE = 4, menu = " + menu);
            addToDebugger("WMODE Score: "
                    + score + "|| oldScore: " + oldScore);
            g.setColor(Color.BLACK);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 100));
            g.setColor(Color.BLACK);
            g.drawString("You lose.", 450, 80);
            g.drawString("Play again?", 430, 190);

            g.setColor(Color.GREEN);
            g.fillRect(300, 300, 200, 100);
            g.setColor(Color.RED);
            g.fillRect(780, 300, 200, 100);
            g.setColor(Color.BLACK);
            g.drawString("Yes", 320, 380);
            g.drawString("No", 820, 380);

            addToDebugger("You Lose Menu Called");

        } else if (wMode == 5) {
            addToDebugger("WMODE = 5, menu = " + menu);
            g.setColor(Color.BLACK);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 100));
            g.setColor(Color.BLACK);
            g.drawString("Play again?", 430, 190);

            g.setColor(Color.GREEN);
            g.fillRect(300, 300, 200, 100);
            g.setColor(Color.RED);
            g.fillRect(780, 300, 200, 100);
            g.setColor(Color.BLACK);
            g.drawString("Yes", 320, 380);
            g.drawString("No", 820, 380);

            addToDebugger("You Win Menu Called");

        }
    }

    /**
     * Handles Modes Graphics.
     *
     * @param mode Passthrough
     * @param run Passthrough
     * @param g Passthrough
     * @param wall2List Passthrough
     * @param ballL Passthrough
     * @param posL Passthrough
     * @param posR Passthrough
     * @param time Passthrough
     * @param time1 Passthrough
     * @param time2 Passthrough
     * @param timer Passthrough
     * @param tMode Passthrough
     * @param demo Passthrough
     */
    public static void runModes(int mode, FullGameTest run,
            Graphics g, Block[][] wall2List, Ball ballL,
            int posL, int posR, int time, int time1, int time2, boolean timer,
            int tMode, boolean demo) {
        JFrame frame = FullGameTest.frame();
        if (mode != 2 && mode != 5
                && mode != 7 && mode != 8 && mode != 0) {
            run.setBackground(Color.CYAN);
            g.setColor(Color.CYAN);
            g.fillRect(0, 0, 1280, 700);
            addToDebugger("Screen Cleared - Cyan Color");
        } else if (mode == 7 || mode == 8) {
            run.setBackground(new Color(190, 66, 244));
            g.setColor(Color.BLACK);
            g.fillRect(635, 0, 10, 980);
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 10; j++) {
                    wall2List[j][i].run2P(g, true, mode);
                }
            }
            FullGameTest.checkForBlock(ballL.x(), ballL.y());
        } else if (mode != 0) {
            g.setColor(Color.RED);
            g.fillRect(0, 0, 1280, 700);
            frame.setBackground(Color.RED);
            addToDebugger("Screen Cleared - Red Color");
        }
        g.setColor(Color.BLACK);
        if (mode != 2 && mode != 5
                && mode != 7 && mode != 8 && mode != 0) {
            g.fillRect(posL, posR, 200, 30);
        }
        if (timer && !demo && mode != 3 && mode != 4 && mode != 5
                && mode != 8 && mode != 10) {
            // System.out.println("TIMER");
            g.setFont(new Font("TimesRoman", Font.PLAIN, 400));
            g.setColor(Color.BLACK);
            if (mode != 7 && mode != 8) {
                g.drawString(Integer.toString(time), 550, 400);
            } else {
                if (tMode == 0) {
                    g.drawString(Integer.toString(time), 250, 400);
                    g.drawString(Integer.toString(time), 830, 400);
                }
                if (tMode == 2) {
                    g.drawString(Integer.toString(time1), 250, 400);
                }
                if (tMode == 3) {
                    g.drawString(Integer.toString(time2), 830, 400);
                }
            }
        }

    }

    /**
     * Handles Other Graphics.
     *
     * @param g Passthrough
     * @param debug Passthrough
     * @param mode Passthrough
     * @param menu Passthrough
     * @param overRide Passthrough
     */
    public static void runOthers(Graphics g, boolean debug, int mode,
            int menu, boolean overRide) {
        if (debug) {
            if (mode != 2 && mode != 5 && mode != 7
                    && mode != 8 && mode != 9 && mode != 10 || menu != -1) {
                g.setColor(Color.RED);
            } else {
                g.setColor(Color.CYAN);
            }
            g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
            addToDebugger("paintComponent method called");
            g.drawString("Debug Mode Enabled", 15, 650);
        }
        if (overRide) {
            g.setColor(Color.RED);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
            g.drawString("Override Enabled", 15, 30);
        }
    }

    /**
     * Handles PowerUps Graphics.
     *
     * @param g Passthrough
     * @param power Passthrough
     * @param img Passthrough
     * @param mode Passthrough
     * @param speed Passthrough
     * @param run Passthrough
     */
    public static void runPowerUps(Graphics g, int power, BufferedImage img,
            int mode, int speed, FullGameTest run) {
        g.setFont(new Font("TimesRoman", Font.PLAIN, 100));
        g.setColor(Color.BLACK);
        if (power == 1) {
            g.drawString("EXTENDED BAR!", 300, 300);
        } else if (power == 2) {
            g.drawString("SLOWER BALL!", 300, 300);
        } else if (power == 3) {
            g.drawString("FASTER BALL!", 300, 300);
        } else if (power == 4) {
            g.drawString("FLASHING SCREEN!", 300, 300);
        } else if (power == 5) {
            g.drawString("MULTIPLE BALLS!", 300, 300);
            // run.runBall(g, img, mode, speed);
        } else if (power == 6) {
            g.drawString("PLATFORM MINI-GUN!", 100, 300);
        }
    }

    /**
     * Handles Scoreboard Graphics.
     *
     * @param g Passthrough
     * @param menu Passthrough
     * @param pause Passthrough
     * @param score Passthrough
     * @param mode Passthrough
     */
    public static void printScoreMenu(Graphics g, int menu,
            boolean pause, int score, int mode) {
        if (menu == -1 && mode == 1 || menu == -1 && mode == 3) {
            addToDebugger("Score menu printed");
            if (!pause) {
                FullGameTest.incScore();
            }
            g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
            g.setColor(Color.BLACK);
            g.drawString("Score: " + score, 1150, 30);
        }
    }

    /**
     * Handles Other Graphics.
     *
     * @param g Passthrough
     * @param speed Passthrough
     * @param ball Passthrough
     * @param mode Passthrough
     * @param total Passthrough
     * @param finished Passthrough
     * @param overRide Passthrough
     * @param posL Passthrough
     * @param posR Passthrough
     */
    public static void notBlank(Graphics g, int speed, Ball ball, int mode,
            int total, boolean finished, boolean overRide,
            int posL, int posR) {
        try {
            Thread.sleep(speed);
        } catch (InterruptedException ex) {
        }
        if (mode == 4 || mode == 6 || mode == 10) {
            if (0 < ball.x() - 100 && ball.x() - 100 < 1080) {
                setPosL(ball.x() - 100);
            }
            if (mode == 4 || mode == 10) {
                if (total == 20 && !finished || overRide) {
                    setFinished(true);
                    addToDebugger("Total + Finished Complete");
                    gameOver(5);
                }
            }
            g.fillRect(posL, posR, 200, 30);
        }

    }

    /**
     * Handles Keyboard Inputs.
     *
     * @param mode Passthrough
     * @param arrLPressed Passthrough
     * @param arrRPressed Passthrough
     * @param wPressed Passthrough
     * @param sPressed Passthrough
     * @param upPressed Passthrough
     * @param downPressed Passthrough
     * @param run Passthrough
     * @param pause Passthrough
     */
    public static void keyboardInputs(int mode, boolean arrLPressed,
            boolean arrRPressed, boolean wPressed, boolean sPressed,
            boolean upPressed, boolean downPressed, FullGameTest run,
            boolean pause) {
        // System.out.println("Keyboard Inputs!");
        if (mode == 1 || mode == 3 || mode == 9) {
            if (arrLPressed) {
                // System.out.println("LEFT ARROW");
                addToDebugger("Left Arrow Pressed");
                run.platmoveLeft();
            }
            if (arrRPressed) {
                run.platmoveRight();
                addToDebugger("Right Arrow Pressed");
            }
        }
        if (mode == 2 || mode == 7) {
            if (wPressed) {
                run.platmove2Up();
                addToDebugger("W Key Pressed");
            }
            if (sPressed) {
                run.platmove2Down();
                addToDebugger("S Key Pressed");
            }
            if (upPressed) {
                run.platmove3Up();
                addToDebugger("Up Key Pressed");

            }
            if (downPressed) {
                run.platmove3Down();
                addToDebugger("Down Key Pressed");
            }
        }
        if (!pause) {
            incScore();
        }
    }
}
