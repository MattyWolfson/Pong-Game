import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.imageio.ImageIO;

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
public class ImageLoader {

    /**
     * Image Loader with Debug disabled.
     * 
     * @return ArrayList Returns Image Arraylist
     */
    public static ArrayList<BufferedImage> loadImageNoDebug() {
        File folder = new File("Icons/");
        File[] listOfFiles = folder.listFiles();
        ArrayList<String> fileNames = new ArrayList<String>();

        for (int i = 0; i < 40; i++) {
            if (i < listOfFiles.length) {
                fileNames.add(listOfFiles[i].getName());
            } else {
                fileNames.add("classic.png");
            }
        }
        for (int i = 0; i < 40; i++) {
            if (fileNames.get(i).equals(".DS_Store")) {
                fileNames.remove(i);
                fileNames.add("classic.png");
            }
        }
        ArrayList<BufferedImage> imgArr = new ArrayList<BufferedImage>();
        for (int i = 0; i < 40; i++) {
            try {
                imgArr.add(ImageIO.read(new File("Icons/" + fileNames.get(i))));
            } catch (IOException ex) {
            } 

        }
        return imgArr;
    }
    
    /**
     * Loads Images into ArrayList.
     * @param debug Debug mode toggle
     * @param writer Debug writer passthrough
     * @return ArrayList Returns image list.
     */
    public static ArrayList<BufferedImage> loadImage(
            boolean debug, PrintWriter writer) {
        File folder = new File("Icons/");
        File[] listOfFiles = folder.listFiles();
        ArrayList<String> fileNames = new ArrayList<String>();

        for (int i = 0; i < 40; i++) {
            if (i < listOfFiles.length) {
                fileNames.add(listOfFiles[i].getName());
            } else {
                fileNames.add("classic.png");
            }
        }
        for (int i = 0; i < 40; i++) {
            if (fileNames.get(i).equals(".DS_Store")) {
                fileNames.remove(i);
                fileNames.add("classic.png");
            }
        }
        ArrayList<BufferedImage> imgArr = new ArrayList<BufferedImage>();
        for (int i = 0; i < 40; i++) {
            try {
                imgArr.add(ImageIO.read(new File("Icons/" + fileNames.get(i))));
            } catch (IOException ex) {
                if (debug) {
                    writer.println("Error: Icons/" 
                            + fileNames.get(i) + " not found!");
                }
            } 

        }
        // System.out.println("CHECK " + imgArr.size());
        return imgArr;
    }    
}
