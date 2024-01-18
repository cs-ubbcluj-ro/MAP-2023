package Repository;


import Domain.Entity;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GeneralTextFileRepository <T extends Entity>
        extends MemoryRepository<T> {
    protected String filename;
    private String entityName;

    public GeneralTextFileRepository(String filename, String entityName) {
        this.filename = filename;
        this.entityName = entityName;
        this.readFromFile();
    }

    public void readFromFile()
    {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = null;
            while ((line = br.readLine()) != null)
            {
                Class className = Class.forName(entityName);
                T newObject = (T) className.getConstructor(String.class).newInstance(line);
                entities.add(newObject);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    //public void writeToFile();

    @Override
    public void add(T elem) throws DuplicateEntityException
    {
        super.add(elem);
        this.writeToFile();
    }

    private void writeToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            Class className = Class.forName(entityName);
            Method convertToString = className.getMethod("toFileString");
            for (T e: entities) {
                bw.write((String) convertToString.invoke(e));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
