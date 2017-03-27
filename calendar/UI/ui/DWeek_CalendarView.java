package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
//setWeek(Calendar c)�� �Է� ���� ���� ��¥�� ��� weekArr�� �������ش�
//�� Week_dayPane [i]��ü�� weekArr[i]�� ������ ������ ����
public class DWeek_CalendarView extends JFrame implements ActionListener{
	DWeek_dayPane[] days;
	private JPanel contentPane;
	private Calendar now=Calendar.getInstance();//���� ��¥
	private Calendar c=Calendar.getInstance();//�̵��� ��¥
    private ArrayList<String> weekArr;//7�� ��¥ �迭
    private JPanel DaysPanel;
    private JLabel titleLabel;
    private JLabel[] WeekLabels;
    String []DAYS_OF_WEEK={"��","��","ȭ","��","��","��","��"};
    private int year,month,today,value,weekNum;//��°��
    private JButton monthBtn;
    private JButton treeBtn;
	public static final DWeek_CalendarView instance =new DWeek_CalendarView();


	/**
	 * Create the frame.
	 */
	public DWeek_CalendarView() {
		setTitle("WeekCalendarView");
		setResizable(false);
		setBounds(100, 100, 1250, 768);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		contentPane.setLayout(null);
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(99, 10, 293, 55);
		contentPane.add(titlePanel);
		titlePanel.setLayout(new BorderLayout(0, 0));
	
		
		JButton DownBtn = new JButton("<");
		DownBtn.setOpaque(true);
		DownBtn.setBackground(new Color(224, 255, 255));
		DownBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		DownBtn.setHorizontalAlignment(SwingConstants.CENTER);
		DownBtn.setPreferredSize(new Dimension(35, 35));
		DownBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				weekArr.clear();
                c.add(Calendar.DATE,-7);
				setWeek(c);
				c.add(Calendar.DATE,-7);
				setDateLabel();
			}
		});
		titlePanel.add(DownBtn, BorderLayout.WEST);
		
		
		titleLabel = new JLabel();
		titleLabel.setFont(new Font("��������ڵ�", Font.BOLD, 13));
		titleLabel.setOpaque(false);
		titleLabel.setBackground(new Color(255, 255, 255));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titlePanel.add(titleLabel, BorderLayout.CENTER);
		
		JButton UpBtn = new JButton(">");
		UpBtn.setOpaque(true);
		UpBtn.setBackground(new Color(224, 255, 255));
		UpBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		UpBtn.setHorizontalAlignment(SwingConstants.CENTER);
		UpBtn.setPreferredSize(new Dimension(35, 15));
		UpBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
	
				c.add(Calendar.DATE,7);
				weekArr.clear();
				setWeek(c);
				 c.add(Calendar.DATE,-7);
				 setDateLabel();
			}
		});
		titlePanel.add(UpBtn, BorderLayout.EAST);
		
		ImageIcon treeIcon=new ImageIcon("image/ic_treeview_black_48dp_1x.png");
		treeBtn = new JButton(treeIcon);
		treeBtn.addActionListener(this);
		treeBtn.setBounds(1163, 29, 48, 48);
		contentPane.add(treeBtn);
		JLabel[] WeekLabels;
		
/*�� ���ϰ���¥ ǥ�� �ǳ�*/	
	

/*�Ϻ� ������*/
		JPanel DaysPanel = new JPanel();//day��  �ǳ�
		DaysPanel.setBackground(Color.LIGHT_GRAY);
		DaysPanel.setBounds(141, 75, 1019, 616);
		DaysPanel.setLayout(new GridLayout(1,8));
		days=new DWeek_dayPane[8];
		setWeek(now);
		for(int i=0;i<days.length;i++){
		//���� ��¥�������� �����ϴ� �Լ�
				if(i==0){
					days[i]=new DWeek_dayPane(this,"�ð�");
				}
				else
					days[i]=new DWeek_dayPane(this,weekArr.get(i-1));
			
			DaysPanel.add(days[i]);
		}
			setDateLabel();	
			contentPane.add(DaysPanel);

		
/*�׷� ���� ������*/
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 192, 203));
		panel.setBounds(0, 251, 137, 217);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("�׷캰 ������");
		lblNewLabel.setBounds(12, 10, 113, 15);
		panel.add(lblNewLabel);
		
		monthBtn = new JButton("month");
		monthBtn.addActionListener(this);
		monthBtn.setBounds(1054, 42, 97, 23);
		contentPane.add(monthBtn);
	}
	public void setWeek(Calendar calendar){
		weekArr= new ArrayList<String>();
	        //�� Ķ���� ��¥ ���� ���� �Ͽ��� ���ϱ�
			year=calendar.get(Calendar.YEAR);
			month=calendar.get(Calendar.MONTH);
			weekNum=calendar.get(Calendar.WEEK_OF_MONTH);
	        calendar.add(Calendar.DATE, 1 - calendar.get(Calendar.DAY_OF_WEEK) );

	        //������ ���ϰ� �����Ϸκ��� 7�Ͼ� ǥ��
	        for(int i=0;i<7;i++){//���� �Ͽ��Ϻ��� 7�� ǥ��
	        	weekArr.add(calendar.get(Calendar.DATE)+"�� ("+DAYS_OF_WEEK[i]+")");
	            calendar.add(Calendar.DATE,1);//�Ϸ羿 �� 7��

	        }		

		
	}
	public void setDateLabel(){
		titleLabel.setText("");
		titleLabel.setText(year+"�� "+(month+1)+"�� "+weekNum+"°��");
		for(int i=1;i<8;i++){
			    days[i].initInfo();
	            days[i].setValue(year,month,weekArr.get(i-1),i);//�� �ǳڿ� day����          
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.setVisible(false);
		// TODO Auto-generated method stub
	
		if(e.getSource()==treeBtn){
			CTreeView treeView=(CTreeView)CTreeView.getInstanace();
			treeView.setVisible(true);
		}
		if(e.getSource()==monthBtn){
			DMonth_CalendarView monthCalendar=(DMonth_CalendarView)DMonth_CalendarView.getInstanace();
			monthCalendar.setVisible(true);
		}
	}
	
	
	public static DWeek_CalendarView getInstanace() {
			// TODO Auto-generated method stub
			return instance;
		}


	
}
