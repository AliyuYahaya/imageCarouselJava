package imagecarousel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyCarouselFunctionClass {
    private static final String[] IMAGE_URLS = {
        "image1.jpg",
        "image2.jpg",
        "image3.jpg"
        // Add more image URLs here
    };

    private int currentIndex = 0;
    private JLabel imageLabel;

    public ImageCarouselApp() {
        JFrame frame = new JFrame("Image Carousel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Create a label to display images
        imageLabel = new JLabel();
        frame.add(imageLabel, BorderLayout.CENTER);

        // Create navigation buttons
        JButton prevButton = new JButton("Previous");
        JButton nextButton = new JButton("Next");

        // Add button listeners
        prevButton.addActionListener(e -> showPreviousImage());
        nextButton.addActionListener(e -> showNextImage());

        // Add buttons to the frame
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Show the initial image
        showImage(currentIndex);

        frame.setVisible(true);
    }

    private void showImage(int index) {
        if (index >= 0 && index < IMAGE_URLS.length) {
            ImageIcon imageIcon = new ImageIcon(IMAGE_URLS[index]);
            imageLabel.setIcon(imageIcon);
        }
    }

    private void showNextImage() {
        currentIndex = (currentIndex + 1) % IMAGE_URLS.length;
        showImage(currentIndex);
    }

    private void showPreviousImage() {
        currentIndex = (currentIndex - 1 + IMAGE_URLS.length) % IMAGE_URLS.length;
        showImage(currentIndex);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ImageCarouselApp());
    }
}
