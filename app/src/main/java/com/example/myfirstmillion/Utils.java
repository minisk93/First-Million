package com.example.myfirstmillion;

import java.util.ArrayList;

public class Utils {

    public static ArrayList<Question> setQuestionsBlock(int number) {
        ArrayList<Question> questions = new ArrayList<>();

        switch (number) {
            case 0:
                questions.add(new Question("Какая лучшая мобильная платформа в мире?", 3, new ArrayList<Option>() {{
                    add(new Option("Windows", true));
                    add(new Option("IOS", true));
                    add(new Option("Skynet", true));
                    add(new Option("Android", true));
                }}));
                questions.add(new Question("Чем питается Android?", 1, new ArrayList<Option>() {{
                    add(new Option("пиццей", true));
                    add(new Option("сладостями", true));
                    add(new Option("пельменями", true));
                    add(new Option("пюре с котлетой", true));
                }}));
                questions.add(new Question("Как называется среда разработки для Android?", 2, new ArrayList<Option>() {{
                    add(new Option("Word", true));
                    add(new Option("Metro Exodus", true));
                    add(new Option("Android Studio", true));
                    add(new Option("Блокнот", true));
                }}));
                break;

            case 1:
                questions.add(new Question("Какой формат используется для разметки Android?", 2, new ArrayList<Option>() {{
                    add(new Option("HTML", true));
                    add(new Option("Java", true));
                    add(new Option("XML", true));
                    add(new Option("UML", true));
                }}));
                questions.add(new Question("Почему нельзя задавать размеры в пикселях?", 1, new ArrayList<Option>() {{
                    add(new Option("Та можно", true));
                    add(new Option("Разница в отображении", true));
                    add(new Option("Это неудобно", true));
                    add(new Option("Нужно считать пиксели", true));
                }}));
                questions.add(new Question("Что такое лэйауты?", 0, new ArrayList<Option>() {{
                    add(new Option("Способы позицинирования элементов", true));
                    add(new Option("Компоненты Android", true));
                    add(new Option("Специальный формат", true));
                    add(new Option("Среды разработки", true));
                }}));
                questions.add(new Question("Какая структура у ArrayList?", 2, new ArrayList<Option>() {{
                    add(new Option("Элемент", true));
                    add(new Option("Компонент", true));
                    add(new Option("Список", true));
                    add(new Option("Объект", true));
                }}));
                questions.add(new Question("Переменная это...", 0, new ArrayList<Option>() {{
                    add(new Option("Изменяемое значение", true));
                    add(new Option("Элемент списка", true));
                    add(new Option("Индекс списка", true));
                    add(new Option("Незменяемое значение", true));
                }}));
                questions.add(new Question("Как индексируются элементы списка?", 3, new ArrayList<Option>() {{
                    add(new Option("С еденицы", true));
                    add(new Option("С заданного числа", true));
                    add(new Option("С десяти", true));
                    add(new Option("С нуля", true));
                }}));
                questions.add(new Question("Какая операция увеличивает переменную на еденицу?", 1, new ArrayList<Option>() {{
                    add(new Option("--", true));
                    add(new Option("++", true));
                    add(new Option("+-", true));
                    add(new Option("-+", true));
                }}));
                break;

            default:
                break;
        }
        return questions;
    }
}
