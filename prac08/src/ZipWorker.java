
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

class ZipWorker extends SwingWorker<Double, Integer> {
    // Esta etiqueta se recibe en el constructor o a través de un
    // metodo setEtiqueta().
    private List<Observer> observers = new ArrayList<>();
    private File folder =new File("C:\\Users\\Entrar\\Desktop\\practica7\\prueba");
    private final static int BUFFER_SIZE = 1024;
    
    
    
    
    public void addObserver(Observer observer){
        observers.add(observer);
    }
    
    /*public void setFile(File folder){
        this.folder = 
    }*/
   
    
    @Override
    protected Double doInBackground() throws Exception {
   // Mostramos el nombre del hilo, para ver que efectivamente
   // esto NO se ejecuta en el hilo de eventos.
        System.out.println("doInBackground() esta en el hilo "
        + Thread.currentThread().getName()); 
        
        /********** Algo de procesamiento costoso ***********/
        
        String[] files = folder.list();
        comprimeFichero(files);
        
        
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
                // System.out.print(i);
                
            } catch (InterruptedException e) {
                System.out.println("interrumpido");
            }
            publish(i);
        }      
        return 100.0;
    }
    
   @Override
    protected void done() {
       // Mostramos el nombre del hilo para ver que efectivamente esto
       // se ejecuta en el hilo de eventos.
       System.out.println("done() esta en el hilo " + Thread.currentThread().getName());     
    }

    
    @Override
    protected void process(List<Integer> chunks) {
        chunks.forEach((chunk) -> observers.forEach( (observer) -> observer.notifyProgess(chunk)));
    }

    private void comprimeFichero(String[] files) {
        try{
            
            FileOutputStream fos = new FileOutputStream(folder.getPath() + ".zip");
            ZipOutputStream zos = new ZipOutputStream(fos);
            zos.putNextEntry(new ZipEntry(folder.getName()));
            
            byte[] data = new byte[BUFFER_SIZE]; 
             
            byte[] bytes = Files.readAllBytes(Paths.get(folder.getPath()));
            zos.write(bytes,0,bytes.length);
            zos.closeEntry();
            zos.close();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
