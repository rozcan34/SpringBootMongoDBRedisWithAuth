package com.mwp.sbmdbr.controllers;

import com.mwp.sbmdbr.common.GenericResponse;
import com.mwp.sbmdbr.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping("/allroles")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public GenericResponse findAllRoles() {
        return roleService.inquireRoles();
    }

}
