package com.example.gameengine.Controllers;

import com.example.gameengine.Models.PropertiesModel;
import com.example.gameengine.Properties;
import javafx.scene.control.Alert;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;

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
}
