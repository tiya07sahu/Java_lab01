package Sorting;


import java.util.Scanner;

public class MenuDrivenSortingProgram {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1) Bubble Sort");
            System.out.println("2) Selection Sort");
            System.out.println("3) Insertion Sort");
            System.out.println("4) Quick Sort");
            System.out.println("5) Merge Sort");
            System.out.println("6) Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    bubbleSort(sc);
                    break;
                case 2:
                    selectionSort(sc);
                    break;
                case 3:
                    insertionSort(sc);
                    break;
                case 4:
                    quickSortWrapper(sc);
                    break;
                case 5:
                    mergeSortWrapper(sc);
                    break;
                case 6:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        sc.close();
    }

    // Bubble Sort
    public static void bubbleSort(Scanner sc) {
        int[] arr = getArrayFromUser(sc);
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("Array sorted using Bubble Sort:");
        printArray(arr);
    }

    // Selection Sort
    public static void selectionSort(Scanner sc) {
        int[] arr = getArrayFromUser(sc);
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
        System.out.println("Array sorted using Selection Sort:");
        printArray(arr);
    }

    // Insertion Sort
    public static void insertionSort(Scanner sc) {
        int[] arr = getArrayFromUser(sc);
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        System.out.println("Array sorted using Insertion Sort:");
        printArray(arr);
    }

    // Quick Sort Wrapper
    public static void quickSortWrapper(Scanner sc) {
        int[] arr = getArrayFromUser(sc);
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Array sorted using Quick Sort:");
        printArray(arr);
    }

    // Quick Sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Partition for Quick Sort
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // Merge Sort Wrapper
    public static void mergeSortWrapper(Scanner sc) {
        int[] arr = getArrayFromUser(sc);
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("Array sorted using Merge Sort:");
        printArray(arr);
    }

    // Merge Sort
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    // Merge for Merge Sort
    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Utility function to get array from user
    public static int[] getArrayFromUser(Scanner sc) {
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    // Utility function to print array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}