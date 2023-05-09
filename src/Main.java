import java.util.*;
public class Main {

        public static void main(){
            int[] sizes = {1000, 10000, 100000, 1000000, 10000000};

            for (int size : sizes) {
                int[] data = generateRandomArray(size);


                long linearStartTime = System.nanoTime();
                linearSearch(data, 90);
                long linearEndTime = System.nanoTime();
                long linearDuration = linearEndTime - linearStartTime;


                Arrays.sort(data);


                long binaryStartTime = System.nanoTime();
                binarySearch(data, 90); //
                long binaryEndTime = System.nanoTime();
                long binaryDuration = binaryEndTime - binaryStartTime;

                System.out.printf("Tamaño: %d | Busqueda  Lineal: %d ns | Busqueda Binaria: %d ns%n", size, linearDuration, binaryDuration);
            }
        }

        private static int[] generateRandomArray(int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = (int) (Math.random() * size);
            }
            return array;
        }

        private static int linearSearch(int[] array, int value) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == value) {
                    return i;
                }
            }
            return -1;
        }

        private static int binarySearch(int[] array, int value) {
            int left = 0;
            int right = array.length - 1;

            while (left <= right) {
                int middle = left + (right - left) / 2;

                if (array[middle] == value) {
                    return middle;
                } else if (array[middle] < value) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }

            return -1;
        }
    }


