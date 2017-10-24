package my.lib.serenity.primefaces.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by arrow on 5/10/16.
 */
public class CommonConstant {
    private static Map<Integer, String> mapBranch_master;
    private static Map<Integer, String> mapAddressPoint;
    private static Map<Integer, String> mapPosition;
    private static Map<Integer, String> mapWorkType;
    private static Map<Integer, String> mapAuthority;

    public static Map<Integer, String> getMapBranch_master() {
        if (mapBranch_master == null) {
            mapBranch_master = new HashMap<>();
            mapBranch_master.put(1, "東京");
            mapBranch_master.put(2, "大阪");
            mapBranch_master.put(3, "名古屋");
            mapBranch_master.put(4, "広島");
            mapBranch_master.put(5, "北九州");
            mapBranch_master.put(6, "北海道");
            mapBranch_master.put(7, "東北");
            mapBranch_master.put(8, "福岡");
            mapBranch_master.put(9, "札幌開発");
            mapBranch_master.put(10, "役員報酬");
            mapBranch_master.put(11, "本社");
            mapBranch_master.put(12, "東京支店");
            mapBranch_master.put(13, "東北支店");
            mapBranch_master.put(14, "横浜営業所");
            mapBranch_master.put(15, "通信ﾈｯﾄﾜｰｸ事業部");
            mapBranch_master.put(16, "大阪支店");
            mapBranch_master.put(17, "神戸営業所");
            mapBranch_master.put(18, "名古屋支店");
            mapBranch_master.put(19, "広島営業所");
            mapBranch_master.put(20, "北九州支店");
            mapBranch_master.put(21, "北海道支店");
            mapBranch_master.put(22, "一割源泉");
            mapBranch_master.put(23, "東京支店１割源泉");
            mapBranch_master.put(24, "Ｒ Ｉ Ａ");
            mapBranch_master.put(25, "札幌開発センター");
            mapBranch_master.put(26, "札幌開発センター");
        }
        return mapBranch_master;
    }

    public static Map<Integer, String> getMapAddressPoint() {
        if (mapAddressPoint == null) {
            mapAddressPoint = new HashMap<>();
            mapAddressPoint.put(1, "北海道");
            mapAddressPoint.put(2, "青森県");
            mapAddressPoint.put(3, "岩手県");
            mapAddressPoint.put(4, "宮城県");
            mapAddressPoint.put(5, "秋田県");
            mapAddressPoint.put(6, "山形県");
            mapAddressPoint.put(7, "福島県");
            mapAddressPoint.put(8, "茨城県");
            mapAddressPoint.put(9, "栃木県");
            mapAddressPoint.put(10, "群馬県");
            mapAddressPoint.put(11, "埼玉県");
            mapAddressPoint.put(12, "千葉県");
            mapAddressPoint.put(13, "東京都");
            mapAddressPoint.put(14, "神奈川県");
            mapAddressPoint.put(15, "新潟県");
            mapAddressPoint.put(16, "富山県");
            mapAddressPoint.put(17, "石川県");
            mapAddressPoint.put(18, "福井県");
            mapAddressPoint.put(19, "山梨県");
            mapAddressPoint.put(20, "長野県");
            mapAddressPoint.put(21, "岐阜県");
            mapAddressPoint.put(22, "静岡県");
            mapAddressPoint.put(23, "愛知県");
            mapAddressPoint.put(24, "三重県");
            mapAddressPoint.put(25, "滋賀県");
            mapAddressPoint.put(26, "京都府");
            mapAddressPoint.put(27, "大阪府");
            mapAddressPoint.put(28, "兵庫県");
            mapAddressPoint.put(29, "奈良県");
            mapAddressPoint.put(30, "和歌山県");
            mapAddressPoint.put(31, "鳥取県");
            mapAddressPoint.put(32, "島根県");
            mapAddressPoint.put(33, "岡山県");
            mapAddressPoint.put(34, "広島県");
            mapAddressPoint.put(35, "山口県");
            mapAddressPoint.put(36, "徳島県");
            mapAddressPoint.put(37, "香川県");
            mapAddressPoint.put(38, "愛媛県");
            mapAddressPoint.put(39, "高知県");
            mapAddressPoint.put(40, "福岡県");
            mapAddressPoint.put(41, "佐賀県");
            mapAddressPoint.put(42, "長崎県");
            mapAddressPoint.put(43, "熊本県");
            mapAddressPoint.put(44, "大分県");
            mapAddressPoint.put(45, "宮崎県");
            mapAddressPoint.put(46, "鹿児島県");
            mapAddressPoint.put(47, "沖縄県");
        }
        return mapAddressPoint;
    }

