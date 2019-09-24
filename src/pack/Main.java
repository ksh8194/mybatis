package pack;

import java.util.List;

public class Main {
	public static void main(String[] args) {
//		ProcessDao dao = new ProcessDao();
//		ProcessDao dao2 = new ProcessDao();
//		System.out.println(dao,dao2);
		
		ProcessDao dao = ProcessDao.getInstance();
		
		ProcessDao dao2 = ProcessDao.getInstance();
		System.out.println(dao+" "+dao2);
		
		try {
			System.out.println("자료 추가.............");
			ProductBean bean = new ProductBean();
			bean.setCode("5");
			bean.setSang("아메리카노");
			bean.setSu("10");
			bean.setDan("5000");
			
			
			System.out.println("전체자료 출력.........");
			List<ProductBean> list = dao.selectdataAll();
			for(ProductBean s:list) {
				System.out.println(s.getCode()+" "+s.getSang()+" "+s.getSu()+" "+s.getDan());
			}
			
			System.out.println("부분자료 출력.............");
			ProductBean bean2 = dao.selectData("1");
			System.out.println(bean2.getCode() + " " + bean.getSang()+ " "+ bean.getSu() + " " + bean.getDan());
		} catch (Exception e) {
			System.out.println("err :"+e);
		}
	}

}
