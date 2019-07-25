package object;

import java.util.List;

public class CheckoutRecord {
	private Member member;
	private int id;
	public CheckoutRecord() {
		
	}
	public CheckoutRecord(int id) {
		this.id = id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private List<Checkout> checkouts;
	public void addCheckout(Checkout ch) {
		checkouts.add(ch);
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public List<Checkout> getCheckouts() {
		return checkouts;
	}
	public void setCheckouts(List<Checkout> checkouts) {
		this.checkouts = checkouts;
	}
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}

	
}
