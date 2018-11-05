package com.questionnaire.ssm.module.resultAnalysis.pojo;

/**
 * Created by 郑晓辉 on 2017/7/22.
 * Description: 结果文本导出数据库实体类
 */
public class AnswerTxtExportDO {
    //问题ID
    private Long questionId;
    //问题内容
    private String questionContext;
    //问题在试卷中的位置
    private Integer questionOrder;
    //答卷编号
    private Long answerPaperId;
    //答案内容
    private String answerStr;


    @Override
    public String toString() {
        return "AnswerTxtExportDO{" +
                "questionId=" + questionId +
                ", questionContext=" + questionContext+
                ", questionOrder='" + questionOrder + '\'' +
                ", answerPaperId=" + answerPaperId +
                ", answerStr='" + answerStr + '\'' +
                '}';
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getQuestionContext() {
        return questionContext;
    }

    public void setQuestionContext(String questionContext) {
        this.questionContext = questionContext;
    }

    public Integer getQuestionOrder() { return questionOrder;}

    public void setQuestionOrder() { this.questionOrder = questionOrder;}


    public Long getAnswerPaperId() {
        return answerPaperId;
    }

    public void setAnswerPaperId(Long answerPaperId) {
        this.answerPaperId = answerPaperId;
    }

    public String getAnswerStr() {
        return answerStr;
    }

    public void setAnswerStr(String answerStr) {
        this.answerStr = answerStr;
    }
}
