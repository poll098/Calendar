package ui;

public class GroupData {
	private String GroupName=null;	//�׷��
	private String GroupIntro=null;	//�׷�Ұ�
	
	
	
	public GroupData(String GroupName, String GroupIntro){
		setGroupName(GroupName);
		setGroupIntro(GroupIntro);
		
	}
	
	public String getGroupName() {
		return GroupName;
	}
	public void setGroupName(String groupName) {
		GroupName = groupName;
	}
	public String getGroupIntro() {
		return GroupIntro;
	}
	public void setGroupIntro(String groupintro) {
		GroupIntro = groupintro;
	}
	
	
	
}