    public static Map<Integer, String> getMapPosition() {
        if (mapPosition == null) {
            mapPosition = new HashMap<>();
            mapPosition.put(101, "管理職");
            mapPosition.put(102, "担当職");
            mapPosition.put(103, "事務職");
            mapPosition.put(104, "システム管理者");
        }
        return mapPosition;
    }

    public static Map<Integer, String> getMapAuthority() {
        if (mapAuthority == null) {
            mapAuthority = new HashMap<>();
            mapAuthority.put(0, "拠点");
            mapAuthority.put(1, "本社");
        }
        return mapAuthority;
    }

    public static Map<Integer, String> getMapWorkType() {
        if (mapWorkType == null) {
            mapWorkType = new HashMap<>();
            mapWorkType.put(101, "建築");
            mapWorkType.put(102, "土木");
            mapWorkType.put(103, "電気");
            mapWorkType.put(104, "設備");
            mapWorkType.put(201, "ソフトウェア");
            mapWorkType.put(201, "ネットワーク");
            mapWorkType.put(301, "通信_無線");
            mapWorkType.put(302, "通信_有線");
            mapWorkType.put(401, "機械・ハード");
            mapWorkType.put(501, "プラント");
            mapWorkType.put(601, "共通");
            mapWorkType.put(602, "事務");
            mapWorkType.put(603, "コールセンター");
        }
        return mapWorkType;
    }

    public static final String BRANCH_REQUIRED_MESSAGE_TEXT = "Please select a branch";
    public static final String EMPLOYEE_REQUIRED_MESSAGE_TEXT = "Please select employee";
    public static final String DELETE_SUCCESSFULLY_MESSAGE_TEXT = "Delete successfully";
    public static final String ADD_TRACKING_NOTIFICATION_PANEL_HEADER = "Add employees to track";
    public static final String MARK_ALL_AS_READ_SUCCESS_MESSAGE = "You have just removed notification successfully";
    public static final String ADD_NEW_DAILY_REPORT_SUCCESS_MESSAGE = "Save successfully";
    public static final String REGISTER_DAILY_REPORT_CATEGORY_OTHER_WORKS = "Other works";
    public static final String REGISTER_DAILY_REPORT_CATEGORY_BUSINESS = "Business";
    public static final String FLAG_ON = "ON";
    public static final String FLAG_OFF = "OFF";
    public static final String START_TIME_AND_END_TIME_REQUIRED_MESSAGE = "Reminder: \"From date\" and \"To date\" are required";
    public static final String DELETE_DAILY_REPORT_SUCCESSFULLY_MESSAGE = "Delete successfully";
    public static final String APPROVE_ACCOUNTING_DATA_SUCCESS_MESSAGE = "Save successfully";
    public static final String APPROVE_ACCOUNTING_DATA_FAILURE_MESSAGE = "Cannot create a report same Request user account, \"Date of survey\" and \"Survey institute and information source\" have been existed";
    public static final String FLAG_YES = "Yes";

    public class DateTimePattern {

        public static final String YEAR_MONTH_DAY = "yyyy/MM/dd";
    }
}
