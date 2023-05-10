/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.


/**
 *
 * @author Computer
 */
public class Main {

  



    
    private static class Node {
        int value;
        Node next;
        
        Node(int value) {
            this.value = value;
        }
    }
    
    private Node head;
    
    // Add a block to the top of the peg
    private void push(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }
    
    // Remove and return the top block from the peg
    private int pop() {
        if (head == null) {
            throw new IllegalStateException("Peg is empty.");
        }
        int value = head.value;
        head = head.next;
        return value;
    }
    
    // Move a block from this peg to another peg
    private void moveBlockTo(int block, Main toPeg) {
        int value = pop();
        if (value != block) {
            throw new IllegalStateException("Expected block " + block + " but got " + value);
        }
        toPeg.push(value);
        System.out.println("Move block " + block + " from peg " + this + " to peg " + toPeg);
    }
    
    // Solve the Tower of Hanoi problem for the given number of blocks
    public static void solve(int numBlocks) {
        Main peg1 = new Main();
        Main peg2 = new Main();
        Main peg3 = new Main();
        for (int i = numBlocks; i >= 1; i--) {
            peg1.push(i);
        }
        moveBlocks(numBlocks, peg1, peg3, peg2);
    }
    
    // Move the given number of blocks from one peg to another using an intermediate peg
    private static void moveBlocks(int numBlocks, Main fromPeg, Main toPeg, Main intermediatePeg) {
        if (numBlocks == 1) {
            fromPeg.moveBlockTo(1, toPeg);
        } else {
            moveBlocks(numBlocks - 1, fromPeg, intermediatePeg, toPeg);
            fromPeg.moveBlockTo(numBlocks, toPeg);
            moveBlocks(numBlocks - 1, intermediatePeg, toPeg, fromPeg);
        }
    }
    
    // Print the blocks on this peg
    public String toString() {
        return Integer.toString(System.identityHashCode(this));
    }
    
    // Test the Tower of Hanoi solver
    public static void main(String[] args) {
        int numBlocks = 3;
        solve(numBlocks);
    }

}
