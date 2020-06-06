package model;

public class Ingredients {
	private int ingredientsId;
	private String name;
	private String description;
	private String issuesTargeted;
	private String skinType;
	private int skinId;
	
	public Ingredients(int ingredientsId, String name, String description, String issuesTargeted, String skinType,int skinId) {
		this.ingredientsId=ingredientsId;
		this.name=name;
		this.description=description;
		this.issuesTargeted=issuesTargeted;
		this.skinType=skinType;
		this.skinId=skinId;
	}
	
	public String getSkinType() {
		return skinType;
	}

	public void setSkinType(String skinType) {
		this.skinType = skinType;
	}

	public int getSkinId() {
		return skinId;
	}

	public void setSkinId(int skinId) {
		this.skinId = skinId;
	}

	public Ingredients() {
		
	}

	public int getIngredientsId() {
		return ingredientsId;
	}

	public void setIngredientsId(int ingredientsId) {
		this.ingredientsId = ingredientsId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIssuesTargeted() {
		return issuesTargeted;
	}

	public void setIssuesTargeted(String issuesTargeted) {
		this.issuesTargeted = issuesTargeted;
	}
	
	

}
