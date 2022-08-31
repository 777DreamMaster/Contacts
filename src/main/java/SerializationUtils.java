import java.io.*;

class SerializationUtils {
    private static File file;

    public static void createFile(String name) {
        File newFile = new File(System.getProperty("user.dir") + "/" + name);
        if (!newFile.exists()) {
            try {
                newFile.createNewFile();
                file = newFile;
            } catch (Exception e) {
                System.out.println("Err while creating file");
            }
        }
    }
    /**
     * Serialize the given object to the file
     */
    public static void serialize(Object obj) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(obj);
        oos.close();
    }

    /**
     * Deserialize to an object from the file
     */
    public static Object deserialize() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);
        ObjectInputStream ois = new ObjectInputStream(bis);
        Object obj = ois.readObject();
        ois.close();
        return obj;
    }

    public static boolean isExist() {
        return file != null;
    }
}