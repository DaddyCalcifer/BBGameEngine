# GameEngine - Игровой движок для 2D игр

GameEngine - это простой игровой движок, разработанный для создания 2D игр в Java с использованием библиотеки JavaFX. Этот движок предоставляет базовые компоненты и структуры для удобного создания игровых объектов, управления сценами и визуализации.

## Основные особенности

- Удобная структура компонентов, включая Transform, GameObject, Size, Vector2 и др.
- Простая система управления сценами.
- Реализация базового рендеринга и управления игровыми объектами.
- Использование JavaFX для визуализации и отображения игровых сцен.

## Структура проекта

- **com.example.gameengine.Models**: Классы, представляющие основные компоненты игрового движка.
- **com.example.gameengine.Properties**: Классы, содержащие настройки и свойства для игрового движка.

## Использование

## Пример кода

Пример использования GameEngine для создания игрового объекта:

```java
import com.example.gameengine.Models.GameObject;
import com.example.gameengine.Models.SceneLayer;
import com.example.gameengine.Models.Transform;

public class MyGame {

    public static void main(String[] args) {
        // Инициализация игрового движка
        // ...

        // Создание игрового объекта
        GameObject player = new GameObject();
        player.Texture = /* загрузка текстуры */;
        player.transform.Position.set(100, 100);

        // Создание сцены
        SceneLayer mainScene = new SceneLayer();
        mainScene.addObject(player);

        // Отображение сцены
        mainScene.draw(/* JavaFX Pane */);
    }
}
```

## Зависимости

GameEngine зависит от библиотеки JavaFX для визуализации и отображения графики. Убедитесь, что вы правильно настроили свой проект, чтобы использовать JavaFX.

---

Создано с любовью и страстью к разработке игр. Приятного кодинга! 🎮✨
