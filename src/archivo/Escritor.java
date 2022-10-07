package archivo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Iterator;

public class Escritor {

	private byte [] arr; 
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		try{
			//archivo
			File arch = new File("D:\\arch.dat");
			RandomAccessFile raf = new RandomAccessFile(arch, "rw");
			
			String msj = "hola mundo :D\n", msj2 = " xD ";
			
			byte [] arrbytes = msj.getBytes();
			byte[] inicio =  new byte[msj.length()];
			byte [] fin;
			byte [] nuevo;
			
			int pos = raf.read();
			raf.seek(0);
			
			System.arraycopy(msj2.getBytes(), 0, msj.getBytes(), 0, msj2.length());
			for (int i = 0; i < msj.getBytes().length; i++) {
				System.out.println("i: " + i + " : " + msj.getBytes()[i]);
				if(i <= 4)
					inicio[i] = msj.getBytes()[i];
			}
			
			//nuevo =  + msj.getBytes();
			
			raf.write(msj.getBytes());
			raf.write(inicio);
			raf.close();
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}

}
