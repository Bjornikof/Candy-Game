/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSEProject2;

/**
 *
 * @author dilar
 * @param <Item>
 */
public class Stack<Item> {
    private int N; // size of the stack 
    private Node<Item> first;

    private static class Node<Item> {

        private Item item;
        private Node<Item> next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }
    public boolean crushSameShape(){
        if(!isEmpty()){
        int itemno=1;
        int sameshapecount = 0;
        boolean diditcrush= false;
        Node<Item> tmp = first;
         Candy c1= (Candy)(tmp.item);
         int prevshape = c1.shape;
         tmp = tmp.next;
        while(tmp!=null){
         itemno++;
            Candy c= (Candy)(tmp.item);
            int shape = c.shape;
            if(prevshape==shape){
                prevshape = shape;
                sameshapecount++;
                if(sameshapecount==2 && diditcrush==false){
                    crush(itemno);
                    diditcrush = true;
                    sameshapecount=0;
                }
            }
            else{
                prevshape= shape;
                sameshapecount=0;
            }
            tmp=tmp.next;
        }
        return diditcrush;
        }
        return false;
    }
    public boolean crushSameColor(){
        if(!isEmpty()){
        int itemno=1;
        int samecolorcount = 0;
        boolean diditcrush= false;
        Node<Item> tmp = first;
         Candy c1= (Candy)(tmp.item);
         String prevcolor = c1.color;
         tmp = tmp.next;
        while(tmp!=null){
         itemno++;
            Candy c= (Candy)(tmp.item);
            String color = c.color;
            if(prevcolor.equals(color)){
                prevcolor= color;
                samecolorcount++;
                if(samecolorcount==2 && diditcrush==false){
                    crush(itemno);
                    diditcrush = true;
                    samecolorcount=0;
                }
            }
            else{
                prevcolor= color;
                samecolorcount=0;
            }
            tmp=tmp.next;
        }
        return diditcrush;
        }
        return false;
    }

    public void push(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<>();
        first.item = item;
        first.next = oldfirst;
        N++;
    }
    
     public Item pop() {
        if (isEmpty()) throw new java.util.NoSuchElementException("Stack Underflow!");
        Item item = first.item;        // save item to return
        first = first.next;            // delete first node
        N--;
        return item;                   // return the saved item
    }
     public void crush(int itemno){
         int pushcount = itemno-3;
         if(pushcount==0){
             pop();
             pop();
             pop();
         }
         else{
             Queue<Item> savedcandies = new Queue(pushcount);
             for(int i=0; i<pushcount; i++){
                 savedcandies.enqueue(pop());
             }
             pop();
             pop();
             pop();
             for(int i=0; i<pushcount;i++){
             push(savedcandies.dequeue());
             }
         }
     }
     public int FinalPointCounter(){
         int totalpoints=0;
         if(!isEmpty()){
        Node<Item> tmp = first;
        while(tmp!=null){
        totalpoints= totalpoints-2;
         tmp = tmp.next;
        }
        }
         return totalpoints;
     }
     
     public String infoStack(int x){
         if(x==1){
             System.out.println("Stack 1;");
         }
         if(x==2){
             System.out.println("Stack 2;");
         }
         if(x==3){
             System.out.println("Stack 3;");
         }
        Node<Item> tmp = first;
        String s2 = "";
        while(tmp!=null){
            Candy c= (Candy)(tmp.item);
            c.info();
            tmp = tmp.next;
        }
         return s2;
     }
}
