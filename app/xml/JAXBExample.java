package xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JAXBExample<T> {
    public void toXML(String fileName, T object) {
        try {
            File file = new File(fileName);
            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(object, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public T fromXML(String fileName, Class<T> instance) {
        try {
            File file = new File(fileName);
            JAXBContext jaxbContext = JAXBContext.newInstance(instance);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            T result= (T) jaxbUnmarshaller.unmarshal(file);
            return result;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

}
