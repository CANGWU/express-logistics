package pamanagementslservice;

import java.util.ArrayList;

import enums.ResultMessage;
import vo.AgencyVO;

public interface AManagementService {

		
		public AgencyVO select(String id);
		public ArrayList<AgencyVO> getAllAgency();
		public ResultMessage delete(String id);
		public AgencyVO revise(String id);
		public ResultMessage saveChange(AgencyVO vo);
		public void save();
		public ResultMessage add(String name,String idNumber,ArrayList<String> staff,String phonenumber,String address,String leader);
	
		
	
	}

