/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yazlab2.pkg2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Yusuf
 */
public class treeGUI extends JFrame{
    private JPanel contentPane;
	public BinaryTree tree;
	public DrawTree drawer;
	
	/**
	 * Create the frame.
	 */
	public treeGUI(BinaryTree tree) {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 700, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
               
		drawer = new DrawTree(tree);
		contentPane.add(drawer);
		setContentPane(contentPane);
		this.tree = tree;
		setVisible(true);
	}
}
