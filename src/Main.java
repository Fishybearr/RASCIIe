import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *Converts a jpg or png image to a 16 shade ASCII art text file
 *
 *
 */
public class Main
{

    public static void main(String[] args) throws IOException
    {

        //showTile();
        ImageToASCII();
    }


    /**
     * Creates and adds logo to bottom of ASCII art text file
     * @param writeTo -References BufferedWriter used to write text to ASCII art files
     * @throws IOException
     */
    public static void showTile(BufferedWriter writeTo) throws IOException
    {

        //Used for Testing
        /*
        System.out.println("  _______          _       ______     ______  _____  _____");
        System.out.println(" |_   __ \\        / \\    .' ____ \\  .' ___  ||_   _||_   _|");
        System.out.println("   | |__) |      / _ \\   | (___ \\_|/ .'   \\_|  | |    | |  .---.");
        System.out.println("   |  __ /      / ___ \\   _.____`. | |         | |    | | / /__\\\\");
        System.out.println("  _| |  \\ \\_  _/ /   \\ \\_| \\____) |\\ `.___.'\\ _| |_  _| |_| \\__.,");
        System.out.println("|____| |___||____| |____|\\______.' `.____ .'|_____||_____|'.__.'");

         */


        //Adds logo to file
        writeTo.append("\nCreated in: ");
        writeTo.append("   _______          _       ______     ______   ___  ___");
        writeTo.append("\n              |_   __ \\        / \\    .' ____ \\  .' ___  |  | |  | |");
        writeTo.append("\n                 ||__) |      / _ \\   | (___ \\_|/ .'   \\_|  | |  | |  .---.");
        writeTo.append("\n                |  __ /      / ___ \\   _.____`. | |         | |  | | / /__\\\\");
        writeTo.append("\n               _| |  \\ \\_  _/ /   \\ \\_| \\____) |\\ `.___.'\\  | |  | | | \\__.,");
        writeTo.append("\n              |____| |___||____| |____|\\______.' `.____ .'  |_|  |_| '.__.'");
        writeTo.append("\nhttps://github.com/Fishybearr/RASCIIe");

    }

    /**
     * Allows user to choose an image
     * Each pixel of selected image is assigned an ASCII character based on its calculated luminance
     * @throws IOException
     */
    public static void ImageToASCII() throws  IOException
    {

        //Creates JFile chooser to select image to convert
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("RASCIIe: Choose an Image");
        fc.addChoosableFileFilter(new FileNameExtensionFilter("images, .jpg , .png","jpg","jpeg","png"));
        fc.setAcceptAllFileFilterUsed(false);
        fc.showOpenDialog(null);

        File img = fc.getSelectedFile();



        BufferedImage image = ImageIO.read(img);

        //Currently writes ASCII art file to a text file in project folder
        BufferedWriter writer = new BufferedWriter(new FileWriter(System.getProperty("user.dir")+"\\Test.txt"));


        //Checks luminance of each pixel in image
        for (int y = 0; y <image.getHeight();y++)
        {
            //System.out.print(y);

            for (int x = 0; x < image.getWidth(); x++)
            {
                int color = image.getRGB(x,y);

                int red   = (color >>> 16) & 0xFF;
                int green = (color >>>  8) & 0xFF;
                int blue  = (color >>>  0) & 0xFF;

                float luminance = (red * 0.2126f + green * 0.7152f + blue * 0.0722f) / 255;


                //[WIP Solution] Sorts pixel's luminance into 1 of 16 possible values, and assigns it a letter used in image
                if (luminance >= .9375f)
                {
                    //System.out.print(" * ");
                    writer.append("   ");
                }

               else if (luminance >= .875f)
                {
                    //System.out.print(" * ");
                    writer.append(" a ");
                }


                else if (luminance >= .8125f)
                {
                    //System.out.print(" * ");
                    writer.append(" b ");
                }

                else if(luminance >= .75f)
                {
                   // System.out.print(" # ");
                    writer.append(" c ");
                }

                else if (luminance >= .6875f)
                {
                    //System.out.print(" * ");
                    writer.append(" d ");
                }

                else if (luminance >= .625f)
                {
                    writer.append(" e ");

                }


                else if (luminance >= .5625f)
                {
                    //System.out.print(" * ");
                    writer.append(" f ");
                }

                else if (luminance >= .50f)
                {
                    writer.append(" g ");
                }


                else if (luminance >= .4375f)
                {
                    //System.out.print(" * ");
                    writer.append(" h ");
                }

                else if (luminance >= .375f)
                {
                    writer.append(" i ");
                }

                else if (luminance >= .3125f)
                {
                    //System.out.print(" * ");
                    writer.append(" j ");
                }


                else if (luminance >= .25f)
                {
                    //System.out.print(" * ");
                    writer.append(" k ");
                }


               else if (luminance >= .1875f)
                {
                    //System.out.print(" * ");
                    writer.append(" l ");
                }



                else if (luminance >= .125f)
                {
                    writer.append(" m ");
                }

                else if (luminance >= .0625f)
                {
                    //System.out.print(" * ");
                    writer.append(" n ");
                }


                else
                {
                    //System.out.print("   ");
                    writer.append(" o ");
                }

            }

            //Finishes image with a new line
            writer.append("\n");

        }

        //Adds title to image
        showTile(writer);
        //Closes file writer
        writer.close();

    }




}
