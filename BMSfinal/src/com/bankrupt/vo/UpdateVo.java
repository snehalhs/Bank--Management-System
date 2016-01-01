package com.bankrupt.vo;

public class UpdateVo {
	private String CUSTOMER_ID;                        
	 private String ACCOUNT_NUMBER;             
	 private String  NAME;  
	 private String  BRANCH_NAME ;
	 private String  GUARDIAN_TYPE;                
	 private String GUARDIAN_NAME;               
	private String  ADDRESS;                                
	private String CITIZENSHIP;              
	private String  COUNTRY  ;                  
	private String  STATE  ;                  
	private String  EMAIL   ;                   
	private String  GENDER   ;                    
	private String  MARITAL_STATUS;                    
	private String CONTACT_NUMBER;       
	 private String  DOB   ;                       
	 private String  REG_DATE  ;                 
	 private String  ACC_TYPE ;                                                        
	 private String CITIZEN_STATUS ;
	 private String  REF_ACC_NO;
	 private String  REF_ADDRESS;
	 private String  ID_PROOF_TYPE ;
	 private String  ID_DOC_NO ;
	 private String REF_HOLDER_NAME;
	 
	public String getCUSTOMER_ID() {
		return CUSTOMER_ID;
	}
	public void setCUSTOMER_ID(String cUSTOMER_ID) {
		CUSTOMER_ID = cUSTOMER_ID;
	}
	public String getACCOUNT_NUMBER() {
		return ACCOUNT_NUMBER;
	}
	public void setACCOUNT_NUMBER(String aCCOUNT_NUMBER) {
		ACCOUNT_NUMBER = aCCOUNT_NUMBER;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getGUARDIAN_TYPE() {
		return GUARDIAN_TYPE;
	}
	public void setGUARDIAN_TYPE(String gUARDIAN_TYPE) {
		GUARDIAN_TYPE = gUARDIAN_TYPE;
	}
	public String getGUARDIAN_NAME() {
		return GUARDIAN_NAME;
	}
	public void setGUARDIAN_NAME(String gUARDIAN_NAME) {
		GUARDIAN_NAME = gUARDIAN_NAME;
	}
	public String getADDRESS() {
		return ADDRESS;
	}
	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}
	public String getCITIZENSHIP() {
		return CITIZENSHIP;
	}
	public void setCITIZENSHIP(String cITIZENSHIP) {
		CITIZENSHIP = cITIZENSHIP;
	}
	public String getCOUNTRY() {
		return COUNTRY;
	}
	public void setCOUNTRY(String cOUNTRY) {
		COUNTRY = cOUNTRY;
	}
	public String getSTATE() {
		return STATE;
	}
	public void setSTATE(String sTATE) {
		STATE = sTATE;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public String getGENDER() {
		return GENDER;
	}
	public void setGENDER(String gENDER) {
		GENDER = gENDER;
	}
	public String getMARITAL_STATUS() {
		return MARITAL_STATUS;
	}
	public void setMARITAL_STATUS(String mARITAL_STATUS) {
		MARITAL_STATUS = mARITAL_STATUS;
	}
	public String getCONTACT_NUMBER() {
		return CONTACT_NUMBER;
	}
	public void setCONTACT_NUMBER(String cONTACT_NUMBER) {
		CONTACT_NUMBER = cONTACT_NUMBER;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getREG_DATE() {
		return REG_DATE;
	}
	public void setREG_DATE(String rEG_DATE) {
		REG_DATE = rEG_DATE;
	}
	public String getACC_TYPE() {
		return ACC_TYPE;
	}
	public void setACC_TYPE(String aCC_TYPE) {
		ACC_TYPE = aCC_TYPE;
	}
	public String getBRANCH_NAME() {
		return BRANCH_NAME;
	}
	public void setBRANCH_NAME(String bRANCH_NAME) {
		BRANCH_NAME = bRANCH_NAME;
	}
	public String getCITIZEN_STATUS() {
		return CITIZEN_STATUS;
	}
	public void setCITIZEN_STATUS(String cITIZEN_STATUS) {
		CITIZEN_STATUS = cITIZEN_STATUS;
	}
	
	public void setREF_ADDRESS(String rEF_ADDRESS) {
		REF_ADDRESS = rEF_ADDRESS;
	}
	public String getREF_ADDRESS() {
		return REF_ADDRESS;
	}
	@Override
	public String toString() {
		return "UpdateVo [CUSTOMER_ID=" + CUSTOMER_ID + ", ACCOUNT_NUMBER="
				+ ACCOUNT_NUMBER + ", NAME=" + NAME + ", BRANCH_NAME="
				+ BRANCH_NAME + ", GUARDIAN_TYPE=" + GUARDIAN_TYPE
				+ ", GUARDIAN_NAME=" + GUARDIAN_NAME + ", ADDRESS=" + ADDRESS
				+ ", CITIZENSHIP=" + CITIZENSHIP + ", COUNTRY=" + COUNTRY
				+ ", STATE=" + STATE + ", EMAIL=" + EMAIL + ", GENDER="
				+ GENDER + ", MARITAL_STATUS=" + MARITAL_STATUS
				+ ", CONTACT_NUMBER=" + CONTACT_NUMBER + ", DOB=" + DOB
				+ ", REG_DATE=" + REG_DATE + ", ACC_TYPE=" + ACC_TYPE
				+ ", CITIZEN_STATUS=" + CITIZEN_STATUS + ", REF_ACC_NO="
				+ REF_ACC_NO + ", REF_ADDRESS=" + REF_ADDRESS
				+ ", ID_PROOF_TYPE=" + ID_PROOF_TYPE + ", ID_DOC_NO="
				+ ID_DOC_NO + ", REF_HOLDER_NAME=" + REF_HOLDER_NAME + "]";
	}
	public void setREF_ACC_NO(String rEF_ACC_NO) {
		REF_ACC_NO = rEF_ACC_NO;
	}
	public String getREF_ACC_NO() {
		return REF_ACC_NO;
	}
	public void setID_PROOF_TYPE(String iD_PROOF_TYPE) {
		ID_PROOF_TYPE = iD_PROOF_TYPE;
	}
	public String getID_PROOF_TYPE() {
		return ID_PROOF_TYPE;
	}
	public void setID_DOC_NO(String iD_DOC_NO) {
		ID_DOC_NO = iD_DOC_NO;
	}
	public String getID_DOC_NO() {
		return ID_DOC_NO;
	}
	public void setREF_HOLDER_NAME(String rEF_HOLDER_NAME) {
		REF_HOLDER_NAME = rEF_HOLDER_NAME;
	}
	public String getREF_HOLDER_NAME() {
		return REF_HOLDER_NAME;
	}
	 
}
