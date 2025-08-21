package pojo;
public class Trainer {
	private String trainerName;
	private String website;
	private String supportType;
	private String specialization;
	private Progms programs; //private classname  nameas payload;
	private String profileLink;
	public String getTrainerName() {
		return trainerName;
	}
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getSupportType() {
		return supportType;
	}
	public void setSupportType(String supportType) {
		this.supportType = supportType;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public Progms getPrograms() {
		return programs;
	}
	public void setPrograms(Progms programs) {
		this.programs = programs;
	}
	public String getProfileLink() {
		return profileLink;
	}
	public void setProfileLink(String profileLink) {
		this.profileLink = profileLink;
	}
	
}