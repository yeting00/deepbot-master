package deepbot;

import com.perspicace.ai.deepbot.service.DistributionService;
import com.perspicace.modules.Perception.PerceptionTxt.Source;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: deepbot
 * @description: 测试控制分发中心
 * @author: Destiny
 * @create: 2018-06-28 20:33
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DistributionTests {
    @Autowired
    private DistributionService distributionService;

    @Test
    public void testPerceptionService(){
//        for(int i =0;i<5;i++) {
            String text = "我回家了" ;//明日の東京の天気   テレビをつける（打开电视）  寝室のエアコンをつけます（打开卧室空调） 电视上一个频道 电视声音大一点  关闭玄关电视  打开玄关电视  玄关电视音量大一点  玄关空调温度高一点 打开客厅的中央空调
            String deviceId = "B44BD6630D56";
            String sn = "000822B0BDFB";
            String account = "test002";
            String groupId = "大家庭";//9
            String talkId = "talk1001";
            String wakeLogId = "wakelogid1001";
            Source source = Source.SmartHomeCall;
            String attachParam = "";
            String responseSn = "28EDE01FE71B";
            String perceptionText = distributionService.getPerceptionText ( text , account , groupId , source );
//        }
    }
}
