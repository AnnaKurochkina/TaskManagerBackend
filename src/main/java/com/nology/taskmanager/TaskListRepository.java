package com.nology.taskmanager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskListRepository extends JpaRepository<TaskList, Long> {

    @Query("SELECT t FROM TaskList t JOIN FETCH t.taskItems WHERE t.id = (:id)")
    TaskList getTaskListWithItems(@Param("id") Long id);
}
