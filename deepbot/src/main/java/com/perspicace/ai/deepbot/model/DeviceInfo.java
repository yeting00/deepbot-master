package com.perspicace.ai.deepbot.model;

import java.io.Serializable;

/**
*@author energy
*@version 1.0.0 创建时间：2017年12月26日
*说明
**/
public class DeviceInfo implements Serializable {
	public boolean hasFloor;
	public boolean hasPosition;
	public boolean hasDevice;
	public String  positionId;
	public String[]  deviceIds;
	public String[]  states;
	public String[] expands;
}
