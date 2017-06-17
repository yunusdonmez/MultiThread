/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yazlab2.pkg2;

import java.util.ArrayList;

/**
 *
 * @author Yusuf
 */
public class Node {
    public int key;
    public int ozellikTuru;
    public ArrayList <Integer> ozellik1=new ArrayList<>();
    public ArrayList <Integer> ozellik2=new ArrayList<>();
    public ArrayList <Integer> ozellik3=new ArrayList<>();
    public ArrayList <Integer> sonuc=new ArrayList<>();
    public Node left;
    public Node right;

 
     /* Constructor */
     public Node()
     {
         left = null;
         right = null;
     }

     /* Function to get left node */
     public Node getLeft()
     {
         return left;
     }
     /* Function to get right node */
    public Node getRight()
     {
         return right;
     }
}

