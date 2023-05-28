package com.example.Recipe.Repository;

import com.example.Recipe.model.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


@Repository
@EnableJpaRepositories
public interface PassworTokenRepository extends JpaRepository<PasswordResetToken, Long> {

    PasswordResetToken findAllByToken(String token);


}
