package com.bharath.springJPA.repos;

import org.springframework.data.repository.CrudRepository;

import com.bharath.springJPA.entity.Image;

public interface ImageRepository extends CrudRepository<Image, Long> {

}
