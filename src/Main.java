import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        ImageToASCII();
    }

    public static void ImageToASCII() throws  IOException
    {


       // BufferedImage image = ImageIO.read(new File("G:\\BeffaloJava\\ASCIIRender\\untitled\\TestImg1.png"));
        BufferedImage image = ImageIO.read(new File("G:\\Roll2.jpg"));


        BufferedWriter writer = new BufferedWriter(new FileWriter("G:\\BeffaloJava\\ASCIIRender\\untitled\\Test.txt"));



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


                if (luminance >= .875f)
                {
                    //System.out.print(" * ");
                    writer.append("   ");
                }
                else if(luminance >= .75f)
                {
                   // System.out.print(" # ");
                    writer.append(" a ");
                }
                else if (luminance >= .625f)
                {
                    writer.append(" b ");

                }
                else if (luminance >= .50f)
                {
                    writer.append(" c ");
                }

                else if (luminance >= .375f)
                {
                    writer.append(" d ");
                }

                else if (luminance >= .25f)
                {
                    writer.append(" e ");
                }

                else if (luminance >= .125f)
                {
                    writer.append(" f ");
                }


                else
                {
                    //System.out.print("   ");
                    writer.append(" g ");
                }

            }

            //System.out.println("");
            writer.append("\n");

        }


    }




}
