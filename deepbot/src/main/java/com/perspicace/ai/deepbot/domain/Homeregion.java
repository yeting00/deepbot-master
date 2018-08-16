package com.perspicace.ai.deepbot.domain;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

@NodeEntity(label = "HomeRegion")
public class Homeregion {
    @Id
    @GeneratedValue
    private Long id;
    private long sqlID;
    private String name;
    private String enName;
    private String key;
    private String nick_name;


    @Relationship(type = "HOME_DEVICE", direction = Relationship.OUTGOING)
    private Set<Light> lights = new HashSet<Light>();
    @Relationship(type = "HOME_DEVICE", direction = Relationship.OUTGOING)
    private Set<Curtain> curtains = new HashSet<Curtain>();
    @Relationship(type = "HOME_DEVICE", direction = Relationship.OUTGOING)
    private Set<Television> televisions = new HashSet<Television>();
    @Relationship(type = "HOME_DEVICE", direction = Relationship.OUTGOING)
    private Set<AirConditioner> airConditioners = new HashSet<AirConditioner>();
    @Relationship(type = "HOME_DEVICE", direction = Relationship.OUTGOING)
    private Set<LoudspeakerBox> loudspeakerBoxes = new HashSet<LoudspeakerBox>();

    @Relationship(type = "HOME_SENSOR", direction = Relationship.OUTGOING)
    private Set<Sensor> sensors = new HashSet<Sensor>();

    @Relationship(type = "WIFI_SENSOR", direction = Relationship.OUTGOING)
    private Wifi wifi;


    @Relationship(type = "SHD_DEVICE", direction = Relationship.OUTGOING)
    private  Set<SHD> shds = new HashSet<SHD>();

    //居住在这个房间或区域的人
    @Relationship(type = "LIVE_IN", direction = Relationship.OUTGOING)
    private Set<Person> persons = new HashSet<Person>();


    public void addSHD(SHD shd)
    {
        shds.add(shd);
    }

    public void addLights(Light light){
        lights.add(light);
    }

    public void addCurtains(Curtain curtain){
        curtains.add(curtain);
    }

    public void addPersons(Person person)
    {
        persons.add(person);
    }

    public void addTelevisions(Television television){
        televisions.add(television);
    }

    public void addAirconditioners(AirConditioner airConditioner){
        airConditioners.add(airConditioner);
    }

    public void addLoudspeakerBoxes(LoudspeakerBox loudspeakerBox){
        loudspeakerBoxes.add(loudspeakerBox);
    }

    public void addSensor(Sensor sensor)
    {
        sensors.add(sensor);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Light> getLights() {
        return lights;
    }

    public void setLights(Set<Light> lights) {
        this.lights = lights;
    }

    public Set<Curtain> getCurtains() {
        return curtains;
    }

    public void setCurtains(Set<Curtain> curtains) {
        this.curtains = curtains;
    }

    public Set<Television> getTelevisions() {
        return televisions;
    }

    public void setTelevisions(Set<Television> televisions) {
        this.televisions = televisions;
    }

    public Set<AirConditioner> getAirConditioners() {
        return airConditioners;
    }

    public void setAirConditioners(Set<AirConditioner> airConditioners) {
        this.airConditioners = airConditioners;
    }

    public Set<LoudspeakerBox> getLoudspeakerBoxes() {
        return loudspeakerBoxes;
    }

    public void setLoudspeakerBoxes(Set<LoudspeakerBox> loudspeakerBoxes) {
        this.loudspeakerBoxes = loudspeakerBoxes;
    }

    public Set<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(Set<Sensor> sensors) {
        this.sensors = sensors;
    }

    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }

    public Wifi getWifi() {
        return wifi;
    }

    public void setWifi(Wifi wifi) {
        this.wifi = wifi;
    }

    public Set<SHD> getShds() {
        return shds;
    }

    public void setShds(Set<SHD> shds) {
        this.shds = shds;
    }
}
