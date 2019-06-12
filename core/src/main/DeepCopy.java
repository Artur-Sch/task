package main;


import java.io.*;

public class DeepCopy {

    /**
     * Возвращает копию объекта или ноль, если объект не serialized;
     */
    public static Object copy(Object orig) {
        Object obj = null;
        try {
            // запись объекта в массив байт
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            try (ObjectOutputStream out = new ObjectOutputStream(bos)) {
                out.writeObject(orig);
                out.flush();
            }

            // прочитать из массива байт объект
            ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
            obj = in.readObject();
        }
        catch(IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }


}
