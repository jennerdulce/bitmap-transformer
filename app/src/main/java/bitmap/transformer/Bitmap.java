package bitmap.transformer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.File;
import java.io.IOException;

public class Bitmap {
    String inputFilePath;
    String outputFilePath;
    String transformImageName;
    BufferedImage image = null;

    public Bitmap(String inputFilePath,
                  String outputFilePath,
                  String transformImageName) throws IOException {
        this.inputFilePath = inputFilePath;
        this.outputFilePath = outputFilePath;
        this.transformImageName = transformImageName;

        try {
            this.image = ImageIO.read(new File(inputFilePath));
        } catch (IOException e){
            System.out.println(e);
        }
    }
    public void exportImage(BufferedImage img) throws IOException{
        try {
            File outputFile = new File(this.outputFilePath + "/" + transformImageName + ".bmp") ;
            System.out.println(outputFile);
            ImageIO.write(img, "bmp", outputFile);
        } catch (IOException e){
            System.out.println(e);
        }
    }

    public BufferedImage transformGrey() throws IOException{
        BufferedImage grey = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        Graphics modifications = grey.getGraphics();
        modifications.drawImage(this.image, 0, 0 ,null );
        modifications.dispose();
        this.exportImage(grey);
        return grey;
    }

    public int transformWidth(int newWidth) throws IOException{
        BufferedImage modifiedImage = new BufferedImage(newWidth, this.image.getHeight(), this.image.getType());
        Graphics2D g2d = modifiedImage.createGraphics();
        g2d.drawImage(this.image, 0, 0, newWidth, this.image.getHeight(), null);
        g2d.dispose();
        this.exportImage(modifiedImage);
        return modifiedImage.getWidth();
    }

    public boolean transformOutlineColor() throws IOException{
        boolean hasChanged = false;
        int[][] pixels = new int[image.getWidth()][image.getHeight()];
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int color = image.getRGB(x, y);
                if (color == -16776704) {
                    image.setRGB(x, y, Color.WHITE.getRGB());
                    hasChanged = true;
                }
            }
        }
        this.exportImage(this.image);
        return hasChanged;
    }
}
