# Баг-репорт: CashBackHacker

## Описание
Метод `CashbackHackService.remain()` некорректно обрабатывает суммы, кратные 1000.

## Шаги воспроизведения
1. Создать объект `CashbackHackService`
2. Вызвать метод `remain(1000)`
3. Проверить возвращаемое значение

## Ожидаемый результат
Метод возвращает `0` (докупать ничего не нужно)

## Фактический результат
Метод возвращает `1000`

## Окружение
- OS: Windows 10
- JDK: 11
- TestNG: 7.1.0
- JUnit: 4.13

## Серьезность
**Major** — нарушена базовая бизнес-логика

## Причина бага
В коде: `return boundary - amount % boundary;`
Если `amount = 1000`, то `1000 % 1000 = 0`, следовательно `1000 - 0 = 1000`

## Предлагаемое решение
```java
public int remain(int amount) {
    int remainder = amount % boundary;
    return remainder == 0 ? 0 : boundary - remainder;
}