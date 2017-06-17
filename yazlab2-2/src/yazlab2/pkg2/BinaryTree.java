/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yazlab2.pkg2;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Yusuf
 */
public class BinaryTree {
    public Node root;
     /* Constructor */
     public BinaryTree()
     {
         root = null;
     }
     /* Function to check if tree is empty */

     /* Functions to insert data */
     public Node ekle(ArrayList <Integer> ozellik1,ArrayList <Integer> ozellik2,ArrayList <Integer> ozellik3,ArrayList <Integer> sonuc) throws InterruptedException
     {
         root=new Node();
         ekle(root,ozellik1,ozellik2,ozellik3,sonuc);
         return root;
     }
     
     /* Function for postorder traversal */
    
     public static void ekle(Node node,ArrayList <Integer> ozellik1,ArrayList <Integer> ozellik2,ArrayList <Integer> ozellik3,ArrayList <Integer> sonuc)throws InterruptedException{
                    
                    Node tmp=new Node();
                    Node tmp2=new Node();
                    node.ozellik1=ozellik1;
                    node.ozellik2=ozellik2;
                    node.ozellik3=ozellik3;
                    node.sonuc=sonuc;
                    Fonk olustur=new Fonk();
                    double ent[]=new double[3];
                    ent[0]=olustur.hesaplaEnt(ozellik1, sonuc, olustur.enk(ozellik1), olustur.enb(ozellik1));
                    ent[1]=olustur.hesaplaEnt(ozellik2, sonuc, olustur.enk(ozellik2), olustur.enb(ozellik2));
                    ent[2]=olustur.hesaplaEnt(ozellik3, sonuc, olustur.enk(ozellik3), olustur.enb(ozellik3));
                   // System.out.println("ent1 "+ent[0]+" ent2 "+ent[1]+" ent3 "+ent[2]);
                    if(ent[0]<=ent[1] && ent[0]<=ent[2]){
                         try {
                             //ent[0] kullan
                             node.key=olustur.enUygunDegeriBul(ozellik1, sonuc, olustur.enk(ozellik1), olustur.enb(ozellik1));
                         } catch (InterruptedException ex) {
                             Logger.getLogger(BinaryTree.class.getName()).log(Level.SEVERE, null, ex);
                         }
                        node.ozellikTuru=1;
                        for (int i = 0; i < ozellik1.size(); i++) {
                            if(ozellik1.get(i)<node.key){
                                tmp.ozellik1.add(ozellik1.get(i));
                                tmp.ozellik2.add(ozellik2.get(i));
                                tmp.ozellik3.add(ozellik3.get(i));
                                tmp.sonuc.add(sonuc.get(i));
                            }else{
                                tmp2.ozellik1.add(ozellik1.get(i));
                                tmp2.ozellik2.add(ozellik2.get(i));
                                tmp2.ozellik3.add(ozellik3.get(i));
                                tmp2.sonuc.add(sonuc.get(i));
                            }
                        }
                    }else if(ent[1]<=ent[0] && ent[1]<=ent[2]){
                         try {
                             //ent[1] kullan
                             node.key=olustur.enUygunDegeriBul(ozellik2, sonuc, olustur.enk(ozellik2), olustur.enb(ozellik2));
                         } catch (InterruptedException ex) {
                             Logger.getLogger(BinaryTree.class.getName()).log(Level.SEVERE, null, ex);
                         }
                        node.ozellikTuru=2;
                        for (int i = 0; i < ozellik1.size(); i++) {
                            if(ozellik2.get(i)<node.key){

                                tmp.ozellik1.add(ozellik1.get(i));
                                tmp.ozellik2.add(ozellik2.get(i));
                                tmp.ozellik3.add(ozellik3.get(i));
                                tmp.sonuc.add(sonuc.get(i));
                            }else{
                                tmp2.ozellik1.add(ozellik1.get(i));
                                tmp2.ozellik2.add(ozellik2.get(i));
                                tmp2.ozellik3.add(ozellik3.get(i));
                                tmp2.sonuc.add(sonuc.get(i));
                            }
                        }
                    }else{

                         try {
                             //ent[2] kullan
                             node.key=olustur.enUygunDegeriBul(ozellik3, sonuc, olustur.enk(ozellik3), olustur.enb(ozellik3));
                         } catch (InterruptedException ex) {
                             Logger.getLogger(BinaryTree.class.getName()).log(Level.SEVERE, null, ex);
                         }
                        node.ozellikTuru=3;
                       for (int i = 0; i < ozellik1.size(); i++) {
                            if(ozellik3.get(i)<node.key){
                                tmp.ozellik1.add(ozellik1.get(i));
                                tmp.ozellik2.add(ozellik2.get(i));
                                tmp.ozellik3.add(ozellik3.get(i));
                                tmp.sonuc.add(sonuc.get(i));
                            }else{
                                tmp2.ozellik1.add(ozellik1.get(i));
                                tmp2.ozellik2.add(ozellik2.get(i));
                                tmp2.ozellik3.add(ozellik3.get(i));
                                tmp2.sonuc.add(sonuc.get(i));
                            }
                        }
                    }
         Thread threadSol=new Thread(new Runnable() {
             @Override
             public void run() {
                if(!tmp2.ozellik1.isEmpty()){
                        int kont1=0;
                             for (int i = 0; i < sonuc.size()-1; i++) {
                                if(sonuc.get(i)!=sonuc.get(i+1)){
                                   kont1=1;
                                   break;
                               }
                            }
                         if(kont1==1)
                              try {
                                  node.right=tmp2;
                                  ekle(node.right,tmp2.ozellik1,tmp2.ozellik2,tmp2.ozellik3,tmp2.sonuc);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(BinaryTree.class.getName()).log(Level.SEVERE, null, ex);
                        }
                }
             }
         });
         Thread threadSag=new Thread(new Runnable() {
             @Override
             public void run() {
                 if(!tmp.ozellik1.isEmpty()){
                         int kont1=0;
                             for (int i = 0; i < sonuc.size()-1; i++) {
                                if(sonuc.get(i)!=sonuc.get(i+1)){
                                   kont1=1;
                                   break;
                               }
                            }
                         if(kont1==1)
                            try {
                                node.left=tmp;
                                ekle(node.left,tmp.ozellik1,tmp.ozellik2,tmp.ozellik3,tmp.sonuc);
                         } catch (InterruptedException ex) {
                             Logger.getLogger(BinaryTree.class.getName()).log(Level.SEVERE, null, ex);
                         }
                     }
             }
         });
         threadSol.start();
         threadSag.start();
         threadSol.join();
         threadSag.join();
     }
     public void preorder()
     {
         preorder(root);
     }
     
