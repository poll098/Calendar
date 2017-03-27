package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class EAdd_Group extends JFrame {

	   private JPanel contentPane;
	   private GroupData groupData;
	   
	   private JLabel GroupIntroLabel;
	   
	   private JTextField GroupNameField;
	   private JTextField GroupIntroField;
	   private EFriend_GroupUI eFGUi;
	   
	   public EAdd_Group(EFriend_GroupUI eFGUi) {
			  
		   	this.eFGUi = eFGUi;
		   
		      setTitle("Make Group");
		      setResizable(false);
		      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		      setBounds(100, 100, 400, 420);
		      contentPane = new JPanel();
		      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		      setContentPane(contentPane);
		      contentPane.setLayout(null);

		      JLabel PrefaceLabel = new JLabel("�׷� ����");
		      PrefaceLabel.setFont(new Font("����", Font.BOLD, 18));
		      PrefaceLabel.setBounds(150, 0, 100, 50);
		      contentPane.add(PrefaceLabel);
		      
		      JLabel GroupNameLabel = new JLabel("�׷��̸� :");
		      GroupNameLabel.setBounds(70, 100, 65, 15);
		      contentPane.add(GroupNameLabel);
		      
		      JLabel GroupIntroLabel = new JLabel("�׷�Ұ� :");
		      GroupIntroLabel.setBounds(70, 150, 65, 15);
		      contentPane.add(GroupIntroLabel);
		      
		      GroupNameField = new JTextField();
		      GroupNameField.setBounds(140, 100, 158, 21);
		      contentPane.add(GroupNameField);
		      GroupNameField.setColumns(10);
		      
		      GroupIntroField = new JTextField();
		      GroupIntroField.setColumns(10);
		      GroupIntroField.setBounds(140, 150, 158, 150);
		      contentPane.add(GroupIntroField);
		      
		      JButton createGBtn = new JButton("����");
		      createGBtn.addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent e) {
		            //���� ���� 
		        	 setGroupData();
		        	 eFGUi.addGroup(groupData);
		        	 for(int i=0; i<eFGUi.getGroupNum();i++){	//�׷��� �߰��� �� ���� ��� �׷��� �̸��� �Ұ� ���
		        		 System.out.println(i + "��° �׷� �̸�: " + eFGUi.getGroupName(i));
		        		 System.out.println(i + "��° �׷� �Ұ�: " + eFGUi.getGroupIntro(i));
		        	 }
		        	 System.out.println("---------------------------------------");
		        	 dispose();       	 
		        	 
		         }
		      });
		      createGBtn.setBounds(70, 320, 97, 23);
		      contentPane.add(createGBtn);
		      
		      JButton cancleBtn = new JButton("���");
		      cancleBtn.addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent e) {
		        	 dispose();       	 
		         }
		      });
		      cancleBtn.setBounds(220, 320, 97, 23);
		      contentPane.add(cancleBtn);
	   }
	   
	   
	   public void setGroupData(){//GroupData Set
		   	groupData = new GroupData(GroupNameField.getText(),GroupIntroField.getText());
	    	   }
	   
}
