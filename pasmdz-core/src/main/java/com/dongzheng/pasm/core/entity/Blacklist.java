package com.dongzheng.pasm.core.entity;

import com.dongzheng.pasm.core.entity.support.BaseEntity;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author xa
 * @since 2018-06-12
 */
@Entity
@ToString
public class Blacklist extends BaseEntity {


	private static final long serialVersionUID = -2547396996394753148L;
	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Integer id;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 身份证号
	 */
	private String idCard;
	/**
	 * 手机号码
	 */
	private String phone;
	/**
	 * 首次加入黑名单时间
	 */
	private Date blackTime;
	/**
	 * 黑名单类型
	 */
	private String type;
	/**
	 * 加入本系统黑名单时间
	 */
	private Date updateTime;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getBlackTime() {
		return blackTime;
	}

	public void setBlackTime(Date blackTime) {
		this.blackTime = blackTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getRegisterTime() {
		return updateTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.updateTime = registerTime;
	}


}
