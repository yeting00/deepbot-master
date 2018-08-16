package deepbot;


import com.perspicace.ai.deepbot.domain.*;
import com.perspicace.ai.deepbot.neo4j.repository.HouseRepository;
import com.perspicace.ai.deepbot.neo4j.repository.SHDRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
//@Transactional
@Slf4j
public class Neo4jTests {
    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    private SHDRepository shdRepository;

    @Before
    public void setUp() {
        House house = new House();
        house.setName("15楼样板间");
        house.setCity("上海");
        house.setDistrict("长宁区");
        house.setFloor(15);
        house.setSize(120);
        house.setCreate(new Date());
        house.setFloorNum(1);

        Person yewei = new Person();

        house.addFamilyMember(yewei);

        Floor floor_1 = new Floor();
        floor_1.setName("1楼");
        floor_1.setSize(128);

        Floor floor_2 = new Floor();
        floor_2.setName("2楼");
        floor_2.setSize(120);

        Wifi bedroom_wifi = new Wifi();
        bedroom_wifi.setName("WIFI智能感知");
        bedroom_wifi.setIsFall(0);
        bedroom_wifi.setIsNobody(0);

        Wifi livingroom_wifi = new Wifi();
        livingroom_wifi.setName("WIFI智能感知");
        livingroom_wifi.setIsFall(0);
        livingroom_wifi.setIsNobody(0);

        Homeregion entrance = new Homeregion();
        entrance.setName("玄关");

        Homeregion livingromm = new Homeregion();
        livingromm.setName("客厅");
        livingromm.setWifi(livingroom_wifi);

        Homeregion kitcheen = new Homeregion();
        kitcheen.setName("厨房");

        Homeregion diningroom = new Homeregion();
        diningroom.setName("餐厅");

        Homeregion washroom = new Homeregion();
        washroom.setName("卫生间");

        Homeregion bedroom = new Homeregion();
        bedroom.setName("卧室");
        bedroom.setWifi(bedroom_wifi);

        SHD livingroom_shd = new SHD();
        livingroom_shd.setName("SHD");
        livingroom_shd.setDevID("客厅3");
        livingroom_shd.setHouseName("15楼样板间");

        SHD entrance_shd = new SHD();
        entrance_shd.setName("SHD");
        entrance_shd.setDevID("玄关1");
        entrance_shd.setHouseName("15楼样板间");

        SHD kitcheen_shd = new SHD();
        kitcheen_shd.setName("SHD");
        kitcheen_shd.setDevID("短投4");
        kitcheen_shd.setHouseName("15楼样板间");

        SHD bedroom_shd = new SHD();
        bedroom_shd.setName("SHD");
        bedroom_shd.setDevID("卧室2");
        bedroom_shd.setHouseName("15楼样板间");

        AirConditioner airConditioner = new AirConditioner();
        airConditioner.setName("空调");
        airConditioner.setCompany("奥克斯");
        airConditioner.setState("制冷");
        airConditioner.addListValue(26);
        airConditioner.setDevID("000001A");

        Television television = new Television();
        television.setName("电视");
        television.setCompany("乐视");
        television.addVolume(35);
        television.addChannel("新闻频道");
        television.setDevID("000001T");

        Curtain livingroom_curtain = new Curtain();
        livingroom_curtain.setName("客厅窗帘");
        livingroom_curtain.setCompany("鸿雁");
        livingroom_curtain.setDevID("000001C");

        Curtain bedroom_curtain = new Curtain();
        bedroom_curtain.setName("卧室窗帘");
        bedroom_curtain.setCompany("鸿雁");
        bedroom_curtain.setDevID("000002C");

        Light livingroom_light = new Light();
        livingroom_light.setName("灯");
        livingroom_light.setCompany("飞利浦");
        livingroom_light.setDevID("00001L");

        Light bedroom_light = new Light();
        bedroom_light.setName("灯");
        bedroom_light.setCompany("飞利浦");
        bedroom_light.setDevID("00002L");

        Light kitcheen_light = new Light();
        kitcheen_light.setName("灯");
        kitcheen_light.setCompany("飞利浦");
        kitcheen_light.setDevID("00003L");

        Light entrance_light = new Light();
        entrance_light.setName("灯");
        entrance_light.setCompany("飞利浦");
        entrance_light.setDevID("00004L");

        Light washroom_light = new Light();
        washroom_light.setName("灯");
        washroom_light.setCompany("飞利浦");
        washroom_light.setDevID("00005L");

        Light diningroom_light = new Light();
        diningroom_light.setName("灯");
        diningroom_light.setCompany("飞利浦");
        diningroom_light.setDevID("000006L");

        Light livingroom_ceiling = new Light();
        livingroom_ceiling.setName("吊灯");
        livingroom_ceiling.setCompany("飞利浦");
        livingroom_ceiling.setDevID("000007L");

        Light livingroom_spotlight = new Light();
        livingroom_spotlight.setName("射灯");
        livingroom_spotlight.setCompany("飞利浦");
        livingroom_spotlight.setDevID("000008L");

        Light livingroom_downlight = new Light();
        livingroom_downlight.setName("落地灯");
        livingroom_downlight.setCompany("飞利浦");
        livingroom_downlight.setDevID("000009L");

        Sensor livingroom_temperature_sensor = new Sensor();
        livingroom_temperature_sensor.setName("温度传感器");
        livingroom_temperature_sensor.setDevID("000001Tem");

        Sensor livingroom_luminance_sensor = new Sensor();
        livingroom_luminance_sensor.setName("亮度传感器");
        livingroom_luminance_sensor.setDevID("000002Lia");

        Sensor kitcheen_temperature_sensor = new Sensor();
        kitcheen_temperature_sensor.setName("温度传感器");
        kitcheen_temperature_sensor.setDevID("000002Tem");

        Sensor bedroom_luminance_sensor = new Sensor();
        bedroom_luminance_sensor.setName("亮度传感器");
        bedroom_luminance_sensor.setDevID("000001Lia");

        Sensor bedroom_temperature_sensor = new Sensor();
        bedroom_temperature_sensor.setName("温度传感器");
        bedroom_temperature_sensor.setDevID("000003Tem");

        house.addFloor(floor_1);
        house.addFloor(floor_2);
        house.addFamilyMember(yewei);

        floor_1.addHomeRegion(entrance);
        floor_1.addHomeRegion(livingromm);
        floor_1.addHomeRegion(bedroom);
        floor_1.addHomeRegion(kitcheen);
        floor_1.addHomeRegion(diningroom);
        floor_1.addHomeRegion(washroom);


        livingromm.addTelevisions(television);
        livingromm.addLights(livingroom_ceiling);
        livingromm.addLights(livingroom_light);
        livingromm.addLights(livingroom_spotlight);
        livingromm.addLights(livingroom_downlight);
        livingromm.addCurtains(livingroom_curtain);
        livingromm.addAirconditioners(airConditioner);
        livingromm.addSensor(livingroom_temperature_sensor);
        livingromm.addSensor(livingroom_luminance_sensor);
        livingromm.addSHD(livingroom_shd);

        bedroom.addPersons(yewei);
        bedroom.addCurtains(bedroom_curtain);
        bedroom.addLights(bedroom_light);
        bedroom.addSensor(bedroom_temperature_sensor);
        bedroom.addSensor(bedroom_luminance_sensor);
        bedroom.addSHD(bedroom_shd);

        washroom.addLights(washroom_light);

        diningroom.addLights(diningroom_light);

        kitcheen.addLights(kitcheen_light);
        kitcheen.addSHD(kitcheen_shd);

        entrance.addLights(entrance_light);
        entrance.addSHD(entrance_shd);

        houseRepository.save(house);
    }

