package cn.game.admin.util.excel;


import java.io.Serializable;
import java.util.Date;
public class SpmsTeacherCertificate implements Serializable {
   
    private Long certificateId;


    private Long teacherId;

  
    @ExcelAnnotation(index = 1, sheetIndex = 0, valueType = String.class)
    private String certificateIds;

   
    @ExcelAnnotation(index = 2,sheetIndex = 0,valueType = String.class)
    private String certificateType;

    
    @ExcelAnnotation(index = 3, sheetIndex = 0, valueType = String.class)
    private String certificateGrade;

   
    @ExcelAnnotation(index = 4, sheetIndex = 0, valueType = String.class)
    private String certificateOrganization;

   
    @ExcelAnnotation(index = 5, sheetIndex = 0, valueType = Date.class)
    private Date certificateDate;

    
    @ExcelAnnotation(index = 6, sheetIndex = 0, valueType = Date.class)
    private Date certificateValidTime;

   
    private Date createTime;

   
    private Date updateTime;

    
    private Long createUser;

 
    private Long updateUser;

    private static final long serialVersionUID = 1L;

    public Long getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(Long certificateId) {
        this.certificateId = certificateId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getCertificateIds() {
        return certificateIds;
    }

    public void setCertificateIds(String certificateIds) {
        this.certificateIds = certificateIds;
    }

    public String getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType;
    }

    public String getCertificateGrade() {
        return certificateGrade;
    }

    public void setCertificateGrade(String certificateGrade) {
        this.certificateGrade = certificateGrade;
    }

    public String getCertificateOrganization() {
        return certificateOrganization;
    }

    public void setCertificateOrganization(String certificateOrganization) {
        this.certificateOrganization = certificateOrganization;
    }

    public Date getCertificateDate() {
        return certificateDate;
    }

    public void setCertificateDate(Date certificateDate) {
        this.certificateDate = certificateDate;
    }

    public Date getCertificateValidTime() {
        return certificateValidTime;
    }

    public void setCertificateValidTime(Date certificateValidTime) {
        this.certificateValidTime = certificateValidTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", certificateId=").append(certificateId);
        sb.append(", teacherId=").append(teacherId);
        sb.append(", certificateIds=").append(certificateIds);
        sb.append(", certificateType=").append(certificateType);
        sb.append(", certificateGrade=").append(certificateGrade);
        sb.append(", certificateOrganization=").append(certificateOrganization);
        sb.append(", certificateDate=").append(certificateDate);
        sb.append(", certificateValidTime=").append(certificateValidTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createUser=").append(createUser);
        sb.append(", updateUser=").append(updateUser);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SpmsTeacherCertificate other = (SpmsTeacherCertificate) that;
        return (this.getCertificateId() == null ? other.getCertificateId() == null : this.getCertificateId().equals(other.getCertificateId()))
            && (this.getTeacherId() == null ? other.getTeacherId() == null : this.getTeacherId().equals(other.getTeacherId()))
            && (this.getCertificateIds() == null ? other.getCertificateIds() == null : this.getCertificateIds().equals(other.getCertificateIds()))
            && (this.getCertificateType() == null ? other.getCertificateType() == null : this.getCertificateType().equals(other.getCertificateType()))
            && (this.getCertificateGrade() == null ? other.getCertificateGrade() == null : this.getCertificateGrade().equals(other.getCertificateGrade()))
            && (this.getCertificateOrganization() == null ? other.getCertificateOrganization() == null : this.getCertificateOrganization().equals(other.getCertificateOrganization()))
            && (this.getCertificateDate() == null ? other.getCertificateDate() == null : this.getCertificateDate().equals(other.getCertificateDate()))
            && (this.getCertificateValidTime() == null ? other.getCertificateValidTime() == null : this.getCertificateValidTime().equals(other.getCertificateValidTime()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCertificateId() == null) ? 0 : getCertificateId().hashCode());
        result = prime * result + ((getTeacherId() == null) ? 0 : getTeacherId().hashCode());
        result = prime * result + ((getCertificateIds() == null) ? 0 : getCertificateIds().hashCode());
        result = prime * result + ((getCertificateType() == null) ? 0 : getCertificateType().hashCode());
        result = prime * result + ((getCertificateGrade() == null) ? 0 : getCertificateGrade().hashCode());
        result = prime * result + ((getCertificateOrganization() == null) ? 0 : getCertificateOrganization().hashCode());
        result = prime * result + ((getCertificateDate() == null) ? 0 : getCertificateDate().hashCode());
        result = prime * result + ((getCertificateValidTime() == null) ? 0 : getCertificateValidTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        return result;
    }
}