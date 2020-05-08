package ro.siit;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class AppTest {

    @Test
    public void copyWebapp(){
        Path source = Paths.get("target" + File.separator + "webapp.war");
        Path destination = Paths.get("C:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\webapp.war");

        try{
            Files.copy(source,destination, StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public void copyWebappLocal(){
        Path source = Paths.get("target" + File.separator + "webapp.war");
        Path destination = Paths.get("target" + File.separator + "webapplocal.war");
       // Path destination = Paths.get("C:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps");

        try{
            Files.copy(source,destination);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
