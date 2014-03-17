package pl.byd.wsg.promand.project1.dao;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import pl.byd.wsg.promand.project1.domain.entity.Talk;
import pl.byd.wsg.promand.project1.utils.DateUtils;

public class PersonalScheduleDao {

    private static PersonalScheduleDao personalScheduleDao = new PersonalScheduleDao();
    private List<Talk> personalTalkList =  new ArrayList<Talk>();

    private PersonalScheduleDao() {
        add(new Talk(2, "PHP Yii",
                "How to be hot in Yii",
                DateUtils.createDate(2014, 9, 20, 17, 45),
                DateUtils.createDate(2014, 9, 20, 21, 00),
                Arrays.asList(1L, 2L),
                Arrays.asList(1L, 5L)
        ));
    }

    public static PersonalScheduleDao getInstance(){
        return personalScheduleDao;
    }

    public void add(Talk talk){
        personalTalkList.add(talk);
    }

    public List<Talk> getPersonalTalkList() {
        return personalTalkList;
    }
}
