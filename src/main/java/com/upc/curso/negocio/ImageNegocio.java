package com.upc.curso.negocio;

import com.upc.curso.dtos.ImageDTO;
import com.upc.curso.entidades.Image;
import com.upc.curso.repositorio.ImageRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImageNegocio {
    @Autowired
    private ImageRepositorio imageRepositorio;

    public Image register(Image image){
        return imageRepositorio.save(image);
    }

    public List<ImageDTO> listImages() {
        List<Image> images = imageRepositorio.findAll();
        return images.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private List<ImageDTO> convertToLisDto(List<Image> images){
        return images.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    private ImageDTO convertToDto(Image image) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(image, ImageDTO.class);
    }
}
