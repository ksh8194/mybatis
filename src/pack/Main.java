package pack;

import java.util.List;

public class Main {
	public static void main(String[] args) {
//		ProcessDao dao = new ProcessDao();
//		ProcessDao dao2 = new ProcessDao();
//		System.out.println(dao,dao2);

		ProcessDao dao = ProcessDao.getInstance();

		ProcessDao dao2 = ProcessDao.getInstance();
		System.out.println(dao + " " + dao2);

		try {
//			System.out.println("자료 추가.............");
//			ProductBean bean = new ProductBean();
//			bean.setCode("6");
//			bean.setSang("오렌지");
//			bean.setSu("10");
//			bean.setDan("5000");
//			dao.insertData(bean);
//
//			System.out.println("자료 수정.............");
//			ProductBean bean = new ProductBean();
//			bean.setCode("6");
//			bean.setSang("홍차");
//			dao.updateData(bean);
//			
////			
			

			System.out.println("자료 삭제................");
			boolean result = dao.delData(6);
			if(result)
				System.out.println("삭제 성공");
			else
				System.out.println("삭제 실패");
			

			System.out.println("전체자료 출력.........");
			List<ProductBean> list = dao.selectdataAll();
			for (ProductBean s : list) {
				System.out.println(s.getCode() + " " + s.getSang() + " " + s.getSu() + " " + s.getDan());
			}

			System.out.println("부분자료 출력.............");
			ProductBean bean2 = dao.selectData("1");
			System.out.println(bean2.getCode() + " " + bean2.getSang() + " " + bean2.getSu() + " " + bean2.getDan());
		} catch (Exception e) {
			System.out.println("err :" + e);
		}
	}

}
