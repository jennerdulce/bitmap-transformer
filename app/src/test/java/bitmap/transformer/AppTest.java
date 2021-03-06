/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bitmap.transformer;

import org.junit.jupiter.api.Test;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test void greyscale_image() throws IOException {
        App systemUnderTest = new App();
        String transformGrey = "greyJohn";
        String inputFilePathToImage = "/Users/jenner/codefellows/Java-401/bitmap-transformer/app/src/main/resources/baldy-8bit.bmp";
        String outputFilePathToFolder = "/Users/jenner/codefellows/Java-401/bitmap-transformer/app/src/main/transformedPictures";
        Bitmap imageOne = new Bitmap(inputFilePathToImage, outputFilePathToFolder, transformGrey);
        BufferedImage actualResult = imageOne.transformGrey();
        assertEquals(true, actualResult instanceof BufferedImage, "Should return a buffered image.");
    }

    @Test void change_width() throws IOException{
        App systemUnderTest = new App();
        String inputFilePathToImage = "/Users/jenner/codefellows/Java-401/bitmap-transformer/app/src/main/resources/baldy-8bit.bmp";
        String outputFilePathToFolder = "/Users/jenner/codefellows/Java-401/bitmap-transformer/app/src/main/transformedPictures";
        Bitmap imageOne = new Bitmap(inputFilePathToImage, outputFilePathToFolder, "someName");
        int expectedResult= 500;
        int actualResult = imageOne.transformWidth(500);
        assertEquals(expectedResult, actualResult, "Should result to true to verify that pixels have been change");
    }

    @Test void modify_outline() throws IOException {
        App systemUnderTest = new App();
        String inputFilePathToImage = "/Users/jenner/codefellows/Java-401/bitmap-transformer/app/src/main/resources/baldy-8bit.bmp";
        String outputFilePathToFolder = "/Users/jenner/codefellows/Java-401/bitmap-transformer/app/src/main/transformedPictures";
        Bitmap imageOne = new Bitmap(inputFilePathToImage, outputFilePathToFolder, "changeOutline");
        boolean actualResult = imageOne.transformOutlineColor();
        assertEquals(true, actualResult, "Should return a buffered image.");
    }
}
