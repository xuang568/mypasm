package com.dongzheng.pasm.core.entity;


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
public class RNrLatest24Monthpaymentstate extends BaseEntity {

    private static final long serialVersionUID = -6185555328874195552L;
    /**
     * 资源id
     */
    private String reportId;
    private String superId;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "latest_id", nullable = false)
    private String latestId;
    private String beginmonth;
    private String endmonth;
    private String latest24State;
    private Date timeStamp;


    @OneToOne
    private CrawlerRequest crawlerRequest;

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }


    public String getSuperId() {
        return superId;
    }

    public void setSuperId(String superId) {
        this.superId = superId;
    }


    public String getLatestId() {
        return latestId;
    }

    public void setLatestId(String latestId) {
        this.latestId = latestId;
    }


    public String getBeginmonth() {
        return beginmonth;
    }

    public void setBeginmonth(String beginmonth) {
        this.beginmonth = beginmonth;
    }


    public String getEndmonth() {
        return endmonth;
    }

    public void setEndmonth(String endmonth) {
        this.endmonth = endmonth;
    }


    public String getLatest24State() {
        return latest24State;
    }

    public void setLatest24State(String latest24State) {
        this.latest24State = latest24State;
    }


    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

}
