package com.upc.curso.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ImageDTO {
    private Long id;
    private String nameImage;
    private String urlImage;

    public ImageDTO(Long id, String nameImage, String urlImage) {
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
        return "ImageDTO{" +
                "id=" + id +
                ", nameImage='" + nameImage + '\'' +
                ", urlImage='" + urlImage + '\'' +
                '}';
    }
}
