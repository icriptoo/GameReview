package com.project.pds.rider.reply.service.impl;

import com.project.pds.rider.reply.vo.RRFilesVo;
import com.project.pds.user.service.impl.CheckFileName;
import com.project.pds.user.vo.FilesVo;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class RRPdsFile {
    public static void save(HashMap<String, Object> map, HttpServletRequest request ) {
        String rrn = (String) map.get("rider_reply_number");

        String filePath = "D:\\Project\\src\\main\\webapp\\WEB-INF\\resources\\img\\rider\\reply\\";
        filePath += rrn;
        filePath += "\\";
        File dir = new File(filePath);
        if (!dir.exists()){
            dir.mkdir();
        }

        CheckFileName checkFile = new CheckFileName();
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;

        Iterator<String> iterator = multipartHttpServletRequest.getFileNames();


        MultipartFile multipartFile =  null;

        RRFilesVo vo = new RRFilesVo();

        String         fileName     = null;
        String         orgFileName  = null;
        String         fileExt      = null;
        String         sFileName    = null;

        multipartFile = multipartHttpServletRequest.getFile(iterator.next());

        if(!multipartFile.isEmpty()){
            fileName = multipartFile.getOriginalFilename();
            orgFileName = fileName.substring(0, fileName.lastIndexOf('.'));
            fileExt = fileName.substring(fileName.lastIndexOf('.'));

            sFileName = checkFile.getCheckFileName(filePath, orgFileName, fileExt);

            vo = new RRFilesVo(rrn, fileName, fileExt, sFileName);

            File file = new File(filePath, sFileName);

            try{
                multipartFile.transferTo(file);
            }catch (IllegalStateException e){
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        map.put("vo", vo);


    }
}
