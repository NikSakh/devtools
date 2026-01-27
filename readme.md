README

Запустить задачи Gradle:

Gradle Tool Window: откройте (View → Tool Windows → Gradle), дважды кликните run, build, test.

Run Anything (Ctrl + Ctrl): введите поочерёдно gradle run, gradle build, gradle test → Enter.


ru.mentee.power — пакет для управления данными менти: хранение имени, номера спринта, плановых часов и проверка готовности к спринту.



Поле - Описание

menteeName -	Имя менти (строка).

sprintNumber -	Номер текущего спринта (целое число).

plannedHoursPerWeek -	Плановые часы в неделю (число с плавающей точкой).

readyForSprint() -	Метод-проверка: возвращает true, если plannedHoursPerWeek > 0 и sprintNumber > 0, иначе false.