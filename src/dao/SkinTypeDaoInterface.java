package dao;


import model.Skin_Type;

public interface SkinTypeDaoInterface {
	void insertSkinType(Skin_Type skinType);
	void deleteSkinType(int skin_id);
	void updateSkinType(int skin_id);
}
