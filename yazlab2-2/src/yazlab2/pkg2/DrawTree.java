/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yazlab2.pkg2;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.JPanel;


public class DrawTree extends JPanel{
    public BinaryTree tree;
	
	public DrawTree(BinaryTree tree){
		this.tree = tree;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		g.setFont(new Font("Tahoma", Font.BOLD, 20));
		DrawTree(g, 0, getWidth(), 0, getHeight() / tree.getheight(tree.root), tree.root);
	}
	
	public void DrawNode(Graphics g,Node n,int w,int h,int q){
		g.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		if(n!=null){
			
			g.drawString(String.valueOf(n.key), (this.getWidth()/q)+w, h);
			if(n.left !=null)
				DrawNode(g, n.left, -w, h*2, q);
			if(n.right !=null)
				DrawNode(g, n.right, w*2, h*2, q);
		}
	}
    public void DrawTree(Graphics g, int StartWidth, int EndWidth, int StartHeight, int Level, Node node) {
        String data;
        if(node.right==null && node.left==null){
            g.setFont(new Font("Tahoma", Font.BOLD, 8));
            data = String.valueOf(node.sonuc.get(0));
        } 
        else{
             data = String.valueOf("("+node.key+"-F"+node.ozellikTuru+")");
             g.setFont(new Font("Tahoma", Font.BOLD, 10));
        }
        FontMetrics fm = g.getFontMetrics();
        int dataWidth = fm.stringWidth(data);
        g.drawString(data, (StartWidth + EndWidth) / 2 - dataWidth / 2, StartHeight + Level / 2);

        if (node.left != null)            
        	DrawTree(g, StartWidth, (StartWidth + EndWidth) / 2, StartHeight + Level, Level, node.left);
        
        if (node.right != null)
        	DrawTree(g, (StartWidth + EndWidth) / 2, EndWidth, StartHeight + Level, Level, node.right);
    }

}
