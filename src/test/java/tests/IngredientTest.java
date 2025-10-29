package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IngredientTest {

    static Stream<Arguments> ingredientData() {
        return Stream.of(
                Arguments.of(IngredientType.SAUCE, "Соус Spicy-X", 90.0f),
                Arguments.of(IngredientType.SAUCE, "Соус фирменный Space Sauce", 80.0f),
                Arguments.of(IngredientType.FILLING, "Говяжий метеорит (отбивная)", 3000.0f),
                Arguments.of(IngredientType.FILLING, "Сыр с астероидной плесенью", 4142.0f)
        );
    }

    @ParameterizedTest
    @MethodSource("ingredientData")
    @DisplayName("Проверка: конструктор и геттеры корректно возвращают значения полей ингредиента")
    void ingredientConstructorAndGettersShouldReturnCorrectValues(IngredientType type, String name, float price) {
        Ingredient ingredient = new Ingredient(type, name, price);

        assertEquals(type, ingredient.getType(),
                "Метод getType() должен возвращать тип, переданный в конструктор");

        assertEquals(name, ingredient.getName(),
                "Метод getName() должен возвращать имя, переданное в конструктор");

        assertEquals(price, ingredient.getPrice(),
                "Метод getPrice() должен возвращать цену, переданную в конструктор");
    }
}
