package com.example.repository;

import com.example.entity.Message;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    @Query("FROM Message WHERE posted_by = :accountId")
    List<Message> findAllPostedBy(@Param("accountId") int account_id);
}
