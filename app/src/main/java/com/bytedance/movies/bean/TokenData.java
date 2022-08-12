package com.bytedance.movies.bean;

/**
 * @Classname TokenData
 * @Description: TODO
 * @Created by 康斯坦丁
 * @Date 2022/8/12 19:42
 */
public class TokenData {
    private String access_token;

    private String captcha;

    private String desc_url;

    private String description;

    private int error_code;

    private int expires_in;

    private String log_id;

    private String open_id;

    private int refresh_expires_in;

    private String refresh_token;

    private String scope;

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getAccess_token() {
        return this.access_token;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public String getCaptcha() {
        return this.captcha;
    }

    public void setDesc_url(String desc_url) {
        this.desc_url = desc_url;
    }

    public String getDesc_url() {
        return this.desc_url;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public int getError_code() {
        return this.error_code;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public int getExpires_in() {
        return this.expires_in;
    }

    public void setLog_id(String log_id) {
        this.log_id = log_id;
    }

    public String getLog_id() {
        return this.log_id;
    }

    public void setOpen_id(String open_id) {
        this.open_id = open_id;
    }

    public String getOpen_id() {
        return this.open_id;
    }

    public void setRefresh_expires_in(int refresh_expires_in) {
        this.refresh_expires_in = refresh_expires_in;
    }

    public int getRefresh_expires_in() {
        return this.refresh_expires_in;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getRefresh_token() {
        return this.refresh_token;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getScope() {
        return this.scope;
    }


}
