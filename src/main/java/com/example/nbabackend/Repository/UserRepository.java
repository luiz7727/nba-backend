package com.example.nbabackend.Repository;

import com.example.nbabackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    public Optional<User> findByNickname(String name);
    //Voce pode criar os seus prórios métodos, porém o nome precisa ser compatível com algumas convenções do spring boot.
    //por exemplo: Não Conseguia criar um método chamado findByName, pois o "Name" não existe nas convenções do spring boot, ai tive que colocar Nickname.
}
