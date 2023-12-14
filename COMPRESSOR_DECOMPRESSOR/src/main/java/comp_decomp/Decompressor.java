/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp_decomp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

/**
 *
 * @author SUBHENDU
 */
public class Decompressor {
    public static void runDecompressor(File file) throws IOException{
        String rootDirectory=file.getParent();
        
        FileInputStream fis=new FileInputStream(file);
        GZIPInputStream gzip=new GZIPInputStream(fis);
        FileOutputStream fos=new FileOutputStream(rootDirectory+"/decompressedfile");
        
        byte []b=new byte[1024];
        int len=0;
        while((len=gzip.read(b))!=-1){
            fos.write(b, 0, len);
        }
        fos.close();
        gzip.close();
        fis.close();
      
    }
    
}
