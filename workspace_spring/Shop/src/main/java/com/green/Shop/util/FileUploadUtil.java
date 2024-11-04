package com.green.Shop.util;

import com.green.Shop.item.vo.ImgVO;
import com.green.Shop.item.vo.ItemVO;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

//첨부파일과 관련된 기능
public class FileUploadUtil {

    //파일 업로드
    public static ImgVO fileUpload(MultipartFile uploadFile){

        //원본파일명 및 첨부된 파일명을 저장한기위한 객체
        ImgVO imgVO = null;

        //input 태그에 파일을  선택했을때만 첨부기능 실행.
        if (!uploadFile.isEmpty()){

            //imgVO 객체 생성
            imgVO = new ImgVO();

            // 업로드 될 경로
            String uploadPath = "D:\\01-STUDY\\dev\\workspace\\workspace_spring\\Shop\\src\\main\\resources\\static\\upload\\";

            //첨부될 파일명 _ 내가 선택한 원본 파일명
            String originFileName = uploadFile.getOriginalFilename(); // <- 내가 선택한 파일의 원본 파일명

            //첨부될 파일명을 랜덤하게 생성
            String uuid = UUID.randomUUID().toString();

            //원본 파일에서 확장자만 추출
            int dotIndex = originFileName.lastIndexOf(".");
            String extension = originFileName.substring(dotIndex);

            //첨부될 파일명
            String attachedFileName = uuid + extension;

            //첨부될 파일생성
            File file = new File(uploadPath + attachedFileName);
            // FileUploadUtil.fileUpload(); // 객체 만들지않고 실행하는?

            //첨부기능실행
            try {
                uploadFile.transferTo((file));

                //첨부된 파일 정보를 imgVO에 저장
                imgVO.setOriginFileName(originFileName);
                imgVO.setAttachedFileName(attachedFileName);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        return imgVO;
    }

}
