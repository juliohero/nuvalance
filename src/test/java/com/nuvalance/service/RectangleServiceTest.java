package com.nuvalance.service;



import com.nuvalance.service.MyRectangleService;
import com.nuvalance.vo.MyRectangle;
import com.nuvalance.vo.RectangleIntersection;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

public class RectangleServiceTest {

    private MyRectangleService testService;

    private void initializeRectangleService() {
        testService = new MyRectangleService();
    }

    @Test
    public void isContainmentR2InsideR1() {
        initializeRectangleService();
        MyRectangle r1 = buildRectangle(198, 191, 209, 89);
        MyRectangle r2 = buildRectangle(235, 217, 106, 42);
        assertTrue(testService.isContainment(r1, r2));
    }

    @Test
    public void isContainmentR1InsideR2() {
        initializeRectangleService();
        MyRectangle r1 = buildRectangle(192, 158, 276, 239);
        MyRectangle r2 = buildRectangle(276, 215, 123, 125);
        assertTrue(testService.isContainment(r1, r2));
    }

    @Test
    public void isNotContainment() {
        initializeRectangleService();
        MyRectangle r1 = buildRectangle(163, 173, 228, 162);
        MyRectangle r2 = buildRectangle(286, 260, 296, 211);
        assertFalse(testService.isContainment(r1, r2));
    }

    @Test
    public void isIntersection() {
        initializeRectangleService();
        MyRectangle r1 = buildRectangle(163, 173, 228, 162);
        MyRectangle r2 = buildRectangle(286, 260, 296, 211);
        assertTrue(testService.isIntersection(r1, r2).isIntersection());
    }

    @Test
    public void isNotIntersection() {
        initializeRectangleService();
        MyRectangle r1 = buildRectangle(226, 235, 245, 103);
        MyRectangle r2 = buildRectangle(183, 339, 166, 27);
        assertFalse(testService.isIntersection(r1, r2).isIntersection());
    }

    @Test
    public void isTopAdjacency() {
        initializeRectangleService();
        MyRectangle r1 = buildRectangle(222, 169, 286, 113);
        MyRectangle r2 = buildRectangle(229, 106, 200, 62);
        assertTrue(testService.isAdjacency(r1, r2));
    }

    @Test
    public void isBottomAdjacency() {
        initializeRectangleService();
        MyRectangle r1 = buildRectangle(226, 235, 245, 103);
        MyRectangle r2 = buildRectangle(183, 339, 166, 27);
        assertTrue(testService.isAdjacency(r1, r2));
    }

    @Test
    public void isLeftAdjacency() {
        initializeRectangleService();
        MyRectangle r1 = buildRectangle(288, 210, 175, 134);
        MyRectangle r2 = buildRectangle(210, 223, 77, 72);
        assertTrue(testService.isAdjacency(r1, r2));
    }

    @Test
    public void isRightAdjacency() {
        initializeRectangleService();
        MyRectangle r1 = buildRectangle(182, 181, 163, 117);
        MyRectangle r2 = buildRectangle(346, 199, 97, 86);
        assertTrue(testService.isAdjacency(r1, r2));
    }

    @Test
    public void isNotAdjacency() {
        initializeRectangleService();
        MyRectangle r1 = buildRectangle(163, 173, 228, 162);
        MyRectangle r2 = buildRectangle(286, 260, 296, 211);
        assertFalse(testService.isAdjacency(r1, r2));
    }

    private MyRectangle buildRectangle(int x, int y, int width, int height) {
        Rectangle rectangle = new Rectangle();
        rectangle.setBounds(x,y, width, height);
        return new MyRectangle(rectangle);
    }
}
