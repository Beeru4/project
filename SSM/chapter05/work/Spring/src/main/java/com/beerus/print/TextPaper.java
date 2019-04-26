package com.beerus.print;

import com.beerus.ink.Paper;

/**
 * @Author Beerus
 * @Description
 * @Date 2019/4/23
 **/
public class TextPaper implements Paper {
    //每行的字符数
    private int charPerLine = 16;
    //每页行数
    private int linePerPage = 5;
    //纸张的内容
    private String context = "";
    //当前X轴位置
    private int posX;
    //Y轴行数
    private int posY;
    //当前页数
    private int posP;

    //提供每行的字符数 和 每页行数的setter方法 使用Spring注入

    public void setCharPerLine(int charPerLine) {
        this.charPerLine = charPerLine;
    }

    public void setLinePerPage(int linePerPage) {
        this.linePerPage = linePerPage;
    }

    public void inputChar(char c) {
        //内容追加
        this.context += c;
        //X轴位置++
        this.posX++;
        // 判断是否换行 当X轴位置 == 输入的字符数的适合换行
        if (this.posX == this.charPerLine) {
            //换行
            this.context += NEWLINE;
            //X轴归零
            this.posX = 0;
            //行数++
            this.posY++;
        }
        //判断是否翻页 当Y轴的位置 == 行数的适合进行下一页
        if (this.posY == this.linePerPage) {
            //拼接页码
            this.context += "== 第" + this.posP + "页 ==";
            //折行
            this.context += NEWLINE + NEWLINE;
            //行数归零
            this.posY = 0;
            //页码++
            this.posP++;
        }
    }

    public String getContext() {
        String contextN = this.context;
        //显示页码
        if ((this.posY != 0 && this.posP != 0)) {
            int count = this.linePerPage - this.posY;
            for (int i = 0; i < count; i++) {
                contextN += NEWLINE;
            }
            contextN += "== 第" + this.posP + "页 ==";
        }

        return contextN;
    }
}
