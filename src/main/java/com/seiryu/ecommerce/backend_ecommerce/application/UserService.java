package com.seiryu.ecommerce.backend_ecommerce.application;

import com.seiryu.ecommerce.backend_ecommerce.domain.model.User;
import com.seiryu.ecommerce.backend_ecommerce.domain.port.IUserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserService {

    private final IUserRepository iUserRepository;

    public UserService(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    /**
     * @param user
     * @return User
     */
    public User save(User user) {
        return this.iUserRepository.save(user);

    }

    /**
     * @param id
     * @return User
     */
    public User findById(Long id) {
        return this.iUserRepository.findById(id);
    }

    /**
     * @param email
     * @return User
     */
    public User findByEmail(String email) {
        log.info("Finding user by email: {}", email);
        return this.iUserRepository.findByEmail(email);
    }

}
