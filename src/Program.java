import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Program {
    public static void main(String[] args) {
        System.out.println("������������!");
        startProgram();
    }

    static void startProgram() {
        System.out.println("������� ����� ��������� (1-3), ���� ������� \"Q\" ��� ������.");
        Scanner scanner = new Scanner(System.in);
        System.out.print("��������� � ");
        String program = scanner.nextLine();
        if (program.equalsIgnoreCase("q")) {
            System.out.println("�� ��������!");
        } else if (program.chars().allMatch(Character::isDigit)) {
            switch (program) {
                case "1" -> ex0();
                case "2" -> ex1();
                case "3" -> ex2();
                default -> {
                    System.out.println("������ ������������ �����, ����������, ���������� ��� ���.");
                    startProgram();
                }
            }
        } else {
            System.out.println("���� �����������, ����������, ���������� ��� ���.");
            startProgram();
        }
    }

    // ������ 1. ����� ��� ������������ ������ ����� �����, ������� �� ���� ������ �����
    static void ex0() {
        ArrayList<Integer> list = getRandomArray(10);
        System.out.println("����������� ������ = " + list);
        list.removeIf(number -> number % 2 == 0);
        System.out.println("�������� ������ = " + list);
        startProgram();
    }

    // ������ 2. ����� ������������� ������ ArrayList. ����� �����������, ������������ � ������� �������������� ��
    // ����� ������. Collections.max()
    static void ex1() {
        ArrayList<Integer> list = getRandomArray(5);
        System.out.println("����������� ������ = " + list);
        int max = Collections.max(list);
        int min = Collections.min(list);
        int average = 0;
        for (int i = 0; i < list.size(); i++) {
            average += list.get(i);
        }
        average = average / list.size();
        System.out.println("������������ �������� = " + max);
        System.out.println("����������� �������� = " + min);
        System.out.println("������� �������������� ���� ��������� = " + average);
        startProgram();
    }

    // ������ 3. *����������� �������� ���������� ��������
    static void ex2() {
        ArrayList<Integer> list = getRandomArray(10);
        System.out.println("����������� ������ = " + list);
        int[] array = list.stream().mapToInt(i -> i).toArray();
        mergeSort(array);
        System.out.println("��������������� ������ = " + Arrays.toString(array));
        startProgram();
    }

    // ������� � ��������� ���������� ������� �� 0 �� 100 ���� ��������� �������
    static ArrayList<Integer> getRandomArray(Integer size) {
        ArrayList<Integer> list = new ArrayList();
        for (int i = 0; i < size; i++) {
            int random = ThreadLocalRandom.current().nextInt(0, 101);
            list.add(random);
        }
        return list;
    }

    // ���������� ��������� ������� �� ���������� �������
    static void mergeSort(int[] list) {
        int size = list.length;

        if (size < 2) return;

        int mid = size / 2;
        int[] leftList = new int[mid];
        int[] rightList = new int[size - mid];

        System.arraycopy(list, 0, leftList, 0, mid);
        System.arraycopy(list, mid, rightList, 0, size - mid);

        mergeSort(leftList);
        mergeSort(rightList);

        merge(list, rightList, leftList);
    }

    // �������� �������� ������� � ��������, �������� �� �������� � ��������
    static void merge(int[] list, int[] rightList, int[] leftList) {
        int i = 0, j = 0, k = 0;

        while (i < leftList.length && j < rightList.length) {
            if (leftList[i] <= rightList[j]) list[k++] = leftList[i++];
            else list[k++] = rightList[j++];
        }

        while (i < leftList.length) {
            list[k++] = leftList[i++];
        }

        while (j < rightList.length) {
            list[k++] = rightList[j++];
        }
    }
}
