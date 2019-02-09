/**
* author: Dilara Ünbay
* twitter: twitter.com/bjornikof
* 
* The MIT License (MIT)
*
* Copyright (c) 2019 Dilara Ünbay
*
* Permission is hereby granted, free of charge, to any person obtaining a copy
* of this software and associated documentation files (the "Software"), to deal
* in the Software without restriction, including without limitation the rights
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the Software is
* furnished to do so, subject to the following conditions:
*
* The above copyright notice and this permission notice shall be included in all
* copies or substantial portions of the Software.
*
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
* SOFTWARE.
 */

package CSEProject2;

import java.util.Scanner;

public class Game{
    
    public static void main(String[] args) {
        // k=40 or more done here;
        int k = (int)(Math.random()*((100-40)+1)+40);
        // Queue & Stacks created, Queue filled here;
        Queue<Candy> candylist = new Queue<>(k);
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();
        Stack stack3 = new Stack();
        for(int i=0; i<k; i++){
            Candy c = new Candy();
            candylist.enqueue(c);
        }
        //Added five candies to the stacks so that game is playable.
        for(int i=0; i<5; i++){
            stack1.push(candylist.dequeue());
            stack2.push(candylist.dequeue());
            stack3.push(candylist.dequeue());
        }
        int turn = 10;
        int totalpoints = 0;
        //Actual game starts here;
        while(turn!=0){
            if(turn==10){
                System.out.println("WELCOME TO CANDY CRUSH STACK");
                System.out.println("----------------------------");
            }
            else{
            System.out.println("----------------------------");
            System.out.println("NEW TURN");
            System.out.println("----------------------------");
            }
        stack1.push(candylist.dequeue());
        //User's turn.
        int noofcommands = 0;
        while(noofcommands<2){
            //end turn if there is no candy left in stacks.
            if(stack1.isEmpty()==true &&stack2.isEmpty()==true &&stack3.isEmpty()==true){
                noofcommands=3;
            }
            //also end turn if there is only one candy.
            if(stack1.size()<2 &&stack2.isEmpty()==true &&stack3.isEmpty()==true
            || stack2.size()<2 &&stack1.isEmpty()==true &&stack3.isEmpty()==true
            || stack3.size()<2 &&stack2.isEmpty()==true &&stack1.isEmpty()==true){
                noofcommands=3;
            }
            ShowStatus(stack1,stack2,stack3,candylist);
            Scanner scn = new Scanner(System.in);
            System.out.println("Choose a stack to pop from: ");
            int popfrom = scn.nextInt();
            System.out.println("Choose a stack to push: ");
            int pushto = scn.nextInt();
            //Pop-Push performed here;
            if(popfrom == 1 && pushto == 2 && stack1.isEmpty()==false){
                stack2.push(stack1.pop());
                noofcommands++;
            }
            else if(popfrom == 1 && pushto == 3 && stack1.isEmpty()==false){
                stack3.push(stack1.pop());
                noofcommands++;
            }
            else if(popfrom == 2 && pushto == 1 && stack2.isEmpty()==false){
                stack1.push(stack2.pop());
                noofcommands++;
            }
            else if(popfrom == 2 && pushto == 3 && stack2.isEmpty()==false){
                stack3.push(stack2.pop());
                noofcommands++;
            }
            else if(popfrom == 3 && pushto == 1 && stack3.isEmpty()==false){
                stack1.push(stack3.pop());
                noofcommands++;
            }
            else if(popfrom == 3 && pushto == 2 && stack3.isEmpty()==false){
                stack2.push(stack3.pop());
                noofcommands++;
            }
            else {
                System.out.println("->Please enter '1','2' or '3' to push.");
                System.out.println("->You can't pop and push from the same stack!");
                System.out.println("->You can't pop and push from an empty stack!");
                System.out.println("Enter 'ok' to continue: ");
                scn.next();
            }
            ShowStatus(stack1, stack2, stack3, candylist);
            System.out.println("Do you want to crush?: ");
            String crushorno = scn.next();
            isCrush(crushorno);
            //Crush is performed here;
            if(isCrush(crushorno)==true){
                System.out.println("Choose a stack to crush: ");
                int stackno = scn.nextInt();
                switch (stackno) {
                    case 1:
                        {
                            noofcommands++;
                            boolean crushshape =stack1.crushSameShape();
                            boolean crushcolor =stack1.crushSameColor();
                            if(crushshape==true && crushcolor==false){
                                totalpoints =totalpoints+CrushPoints(false);
                            }
                            else if(crushcolor==true && crushshape==false){
                                totalpoints =totalpoints+CrushPoints(false);
                            }
                            else if(crushshape== true && crushcolor==true){
                                totalpoints =totalpoints+CrushPoints(true);
                            }
                            else{
                                System.out.println("YOU CAN'T CRUSH THIS STACK!");
                                System.out.println("->You can crush three same color candies.");
                                System.out.println("->You can crush three same shape candies.");
                                System.out.println("Enter 'ok' to continue: ");
                                scn.next();
                            }       break;
                        }
                    case 2:
                        {
                            noofcommands++;
                            boolean crushshape =stack2.crushSameShape();
                            boolean crushcolor =stack2.crushSameColor();
                            if(crushshape==true && crushcolor==false){
                                totalpoints =totalpoints+CrushPoints(false);
                            }
                            else if(crushcolor==true && crushshape==false){
                                totalpoints =totalpoints+CrushPoints(false);
                            }
                            else if(crushshape== true && crushcolor==true){
                                totalpoints =totalpoints+CrushPoints(true);
                            }
                            else{
                                System.out.println("YOU CAN'T CRUSH THIS STACK!");
                                System.out.println("->You can crush three same color candies.");
                                System.out.println("->You can crush three same shape candies.");
                                System.out.println("Enter 'ok' to continue: ");
                                scn.next();
                            }       break;
                        }
                    case 3:
                        {
                            noofcommands++;
                            boolean crushshape =stack3.crushSameShape();
                            boolean crushcolor =stack3.crushSameColor();
                            if(crushshape==true && crushcolor==false){
                                totalpoints =totalpoints+CrushPoints(false);
                            }
                            else if(crushcolor==true && crushshape==false){
                                totalpoints =totalpoints+CrushPoints(false);
                            }
                            else if(crushshape== true && crushcolor==true){
                                totalpoints =totalpoints+CrushPoints(true);
                            }
                            else{
                                System.out.println("YOU CAN'T CRUSH THIS STACK!");
                                System.out.println("->You can crush three same color candies.");
                                System.out.println("->You can crush three same shape candies.");
                                System.out.println("Enter 'ok' to continue: ");
                                scn.next();
                            }       break;
                        }
                    default:
                        System.out.println("->Please enter '1','2' or '3' to crush.");
                        System.out.println("Enter 'ok' to continue: ");
                        scn.next();
                        break;
                }
            }
            if(noofcommands>2){
                System.out.println("->End of this turn. Proceeding to next turn.");
            }
        }
        //Checking candies before proceeding with turns.
        if(candylist.isEmpty()){
            turn =0;
        }
        else{
            turn--;
        }
    }
        System.out.println("----------------------------");
        System.out.println("GAME IS OVER");
        System.out.println("----------------------------");
        int maximumpoints= totalpoints;
        totalpoints=totalpoints+StackPoints(stack1, stack2, stack3);
        if(maximumpoints==totalpoints){
            System.out.println("˙˚ʚ(´◡`)ɞ˚˙ CONGRATULATIONS ˙˚ʚ(´◡`)ɞ˚˙");
            System.out.println("->You earned "+totalpoints+" points and"
                    + " you had no candies left.");
        }
        else if(totalpoints<0){
            System.out.println("☹ YOU CAN DO BETTER ☹");
            System.out.println("->You earned "+totalpoints+" points.");
        }
        else
            System.out.println("㋡ NOT BAD ㋡");
        System.out.println("->You earned "+totalpoints+" points.");
        }
    
