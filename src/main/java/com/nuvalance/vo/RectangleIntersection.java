package com.nuvalance.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RectangleIntersection {
    private boolean isIntersection;
    private Coordinate intersectionPoint1;
    private Coordinate intersectionPoint2;
}
