package com.dongzheng.pasm.core.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dongzheng.pasm.core.entity.support.BaseEntity;
import lombok.Data;
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
@Table
public class CrawlerRequest extends BaseEntity {

  private static final long serialVersionUID = 7299528223400754681L;
  /**
   * 资源id
   */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "report_id", nullable = false)
  private String reportId;
  private String appId;
  private String username;
  private String certype;
  private String cercode;
  private String queryreason;
  private String vertype;
  private String idauthflag;
  private String policetype;
  private Integer runStatus;
  private Integer returntype;
  private String filepath;
  private String otherpath;
  private String errormessage;
  /**
   * 时间
   */
  @JSONField(format = "yyyy-MM-dd HH:mm:ss")
  private Date crawlTime;
  private String rawContent;
  private String role;
  private String mode;
  private String searchname;
  private String other;
  private String id;

  @OneToOne
  private RNrLatest24Monthpaymentstate rNrLatest24Monthpaymentstate;

  public String getReportId() {
    return reportId;
  }

  public void setReportId(String reportId) {
    this.reportId = reportId;
  }


  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public String getCertype() {
    return certype;
  }

  public void setCertype(String certype) {
    this.certype = certype;
  }


  public String getCercode() {
    return cercode;
  }

  public void setCercode(String cercode) {
    this.cercode = cercode;
  }


  public String getQueryreason() {
    return queryreason;
  }

  public void setQueryreason(String queryreason) {
    this.queryreason = queryreason;
  }


  public String getVertype() {
    return vertype;
  }

  public void setVertype(String vertype) {
    this.vertype = vertype;
  }


  public String getIdauthflag() {
    return idauthflag;
  }

  public void setIdauthflag(String idauthflag) {
    this.idauthflag = idauthflag;
  }


  public String getPolicetype() {
    return policetype;
  }

  public void setPolicetype(String policetype) {
    this.policetype = policetype;
  }


  public Integer getRunStatus() {
    return runStatus;
  }

  public void setRunStatus(Integer runStatus) {
    this.runStatus = runStatus;
  }


  public Integer getReturntype() {
    return returntype;
  }

  public void setReturntype(Integer returntype) {
    this.returntype = returntype;
  }


  public String getFilepath() {
    return filepath;
  }

  public void setFilepath(String filepath) {
    this.filepath = filepath;
  }


  public String getOtherpath() {
    return otherpath;
  }

  public void setOtherpath(String otherpath) {
    this.otherpath = otherpath;
  }


  public String getErrormessage() {
    return errormessage;
  }

  public void setErrormessage(String errormessage) {
    this.errormessage = errormessage;
  }


  public Date getCrawlTime() {
    return crawlTime;
  }

  public void setCrawlTime(Date crawlTime) {
    this.crawlTime = crawlTime;
  }


  public String getRawContent() {
    return rawContent;
  }

  public void setRawContent(String rawContent) {
    this.rawContent = rawContent;
  }


  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }


  public String getMode() {
    return mode;
  }

  public void setMode(String mode) {
    this.mode = mode;
  }


  public String getSearchname() {
    return searchname;
  }

  public void setSearchname(String searchname) {
    this.searchname = searchname;
  }


  public String getOther() {
    return other;
  }

  public void setOther(String other) {
    this.other = other;
  }


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

}
