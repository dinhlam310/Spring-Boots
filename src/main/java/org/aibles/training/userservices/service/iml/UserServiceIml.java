package org.aibles.training.userservices.service.iml;

import org.aibles.training.userservices.Exception.UserExistsException;
import org.aibles.training.userservices.Exception.UserNotFoundException;
import org.aibles.training.userservices.model.User;
import org.aibles.training.userservices.repository.UserRepository;
import org.aibles.training.userservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
    public class UserServiceIml implements UserService {
        private final UserRepository userRepository;

    @Autowired
    public UserServiceIml(UserRepository userRepository){
        this.userRepository = userRepository;
    }

        @Override
        public User createUser (User user) throws UserExistsException {
            User existingUser = userRepository.findById(user.getId()).orElse(null);
            if (existingUser != null) {
                throw new UserExistsException();
            } else {
                User userCreated = userRepository.save(user);
                return userCreated;
            }
        }

        @Override
        public User getUser(int id) throws UserNotFoundException {
            User existingUser  = userRepository.findById(id).orElse(null);
            if (existingUser == null ) {
                throw new UserNotFoundException();
            }
            else {
                return existingUser;
            }
        }

        @Override
        public List<User> getAllUser(){
        return userRepository.findAll();
        }


        @Override
        public void deleteUser(int id) throws UserNotFoundException{
            User existingUser = userRepository.findById(id).orElse(null);
            if (existingUser == null) {
                throw new UserNotFoundException();
            } else {
                userRepository.delete(existingUser);
            }
        }

        @Override
        public User updateUser (int id,User user) throws UserNotFoundException {
            User existingUser = userRepository.findById(id).orElse(null);
            if (existingUser == null) {
                throw new UserNotFoundException();
            } else {
                existingUser.setName(user.getName());
                existingUser.setAge(user.getAge());
                User updatedUser = userRepository.save(existingUser);
                return updatedUser;
            }
        }
}
