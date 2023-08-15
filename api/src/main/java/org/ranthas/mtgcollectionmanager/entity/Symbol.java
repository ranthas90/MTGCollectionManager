package org.ranthas.mtgcollectionmanager.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "symbols")
public class Symbol extends BaseEntity {

    @Column(name = "code")
    private String code;

    @Column(name = "image_path")
    private String imagePath;

    public Symbol() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
