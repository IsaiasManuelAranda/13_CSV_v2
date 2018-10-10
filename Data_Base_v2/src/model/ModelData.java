
package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class ModelData {
    private String name;
    private String email;
    private String result;
    private String path = "C:\\Users\\VICTOR MANUEL ARANDA\\Documents\\archivos\\DataBase.csv";
    private String message;
    private final List data = new ArrayList<>();
    private int i;
    private int tam;
    
    /**
    *Obtiene el resultado de
    *el nombre más el email separado por coma.
    *@regresa la cadena de texto
    */
    public String getResult() {
        return result;
    }
    /**
    *Modifica el resultado de
    *el nombre más el email separado por coma.
    *@regresa la cadena de texto
    */
    public void setResult(String result) {
        this.result = result;
    }
    /**
     * Obtiene el path asignado
     * @return the path
     */
    public String getPath() {
        return path;
    }
    /**
     * Modifica el path
     * @param path of the file
     */
    public void setPath(String path) {
        this.path = path;
    }
    /**
     * Get the message from the file
     * @return all the message
     */
    public String getMessage() {
        return message;
    }
    /**
     * Set the message of the file
     * @param message complete.
     */
    public void setMessage(String message) {
        this.message = message;
    }
    /**
     * Get the name
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * Set the name with the text of the textfile
     * @param name like new value
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Get the email
     * @return the email
     */
    public String getEmail() {
        return email;
    }
    /**
     * Set the value of email
     * @param email like new value
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Make the String "name,email"
     * @return the String completed
     */
    public String resultCSV(){
        this.result = this.name + "," + this.email;
        return result;
    }
    /**
     * Método para leer el archivo de la ruta especificada
     * 
     */
    public void read(){
        readFile(path);
    }
    /**
     * Lee el archivo de la ruta especificada
     * @param path que es la ruta del archivo
     */
    private void readFile(String path){
        try {
            data.clear();
            tam = 0;
            String row;
            FileReader file = new FileReader(path);
            try (BufferedReader bufferedReader = new BufferedReader(file)) {
                while ((row = bufferedReader.readLine()) != null) {
                    data.add(row);
                    tam++;
                }
            }
        } catch (FileNotFoundException err) {
            System.err.println("File not found: " + err.getMessage());
        } catch (IOException err) {
            System.err.println("Error on I/O operation:  " + err.getMessage());
        } catch (NullPointerException err) {
            System.err.println("NullPointer:  " + err.getMessage());
        }
    }
    /**
     * Abre o crea el archivo de la ruta especificada
     * @param path que es la ubicación del archivo
     * @param message las columnas que estará imprimiendo
     */
    public void writeFile(String path, String message){
        try{
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file, true);
            try (PrintWriter printWriter = new PrintWriter(fileWriter)){
                printWriter.println(message);
                printWriter.flush();
                printWriter.close();
            }
        }catch(FileNotFoundException err){
            JOptionPane.showMessageDialog(null, "File not found: " + err.getMessage());
        }catch(IOException err){
            JOptionPane.showMessageDialog(null, "Fallo de entrada o salida: " + err.getMessage());
        }
    }
    /**
     * Separa la cadena previamente creada y guarda cada dato en una variable
     * @param i posicion
     */
    private void getData(int i) {
        String row[];
        row = String.valueOf(data.get(i)).split(",");
        name = row[0];
        email = row[1];
    }
    /**
     * Establece la posicion del registro en 0 y llama al metodo getData
     * para separar los valores de nombre y email.
     */
    public void moveHead() {
        i = 0;
        getData(i);
    }
     /**
     * Incrementa en 1 la posicion del registro y llama al metodo getData
     * para separar los valores de nombre y email.
     */
    public void moveNext(){
        if(i+1<tam)
            i++;
        getData(i);
    }
    
    /**
     * Decrementa en 1 la posicion del registro y llama al metodo getData
     * para separar los valores de nombre y email.
     */
    public void movePrevious() {
        if (i > 0) 
            i--;
        getData(i);
    }

    /**
     * Establece  la posicion del registro en 1 antes del tamaño de la lista,
     * y llama al metodo getData para separar los valores de nombre y email.
     */
    public void moveTail() {
        i = tam - 1;
        getData(i);
    }
}
