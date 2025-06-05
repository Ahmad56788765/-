// Интерфейс для всех реализаций очереди
public interface Queue<T> {
    void enqueue(T item);               // Добавляет элемент в конец очереди
    T dequeue();                        // Удаляет и возвращает элемент из начала очереди
    boolean isEmpty();                  // Проверяет, пуста ли очередь
    int size();                         // Получение текущего количества элементов
}// Вспомогательный класс узла для односвязанного списка
class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
    }
}

public class LinkedQueue<T> implements Queue<T> {
    private Node<T> front = null;      // Головной узел
    private Node<T> back = null;       // Хвостовой узел
    private int count = 0;             // Текущее число элементов

    
    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item);
        if(front == null) {
            front = back = newNode;
        } else {
            back.next = newNode;
            back = newNode;
        }
        count++;
    }

   
    public T dequeue() {
        if(isEmpty()) {
            throw new RuntimeException("Очередь пуста");
        }
        T item = front.data;
        front = front.next;
        if(front == null) {
            back = null;               // Когда очередь становится пустой
        }
        count--;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public int size() {
        return count;
    }
}
public class Main2 {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedQueue<>(); // Неограниченная очередь
        
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        
        System.out.println(queue.dequeue()); // Выведет 1
        System.out.println(queue.dequeue()); // Выведет 2
        System.out.println(queue.size());    // Выведет 1
    }
}