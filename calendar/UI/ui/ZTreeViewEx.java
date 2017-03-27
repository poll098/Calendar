package ui;


	import java.awt.BorderLayout; 
	import javax.swing.JFrame; 
	import javax.swing.JMenu; 
	import javax.swing.JMenuBar; 
	import javax.swing.JMenuItem; 
	import javax.swing.JPanel; 
	import javax.swing.JSplitPane; 
	import javax.swing.JTable; 
	import javax.swing.JTree; 
	import javax.swing.tree.DefaultMutableTreeNode; 
	class ZTreeViewEx extends JPanel { 
	   public ZTreeViewEx() { 
	      setLayout( new BorderLayout() ); 
	      DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root"); 
	      DefaultMutableTreeNode mercury = new DefaultMutableTreeNode("Mercury"); 
	      DefaultMutableTreeNode mercury1 = new DefaultMutableTreeNode("Mercury1"); 
	      root.add(mercury); 
	      mercury.add(mercury1);
	      DefaultMutableTreeNode venus = new DefaultMutableTreeNode("Venus"); 
	      root.add(venus); 
	      DefaultMutableTreeNode mars = new DefaultMutableTreeNode("Mars"); 
	      root.add(mars); 
	      JTree tree = new JTree(root); 
	      add( tree, BorderLayout.CENTER ); 
	   } 
	} 
	class TableViewEx extends JPanel { 
	   public TableViewEx() { 
	      setLayout( new BorderLayout() ); 
	      String columnNames[] = 
	      { "��ǰ��ȣ", "��ǰ�̸�", "��ǰ����", "��ǰ����" }; 
	      Object rowData[][] = 
	      { 
	         { 1, "������", 100, "������" }, 
	         { 2, "������", 200, "�ҷ���ǰ" }, 
	         { 3, "ĭ����", 300, "���ڰ��� ������" } }; 
	         JTable table = new JTable(rowData, columnNames); 
	         add( table, BorderLayout.CENTER ); 
	      } 
	   } 

