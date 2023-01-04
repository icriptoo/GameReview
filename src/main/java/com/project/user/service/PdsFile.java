package com.project.user.service;

import com.project.user.vo.FilesVo;
import com.project.user.vo.UserVo;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;

public class PdsFile {
    public static void save(HashMap<String, Object> map, HttpServletRequest request, HttpSession httpSession) throws IOException {
        UserVo userVo = (UserVo) httpSession.getAttribute("login");


        String userid = userVo.getU_id();

        String filePath = "C:\\GameReview\\src\\main\\webapp\\WEB-INF\\resources\\img\\userProfile\\";
        String deletePath = "C:\\GameReview\\src\\main\\webapp\\WEB-INF\\resources\\img\\userProfile\\";

        filePath += userid;
        deletePath += userid;
        filePath += "\\";

        // 유저프로필 경로에 이전 프로필 파일 삭제
        File del = new File(deletePath);
        try {
            while (del.isDirectory()){
                File[] delList = del.listFiles();

                for (int i = 0; i < delList.length; i++){
                    delList[i].delete();
                }
//                폴더도 삭제 하는 명령어
                if (delList.length == 0 && del.isDirectory()){
                    del.delete();
                }
            }
        } catch (Exception e) {
            e.getStackTrace();
        }


        Files.deleteIfExists(Paths.get(deletePath));

        File dir = new File(filePath);
        if (!dir.exists()){
            dir.mkdir();
        }
        CheckFileName checkFile = new CheckFileName();

        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
        Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
        FilesVo vo = new FilesVo();
        MultipartFile  multipartFile =  null;
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
            vo = new FilesVo(userid, fileName, fileExt, sFileName);
            File file = new File(filePath, sFileName);
            try{
                multipartFile.transferTo(file);
            }catch (IllegalStateException e){
                e.printStackTrace();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
        map.put("vo", vo);
    }
}
