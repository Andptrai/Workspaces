#include <iostream>
#include <vector>

void heapify(std::vector<int>& arr, int n, int i) {
    int largest = i;
    int l = 2 * i + 1;
    int r = 2 * i + 2;

    if (l < n && arr[i] < arr[l]) {
        largest = l;
    }

    if (r < n && arr[largest] < arr[r]) {
        largest = r;
    }

    if (largest != i) {
        std::swap(arr[i], arr[largest]);
        heapify(arr, n, largest);
    }
}

void heapSort(std::vector<int>& arr) {
    int n = arr.size();

    // Xây d?ng heap
    for (int i = n / 2 - 1; i >= 0; i--) {
        heapify(arr, n, i);
    }

    // Trích xu?t t? heap
    for (int i = n - 1; i > 0; i--) {
        std::swap(arr[0], arr[i]);
        heapify(arr, i, 0);

        // In ra m?ng sau m?i bu?c
        std::cout << "Bu?c " << n - i << ": ";
        for (int j = 0; j < arr.size(); j++) {
            std::cout << arr[j] << " ";
        }
        std::cout << std::endl;
    }
}

int main() {
    int arr_data[] = {5, 3, 2, 6, 1, 8, 2, 9, 0, 7};
    std::vector<int> arr(arr_data, arr_data + sizeof(arr_data) / sizeof(arr_data[0]));

    std::cout << "M?ng ban d?u: ";
    for (int i = 0; i < arr.size(); i++) {
        std::cout << arr[i] << " ";
    }
    std::cout << std::endl;

    // Heapify tru?c
    for (int i = arr.size() / 2 - 1; i >= 0; i--) {
        heapify(arr, arr.size(), i);
    }

    std::cout << "M?ng sau khi heapify: ";
    for (int i = 0; i < arr.size(); i++) {
        std::cout << arr[i] << " ";
    }
    std::cout << std::endl;

    // S?p x?p heap
    heapSort(arr);

    std::cout << "M?ng sau khi s?p x?p: ";
    for (int i = 0; i < arr.size(); i++) {
        std::cout << arr[i] << " ";
    }
    std::cout << std::endl;

    return 0;
}

