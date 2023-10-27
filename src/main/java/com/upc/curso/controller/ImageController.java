package com.upc.curso.controller;

import com.upc.curso.dtos.ImageDTO;
import com.upc.curso.entidades.Image;
import com.upc.curso.negocio.ImageNegocio;
import com.upc.curso.repositorio.ImageRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ImageController {
    @Autowired //inyectando
    private ImageRepositorio imageRepositorio;
    @Autowired
    private ImageNegocio imageNegocio;

    @PostMapping("/image")
    public ResponseEntity<ImageDTO> register(@RequestBody ImageDTO imageDTO){
        Image image = convertToEntity(imageDTO);
        image = imageNegocio.register(image);
        imageDTO = convertToDto(image);
        return new ResponseEntity<ImageDTO>(imageDTO, HttpStatus.OK);
    }

    @GetMapping("/images")
    public ResponseEntity<List<ImageDTO>> listImages() {
        try {
            List<ImageDTO> images = imageNegocio.listImages();
            return new ResponseEntity<>(images, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private ImageDTO convertToDto(Image image) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(image, ImageDTO.class);
    }

    private Image convertToEntity(ImageDTO imageDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(imageDTO, Image.class);
    }

    private List<ImageDTO> convertToLisDto(List<Image> list){
        return list.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

}
