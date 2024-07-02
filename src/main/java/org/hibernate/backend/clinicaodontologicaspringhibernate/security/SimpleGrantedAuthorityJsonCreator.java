package org.hibernate.backend.clinicaodontologicaspringhibernate.security;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public abstract class SimpleGrantedAuthorityJsonCreator {

    @JsonCreator
    public SimpleGrantedAuthorityJsonCreator(@JsonProperty(TokenJwtConfig.HEADER_AUTHORIZATION) String authority) {
        new SimpleGrantedAuthority(authority);
    }
}
