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
    public void isContainmentR2InsideR1Test() {
        initializeRectangleService();
        MyRectangle r1 = buildRectangle(198, 191, 209, 89);
        MyRectangle r2 = buildRectangle(235, 217, 106, 42);
        assertTrue(testService.isContainment(r1, r2));
    }

    @Test
    public void isContainmentR1InsideR2Test() {
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
    public void isIntersectionTopTest() {
        initializeRectangleService();
        MyRectangle r1 = buildRectangle(286, 194, 199, 131);
        MyRectangle r2 = buildRectangle(333, 146, 92, 91);
        assertTrue(testService.isIntersection(r1, r2).isIntersection());
    }

    @Test
    public void isIntersectionBottomTest() {
        initializeRectangleService();
        MyRectangle r1 = buildRectangle(236, 161, 370, 144);
        MyRectangle r2 = buildRectangle(342, 244, 168, 127);
        assertTrue(testService.isIntersection(r1, r2).isIntersection());
    }

    @Test
    public void isIntersectionLeftTest() {
        initializeRectangleService();
        MyRectangle r1 = buildRectangle(220, 230, 175, 122);
        MyRectangle r2 = buildRectangle(166, 259, 94, 55);
        assertTrue(testService.isIntersection(r1, r2).isIntersection());
    }

    @Test
    public void isIntersectionRightTest() {
        initializeRectangleService();
        MyRectangle r1 = buildRectangle(267, 209, 209, 166);
        MyRectangle r2 = buildRectangle(400, 224, 143, 101);
        assertTrue(testService.isIntersection(r1, r2).isIntersection());
    }

    @Test
    public void isIntersectionTopLeftCornerTest() {
        initializeRectangleService();
        MyRectangle r1 = buildRectangle(304, 204, 196, 154);
        MyRectangle r2 = buildRectangle(237, 169, 112, 70);
        assertTrue(testService.isIntersection(r1, r2).isIntersection());
    }

    @Test
    public void isIntersectionTopRightCornerTest() {
        initializeRectangleService();
        MyRectangle r1 = buildRectangle(188, 249, 199, 151);
        MyRectangle r2 = buildRectangle(344, 223, 122, 69);
        assertTrue(testService.isIntersection(r1, r2).isIntersection());
    }

    @Test
    public void isIntersectionBottomLeftCornerTest() {
        initializeRectangleService();
        MyRectangle r1 = buildRectangle(313, 180, 290, 165);
        MyRectangle r2 = buildRectangle(245, 284, 198, 111);
        assertTrue(testService.isIntersection(r1, r2).isIntersection());
    }

    @Test
    public void isIntersectionBottomRightCornerTest() {
        initializeRectangleService();
        MyRectangle r1 = buildRectangle(295, 211, 142, 111);
        MyRectangle r2 = buildRectangle(384, 284, 133, 121);
        assertTrue(testService.isIntersection(r1, r2).isIntersection());
    }

    @Test
    public void isNotIntersectionTest() {
        initializeRectangleService();
        MyRectangle r1 = buildRectangle(226, 235, 245, 103);
        MyRectangle r2 = buildRectangle(183, 339, 166, 27);
        assertFalse(testService.isIntersection(r1, r2).isIntersection());
    }

    @Test
    public void isTopAdjacencyTest() {
        initializeRectangleService();
        MyRectangle r1 = buildRectangle(222, 169, 286, 113);
        MyRectangle r2 = buildRectangle(229, 106, 200, 62);
        assertTrue(testService.isAdjacency(r1, r2));
    }

    @Test
    public void isBottomAdjacencyTest() {
        initializeRectangleService();
        MyRectangle r1 = buildRectangle(226, 235, 245, 103);
        MyRectangle r2 = buildRectangle(183, 339, 166, 27);
        assertTrue(testService.isAdjacency(r1, r2));
    }

    @Test
    public void isLeftAdjacencyTest() {
        initializeRectangleService();
        MyRectangle r1 = buildRectangle(288, 210, 175, 134);
        MyRectangle r2 = buildRectangle(210, 223, 77, 72);
        assertTrue(testService.isAdjacency(r1, r2));
    }

    @Test
    public void isRightAdjacencyTest() {
        initializeRectangleService();
        MyRectangle r1 = buildRectangle(182, 181, 163, 117);
        MyRectangle r2 = buildRectangle(346, 199, 97, 86);
        assertTrue(testService.isAdjacency(r1, r2));
    }

    @Test
    public void isNotAdjacencyTest() {
        initializeRectangleService();
        MyRectangle r1 = buildRectangle(163, 173, 228, 162);
        MyRectangle r2 = buildRectangle(286, 260, 296, 211);
        assertFalse(testService.isAdjacency(r1, r2));
    }

    private MyRectangle buildRectangle(int x, int y, int width, int height) {
        Rectangle rectangle = new Rectangle();
        rectangle.setBounds(x, y, width, height);
        return new MyRectangle(rectangle);
    }
}
