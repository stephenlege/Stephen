/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.bean;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;
import jdk.nashorn.internal.ir.annotations.Ignore;

/**
 *
 * @author LEGE
 */
@Named(value = "fileUploadBean")
@SessionScoped
public class FileUploadBean implements Serializable {

    private boolean isSuccess = true;
    private String msg = "";
    private Part uploadedFile;

    public boolean isIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Part getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(Part uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

    /**
     * Creates a new instance of NewJSFManagedBean
     */
    public FileUploadBean() {
    }

    public void saveFile() throws IOException {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();

        Path path = Paths.get(((ServletContext) externalContext.getContext())
                .getRealPath("/resources/uploadedFiles"));
        String s = path.toString();
        try (InputStream input = uploadedFile.getInputStream()) {

           
            
            Path saveTo = Paths.get(uploadedFile.getSubmittedFileName());
            String fileName = saveTo.getFileName().toString();
            

            System.out.println(fileName);
            Files.copy(input, new File(s, fileName).toPath()); //"fileUpload.txt"
            msg = "sucess in saving file";

        }
//        catch(IOException e){
//            isSuccess = false;
//            msg = e.toString();
//            e.printStackTrace();
//            System.out.println("=-----------------------=failure to save " + e);
//            
//        }
    }

}
