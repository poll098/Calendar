package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class DAddSchedule extends JFrame {
   private JPanel contentPane;
   private JLabel DayLabel;
   private String date;//"��/��/��"
   private JLabel ScheduleNameLabel;
   private JLabel SubtitleLabel;
   private JLabel LocationLabel;
   private JLabel PriorityLabel;
   private JLabel ContextLabel;
   private JLabel timeLabel;
   private JLabel ShareLabel;
   

   private JTextField ScheduleName;
   private JTextField Subtitle;
   private JTextField Location;
   private JComboBox timeBox;
   private JTextField Shared;

   private DMonth_CalendarView calendar;
   private ScheduleData scheduleData;
   private int year,month,day;
   private JTextField context;


   public DAddSchedule(DMonth_CalendarView calendar,String date) {
	

      this.calendar=calendar;
      
      setBounds(100, 100, 450, 619);
      contentPane = new JPanel();
      setResizable(false);
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
 
      this.date=date;
      
      scheduleData=new ScheduleData(date);
      DayLabel = new JLabel(date);
      DayLabel.setFont(new Font("����", Font.BOLD, 14));
      DayLabel.setBounds(162, 21, 116, 15);
      contentPane.add(DayLabel);
      
      ScheduleNameLabel = new JLabel("�����ٸ� :");
      ScheduleNameLabel.setBounds(29, 62, 75, 15);
      contentPane.add(ScheduleNameLabel);
      
      ScheduleName = new JTextField();
      ScheduleName.setBounds(119, 59, 221, 21);
      contentPane.add(ScheduleName);
      ScheduleName.setColumns(10);
      
      SubtitleLabel = new JLabel("������� :");
      SubtitleLabel.setBounds(29, 109, 57, 15);
      contentPane.add(SubtitleLabel);
      
      Subtitle = new JTextField();
      Subtitle.setColumns(10);
      Subtitle.setBounds(119, 106, 221, 21);
      contentPane.add(Subtitle);
      
      timeLabel = new JLabel("�ð� :");
      timeLabel.setBounds(29, 154, 57, 15);
      contentPane.add(timeLabel);
      
      timeBox = new JComboBox();
      String time[]={"00:00-01:00","01:00-02:00","02:00-03:00","03:00-04:00","04:00-05:00","05:00-06:00","06:00-07:00","07:00-08:00","08:00-09:00","09:00-10:00","10:00-11:00","11:00-12:00","12:00-13:00","13:00-14:00","14:00-15:00","15:00-16:00","16:00-17:00","17:00-18:00","18:00-19:00","19:00-20:00","20:00-21:00","21:00-22:00","22:00-23:00","23:00-24:00"};
      for(int i=0;i<time.length;i++){
    	  timeBox.addItem(time[i]);
      }
  
      timeBox.setBounds(119, 151, 199, 21);
      contentPane.add(timeBox);
      
      
//      JCheckBox PeriodCheckBox = new JCheckBox("�ݺ�");
//      PeriodCheckBox.setBounds(326, 150, 57, 23);
//      contentPane.add(PeriodCheckBox);
      
      PriorityLabel = new JLabel("�켱���� :");
      PriorityLabel.setBounds(29, 206, 75, 15);
      contentPane.add(PriorityLabel);
      
//      JComboBox PrioritycomboBox = new JComboBox();
//      PrioritycomboBox.setBounds(119, 203, 221, 21);
//      contentPane.add(PrioritycomboBox);
      
      LocationLabel = new JLabel("��� :");
      LocationLabel.setBounds(29, 259, 57, 15);
      contentPane.add(LocationLabel);
      
      Location = new JTextField();
      Location.setColumns(10);
      Location.setBounds(121, 256, 199, 21);
      contentPane.add(Location); 
      
//      ImageIcon LocationIcon=new ImageIcon("image/ic_room_black_23dp_1x.png");
//      JButton locationBtn = new JButton(LocationIcon);
//      locationBtn.setBounds(326, 254, 23, 23);
//      contentPane.add(locationBtn);
      
      ContextLabel = new JLabel("���� :");
      ContextLabel.setBounds(29, 309, 57, 15);
      contentPane.add(ContextLabel);                                  
      
      context = new JTextField();
      context.setBounds(121, 306, 219, 109);
      contentPane.add(context);
      context.setColumns(10);
      
      ShareLabel = new JLabel("������ :");
      ShareLabel.setBounds(29, 451, 57, 15);
      contentPane.add(ShareLabel);
      
      
      Shared = new JTextField();
      Shared.setBounds(119, 448, 221, 21);
      contentPane.add(Shared);
      Shared.setColumns(10);

        
      JButton addBtn = new JButton("add");
      addBtn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            //���� ���� 
        	 setScheduleData();
        	 calendar.addSchedule(scheduleData);
    	 
        	 dispose();       	 
        	 
         }
      });
      addBtn.setBounds(175, 513, 97, 23);
      contentPane.add(addBtn);
     
  
   }

       
     public void setScheduleData(){//ScheduleData�� ��
    	 System.out.println("�������̸�:"+ScheduleName.getText());
    	
    	 scheduleData.setScheduleName(ScheduleName.getText());
//    	 scheduleData.setSubtitle(Subtitle.getText());
    	 
    	 scheduleData.setTime((String)timeBox.getSelectedItem());
//    	 scheduleData.setLocation(Location.getText());
//    	 scheduleData.setContext(context.getText());
//    	 scheduleData.setShare(Shared.getText());
//    	 
    	   }
     
     
    
     
     public ScheduleData getScheduleData(){
		return scheduleData;//set �� ���� daypane scheduleArr�� ���� add  	 
     }
     
}