/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp_decomp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/**
 *
 * @author SUBHENDU
 */
public class Compressor {
    public static void runCompression(File file)throws IOException {
        String rootDirectory=file.getParent();
        FileInputStream fis=new FileInputStream(file);
        FileOutputStream fos=new FileOutputStream(rootDirectory+"/compressedfile.gz");
        GZIPOutputStream gzip=new GZIPOutputStream(fos);
        
        byte b[]=new byte[1024];
        int len=0;
        while((len=fis.read(b))!=-1){
            gzip.write(b, 0, len);
        }
        gzip.close();
        fos.close();
        fis.close();
    }

}
