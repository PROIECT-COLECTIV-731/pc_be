package com.example.project.service;

import com.example.project.dto.RegisterRequestDto;
import com.example.project.dto.RegisterResponseDto;
import com.example.project.dto.UserDto;
import com.example.project.entity.BookEntity;
import com.example.project.entity.ReviewEntity;
import com.example.project.entity.UserBookEntity;

import com.example.project.entity.UserEntity;
import com.example.project.mapper.UserMapper;
import com.example.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    private final Long MAX_DAYS_TO_BORROW=5L;
    
    @Override
    public List<UserDto> findAll() {
        return userMapper.entitiesToDtos(this.userRepository.findAll());
    }

    @Override
    public UserEntity findUserByUserName(String username)
    {
        return userRepository.findAll().stream().filter(user->user.getUsername().equals(username)).findFirst().orElse(null);
    }


    public List<UserBookEntity> getExpiredBooks(String username) {
        UserEntity foundUser=findUserByUserName(username);
        List<UserBookEntity>books=new ArrayList<>();
        LocalDate todayDate=LocalDate.now();

        if(foundUser!=null)
        {
            foundUser.getBooks().forEach(userBook->{if(userBook.getStartDate().plusDays(MAX_DAYS_TO_BORROW).isBefore(todayDate)){books.add(userBook);}});
        }
        return books;
    }

    public List<BookEntity> getBooks(String username) {
        UserEntity foundUser=findUserByUserName(username);
        List<BookEntity>books=new ArrayList<>();
        if(foundUser!=null)
        {
            foundUser.getBooks().forEach(userBook->{books.add(userBook.getBookEntity());});
        }
        return books;
    }

    public UserDto findByEmailAndPassword(String email, String password) {
        return userMapper.entityToDto(this.userRepository.findByEmailAndPassword(email, password));
    }



    @Override
    public String login(String email, String password){
        try {
            UserDto user = findByEmailAndPassword(email, password);
            if (user != null && email.contains("@stud.ubbcluj.ro"))
                return "userAccepted";
            else if (user != null && email.contains("@ubbcluj.ro")) {
                return "adminAccepted";
            }
            return null;
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
    public boolean email_validator(RegisterRequestDto dto){
        return dto.getEmail().endsWith("@stud.ubbcluj.ro") || dto.getEmail().endsWith("@ubbcluj.ro") ;
    }
    public boolean name_validator(UserEntity userEntity){
        return userEntity.getFirstName().length() > 0 && userEntity.getLastName().length() > 0;
    }
    public boolean password_validator(UserEntity userEntity){
        return userEntity.getPassword().length()>0;
    }
    public RegisterResponseDto saveUser(RegisterRequestDto dto) throws Exception {


            Optional<UserEntity> optionalUserEntity = Optional.ofNullable(userRepository.findByEmail(dto.getEmail()));
            if (optionalUserEntity.isPresent()) {
                throw new Exception();
            }
            else {
                    UserEntity user = new UserEntity();
                    user.setEmail(dto.getEmail());
                    user.setUsername(dto.getEmail());
                    String firstName = dto.getEmail().split("\\.")[0];
                    String lastName = dto.getEmail().split("\\.")[1].split("@")[0];
                    user.setFirstName(firstName);
                    user.setLastName(lastName);
                    user.setPassword(dto.getPassword());
                    List<UserBookEntity> userBookEntities = new ArrayList<UserBookEntity>();
                    user.setBooks(userBookEntities);
                    user.setReviews(new ArrayList<ReviewEntity>());

                    userRepository.save(user);
                    RegisterResponseDto responseDto = new RegisterResponseDto();
                    responseDto.setEmail(userRepository.findByEmail(dto.getEmail()).getEmail());
                return responseDto;
            }

    }

    @Override
    public UserDto findByEmail(String email){
        return userMapper.entityToDto(this.userRepository.findByEmail(email));
    }


}
