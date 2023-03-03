package validators;

import static colors.Colors.*;

public enum Errors {
    NOTHAVEENVIRONMENT("При запуске программы переменная окружения не была передана," +
            " запустите программу заново, передав переменную окружения"),
    WRONGENVIRONMENT("При запуске программы переменная окружения не имеет никакого значения, " +
            "либо было передано пустое значение переменной окружения, запустите программу заново с указанием переменной окружения"),
    EMPTYENVIRONMENT("Данная переменная окружения имеет пустое значение, " +
            "задайте правильное расположение файла в переменной и запустите программу заново с указанием переменной окружения"),
    NOTEXISTFILE("Данный файл не существует, передайте в переменную окружения существующий файл"),
    NOTCANREADFILE("Данный файл не имеет права доступа на чтение файла, разрешите доступ для чтения файла"),
    NOTCANWRITEFILE("Данный файл не имеет права доступа на запись данных в файл, разрешите доступ для записи в файл"),
    NOTCSVFILE("Данный файл не является csv файлом, передайте в переменную окружения csv-файл"),
    NOTHAVEERRORS("Ошибок не было найдено"),
    NOTHASONEARGUMENT("Команда remove_key принимает на вход 1 аргумент"),
    NOTCANTRANSFORMTOUUID("Невозможно преобразовать данный ключ к типу UUID"),
    NOTHASELEMENT("Элемента с таким ключом не существует в коллекции");

    final String error;
    Errors(String error){
        this.error = error;
    }

    @Override
    public String toString() {
        return RED + error + RESET;
    }
}
