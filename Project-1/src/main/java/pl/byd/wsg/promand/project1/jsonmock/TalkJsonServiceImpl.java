package pl.byd.wsg.promand.project1.jsonmock;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.Date;

import pl.byd.wsg.promand.project1.domain.entity.Talk;
import pl.byd.wsg.promand.project1.domain.list.TalkList;
import pl.byd.wsg.promand.project1.utils.DateUtils;

public class TalkJsonServiceImpl implements TalkJsonService {

    private TalkList talkList = new TalkList();

    public TalkJsonServiceImpl() {
        talkList.add(new Talk(1, "How to be hot",
                "You will get some advices for how to be hot",
                DateUtils.createDate(2014, 12, 31, 00, 00),
                DateUtils.createDate(2015, 1, 1, 20, 00),
                Arrays.asList(1L, 2L),
                Arrays.asList(1L, 5L)
                ));
        talkList.add(new Talk(2, "Java EE 7",
                "Main features of java 7",
                DateUtils.createDate(2013, 10, 2, 18, 30),
                DateUtils.createDate(2013, 10, 2, 20, 10),
                Arrays.asList(1L, 2L),
                Arrays.asList(1L, 5L)
        ));
        talkList.add(new Talk(2, "PHP Yii",
                "How to be hot in Yii",
                DateUtils.createDate(2014, 9, 20, 17, 45),
                DateUtils.createDate(2014, 9, 20, 21, 00),
                Arrays.asList(1L, 2L),
                Arrays.asList(1L, 5L)
        ));
    }

    @Override
    public String getTalkList() {
        return new Gson().toJson(talkList);
    }
}
