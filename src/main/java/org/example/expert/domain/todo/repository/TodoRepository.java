package org.example.expert.domain.todo.repository;

import org.example.expert.domain.todo.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    // @Query를 @EntityGraph로 대체
    @EntityGraph(attributePaths = {"user"})
    Page<Todo> findAllByOrderByModifiedAtDesc(Pageable pageable);

    // findByIdWithUser 메서드 대신, JpaRepository의 기본 findById를 오버라이딩
    @Override
    @EntityGraph(attributePaths = {"user"})
    Optional<Todo> findById(Long todoId);

    int countById(Long todoId);
}