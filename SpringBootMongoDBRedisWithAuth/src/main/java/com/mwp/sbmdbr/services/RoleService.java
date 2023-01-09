package com.mwp.sbmdbr.services;

import com.mwp.sbmdbr.cache.redis.RedisUtility;
import com.mwp.sbmdbr.common.GenericResponse;
import com.mwp.sbmdbr.dtos.RoleDto;
import com.mwp.sbmdbr.models.Role;
import com.mwp.sbmdbr.repository.RoleRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private RedisUtility redisUtility;

    @Autowired
    private ModelMapper modelMapper;

    private static final Logger logger = LogManager.getLogger(RoleService.class);

    public GenericResponse inquireRoles() {

        List<Role> roleList = (List<Role>) this.redisUtility.get("roles");
        if(Objects.isNull(roleList)) {
            roleList = this.roleRepository.findAll();
            if(Objects.nonNull(roleList)) {
                redisUtility.set("roles", roleList);
                return new GenericResponse("Getting Data from DB", modelMapper.map(roleList, new TypeToken<List<RoleDto>>(){}.getType()));
            }
            logger.warn("No roles found in database !!");
            return new GenericResponse("No Data Found", Collections.EMPTY_LIST);
        }
        logger.info("# of roles: " + roleList.size());
        return new GenericResponse("Getting Data from Redis Server", modelMapper.map(roleList, new TypeToken<List<RoleDto>>(){}.getType()));
    }
}
