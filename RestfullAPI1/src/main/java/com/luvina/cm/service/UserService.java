package com.luvina.cm.service;

import com.luvina.cm.configuration.MaskingPatternLayout;
import com.luvina.cm.dto.UserDto;
import com.luvina.cm.dto.UserResDto;
import com.luvina.cm.entity.User;
import com.luvina.cm.error.ErrorCodes;
import com.luvina.cm.error.ServiceRuntimeException;
import com.luvina.cm.factory.UserFactory;
import com.luvina.cm.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserFactory userFactory;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public UserResDto saveUser(UserDto userDto) {
        if (findUserByEmail(userDto.getEmail()) == null) {
            User user = userFactory.createUser(userDto);
            User saveUser = userRepository.save(user);
            UserResDto userResDto = findUserByID(saveUser.getId());
            return userResDto;
        }
        throw new ServiceRuntimeException(HttpStatus.valueOf(403),
                ErrorCodes.USER_E001,
                String.format("User email exists: %s", userDto.getEmail()));
    }

    @Transactional
    public UserResDto findUserByID(int userId) {
        User user = userRepository.findById(userId).orElseThrow();
        return modelMapper.map(user, UserResDto.class);
    }

    public User findUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return user;
    }
}
