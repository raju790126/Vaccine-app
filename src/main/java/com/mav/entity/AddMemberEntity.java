package com.mav.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "addmembers")
public class AddMemberEntity implements java.io.Serializable{
	
	@Id
	@Column(name = "MEMBER_ID")
	private int id;
	@Column(name = "USEREMAIL")
	private String useremail;
	@Column(name = "MEMBER_NAME")
	private String memberName;
	@Column(name = "GENDER")
	private String gender;
	@Column(name = "DATE_OF_BIRTH")
	private String birth;
	@Column(name = "ID_PROOF")
	private String idProof;
	@Column(name = "PROOF_NUMBER")
	private String proofNo;
	@Column(name = "VACCINE_TYPE")
	private String vaccineType;
	@Column(name = "DOSE")
	private int dose;
	
	public AddMemberEntity() {
		System.out.println("AddMember default constructor");
	}

	public AddMemberEntity(int id,String useremail, String memberName, String gender, String birth, String idProof, String proofNo,
			String vaccineType, int dose) {
		super();
		this.id = id;
		this.useremail = useremail;
		this.memberName = memberName;
		this.gender = gender;
		this.birth = birth;
		this.idProof = idProof;
		this.proofNo = proofNo;
		this.vaccineType = vaccineType;
		this.dose = dose;
	}
	public AddMemberEntity(String useremail, String memberName, String gender, String birth, String idProof, String proofNo,
			String vaccineType, int dose) {
		super();
		this.useremail = useremail;
		this.memberName = memberName;
		this.gender = gender;
		this.birth = birth;
		this.idProof = idProof;
		this.proofNo = proofNo;
		this.vaccineType = vaccineType;
		this.dose = dose;
	}

	public int getId() {
		return id;
	}
	
	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getIdProof() {
		return idProof;
	}

	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}

	public String getProofNo() {
		return proofNo;
	}

	public void setProofNo(String proofNo) {
		this.proofNo = proofNo;
	}

	public String getVaccineType() {
		return vaccineType;
	}

	public void setVaccineType(String vaccineType) {
		this.vaccineType = vaccineType;
	}

	public int getDose() {
		return dose;
	}

	public void setDose(int dose) {
		this.dose = dose;
	}

	@Override
	public String toString() {
		return "AddMember [ "+ id+ ", " + useremail + ", " + memberName + ", " + gender + ", "
				+ birth + ", " + idProof + ", " + proofNo + ", " + vaccineType + ", "
				+ dose + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
