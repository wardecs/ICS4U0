import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture {
  ///////////////////// constructors //////////////////////////////////

  /**
   * Constructor that takes no arguments
   */
  public Picture() {
    /*
     * not needed but use it to show students the implicit call to super() child
     * constructors always call a parent constructor
     */
    super();
  }

  /**
   * Constructor that takes a file name and creates the picture
   *
   * @param fileName
   *          the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }

  /**
   * Constructor that takes the width and height
   *
   * @param height
   *          the height of the desired picture
   * @param width
   *          the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width, height);
  }

  /**
   * Constructor that takes a picture and creates a copy of that picture
   *
   * @param copyPicture
   *          the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }

  /**
   * Constructor that takes a buffered image
   *
   * @param image
   *          the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }

  ////////////////////// methods ///////////////////////////////////////

  /*
   * Main method for testing - each class in Java can have a main method
   */
  public static void main(String[] args) {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }

  /**
   * Method to set the blue to 0
   */
  public void zeroBlue() {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels) {
      for (Pixel pixelObj : rowArray) {
        pixelObj.setBlue(0);
      }
    }
  }

  /**
   * Method to return a string with information about this picture.
   *
   * @return a string with information about the picture such as fileName,
   *         height and width.
   */
  public String toString() {
    String output = "Picture, filename " + getFileName() + " height "
            + getHeight() + " width " + getWidth();
    return output;

  }

  public void keepOnlyBlue() {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
      for (Pixel pixelObj : rowArray) {
        pixelObj.setRed(0);
        pixelObj.setGreen(0);
      }
  }

  public void negate() {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
      for (Pixel pixelObj : rowArray) {
        pixelObj.setBlue(255 - pixelObj.getBlue());
        pixelObj.setRed(255 - pixelObj.getRed());
        pixelObj.setGreen(255 - pixelObj.getGreen());
      }
  }

  public void grayscale() {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
      for (Pixel pixelObj : rowArray) {
        int avg = (pixelObj.getBlue() + pixelObj.getRed() + pixelObj.getGreen()) / 3;
        pixelObj.setColor(new Color(avg, avg, avg));
      }
  }

  public void fixUnderwater() {
    Pixel[][] pixels = this.getPixels2D();
    int max = 0;

    //calculating the maximum brightness helps get us an idea of how light the scene already is
    for (Pixel[] rowArray : pixels)
      for (Pixel pixelObj : rowArray) {
        int avg = (pixelObj.getBlue() + pixelObj.getRed() + pixelObj.getGreen()) / 2; //divide by two to increase how much we'll be darkening the image by
        if (avg > max)
          max = avg;
      }

    for (Pixel[] rowArray : pixels)
      for (Pixel pixelObj : rowArray) {
        pixelObj.setBlue(2 * (pixelObj.getBlue()) - max); //brighten a little first, then decrease brightness by the value of the lightest pixel / 2
        pixelObj.setRed(2 * (pixelObj.getRed()) - max);
        pixelObj.setGreen(2 * (pixelObj.getGreen()) - max);
      }
  }

  /**
   * Method that mirrors the picture around a vertical mirror in the center of
   * the picture from left to right
   */
  public void mirrorVertical() {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }

  /**
   * Method that mirrors the picture around a vertical mirror in the center of
   * the picture from left to right
   */
  public void mirrorVerticalRightToLeft() {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
      for (int col = 0; col < width / 2; col++) {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        leftPixel.setColor(rightPixel.getColor());
      }
  }

  public void mirrorHorizontal() {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel botPixel = null;
    int height = pixels.length;
    for (int row = 0; row < height / 2; row++)
      for (int col = 0; col < pixels[0].length; col++) {
        topPixel = pixels[row][col];
        botPixel = pixels[height - row - 1][col];
        botPixel.setColor(topPixel.getColor());
      }
  }

  public void mirrorHorizontalBotToTop() {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel botPixel = null;
    int height = pixels.length;
    for (int row = 0; row < height / 2; row++)
      for (int col = 0; col < pixels[0].length; col++) {
        topPixel = pixels[row][col];
        botPixel = pixels[height - row - 1][col];
        topPixel.setColor(botPixel.getColor());
      }
  }

  public void mirrorDiagonal() {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel botPixel = null;
    //we check that it stays within the range for both the height and width of the picture with the &&
    for (int row = 0; row < pixels[0].length && row < pixels.length; row++)
      for (int col = row + 1; col < pixels[0].length && col < pixels.length; col++) {
        topPixel = pixels[row][col];
        botPixel = pixels[col][row];
        topPixel.setColor(botPixel.getColor());
      }
  }

  /** Mirror just part of a picture of a temple */
  public void mirrorTemple() {
    mirrorPartial(27, 97, 13, 276, 276, false);
  }

  public void mirrorTempleOld() {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();

    // loop through the rows
    for (int row = 27; row < 97; row++) {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++) {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
        count++;
      }
    }
    System.out.println("Iterations: " + count);
  }

  /**
   * Mirror just part of a picture of a snowman
   */
  public void mirrorArms() {
    mirrorPartial(160, 195, 100, 300, 195, true);
  }

  /**
   * Mirror just part of a picture of a seagull
   */
  public void mirrorGull() {
    mirrorPartial(230, 330, 230, 350, 350, false);
  }

  public void mirrorPartial(int rowStart, int rowEnd, int colStart, int colEnd,
                            int mirrorPoint, boolean mirrorVertically) {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] pixels = this.getPixels2D();

    for (int row = rowStart; row < rowEnd; row++) {
      for (int col = colStart; col < colEnd; col++) {
        fromPixel = pixels[row][col];
        if (mirrorVertically) {
          toPixel = pixels[mirrorPoint - row + mirrorPoint][col];

        } else {
          toPixel = pixels[row][mirrorPoint - col + mirrorPoint];
        }
        toPixel.setColor(fromPixel.getColor());
      }
    }
  }

  /**
   * copy from the passed fromPic to the specified startRow and startCol in the
   * current picture
   *
   * @param fromPic  the picture to copy from
   * @param startRow the start row to copy to
   * @param startCol the start col to copy to
   */
  public void copy(Picture fromPic, int startRow, int startCol) {
    copyPartial(fromPic, startRow, startCol, -1, -1, -1, -1);
  }

  /**
   * copy from the passed fromPic to the specified startRow and startCol in the
   * current picture
   *
   * @param fromPic  the picture to copy from
   * @param startRow the start row to copy to
   * @param startCol the start col to copy to
   */
  public void copyPartial(Picture fromPic, int startRow, int startCol, int fromRowStart, int fromColStart, int fromRowEnd, int fromColEnd) {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    if (fromRowStart < 0 || fromRowStart > fromPixels.length)
      fromRowStart = 0;
    if (fromColStart < 0 || fromColStart > fromPixels[0].length)
      fromColStart = 0;
    if (fromRowEnd < 0 || fromRowEnd > fromPixels.length)
      fromRowEnd = fromPixels.length;
    if (fromColEnd < 0 || fromColEnd > fromPixels[0].length)
      fromColEnd = fromPixels[0].length;

    for (int fromRow = fromRowStart, toRow = startRow; fromRow < fromRowEnd && toRow < toPixels.length; fromRow++, toRow++)
      for (int fromCol = fromColStart, toCol = startCol; fromCol < fromColEnd && toCol < toPixels[0].length; fromCol++, toCol++) {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
  }

  /** Method to create a collage of several pictures */
  public void createCollage() {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1, 0, 0);
    this.copy(flower2, 100, 0);
    this.copy(flower1, 200, 0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue, 300, 0);
    this.copy(flower1, 400, 0);
    this.copy(flower2, 500, 0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }

  public void myCollage() {
    Picture sans1 = new Picture("sans.jpg").scale(0.3, 0.3);
    Picture sans2 = new Picture("sans.jpg").scale(0.3, 0.3);
    Picture sans3 = new Picture("sans.jpg").scale(0.5, 0.5);

    sans1.grayscale();
    this.copy(sans1, 0, 0);
    sans1.mirrorDiagonal();
    this.copy(sans1, 0, 300);

    sans2.fixUnderwater();
    this.copy(sans2, 100, 0);

    sans3.zeroBlue();
    sans3.negate();
    this.copy(sans3, 200, 0);

  }

  /**
   * Method to show large changes in color
   *
   * @param edgeDist the distance for finding edges
   */
  public void edgeDetection(int edgeDist) {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length - 1; col++) {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col + 1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }

  /**
   * Method to show large changes in color, both horizontally and vertically
   *
   * @param edgeDist
   *          the distance for finding edges
   */
  public void myEdgeDetection(int edgeDist) {
    Pixel leftPixel;
    Pixel rightPixel;
    Pixel bottomPixel;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor;
    Color bottomColor;
    for (int row = 0; row < pixels.length - 1; row++) {
      for (int col = 0; col < pixels[0].length - 1; col++) {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col + 1];
        bottomPixel = pixels[row + 1][col];

        rightColor = rightPixel.getColor();
        bottomColor = bottomPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > edgeDist || leftPixel.colorDistance(bottomColor) > edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }

} // this } is the end of class Picture, put all new methods before this
