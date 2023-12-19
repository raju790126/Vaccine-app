package com.mav.dao;

import java.util.List;


import com.mav.entity.AddMemberEntity;
import com.mav.entity.RegisterEntity;

public interface AddMemberInterface {

	public boolean saveAddMember(AddMemberEntity addentity);
	
	public boolean updateRegisterMember(RegisterEntity regentity);
	
	public List<AddMemberEntity> setAllAddMembers(String addemail);
	
	public AddMemberEntity getDetailsById(int id);
	
	public boolean updateMemberDetails(AddMemberEntity entity);
	
	public boolean deleteMemberDetails(int id);
	
	public boolean decreaseCountRegisterMember(RegisterEntity regentity);
}
