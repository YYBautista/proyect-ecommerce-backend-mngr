package com.seiryu.ecommerce.backend_ecommerce.infrastructure.adapter;

import org.springframework.stereotype.Repository;

import com.seiryu.ecommerce.backend_ecommerce.domain.model.User;
import com.seiryu.ecommerce.backend_ecommerce.domain.port.IUserRepository;
import com.seiryu.ecommerce.backend_ecommerce.infrastructure.mapper.IUserMapper;

@Repository
public class UserCrudRepositoryImpl implements IUserRepository {

    private final IUserCrudRepository iUserCrudRepository;
    private final IUserMapper iUserMapper;

    public UserCrudRepositoryImpl(IUserCrudRepository iUserCrudRepository, IUserMapper iUserMapper) {
        this.iUserCrudRepository = iUserCrudRepository;
        this.iUserMapper = iUserMapper;
    }

    @Override
    public User save(User user) {
        return iUserMapper.toUser(iUserCrudRepository.save(iUserMapper.toUserEntity(user)));
    }

    @Override
    public User findByEmail(String email) {

        return iUserMapper.toUser(iUserCrudRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email)));
    }

    @Override
    public User findById(Long id) {

        return iUserMapper.toUser(iUserCrudRepository.findById(id).orElse(null));

    }

}
