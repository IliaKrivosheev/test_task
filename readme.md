# Тестовое задание компании Selsup по реализации класса для работы с API Честного знака

## Описание
### CrptApi

Класс `CrptApi` предоставляет функционал для взаимодействия с API CRPT (Честный знак) для создания документов. Класс реализует отправку запросов на создание документов и управление лимитами запросов для обеспечения потокобезопасности.

### Переменные
- `String API_URL` - Адрес для отправки запроса
- `AtomicInteger requestsCount` - кол-во отправленных запрсоов до превышения лимита
- `String USER_TOKEN` - токена пользователя
- `BlockingQueue<RequestData> requestQueue` - очередь запросов для отправки
- `HttpClient client` - экземпляра HttpClient, созданные для исключения повторного создания
### Методы
- `createDocument(Document document, String signature)` - Метод для создания документа путем отправки запроса к API CRPT
- `processRequestQueue()` - Обработка очереди запросов для создания документов
- `boolean canMakeRequest()` - Проверка возможности выполнения запроса на основе лимитов запросов
- `makeApiRequest(RequestData requestData)` - Выполнение запроса к API CRPT для создания документа
- `JSONObject createRequestBody(RequestData requestData)` - Преобразование данных запроса в JSONObject

### Внутренние классы
- `RequestData` - Внутренний класс для хранения данных запроса
- `Document` - Внутренний класс, представляющий документ
- `Product` - Внутренний класс, представляющий продукт
- `Description` - Внутренний класс, представляющий описание документа

### Особенности
- Потокобезопасность: Все методы и операции в классе `CrptApi` реализованы с учетом потокобезопасности (thread-safe).
- Управление лимитами запросов: Класс управляет лимитами запросов через установленный интервал времени и максимальное количество запросов.

## Использование
### Создание экземпляра CrptApi
```java
CrptApi crptApi = new CrptApi(TimeUnit.SECONDS, 10);  // Создание экземпляра с лимитом отправки в 10 запросов в секунду
```
### Примечание
- Взаимодействие с API CRPT требует наличия корректного токена пользователя (USER_TOKEN), который должен быть предоставлен для работы с API.
- В классе `Main` представлен тестовый пример использования `CrptApi`