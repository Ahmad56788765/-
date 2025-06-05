import java.util.ArrayList;
import java.util.List;

public class MySet<T> {
    private List<T> elements; // Список уникальных элементов множества

    public MySet() {
        this.elements = new ArrayList<>();
    }
    
    /**
     * Добавляет элемент в множество,
     * игнорирует повторяющиеся элементы.
     */
    public void add(T element) {
        if (!elements.contains(element)) { // проверяем наличие элемента перед добавлением
            elements.add(element);
        }
    }

    /**
     * Удаляет указанный элемент из множества.
     */
    public boolean remove(T element) {
        return elements.remove(element); // возвращает true, если элемент найден и удалён
    }

    /**
     * Возвращает true, если множество содержит заданный элемент.
     */
    public boolean contains(T element) {
        return elements.contains(element);
    }

    /**
     * Возвращает количество элементов в множестве.
     */
    public int size() {
        return elements.size();
    }

    /**
     * Объединение двух множеств.
     */
    public MySet<T> union(MySet<T> otherSet) {
        MySet<T> result = new MySet<>();
        for (T e : elements) {
            result.add(e); // добавляем все элементы текущего множества
        }
        for (T e : otherSet.elements) {
            result.add(e); // добавляем элементы другого множества
        }
        return result;
    }

    /**
     * Пересечение двух множеств.
     */
    public MySet<T> intersection(MySet<T> otherSet) {
        MySet<T> result = new MySet<>();
        for (T e : elements) {
            if (otherSet.contains(e)) { // добавляем только общие элементы
                result.add(e);
            }
        }
        return result;
    }

    /**
     * Разность между двумя множествами.
     */
    public MySet<T> difference(MySet<T> otherSet) {
        MySet<T> result = new MySet<>();
        for (T e : elements) {
            if (!otherSet.contains(e)) { // добавляем только уникальные элементы текущего множества
                result.add(e);
            }
        }
        return result;
    }
}
public class Main6 {
    public static void main(String[] args) {
        MySet<Integer> setA = new MySet<>();
        MySet<Integer> setB = new MySet<>();
        
        // Добавляем элементы
        setA.add(1);
        setA.add(2);
        setA.add(3);
        
        setB.add(2);
        setB.add(3);
        setB.add(4);
        
        System.out.println("Size Set A: " + setA.size()); // Выведет: 3
        System.out.println("Size of Set B: " + setB.size()); // Выведет: 3
        
        // Проверка наличия элемента
        System.out.println("Contains '2' in Set A: " + setA.contains(2)); // true
        
        // Операция объединения
        MySet<Integer> unionAB = setA.union(setB);
        System.out.println("Union Size: " + unionAB.size()); // Выведет: 4 (1, 2, 3, 4)
        
        // Операция пересечения
        MySet<Integer> intersectAB = setA.intersection(setB);
        System.out.println("Intersection Size: " + intersectAB.size()); // Выведет: 2 (2, 3)
        
        // Операция разности
        MySet<Integer> diffAB = setA.difference(setB);
        System.out.println("Difference Size: " + diffAB.size()); // Выведет: 1 (1)
    }
}
