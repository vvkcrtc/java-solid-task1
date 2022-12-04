Описание променяемых шаблонов.

Применение принципа SOLID - каждый класс отвечает за определенную функциональность:
Product - описание товара
Stock - реализует функциональность склада - хранение, учет, поиск
Buyer - покупатель,
Buyers - покупатели,
Market - реализует взаимодействие между покупателями и складом
Main - создание объектов
https://github.com/vvkcrtc/java-solid-task1/blob/3b01d94bfc95315f6ccb3667b96edcfbb88825c4/src/Main.java#L10

Применение принципа SOLID, класс Byers, в котором содержится список покупателей - класс Byer и методы работы с покупателями
https://github.com/vvkcrtc/java-solid-task1/blob/3b01d94bfc95315f6ccb3667b96edcfbb88825c4/src/Buyers.java#L4-L46

Применение шаблона DRY, вынесение повторяющийся логики в отдельный метод
https://github.com/vvkcrtc/java-solid-task1/blob/3b01d94bfc95315f6ccb3667b96edcfbb88825c4/src/Buyers.java#L12-L26

Применение принципа SOLID, класс Market осуществляет взаимодействие между складом - класс Stock, где хранятся товары - класс Product и покупателями - класс Byers
https://github.com/vvkcrtc/java-solid-task1/blob/3b01d94bfc95315f6ccb3667b96edcfbb88825c4/src/Market.java#L4

Применение DRY, исключение повторяющийся логики
https://github.com/vvkcrtc/java-solid-task1/blob/3b01d94bfc95315f6ccb3667b96edcfbb88825c4/src/Market.java#L60

Применение DRY, категории товара вынесены в множество, если потребуется внести изменения - добавить категорию товара не потребуется изменять код во многих местах
https://github.com/vvkcrtc/java-solid-task1/blob/3b01d94bfc95315f6ccb3667b96edcfbb88825c4/src/Product.java#L2
