package com.taxipark.connectors;

import com.taxipark.taxi.Taxi;
import com.taxipark.taxi.TaxiPark;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class Serializer {
    public static final Logger logger = LogManager.getLogger(Serializer.class.getName());

    public static boolean serialize(Object object, String fileName){
        boolean flag = false;
        File file = new File(fileName);
        ObjectOutputStream outputStream = null;
        try(FileOutputStream fileOutputStream = new FileOutputStream(file)){
            outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(object);
            flag = true;
        } catch (IOException e){
            logger.error(e);
        }

        return flag;
    }

    public static Object deserialize(String fileName) throws InvalidObjectException {
        File file = new File(fileName);
        ObjectInputStream objectInputStream = null;
        try(FileInputStream fileInputStream = new FileInputStream(file)){
            objectInputStream = new ObjectInputStream(fileInputStream);
            return (Taxi) objectInputStream.readObject();
        }
        catch (ClassCastException e){
            try{
                FileInputStream fileInputStream = new FileInputStream(file);
                objectInputStream = new ObjectInputStream(fileInputStream);
                return (TaxiPark) objectInputStream.readObject();
            }
            catch (IOException | ClassNotFoundException innerException){
                logger.error(innerException);
            }
        }
        catch (IOException | ClassNotFoundException e){
            logger.error(e);
        }
        throw new InvalidObjectException("Object wasn't serialized");
    }
}
