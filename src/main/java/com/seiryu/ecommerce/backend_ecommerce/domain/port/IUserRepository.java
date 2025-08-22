package com.seiryu.ecommerce.backend_ecommerce.domain.port;

import com.seiryu.ecommerce.backend_ecommerce.domain.model.User;

public interface IUserRepository {

    public User save(User user);

    public User findByEmail(String email);

    public User findById(Long id);

}
