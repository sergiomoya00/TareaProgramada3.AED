package SYSTEM;

import java.io.*;
import java.util.zip.*;
import javax.swing.JOptionPane;

public class FileCompress {

    public static void compress(File source, File destination) throws IOException {
        byte[] buffer = new byte[1024];
        FileInputStream fis = new FileInputStream(source);
        FileOutputStream fos = new FileOutputStream(destination);
        GZIPOutputStream gzos = new GZIPOutputStream(fos);
        int read;
        while ((read = fis.read(buffer)) != -1) {
            gzos.write(buffer, 0, read);

        }
        gzos.finish();
        gzos.close();
        fos.close();
        fis.close();
    }

    public static void generateCompressed() {
        File source = new File("direccion del archivo creado antes");
        File destination = new File("direccion del archivo que se va a crear con su nombre");
        try {
            compress(source, destination);
        } catch (IOException e) {
           // JOptionPane.showMessageDialog(null, "Ocurrio un error al ingresar los datos del archivo");(e);
        }
    }
}
