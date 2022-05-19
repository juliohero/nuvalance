package com.nuvalance.service;

import com.nuvalance.vo.Coordinate;
import com.nuvalance.vo.MyRectangle;
import com.nuvalance.vo.RectangleIntersection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.Serializable;

@Service
public class MyRectangleService implements Serializable {

    @Autowired
    public MyRectangleService() {
    }

    /**
     * This MyRectangle contains the specified point if
     *
     * The X coordinate r2X of the point lies between r1X and r1X + width
     *
     * and
     *
     * The Y coordinate r2Y of the point lies between r1Y and r1Y + height
     *
     * @param r1X - The x position of the coordinate to check for MyRectangle 1
     * @param r1Y - The y position of the coordinate to check for MyRectangle 1
     * @param r2X - The x position of the coordinate to check for MyRectangle 2
     * @param r2Y - The y position of the coordinate to check for MyRectangle 2
     * @param r1W - Width for MyRectangle 1
     * @param r1H - Height for MyRectangle 1
     * @return true if the specified coordinates for both MyRectangles indicate one intersects with another
     */
    public boolean contains(int r1X, int r1Y, int r2X, int r2Y, int r1W, int r1H) {
        return (r2X >= r1X
                && r2Y >= r1Y
                && r2X <= r1X + r1W
                && r2Y <= r1Y + r1H);
    }

    /**
     * The MyRectangle overlaps the specified MyRectangle if the MyRectangle contains any of the corners.
     *
     * If true
     *
     * Then, based on the minimum and maximum for each rectangle, these are validated to detect the intersection based on the position
     *
     *
     * @param r1 - The MyRectangle for reference
     * @param r2 - The MyRectangle to check.
     * @return - RectangleIntersection if any corner or part of the MyRectangle is contained,
     * also return the 2 coordinates for the intersections
     */
    public RectangleIntersection isIntersection(MyRectangle r1, MyRectangle r2) {
        RectangleIntersection intersection = new RectangleIntersection();
        intersection.setIntersection(contains(r1.x, r1.y, r2.x, r2.y, r1.width, r1.height)
                || contains(r1.x, r1.y, r2.x + r2.width, r2.y + r2.height, r1.width, r1.height)
                || contains(r1.x, r1.y, r2.x, r2.y + r2.height, r1.width, r1.height)
                || contains(r1.x, r1.y, r2.x + r2.width, r2.y, r1.width, r1.height));


        if (intersection.isIntersection()) {
            int x5 = 0, y5 = 0;
            int x6 = 0, y6 = 0;

            //Not a corner Just a part of the rectangle intersected on the other rectangle on the X axis, on top or bottom
            if (r1.getMinimumX() < r2.getMinimumX() &&
                r2.getMaximumX() < r1.getMaximumX())   {
                if (r2.getMaximumY() < r1.getMaximumY()) {
                    //Top
                    x5 = r2.getMinimumX();
                    y5 = r1.getMinimumY();
                    x6 = r2.getMaximumX();
                    y6 = r1.getMinimumY();
                } else {
                    //Bottom
                    x5 = r2.getMinimumX();
                    y5 = r1.getMaximumY();
                    x6 = r2.getMaximumX();
                    y6 = r1.getMaximumY();
                }
            }
            //Not a corner Just a part of the rectangle intersected on the other rectangle on the Y axis, on left or right
            else if (r1.getMinimumY() < r2.getMinimumY() &&
                    r2.getMaximumY() < r1.getMaximumY())   {
                if (r2.getMaximumX() < r1.getMaximumX()) {
                    //Left
                    x5 = r1.getMinimumX();
                    y5 = r2.getMinimumY();
                    x6 = r1.getMinimumX();
                    y6 = r2.getMaximumY();
                } else {
                    //Right
                    x5 = r1.getMaximumX();
                    y5 = r2.getMinimumY();
                    x6 = r1.getMaximumX();
                    y6 = r2.getMaximumY();
                }
            }
            //Corners
            else if (r1.getMaximumX() < r2.getMaximumX() &&
                    r1.getMaximumY() < r2.getMaximumY()){
                //Bottom Right Corner
                x5 = r1.getMaximumX();
                y5 = r2.getMinimumY();
                x6 = r2.getMinimumX();
                y6 = r1.getMaximumY();
            } else if (r1.getMaximumX() < r2.getMaximumX() &&
                    r1.getMaximumY() > r2.getMaximumY()) {
                //Top Right Corner
                x5 = r1.getMaximumX();
                y5 = r2.getMaximumY();
                x6 = r2.getMinimumX();
                y6 = r1.getMinimumY();
            } else if (r1.getMaximumX() > r2.getMaximumX() &&
                    r1.getMaximumY() > r2.getMaximumY()) {
                //Bottom Top Left Corner
                x5 = r2.getMaximumX();
                y5 = r1.getMinimumY();
                x6 = r1.getMinimumX();
                y6 = r2.getMaximumY();
            } else if (r1.getMaximumX() > r2.getMaximumX() &&
                    r1.getMaximumY() < r2.getMaximumY()) {
                //Bottom Bottom Left Corner
                x5 = r1.getMinimumX();
                y5 = r2.getMinimumY();
                x6 = r2.getMaximumX();
                y6 = r1.getMaximumY();
            }

            intersection.setIntersectionPoint1(new Coordinate(x5,y5));
            intersection.setIntersectionPoint2(new Coordinate(x6,y6));
        }
        return intersection;
    }



