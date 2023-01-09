package com.mwp.sbmdbr.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Document(collection = "roles")
public class Role {

    @Id
    private String id;

    @NonNull
    private ERole name;
}
