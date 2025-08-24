package com.seiryu.ecommerce.backend_ecommerce.application;

import com.seiryu.ecommerce.backend_ecommerce.domain.model.User;
import com.seiryu.ecommerce.backend_ecommerce.domain.port.IUserRepository;

public class RegistrationService {
    private final IUserRepository iUserRepository;

    // Constructor
    public RegistrationService(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    /**
     * @param user
     * @return User
     */
    public User register(User user) {

        return iUserRepository.save(user);

    }
}
