/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bluemoonver2.image;

import java.awt.Image;
import javax.swing.ImageIcon;
/**
 *
 * @author DELL
 */
public class ImageResize {
    public static ImageIcon resizeImage(String imagePath, int width, int height) {
        // Load the original image
        ImageIcon originalIcon = new ImageIcon(imagePath);

        // Resize the image
        Image resizedImage = originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);

        // Return the resized image wrapped in an ImageIcon
        return new ImageIcon(resizedImage);
    }
}
