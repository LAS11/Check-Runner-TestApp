# (CheckRunner)
 A Java app that can create a store cash receipts. output them onto console and save them in a txt-file

OC: Windows 10
Текстовый редактор: Notepad++
Сборщик проекта: Gradle 7.5

Инструкция по запуску:
1. Приложение нужно собрать, для чего в консоли откройте папку с проектом и введите gradlew build
2. В консоли перейдите в "Check-Runner-TestApp\app\build\classes\java\main"
3. Введите java checkrunner.CheckRunner <args>,
где <args> - набор параметров в форме "число-число" (товар) или "card-число" (скидочная карта)
Например: checkrunner.CheckRunner 10-5 8-12 card-0451

Что реализовано:
	1. Принятие списка аргументов, как товаров так и карт скидочных — приложение *работает* с последней предъяявленной картой
	2. Вывод чека списка покупок на экране
	3. Обработка исключений
	4. Сохранение чека списка покупок в txt-Файл (по умолчанию на диск D:/check.txt)

Что предстоит реализовать:
	1. Форматированный вывод чека в текстовый файл
	* Обработку скидочной карты (наложение скидки на все товары)
	* Скидочные товары (при их определённом количестве итоговая стоимость уменьшается)
	* БД товаров и скидочных карт принимать из txt-Файлов, подаваемых при старте программы
	* Реализовать БД на одной из вариации SQL
	* Написать тест-юниты
