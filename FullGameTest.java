import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import java.io.PrintWriter;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Pong, pong, pong, ping End of Year AP Computer Science Project and Learn
 * Better Project Pictures are property of Nintendo and their creators Emoji
 * Images are property of Apple Inc. and their creators Video method not created
 * by Matty Wolfson
 * 
 * @author Matty Wolfson
 * @version CURRENT
 * 
 */
public class FullGameTest extends JPanel implements
        KeyListener, MouseListener, ActionListener {

    private static JFrame frame = new JFrame();
    private static FullGameTest run = new FullGameTest();
    private static ArrayList<BufferedImage> imgArr;
    private static int[] posList = new int[10];
    private static BufferedImage img = null;
    private static boolean finished = false;
    private static ArrayList<Block> blockList = new ArrayList<Block>();
    private static Graphics g;
    private static int total = 0;
    private static Ball ball;
    private static Ball ballL;
    private static Ball ballR;
    private static int posL = 540;
    private static int posR = 640;
    private static int pos2L = 10;
    private static int pos2R = 250;
    private static int pos3R = 250;
    private static int score = 0;
    private static int menu = 0;
    private static boolean arrLPressed = false;
    private static boolean upPressed = false;
    private static boolean downPressed = false;
    private static boolean arrRPressed = false;
    private static boolean wPressed = false;
    private static boolean sPressed = false;
    private static int blockType;
    private static boolean started;
    private static boolean overRide = false;
    private static int sp = 0;
    private static int mode = 0;
    private static int wMode = 0;
    private static boolean debug = false;
    private static int oldScore = 0;
    private static PrintWriter writer;
    private static PrintWriter scores;
    private static List<String> scoresArr;
    private static String name = "";
    private static int time = 3;
    private static int time1 = 3;
    private static int time2 = 3;
    private static boolean timer = false;
    private static boolean compl = false;
    private static int tMode = 0;
    private static Timer timer0;
    private static Timer timer1;
    private static Timer timer2;
    private static int lifeCountL = 3;
    private static int lifeCountR = 3;
    private static int power = 0;
    private static boolean powerUp = false;
    private static int barLength = 200;
    private static int imgX = 40;
    private static int imgY = 95;
    private static int p2img = 1;
    private static int p1img = 1;
    private static boolean flashb = false;
    private static int flash = 0;
    private static boolean demo = false;
    private static int posit = 0;
    private static boolean recent = true;
    private Block[][] trumpList = new Block[10][3];
    private Block[][] wall2List = new Block[10][6];
    private int pos3L = 1240;
    private boolean blank = false;
    private int speed = 0;
    private static boolean pause = true;

    /**
     * JFrame method.
     * 
     * @return JFrame returns frame
     */
    public static JFrame frame() {
        return frame;
    }

    /**
     * Run Method.
     * 
     * @return FullGameTest returns run variable
     */
    public static FullGameTest run() {
        return run;
    }

    /**
     * Main Method, calls buttons method and reads in scoreboard.
     * 
     * @param args Command Line not used
     */
    public static void main(String[] args) {
        // executeVideo(1);

        imgArr = new ArrayList<BufferedImage>();
        if (debug) {
            ImageLoader.loadImage(true, writer);
        } else {
            imgArr = ImageLoader.loadImageNoDebug();
        }
        // run.debugMode();
        menu = 0;
        buttons();
        Path scorebp = Paths.get("scoreboard.txt");
        try {
            scoresArr = Files.readAllLines(scorebp);
        } catch (Exception ex) {
            System.out.println("Exception caught: " + ex);
        }
    }

    /**
     * Resets variables back to default after game ends.
     */
    public void reset() {
        if (!compl) {
            compl = true;
            addToDebugger("Reset Method Called");
            trumpList = new Block[10][3];
            posList = new int[10];
            finished = false;
            if (mode != 7 && mode != 8) {
                FullGameTest.ball.changePos(625, 335);
            } else {
                FullGameTest.ballL.changePos(40, 335);
                name = "";
                FullGameTest.ballR.changePos(1210, 335);
                ballR.setDouble();
            }
            total = 0;
            pos3L = 1240;
            pos3R = 250;
            score = 0;
            if (mode != 7) {
                ball.reset();
            } else {
                try {
                    FullGameTest.ballL.reset();
                    FullGameTest.ballR.reset();
                    ballR.setDouble();
                } catch (StackOverflowError ex) {
                    addToDebugger("Stack Overflow error ball.reset");
                }
            }
            blank = false;
            posL = 540;
            posR = 640;
            pos2L = 10;
            pos2R = 250;
            speed = 0;
            menu = 0;
            sp = 0;
            wMode = 0;
            addToDebugger("Reset method Completed");
            buttons();
        }
    }

    /**
     * Sets Main Layout, frame settings and other parameters.
     */
    public static void buttons() {
        run = new FullGameTest();
        frame = new JFrame();
        blockList = new ArrayList<Block>();
        finished = false;
        JFrame.setDefaultLookAndFeelDecorated(false);
        run.setEnabled(true);
        frame.setTitle("Pong, Pong, Pong, Ping");
        frame.setResizable(false);
        run.setFocusable(true);
        run.setFocusable(true);
        run.setLayout(new BorderLayout());
        switch (sp) {
            case 1:
                run.speed = 75;
                break;
            case 2:
                run.speed = 60;
                break;
            case 3:
                run.speed = 45;
                break;
            case 4:
                run.speed = 30;
                break;
        }
        frame.repaint();
        frame.setContentPane(run);
        frame.setSize(1280, 700);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.CYAN);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.addKeyListener(run);
        frame.addMouseListener(run);
        frame.setFocusable(true);
        frame.requestFocusInWindow();
        posL = 540;

    }

    /**
     * Main Run Method, sets titles and other parameters.
     * 
     * @param blockType2 Updates images
     * @param frame2 Takes in frame from prior method
     * @param mode2 Updates mode with selected mode
     */
    public static void run(int blockType2, JFrame frame2, int mode2) {
        addToDebugger("RUN METHOD");
        addToDebugger("Run Method Called");
        mode = mode2;
        blockType = blockType2;
        if (mode != 3 && mode != 6) {
            frame.setTitle("Play!");
        } else {
            frame.setTitle("Wall Builder!");
        }
        JFrame.setDefaultLookAndFeelDecorated(true);
        img = FullGameTest.imgArr.get(blockType - 1);

        frame.setSize(1280, 700);
        if (mode != 2 && mode != 5) {
            if (mode != 3 && mode != 6) {
                for (int i = 70; i < 1160; i = i + 110) {
                    for (int j = 0; j < 180; j = j + 70) {
                        if (mode == 9 || mode == 10) {
                            int rnum = (int) (Math.random() * 20);
                            if (rnum > 6) {
                                rnum = 0;
                            }
                            // rnum = 5;
                            // rnum = 4;
                            // System.out.println(rnum);
                            Block b = new Block(i, j, rnum);
                            blockList.add(b);
                        } else {
                            Block b = new Block(i, j);
                            blockList.add(b);
                        }
                    }
                }
                addToDebugger("Blocks ArrayList created");
            } else {
                int p = 0;
                int p1 = 70;
                for (int i = 0; i < 3; i++) {
                    p1 = 70;
                    for (int j = 0; j < 10; j++) {
                        run.trumpList[j][i] = new Block(p1, p);
                        p1 = p1 + 110;
                        // run.trumpList[j][i].getStatus();
                    }
                    p = p + 70;
                }
                addToDebugger("0,1 " + run.trumpList[0][1].posX1()
                        + "  " + run.trumpList[0][1].posY1());
            }
            addToDebugger("ARR SIZE" + blockList.size());
        }

        if (mode == 7 || mode == 8) {
            int p1 = 290;
            int p = 10;
            for (int i = 0; i < 6; i++) {
                p1 = 290;
                for (int j = 0; j < 10; j++) {
                    // System.out.println("P1: " + p1 + " p: " + p);
                    run.wall2List[j][i] = new Block(p1, p);
                    if (j == 3 || j == 4 || j == 5 || j == 6) {
                        run.wall2List[j][i].changeStatus();
                    }
                    if (j == 4) {
                        p1 = p1 + 80;
                    } else {
                        p1 = p1 + 70;
                    }
                }
                p = p + 110;
            }
        }
        for (int i = 0; i < 9; i++) {
            posList[i] = 0;
        }
        frame.setVisible(true);
        if (mode == 7 || mode == 8 || demo) {
            FullGameTest.ballL = new Ball(mode);
            FullGameTest.ballL.changePos(40, 335);
            FullGameTest.ballR = new Ball(mode);
            FullGameTest.ballR.setDouble();
            FullGameTest.ballR.startAngle(true);
            FullGameTest.ballR.changePos(1210, 335);
        } else {
            FullGameTest.ball = new Ball(mode);
            if (mode == 2 || mode == 5) {
                FullGameTest.ball.changePos(625, 335);
            }
        }
        started = false;
        finished = false;
        frame.setIgnoreRepaint(false);
        addToDebugger("Run method completed");
        ball = new Ball(mode);
        // start = true;
        timer0 = new Timer(1000, run);
        timer0.start();
        timer = true;
        if (mode == 7 || mode == 8) {
            // timerL = true;
            // timerR = true;
            ballL.flipY();

        }
    }

    /**
     * Sets the posL.
     * 
     * @param posL2 New value for posL.
     */
    public static void setPosL(int posL2) {
        posL = posL2;
    }

    /**
     * Sets the finished boolean.
     * 
     * @param newFinished New value for finished boolean.
     */
    public static void setFinished(boolean newFinished) {
        finished = newFinished;
    }

    /**
     * Adds text to debugger.
     * 
     * @param text Text to add to debugger.
     */
    public static void addToDebugger(String text) {

        if (debug) {
            System.out.println("DEBUG: " + text);
            Date dNow = new Date();
            SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ssa");
            String strDate = ft.format(dNow).toString();
            writer.println(strDate + ": " + text);
        }
    }

    /**
     * Main Painting Method - Constantly Updates the Screen.
     * 
     * @param g2 Graphics engine
     */
    public void paintComponent(Graphics g2) {

        g = g2;
        try {
            Thread.sleep(10);
        } catch (Exception ex) {
        }
        addToDebugger("paintComponent menu: " + menu);
        if (flash % 4 != 0 || !flashb) {
            PaintMenus.runMenus(g2, menu, frame, mode, imgX,
                    imgY, imgArr, name, score, scoresArr, wMode, oldScore);
            if (menu == -1) {
                PaintMenus.runModes(mode, run, g, wall2List,
                        ballL, posL, posR, time, time1, time2, timer, tMode,
                        demo);
                if (!blank) {
                    PaintMenus.notBlank(g2, speed, ball, mode, total, finished,
                            overRide, posL, posR);
                    PaintMenus.keyboardInputs(mode, arrLPressed, arrRPressed,
                            wPressed, sPressed, upPressed, downPressed, run,
                            pause);
                    if (mode != 2 && mode != 5
                            && mode != 7 && mode != 8 && mode != 0) {
                        frame.setBackground(Color.CYAN);
                        platformCreate();
                        if (mode != 3 && mode != 6) {
                            for (int i = 0; i < blockList.size(); i++) {
                                blockList.get(i).run(g, mode);
                            }
                            img = imgArr.get(p1img);
                            ball.run(g, img, mode, speed);
                            checkForBlock(ball.x(), ball.y());
                            if (blockList.size() == 0 && !finished
                                    || overRide && !finished) {
                                finished = true;
                                gameOver(3);
                            }
                        } else if (mode == 3 || mode == 6) {
                            try {
                                Thread.sleep(30);
                            } catch (Exception ex) {
                            }
                            for (int i = 0; i < 3; i++) {
                                for (int j = 0; j < 10; j++) {
                                    trumpList[j][i].run(g, true, mode);
                                }
                            }
                            ball.run(g, imgArr.get(p1img), mode, speed);
                            total = 0;
                            for (int i = 0; i < 10; i++) {
                                if (posList[i] >= 2) {
                                    posList[i] = 2;
                                }
                                total = posList[i] + total;
                            }
                            if (total == 20 && !finished || overRide) {
                                finished = true;
                                addToDebugger("Total + Finished Complete");
                                gameOver(3);
                            }
                        }
                    } else if (mode == 5 || mode == 8 || mode == 7) {
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException ex) {
                            addToDebugger("Exception Thrown: Line 1039: " + ex);
                        }
                        if (mode == 5) {
                            ball.run(g, imgArr.get(p1img), mode, speed);
                            if (0 < FullGameTest.ball.y() - 100
                                    && FullGameTest.ball.y() - 100 < 640) {
                                pos2R = ball.y() - 85;
                                g.fillRect(pos2L, pos2R, 30, 200);

                                pos3R = ball.y() - 85;
                                g.fillRect(pos3L, pos3R, 30, 200);
                            } else {
                                g.fillRect(pos2L, 0, 30, 200);
                                g.fillRect(pos3L, 0, 30, 200);

                            }
                        } else if (mode == 7) {
                            platformLCreate();
                            platformRCreate();
                            ballL.run(g, imgArr.get(p1img), mode, speed);
                            ballR.run(g, imgArr.get(p2img), mode, speed);
                            for (int i = 0; i < lifeCountR; i++) {
                                try {
                                    g.drawImage(ImageIO.read(new File(
                                            "120px-Brick_Block.png")),
                                            1200 + 20 * i,
                                            10, 15, 15, frame);
                                } catch (IOException ex) {
                                    addToDebugger("No image found");
                                }
                            }
                            for (int i = 0; i < lifeCountL; i++) {
                                try {
                                    g.drawImage(ImageIO.read(new File(
                                            "120px-Brick_Block.png")),
                                            20 + 20 * i,
                                            10, 15, 15, frame);
                                } catch (IOException ex) {
                                    addToDebugger("No image found");
                                }
                            }
                        } else if (mode == 8) {
                            ballL.run(g, imgArr.get(p1img), mode, speed);
                            ballR.run(g, imgArr.get(p2img), mode, speed);
                            if (0 < ballR.y() - 100
                                    && ballR.y() + 60 < 640) {
                                pos3R = ballR.y() - 100;
                                g.fillRect(1240, pos3R, 30, 200);
                            } else {
                                g.fillRect(1240, pos3R, 30, 200);
                            }
                            if (0 < ballL.y() - 100
                                    && ballL.y() + 60 < 640) {
                                pos2R = ballL.y() - 100;
                                g.fillRect(10, pos2R, 30, 200);
                            } else {
                                g.fillRect(10, pos2R, 30, 200);
                            }
                        }
                    } else if (mode == 2 || mode == 5) {
                        frame.setBackground(Color.RED);
                        try {
                            Thread.sleep(20); // 20
                        } catch (InterruptedException ex) {
                        }
                        platformLCreate();
                        platformRCreate();
                        ball.run(g, imgArr.get(p1img), mode, speed);
                    }
                } else {
                    run.blank = false;
                }
                run.repaint();
            }
            PaintMenus.runOthers(g, debug, mode, menu, overRide);
            PaintMenus.printScoreMenu(g, menu, pause, score,
                    mode);
            if (powerUp) {
                PaintMenus.runPowerUps(g, power, imgArr.get(p1img), mode, speed,
                        run);
            }
        }
    }

    /**
     * Increases the score by 1.
     */
    public static void incScore() {
        score++;
    }

    /**
     * Action Listener Method.
     * 
     * @param e Action listener input
     */
    public void actionPerformed(ActionEvent e) {
        if (timer) {
            // System.out.println("Timed");
            if (tMode == 0) {
                time--;
            }
            if (tMode == 2) {
                time1--;
            }
            if (tMode == 3) {
                time2--;
            }
            if (time == 0 || time1 == 0 || time2 == 0) {
                if (time == 0) {
                    time = 3;
                }
                if (time1 == 0) {
                    time1 = 3;
                }
                if (time2 == 0) {
                    time2 = 3;
                }
                timer = false;
                pause = false;
                if (tMode == 2) {
                    ballL.changePos(50, 335);
                    ballL.startAngle(false);
                    // ballL.flipY();
                }
                if (tMode == 3) {
                    ballR.changePos(1210, 335);
                    ballR.startAngle(true);
                    ballR.setDouble();
                }
                // timerL = false;
                // timerR = false;
            }
        }
    }

    /**
     * KeyListener method.
     * 
     * @param e Keylistener input
     */
    public void keyPressed(KeyEvent e) { // KeyListener
        // System.out.println(e);
        addToDebugger("keyPressed method called: " + e);
        if (menu != 2 && menu != 5) {
            String temp = "";
            if (menu == 8) {
                if ((int) e.getKeyCode() == 8 && name.length() >= 1) {
                    // System.out.println("BACKSPACE");
                    name = name.substring(0, name.length() - 1);
                } else {
                    // System.out.println("CHAR: " + e.getKeyChar());
                    temp = Character.toString(e.getKeyChar());
                    // System.out.println("TEMP: " + temp);
                    name = name + temp.substring(0, 1);
                }
                // prev++;
                // System.out.println("NAME: " + name);
                repaint();
            }
        }
        switch (e.getKeyCode()) {
            case 79:
                run.overRide();
                break;
            case 84:
                if (mode != 7 && mode != 8) {
                    ball.startAngle(false);
                } else {
                    ballL.startAngle(false);
                    ballR.startAngle(true);
                    ballR.setDouble();
                }
                break;
            case 68:
                run.debugMode();
                break;
            case 37:
                arrLPressed = true;
                break;
            case 39:
                arrRPressed = true;
                break;
            case 27:
                run.exitGame();
                break;
            case 81:
                run.exitGame();
                break;
            case 87:
                wPressed = true;
                break;
            case 83:
                sPressed = true;
                break;
            case 38:
                upPressed = true;
                break;
            case 40:
                downPressed = true;
                break;
            case 80:
                if (!pause) {
                    pause = true;
                } else {
                    pause = false;
                }
                break;
            case 10:
                menu = 4;
                addToDebugger("ENTER");
                scoresArr.add(score + "," + name);
                repaint();
                break;
        }
    }

    /**
     * Keylistener method.
     * 
     * @param e Keylistener input
     */
    public void keyReleased(KeyEvent e) {
        addToDebugger("keyReleased method called: " + e);
        switch (e.getKeyCode()) {
            case 37:
                arrLPressed = false;
                break;
            case 39:
                arrRPressed = false;
                break;
            case 87:
                wPressed = false;
                // System.out.println("W CHANGE");
                break;
            case 83:
                sPressed = false;
                // System.out.println("S CHANGE");
                break;
            case 38:
                upPressed = false;
                break;
            case 40:
                downPressed = false;
                break;
        }
    }

    /**
     * Keeps track of Life Counts and timers.
     * 
     * @param player Player to deduct life off of
     */
    public void lifeCounts(int player) {
        if (player == 1) {
            addToDebugger(lifeCountL + " L");
            tMode = 2;
            lifeCountL--;
            if (lifeCountL > 0) {
                timer = true;
                timer1 = new Timer(1000,
                        new ActionListener() {
                            public void actionPerformed(
                                    ActionEvent evt) {
                                time1--;
                                if (time1 <= 0) {
                                    timer1.stop();
                                    timer = false;
                                    time1 = 3;
                                }
                            }
                        });
            } else {
                gameOver(2);
            }
        } else {
            tMode = 3;
            lifeCountR--;
            addToDebugger(lifeCountR + " R");
            if (lifeCountR > 0) {
                timer = true;
                timer2 = new Timer(1000,
                        new ActionListener() {
                            public void actionPerformed(
                                    ActionEvent evt) {
                                time2--;
                                if (time2 <= 0) {
                                    timer2.stop();
                                    timer = false;
                                    time2 = 3;
                                }
                            }
                        });
            } else {
                gameOver(1);
            }
        }
    }

    /**
     * Extra Keylistener method.
     * 
     * @param e Keylistener input
     */
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Creates bottom platform.
     */
    public void platformCreate() {
        // System.out.println("PLAT CREATED");
        g.fillRect(posL, posR, barLength, 30);
    }

    /**
     * Creates left platform.
     */
    public void platformLCreate() {
        g.fillRect(pos3L, pos3R, 30, 200);
    }

    /**
     * Creates right platform.
     */
    public void platformRCreate() {
        g.fillRect(pos2L, pos2R, 30, 200);
    }

    /**
     * Returns bar length.
     * 
     * @return int Returns barLength
     */
    public int getBarLength() {
        return barLength;
    }

    /**
     * Returns left positon of platform.
     * 
     * @return int Left position of platform
     */
    public int platL() {
        return posL;
    }

    /**
     * Returns right position of platform.
     * 
     * @return int Right position of platform
     */
    public int platR() {
        return posR;
    }

    /**
     * Returns right position of platform 2.
     * 
     * @return int Right position of platform 2
     */
    public int plat2R() {
        return pos2R;
    }

    /**
     * Returns left position of platform 2.
     * 
     * @return int left position of platform 2
     */
    public int plat2L() {
        return pos2L;
    }

    /**
     * Returns left position of platform 3.
     * 
     * @return int left position of platform 3
     */
    public int plat3L() {
        return pos3L;
    }

    /**
     * Returns right position of platform 3.
     * 
     * @return int right position of platform 3
     */
    public int plat3R() {
        return pos3R;
    }

    /**
     * Moves platform to the left.
     */
    public void platmoveLeft() {
        // System.out.println("LEFT!");
        addToDebugger("platmoveLeft called");
        if (!started) {
            addToDebugger("STARTED");
            ball.run(g, imgArr.get(p1img), mode, speed);
            started = true;
        }
        if (posL > 0) {
            posL = posL - 30;
            g.fillRect(posL, posR, barLength, 30);
            run.repaint();
        } else {
            addToDebugger("platformLeft out of bounds!");
        }
    }

    public boolean getPause() {
        return pause;
    }

    /**
     * Moves platform to the right.
     */
    public void platmoveRight() {
        // System.out.println("RIGHT");
        addToDebugger("platmoveRight called");
        if (!started) {
            addToDebugger("STARTED");
            ball.run(g, imgArr.get(p1img), mode, speed);
            started = true;
        }
        if (posL < 1080) {
            posL = posL + 30;
            g.fillRect(posL, posR, barLength, 30);
            repaint();
        } else {
            addToDebugger("platformRight out of bounds");
        }
    }

    /**
     * Moves platform 2 up.
     */
    public void platmove2Up() {
        addToDebugger("platmove2Up called");
        if (!started) {
            if (mode != 7 && mode != 8) {
                ball.run(g, imgArr.get(p1img), mode, speed);
            } else {
                ballR.run(g, imgArr.get(p2img), mode, speed);
                ballL.run(g, imgArr.get(p1img), mode, speed);
            }
            started = true;
        }
        if (pos2R > 0) {
            pos2R = pos2R - 30;
            addToDebugger("platform2Up pos2R: " + pos2R + "|| pos2L: " + pos2L);
            g.fillRect(pos2L, pos2R, 30, 200);
            // System.out.println("MOVED");
            repaint();
        } else {
            addToDebugger("platmove2Up Out of bounds");
        }
    }

    /**
     * Moves platform 2 down.
     */
    public void platmove2Down() {
        addToDebugger("platmove2Down called");
        if (!started) {
            addToDebugger("STARTED");
            if (mode != 7 && mode != 8) {
                ball.run(g, imgArr.get(p1img), mode, speed);
            } else {
                ballR.run(g, imgArr.get(p2img), mode, speed);
                ballL.run(g, imgArr.get(p1img), mode, speed);
            }
            started = true;
        }
        if (pos2R < 500) {
            pos2R = pos2R + 30;
            addToDebugger(
                    "platform2Down pos2R: "
                            + pos2R + "|| pos2L: " + pos2L);
            g.fillRect(pos2L, pos2R, 30, 200);
            repaint();
        } else {
            addToDebugger("platform2Down out of bounds");
        }
    }

    /**
     * Moves platform 3 up.
     */
    public void platmove3Up() {
        addToDebugger("platmove3Up called");
        if (!started) {
            if (mode != 7 && mode != 8) {
                ball.run(g, imgArr.get(p1img), mode, speed);
            } else {
                ballR.run(g, imgArr.get(p2img), mode, speed);
                ballL.run(g, imgArr.get(p1img), mode, speed);
            }
            started = true;
        }
        if (pos3R > 0) {
            pos3R = pos3R - 30;
            g.fillRect(pos3L, pos3R, 30, 200);
            addToDebugger("platform3Up pos3R: " + pos3R + "|| pos3L: " + pos3L);
            repaint();
        } else {
            addToDebugger("platform3Up out of bounds");
        }
    }

    /**
     * Moves platform 3 down.
     */
    public void platmove3Down() {
        addToDebugger("platmove3Down called");
        if (!started) {
            addToDebugger("STARTED");
            if (mode != 7 && mode != 8) {
                ball.run(g, imgArr.get(p1img), mode, speed);
            } else {
                ballR.run(g, imgArr.get(p2img), mode, speed);
                ballL.run(g, imgArr.get(p1img), mode, speed);
            }
            started = true;
        }
        if (500 > pos3R) {
            pos3R = pos3R + 30;
            g.fillRect(pos3L, pos3R, 30, 200);
            addToDebugger(
                    "platform3Down pos3R: " + pos3R + "|| pos3L: " + pos3L);
            repaint();
        } else {
            addToDebugger("platform3Down out of bounds");
        }
    }

    /**
     * Checks to see if there is a block at x,y.
     * 
     * @param x X coord to check for block
     * @param y Y coord to check for block
     * @return boolean Returns true if there is a block
     */
    public static boolean checkForBlock(int x, int y) {
        addToDebugger("checkForBlock method called with x: "
                + x + "|| y: " + y);
        if (mode != 3 && mode != 6) {
            if (mode != 7 && mode != 8) {
                for (int i = 0; i < blockList.size(); i++) {
                    if (blockList.get(i).posX1() <= x
                            && blockList.get(i).posX2() >= x
                            && blockList.get(i).posY1() <= y
                            && blockList.get(i).posY2() >= y) {
                        removeBlock(i);
                        return true;
                    }
                }
            } else {
                for (int i = 0; i < 6; i++) {
                    for (int j = 0; j < 10; j++) {
                        if (run.wall2List[j][i].posX1() <= x
                                && run.wall2List[j][i].posX2() >= x
                                && run.wall2List[j][i].posY1() <= y
                                && run.wall2List[j][i].posY2() >= y
                                || run.wall2List[j][i].posX1() <= (x + 30)
                                        && run.wall2List[j][i]
                                                .posX2() >= (x + 30)
                                        && run.wall2List[j][i]
                                                .posY1() <= (y + 30)
                                        && run.wall2List[j][i]
                                                .posY2() >= (y + 30)) {
                            if (run.wall2List[j][i].getStatus()) {
                                run.wall2List[j][i].setStatus(false);
                                FullGameTest.ballL.flipY();
                            }
                        }
                    }
                }
            }
        } else {
            for (int m = 0; m < 3; m++) {
                for (int j = 0; j < 10; j++) {
                    if (run.trumpList[j][m].posX1() <= x
                            && run.trumpList[j][m].posX2() >= x
                            && run.trumpList[j][m].posY1() <= y
                            && run.trumpList[j][m].posY2() >= y) {
                        if (run.trumpList[j][m].getStatus()) {
                            ball.flipX();
                        }
                    }
                }
            }

        }
        addToDebugger("checkforBlock method completed");
        return false;
    }

    /**
     * Removes blocks.
     * 
     * @param blockNumber Block ID to be removed
     */
    public static void removeBlock(int blockNumber) {
        addToDebugger("Removed: " + blockNumber);
        if (mode == 9 || mode == 10) {
            run.powerUps(blockList.get(blockNumber).powers());
        }
        blockList.remove(blockNumber);
        if (mode != 7 || mode != 8) {
            ball.flipX();
        } else {
            FullGameTest.ballL.flipX();
        }
    }

    /**
     * Executes video intro. (not my method)
     * 
     * @param num Video parameter
     */
    public static void executeVideo(int num) {
        addToDebugger("executeVideo Method called");
        // VideoPlayer video = new VideoPlayer();
        // VideoPlayer.exec(num);
    }

    /**
     * Handles End-game procedures.
     * 
     * @param wModeOver End Mode #
     */
    public static void gameOver(int wModeOver) {
        addToDebugger("gameOver Method called with wModeOver: "
                + wModeOver);
        arrLPressed = false;
        arrRPressed = false;
        upPressed = false;
        downPressed = false;
        wPressed = false;
        sPressed = false;
        if (mode == 1) {
            ArrayList<Integer> intList = new ArrayList<Integer>();
            ArrayList<String> scoresTemp = new ArrayList<String>();
            String[][] temp = new String[2][scoresArr.size()];
            for (int i = 0; i < scoresArr.size(); i++) {
                for (int j = 0; j < scoresArr.get(i).length(); j++) {
                    if (scoresArr.get(i).charAt(j) == ',') {
                        temp[0][i] = scoresArr.get(i).substring(0, j);
                        temp[1][i] = scoresArr.get(i).substring(
                                j + 1, scoresArr.get(i).length());
                    }
                }
            }
            for (int i = 0; i < scoresArr.size() - 1; i++) {
                try {
                    intList.add(Integer.parseInt(temp[0][i]));
                } catch (Exception ex) {
                    addToDebugger("EXCEPTION CAUGHT: " + ex);
                }
            }
            Collections.sort(intList, Collections.reverseOrder());
            for (int i = 0; i < intList.size(); i++) {
                for (int j = 0; j < intList.size(); j++) {
                    if (Integer.toString(intList.get(i)).equals(temp[0][j])) {
                        scoresTemp.add(intList.get(i) + "," + temp[1][j]);
                        temp[0][j] = null;
                        temp[1][j] = null;
                    }
                }
            }
            scoresArr = scoresTemp;
        }
        if (!demo) {
            FullGameTest.pause = true;
            // double again = 90;
            addToDebugger("MODE: " + mode);
            if (mode == 2 || mode == 3 || mode == 5 || mode == 7 || mode == 9) {
                menu = 4;
            }
            wMode = wModeOver;
            if (mode == 4 || mode == 5
                    || mode == 6 || mode == 8 || mode == 10) {
                menu = 4;
                wMode = 5;
            }
            if (mode == 1) {
                menu = 8;
            }
        }
        run.repaint();
    }

    /**
     * Checks for column #.
     * 
     * @param x X coord of ball
     * @return int Returns column number.
     */
    public static int columnCheck(int x) {
        addToDebugger("columnCheck method called with x: " + x);
        int status = 11;
        if ((x + 60) >= 70 && x <= 180) {
            status = 0;
        }
        if ((x + 60) >= 180 && x <= 290) {
            status = 1;
        }
        if ((x + 60) >= 290 && x <= 400) {
            status = 2;
        }
        if ((x + 60) >= 400 && x <= 510) {
            status = 3;
        }
        if ((x + 60) >= 510 && x <= 620) {
            status = 4;
        }
        if ((x + 60) >= 620 && x <= 730) {
            status = 5;
        }
        if ((x + 60) >= 730 && x <= 840) {
            status = 6;
        }
        if ((x + 60) >= 840 && x <= 950) {
            status = 7;
        }
        if ((x + 60) >= 950 && x <= 1060) {
            status = 8;
        }
        if ((x + 60) >= 1060 && x <= 1170) {
            status = 9;
        }
        if (x < 70 || x > 1170) {
            status = 11;
        }
        // addB(status);
        addToDebugger(
                "columnCheck method completed with x: "
                        + x + " and status: " + status);
        return status;
    }

    /**
     * Checks columns for two player.
     * 
     * @return boolean Returns if there is a column
     */
    public static boolean colCheck2P() {
        addToDebugger("colCheck2P Method Called");
        boolean status = false;
        int xPos = 5;

        for (int x = 650; x <= 930; x += 70) {
            int yPos = 0;
            for (int y = 30; y <= 690; y += 110) {
                // System.out.println("X: " + x + " | Y: " + y);

                if (ballR.x() > x && ballR.x() <= x + 60) {
                    if (ballR.y() > y && ballR.y() <= y + 100) {
                        if (xPos != 0) {
                            if (run.wall2List[xPos - 1][yPos].getStatus()) {
                                run.wall2List[xPos][yPos].changeStatus();
                                ballR.reflect();
                                status = true;
                            }
                        } else {
                            if (!run.wall2List[xPos][yPos].getStatus()) {
                                run.wall2List[xPos][yPos].changeStatus();
                                ballR.reflect();
                                status = true;
                            }
                        }
                    }
                }
                yPos++;
            }
            xPos++;
        }
        if (run.wall2List[7][0].getStatus()
                && run.wall2List[7][1].getStatus()
                && run.wall2List[7][2].getStatus()
                && run.wall2List[7][3].getStatus()
                && run.wall2List[7][4].getStatus()
                && run.wall2List[7][5].getStatus()
                || !run.wall2List[3][0].getStatus()
                        && !run.wall2List[3][1].getStatus()
                        && !run.wall2List[3][2].getStatus()
                        && !run.wall2List[3][3].getStatus()
                        && !run.wall2List[3][4].getStatus()
                        && !run.wall2List[3][5].getStatus()) {
            addToDebugger("ARRAY MOVED");
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 6; j++) {
                    addToDebugger(
                            Boolean.toString(run.wall2List[i][j].getStatus()));
                }
                addToDebugger("");
            }

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 6; j++) {
                    run.wall2List[i][j].setStatus(
                            run.wall2List[i + 1][j].getStatus());
                }
            }
            addToDebugger("");
            addToDebugger("");
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 6; j++) {
                    addToDebugger(
                            Boolean.toString(run.wall2List[i][j].getStatus()));
                }
                addToDebugger("");
            }
        }
        return status;
    }

    /**
     * Adds block.
     * 
     * @return Returns whether block was added or not
     */
    public static boolean addB() {
        boolean status = false;
        addToDebugger("addB Method called");
        int xPos = 0;

        for (int x = 70; x <= 1060; x += 110) {
            int yPos = 0;
            for (int y = 0; y <= 200; y += 70) {
                addToDebugger("X: " + x + " | Y: " + y);

                if (ball.x() > x && ball.x() <= x + 100) {
                    if (ball.y() > y && ball.y() <= y + 60) {
                        if (yPos != 0) {
                            if (!run.trumpList[xPos][yPos].getStatus()
                                    && run.trumpList[xPos][yPos - 1]
                                            .getStatus()) {
                                run.trumpList[xPos][yPos].changeStatus();
                                status = true;
                            }
                        } else {
                            if (!run.trumpList[xPos][0].getStatus()) {
                                run.trumpList[xPos][0].changeStatus();
                                status = true;
                            }
                        }
                    }
                }
                yPos++;
            }
            xPos++;
        }

        return status;
    }

    /**
     * Sets p1img variable.
     * 
     * @param img New value for p1img
     */
    public static void setImg(int img) {
        p1img = img;
    }

    /**
     * 
     * Sets p2img variable.
     * 
     * @param img New value for p2img
     */
    public static void set2Img(int img) {
        p2img = img;
    }

    /**
     * Mouse Listener method.
     * 
     * @param e Mouse Listener input
     */
    public void mouseClicked(MouseEvent e) {
        addToDebugger("mouseClicked method called: " + e);
        if (e.getX() >= 40 && e.getX() <= 1200
                && e.getY() >= 10 && e.getY() <= 80) {
            run.demoMode();
        }
        if (menu == 0) {
            if (e.getX() >= 40 && e.getX() <= 600
                    && e.getY() >= 95 && e.getY() <= 325) {
                FullGameTest.menu = 2;
                mode = 1;
                run.blank = true;
                repaint();
            }
            if (e.getX() >= 40 && e.getX() <= 600
                    && e.getY() >= 345 && e.getY() <= 575) {
                FullGameTest.menu = 10;
                run.blank = true;
                repaint();
            }
            if (e.getX() >= 640 && e.getX() <= 1200
                    && e.getY() >= 95 && e.getY() <= 325) {
                FullGameTest.menu = 3;
                mode = 2;
                run.blank = true;
                repaint();
            }
            if (e.getX() >= 640 && e.getX() <= 1200
                    && e.getY() >= 345 && e.getY() <= 575) {
                FullGameTest.menu = 11;
                run.blank = true;
                repaint();
            }
            if (e.getX() >= 400 && e.getX() <= 1200
                    && e.getY() >= 590 && e.getY() <= 660) {
                run.exitGame();
            }

        } else if (menu == 2) {
            MouseActions.speedMenu(e, frame, run);
        } else if (menu == 3) {
            MouseActions.imageLoader(e, menu, frame, run, mode);
        } else if (menu == 4) {
            addToDebugger("Menu 4 - Again?");
            if (e.getX() >= 300 && e.getX() <= 500
                    && e.getY() >= 300 && e.getY() <= 400) {
                run.reset();
                run.blank = true;
                repaint();
            }
            if (e.getX() >= 780 && e.getX() <= 980
                    && e.getY() >= 300 && e.getY() <= 400) {
                exitGame();
            }
            if (e.getX() >= 150 && e.getX() <= 1200
                    && e.getY() >= 590 && e.getY() <= 660) {
                run.exitGame();
            }
        } else if (menu == 6) {
            MouseActions.imageLoader(e, menu, frame, run, mode);
            FullGameTest.menu = 3;
            run.blank = true;
            repaint();
        } else if (menu == 10) {
            addToDebugger("Specials Menu");
            if (e.getX() >= 40 && e.getX() <= 600
                    && e.getY() >= 95 && e.getY() <= 325) {
                mode = 3;
                FullGameTest.menu = 3;
                run.blank = true;
                repaint();
            }
            if (e.getX() >= 40 && e.getX() <= 600
                    && e.getY() >= 345 && e.getY() <= 575) {
                frame.setContentPane(run);
                sp = 3;
                run.blank = false;
                menu = -1;
                run(1, frame, 9);
            }
            if (e.getX() >= 640 && e.getX() <= 1200
                    && e.getY() >= 95 && e.getY() <= 325) {
                mode = 7;
                sp = 4;
                FullGameTest.menu = 6;
                run.blank = true;
                repaint();
            }
            if (e.getX() >= 40 && e.getX() <= 600
                    && e.getY() >= 95 && e.getY() <= 325) {
                addToDebugger("Not completed yet");
            }
            if (e.getX() >= 640 && e.getX() <= 1200
                    && e.getY() >= 345 && e.getY() <= 575) {
                addToDebugger("Not completed yet");
            }
            if (e.getX() >= 150 && e.getX() <= 1200
                    && e.getY() >= 590 && e.getY() <= 660) {
                run.exitGame();
            }
            if (e.getX() >= 40 && e.getX() <= 140
                    && e.getY() >= 570 && e.getY() <= 660) {
                run.blank = false;
                FullGameTest.menu = 0;
                repaint();
            }
        } else if (menu == 11) {
            addToDebugger("Demo");
            MouseActions.demoMenu(e, frame, run);
        }
    }

    /**
     * Changes speed variable.
     * 
     * @param newSpeed New value for speed.
     */
    public static void setSpeed(int newSpeed) {
        sp = newSpeed;
    }

    /**
     * Changes blank variable.
     * 
     * @param newBlank New value to set blank to.
     */
    public static void setBlank(boolean newBlank) {
        run.blank = newBlank;
    }

    /**
     * Changes Menu Variable.
     * 
     * @param newMenu New Value to set menu to.
     */
    public static void setMenu(int newMenu) {
        menu = newMenu;
    }

    /**
     * Mouse Listener Extra Method.
     * 
     * @param e Mouse Listener input
     */
    public void mouseEntered(MouseEvent e) {
    }

    /**
     * Mouse Listener Extra Method.
     * 
     * @param e Mouse Listener input
     */
    public void mouseReleased(MouseEvent e) {
    }

    /**
     * Mouse Listener Extra Method.
     * 
     * @param e Mouse Listener input
     */
    public void mousePressed(MouseEvent e) {
    }

    /**
     * Mouse Listener Extra Method.
     * 
     * @param e Mouse Listener input
     */
    public void mouseExited(MouseEvent e) {
    }

    /**
     * Debug Mode Method Starter.
     */
    public void debugMode() {
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ssa MM-dd-yyyy");
        String strDate = ft.format(dNow).toString();
        File log = new File("logs/log " + ft.format(dNow).toString());
        try {
            writer = new PrintWriter(log);
        } catch (Exception ex) {
            System.out.println("Log File not created: " + ex);
        }
        writer.println("Matty Wolfson");
        writer.println("Pong, pong, pong, ping");
        writer.println("End of Year AP Computer Science "
                + "Project and Learn Better Project");
        writer.println("Pictures are property of Nintendo and their creators");
        writer.println("Emoji Images are property of"
                + " Apple Inc. and their creators");
        writer.println();
        writer.println("-----------------------"
                + "DEBUG MODE ENABLED------------------");
        writer.println("Date and Time: " + strDate);
        debug = !debug;
        if (overRide) {
            writer.println("-----------------------"
                    + "OVERRIDE ENABLED!-------------------");
        }
        repaint();
    }

    /**
     * Game Exit Method.
     */
    public void exitGame() {
        addToDebugger("Exited Game, Saving File");
        try {
            scores = new PrintWriter("scoreboard.txt");
        } catch (Exception ex) {
            System.out.println("scoreboard.txt failed: " + ex);
        }
        for (int i = 0; i < scoresArr.size(); i++) {
            scores.println(scoresArr.get(i));
            addToDebugger(scoresArr.get(i));
        }
        if (debug) {
            writer.close();
        }
        scores.close();
        System.out.println("File Saved!");
        System.exit(1);
    }

    /**
     * Override Setup Method.
     */
    public void overRide() {
        addToDebugger("-----------------------"
                + "OVERRIDE TOGGLED!-------------------");
        overRide = !overRide;
        repaint();
    }

    /**
     * Returns posX1 of coord.
     * 
     * @param x X coord
     * @param y Y Coord
     * @return int X Coord return
     */
    public int trumpPosX1(int x, int y) {
        return run.trumpList[x][y].posX1();
    }

    /**
     * Returns posX2 of coord.
     * 
     * @param x X coord
     * @param y Y Coord
     * @return int X Coord return
     */
    public int trumpPosX2(int x, int y) {
        return run.trumpList[x][y].posX2();
    }

    /**
     * Returns posY1 of coord.
     * 
     * @param x X coord
     * @param y Y Coord
     * @return int Y Coord return
     */
    public int trumpPosY1(int x, int y) {
        return run.trumpList[x][y].posY1();
    }

    /**
     * Returns posY2 of coord.
     * 
     * @param x X coord
     * @param y Y Coord
     * @return int Y Coord return
     */
    public int trumpPosY2(int x, int y) {
        return run.trumpList[x][y].posY2();
    }

    /**
     * Gets the recent boolean.
     * 
     * @return boolean Returns "recent"
     */
    public boolean getRecent() {
        return recent;
    }

    /**
     * Sets recent.
     * 
     * @param newRecent New value for recent.
     */
    public void setRecent(boolean newRecent) {
        recent = newRecent;
    }

    /**
     * Gets the image array.
     * 
     * @return ArrayList Returns image array.
     */
    public ArrayList<BufferedImage> getImages() {
        return imgArr;
    }

    /**
     * Gets the player 2 img index.
     * 
     * @return int Returns player 2 image index
     */
    public int getp2Img() {
        return p2img;
    }

    /**
     * Sets up and runs Power Ups.
     * 
     * @param power2 Power Up Type Parameter
     */
    public void powerUps(int power2) {
        addToDebugger("POWER UP: " + power2);
        powerUp = true;
        power = power2;
        if (power == 1) {
            barLength = 400;
            Timer timer = new Timer(6000,
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent arg0) {
                            barLength = 200;
                        }
                    });
            timer.setRepeats(false); // Only execute once
            timer.start(); // Go go go!
        }
        if (power == 2) {
            // int oldh = ball.h();
            // int oldl = ball.l();
            ball.setL(ball.l() / 2);
            ball.setH(ball.h() / 2);
            /*
             * Timer timer = new Timer(6000, new ActionListener() {
             * 
             * @Override public void actionPerformed(ActionEvent arg0) {
             * ball.setL(oldl); ball.setH(oldh); } });
             */
        }
        if (power == 3) {
            // int oldh = ball.h();
            // int oldl = ball.l();
            ball.setL(ball.l() * 2);
            ball.setH(ball.h() * 2);
            /*
             * Timer timer = new Timer(6000, new ActionListener() {
             * 
             * @Override public void actionPerformed(ActionEvent arg0) {
             * ball.setL(oldl); ball.setH(oldh); } });
             */
        }
        /*
         * if(power == 4){ flashb = true; Timer timer4 = new Timer(6000, new
         * ActionListener() {
         * 
         * @Override public void actionPerformed(ActionEvent arg0) { flashb =
         * false; } }); }
         */

    }

    /**
     * Loads Images Array.
     */
    public void loadImages() {
        imgArr = ImageLoader.loadImage(debug, writer);
    }

    /**
     * Demo Method Setup/Run.
     */
    public void demoMode() {
        frame.setContentPane(run);
        sp = 3;
        run.blank = false;
        menu = -1;
        run(1, frame, 4);
        demo = true;
        Timer timer9 = new Timer(10000,
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        addToDebugger("OVERRIDE RUN");
                        if (posit == 0) {
                            ball.reset();
                            frame.setContentPane(run);
                            sp = 3;
                            run.blank = false;
                            posit++;
                            menu = -1;
                            ball.startAngle(false);
                            run(1, frame, 5);
                        } else if (posit == 1) {
                            ball.reset();
                            frame.setContentPane(run);
                            sp = 3;
                            run.blank = false;
                            posit++;
                            menu = -1;
                            ball.startAngle(false);
                            run(1, frame, 6);
                        } else if (posit == 2) {
                            ball.reset();
                            frame.setContentPane(run);
                            sp = 3;
                            run.blank = false;
                            posit++;
                            menu = -1;
                            ballL.startAngle(false);
                            ballR.startAngle(true);
                            run(1, frame, 8);
                        } else if (posit == 3) {
                            ballL.reset();
                            ballR.reset();
                            frame.setContentPane(run);
                            sp = 3;
                            run.blank = false;
                            menu = -1;
                            posit = 0;
                            ball.startAngle(false);
                            run(1, frame, 4);
                        }
                    }
                });
        timer9.start();
    }
}
