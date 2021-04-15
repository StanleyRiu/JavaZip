import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFile {
    public static void main(String[] args) throws IOException {
//        ZipFile zipFile = new ZipFile();
        for (String arg : args) {

        }
        String user_dir = System.getProperty("user.dir");
        String zipFileName = new File(user_dir).getName();
        FileOutputStream fos = new FileOutputStream(zipFileName+".zip");
        ZipOutputStream zos = new ZipOutputStream(fos);
        for (String srcFile : args) {
            File fileToZip = new File(srcFile);
            FileInputStream fis = new FileInputStream(fileToZip);
            ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
            zos.putNextEntry(zipEntry);
            byte[] bytes = new byte[1024];
            int length;
            while ((length = fis.read(bytes)) >= 0) {
                zos.write(bytes, 0, length);
            }
            fis.close();
        }
        zos.close();
        fos.close();
    }
}
