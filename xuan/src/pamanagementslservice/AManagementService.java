package pamanagementslservice;

import java.util.ArrayList;

import vo.AgencyVO;

public interface AManagementService {

		
		public AgencyVO select(String id);
		public ArrayList<AgencyVO> getAllAgency();
		public void delect(String id);
		public void revise(String id);
		public void saveChange(AgencyVO vo);
		public void save(AgencyVO vo);
		public void add();
		public void endAManagement();
	
		
	
	}

