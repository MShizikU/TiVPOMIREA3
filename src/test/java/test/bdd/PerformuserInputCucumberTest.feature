# language: ru
@all
Функционал: Обработка пользовательского ввода

  Сценарий: Пользователь вводит букву которая есть в начале слова
    Дано загаданное слово мошка
    Когда пользователь вводит букву м
    Тогда проверка на наличие буквы возвращает да

  Сценарий: Пользователь вводит букву которая есть в конце слова
    Дано загаданное слово кошка
    Когда пользователь вводит букву а
    Тогда проверка на наличие буквы возвращает да

  Сценарий: Пользователь вводит букву которая есть в середине слова
    Дано загаданное слово кошка
    Когда пользователь вводит букву ш
    Тогда проверка на наличие буквы возвращает да

  Сценарий: Пользователь вводит букву которой нет в слове
    Дано загаданное слово кошка
    Когда пользователь вводит букву ы
    Тогда проверка на наличие буквы возвращает нет

  Сценарий: Пользователь вводит английскую букву которой нет в слове
    Дано загаданное слово кошка
    Когда пользователь вводит букву a
    Тогда проверка на наличие буквы возвращает нет

  Сценарий: Пользователь удаляет букву из алфавита
    Дано загаданное слово кошка
    Когда пользователь вводит букву a
    Тогда алфавит должен стать _бвгдеёжзийклмнопрстуфхчшщьыъэюя