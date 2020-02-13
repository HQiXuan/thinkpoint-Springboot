package com.hy.springboot.bean;

import java.util.Date;

public class UploadFileEntity {

    /** 文件ID */
    private String id;
    /** 文件原名称 */
    private String origName;
    /** 文件新名称 */
    private String newName;
    /** 文件上传后服务器访问地址 */
    private String serverPath;
    /** 文件大小 */
    private Double fileSize;
    /** 文件MD5 */
    private String fileMd5;
    /** 文件上传时间 */
    private Date uploadTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrigName() {
        return origName;
    }

    public void setOrigName(String origName) {
        this.origName = origName;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getServerPath() {
        return serverPath;
    }

    public void setServerPath(String serverPath) {
        this.serverPath = serverPath;
    }

    public Double getFileSize() {
        return fileSize;
    }

    public void setFileSize(Double fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileMd5() {
        return fileMd5;
    }

    public void setFileMd5(String fileMd5) {
        this.fileMd5 = fileMd5;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    @Override
    public String toString() {
        return "UploadFileEntity{" +
                "id='" + id + '\'' +
                ", origName='" + origName + '\'' +
                ", newName='" + newName + '\'' +
                ", serverPath='" + serverPath + '\'' +
                ", fileSize=" + fileSize +
                ", fileMd5='" + fileMd5 + '\'' +
                ", uploadTime=" + uploadTime +
                '}';
    }
}
