import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
// import java.awt.Image;
// import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 * Pong, pong, pong, ping
 * End of Year AP Computer Science Project and Learn Better Project
 * Pictures are property of Nintendo and their creators
 * Emoji Images are property of Apple Inc. and their creators
 * Video method not created by Matty Wolfson
 * 
 * @author Matty Wolfson
 * @version CURRENT
 */
//Pong, pong, pong, ping
//End of Year AP Computer Science Project

public class Block extends FullGameTest {
    private int x;
    private int y;
    private int power;
    private boolean show;
    // private FullGameTest run = FullGameTest.run();
    private JFrame frame = FullGameTest.frame();
    private int mode;
    
    /**
     * Creates block at coords.
     * @param x2 X coord of block
     * @param y2 Y coord of block
     */
    public Block(int x2, int y2) {
        x = x2;
        y = y2;
        show = false;
    }
    
    /**
     * Creates block at coords (with powerups).
     * @param x2 X coord of block
     * @param y2 Y coord of block
     * @param power2 Type of Powerup
     */
    public Block(int x2, int y2, int power2) {
        x = x2;
        y = y2;
        power = power2;
        show = false;
    }
    
    /**
     * Run method to show blocks.
     * @param g Graphics object
     * @param show2 Boolean of whether block should show or hide
     * @param mode2 Mode Passed through
     */
    public void run(Graphics g, boolean show2, int mode2) {
        mode = mode2;
        if (show) {
            // System.out.println("SHOW TRUE");
            try {
                g.drawImage(ImageIO.read(new File("120px-Brick_Block.png")),
                        x, y, 100, 60, frame);
            } catch (IOException ex) {
                System.out.println("No image found");
            }
        } 
    }
    
    /**
     * Run method for blocks.
     * @param g Graphics object
     * @param mode2 Mode passed through
     */
    public void run(Graphics g, int mode2) {
        mode = mode2;
        try {
            g.drawImage(ImageIO.read(new File("120px-Brick_Block.png")),
                    x, y, 100, 60, frame);
        } catch (IOException ex) {
            System.out.println("No image found");
        }
    }
    
    /**
     * 2 Player run method.
     * @param g Graphics object
     * @param show2 True/False show parameter
     * @param mode2 Mode passed through
     */
    public void run2P(Graphics g, boolean show2, int mode2) {
        mode = mode2;
        if (show) {
            try {
                g.drawImage(ImageIO.read(new File("block2p.png")),
                        x, y, 60, 100, frame);
            } catch (IOException ex) {
                System.out.println("No image found");
            }
        }
    }
    
    /**
     * Removes all from frame.
     */
    public void remove() {
        frame.removeAll();
    }

    /**
     * Returns x coord of block.
     * @return int X1 Coord of block
     */
    public int posX1() {
        return x;
    }  
    
    /**
     * Returns x coord of block.
     * @return int X2 Coord of block
     */
    public int posX2() {
        if (mode != 7) {
            return x + 100;
        } else {
            return x + 60;
        }
    }
    
    /**
     * Returns y coord of block.
     * @return int Y1 Coord of block
     */
    public int posY1() {
        return y;
    }
    
    /**
     * Returns y coord of block.
     * @return int Y2 Coord of block
     */
    public int posY2() {
        if (mode != 7) {

            return y + 60;
        } else {
            return y + 100;
        }
    }
    
    /**
     * Changes the status of block to true.
     */
    public void changeStatus() {
        // System.out.println("CHANGE STATUS X: " + x + " || Y: " + y);
        show = true;
    }
    
    /**
     * Gets the status of a block.
     * @return boolean Returns status.
     */
    public boolean getStatus() {
        // System.out.println("GET STATUS " + show);
        return show;
    }
    
    /**
     * Sets the status of a block.
     * @param setstatus New status to set
     */
    public void setStatus(boolean setstatus) {
        show = setstatus;
    }
    
    /**
     * Sets powerup type.
     * @return Returns powerup type
     */
    public int powers() {
        return power;
    }
}
