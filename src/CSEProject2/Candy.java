/*
 author: Dilara Ünbay
 twitter: twitter.com/bjornikof
 
The MIT License (MIT)

Copyright (c) 2019 Dilara Ünbay

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */

package CSEProject2;

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
