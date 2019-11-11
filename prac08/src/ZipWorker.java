
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

class ZipWorker extends SwingWorker<Double, Integer> {
    
    private List<String> files;
    private File folder;
    private MainFrame mainFrame;
    private final static int BUFFER_SIZE = 1024;
    private final static int PERCENTAGE = 100;  
    private String destPath;
    
    public ZipWorker(MainFrame mainFrame, File file,String destPath) {
        folder = file;
        files = new ArrayList<String>();
        this.mainFrame = mainFrame;
        this.destPath=destPath;
    }
    
    @Override
    protected Double doInBackground() throws Exception {
 
        System.out.println("doInBackground() esta en el hilo "
                + Thread.currentThread().getName());
        
        comprimeFichero();
        
        //publish(i);
        
        return 100.0;
    }

    @Override
    protected void done() {
        mainFrame.finish();
    }

    @Override
    protected void process(List<Integer> chunks) {
        chunks.forEach((chunk) -> mainFrame.notifyProgess(chunk));
    }

    private void comprimeFichero() {
        int size = folder.list().length;
        int cont = 0;
        
        try{
            
            BufferedInputStream origin = null;
               
            FileOutputStream dest = new FileOutputStream(destPath+File.separator+folder.getName()+".zip");
            ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
            
            byte[] data = new byte[BUFFER_SIZE];
            
            for(File i : folder.listFiles()){
                
                Thread.sleep(1000);
                cont++;
                FileInputStream fi = new FileInputStream(i.getAbsolutePath());
                origin = new BufferedInputStream(fi, BUFFER_SIZE);

                ZipEntry entry = new ZipEntry(folder.getName()+File.separator+i.getName());
                out.putNextEntry(entry);

                int count;
                while ((count = origin.read(data, 0, BUFFER_SIZE)) != -1) {
                    out.write(data, 0, count);
                }

                origin.close();
                publish((cont*PERCENTAGE/size));
            }

            out.close();
        }
        catch( Exception e){
            mainFrame.errorOcurred();
        }
        if(size==0){
            publish(100);
            return;
        }
    }
}
