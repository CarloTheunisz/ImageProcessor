//This program creates a GUI in which an image can be loaded. After loading, 
//the image can be sharpened, blurred or converted to grayscale. In the
//first text field, the location of the source image must be entered. All other 
//text fields contain the locations where the new images will be saved. This
//application enables fast processing of multiple images. 

//The image loaded must be non-transparent. Only the following image formats 
//can be loaded:
//gif, png, jpg, bmp, wbmp
//gif-files must not be animated. 
package imageprocessor;

//Import all necessities. 
import java.awt.BorderLayout;
import java.awt.color.ColorSpace;
import java.awt.image.*;
import java.io.*;
import java.util.logging.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ImageProcessor extends javax.swing.JFrame {
    //Declare all elements of the GUI. 
    private JLabel textLabel1;
    private JLabel textLabel2;
    private JLabel textLabel3;
    private JLabel textLabel4;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    
    //Declare further variables
    private String source = "C:/Users/Carlo/Documents/NetBeansProjects/BroncodeTraineeship/src/broncodetraineeship/HistologyImage.jpg";
    private String destinationText = "Destination";
    private String destination = "C:/Users/Carlo/Pictures/";
    
    public ImageProcessor() {
        //This method creates the GUI.
        initComp();
    }

    private void initComp() {
        //Make all GUI elements. 
        textLabel1 = new javax.swing.JLabel();
        textLabel2 = new javax.swing.JLabel();
        textLabel3 = new javax.swing.JLabel();
        textLabel4 = new javax.swing.JLabel();
        textField1 = new javax.swing.JTextField();
        textField2 = new javax.swing.JTextField();
        textField3 = new javax.swing.JTextField();
        textField4 = new javax.swing.JTextField();
        button1 = new javax.swing.JButton();
        button2 = new javax.swing.JButton();
        button3 = new javax.swing.JButton();
        button4 = new javax.swing.JButton();
        button5 = new javax.swing.JButton();
        
        //Stop program after closing the GUI. 
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        //Set the standard text for all GUI elements. 
        //The folders will have to be changed!
        textLabel1.setText("Select image");
        textLabel2.setText(destinationText);
        textLabel3.setText(destinationText);
        textLabel4.setText(destinationText);
        textField1.setText(source);
        textField2.setText(destination + "SharpExample.png");
        textField3.setText(destination + "BlurExample.png");
        textField4.setText(destination + "GrayExample.png");
        button1.setText("Show");
        button2.setText("Sharpen");
        button3.setText("Blur");
        button4.setText("Grayscale");
        button5.setText("Exit");
        
        //The following blocks add functionality to the buttons. 
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1Action(evt);
            }
        });
        
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2Action(evt);
            }
        });
        
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3Action(evt);
            }
        });
        
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4Action(evt);
            }
        });
        
        button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button5Action(evt);
            }
        });
        
        //Define the layout of the GUI. 
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textField1, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                )
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(button1, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                )
            )
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textField2, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                )
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(button2, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                )
            )
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textField3, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                )
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(button3, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                )
            )
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textField4, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                )
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(button4, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                )
            )
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(button5, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                )
            )
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textLabel1)
                    .addGap(5)
                    .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(5)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(5)
                )
            .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textLabel2)
                    .addGap(5)
                    .addComponent(textField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(5)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(5)
                )
            .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textLabel3)
                    .addGap(5)
                    .addComponent(textField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(5)
                    .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(5)
                )
            .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textLabel4)
                    .addGap(5)
                    .addComponent(textField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(5)
                    .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(5)
                )
            .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(5)
                )
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            )
        );
        
        //The GUI gets finalised here. 
        pack();
    }
    
    private BufferedImage loadImage() {
        //This method loads the image specified the the first text field. 
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(textField1.getText()));
        } catch (IOException e) {
            System.out.println("This image cannot be loaded. Try a different file type or a non-transparent image.");
        }
        
        //Retrieve the image for use in other methods. 
        return image;
    }
    
    private void button1Action(java.awt.event.ActionEvent evt) {
        //Load image. 
        BufferedImage image = loadImage();
        
        //Get the image width and height. 
        int w = image.getWidth();
        int h = image.getHeight();
        
        //Show the loaded image. 
        JFrame frame1 = new JFrame();
        JLabel imageLabel1 = new javax.swing.JLabel(new ImageIcon(image));
        frame1.getContentPane().add(imageLabel1, BorderLayout.CENTER);
        frame1.setSize(w, h);
        pack();
        frame1.setVisible(true);
    }
    
    private void button2Action(java.awt.event.ActionEvent evt) {
        //Load the source image. 
        BufferedImage image = loadImage();
        
        //Make a sharpening kernel and convolve the source image. 
        Kernel sharp = new Kernel(3, 3, new float[]{-1,-1,-1,-1,9,-1,-1,-1,-1});
        BufferedImageOp sharpOp = new ConvolveOp(sharp);
        BufferedImage sharpImage = sharpOp.filter(image, null);
        
        //Get the new image's width and height. 
        int w = sharpImage.getWidth();
        int h = sharpImage.getHeight();
        
        //Show the new image. 
        JFrame frame2 = new JFrame();
        JLabel imageLabel2 = new javax.swing.JLabel(new ImageIcon(sharpImage));
        frame2.getContentPane().add(imageLabel2, BorderLayout.CENTER);
        frame2.setSize(w, h);
        pack();
        frame2.setVisible(true);
        
        //Save the image at the location given by the second text field. 
        File imOut = new File(textField2.getText());
        try {
            ImageIO.write(sharpImage, "png", imOut);
        } catch (IOException ex) {
            Logger.getLogger(ImageProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void button3Action(java.awt.event.ActionEvent evt) {
        //Load the source image. 
        BufferedImage image = loadImage();
        
        //Make a blurring kernel and convolve the source image. 
        Kernel blur = new Kernel(3, 3, new float[] {1f/9f,1f/9f,1f/9f,1f/9f,1f/9f,1f/9f,1f/9f,1f/9f,1f/9f});
        BufferedImageOp blurOp = new ConvolveOp(blur);
        BufferedImage blurImage = blurOp.filter(image, null);
        
        //Get the new image's width and height. 
        int w = blurImage.getWidth();
        int h = blurImage.getHeight();
        
        //Show the new image. 
        JFrame frame3 = new JFrame();
        JLabel imageLabel3 = new javax.swing.JLabel(new ImageIcon(blurImage));
        frame3.getContentPane().add(imageLabel3, BorderLayout.CENTER);
        frame3.setSize(w, h);
        pack();
        frame3.setVisible(true);
        
        //Save the image at the location given by the third text field. 
        File imOut = new File(textField3.getText());
        try {
            ImageIO.write(blurImage, "png", imOut);
        } catch (IOException ex) {
            Logger.getLogger(ImageProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void button4Action(java.awt.event.ActionEvent evt) {
        //Load the source image. 
        BufferedImage image = loadImage();
        
        //Convert the source image to grayscale. 
        ColorSpace gray = ColorSpace.getInstance(ColorSpace.CS_GRAY);
        ColorConvertOp grayOp = new ColorConvertOp(gray, null);
        BufferedImage grayImage = grayOp.filter(image, null);
        
        //Get the new image's width and height. 
        int w = grayImage.getWidth();
        int h = grayImage.getHeight();
        
        //Show the new image. 
        JFrame frame4 = new JFrame();
        JLabel imageLabel4 = new javax.swing.JLabel(new ImageIcon(grayImage));
        frame4.getContentPane().add(imageLabel4, BorderLayout.CENTER);
        frame4.setSize(w, h);
        pack();
        frame4.setVisible(true);
        
        //Save the image at the location given by the fourth text field. 
        File imOut = new File(textField4.getText());
        try {
            ImageIO.write(grayImage, "png", imOut);
        } catch (IOException ex) {
            Logger.getLogger(ImageProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void button5Action(java.awt.event.ActionEvent evt) {
        //Stop the program and close the GUI when this button is pressed. 
        System.exit(0);
    }
    
    public static void main(String[] args) {
        //Main method, the GUI gets initialised here. 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImageProcessor().setVisible(true);
            }
        });
    }
}
