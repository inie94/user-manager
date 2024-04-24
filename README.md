# Базовая структура клиент-серверного взаимодействия

# Структура сервиса



# Просмотр базы данных:
http://localhost:8080/h2-console
# Команды:
* Запрос на создание пользователя: `curl -i -X POST -H "Content-Type: application/json" -d '{"firstName": "Jhon", "lastName": "Doe", "email": "jdoe@gmail.com", "birthDate": "1990-04-21"}' http://localhost:8080/users`
* Запрос списка пользователей: `curl -i -X GET -H "Accept: application/json" http://localhost:8080/users`
* Запрос конкретного пользователя: `curl -i -X GET -H "Accept: application/json" http://localhost:8080/users/1`
* Запрос на изменение пользователя: `curl -i -X PUT -H "Content-Type: application/json" -d '{"firstName": "James", "lastName": "Doe", "email": "jdoe@gmail.com", "birthDate": "1990-04-21"}' http://localhost:8080/users/1`
* Запрос на удаление пользователя: `curl -i -X DELETE -H "Accept: application/json" http://localhost:8080/users/1`

