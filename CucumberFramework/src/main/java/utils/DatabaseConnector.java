package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnector {

	
	
//	private final static String DATABASE_SCHEMA = "DEVI77";
//	private final static String DATABASE_IP = "10.101.138.58";
//	private final static String DATABASE_PORT = "1521";
//	private final static String DATABASE_USER = "I77";
//	private final static String DATABASE_PASS = "I77";
	
	private final static String DATABASE_SCHEMA = "DEVI77";
	private final static String DATABASE_IP = "10.101.138.58";
	private final static String DATABASE_PORT = "1521";
	private final static String DATABASE_USER = "NTE35W";
	private final static String DATABASE_PASS = "NTE35W";
	private final static String DATABASE_URL = "jdbc:oracle:thin:@" + DATABASE_IP + ":" + DATABASE_PORT + ":" + DATABASE_SCHEMA;
	
	public static Long checkResultInDatabase(String query) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Long result = null;
		
		try {
			conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASS);
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				result = rs.getLong(1);
			}
			
		} catch (SQLException e) {
			
			System.out.println("Connector error: " + e.getMessage());
			
		}finally{
			closeConnection(rs, conn, ps);
		}
		return result;
		
	}
	
	public static List<String> getTransactionValuesInDatabase(List<String> ids) {
		
		String fields = " MEDTR_TRNST_FK, MEDTR_OID, MEDTR_SETTOLLROAD_FK, MEDTR_FEC_TSCTIMESTAMP, MEDTR_PRVRSE_FK, MEDTR_SETTOLLPLAZA_FK, MEDTR_VAL_LANE, MEDTR_VAL_TCS_PLATE, MEDTR_VAL_TCSPLATECONF, MEDTR_VAL_TCS_JURIS, MEDTR_VAL_TCSJURISCONF, MEDTR_VAL_TCS_ETCTAGID, MEDTR_VAL_ISVIDEO, MEDTR_TAGSTATUS_FK, MEDTR_VAL_TAGCLASS, MEDTR_VAL_TAGTVLFILEID, MEDTR_VAL_TAGISINVALID, MEDTR_VAL_TAG_FROM_TVL, MEDTR_VEPRULES_FK, MEDTR_VEPDESTINATION_FK, MEDTR_VAL_CLASSMISMATCH, MEDTR_VAL_MINFLAG, MEDTR_VAL_TOLLAMOUNT, MEDTR_VAL_TOLLBEFDISC, MEDTR_TOLL_FARE_FK, MEDTR_MEDEXEMPT_FK, MEDTR_VAL_CONTRAFLOW, MEDTR_COD_ISSUEREPCAUSE_FK, MEDTR_NUM_RETRANSCOUNT, MEDTR_RETRANS_TIMESTAMP, MEDTR_VAL_PROV_HOV, MEDTR_VAL_TCSHEIGHT, MEDTR_VAL_TSCLENGTH, MEDTR_VAL_TCSWIDTH, MEDTR_VAL_PLATE, MEDTR_VAL_JURISDICTION, MEDTR_VAL_PLATE_CONF, MEDTR_VAL_JURIS_CONF, MEDTR_VHCLASS_FK, MEDTR_VAL_CUTIMAGE, MEDTR_RVNTYP_FK, MEDTR_VAL_TCSCLASS, MEDTR_FIXED_FEE, MEDTR_VARIABLE_FEE, MEDTR_INTEROP_FEE, MEDTR_IND_UNACCEPTABLE, MEDTR_IND_SUITABLE, MEDTR_EXCEPT_FK, MEDTR_DAT_MODIFICATION, MEDTR_USER_MODIFICATION, MEDTR_TRIPS_FK, MEDTR_FEC_TSCDATE, MEDTR_FORCE_EQUALS_TRIPS, MEDTR_IS_PASS_TO_VEP, MEDTR_AUTOMATIC_REVENUE_DATE, MEDTR_AUTOMATIC_TXTRECTYPE, MEDTR_AUTOMATIC_NUMBER_RESUBMI, MEDTR_TXN_CODE, MEDTR_UTC_TMSTMP, MEDTR_COD_UNREADABLE, MEDTR_COD_UNCOLLECTIBLE, MEDTR_NUM_ATTEMPTS_FIND_IMG, MEDTR_WAITIMGATTEMPT_TIMESTAMP, MEDTR_FRONT_VDAC_CLASS_CONF, MEDTR_REAR_VDAC_CLASS_CONF, MEDTR_FRONT_VDAC_TOLL_CLASS, MEDTR_REAR_VDAC_TOLL_CLASS, MEDTR_EMERGENCY, MEDTR_HIGH_DISC, MEDTR_PLATE_TYPE_FK, MEDTR_IND_LOAD_ROOF, MEDTR_COUNTRY_FK, MEDTR_HIGH_SURCH, MEDTR_MAX_TOLL_RATE, MEDTR_MIN_TOLL_RATE, MEDTR_VAL_IPID, MEDTR_IND_FNG_OPERATION, MEDTR_VAL_FNG_CONF, MEDTR_IND_FNG_OK, MEDTR_IND_FNG, MEDTR_DISC_APPLIED, MEDTR_DISPUT_FK, MEDTR_RECJV_FK, MEDTR_LOCATION_TYPE, MEDTR_FACILITY, MEDTR_SPEED, MEDTR_LANE_MODE_FK, MEDTR_COLLECTOR_ID, MEDTR_VAULT_ID, MEDTR_TRANSPONDER_TOLL_AMOUNT, MEDTR_TRANSPONDER_DISC_TYPE, MEDTR_DISC_TOLL_AMOUNT, MEDTR_VIDEO_TOLL_AMOUNT, MEDTR_VIDEO_DISC_TYPE, MEDTR_SURCH_TOLL_AMOUNT, MEDTR_DISCO_VIDEO_WITH_TOLL_PR, MEDTR_AMOUNT_PAID, MEDTR_OCCURRENCE_CODE_FK, MEDTR_NUMBER_IMAGES, MEDTR_NET_RECLAIMED_AMOUNT, MEDTR_RECTRP_FK, MEDTR_RESUBMITTED_FLAG, MEDTR_REVENUE_DATE, MEDTR_RESUBMITTED_NUMBER, MEDTR_RESUBMITTED_REASON, MEDTR_DATE_POSTED, MEDTR_DISPRECTYPE, MEDTR_TSP_PAYMENT_AMOUNT, MEDTR_COD_VIOLATION, MEDTR_REJCOD_FK, MEDTR_DSP_RECORD_ID, MEDTR_FRONT_VDAC_SPEED, MEDTR_REAR_VDAC_SPEED, MEDTR_EXPEC_PAY_DATE, MEDTR_DAT_RECON_STATUS, MEDTR_DSPPROC_TIME_READED, MEDTR_TRANSFER_IMAGE, MEDTR_DAT_TARIFICATION, MEDTR_LVL_FILE_NAME, MEDTR_VAL_FORCE_VEP, MEDTR_TOLLAMOUNT_EXPECTED, MEDTR_AMOUNT_POSTED, MEDTR_IS_ADJUSTMENT_JV, MEDTR_SPLIT_TRIP, MEDTR_IS_PENDING_OPERATION, MEDTR_FEC_AVIDUP_LAST_PROC, MEDTR_TXN_IDENTITY, MEDTR_DUPLICATE_AVI_DET, MEDTR_IS_ETC_TAG, MEDTR_VAL_ISVIDEO_ORI, MEDTR_NUM_IMAGES_WAITED, MEDTR_IS_PASS_TO_DSPSCREEN, MEDTR_REVIEW_LOCK_TIME, MEDTR_ID_SAME_DISCARTED, MEDTR_IS_COMBOGANTRY, MEDTR_IS_WAITING_FARE, MEDTR_VAL_DISC_PRIORITY, MEDTR_TRIPBUILDING_TMSTP, MEDTR_SAME_DISCARDED_PROCESS, MEDTR_ITERATION_AUTO_REVIEW, MEDTR_INVALID_LAST_TIME_REVIEW, MEDTR_CODEOFF_TO_MANUAL_REVIEW, MEDTR_IP_SPV_DISAGREES, MEDTR_IP_FORZE_NOT_UNCOL, MEDTR_DISPUT_PREV, MEDTR_RECTRP_PREV, MEDTR_SETTOLLPLAZA_RATED, MEDTR_VAL_TVL_PLATE, MEDTR_VAL_TVL_PLATE_STATE, MEDTR_VAL_TCS_ETCTAGID_INITVAL, MEDTR_TOLL_RATE_TAG, MEDTR_TOLL_RATE_VID_PRE, MEDTR_TOLL_RATE_VID_POS, MEDTR_IS_DSP_PRESENT, MEDTR_DISC_TYPE_APPLIED, MEDTR_TOLL_FARE_TAG_FK, MEDTR_TOLL_FARE_VID_PRE_FK, MEDTR_TOLL_FARE_VID_POS_FK, MEDTR_VAL_TOLLBEFDISC_TAG, MEDTR_VAL_TOLLBEFDISC_VID_PRE, MEDTR_VAL_TOLLBEFDISC_VID_POS, MEDTR_EMERGENCY_TAG, MEDTR_EMERGENCY_VID_PRE, MEDTR_EMERGENCY_VID_POS, MEDTR_DAT_TARIFICATION_TAG, MEDTR_DAT_TARIFICATION_VID_PRE, MEDTR_DAT_TARIFICATION_VID_POS, MEDTR_DISC_APPLIED_TAG, MEDTR_DISC_APPLIED_VIDEO_PRE, MEDTR_DISC_APPLIED_VIDEO_POS, MEDTR_MEDEXEMPT_TAG_FK, MEDTR_MEDEXEMPT_VIDEO_PRE_FK, MEDTR_MEDEXEMPT_VIDEO_POS_FK, MEDTR_IMG_REAR_FK, MEDTR_IMG_CROP_FK, MEDTR_IS_PLATE_FROM_VEP, MEDTR_TOTAL_FIXED_FEE, MEDTR_TOTAL_VARIABLE_FEE, MEDTR_TOTAL_INTEROP_FEE, MEDTR_CONVERT_TO_VIDEO_FK, MEDTR_PLATE_TYPE_CONF, MEDTR_TOLLPREMIUM_TOLL_AMOUNT, MEDTR_TOLLPREM_TOLL_AM_TAG, MEDTR_TOLLPREM_TOLL_AM_VID_PRE, MEDTR_TOLLPREM_TOLL_AM_VID_POS";
		StringBuilder queryTransactionStatus = new StringBuilder("SELECT ").append(fields).append(" FROM med_bos_transactions where medtr_oid in (");
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<String> result = new ArrayList<String>();
		
		try {
			if(!ids.isEmpty()) {
				queryTransactionStatus.append(
						String.join(",", ids));
				queryTransactionStatus.append(")");
				
				conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASS);
				ps = conn.prepareStatement(queryTransactionStatus.toString());
				
				rs = ps.executeQuery();
				
				String[] fieldsList = fields.split(",");
				
				StringBuilder row = null;
				while(rs.next()) {
					row = new StringBuilder();
					for (int j = 0; j < fieldsList.length; j++) {
						row
							.append(fieldsList[j])
							.append("=")
							.append(rs.getString(j+1))
							.append(",")
							.toString();
					}
					result.add(row.toString());
				}
			}
			
		} catch (SQLException e) {
			
			System.out.println("Connector error: " + e.getMessage());
			
		}finally{
			closeConnection(rs, conn, ps);
		}
		return result;
		
	}
	
	private static void closeConnection(ResultSet rs, Connection conn, PreparedStatement ps){
		try {
			if(rs!=null&&!rs.isClosed()){
				rs.close();
			}
		} catch (SQLException e) {
			System.out.println("Connector error: " + e.getMessage());
		}
		try {
			if(ps!=null&&!ps.isClosed()){
				ps.close();
			}
		} catch (SQLException e) {
			System.out.println("Connector error: " + e.getMessage());
		}
		try {
			if(conn!=null&&!conn.isClosed()){
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("Connector error: " + e.getMessage());
		}
	}
	
}
