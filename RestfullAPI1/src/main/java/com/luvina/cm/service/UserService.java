package com.luvina.cm.service;

import com.luvina.cm.dto.UserDto;
import com.luvina.cm.dto.UserResDto;
import com.luvina.cm.entity.User;
import com.luvina.cm.factory.UserFactory;
import com.luvina.cm.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserFactory userFactory;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public UserResDto saveUser(UserDto userDto) {
        User user = userFactory.createUser(userDto);
        User saveUser = userRepository.save(user);
        return modelMapper.map(saveUser, UserResDto.class);
    }

}
