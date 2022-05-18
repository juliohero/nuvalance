package com.nuvalance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.Serializable;

@Service
public class RectangleService implements Serializable {

    @Autowired
    public RectangleService() {
    }

    /**
     * This rectangle contains the specified point if
     *
     * The X coordinate r2X of the point lies between r1X and r1X + width
     *
     * and
     *
     * The Y coordinate r2Y of the point lies between r1Y and r1Y + height
     *
     * @param r1X - The x position of the coordinate to check for rectangle 1
     * @param r1Y - The y position of the coordinate to check for rectangle 1
     * @param r2X - The x position of the coordinate to check for rectangle 2
     * @param r2Y - The y position of the coordinate to check for rectangle 2
     * @param r1W - Width for rectangle 1
     * @param r1H - Height for rectangle 1
     * @return true if the specified coordinates for both rectangles indicate one intersects with another
     */
    public boolean contains(int r1X, int r1Y, int r2X, int r2Y, int r1W, int r1H) {
        return (r2X >= r1X
                && r2Y >= r1Y
                && r2X <= r1X + r1W
                && r2Y <= r1Y + r1H);
    }

    /**
     * The rectangle overlaps the specified rectangle if the rectangle contains any of the corners.
     *
     * @param r1 - The rectangle for reference
     * @param r2 - The rectangle to check.
     * @return - true if any corner of the rectangle is contained.
     */
    public boolean isIntersection(Rectangle r1, Rectangle r2) {
        return contains(r1.x, r1.y, r2.x, r2.y, r1.width, r1.height)
                || contains(r1.x, r1.y, r2.x + r2.width, r2.y + r2.height, r1.width, r1.height)
                || contains(r1.x, r1.y, r2.x, r2.y + r2.height, r1.width, r1.height)
                || contains(r1.x, r1.y, r2.x + r2.width, r2.y, r1.width, r1.height);
    }


    /**
     * The rectangle contains the specified rectangle if the rectangle contains both diagonally opposite corners.
     *
     * @param r1 - The rectangle for reference
     * @param r2 - The rectangle to check.
     * @return - true if the specified rectangle is entirely contained.
     */
    public boolean isContainment(Rectangle r1, Rectangle r2) {
        return contains(r1.x, r1.y, r2.x, r2.y, r1.width, r1.height)
                && contains(r1.x, r1.y, r2.x + r2.width, r2.y + r2.height, r1.width, r1.height);
    }

    /**
     * This rectangle is adjacent to another if
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
     * @param r1X - The x position of the coordinate to check for rectangle 1
     * @param r1Y - The y position of the coordinate to check for rectangle 1
     * @param r2X - The x position of the coordinate to check for rectangle 2
     * @param r2Y - The y position of the coordinate to check for rectangle 2
     * @param r1W - Width for rectangle 1
     * @param r1H - Height for rectangle 1
     * @param r2W - Width for rectangle 2
     * @param r2H - Height for rectangle 2
     * @return true if the coordinates indicate adjajency between rectangles
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
     * One of the rectangles is at a side of the other
     *
     * @param r1 - The rectangle for reference
     * @param r2 - The rectangle to check.
     * @return - true if the specified rectangle is entirely contained.
     */
    public boolean isAdjacency(Rectangle r1, Rectangle r2) {
        return isAdjacency(r1.x, r1.y, r2.x, r2.y, r1.width, r1.height, r2.width, r2.height);
    }
}
