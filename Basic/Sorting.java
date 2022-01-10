import java.util.Arrays;

public class Sorting {

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        shuffle(arr);
        selectSort(arr);
        System.out.println("선택 정렬: " + Arrays.toString(arr));

        shuffle(arr);
        insertionSort(arr);
        System.out.println("삽입 정렬" + Arrays.toString(arr));

        shuffle(arr);
        bubbleSort(arr);
        System.out.println("버블 정렬" + Arrays.toString(arr));

        shuffle(arr);
        quickSort(arr, 0, arr.length - 1);
        System.out.println("퀵 정렬" + Arrays.toString(arr));
    }

    static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    static void shuffle(int[] arr) {
        int x, y;
        for (int i = 0; i < 100; i++) {
            x = (int) (Math.random() * arr.length);
            y = (int) (Math.random() * arr.length);
            if (x == y) {
                continue;
            }

            swap(arr, x, y);
        }
    }

    /*
    선택 정렬

    단순히 가장 작은 데이터를 선택하고 맨 앞에 데이터와 바꾸고 그다음 데이터를 선택해 두번째 데이터와 바꾸는 알고리즘.
    */
    static void selectSort(int[] arr) {

        int minIndex;
        for (int i = 0; i < arr.length; i++) {
            minIndex = arr[i];

            for (int j = i; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }

            swap(arr, i, minIndex);
        }
    }

    /*
    삽입 정렬

    데이터를 하나씩 확인해 각 데이터에 적절한 위치에 삽입하는 알고리즘.

    삽입 정렬은 두 번째 인덱스부터 시작
    1. 두 번째 인덱스 부터 기준 삼아 현재 인덱스-1과 비교.
    2. 기준으로 잡은 데이터가 더 작다면, 두 값을 바꿔주고 다시 비교한 인덱스-1과 비교.
    3. 자기보다 더 작은 데이터를 만났을 경우 stop
    */
    static void insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    /*
    버블 정렬

    서로 인접한 두 원소를 검사하여 정렬하는 알고리즘. (선택 정렬과 유사)

    1. 첫 번째 인덱스와 두 번째 인덱스를 비교, 두 번째와 세번째 비교... 마지막-1번째와 마지막 비교하면서 swap.
    2. 가장 큰 숫자가 맨 뒤로 갔으므로, 마지막 인덱스는 제외하고 반복
    */
    static void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }


    /*
    퀵 정렬

    기준을 설정한 다음 큰 수와 작은 수를 swap 그 후 리스트를 반으로 나누는 방식으로 동작.
    특징으로는 pivot이 사용되어 큰 숫자와 작은 숫자를 비교할 때 교환하기 위한 기준이 됨

    1. 리스트에서 첫 번째 데이터를 피벗으로 설정
    2. 왼쪽에서는 피벗보다 큰 데이터를 찾고, 오른쪽에서는 피벗보다 작은 데이터를 찾는다
    3-1. 엇갈리지 않았다면 두 값의 위치를 교환.
    3-2. 엇갈렸다면 작은 데이터와 피벗의 위치를 바꾸고 피벗의 위치를 고정, 피벗의 위치를 기준으로 왼쪽 오른쪽 분할 후 다시 반복.
     */
    static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = start;
        int left = start + 1;
        int right = end;

        while (left <= right) {
            while (left <= end && arr[left] <= arr[pivot]) {
                left += 1;
            }
            while (right > start && arr[right] >= arr[pivot]) {
                right -= 1;
            }

            if (left > right) {
                swap(arr, right, pivot);// 엇갈린 경우
            } else {
                swap(arr, left, right);
            }
        }

        quickSort(arr, start, right - 1);
        quickSort(arr, right + 1, end);
    }
}