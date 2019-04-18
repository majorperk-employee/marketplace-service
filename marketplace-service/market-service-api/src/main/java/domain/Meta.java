package domain;

public class Meta {
	int purchased;
	int selected;

	public Meta() {
        super();
    }
    
    public Meta(int purchased, int selected) {
    	this.purchased = purchased;
    	this.selected = selected;
    }

	public int getPurchased() {
		return purchased;
	}

	public void setPurchased(int purchased) {
		this.purchased = purchased;
	}

	public int getSelected() {
		return selected;
	}

	public void setSelected(int selected) {
		this.selected = selected;
	}
}
