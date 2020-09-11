//package com.example.demo.commons;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.MultipartHttpServletRequest;
//
//import javax.servlet.http.HttpServletRequest;
//import java.io.BufferedOutputStream;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author: Martin
// * @Date: 2018/12/12
// * @Description:
// * @Modify By:
// */
//@Slf4j
//@Component
//public class FileUtil extends BaseService {
//
//    @Value("${saliai.targetFilePath}")
//    private String targetFile;
//    @Value("${saliai.accessPath}")
//    private String accessPath;
//    @Autowired
//    private ProductImagesMapper productImagesMapper;
//
//    /**
//     * 功能描述: 上传文件
//     *
//     * @param multipartFile
//     * @return java.util.List<com.saliai.lifebank_mall.common.model.UploadDto>
//     * @author Martin
//     * @date 2018/12/12
//     * @version V1.0
//     */
//    public List upload(MultipartFile multipartFile) {
//
//        log.info(" >>> 文件上传入口... <<< ");
//        List list = new ArrayList();
//        if (multipartFile == null) {
//            throw new CustomException(ResultEnum.OBJECT_IS_NULL.getCode(), ResultEnum.OBJECT_IS_NULL.getMessage());
//        }
//        UploadDto uploadDto = new UploadDto();
//        String fileName = "";
//        File filePath = new File(targetFile);
//        if (!filePath.mkdir()) {
//            filePath.mkdirs();
//        }
//        try {
//            byte[] bytes = multipartFile.getBytes();
//            //获取上传文件类型
//            String fileUrl = multipartFile.getOriginalFilename();
//            String fileType = fileUrl.substring(fileUrl.lastIndexOf(".")).toLowerCase();
//            uploadDto.setImgType("cover");
//            uploadDto.setImgSuffix(fileType);
//            //自定义上传文件的名字
//            fileName = System.currentTimeMillis() + StringUtil.getRandomNum(6) + fileType;
//            uploadDto.setImgName(fileName);
//            //截取文件格式
//            String type = fileUrl.substring(fileUrl.lastIndexOf(".") + 1).toLowerCase();
//            String destPath = filePath + File.separator + fileName;
//            //保存到一个目标文件中
//            multipartFile.transferTo(new File(destPath));
//            uploadDto.setRealPath(targetFile + "/" + fileName);
//            uploadDto.setHttpPath(accessPath + "/" + fileName);
//            list.add(uploadDto);
//            log.info(" >>> 文件上传结束... <<< ");
//        } catch (Exception e) {
//            e.printStackTrace();
//            log.error("You failed to upload " + " => " + e.getMessage());
//            throw new CustomException(ResultEnum.UPLOAD_FAIL.getCode(), ResultEnum.UPLOAD_FAIL.getMessage());
//        }
//        return list;
//    }
//
//    /**
//     * 功能描述:删除文件
//     *
//     * @param fileRealUrl
//     * @return boolean
//     * @author Martin
//     * @date 2018/12/12
//     * @version V1.0
//     */
//    public boolean removeFile(String fileRealUrl) {
//
//        boolean result = false;
//        File file = null;
//        if (!StringUtils.isEmpty(fileRealUrl)) {
//            file = new File(fileRealUrl);
//        } else {
//            result = false;
//        }
//        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
//        if (file.exists() && file.isFile()) {
//            if (!file.delete()) {
//                throw new CustomException(ResultEnum.DELETE_FAIl.getCode(), ResultEnum.DELETE_FAIl.getMessage());
//            }
//            result = true;
//        }
//        return result;
//    }
//
//    /**
//     * 批量上传文件
//     *
//     * @param request
//     * @return
//     */
//    public List<UploadDto> handleFileUpload(HttpServletRequest request) {
//        List<MultipartFile> files = ((MultipartHttpServletRequest) request)
//                .getFiles("file");
//        return this.uploadBatchFile(files);
//
//    }
//
//    /**
//     * 功能描述: 多文件上传
//     *
//     * @param multipartFileList
//     * @return java.util.List<com.saliai.lifebank_mall.common.model.UploadDto>
//     * @author Martin
//     * @date 2018/12/25
//     * @version V1.0
//     */
//    public List<UploadDto> uploadBatchFile(List<MultipartFile> multipartFileList) {
//        log.info(" >>> 文件上传入口... <<< ");
//        List<UploadDto> list = new ArrayList<>();
//        if (multipartFileList == null || multipartFileList.size() < 1) {
//            throw new CustomException(ResultEnum.OBJECT_IS_NULL.getCode(), ResultEnum.OBJECT_IS_NULL.getMessage());
//        }
//        String fileName = "";
//        File filePath = new File(targetFile);
//        if (!filePath.mkdir()) {
//            filePath.mkdirs();
//        }
//        try {
//            for(){
//                () -> fileName.jsjllkjflf;lksdkfls;ksflkkm;
//                sjjfjsdljfl/lofjljf;sal/kjfkljkl;
//            }
//            for (MultipartFile multipartFile : multipartFileList) {
//                UploadDto uploadDto = new UploadDto();
//                multipartFile.getByte
//                byte[] bytes = multipartFile.getBytes();
//                //获取上传文件类型
//                String fileUrl = multipartFile.getOriginalFilename();
//                String fileType = fileUrl.substring(fileUrl.lastIndexOf(".")).toLowerCase();
//                uploadDto.setImgType("detail");
//                uploadDto.setImgSuffix(fileType);
//                //自定义上传文件的名字
//                fileName = System.currentTimeMillis() + StringUtil.getRandomNum(6) + fileType;
//                uploadDto.setImgName(fileName);
//                //截取文件格式
//                String type = fileUrl.substring(fileUrl.lastIndexOf(".") + 1).toLowerCase();
//                String destPath = filePath + File.separator + fileName;
//                //保存到一个目标文件中
//                multipartFile.transferTo(new File(destPath));
//                uploadDto.setRealPath(targetFile + "/" + fileName);
//                uploadDto.setHttpPath(accessPath + "/" + fileName);
//                list.add(uploadDto);
//            }
//            log.info(" >>> 文件上传结束... <<< ");
//            () -> log
//        } catch (Exception e) {
//            e.printStackTrace();
//            log.error("You failed to upload " + " => " + e.getMessage());
//            throw new CustomException(ResultEnum.UPLOAD_FAIL.getCode(), ResultEnum.UPLOAD_FAIL.getMessage());
//        }
//        return list;
//    }
//
//    public ResponseVo deleteFile(String path) {
//        File file = new File(path);
//        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
//        if (file.exists() && file.isFile()) {
//            if (!file.delete()) {
//                return new ResponseVo(3001, "删除文件失败");
//            } else {
//                return new ResponseVo(200, "删除文件成功");
//            }
//        } else {
//            return new ResponseVo(3008, "文件不存在");
//        }
//    }
//}