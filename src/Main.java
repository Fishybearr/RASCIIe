import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        ImageToASCII();
    }

    public static void ImageToASCII() throws  IOException
    {


        BufferedImage image = ImageIO.read(new File("G:\\BeffaloJava\\ASCIIRender\\untitled\\TestImg1.png"));
        //BufferedImage image = ImageIO.read(new File("G:\\Roll.jpg"));






        for (int x = 0; x <image.getHeight();x++)
        {
            for (int y = 0; y < image.getWidth(); y++)
            {
                int color = image.getRGB(x,y);

                int red   = (color >>> 16) & 0xFF;
                int green = (color >>>  8) & 0xFF;
                int blue  = (color >>>  0) & 0xFF;

                float luminance = (red * 0.2126f + green * 0.7152f + blue * 0.0722f) / 255;

                if (luminance >= .75f)
                {
                    System.out.print(" * ");
                }
                else if(luminance >= .5f)
                {
                    System.out.print(" # ");
                }
                else
                {
                    System.out.print("   ");
                }

            }
            System.out.println("");

        }


    }




}
