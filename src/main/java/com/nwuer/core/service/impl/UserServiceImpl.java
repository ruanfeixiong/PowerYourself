package com.nwuer.core.service.impl;

import com.nwuer.core.common.ResponseCode;
import com.nwuer.core.common.ServerResponse;
import com.nwuer.core.common.exception.PowerYourselfException;
import com.nwuer.core.common.util.MD5;
import com.nwuer.core.dao.UserMapper;
import com.nwuer.core.dto.UserDto;
import com.nwuer.core.entity.User;
import com.nwuer.core.pojo.Role;
import com.nwuer.core.pojo.VerificationToken;
import com.nwuer.core.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author harbo
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findTopUserByUsername(UserDto user) {
        return null;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public User createNewAccount(UserDto userDto) {
        boolean emailExists = verifyEmailExistence(userDto.getEmail());
        if (emailExists) {
            throw new PowerYourselfException(ResponseCode.EMAIL_ALREADY_EXISTS);
        }

        boolean usernameExists = verifyUsernameExistence(userDto.getUsername());
        if (usernameExists) {
            throw new PowerYourselfException(ResponseCode.USERNAME_ALREADY_EXISTS);
        }

        User user = new User();
        user.setRole(Role.ORDINARY.getLevel());
        user.setUsername(userDto.getUsername());
//        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setEmail(userDto.getEmail());
//        return userRepository.save(user);
        return null;
    }

    @Override
    public boolean verifyEmailExistence(String email) {
//        return userRepository.findTopByEmail(email) != null;
        return false;
    }

    @Override
    public boolean verifyUsernameExistence(String username) {
        return false;
    }

    @Override
    public ServerResponse login(UserDto userDto) {
        User user = userMapper.findByUsernameAndPassword(userDto.getUsername(), MD5.md5(userDto.getPassword()));
        if (user != null) {
            return ServerResponse.createBySuccess(new UserDto(user.getId(),user.getUsername(), "******", user.getEmail()));
        } else {
            return ServerResponse.createByErrorMessage("用户名或密码错误");
        }
        // TODO repository层还没写

    }

    @Override
    public User getUser(String verificationToken) {
//        return verificationTokenRepository.findTopByToken(verificationToken).getUser();
        return null;
    }

    @Override
    public void saveRegisteredUser(User user) {
//        userRepository.save(user);
    }

    @Override
    public void createVerificationToken(User user, String token) {
//        VerificationToken myToken = new VerificationToken(token, user);
//        verificationTokenRepository.save(myToken);
    }

    @Override
    public VerificationToken getVerificationToken(String VerificationToken) {
//        return verificationTokenRepository.findTopByToken(VerificationToken);
        return null;
    }

    @Override
    public VerificationToken generateNewVerificationToken(String oldToken) {
        return null;
    }
}
