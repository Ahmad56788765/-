class SingleNode<T> {
    T data;                 // Данные узла
    SingleNode<T> next;     // Следующий узел

    public SingleNode(T data) {
        this.data = data;
        this.next = null;
    }
}
public class OneWayList<T> {
    private SingleNode<T> head; // Начальный узел списка

    // Добавляем элемент в начало списка
    public void addToHead(T data) {
        SingleNode<T> newNode = new SingleNode<>(data);
        newNode.next = head;
        head = newNode;
    }

    // Добавляем элемент в конец списка
    public void addToTail(T data) {
        SingleNode<T> newNode = new SingleNode<>(data);
        if (head == null) {
            head = newNode;
        } else {
            SingleNode<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Удаляем первый элемент
    public T removeFromHead() {
        if (head == null) {
            throw new IndexOutOfBoundsException("Список пуст");
        }
        T data = head.data;
        head = head.next;
        return data;
    }

    // Печать содержимого списка
    public void printList() {
        SingleNode<T> current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Поиск элемента по значению
    public boolean contains(T targetData) {
        SingleNode<T> current = head;
        while (current != null) {
            if (current.data.equals(targetData)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Получение длины списка
    public int length() {
        int count = 0;
        SingleNode<T> current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}
public class Main4 {
    public static void main(String[] args) {
        OneWayList<Integer> list = new OneWayList<>();
        
        // Добавляем элементы в список
        list.addToHead(1); // добавляем элемент в голову
        list.addToTail(2); // добавляем элемент в хвост
        list.addToTail(3); // добавляем ещё один элемент в хвост
        
        // Выводим содержимое списка
        list.printList(); // Должно вывести: 1 -> 2 -> 3 -> null
        
        // Проверяем содержит ли список определенный элемент
        System.out.println(list.contains(2)); // Должно вернуть true
        
        // Проверяем длину списка
        System.out.println(list.length()); // Должно вывести 3
        
        // Удаляем первый элемент из головы
        list.removeFromHead();
        
        // Опять выводим содержимое списка
        list.printList(); // Теперь должно выводить: 2 -> 3 -> null
    }
}