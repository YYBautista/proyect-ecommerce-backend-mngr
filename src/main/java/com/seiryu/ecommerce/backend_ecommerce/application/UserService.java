package com.seiryu.ecommerce.backend_ecommerce.application;

import com.seiryu.ecommerce.backend_ecommerce.domain.model.User;
import com.seiryu.ecommerce.backend_ecommerce.domain.port.IUserRepository;

public class UserService {

    private final IUserRepository iUserRepository;

    public UserService(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    public User save(User user) {
        return this.iUserRepository.save(user);

    }

    public User findById(Long id) {
        return this.iUserRepository.findById(id);
    }

}
