package com.nology.taskmanager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskItemRepository extends JpaRepository<TaskItem, Long> {

        void deleteTaskItemById(long id);
}
