package imagecarousel;


import javax.swing.*;
import java.awt.*;

public class imageCarousel 
{
    // ========================== [Start-Of-File] =========================== //
    
    // ====================== [Variables Declerations] ====================== //
    private static final String[] IMAGE_URLS = {      
        
        // Add your own more image URLs here
    };
    private int currentIndex = 0;
    private final  JLabel imageLabel;
    // ====================================================================== //

    // ==================== [Method-That-Creates-JFrame] ==================== //
    public imageCarousel() 
    {
        JFrame frame = new JFrame("Image Carousel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // ------=--------- Create a label to display images ---------------- //
        imageLabel = new JLabel();
        frame.add(imageLabel, BorderLayout.CENTER);

        // ----------------------- Create nav buttons ----------------------- //
        JButton prevButton = new JButton("Previous Image");
        JButton nextButton = new JButton("Next Image");

        // ---------------------- Add button listeners ---------------------- //
        prevButton.addActionListener(e -> showPreviousImage());
        nextButton.addActionListener(e -> showNextImage());

        // -------------------- Add buttons to the frame -------------------- //
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // --------------------- Show the initial image --------------------- //
        showImage(currentIndex);

        frame.setVisible(true);
    }
    // ====================================================================== //

    // ===================== [Method-Displays-Image] ======================== //
    private void showImage(int index) 
    {
        if (index >= 0 && index < IMAGE_URLS.length) {
            ImageIcon imageIcon = new ImageIcon(IMAGE_URLS[index]);
            imageLabel.setIcon(imageIcon);
        }
    }
    // ====================================================================== //

    // =================== [Method-Goes-To-Next-Image] ====================== //
    private void showNextImage() 
    {
        currentIndex = (currentIndex + 1) % IMAGE_URLS.length;
        showImage(currentIndex);
    }
    // ====================================================================== //

    // ================= [Method-Goes-To-Previous-Image] ==================== //
    private void showPreviousImage() 
    {
        currentIndex = (currentIndex - 1 + IMAGE_URLS.length) % IMAGE_URLS.length;
        showImage(currentIndex);
    }
    // ====================================================================== //

    // ====================== [This-Is--The-Main-Method] ==================== //
    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> new imageCarousel());
    }
    // ====================================================================== //
    
    // ===========================  {End-Of-File} =========================== //
}
