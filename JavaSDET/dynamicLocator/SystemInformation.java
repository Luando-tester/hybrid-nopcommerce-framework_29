package dynamicLocator;

import java.io.File;

public class SystemInformation {
    public static void main(String[] args){
        String osName = System.getProperty("os.name");
        System.out.println(osName);

        String projectPath =  System.getProperty("user.dir");
        System.out.println(projectPath);

        String sepator = System.getProperty("file.separator");
        System.out.println(sepator);

        String danangImagePath = projectPath + File.separator +  "uploadFiles"+ File.separator + "DaNang.jpg";
        System.out.println(danangImagePath);
        System.out.println(danangImagePath.trim());



    }
}
