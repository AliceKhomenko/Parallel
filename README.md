Привет!


Хочу вам рассказать немного про структуру проекта:
 * все сценарии хранятся в src/test/resources/features/
 * у сценариев есть теги, если хотите запустить выборочно группу тестов - указывайте в раннерах нужные вам теги
 * раннеры - точки запуска тестов - хранятся в src/test/java/runners/
 * описания реализациb шагов хранятся в src/test/java/stepdefs/, также реализацию можно посмотреть в page oblects,
которые хранятся в src/test/java/pages/
 * всякая всячина и дополнительные инструменты хранятся в src/test/java/additional/
 * готовые репорты можно посмотреть в reports/cucumber/<имя класса> - такие же и настройки указывать в раннерах в
 cucumber options. Там красота, шаги, сценарии, скриншоты - все по феншую
 * драйверы расположены в папке drivers/Chrome и drivers/Firefox - там их можно актуализировать по собственным нуждам
и версиям браузеров
 * настройки хранятся в src/test/resources/configuration.properties


 Баг репорт можно посмотреть по ссылке - https://docs.google.com/spreadsheets/d/1K4zl0LWOE5P7GmyDZlMOfGU9taUUwG2q_rEItpewCgQ/edit?usp=sharing
 Наслаждайтесь! :)
