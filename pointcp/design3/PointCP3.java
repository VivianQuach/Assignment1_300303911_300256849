package design2, design3; 

import java.io.IOException;
import java.lang.Math;

// This file contains material supporting section 2.9 of
//the textbook :
// "Object Oriented Software Engineering" and is issued under the
// open-source license found at www.lloseng.com
// @author Amr Bakouban, 300256849
/**
 * This class contains instances of coordinates in either polar or
 * cartesian format. It also provides the utilities to convert
 * them into the other type. It is not an optimal design, it is used
 * only to illustrate some design issues.
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge
 * @version July 2000
 */
public class PointCP3 {
  // Instance variables ************************************************
  /**
   * Contains C(artesian) or P(olar) to identify the type of
   * coordinates that are being dealt with.
   */
  private char typeCoord;
  /**
   * Contains the current value of X or RHO depending on the type
   * of coordinates.
   */
  private double x;
  /**
   * Contains the current value of Y or THETA value depending on the
   * type of coordinates.
   */
  private double y;
  // Constructors ******************************************************
  /**
   * Constructs a coordinate object, with a type identifier.
   */
  public PointCP3(double x, double y) {
    this.x = x;
    this.y = y;
  }
  // Instance methods **************************************************
  public double getX() {
    return this.x;
  }
  public double getY() 
  {
    return this.y;
  }
  public double getRho() {
    return (Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2)));
  }
  public double getTheta() {
    return Math.toDegrees(Math.atan2(this.y, this.x));
  }
  /**
   * Converts Cartesian coordinates to Polar coordinates.
   */
  public PointCP2 convertStorageToPolar() {
    PointCP2 conversion = new PointCP2(getRho(), getTheta());
    return conversion;
  }
  /**
   * Converts Polar coordinates to Cartesian coordinates.
   */
  public void convertStorageToCartesian() {
    return;
  }
  /**
   * Calculates the distance in between two points using the Pythagorean
   * theorem (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
   *
   * @param pointA The first point.
   * @param pointB The second point.
   * @return The distance between the two points.
   */
  public double getDistance(PointCP3 pointB) {
    // Obtain differences in X and Y, sign is not important as these values
    // will be squared later.
    double deltaX = getX() - pointB.getX();
    double deltaY = getY() - pointB.getY();
    return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
  }
  /**
   * Rotates the specified point by the specified number of degrees.
   * Not required until E2.30
   * @param rotation The number of degrees to rotate the point.
   * @return The rotated image of the original point.
   */
  public PointCP3 rotatePoint(double rotation) {
    double radRotation = Math.toRadians(rotation);
    double X = getX();
    double Y = getY();
    return new PointCP3(

        (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
        (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
  }
  /**
   * Returns coordinates.
   * @return A String containing coordinates.
   */
  public String toString() {
    return "Stored as Polar [" + getX() + ',' + getY() + "]" + "\n" + "Computed as Cartesian [" + getRho() + ',' + getTheta() + "]";
  }
}