    /**
     * The MyRectangle contains the specified MyRectangle if the MyRectangle contains both diagonally opposite corners.
     *
     * @param r1 - The MyRectangle for reference
     * @param r2 - The MyRectangle to check.
     * @return - true if the specified MyRectangle is entirely contained.
     */
    public boolean isContainment(MyRectangle r1, MyRectangle r2) {
        return contains(r1.x, r1.y, r2.x, r2.y, r1.width, r1.height)
                && contains(r1.x, r1.y, r2.x + r2.width, r2.y + r2.height, r1.width, r1.height);
    }

    /**
     * This MyRectangle is adjacent to another if
     *
     * Top:
     * The Y coordinate of r1 is 1 apart for Y Coordinates of r2 Y + height
     * and X and Y coordinates of r2 is between coincide with r1 X + width and Y + height
     *
     * or
     *
     * Bottom:
     * The Y coordinate of r2 is 1 apart for Y Coordinates of r1 Y + height
     * and X and Y coordinates of r1 is between coincide with r2 X + width and Y + height
     *
     * or
     *
     * Left:
     * The X coordinate of r1 is 1 apart for X Coordinates of r2 Y + width
     * and X and Y coordinates of r2 is between coincide with r1 X + width and Y + height
     *
     * or
     *
     * Right:
     * The X coordinate of r2 is 1 apart for X Coordinates of r1 Y + width
     * and X and Y coordinates of r1 is between coincide with r2 X + width and Y + height
     *
     * @param r1X - The x position of the coordinate to check for MyRectangle 1
     * @param r1Y - The y position of the coordinate to check for MyRectangle 1
     * @param r2X - The x position of the coordinate to check for MyRectangle 2
     * @param r2Y - The y position of the coordinate to check for MyRectangle 2
     * @param r1W - Width for MyRectangle 1
     * @param r1H - Height for MyRectangle 1
     * @param r2W - Width for MyRectangle 2
     * @param r2H - Height for MyRectangle 2
     * @return true if the coordinates indicate adjacency between MyRectangles
     */
    public boolean isAdjacency(int r1X, int r1Y, int r2X, int r2Y, int r1W, int r1H, int r2W, int r2H) {
        //Top
        if ( r1Y - (r2Y + r2H) == 1
                && (r2X <= r1X + r1W)
                && (r2Y <= r1Y + r1H)) {
            System.out.println("Top");
            System.out.println((r2Y + r2H));
            System.out.println(r1Y);
            return true;
        }
        //Bottom
        else  if ( r2Y - (r1Y + r1H) == 1
                && (r1X <= r2X + r2W)
                && (r1Y <= r2Y + r2H)) {
            System.out.println("Bottom");
            System.out.println((r1Y + r1H ));
            System.out.println(r2Y);
            return true;
        }
        //Left
        else  if ( r1X - (r2X + r2W) == 1
                && r2Y <= (r1Y + r1H)
                && r2X <= (r1X + r1W)) {
            System.out.println("Left");
            System.out.println((r2X + r2W));
            System.out.println(r1X);
            return true;
        }
        //Right
        else  if ( r2X - (r1X + r1W) == 1
                && r1Y <= (r2Y + r2H)
                && r1X <= (r2X + r2W)) {
            System.out.println("Right");
            System.out.println((r1X + r1W));
            System.out.println(r2X);
            return true;
        }
        return false;
    }

    /**
     * One of the MyRectangles is at a side of the other
     *
     * @param r1 - The MyRectangle for reference
     * @param r2 - The MyRectangle to check.
     * @return - true if the specified MyRectangle is entirely contained.
     */
    public boolean isAdjacency(MyRectangle r1, MyRectangle r2) {
        return isAdjacency(r1.x, r1.y, r2.x, r2.y, r1.width, r1.height, r2.width, r2.height);
    }
}
