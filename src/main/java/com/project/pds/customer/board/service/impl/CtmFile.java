package com.project.pds.customer.board.service.impl;

import com.project.pds.customer.board.vo.CtmVo;
import com.project.pds.user.service.impl.CheckFileName;
import com.project.pds.user.vo.FilesVo;
import com.project.user.vo.UserVo;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class CtmFile {
    public static void save(HashMap<String, Object> map, HttpServletRequest request) {
        String num = (String)map.get("customer_board_number");

        String filePath = "D:\\Project\\src\\main\\webapp\\WEB-INF\\resources\\img\\CtmBoard\\";
        filePath += num;
        filePath += "\\";
        File dir = new File(filePath);
        if (!dir.exists()){
            dir.mkdir();
        }

        CheckFileName checkFile = new CheckFileName();

        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;

        Iterator<String> iterator = multipartHttpServletRequest.getFileNames();

        MultipartFile multipartFile =  null;

        CtmVo vo = new CtmVo();

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

            vo = new CtmVo(num, fileName, fileExt, sFileName);

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
