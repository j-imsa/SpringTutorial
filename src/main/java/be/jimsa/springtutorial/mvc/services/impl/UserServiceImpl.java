package be.jimsa.springtutorial.mvc.services.impl;

import be.jimsa.springtutorial.mvc.models.entities.UserEntity;
import be.jimsa.springtutorial.mvc.models.requests.UserRequest;
import be.jimsa.springtutorial.mvc.models.responses.UserResponse;
import be.jimsa.springtutorial.mvc.repositories.UserRepository;
import be.jimsa.springtutorial.mvc.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        Page<UserEntity> userEntityPage = userRepository.findAll(PageRequest.of(0, 10, sort));
        log.info("Total Elements: {}", userEntityPage.getTotalElements());
        log.info("Total Pages: {}", userEntityPage.getTotalPages());
        log.info("Number Of Elements: {}", userEntityPage.getNumberOfElements());
        log.info("Size: {}", userEntityPage.getSize());
    }

    @Override
    public List<String> getProfessions() {
        return List.of("Developer", "Tester", "Architect");
    }

    @Override
    public void manageUserInfo(UserRequest user) {
        // Validation
        // Db
        // ...

        log.info("User is {}", user);

    }

    @Override
    public List<UserResponse> getMathData() {
        return List.of(
                new UserResponse("A-name", "A-email", "A-id"),
                new UserResponse("B-name", "B-email", "B-id"),
                new UserResponse("C-name", "C-email", "C-id")
        );
    }

    @Override
    public List<UserResponse> getEnglishData() {
        return List.of(
                new UserResponse("X-name", "X-email", "X-id"),
                new UserResponse("Y-name", "Y-email", "Y-id"),
                new UserResponse("Z-name", "Z-email", "Z-id")
        );
    }

    @Override
    public List<UserResponse> getAllData() {
        return Stream
                .concat(
                        getEnglishData().stream(),
                        getMathData().stream()
                )
                .toList();
    }

    @Override
    public boolean saveUser(UserRequest user) {
        UserEntity savedUserEntity = userRepository.save(
                new UserEntity(
                        0L,
                        user.getName(),
                        user.getEmail(),
                        passwordEncoder.encode(user.getPwd())
                )
        );
        return savedUserEntity.getId() > 0;
    }

}
