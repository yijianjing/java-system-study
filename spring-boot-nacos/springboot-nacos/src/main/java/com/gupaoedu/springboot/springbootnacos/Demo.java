package com.gupaoedu.springboot.springbootnacos;


public class Demo {
    //系统上线时间
    private final long startTime = 1608220800000L;

    //业务ID
    private long businessType;
    //机器ID
    private long workId;
    //序列号
    private long serialNum = 0L;

    //region 得到位移长度
    private final long serialNumBits = 10L;
    private final long workBits = 7L;
    private final long businessTypeBits = 5L;

    private final long workShift = serialNumBits;
    private final long businessTypeShift = workShift + workBits;
    private final long timestampShift = businessTypeShift + businessTypeBits;
    //endregion

    //上一次的执行时间
    private long lastTimeStamp = 0L;

    //serialNum能代表的最大值
    private final long serialNumMax = -1 ^ (-1L << serialNumBits);

    public Demo(long businessType, long workId) {

        // TODO:判断
        this.businessType = businessType;
        this.workId = workId;
    }

    public synchronized long getId() {
        long timeStamp = System.currentTimeMillis();
        //实现serialNum
        if (lastTimeStamp == timeStamp) {
            //同一毫秒，serialNum+1   如果超过了最大长度怎么办？等到下一毫秒去执行
            serialNum = (serialNum + 1) & serialNumMax;  //超过了最大值，并且把serialNum赋值为0
            if (serialNum == 0) {
                timeStamp = waitNextMillis(timeStamp);
            }

        } else {
            serialNum = timeStamp & 1;
        }
        lastTimeStamp = timeStamp;
        return ((timeStamp - startTime) << timestampShift)
                | (businessType << businessTypeShift)
                | (workId << workShift)
                | serialNum;
    }

    private long waitNextMillis(long timeStamp) {
        long nowTimeStamp = System.currentTimeMillis();
        while (timeStamp >= nowTimeStamp) {
            nowTimeStamp = System.currentTimeMillis();
        }
        return nowTimeStamp;
    }
}