    @Test
    public void getSHD() {
//        Homeregion homeregion = homeregionRepository.findByName("客厅");
        SHD shd = shdRepository.findSHDByDevID("客厅3");

        String house_name = shd.getHouseName();

        String name = shd.getName();
        log.info("\n===============SHD name={}" + name);
    }

    /**
     * Test of findByTitle method, of class MovieRepository.
     */
//	@Test
//	public void testFindByTitle() {
//
//		String title = "The Matrix";
//		Movie result = movieRepository.findByTitle(title);
//		assertNotNull(result);
//		assertEquals(1999, result.getReleased());
//	}

    /**
     * Test of findByTitleContaining method, of class MovieRepository.
     */
//	@Test
//	public void testFindByTitleContaining() {
//		String title = "*Matrix*";
//		Collection<Movie> result = movieRepository.findByTitleLike(title);
//		assertNotNull(result);
//		assertEquals(1, result.size());
//	}

    /**
     * Test of graph method, of class MovieRepository.
     */
//	@Test
//	public void testGraph() {
//		Collection<Movie> graph = movieRepository.graph(5);
//
//		assertEquals(1, graph.size());
//
//		Movie movie = graph.iterator().next();
//
//		assertEquals(1, movie.getRoles().size());
//
//		assertEquals("The Matrix", movie.getTitle());
//		assertEquals("Keanu Reeves", movie.getRoles().iterator().next().getPerson().getName());
//	}
}