package model;

public class Skin_Type {
	private int skinTypeId;
	private String skinTypeName;
	
	public Skin_Type(int skinTypeId, String skinTypeName) {
		this.skinTypeId=skinTypeId;
		this.skinTypeName=skinTypeName;
	}
	
	public Skin_Type() {
		
	}

	public int getSkinTypeId() {
		return skinTypeId;
	}

	public void setSkinTypeId(int skinTypeId) {
		this.skinTypeId = skinTypeId;
	}

	public String getSkinTypeName() {
		return skinTypeName;
	}

	public void setSkinTypeName(String skinTypeName) {
		this.skinTypeName = skinTypeName;
	}
}
