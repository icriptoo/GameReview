package com.project.user.service;

import java.io.File;

public class CheckFileName {

    public String getCheckFileName(String filePath, String orgFileName, String fileExt){
        boolean isCheck = true;
        String returnFileName = null;

        String fullFilepath = null;
        File file = null;

        String fileName = orgFileName;

        int i = 0;
        while(isCheck){
            fullFilepath = filePath + fileName + fileExt;
            file = new File(fullFilepath);

            if (file.exists()){
                i+=1;
                fileName = String.format("%s_%d", orgFileName, i);
            } else{
                isCheck = false;
            }
        }
        returnFileName = fileName + fileExt;

        return returnFileName;

    }
}
