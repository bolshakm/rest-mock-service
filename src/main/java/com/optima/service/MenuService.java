package com.optima.service;

import com.optima.forms.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class MenuService {

    public OrderData place(OrderForm orderForm){
        OrderData orderData= new OrderData();
        double sum = 0;
        Map<Long, Integer> orderedDishes = orderForm.getOrderedDishes();
        List<OrderedDishData> orderedDishData = new ArrayList<>();
        for (Map.Entry<Long, Integer> item: orderedDishes.entrySet()){
            DishForm dishForm = getDrinksForm(item.getKey());
            orderedDishData.add(new OrderedDishData(dishForm, item.getValue()));
            sum = sum + dishForm.getPrice().doubleValue();
        }

        orderData.setOrderedDish(orderedDishData);
        orderData.setTotalSum(new BigDecimal(sum));
        return orderData;
    }

    public OrderData order( ){
        OrderData orderData= new OrderData();
        double sum = 0;
        Map<Long, Integer> orderedDishes = new HashMap<>();
        orderedDishes.put(1L, 3);
        orderedDishes.put(3L, 2);
        orderedDishes.put(4L, 3);
        orderedDishes.put(35L, 3);
        orderedDishes.put(36L, 4);
        orderedDishes.put(37L, 3);
        List<OrderedDishData> orderedDishData = new ArrayList<>();
        for (Map.Entry<Long, Integer> item: orderedDishes.entrySet()){
            DishForm dishForm = getDrinksForm(item.getKey());
            orderedDishData.add(new OrderedDishData(dishForm, item.getValue()));
            sum = sum + dishForm.getPrice().doubleValue();
        }

        orderData.setOrderedDish(orderedDishData);
        orderData.setTotalSum(new BigDecimal(sum));
        return orderData;
    }


    public MenuForm getMock() {
        MenuForm result = new MenuForm();
        result.setTableNumber(1);
        List<CategoryForm> categoryFormList = new ArrayList<>();

        CategoryForm drinksCateg = new CategoryForm();
        drinksCateg.setId(1L);
        drinksCateg.setName("Drinks");
        drinksCateg.setDescription("Drinks category description");
        drinksCateg.setDishes(getDrinks());

        CategoryForm dishesCateg = new CategoryForm();
        dishesCateg.setId(1L);
        dishesCateg.setName("Dishes");
        drinksCateg.setDescription("Dishes category description");
        dishesCateg.setDishes(getDishes());

        categoryFormList.add(drinksCateg);
        categoryFormList.add(dishesCateg);

        result.setId(1L);
        result.setName("Summertime");
        result.setCategories(categoryFormList);
        result.setActive(true);

        return result;
    }

    public DishForm getDrinksForm(Long id){
        List<DishForm> dishes = new ArrayList<>();
        dishes.addAll(getDishes());
        dishes.addAll(getDrinks());
        return dishes.stream().filter(item -> Objects.equals(item.getId(), id)).findFirst().get();
    }

    private List<DishForm> getDishes() {
        List<DishForm> dishForms = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            Long id = (long) i;
            String name = generateRealDishNames(i);
            String description = generateDishDescription(i);
            BigDecimal price = BigDecimal.valueOf(i * 1.5);
            DishForm dishForm = new DishForm(id, name, description, price);
            dishForms.add(dishForm);
        }
        return dishForms;
    }

    private List<DishForm> getDrinks() {
        List<DishForm> dishForms = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            Long id = (long) i + 34;
            String name = getDrinkNames(i);
            String description = generateDrinksDescription(i);
            BigDecimal price = BigDecimal.valueOf(i * 1.5);
            DishForm dishForm = new DishForm(id, name, description, price);
            dishForms.add(dishForm);
        }
        return dishForms;
    }

    public String generateRealDishNames(int index) {
        List<String> dishNames = Arrays.asList("Pasta Carbonara", "Chicken Alfredo", "Margherita Pizza", "Sushi Roll", "Caesar Salad", "Beef Stir-Fry", "Burger with Fries", "Pad Thai", "Grilled Salmon", "Ramen Noodles");
        return dishNames.get(index);
    }

    private String getDrinkNames(int index) {
        List<String> drinkNames = Arrays.asList("Espresso", "Espresso", "Latte", "Mocha", "Americano", "Flat White", "Macchiato", "Iced Coffee", "Cold Brew", "Chai Latte");
        return drinkNames.get(index);
    }

    private String generateDrinksDescription(int index) {
        return "Description for Drink " + getDrinkNames(index);
    }
    private String generateDishDescription(int index) {
        return "Description for Drink " + generateRealDishNames(index);
    }


}