    public static void ShowStatus(Stack s1, Stack s2, Stack s3, Queue cl){
        System.out.println(s1.infoStack(1));
        System.out.println(s2.infoStack(2));
        System.out.println(s3.infoStack(3));
        System.out.println(cl.infoQueue());
    }
    public static int StackPoints(Stack s1, Stack s2, Stack s3){
        int stackpoints=0;
        stackpoints= stackpoints+s1.FinalPointCounter()+
        s2.FinalPointCounter()+s3.FinalPointCounter();
        return stackpoints;
    }
    public static int CrushPoints(boolean x){
        //It always crashes 3 candies. Not less or more.
        int N=3;
        int earnedpoints;
        if(x==false){
        earnedpoints= (int)(Math.pow(2, N));
        System.out.println("->You earned "+earnedpoints+" points for crushing.");
        }
        else{
        earnedpoints= (int)(Math.pow(2, (N+2)));
        System.out.println("->You earned "+earnedpoints+" points for crushing.");
        }
        return earnedpoints;
    }
    public static boolean isCrush(String x){
        if("Yes".equals(x) || "yes".equals(x)){
            return true;
        }
        else if("No".equals(x) || "no".equals(x)){
            return false;
        }
        else{
            Scanner scn = new Scanner(System.in);
            System.out.println("->Please enter 'Yes' or 'No' to crush.");
            System.out.println("Enter 'ok' to continue: ");
            scn.next();
        }
        return false;
    }
}