     private void preorder(Node r)
     {
         if (r != null)
         {      
             if(r.getLeft()==null && r.getRight()==null)
             {
                 System.out.println("f1 "+"f2 "+"f3 "+"sonuc");
                for (int i = 0; i < r.ozellik1.size(); i++) {
                    System.out.println(r.ozellik1.get(i)+" "+r.ozellik2.get(i)+" "+r.ozellik3.get(i)+" "+r.sonuc.get(i));
                }
             }
             preorder(r.getLeft());
             /*if(r.getRight()==null)
             {
                 System.out.println("f1 "+"f2 "+"f3 "+"sonuc");
                for (int i = 0; i < r.ozellik1.size(); i++) {
                    System.out.println(r.ozellik1.get(i)+" "+r.ozellik2.get(i)+" "+r.ozellik3.get(i)+" "+r.sonuc.get(i));
                }
             }*/
             preorder(r.getRight());
         }
     } 
     public static int ara(Node kok,int dizi[]){
         int sonuc;
         if(kok.left!=null || kok.right!=null){
             switch (kok.ozellikTuru) {
                 case 1:
                     if(dizi[0]<kok.key){
                         sonuc=ara(kok.left,dizi);
                     }else{
                         sonuc=ara(kok.right,dizi);
                     }    break;
                 case 2:
                     if(dizi[1]<kok.key){
                         sonuc=ara(kok.left,dizi);
                     }else{
                         sonuc=ara(kok.right,dizi);
                     }    break;
                 default:
                     if(dizi[2]<kok.key){
                         sonuc=ara(kok.left,dizi);
                     }else{
                         sonuc=ara(kok.right,dizi);
                     }    break;
             }
         }else{
             return kok.sonuc.get(0);
         }
         return sonuc;
     }
     public int getheight(Node root) {
		if (root == null)
			return 0;
		return Math.max(getheight(root.left), getheight(root.right)) + 1;
	}
     /* Function to insert data recursively */     
}
