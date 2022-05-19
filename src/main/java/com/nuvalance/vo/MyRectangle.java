package com.nuvalance.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.awt.*;

@Getter
@Setter
@ToString
public class MyRectangle extends Rectangle {

    private int minimumX;
    private int maximumX;
    private int minimumY;
    private int maximumY;

    //Corners
    private Coordinate topLeft;
    private Coordinate topRight;
    private Coordinate bottomLeft;
    private Coordinate bottomRight;


    public MyRectangle(Rectangle rectangle){
        super(rectangle);
        this.calculateMaxAndMin();
        this.calculateCorners();
    }

    public void calculateMaxAndMin() {
        this.minimumX = this.x;
        this.maximumX = this.x + this.width;
        this.minimumY = this.y;
        this.maximumY = this.y + this.height;
    }

    public void calculateCorners() {
        this.topLeft = new Coordinate(this.x, this.y);
        this.topRight = new Coordinate(this.x + this.width, this.y);
        this.bottomLeft = new Coordinate(this.x, this.y + this.height);
        this.bottomLeft = new Coordinate(this.x + this.width, this.y + this.height);
    }
}
