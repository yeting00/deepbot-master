//package com.perspicace.ai.deepbot.utils;
//
//import com.perspicace.constant.Global;
//import com.perspicace.gen.app.slice.AppServicePrx;
//import com.perspicace.gen.app.slice.AppServicePrxHelper;
//import com.perspicace.gen.cms.slice.CmsServicePrx;
//import com.perspicace.gen.cms.slice.CmsServicePrxHelper;
//import com.perspicace.gen.community.slice.CommunityServicePrx;
//import com.perspicace.gen.community.slice.CommunityServicePrxHelper;
//import com.perspicace.gen.construction.slice.ConstructionServicePrx;
//import com.perspicace.gen.construction.slice.ConstructionServicePrxHelper;
//import com.perspicace.gen.contact.slice.ContactServicePrx;
//import com.perspicace.gen.contact.slice.ContactServicePrxHelper;
//import com.perspicace.gen.device.slice.DeviceServicePrx;
//import com.perspicace.gen.device.slice.DeviceServicePrxHelper;
//import com.perspicace.gen.doorlock.slice.DoorlockServicePrx;
//import com.perspicace.gen.doorlock.slice.DoorlockServicePrxHelper;
//import com.perspicace.gen.electricappliance.slice.ElectricApplianceControlServicePrx;
//import com.perspicace.gen.electricappliance.slice.ElectricApplianceControlServicePrxHelper;
//import com.perspicace.gen.electricappliance.slice.ElectricApplianceCoreServicePrx;
//import com.perspicace.gen.electricappliance.slice.ElectricApplianceCoreServicePrxHelper;
//import com.perspicace.gen.electricappliance.slice.ElectricApplianceGenJsonServicePrx;
//import com.perspicace.gen.electricappliance.slice.ElectricApplianceGenJsonServicePrxHelper;
//import com.perspicace.gen.electricappliance.slice.ElectricApplianceInfraredServicePrx;
//import com.perspicace.gen.electricappliance.slice.ElectricApplianceInfraredServicePrxHelper;
//import com.perspicace.gen.electricappliance.slice.ElectricApplianceRemindServicePrx;
//import com.perspicace.gen.electricappliance.slice.ElectricApplianceRemindServicePrxHelper;
//import com.perspicace.gen.electricappliance.slice.ElectricApplianceReportServicePrx;
//import com.perspicace.gen.electricappliance.slice.ElectricApplianceReportServicePrxHelper;
////import com.perspicace.gen.family.slice.FamilyMessageServicePrx;
////import com.perspicace.gen.family.slice.FamilyMessageServicePrxHelper;
//import com.perspicace.gen.family.slice.FamilyServicePrx;
//import com.perspicace.gen.family.slice.FamilyServicePrxHelper;
//import com.perspicace.gen.health.slice.HealthServicePrx;
//import com.perspicace.gen.health.slice.HealthServicePrxHelper;
//import com.perspicace.gen.house.slice.HouseServicePrx;
//import com.perspicace.gen.house.slice.HouseServicePrxHelper;
//import com.perspicace.gen.launcher.slice.AppChatServicePrx;
//import com.perspicace.gen.launcher.slice.AppChatServicePrxHelper;
//import com.perspicace.gen.launcher.slice.LauncherServicePrx;
//import com.perspicace.gen.launcher.slice.LauncherServicePrxHelper;
//import com.perspicace.gen.log.slice.LogServicePrx;
//import com.perspicace.gen.log.slice.LogServicePrxHelper;
//import com.perspicace.gen.message.slice.MessageLetterServicePrx;
//import com.perspicace.gen.message.slice.MessageLetterServicePrxHelper;
//import com.perspicace.gen.message.slice.MessageServicePrx;
//import com.perspicace.gen.message.slice.MessageServicePrxHelper;
//import com.perspicace.gen.remote.slice.RemoteServicePrx;
//import com.perspicace.gen.remote.slice.RemoteServicePrxHelper;
//import com.perspicace.gen.scene.slice.SceneServicePrx;
//import com.perspicace.gen.scene.slice.SceneServicePrxHelper;
//import com.perspicace.gen.thirdparty.slice.ThirdPartyServicePrx;
//import com.perspicace.gen.thirdparty.slice.ThirdPartyServicePrxHelper;
//import com.perspicace.gen.timer.slice.TimerServicePrx;
//import com.perspicace.gen.timer.slice.TimerServicePrxHelper;
//import com.perspicace.gen.user.slice.UserServicePrx;
//import com.perspicace.gen.user.slice.UserServicePrxHelper;
//import com.perspicace.gen.verifycode.slice.VerifyCodeServicePrx;
//import com.perspicace.gen.verifycode.slice.VerifyCodeServicePrxHelper;
//
//import Ice.Communicator;
//import Ice.ObjectPrx;
//
//public class IceBeanUtil {
//
//	public static Communicator communicator;
//
//	public static ObjectPrx createIceProxy(@SuppressWarnings("rawtypes") Class serviceCls) {
//		if (communicator == null) {
//			String iceDefaultLocator = "--Ice.Default.Locator=" + Global.getConfig("Ice.Default.Locator");
//			String[] initParams = new String[] { iceDefaultLocator };
//			communicator = Ice.Util.initialize(initParams);
//		}
//
//		String serviceName = serviceCls.getSimpleName();
//		int pos = serviceName.lastIndexOf("Prx");
//		if (pos <= 0) {
//			throw new IllegalArgumentException("Invalid ObjectPrx class ,class name must end with Prx");
//		}
//		String realSvName = serviceName.substring(0, pos);
//		try {
//			String environmentVariable = Global.getConfig("environment.variable");
//			if("dev".equals(environmentVariable)){
//				ObjectPrx base = communicator.stringToProxy(realSvName + "@" + realSvName + "Adapter");
//				return base;
//			}else if("product".equals(environmentVariable)){
//				ObjectPrx base = communicator.stringToProxy(realSvName);
//				return base;
//			}else if("test".equals(environmentVariable)){
//				ObjectPrx base = communicator.stringToProxy(realSvName + "@" + realSvName + "Adapter");
//				return base;
//			}else{
//				return null;
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new RuntimeException(e);
//		}
//	}
//
//	// common
//	private static ContactServicePrx contactService;
//	private static MessageServicePrx messageService;
//	private static MessageLetterServicePrx messageLetterService;
//	private static VerifyCodeServicePrx verifyCodeService;
//	private static CmsServicePrx cmsService;
//	private static LogServicePrx logService;
//	private static AppServicePrx appService;
//
//	public static MessageServicePrx getMessageService() {
//		if (IceBeanUtil.messageService == null) {
//			IceBeanUtil.messageService = MessageServicePrxHelper.checkedCast(createIceProxy(MessageServicePrx.class));
//		}
//		return IceBeanUtil.messageService;
//	}
//
//	public static MessageLetterServicePrx getMessageLetterService() {
//		if (IceBeanUtil.messageLetterService == null) {
//			IceBeanUtil.messageLetterService = MessageLetterServicePrxHelper
//					.checkedCast(createIceProxy(MessageLetterServicePrx.class));
//		}
//		return IceBeanUtil.messageLetterService;
//	}
//
//	public static VerifyCodeServicePrx getVerifyCodeService() {
//		if (IceBeanUtil.verifyCodeService == null) {
//			IceBeanUtil.verifyCodeService = VerifyCodeServicePrxHelper
//					.checkedCast(createIceProxy(VerifyCodeServicePrx.class));
//		}
//		return IceBeanUtil.verifyCodeService;
//	}
//
//	public static ContactServicePrx getContactService() {
//		if (IceBeanUtil.contactService == null) {
//			IceBeanUtil.contactService = ContactServicePrxHelper.checkedCast(createIceProxy(ContactServicePrx.class));
//		}
//		return IceBeanUtil.contactService;
//	}
//
//	public static CmsServicePrx getCmsService() {
//		if (IceBeanUtil.cmsService == null) {
//			IceBeanUtil.cmsService = CmsServicePrxHelper.checkedCast(createIceProxy(CmsServicePrx.class));
//		}
//		return IceBeanUtil.cmsService;
//	}
//
//	public static LogServicePrx getLogService() {
//		if (IceBeanUtil.logService == null) {
//			IceBeanUtil.logService = LogServicePrxHelper.checkedCast(createIceProxy(LogServicePrx.class));
//		}
//		return IceBeanUtil.logService;
//	}
//
//	public static AppServicePrx getAppService() {
//		if (IceBeanUtil.appService == null) {
//			IceBeanUtil.appService = AppServicePrxHelper.checkedCast(createIceProxy(AppServicePrx.class));
//		}
//		return IceBeanUtil.appService;
//	}
//
//	// community
//	private static CommunityServicePrx communityServicePrx;
//
//	public static CommunityServicePrx getCommunityService() {
//		if (IceBeanUtil.communityServicePrx == null) {
//			IceBeanUtil.communityServicePrx = CommunityServicePrxHelper
//					.checkedCast(createIceProxy(CommunityServicePrx.class));
//		}
//		return communityServicePrx;
//	}
//
//	// launcher
//	private static LauncherServicePrx launcherService;
//
//	public static LauncherServicePrx getLauncherService() {
//		if (IceBeanUtil.launcherService == null) {
//			IceBeanUtil.launcherService = LauncherServicePrxHelper
//					.checkedCast(createIceProxy(LauncherServicePrx.class));
//		}
//		return IceBeanUtil.launcherService;
//	}
//
//	//
//	private static AppChatServicePrx appChatService;
//
//	public static AppChatServicePrx getAppChatService() {
//		if (IceBeanUtil.appChatService == null) {
//			IceBeanUtil.appChatService = AppChatServicePrxHelper.checkedCast(createIceProxy(AppChatServicePrx.class));
//		}
//		return IceBeanUtil.appChatService;
//	}
//	//
//
//	// 场景
//	private static SceneServicePrx sceneService;
//
//	public static SceneServicePrx getSceneService() {
//		if (IceBeanUtil.sceneService == null) {
//			IceBeanUtil.sceneService = SceneServicePrxHelper.checkedCast(createIceProxy(SceneServicePrx.class));
//		}
//		return IceBeanUtil.sceneService;
//	}
//
//	// user
//	private static UserServicePrx userService;
//
//	public static UserServicePrx getUserService() {
//		if (IceBeanUtil.userService == null) {
//			IceBeanUtil.userService = UserServicePrxHelper.checkedCast(createIceProxy(UserServicePrx.class));
//		}
//		return IceBeanUtil.userService;
//	}
//
//	// family
//	private static FamilyServicePrx familyService;
//
//	public static FamilyServicePrx getFamilyService() {
//		if (IceBeanUtil.familyService == null) {
//			IceBeanUtil.familyService = FamilyServicePrxHelper.checkedCast(createIceProxy(FamilyServicePrx.class));
//		}
//		return IceBeanUtil.familyService;
//	}
//
//	// device
//	private static DeviceServicePrx deviceServicePrx;
//
//	public static DeviceServicePrx getDeviceService() {
//		if (IceBeanUtil.deviceServicePrx == null) {
//			IceBeanUtil.deviceServicePrx = DeviceServicePrxHelper.checkedCast(createIceProxy(DeviceServicePrx.class));
//		}
//		return IceBeanUtil.deviceServicePrx;
//	}
//
//	// house
//	private static HouseServicePrx houseServicePrx;
//
//	public static HouseServicePrx getHouseService() {
//		if (IceBeanUtil.houseServicePrx == null) {
//			IceBeanUtil.houseServicePrx = HouseServicePrxHelper.checkedCast(createIceProxy(HouseServicePrx.class));
//		}
//		return IceBeanUtil.houseServicePrx;
//	}
//
//	// 工单
//	private static ConstructionServicePrx constructionServicePrx;
//
//	public static ConstructionServicePrx getConstructionService() {
//		if (IceBeanUtil.constructionServicePrx == null) {
//			IceBeanUtil.constructionServicePrx = ConstructionServicePrxHelper
//					.checkedCast(createIceProxy(ConstructionServicePrx.class));
//		}
//		return IceBeanUtil.constructionServicePrx;
//	}
//
//
//	// 家电核心
//	private static ElectricApplianceCoreServicePrx electricApplianceCoreServicePrx;
//
//	public static ElectricApplianceCoreServicePrx getElectricApplianceCoreService() {
//		if (IceBeanUtil.electricApplianceCoreServicePrx == null) {
//			IceBeanUtil.electricApplianceCoreServicePrx = ElectricApplianceCoreServicePrxHelper
//					.checkedCast(createIceProxy(ElectricApplianceCoreServicePrx.class));
//		}
//		return IceBeanUtil.electricApplianceCoreServicePrx;
//	}
//
//	// 家电红外
//	private static ElectricApplianceInfraredServicePrx electricApplianceInfraredServicePrx;
//
//	public static ElectricApplianceInfraredServicePrx getElectricApplianceInfraredService() {
//		if (IceBeanUtil.electricApplianceInfraredServicePrx == null) {
//			IceBeanUtil.electricApplianceInfraredServicePrx = ElectricApplianceInfraredServicePrxHelper
//					.checkedCast(createIceProxy(ElectricApplianceInfraredServicePrx.class));
//		}
//		return IceBeanUtil.electricApplianceInfraredServicePrx;
//	}
//
//	// 家庭Json生成
//	private static ElectricApplianceGenJsonServicePrx electricApplianceGenJsonServicePrx;
//
//	public static ElectricApplianceGenJsonServicePrx getElectricApplianceGenJsonService() {
//		if (IceBeanUtil.electricApplianceGenJsonServicePrx == null) {
//			IceBeanUtil.electricApplianceGenJsonServicePrx = ElectricApplianceGenJsonServicePrxHelper
//					.checkedCast(createIceProxy(ElectricApplianceGenJsonServicePrx.class));
//		}
//		return IceBeanUtil.electricApplianceGenJsonServicePrx;
//	}
//
//	// 家电状态
//	private static ElectricApplianceReportServicePrx electricApplianceReportServicePrx;
//
//	public static ElectricApplianceReportServicePrx getElectricApplianceReportService() {
//		if (IceBeanUtil.electricApplianceReportServicePrx == null) {
//			IceBeanUtil.electricApplianceReportServicePrx = ElectricApplianceReportServicePrxHelper
//					.checkedCast(createIceProxy(ElectricApplianceReportServicePrx.class));
//		}
//		return IceBeanUtil.electricApplianceReportServicePrx;
//	}
//
//	private static ElectricApplianceRemindServicePrx electricApplianceRemindServicePrx;
//
//	public static ElectricApplianceRemindServicePrx getElectricApplianceRemindService() {
//		if (IceBeanUtil.electricApplianceRemindServicePrx == null) {
//			IceBeanUtil.electricApplianceRemindServicePrx = ElectricApplianceRemindServicePrxHelper
//					.checkedCast(createIceProxy(ElectricApplianceRemindServicePrx.class));
//		}
//		return IceBeanUtil.electricApplianceRemindServicePrx;
//	}
//
//	// 家电控制
//	private static ElectricApplianceControlServicePrx electricApplianceControlServicePrx;
//
//	public static ElectricApplianceControlServicePrx getElectricApplianceControlService() {
//		if (IceBeanUtil.electricApplianceControlServicePrx == null) {
//			IceBeanUtil.electricApplianceControlServicePrx = ElectricApplianceControlServicePrxHelper
//					.checkedCast(createIceProxy(ElectricApplianceControlServicePrx.class));
//		}
//		return IceBeanUtil.electricApplianceControlServicePrx;
//	}
//
//	// 定时任务
//	private static TimerServicePrx timerServicePrx;
//
//	public static TimerServicePrx getTimerService() {
//		if (IceBeanUtil.timerServicePrx == null) {
//			IceBeanUtil.timerServicePrx = TimerServicePrxHelper.checkedCast(createIceProxy(TimerServicePrx.class));
//		}
//		return IceBeanUtil.timerServicePrx;
//	}
//
//	// 遥控器红外码
//	private static RemoteServicePrx remoteServicePrx;
//
//	public static RemoteServicePrx getRemoteService() {
//		if (IceBeanUtil.remoteServicePrx == null) {
//			IceBeanUtil.remoteServicePrx = RemoteServicePrxHelper.checkedCast(createIceProxy(RemoteServicePrx.class));
//		}
//		return IceBeanUtil.remoteServicePrx;
//	}
//
//	//
//	private static ThirdPartyServicePrx thirdPartyServicePrx;
//
//	public static ThirdPartyServicePrx getThirdPartyService() {
//		if (IceBeanUtil.thirdPartyServicePrx == null) {
//			IceBeanUtil.thirdPartyServicePrx = ThirdPartyServicePrxHelper
//					.checkedCast(createIceProxy(ThirdPartyServicePrx.class));
//		}
//		return IceBeanUtil.thirdPartyServicePrx;
//	}
//
//
//	private static HealthServicePrx healthServicePrx;
//
//	public static HealthServicePrx getHealthService() {
//		if (IceBeanUtil.healthServicePrx == null) {
//			IceBeanUtil.healthServicePrx = HealthServicePrxHelper.checkedCast(createIceProxy(HealthServicePrx.class));
//		}
//		return IceBeanUtil.healthServicePrx;
//	}
//
//	// 门锁管理
//	private static DoorlockServicePrx doorlockServicePrx;
//
//	public static DoorlockServicePrx getDoorlockService() {
//		if (IceBeanUtil.doorlockServicePrx == null) {
//			IceBeanUtil.doorlockServicePrx = DoorlockServicePrxHelper
//					.checkedCast(createIceProxy(DoorlockServicePrx.class));
//		}
//		return IceBeanUtil.doorlockServicePrx;
//	}
//}
package com.perspicace.ai.deepbot.utils;

import org.apache.commons.lang3.SerializationException;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;

public class RedisObjectSerializer implements RedisSerializer<Object> {

    private Converter<Object, byte[]> serializer = new SerializingConverter ( );
    private Converter<byte[], Object> deserializer = new DeserializingConverter ( );

    static final byte[] EMPTY_ARRAY = new byte[0];

    public Object deserialize(byte[] bytes) {
        if (isEmpty ( bytes )) {
            return null;
        }

        try {
            return deserializer.convert ( bytes );
        } catch (Exception ex) {
            throw new SerializationException ( "Cannot deserialize" , ex );
        }
    }

    public byte[] serialize(Object object) {
        if (object == null) {
            return EMPTY_ARRAY;
        }

        try {
            return serializer.convert ( object );
        } catch (Exception ex) {
            return EMPTY_ARRAY;
        }
    }

    private boolean isEmpty(byte[] data) {
        return (data == null || data.length == 0);
    }
}