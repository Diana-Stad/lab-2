## Отчет по лабораторной работе № 2

#### № группы: `ПМ-2402`

#### Выполнила: `Стадникова Диана Денисовна`

#### Вариант: `24`

### Cодержание:

- [Постановка задачи](#1-постановка-задачи)
- [Входные и выходные данные](#2-входные-и-выходные-данные)
- [Математическая модель](#25-математическая-модель)
- [Выбор структуры данных](#3-выбор-структуры-данных)
- [Алгоритм](#4-алгоритм)
- [Программа](#5-программа)
- [Анализ правильности решения](#6-анализ-правильности-решения)

### 1. Постановка задачи

> Программа получает считывает с консоли число N, затем N слов и заполняет массив
размером N.
> Далее необходимо выполнить ряд задач:
- Сортировать массив слов в порядке возрастания длины слова. Если
длины равны, сортировать в алфавитном порядке.
- Найти и вывести самое длинное слово в массиве.
- Вывести слова, которые являются анаграммами друг друга, группируя их вместе.
- Заменить в каждом слове все гласные буквы на следующий по алфавиту символ и вывести полученный массив.

Данную задачу необходимо разделить на 4 мини-задачи,которые в свою очередь, тоже разобьются на несколько подзадач(в данном 
пункте описано кратко,далее уже расписаны подробные шаги)

- Для 1 мини-задачи:
  1. Сортируем методом пузырька при неравных длинах слов
  2. При равных длинах начинаем сравнивать по символьно,чтобы отсортировать в алфавитном порядке
- Для 2 мини-задачи
  1. Находим самое длинное слово в массиве
  2. Выводим его
- Для 3 мини-задачи
  1.Сортировка букв в строках
  2.Находим одинаковые строки
- Для 4 мини-задачи
  1. Преобразование гласных
  2. Рассматриваем определенные случаи

### 2. Входные и выходные данные

#### Данные на вход

На вход программа должна получать натуральное число, которое является размеров массива,а также обозначает какое количество слов введено в массив.
В задаче не указаны верхние границы размера одного слова,поэтому будем считать что максимальная длина слова-100 символов. Минимальное значение для n будет 1 тк 
в массиве должен быть хотя бы 1 элемент.

|             | Тип                | min значение    | max значение   |
|-------------|--------------------|-----------------|----------------|
|     n       | Натуральное число  |         1       | 10<sup>9</sup> |
|    w[i]     |     строка         |    1 символ     |  100 символов  |
#### Данные на выход

Т.к. в задаче указано вывести массив только в последнем задании, то самостоятельно обозначим вывод массива после каждого пункта задачи,
чтобы удобнее было смотреть правильность выполнения каждого пункта

|                 |       Тип                          | min значение |         max значение     |
|-----------------|------------------------------------|--------------|--------------------------|
| массив 1        |          Одномерный массив         | 1 элемент    | 10<sup>9</sup> элементов |
| 1 элемент(max)  |              строка                |  1 символ    |       100 символов       |
| массив 2        |          Одномерный массив         | 1 элемент    | 10<sup>9</sup> элементов |
| массив 3        |          Одномерный массив         | 1 элемент    | 10<sup>9</sup> элементов |

### 3. Выбор структуры данных

Программа получает натуральное число, не превышающее по модулю 10<sup>9</sup> < 2<sup>30</sup>. Поэтому для его хранения
можно выделить переменную (`n`) типа `int`.

|             | название переменной | Тип (в Java) | 
|-------------|---------------------|--------------|
|    n      | `x`                 | `double`     |
| Y (Число 2) | `y`                 | `double`     | 

Для вывода результата необязательно его хранить в отдельной переменной.

### 4. Алгоритм

#### Алгоритм выполнения программы:

1. **Ввод данных:**  
   

2. ** **  
   

3. ** **
    - 
      

4. **Вывод результата:**  
  



### 5. Программа

```java
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
public class Main {
    public static Scanner in = new Scanner(System.in);
    public static PrintStream out = System.out;
    public static void main(String[] args) throws IOException {
        //Считываем с консоли число N
        int n = in.nextInt();
        //переход к следующей строке
        // (избегаем захвата лишних символов в буфере)
        in.nextLine();
        //создаем массив строк длинной n
        String[] w = new String[n];
        // Вводим n строк в массив w
        for (int i = 0; i < n; i++)
            w[i] = in.nextLine();
        //сортировка пузырьком
        for (int j = 1; j < n ; j++) {
            for (int i = 0; i < n-j; i++) {
                //Сравниваем длины строк
                if (w[i].length() > w[i+ 1].length()) {
                    // Меняем местами, если длина строки i больше, чем у i+1
                    String z = w[i];
                    w[i] = w[i+1];
                    w[i+1] = z;
                }
                // Если длины одинаковые,то выстраиваем строки
                //в алфавитном порядке
                else if (w[i].length() == w[i+1].length()) {
                    if (w[i].compareTo(w[i+1]) > 0) {
                        String r = w[i];
                        w[i] = w[i+1];
                        w[i+1] = r;
                    }
                }
            }
        }
        // Выводим отсортированные строки
        for (int i = 0 ; i < w.length ; i++)
            out.print(w[i] + " ");
        System.out.println();
        // Находим строку с максимальной длиной
        int max = 0;
        String maxw = "";
        for (int i = 0; i < w.length; i++) {
            if (w[i].length() > max) {
                max = w[i].length();
                maxw = w[i];
            }
        }
        out.println(maxw);
        // Копируем массив w в новый массив group
        String [] group = new String [n];
        for (int i = 0; i < group.length; i++){
            group[i] = w[i];
        }
        // Сортируем пузырьком буквы в каждой строке
        for (int k = 0; k < group.length; k++){
            // Преобразуем строку в массив символов
            char[] Array = group[k].toCharArray();
            for (int i = 1; i < Array.length; i++) {
                for (int j = 0; j < Array.length - i; j++) {
                    if (Array[j] > Array[j + 1]) {
                        char temp1 = Array[j];
                        Array[j] = Array[j + 1];
                        Array[j + 1] = temp1;
                    }
                }
            }
            // Преобразуем отсортированный массив символов обратно в строку
            group[k] = new String(Array);
        }
        // Флаг для нахождения одинаковых строк
        boolean flag = false;
        for (int i = 0 ; i < w.length ; i++){
            String str = w[i];
            for (int j = 0; j < w.length; j++){
                // Если отсортированная строка совпадает с другой строкой
                //Добавляем строку w[j] к str
                if (group[i].equals(group[j]) && i != j){
                    str += " " + w[j];
                    flag = true;
                    // помечаем строку group[j] как обработанную
                    group[j] = w[j];

                }
            }
            // Выводим строки с одинаковыми символами в алфавитном порядке
            // и сброс флага
            if (flag) {
                System.out.println(str);
                flag = false;
            }
        }
        // Преобразуем гласные буквы в строках(гласная заменяется
        // на следущую букву в алфавите)
        for (int i = 0 ; i < w.length ; i++){
            for (int j = 0; j < w[i].length(); j++){
                if ("AEIOUYyaeiouАИОУЭЫЮаиоуэыю".indexOf(w[i].charAt(j)) != -1){
                    String str1 = w[i].substring(0, j);
                    String str2 = w[i].substring(j + 1);
                    w[i] = str1 + (char)(w[i].charAt(j) + 1) + str2;
                }
                //с буквами е,ё,я работаем отдельно
                else if (w[i].charAt(j) == 'Ё'){
                    String str1 = w[i].substring(0, j);
                    String str2 = w[i].substring(j + 1);
                    w[i] = str1 + 'Ж' + str2;

                }
                else if (w[i].charAt(j) == 'ё'){
                    String str1 = w[i].substring(0, j);
                    String str2 = w[i].substring(j + 1);
                    w[i] = str1 + 'ж' + str2;
                }
                else if (w[i].charAt(j) == 'Е'){
                    String str1 = w[i].substring(0, j);
                    String str2 = w[i].substring(j + 1);
                    w[i] = str1 + 'Ё' + str2;
                }
                else if (w[i].charAt(j) == 'е'){
                    String str1 = w[i].substring(0, j);
                    String str2 = w[i].substring(j + 1);
                    w[i] = str1 + 'ё' + str2;
                }
                else if (w[i].charAt(j) == 'я'){
                    String str1 = w[i].substring(0, j);
                    String str2 = w[i].substring(j + 1);
                    w[i] = str1 + 'а' + str2;
                }
                else if (w[i].charAt(j) == 'Я'){
                    String str1 = w[i].substring(0, j);
                    String str2 = w[i].substring(j + 1);
                    w[i] = str1 + 'А' + str2;
                }
            }

        }
        // Выводим измененные строки
        for (int i = 0 ; i < w.length ; i++)
            out.print(w[i] + " ");
    }

}
            

```

### 6. Анализ правильности решения

Программа работает корректно на всем множестве решений с учетом ограничений.

1. Тест на `X > Y > 0`:

    - **Input**:
        ```
        5 1.3
        ```

    - **Output**:
        ```
        5
        ```


        5
        ```

