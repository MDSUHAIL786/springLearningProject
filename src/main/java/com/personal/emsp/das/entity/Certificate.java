package com.personal.emsp.das.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Certificate {
    private String certificateName;
    private String number;

    public Certificate() {
        super();
    }

    public Certificate(String certificateName, String number) {
        this.certificateName = certificateName;
        this.number = number;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
