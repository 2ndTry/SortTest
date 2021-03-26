
public class SortTest {

    public static void main(String[] args) {

        //Сравнение двух типов сортировки массива (Быстрая и Пузырьком) при 100000 эрементах.
        // Выполнение тестов может занять некоторое время.
        test1(); //случайный массив
        test2(); //отсортированный массив
        System.out.println("Вывод: При сортировке случайных чисел быстрая сортировка на\n" +
                "порядки быстрее пузырьковой, но при наличии массива отсортированного или близкого к\n" +
                "отсортированному сортировка пузырьком может быть быстрее.");
    }

    public static void test1() {
        int testLen = 100000;

        int[] arr1 = new int[testLen];
        int[] arr2 = new int[testLen];

        System.out.println("\n-----Случайный массив------");

        for (int i = 0; i < testLen; i++) {
            arr2[i] = arr1[i] = (int) Math.round(Math.random() * 10000);
        }

        System.out.println("Быстрая сортировка:");
        measureTime(() -> BubbleSortVsQuickSort.quickSort(arr1, 0, testLen - 1));

        System.out.println("Сортировка пузырьком:");
        measureTime(() -> BubbleSortVsQuickSort.bubbleSort(arr2));
    }

    public static void test2() {
        int testLen = 100000;

        int[] arr1 = new int[testLen];
        int[] arr2 = new int[testLen];

        System.out.println("\n-----Отсортированный массив------");

        for (int i = 0; i < testLen; i++) {
            arr2[i] = arr1[i] = i;
        }

        System.out.println("Быстрая сортировка:");
        measureTime(() -> BubbleSortVsQuickSort.quickSort(arr1, 0, testLen - 1));

        System.out.println("Сортировка пузырьком:");
        measureTime(() -> BubbleSortVsQuickSort.bubbleSort(arr2));

    }

    private static void measureTime(Runnable task) {
        long startTime = System.currentTimeMillis();
        task.run();
        long elapsed = System.currentTimeMillis() - startTime;
        System.out.println("Затраченное время: " + elapsed + " ms");
    }
}

