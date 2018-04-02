package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.util.List;

@Transactional(readOnly = true)
public interface CrudMealRepository extends JpaRepository<Meal, Integer> {

    Meal findMealByIdAndUser_Id(Integer integer, Integer userId);

    @Override
    @Transactional
    Meal save(Meal entity);

    @Transactional
    int deleteMealByIdAndUser_Id(int integer, int userId);

    List<Meal> findAllByUser_Id(Sort sort, Integer userId);

    List<Meal> findByDateTimeBetweenAndUser_Id(LocalDateTime startDate, LocalDateTime endDate, Integer userId, Sort sort);
}
