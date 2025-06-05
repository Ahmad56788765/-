public class MyStack<T> {
    private T[] elements; // Массив для хранения элементов
    private int top = -1; // Индекс вершины стека (-1 означает пустой)
    
    public MyStack(int capacity) { // Конструктор принимает размер стека
        this.elements = (T[]) new Object[capacity];
    }

    public void push(T item) throws Exception {
        if(top + 1 >= elements.length){
            throw new Exception("Стек полон");
        }
        elements[++top] = item;
    }

    public T pop() throws Exception {
        if(isEmpty()){
            throw new Exception("Стек пуст");
        }
        return elements[top--]; // Возвращаем верхний элемент и уменьшаем индекс
    }

    public boolean isEmpty(){
        return top < 0;
    }
}
public class Main {
    public static void main(String[] args) {
        try{
            MyStack<Integer> stack = new MyStack<>(5); // Создаем стек размером 5
            
            stack.push(1);
            stack.push(2);
            System.out.println(stack.pop()); // Выведет 2
            System.out.println(stack.isEmpty()); // false
            stack.push(3);
            System.out.println(stack.pop()); // Выведет 3
            System.out.println(stack.pop()); // Выведет 1
            System.out.println(stack.isEmpty()); // true
        } catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
}