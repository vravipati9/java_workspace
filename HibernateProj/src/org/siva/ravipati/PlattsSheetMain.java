package org.siva.ravipati;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class PlattsSheetMain {

	/**
	 * @param args
	 */
	public static Logger log = Logger.getLogger(PlattsSheetMain.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//PropertyConfigurator.configure("log4j.properties");
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Long courseId = null;
		try {
			System.out.println("IN PLATTS MAIN.............");
			transaction = session.beginTransaction();
			insertPlattsSheet(session);
			//deletePlattsSheet(session); //using delete-orphan
			//readPSusingRestrictions(session);
			//readPSUsingCriteria(session);
			//readPSUsingJoins(session);

			//callStoredProcedure(session);
			//readPSUsingEagerFetch(session);
			//readPsUsingAlias(session);
			//usingInverseEx(session);
			//usingSQLFunctions(session);
			
			//distinctResults(session);
			transaction.commit();
		} catch (HibernateException e) {
			System.out.println("e....."+e.getMessage());
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}
	private static void distinctResults(Session session) {
		List<PlattsSheet> plattsSheet = null;
		
		//Criteria plattsSheetCriteria = session.createCriteria(PlattsSheet.class);
		//Criteria plattsPriceCriteria = plattsSheetCriteria.createCriteria("plattsPrices");
		Criteria plattsPriceCriteria = session.createCriteria(PlattsPrice.class, "pp");
		Criteria plattsSheetCriteria = plattsPriceCriteria.createCriteria("pp.plattsSheet", "ps");
		
//		plattsSheetCriteria.setProjection( Projections.projectionList()
//	             .add( Projections.count("plattsSheetId"))
//	              .add( Projections.groupProperty("plattsSheetId")));
//		List<PlattsSheet> plattsSheets = plattsSheetCriteria.list();
//		for (PlattsSheet ps : plattsSheets) {
//		
//		}
		
		plattsPriceCriteria.setProjection(Projections.projectionList()
        .add( Projections.property("plattsPriceId"))
        .add( Projections.property("ps.plattsSheetId")));
		List<Object[]> objArray = plattsPriceCriteria.list();
		
		
		
		System.out.println("li.size...."+objArray.size());
		
			
//		System.out.println(ps.getPlattsSheetName()+"--"+ps.getPlattsSheetId());	

	       // SELECT COUNT(ID) FROM ORDER  HAVING PRICETOTAL>2000 GROUP BY ID

//	       List orders = session.createCriteria(PlattsSheet.class)
//	            .setProjection( Projections.projectionList()
//	             .add( Projections.count(“id”) )
//	              .add( Projections.groupProperty(“id”) )
//	            )
//	             .list();
		



	}

	private static void callStoredProcedure(Session session) {
		System.out.println("In CallStoredProcedure");
		// By using first way
		/*Query query = session
		.createSQLQuery("CALL GetPlattSheets(:plattsSheetId)")
		.addEntity(PlattsSheet.class)
		.setParameter("plattsSheetId", "102");
		 */

		Query query = session.getNamedQuery("selPlattSheetItems")
		.setParameter("plattsSheetId", "102");
		List result = query.list();
		for (int i = 0; i < result.size(); i++) {
			PlattsSheet plattsSheet = (PlattsSheet) result.get(i);
			System.out.println(plattsSheet.getPlattsSheetName());
		}
	}


	private static void usingInverseEx(Session session) {
		/*        Query q = session.createQuery("from PlattsSheet where stockCode = :stockCode ");
        q.setParameter("stockCode", "4715");
        Stock stock = (Stock)q.list().get(0);
        stock.setStockName("GENM1");
        StockDailyRecord stockDailyRecords = new StockDailyRecord();
        //set stockDailyRecords data
        stockDailyRecords.setStock(stock);        
        stock.getStockDailyRecords().add(stockDailyRecords);
        session.save(stockDailyRecords);
        session.update(stock);
		 */        

		/*Query q = session.createQuery("from PlattsSheet where plattsSheetId = :plattsSheetId");
		q.setParameter("plattsSheetId", new Integer(103));
		List l = q.list();
		PlattsSheet pSheet = (PlattsSheet)l.get(0);
		pSheet.setPlattsSheetName("NEW ONE");
		PlattsPrice plattsPrice = new PlattsPrice();
		plattsPrice.setPlattsSheet(pSheet);
		pSheet.getPlattsPrices().add(plattsPrice);
		session.save(plattsPrice);
		session.update(pSheet);*/
		PlattsSheet pSheet = new PlattsSheet();
		pSheet.setPlattsSheetId(103);
		PlattsPrice plattsPrice = new PlattsPrice();
		plattsPrice.setPlattsPriceId(new Integer(new Integer(12)));
		plattsPrice.setPlattsSheet(pSheet);
		plattsPrice.setRegionTypeId(new Integer(new Integer(970)));

		session.save(plattsPrice);
	}

	private static void deletePlattsSheet(Session session) {
		System.out.println("DeletePlattsSheet........");
		// using delete
		/*		Criteria crit = session.createCriteria(PlattsSheet.class);
		crit.add(Expression.eq("plattsSheetId", Integer.valueOf(103)));
		PlattsSheet plattsSheet =  (PlattsSheet)crit.list().get(0);
		session.delete(plattsSheet);
		 */		
		// use delete-orphan - if we want to delete some records
		//http://www.mkyong.com/hibernate/hibernate-cascade-example-save-update-delete-and-delete-orphan/
		Query q = session.createQuery("from PlattsSheet where plattsSheetId = :plattsSheetId");
		q.setParameter("plattsSheetId", new Integer(102));
		List l = q.list();
		PlattsSheet pSheet = (PlattsSheet)l.get(0);
		PlattsPrice pp2 = (PlattsPrice)session.get(PlattsPrice.class, new Integer(1));
		pSheet.getPlattsPrices().remove(pp2);
		session.saveOrUpdate(pSheet);

		/*
		 *	//WITH OUT USING DELETE-ORPHAN
 		PlattsPrice pp1 = (PlattsPrice)session.get(PlattsPrice.class, new Integer(2)); 
 		session.delete(pp1);
		 */
	}
	@SuppressWarnings("unchecked")
	private static void readPSUsingJoins(Session session) {
		/*Iterator i = session.createQuery(
				"select ps.plattsSheetId, ps.plattsSheetName, pp.plattsPriceId " +
				"from PlattsSheet ps join ps.plattsPrices pp " +
				"where pp.plattsPriceId = 1"
		).list().iterator();
		 */
		Iterator i = session.createQuery(
				"select ps.plattsSheetId, ps.plattsSheetName, pp.plattsPriceId " +
				"from PlattsSheet join PlattsPrice pp " +
				"where pp.plattsPriceId = 1"
		).list().iterator();
		while ( i.hasNext() ) {
			Object[] row = (Object[]) i.next();
			Integer id = (Integer) row[0];
			String description = (String) row[1];
			Integer ppId = (Integer) row[2];
			// ... show values in a report screen
			System.out.println(id+"---"+"---"+description+"---"+ppId);
		}

		Iterator itr = session.createSQLQuery( "select * from platts_sheet ps join platts_price pp " +
		"where ps.platts_sheet_id=pp.platts_sheet_id and platts_price_id=1 and platts_sheet_name like 't%'").list().iterator();
		for (;itr.hasNext();) {
			if (itr instanceof PlattsSheet) {
				PlattsSheet plattsSheet = (PlattsSheet) itr;
				System.out.println("INFO...."+plattsSheet.getPlattsSheetId()+  "---"+plattsSheet.getPlattsSheetName());	
			}
		}
	}

	private static void usingSQLFunctions(Session session) {


		Iterator i = session.createQuery(
				"select ps.plattsSheetId, lower(ps.plattsSheetName)" +
		"from PlattsSheet ps join ps.plattsPrices pp ").list().iterator();

		while ( i.hasNext() ) {
			Object[] row = (Object[]) i.next();
			Integer id = (Integer) row[0];
			String description = (String) row[1];


			// ... show values in a report screen
			System.out.println(id+"---"+"---"+description);
		}
	}

	private static void readPSUsingEagerFetch(Session session) {
		//The query returns all combinations of associated Bids and Items. But unlike a fetch
		//join, the bids collection of the Item isn’t initialized by the query
		Query q = session.createQuery("from PlattsSheet ps join ps.plattsPrices pp where pp.plattsPriceId = 1");
		Iterator itr = q.list().iterator();
		for (;itr.hasNext();) {
			Object[] obj = (Object[])itr.next();
			if (obj[0] instanceof PlattsSheet) {
				PlattsSheet plattsSheet = (PlattsSheet) obj[0];
				System.out.println("INFO...."+plattsSheet.getPlattsSheetId()+  "---"+plattsSheet.getPlattsSheetName());	
			}
			if (obj[1] instanceof PlattsPrice) {
				PlattsPrice plattsPrice = (PlattsPrice) obj[1];
				System.out.println("INFO...."+plattsPrice.getPlattsPriceId()+  "---"+plattsPrice.getRegionTypeId());	
			}
		}
		// Using fetch join
		System.out.println("FETCH");
		Query qry = session.createQuery("from PlattsSheet ps left join fetch ps.plattsPrices pp where pp.plattsPriceId = 1");
		/*Iterator it = qry.list().iterator();
		for (;it.hasNext();) {
			if (it instanceof PlattsSheet) {
				PlattsSheet plattsSheet = (PlattsSheet) it;
				System.out.println("INFO...."+plattsSheet.getPlattsSheetId()+  "---"+plattsSheet.getPlattsSheetName());	
			}
		}*/
		List<PlattsSheet> plattsSheet = qry.list();
		for (PlattsSheet ps : plattsSheet) {
			System.out.println(ps.getPlattsSheetName()+"--"+ps.getPlattsSheetId());
		}
	}

	private static void readPsUsingAlias(Session session) {
		List<PlattsSheet> plattsSheet = null;
		String string = "T*";
		Criteria plattsCriteria = session.createCriteria(PlattsSheet.class);  
		String plattsSheetName = string.replace('*', '%');
		plattsCriteria.add(Restrictions.ilike("plattsSheetName", plattsSheetName));
		Criteria parentVendorQuery = plattsCriteria.createCriteria("plattsPrices");
		parentVendorQuery.add(Restrictions.eq("plattsPriceId", Integer.valueOf(1)));



		plattsSheet  = parentVendorQuery.list();
		for (PlattsSheet ps : plattsSheet) {
			System.out.println(ps.getPlattsSheetName()+"--"+ps.getPlattsSheetId());
		}
	}

	private static void readPSusingRestrictions(Session session) {
		//List contacts = session.createCriteria(Contact.class).list();
		//Query q = session.createQuery("from Contact u where u.firstname = :fname");
		//q.setString("fname", "siva");
		//List contacts = q.list();
		//Iterator<Contact> it = contacts.iterator();
		//while (it.hasNext()) {
		//	System.out.println("name.."+(it.next()).getFirstName());
		//}
		//String[] str = new String[] {"ONE","TWO"};

		List<String> str = new ArrayList<String>();
		str.add("ONE");
		str.add("TWO");
		str.add(null);str.add(null);
		List<PlattsSheet> plattsData = session.createCriteria(PlattsSheet.class)
		.add( Restrictions.in( "plattsSheetName", str)).list();
		for (PlattsSheet plattsSheet : plattsData) {
			System.out.println("INFO...."+plattsSheet.getPlattsSheetId()+  "---"+plattsSheet.getPlattsSheetName());
		}

		/*		paymentAuthorizationQuery.add(
		 * 		Restrictions.or(Restrictions.gt("paymentStartDate", ct.getOnlyReturnActiveSuppliersDate()),
		 *      Restrictions.and(Restrictions.le("paymentStartDate", ct.getOnlyReturnActiveSuppliersDate()), 
                Restrictions.or(Restrictions.lt("paymentStartDate",ct.getOnlyReturnActiveSuppliersDate()),Restrictions.isNull("paymentAuthorizationEndDate")) 
                 )));

                paymentaut1_.PAYMENT_START_DATE > to_date('04-04-2011','mm-dd-yyyy')  or
       			(paymentaut1_.PAYMENT_START_DATE <= to_date('04-04-2011','mm-dd-yyyy') and
       			paymentaut1_.PAYMENT_END_DATE < to_date('04-04-2011','mm-dd-yyyy') or  paymentaut1_.PAYMENT_END_DATE is null))
		 */
		System.out.println("QUERY  :"+plattsData.toString());
	}

	private static void readPSUsingCriteria(Session session) {
		List<PlattsSheet> plattsSheet = null;
		String string = "t*";
		Criteria plattsCriteria = session.createCriteria(PlattsSheet.class);  
		String plattsSheetName = string.replace('*', '%');
		Criteria parentVendorQuery = plattsCriteria.createCriteria("plattsPrices");
		plattsCriteria.add(Restrictions.ilike("plattsSheetName", plattsSheetName));
		parentVendorQuery.add(Restrictions.eq("plattsPriceId", Integer.valueOf(1)));
		plattsSheet  = plattsCriteria.list();
		for (PlattsSheet ps : plattsSheet) {
			System.out.println(ps.getPlattsSheetName()+"--"+ps.getPlattsSheetId());
		}
	}

	private static void insertPlattsSheet(Session session) {
		System.out.println("INSERT PLATTSSHEET.............");
		PlattsSheet plattsSheet = new PlattsSheet();
		plattsSheet.setPlattsSheetId(new Integer(105));
		plattsSheet.setPlattsSheetName("FIVE");
		//plattsSheet.setEffectiveDate(new Date());
		plattsSheet.setStatusTypeId("ACTIVE");

		Set<PlattsPrice> plattsPriceSet = new HashSet<PlattsPrice>();

		PlattsPrice plattsPrice1 = new PlattsPrice();
		//plattsPrice1.setPlattsPriceId(new Integer(new Integer(3)));
		plattsPrice1.setRegionTypeId(new Integer(new Integer(666)));
		plattsPrice1.setPriceHigh(new Integer(new Integer(10)));
		plattsPrice1.setPriceLow(new Integer(new Integer(20)));
		plattsPrice1.setPlattsSheet(plattsSheet);
		
		PlattsPrice plattsPrice2 = new PlattsPrice();
		//plattsPrice2.setPlattsPriceId(new Integer(new Integer(4)));
		plattsPrice2.setRegionTypeId(new Integer(new Integer(667)));
		plattsPrice2.setPriceHigh(new Integer(new Integer(20)));
		plattsPrice2.setPriceLow(new Integer(new Integer(30)));
		plattsPrice2.setPlattsSheet(plattsSheet);

		plattsPriceSet.add(plattsPrice1);
		plattsPriceSet.add(plattsPrice2);
		plattsSheet.setPlattsPrices(plattsPriceSet);

		session.save(plattsSheet);

		 
	
   
//		String insertStatement = "insert into PlattsSheet (plattsSheetId) select oo.plattsPriceId from PlattsPrice oo";   
//		session.createQuery( insertStatement ).executeUpate();   
//		tx.commit();   
//		session.close();
		

//		Query query = session.createQuery("from PlattsSheet where plattsSheetName = :id");
//		query.setParameter("id", "TWO");
//		List list = query.list();
//		System.out.println("SIZE>>>>>"+list.size());
	}

}

