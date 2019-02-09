/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSEProject2;
/**
 *
 * @author dilar
 */
public class Candy {
    int shape;
    int point;
    String color;
    String reset;
    
    public Candy(){
        this.shape = randomShape();
        this.color = randomColor();
        this.point = 1;
        this.reset = "\033[0m";
    }
    
    public final String randomColor(){
        String red = "\033[0;31m";
        String blue = "\033[0;34m";
        String green = "\033[0;32m";
        String yellow = "\033[0;33m";
        int random = (int)(Math.random()*4);
        switch (random) {
            case 1:
                return red;
            case 2:
                return blue;
            case 3:
                return green;
            default:
                return yellow;
        }
    }
    
    public final int randomShape(){
        int square = 9632;
        int triangle = 9650;
        int circle = 9679;
        int star = 9733;
        int random = (int)(Math.random()*4);
        switch (random) {
            case 1:
                return square;
            case 2:
                return triangle;
            case 3:
                return circle;
            default:
                return star;
        }
    }
    
    public void info(){
//       String s1 = "";
//       
//       s1 +=System.out.printf("%s %c %s", color, shape, reset);
//       return s1;
System.out.printf("%s %c %s", color, shape, reset);
    }
}
