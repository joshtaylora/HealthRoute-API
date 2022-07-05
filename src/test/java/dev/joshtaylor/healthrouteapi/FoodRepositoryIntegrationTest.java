package dev.joshtaylor.healthrouteapi;

import dev.joshtaylor.healthrouteapi.domain.Food;
import dev.joshtaylor.healthrouteapi.repository.FoodRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class FoodRepositoryIntegrationTest {

    @Autowired
    private FoodRepository foodRepository;

    @Test
    public void whenCalledSave_thenCorrectNumberOfFoods() {
        foodRepository.save(new Food("food1", 1, 2, 3, 4));
        List<Food> foods = (List<Food>) foodRepository.findAll();

        assertThat(foods.size()).isEqualTo(1);
    }
}
