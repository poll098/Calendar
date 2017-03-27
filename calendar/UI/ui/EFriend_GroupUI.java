package ui;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
public class EFriend_GroupUI extends JFrame {
	private JTabbedPane tab;
	
	private JPanel FriendPanel;
	private JTable FriendTable;
	private JScrollPane scrollPane;
	
	private JPanel GroupPanel;
	
	private JPanel RequestPanel;
	private JTable RequestTable;

	private Panel Gp1;
	private JTextField Gp1_name;
	private JTextField Gp1_member;
	private Vector <GroupData>GroupVec=new Vector<GroupData>();
	
	EAdd_Group MakeGroup=new EAdd_Group(this);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EFriend_GroupUI frame = new EFriend_GroupUI();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EFriend_GroupUI() {
		setTitle("Friend_Group");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1210, 850);
		getContentPane().setLayout(null);
			
		tab=new JTabbedPane();
		tab.setBounds(0, 0, 1194, 710);
		
	/*�ǿ��� ģ�� �г�*/
		FriendPanel = new JPanel();		
		FriendPanel.setLayout(null);
		String []columnNames={"�̸�","��ȭ��ȣ","�̸���","�׷�","�Ѹ���"};//���̺� ����� ������
		DefaultTableModel friend_model=new DefaultTableModel(columnNames,0);//������ ù��° ��
		friend_model.addRow(new Object[]{"�ֺ���","01066311668","boyoon456123@naver.com","����������Ʈ","�ݰ����ϴ�."});
		friend_model.addRow(new Object[]{"����","01022362222","gdfge@naver.com","����������Ʈ","�ݰ����ϴ�."});
		
		FriendTable = new JTable(friend_model);//ģ������Ʈ���̺�
		FriendTable.setPreferredScrollableViewportSize(new Dimension(1150, 600));			
		FriendTable.getColumnModel().getColumn(0).setPreferredWidth(100);//�� �÷��̸� ������ ���� 
		FriendTable.getColumnModel().getColumn(1).setPreferredWidth(200);
		FriendTable.getColumnModel().getColumn(2).setPreferredWidth(250);
		FriendTable.getColumnModel().getColumn(3).setPreferredWidth(200);
		FriendTable.getColumnModel().getColumn(4).setPreferredWidth(400);	
		scrollPane = new JScrollPane(FriendTable);
		scrollPane.setBounds(0, 53, 1189, 628);
		FriendPanel.add(scrollPane);
	
		JButton inviteButton = new JButton("ģ���ʴ�");//ģ���ʴ��ư
		inviteButton.setBounds(28, 20, 97, 23);
		FriendPanel.add(inviteButton);
		
		JButton addGroupButton = new JButton("�׷츸���");//�׷츸����ư
		addGroupButton.setBounds(137, 20, 114, 23);
		FriendPanel.add(addGroupButton);
		addGroupButton.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            if(e.getSource()==addGroupButton){
	               MakeGroup.setVisible(true);
	            }
	         }
	      });
		tab.addTab("ģ��", FriendPanel);
		
	/*�ǿ��� �׷��г�*/
		GroupPanel=new JPanel();	
		GroupPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 150, 100));
		
			Gp1 = new Panel();
			Gp1.setBackground(Color.LIGHT_GRAY);
			Gp1.setPreferredSize(new Dimension(350,150));
			GroupPanel.add(Gp1);
			Gp1.setLayout(null);
			
			Gp1_name = new JTextField();
			Gp1_name.setText("�׷��̸�");
			Gp1_name.setBounds(160, 35, 116, 21);
			Gp1.add(Gp1_name);
			Gp1_name.setColumns(10);
			
			Gp1_member = new JTextField();
			Gp1_member.setText("����̸�");
			Gp1_member.setColumns(10);
			Gp1_member.setBounds(160, 91, 116, 21);
			Gp1.add(Gp1_member);
			tab.addTab("�׷�", GroupPanel);
		
	/*�ǿ��� ��û�޼��� �г�*/
		RequestPanel=new JPanel();
		RequestPanel.setLayout(null);
		String []columnNames2={"������ ��","�׷�","��¥","���","��������"};
		DefaultTableModel request_model=new DefaultTableModel(columnNames2,0);
		RequestTable = new JTable(request_model);//��û����Ʈ���̺�
		RequestTable.setPreferredScrollableViewportSize(new Dimension(1150, 600));	
		RequestTable.getColumnModel().getColumn(0).setPreferredWidth(300);//�� �÷��̸� ������ ���� 
		RequestTable.getColumnModel().getColumn(1).setPreferredWidth(180);
		RequestTable.getColumnModel().getColumn(2).setPreferredWidth(200);
		RequestTable.getColumnModel().getColumn(3).setPreferredWidth(200);
		RequestTable.getColumnModel().getColumn(4).setPreferredWidth(300);	
		
		scrollPane = new JScrollPane(RequestTable);
		scrollPane.setBounds(0, 53, 1189, 628);
		RequestPanel.add(scrollPane);
		tab.addTab("��û�޼���", RequestPanel);	
		
		getContentPane().add(tab);
  
		Button mypageBtn = new Button("����������");
		mypageBtn.setBounds(321, 752, 115, 23);
		getContentPane().add(mypageBtn);
		
		Button friendgroupBtn = new Button("Friend&Group");
		friendgroupBtn.setBounds(469, 752, 115, 23);
		getContentPane().add(friendgroupBtn);
		
		Button settingBtn = new Button("ȯ�漳��");
		settingBtn.setBounds(615, 752, 115, 23);
		getContentPane().add(settingBtn);
		
		Button logoutBtn = new Button("�α׾ƿ�");
		logoutBtn.setBounds(758, 752, 115, 23);
		getContentPane().add(logoutBtn);
	}
	
	//addGroup
	public void addGroup(GroupData groupData){
		GroupVec.addElement(groupData);
	}
	
	public String getGroupIntro(int index){
		return GroupVec.elementAt(index).getGroupIntro();
	}
	public String getGroupName(int index){
		return GroupVec.elementAt(index).getGroupName();
	}
	public int getGroupNum(){
		return GroupVec.size();
	}
}
