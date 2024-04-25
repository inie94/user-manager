# Базовая структура клиент-серверного взаимодействия
![Текст с описанием картинки](/images/arch.jpeg)  

# Инструменты:
* Swagger/Openapi - Инструмент декларативного описания API. Позволяет описать стандарт взаимодействия в удобочитаемом виде, а на основе него сгенерировать часть кода;
* SpringBoot - Современный фрейморк разработки серверных приложений, де-факто в подавляющем большенстве случаев является стандартом разработки;
* Hibernate(ORM) - Инструмент, позволяющий в подавляющем большенстве задачь унифицированно взаимодействовать с разного рода СУБД;
* H2 - Открытая кроссплатформенная СУДБ. Позволяет развернуть БД как в файловом режиме так и в оперативной памяти.

# Структура сервиса



# Просмотр базы данных:
http://localhost:8080/h2-console

# Команды:
* Запрос на создание пользователя: `curl -i -X POST -H "Content-Type: application/json" -d '{"firstName": "Jhon", "lastName": "Doe", "email": "jdoe@gmail.com", "birthDate": "1990-04-21"}' http://localhost:8080/users`
* Запрос списка пользователей: `curl -i -X GET -H "Accept: application/json" http://localhost:8080/users`
* Запрос конкретного пользователя: `curl -i -X GET -H "Accept: application/json" http://localhost:8080/users/1`
* Запрос на изменение пользователя: `curl -i -X PUT -H "Content-Type: application/json" -d '{"firstName": "James", "lastName": "Doe", "email": "jdoe@gmail.com", "birthDate": "1990-04-21"}' http://localhost:8080/users/1`
* Запрос на удаление пользователя: `curl -i -X DELETE -H "Accept: application/json" http://localhost:8080/users/1`

