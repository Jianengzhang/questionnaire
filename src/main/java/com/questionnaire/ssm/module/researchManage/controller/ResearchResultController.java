package com.questionnaire.ssm.module.researchManage.controller;

import com.questionnaire.ssm.module.global.constant.CONSTANT;
import com.questionnaire.ssm.module.global.pojo.ResponsePkt;
import com.questionnaire.ssm.module.global.util.CheckPicUtil;
import com.questionnaire.ssm.module.global.util.ResultUtil;
import com.questionnaire.ssm.module.global.util.UserValidationUtil;
import com.questionnaire.ssm.module.researchManage.pojo.AnswerPaperVO;
import com.questionnaire.ssm.module.researchManage.service.ResearchResultService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

/**
 * Created by 郑晓辉 on 2017/5/1.
 * Description: 调查结果控制器
 */
@Controller
@RequestMapping(value = "/researchResult")
public class ResearchResultController {

    /**
     * 上传答卷
     *
     * @param answerPaperVOList Json格式的AnswerPaper  List
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/submitAnswerPaper")
    @ResponseBody
    public ResponsePkt submitAnswerPaper(@RequestBody List<AnswerPaperVO> answerPaperVOList) throws Exception {
        String userTel = UserValidationUtil.getUserTel(logger);
        if (answerPaperVOList.size() <= 0) {
            return ResultUtil.success(0);
        }
        return ResultUtil.success(researchResultService.multiSubmitAnswerPaper(userTel, answerPaperVOList));
    }


    /**
     * 上传答卷中的视频
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/submitAnswerMultiMedia")
    public ResponsePkt postMediaAndReturnPath(HttpServletRequest request) throws Exception {
        String userTel = UserValidationUtil.getUserTel(logger);
        MultipartHttpServletRequest multiFileRequest = (MultipartHttpServletRequest) request;
        List<MultipartFile> files = multiFileRequest.getFiles("file");

        String fileName = null, savePath = null, mediaRelativePath = null, todayDateStr = null;
        for (MultipartFile multipartFile : files) {
            fileName = multipartFile.getOriginalFilename();
            if (!CheckPicUtil.isPictureType(fileName, multipartFile.getContentType())) {
                return ResultUtil.badRequest();
            }
            //新建一个文件夹
            todayDateStr = CheckPicUtil.getTodayFolder();
            File picFolder = new File(CONSTANT.UPLOAD_MULTIMEDIA_ANSWER + "\\" + userTel + "\\" + todayDateStr);
            if (!picFolder.exists()) {
                picFolder.mkdirs();
            }
            mediaRelativePath = userTel + "\\" + todayDateStr + "\\" + CheckPicUtil.getPicType(fileName);
            File savingMedia = new File(CONSTANT.UPLOAD_MULTIMEDIA_ANSWER + "\\" + mediaRelativePath);
            multipartFile.transferTo(savingMedia);
        }

        return ResultUtil.success(mediaRelativePath);
    }


    private final static Logger logger = LoggerFactory.getLogger(ResearchResultController.class);
    private ResearchResultService researchResultService;

    @Autowired
    public ResearchResultController(ResearchResultService researchResultService) {
        this.researchResultService = researchResultService;
    }
}
