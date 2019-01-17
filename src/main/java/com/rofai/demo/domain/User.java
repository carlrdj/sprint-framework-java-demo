package com.rofai.demo.domain;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * CRUEDA - 15-01-2019 - Created Entity User
 * Description: Entity User
 */
public class User{
    /**
     * ui_iduser
     */
    @JsonProperty("idUser")
    private UUID ui_iduser;

    @JsonProperty("name")
    private String vc_name;

    @JsonProperty("surname")
    private String vc_surname;
    
    public UUID getUi_iduser() {
        return ui_iduser;
    }
    
    public void setUi_iduser(UUID ui_iduser) {
        this.ui_iduser = ui_iduser;
    }
    
    public String getVc_name() {
        return vc_name;
    }
    
    public void setVc_name(String vc_name) {
        this.vc_name = vc_name;
    }
    
    public String getVc_surname() {
        return vc_surname;
    }
    
    public void setVc_surname(String vc_surname) {
        this.vc_surname = vc_surname;
    }
}


