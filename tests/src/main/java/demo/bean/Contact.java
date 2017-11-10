package demo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Contact {

	@Id
	@GeneratedValue
	private Integer cid;
	private Integer ctid;
	private String name;
	private String sex;
	private String company;
	private String homeTelNum;
	private String officeTelNum;
	@ManyToOne
	@JoinColumn(name="ctid",insertable=false,updatable=false)
	private Cardtype cardtype;
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Integer getCtid() {
		return ctid;
	}
	public void setCtid(Integer ctid) {
		this.ctid = ctid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getHomeTelNum() {
		return homeTelNum;
	}
	public void setHomeTelNum(String homeTelNum) {
		this.homeTelNum = homeTelNum;
	}
	public String getOfficeTelNum() {
		return officeTelNum;
	}
	public void setOfficeTelNum(String officeTelNum) {
		this.officeTelNum = officeTelNum;
	}
	
	public Cardtype getCardtype() {
		return cardtype;
	}
	public void setCardtype(Cardtype cardtype) {
		cardtype = cardtype;
	}
	@Override
	public String toString() {
		return "Contact [cid=" + cid + ", ctid=" + ctid + ", name=" + name + ", sex=" + sex + ", company=" + company
				+ ", homeTelNum=" + homeTelNum + ", officeTelNum=" + officeTelNum + ", Cardtype=" + cardtype + "]";
	}
	
}
