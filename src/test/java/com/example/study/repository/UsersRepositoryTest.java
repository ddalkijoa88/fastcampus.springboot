package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Users;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.Optional;

public class UsersRepositoryTest extends StudyApplicationTests {

    @Autowired
    private UsersRepository usersRepository;

    @Test
    public void create(){
        Users user = new Users();
        user.setAccount("pengsu1");
        user.setEmail("pengsu1@gmail.com");
        user.setPhone("010-2222-3333");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("admin");

        Users newUser = usersRepository.save(user);
        System.out.println("newUser : "+ newUser);
    }

    @Test
    public void read(){
        Optional<Users> user = usersRepository.findById(9L);
        user.ifPresent(selectUser -> {  //테이블에 "9L(long type이므로)"이라는 id가 있다면 가져오라는 의미(해당 id가 없을수도 있기 때문에)
            System.out.println("user : " + user);
            System.out.println(selectUser.getEmail());
        });

    }

    @Test
    public void update(){
        //수정을 하려면 수정 대상을 찾아와야 한다. 그러므로 아래의 문장으로 해당하는 데이터를 가져온다
        Optional<Users> user = usersRepository.findById(1L);
        user.ifPresent(selectUser -> {
            selectUser.setAccount("userid");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            usersRepository.save(selectUser);  //해당 id가 존재한다면 jpa가 알아서 수정을 진행한다.
        });
    }

    @Test
    @Transactional  //이 어노테이션을 사용할 경우 롤백시켜주기 때문에 삭제되는지 테스트만 해볼 수 있다.
    public void delete(){
        Optional<Users> user = usersRepository.findById(2L);
        Assertions.assertTrue(user.isPresent());  //데이터가 없을수도 있으니 삭제 대상의 데이터가 있을 경우에만(true) 진행한다
        //위 코드로 인해 없는 데이터에 대해 삭제 할 경우 error를 만나게 된다

        user.ifPresent(selectUser -> {
            usersRepository.delete(selectUser);
        });

        Optional<Users> deleteUser = usersRepository.findById(2L);
        Assertions.assertFalse(deleteUser.isPresent()); //이미 삭제되었기 때문에 반드시 false여야 한다






    }
}
