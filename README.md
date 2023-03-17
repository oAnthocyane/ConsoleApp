# Лабораторная работа №5. Консольное приложение на Java.

## Содержание

- [Цель работы](#Цель-работы)
- [Условие](#Условие)
- [Описание хранимых в коллекции классов](#Описание-хранимых-в-коллекции-классов)
- [Запуск](#Запуск)


## Цель работы
Реализовать консольное приложение, которое реализует управление коллекцией объектов в интерактивном режиме. В коллекции необходимо хранить объекты класса  <span style="color:red">HumanBeing</span>, описание которого приведено ниже.

## Условие

### Разработанная программа должна удовлетворять следующим требованиям:

- Класс, коллекцией экземпляров которого управляет программа, должен реализовывать сортировку по умолчанию.
- Все требования к полям класса (указанные в виде комментариев) должны быть выполнены.
- Для хранения необходимо использовать коллекцию типа <span style="color:red">java.util.HashMap</span>.
- При запуске приложения коллекция должна автоматически заполняться значениями из файла.
- Имя файла должно передаваться программе с помощью: **переменная окружения**.
- Данные должны храниться в файле в формате <span style="color:red">csv</span>.
- Чтение данных из файла необходимо реализовать с помощью класса <span style="color:red">java.io.InputStreamReader</span>.
- Запись данных в файл необходимо реализовать с помощью класса <span style="color:red">java.io.BufferedWriter</span>.
- Все классы в программе должны быть задокументированы в формате javadoc.
- Программа должна корректно работать с неправильными данными (ошибки пользовательского ввода, отсутсвие прав доступа к файлу и т.п.).

### В интерактивном режиме программа должна поддерживать выполнение следующих команд:

- <span style="color:red">help</span> : вывести справку по доступным командам
- <span style="color:red">info</span> : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
- <span style="color:red">show</span> : вывести в стандартный поток вывода все элементы коллекции в строковом представлении
- <span style="color:red">insert null {element}</span> : добавить новый элемент с заданным ключом
- <span style="color:red">update id {element}</span> : обновить значение элемента коллекции, id которого равен заданному
- <span style="color:red">remove_key null</span> : удалить элемент из коллекции по его ключу
- <span style="color:red">clear</span> : очистить коллекцию
- <span style="color:red">save</span> : сохранить коллекцию в файл
- <span style="color:red">execute_script file_name</span> : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.
- <span style="color:red">exit</span> : завершить программу (без сохранения в файл)
- <span style="color:red">remove_greater {element}</span> : удалить из коллекции все элементы, превышающие заданный
- <span style="color:red">remove_lower {element}</span> : удалить из коллекции все элементы, меньшие, чем заданный
- <span style="color:red">remove_greater_key null</span> : удалить из коллекции все элементы, ключ которых превышает заданный
- <span style="color:red">count_greater_than_impact_speed impactSpeed</span> : вывести количество элементов, значение поля impactSpeed которых больше заданного
- <span style="color:red">filter_less_than_impact_speed impactSpeed</span> : вывести элементы, значение поля impactSpeed которых меньше заданного
- <span style="color:red">print_field_descending_mood</span> : вывести значения поля mood всех элементов в порядке убывания

### Формат ввода команд:

- Все аргументы команды, являющиеся стандартными типами данных (примитивные типы, классы-оболочки, String, классы для хранения дат), должны вводиться в той же строке, что и имя команды.
- Все составные типы данных (объекты классов, хранящиеся в коллекции) должны вводиться по одному полю в строку.
- При вводе составных типов данных пользователю должно показываться приглашение к вводу, содержащее имя поля (например, "Введите дату рождения:")
- Если поле является enum'ом, то вводится имя одной из его констант (при этом список констант должен быть предварительно выведен).
- При некорректном пользовательском вводе (введена строка, не являющаяся именем константы в enum'е; введена строка вместо числа; введённое число не входит в указанные границы и т.п.) должно быть показано сообщение об ошибке и предложено повторить ввод поля.
- Для ввода значений null использовать пустую строку.
- Поля с комментарием "Значение этого поля должно генерироваться автоматически" не должны вводиться пользователем вручную при добавлении.

## Описание хранимых в коллекции классов:

``` java
public class HumanBeing {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private boolean realHero;
    private boolean hasToothpick;
    private Float impactSpeed; //Максимальное значение поля: 496, Поле может быть null
    private WeaponType weaponType; //Поле может быть null
    private Mood mood; //Поле может быть null
    private Car car; //Поле может быть null
}
```

``` java
public class Coordinates {
    private double x; //Значение поля должно быть больше -809
    private Float y; //Поле не может быть null
}
```

``` java 
public class Car {
    private boolean cool;
}
```

``` java
public enum WeaponType {
    HAMMER,
    PISTOL,
    SHOTGUN;
}
```

``` java
public enum Mood {
    LONGING,
    GLOOM,
    APATHY,
    RAGE;
}
```
## Документация
Документация по всем классам оформлена в javadoc. 

Путь к документации: build/docs/javadoc/index.html
## Запуск

### Helios
``` bash
export <название_переменной_окружения>=<путь_к_файлу>
cd /home/studs/s367292/Lab5/ConsoleApp
java -jar ./build/libs/ConsoleApp-1.0-SNAPSHOT.jar <название_переменной_окружения>
```

### На локальном компьютере
Скачать openjdk version "17.0.5", после чего склонировать репозиторий, перейти в папку ConsoleApp и запустить java -jar
```bash
sudo apt install openjdk-17-jdk 
git clone https://github.com/oAnthocyane/ConsoleApp.git
cd ConsoleApp
export <название_переменной_окружения>=<путь_к_файлу>
java -jar ./build/libs/ConsoleApp-1.0-SNAPSHOT.jar <название_переменной_окружения>
```