package com.mwp.sbmdbr.repository;

import com.mwp.sbmdbr.models.ERole;
import com.mwp.sbmdbr.models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {

    Optional<Role> findByName(ERole name);
}
