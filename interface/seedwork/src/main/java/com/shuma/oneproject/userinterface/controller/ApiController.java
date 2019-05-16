package com.shuma.oneproject.userinterface.controller;

import com.shuma.oneproject.application.Service;
import com.shuma.oneproject.domain.Entity;
import com.shuma.oneproject.userinterface.annotation.DeleteMappingInheritable;
import com.shuma.oneproject.userinterface.annotation.GetMappingInheritable;
import com.shuma.oneproject.userinterface.annotation.PostMappingInheritable;
import com.shuma.oneproject.userinterface.annotation.PutMappingInheritable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 通用接口
 *
 * @author 马文韬
 * @version 1.0
 * @date 2019/1/31
 */
public abstract class ApiController<TEntity extends Entity, TEntityDTO> {

    @Autowired
    protected Service<TEntity, TEntityDTO> service;

    @GetMappingInheritable ("")
    public List<TEntityDTO> get() {
        return service.getAllDTO();
    }

    @GetMappingInheritable ("/get-by-id/{id}")
    public TEntityDTO getById (@PathVariable("id") Long id) {
        return service.getDTO(id);
    }

    @PostMappingInheritable ("")
    public TEntityDTO post (@RequestBody TEntityDTO entityDTO) {
        return service.addByEntityDTO(entityDTO);
    }

    @PostMappingInheritable ("/post-items")
    public List<TEntityDTO> postItems (@RequestBody List<TEntityDTO> entityDTOS) {
        return service.addByEntityDTO(entityDTOS);
    }

    @PutMappingInheritable ("")
    public TEntityDTO put (@RequestBody TEntityDTO entityDTO) {
        return service.modifyByEntityDTO(entityDTO);
    }

    @PutMappingInheritable ("/put-with-id/{id}")
    public TEntityDTO putWithId(@PathVariable("id") Long id, @RequestBody TEntityDTO entityDTO) {
        return service.modifyByEntityDTO(id, entityDTO);
    }

    @PutMappingInheritable ("/put-items")
    public List<TEntityDTO> putItems(@RequestBody List<TEntityDTO> entityDTOS) {
        return service.modifyByEntityDTO(entityDTOS);
    }

    @DeleteMappingInheritable ("/{id}")
    public void delete(@PathVariable Long id) {
        service.removeById(id);
    }

    @DeleteMappingInheritable ("/delete-items")
    public void deleteItems(@RequestBody List<Long> ids) {
        service.removeByIds(new ArrayList<>(ids));
    }

}
