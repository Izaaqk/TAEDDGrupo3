package com.upc.curso.entidades;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Data
@Transactional
@NoArgsConstructor
@Entity
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nameImage", length = 50, nullable = false)
    private String nameImage;
    private String urlImage;

    public Image(Long id, String nameImage, String urlImage) {
        this.id = id;
        this.nameImage = nameImage;
        this.urlImage = urlImage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameImage() {
        return nameImage;
    }

    public void setNameImage(String nameImage) {
        this.nameImage = nameImage;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", nameImage='" + nameImage + '\'' +
                ", urlImage='" + urlImage + '\'' +
                '}';
    }
}
