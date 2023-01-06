# CheckRunner: a Java app that can create a store cash receipts, output them onto console and save them in a txt-file

+ OC: Windows 10
+ Текстовый редактор: Notepad++
+ Сборщик проекта: Gradle 7.5
+ Версия JDK: 17.0.5 

Инструкция по запуску (вариант А, приложение нужно собрать (для чего в консоли откройте папку с проектом и введите gradlew build)):
1. В консоли перейдите в "Check-Runner-TestApp\app\build\classes\java\main",
2. Введите java CheckRunner args

Инструкция по запуску (вариант Б):
1. Открыв в консоли папку с проектом, введите gradlew run --args="args" //в кавычках
2. Если текст некорректно выводится на экран, добавьте в систему системную переменную GRADLE_OPTS со значением -Dfile.encoding=utf-8
3. (Windows) Также убедитесь, что в консоли установлена кодировка UTF-8 (устанавливается введением в консоль chcp 65001)

args - набор параметров в форме "число-число" (товар) или "card-число" (скидочная карта)
Например: java CheckRunner 4-8 15-16 23-42 card-0451

Имеется поддержка внешних txt-файлов, из которых программа может считать данные по продуктам и дисконтным картам:
cards="путь до txt-файла с указанием дисконтных карт"
products="путь до txt-файла с указанием продуктов"

Формат txt-файла с дисконтными картами: номер_карты размер скидки
Формат txt-файла с продуктами: имя_продукта цена маркер

Что реализовано:
* Принятие списка аргументов, как товаров так и карт скидочных — приложение работает с последней предъявленной картой
* Вывод чека списка покупок на экране
* Обработка исключений
* Сохранение чека списка покупок в txt-файл (по умолчанию в папку с программой, check.txt)
* Обработка скидочной карты (наложение скидки на общую стоимость всех товаров)
* Скидочные товары (при их определённом количестве итоговая стоимость уменьшается)
* Форматированный вывод чека в текстовый файл
* БД товаров и скидочных карт принимать из txt-файлов, подаваемых при старте программы

Что предстоит:
* Написать тест-юниты
* Реализовать БД на одной из вариации SQL
