package TestAutomation.testng;

import java.util.ArrayList;

public class Library {
	private Catalogue catalouge;
	private Admin admin;
	public ArrayList<Members> members;
	public Library() {
		this.members = new ArrayList<Members>();
	}
	public int getMembersListSize() {
		return members.size();
	}
	public Catalogue getCatalouge() {
		return catalouge;
	}
	public void setCatalouge(Catalogue catalouge) {
		this.catalouge = catalouge;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public ArrayList<Members> getMembers() {
		return members;
	}
	public void setMembers(ArrayList<Members> members) {
		this.members = members;
	}
	public void addNewMember(Members member) {
		this.members.add(member);
	}
}
