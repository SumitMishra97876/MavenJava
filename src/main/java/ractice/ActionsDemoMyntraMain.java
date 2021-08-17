package ractice;

public class ActionsDemoMyntraMain {

	public static void main(String[] args) throws InterruptedException {
		ActionsDemoMyntra act=new ActionsDemoMyntra();
		act.loadUrl();
		act.performActions();
		act.select_bag("All");

	}

}
