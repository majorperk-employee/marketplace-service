package domain;

import java.util.List;

public class RewardItem {

	String name;
	Integer price;
	String type;
	List<String> tags;
	Meta meta;

	public RewardItem() {
        super();
    }
    
    public RewardItem(String name, Integer price, String category, String description, String tags, String image, Boolean incart) {
    	this.name = name;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}
}
