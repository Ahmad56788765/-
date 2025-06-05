import java.util.Random;

// Класс сортировок
class Sorts {
    // Быстрая сортировка
    public static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Вспомогательная функция разделения
    private static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    // Обмен значений местами
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Сортировка вставками
    public static void insertionSort(int arr[]) {
        for (int i = 1; i < arr.length; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}

// Тестирование скорости работы алгоритмов
public class SortTest {
    public static void main(String[] args) {
        Random random = new Random();
        final int SMALL_SIZE = 1_000;
        final int LARGE_SIZE = 1_000_000;

        // Генерация небольшого массива
        int smallArray[] = generateRandomArray(SMALL_SIZE, random);
        long startTimeSmallQS = System.nanoTime(); // Время начала быстрого сортирования малого массива
        Sorts.quickSort(smallArray, 0, smallArray.length - 1);
        long endTimeSmallQS = System.nanoTime(); // Время окончания быстрого сортирования малого массива
        System.out.printf("Time work QuickSort in small massiv (%d element): %f мс\n",
                          SMALL_SIZE, (endTimeSmallQS - startTimeSmallQS)/1e6);

        long startTimeSmallIS = System.nanoTime(); // Время начала сортировки вставками малого массива
        Sorts.insertionSort(smallArray);
        long endTimeSmallIS = System.nanoTime(); // Время окончания сортировки вставками малого массива
        System.out.printf("Time work InsertionSort in small massiv (%d element): %f мс\n",
                          SMALL_SIZE, (endTimeSmallIS - startTimeSmallIS)/1e6);

        // Генерация большого массива
        int largeArray[] = generateRandomArray(LARGE_SIZE, random);
        long startTimeLargeQS = System.nanoTime(); // Время начала быстрого сортирования большого массива
        Sorts.quickSort(largeArray, 0, largeArray.length - 1);
        long endTimeLargeQS = System.nanoTime(); // Время окончания быстрого сортирования большого массива
        System.out.printf("Time work QuickSort in big massiv (%d element): %f мс\n",
                          LARGE_SIZE, (endTimeLargeQS - startTimeLargeQS)/1e6);

        long startTimeLargeIS = System.nanoTime(); // Время начала сортировки вставками большого массива
        Sorts.insertionSort(largeArray);
        long endTimeLargeIS = System.nanoTime(); // Время окончания сортировки вставками большого массива
        System.out.printf("Time work InsertionSort in big massiv (%d element): %f мс\n",
                          LARGE_SIZE, (endTimeLargeIS - startTimeLargeIS)/1e6);
    }

    // Функция генерации случайного массива
    private static int[] generateRandomArray(int size, Random random) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++)
            array[i] = random.nextInt(size*2);
        return array;
    }
}