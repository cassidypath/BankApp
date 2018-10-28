package views;

import java.util.ArrayList;
import java.util.List;

import models.Customer;

// Abstract because it's the parent class
public abstract class View {
	
	public List<View> nextViews = new ArrayList<>();
	public View previousView = null;
	
	
	public abstract void DisplayOptions();
	public abstract void ProcessInput();
	
	
	public List<View> getNextViews() {
		return nextViews;
	}
	public void setNextViews(List<View> nextViews) {
		this.nextViews = nextViews;
	}
	public View getPreviousView() {
		return previousView;
	}
	
	public void setPreviousView(View previousView) {
		this.previousView = previousView;
	}
	
}
