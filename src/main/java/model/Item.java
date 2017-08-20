package model;

/**
 * Item in the order related data
 * @author hardik thakkar
 *
 */
public class Item {
	String name;
	Long quantity;

	public Item(String name,Long quantity) {
		super();
		this.name = name;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	
	
	
}
