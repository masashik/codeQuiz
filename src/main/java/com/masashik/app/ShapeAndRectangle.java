package com.masashik.app;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ShapeAndRectangle {
  public static void main(String args[] ) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    Scanner scanner = new Scanner(System.in);
    int len = scanner.nextInt();
    int bre = scanner.nextInt();

    Rectangle rec = new Rectangle(len, bre);
    rec.area();

  }
}

class Shape {

  int length = 0;
  int breadth = 0;

  public Shape(int _length, int _breadth) {
    this.length = _length;
    this.breadth = _breadth;
  }

  public void area() {
    System.out.println(length + " " + breadth);
  }
}

class Rectangle extends Shape {

  public Rectangle(int length, int breadth) {
    super(length, breadth);
  }

  public void area() {
    super.area();
    System.out.println(length * breadth);
  }

}

