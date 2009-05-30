package com.dendrytdev.org.server;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dendrytdev.org.client.bean.Problem;
import com.dendrytdev.org.client.problemOverview.ProblemOverviewService;

public class ProblemOverviewServiceImpl implements ProblemOverviewService{
	

	
	
	static List<Problem> testingList = new ArrayList<Problem>();

	
	/**
	 * for mega fucking testing purposes only ;>
	 */
	Problem generateOneProblem(String[] s){
		Problem p = new Problem();
		p.setProduct(s[0]);
		p.setClient(s[1]);
		p.setClientImportance(s[2]);
		p.setProblemDate(new Date());
		p.setService(s[3]);
		p.setDesigner(s[4]);
		p.setProgrammer(s[5]);
		p.setTester(s[6]);
		p.setDescription(s[7]);
		return p;
	}
	
	/**
	 * for mega testing purposes only ;>
	 */
	List<Problem> generateTestingValues() {
		if (testingList.size() == 0) { //generate only once
			String[] arr;
			
			arr = new String[]{
					"Produkt1",
					"Michal",
					"2",
					"S",
					"PR",
					"PROG",
					"T",
					"Cos sie zepsulo chyba w czyms tam, albo i nie nawet"
					};
			testingList.add(generateOneProblem(arr));
			
			arr = new String[]{
					"Dendryt",
					"Jozek",
					"3",
					"See",
					"PR",
					"PROG",
					"T",
					"Bla blaaaa blaa. .... "
			};
			testingList.add(generateOneProblem(arr));
			
			arr = new String[]{
					"GoogleWave",
					"Slawek",
					"2",
					"Seer",
					"PR",
					"PROG11",
					"T",
					"xxxxxxxx consult the log for full details........."
			};
			testingList.add(generateOneProblem(arr));
			
			arr = new String[]{
					"Dendryt",
					"Zbigniew",
					"1",
					"Serww",
					"PRrr",
					"PROGgg",
					"T",
					"yyyyyyy / ....."
			};
			testingList.add(generateOneProblem(arr));
			
			arr = new String[]{
					"CyfronWIWIII",
					"Olgiert",
					"2",
					"S",
					"PR",
					"PROG2",
					"T",
					";)"
			};
			testingList.add(generateOneProblem(arr));
			
			
		}

		return testingList;
	}
	
	
	@Override
	public List<Problem> getProblemList(int lastListHashCode) {
		List<Problem> list = generateTestingValues(); // TODO: take it from DB!!!
		int hash = list.hashCode();
		System.out.println("hash" + hash);
		System.out.println("lastListHashCode" + lastListHashCode);
		if(lastListHashCode == hash){
			return null; //no changes on server side, no need to send the data
		}else{
			lastListHashCode = hash;
			return list;
		}
	}

}
