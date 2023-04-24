import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Collections.reverseOrder;

// Пусть дан список сотрудников:
// Иван Иванов
// Светлана Петрова
// Кристина Белова
// Анна Мусина
// Анна Крутова
// Иван Юрин
// Петр Лыков
// Павел Чернов
// Петр Чернышов
// Мария Федорова
// Марина Светлова
// Мария Савина
// Мария Рыкова
// Марина Лугова
// Анна Владимирова
// Иван Мечников
// Петр Петин
// Иван Ежов

// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
// Отсортировать по убыванию популярности Имени.


public class Ex_5_2 {
    public static void main(String[] args) {
        Map<String, Integer> namesDict = new HashMap<>();
        Map<Object, Object> countNamesDict = new HashMap<>();
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Иван Иванов", "Светлана Петрова", "Кристина Белова",
         "Анна Мусина", "Анна Крутова" ,"Иван Юрин", "Петр Лыков", "Павел Чернов", "Петр Чернышов", "Мария Федорова", 
         "Марина Светлова", "Мария Савина", "Мария Рыкова", "Марина Лугова", "Анна Владимирова", "Иван Мечников", "Петр Петин", 
         "Иван Ежов"));

        for (String name : list) {
            if (namesDict.containsKey(Array.get(name.split(" "), 0))) {
                int index = namesDict.get(Array.get(name.split(" "), 0));
                namesDict.put((String) Array.get(name.split(" "), 0), index+1);
            }
            else
                namesDict.put((String) Array.get(name.split(" "), 0), 1);
        }
        
        countNamesDict = namesDict.entrySet().stream().sorted(reverseOrder(Map.Entry.comparingByValue()))                                    
                            .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(e1, e2) -> e1,LinkedHashMap::new));
                                                    
        for (var item : countNamesDict.entrySet()) {
            System.out.println(item.getKey() + " " + item.getValue());
        }
    }
}
