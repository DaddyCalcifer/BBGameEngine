package com.example.gameengine.Controllers;

import com.example.gameengine.Models.*;
import com.example.gameengine.Properties;
import javafx.scene.control.Alert;
import java.net.MalformedURLException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;

public class FileManager {
    public static PropertiesModel loadProp() {

        PropertiesModel model = new PropertiesModel();
        try {
            File file = new File("appdata.prop");

            JAXBContext jaxbContext = JAXBContext.newInstance(PropertiesModel.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            PropertiesModel deserializedPropertyModel = (PropertiesModel) unmarshaller.unmarshal(file);

            model.setWindowName(deserializedPropertyModel.getWindowName());
            model.setHeight(deserializedPropertyModel.getHeight());
            model.setWidth(deserializedPropertyModel.getWidth());
            // Вывод десериализованных данных
            System.out.println("Deserialized Height: " + deserializedPropertyModel.getHeight());
            System.out.println("Deserialized Width: " + deserializedPropertyModel.getWidth());
            System.out.println("Deserialized Window Name: " + deserializedPropertyModel.getWindowName());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return model;
    }

    public static void saveAppData() throws JAXBException, IOException {
        try {
            PropertiesModel propertyModel = new PropertiesModel();
            propertyModel.setHeight(Properties.APP_HEIGHT);
            propertyModel.setWidth(Properties.APP_WIDTH);
            propertyModel.setWindowName(Properties.APP_TITLE);

            File file = new File("appdata.prop");

            JAXBContext jaxbContext = JAXBContext.newInstance(PropertiesModel.class);
            Marshaller marshaller = jaxbContext.createMarshaller();

            // Форматирование вывода XML
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Сериализация в файл
            marshaller.marshal(propertyModel, file);

            // Вывод XML в консоль
            marshaller.marshal(propertyModel, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    public static void serializeScene(Scene scene, String filePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(Scene.class);
            Marshaller marshaller = context.createMarshaller();


            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            // Сериализуем объект в XML
            marshaller.marshal(scene, new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static Scene deserializeScene(String filePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(Scene.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            // Десериализуем объект из XML
            return (Scene) unmarshaller.unmarshal(new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void serializeGamePbject(GameObject gameObject, String xmlFilePath) {
        try {
            File file = new File(xmlFilePath);
            JAXBContext jaxbContext = JAXBContext.newInstance(GameObject.class);
            Marshaller marshaller = jaxbContext.createMarshaller();

            // Устанавливаем форматирование XML (для читаемости)
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Сериализуем объект в XML и сохраняем в файл
            marshaller.marshal(gameObject, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    // Метод для десериализации объекта из XML
    public static GameObject deserializeGameObject(String xmlFilePath) {
        try {
            File file = new File(xmlFilePath);
            JAXBContext jaxbContext = JAXBContext.newInstance(GameObject.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            // Десериализуем объект из XML
            return (GameObject) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void serializeVector2(Vector2 vector2, String filePath) {
        try {
            File file = new File(filePath);
            JAXBContext context = JAXBContext.newInstance(Vector2.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(vector2, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static Vector2 deserializeVector2(String filePath) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                System.out.println("File not found: " + filePath);
                return null;
            }

            JAXBContext context = JAXBContext.newInstance(Vector2.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (Vector2) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void serializeSize(Size size_, String filePath) {
        try {
            File file = new File(filePath);
            JAXBContext context = JAXBContext.newInstance(Size.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(size_, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static Size deserializeSize(String filePath) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                System.out.println("File not found: " + filePath);
                return null;
            }

            JAXBContext context = JAXBContext.newInstance(Size.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (Size) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void serializeTransform(Transform tran, String filePath) {
        try {
            File file = new File(filePath);
            JAXBContext context = JAXBContext.newInstance(Transform.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(tran, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static Transform deserializeTransform(String filePath) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                System.out.println("File not found: " + filePath);
                return null;
            }

            JAXBContext context = JAXBContext.newInstance(Transform.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (Transform) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }
    private static Class<?> loadClassFromExternalFile(String filePath) throws MalformedURLException, ClassNotFoundException {
        File file = new File(filePath);
        URL url = file.toURI().toURL();
        URLClassLoader classLoader = new URLClassLoader(new URL[]{url});
        String className = "test_sss"; // Замените на имя вашего класса
        return Class.forName(className, true, classLoader);
    }
    public static void TestScriptLoader()
    {
        try {
            // Загрузка внешнего класса
            URLClassLoader classLoader = new URLClassLoader(new URL[]{new URL("file:C:\\Users\\Nikita\\IdeaProjects\\GameEngine\\target\\classes\\com\\example\\gameengine\\Components\\test_sss.class")});
            Class<?> externalComponentClass = classLoader.loadClass("test_sss");

            try {
                // Создание экземпляра внешнего класса
                Component externalComponent = (Component) externalComponentClass.getDeclaredConstructor().newInstance();
                externalComponent.start();
            } catch (Exception ex)
            {
                System.out.println("xd");
            }
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        //try {
        //    // Загрузка класса из внешнего файла
        //    String externalClassPath = "C:\\Users\\Nikita\\Desktop\\scripts\\test_sss.class";
        //    Class<?> externalClass = loadClassFromExternalFile(externalClassPath);
//
        //    // Создание экземпляра загруженного класса
        //    Object instance = externalClass.getDeclaredConstructor().newInstance();
//
        //    // Пример вызова метода из загруженного класса
        //    externalClass.getMethod("start").invoke(instance);
        //} catch (Exception e) {
        //    e.printStackTrace();
        //}
    }
}
