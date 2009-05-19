package com.dendrytdev.org.server;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dendrytdev.org.client.bean.Problem;
import com.dendrytdev.org.client.problemOverview.ProblemOverviewService;

public class ProblemOverviewServiceImpl implements ProblemOverviewService{
	

	
	
	static List<Problem> testingList = new ArrayList<Problem>();

	List<Problem> generateTestingValues() {
		if (testingList.size() == 0) { //generate only once
			System.out.println("G");

			Problem pr = new Problem();
			pr.setProdukt("Produkt1");
			pr.setImieZglaszajacego("Michal");
			pr.setNazwiskoZglaszajacego("NAZWISKO1");
			pr.setTelefonZglaszajacego("0774822244");
			pr.setWagaKlienta("2");
			pr.setDataZgloszenia(new Date());
			pr.setSerwisant("S");
			pr.setProjektant("PR");
			pr.setProgramista("PROG");
			pr.setTester("T");
			pr.setOpis("Cos sie zepsulo chyba w czyms tam, albo i nie nawet");
			testingList.add(pr);

			pr = new Problem();
			pr.setProdukt("Produkt2");
			pr.setImieZglaszajacego("Kasia");
			pr.setNazwiskoZglaszajacego("NAZWISKO2");
			pr.setTelefonZglaszajacego("0774821111");
			pr.setWagaKlienta("4");
			pr.setDataZgloszenia(new Date());
			pr.setSerwisant("S2");
			pr.setProjektant("PR2");
			pr.setProgramista("PROG2");
			pr.setTester("T2");
			pr.setOpis("Wyskoczylo okno z napisem jakims tam bla bla bla");
			testingList.add(pr);
			
			
			
			pr = new Problem();
			pr.setProdukt("ProduktX3");
			pr.setImieZglaszajacego("Wojtek");
			pr.setNazwiskoZglaszajacego("NAZWISKO3");
			pr.setTelefonZglaszajacego("0774823333");
			pr.setWagaKlienta("2");
			pr.setDataZgloszenia(new Date());
			pr.setSerwisant("S3");
			pr.setProjektant("PR3");
			pr.setProgramista("PROG3");
			pr.setTester("T3");
			pr.setOpis("xxxxxxxxxxxxxxxxxx.x..x.c.fd..fd.f.df..f..ff...f.f. AlkoAGILE");
			testingList.add(pr);
			
			pr = new Problem();
			pr.setProdukt("DENDRYT");
			pr.setImieZglaszajacego("Michal");
			pr.setNazwiskoZglaszajacego("Szaman");
			pr.setTelefonZglaszajacego("514414411");
			pr.setWagaKlienta("1");
			pr.setDataZgloszenia(new Date());
			pr.setSerwisant("");
			pr.setProjektant("");
			pr.setProgramista("skok");
			pr.setTester("");
			pr.setOpis("blad .... ;-)");
			testingList.add(pr);
			
			pr = new Problem();
			pr.setProdukt("CYFRON");
			pr.setImieZglaszajacego("Olga");
			pr.setNazwiskoZglaszajacego("Awarja");
			pr.setTelefonZglaszajacego("8888");
			pr.setWagaKlienta("1");
			pr.setDataZgloszenia(new Date());
			pr.setSerwisant("");
			pr.setProjektant("");
			pr.setProgramista("skok");
			pr.setTester("");
			pr.setOpis("awaria .... ;-)");
			testingList.add(pr);
			
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
