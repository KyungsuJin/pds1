package com.test.mall1.item.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
	@Autowired
	private ItemDao itemDao;
	private static final Logger logger = LoggerFactory.getLogger(ItemService.class);
	
	/*public Member getMemberById(Member meber) {
		return itemDao.selectMemberById(member);
	}*/
	
	//Map<key 값 string, object 다형성> 
	public Map<String,Object> getItemList(int currentPage,int pagePerRow){
		Map<String,Integer> map = new HashMap<String,Integer>();
		//currentPage 현재페이지  pagePerRow 10개씩보기
		int beginRow = (currentPage-1)*pagePerRow;
		//beginRow LIMIT 에 첫번쨰값구하기 0번째 에서 10개보여준다 10번쨰에서 10개보여준다
		// 현재페이지 -1 * 10
		map.put("beginRow", beginRow);
		map.put("pagePerRow", pagePerRow);
		
		List<Item> list =itemDao.selectItemList(map);
		//게시글의 총 갯수를 구하는..total 에 41개가 들어왔따고 가정
		int total = itemDao.totalCountMember();
		//total,pagePerRow ->lastPage 알고리즘
		int lastPage=0;
		//만약 totla=41 과 pagePerRow =10 를 나눠 나머지가 0이라면 그치만 1이다 그러므로 else
		if(total%pagePerRow==0) {
			lastPage=total/pagePerRow;
		}else {
			//lastPage 가 현재는 0 total=41 / 10 = 4 +1 = 5
			//10개씩 보기로 했기때문에  lastPage 는 5 
			lastPage=total/pagePerRow+1;
		}
		Map<String,Object> returnMap = new HashMap<String,Object>();
		returnMap.put("list", list);//리스트를 map 에답는다 .
		returnMap.put("total", lastPage);//마지막페이지를 map 에담는다
		return returnMap;
	}
	
	public int addItem(Item item) {
		logger.info("ItemService 의 addItem 메서드 실행");
		int row =itemDao.insertItem(item);
		return row;
	}
}
