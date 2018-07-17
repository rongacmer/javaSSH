package com.weibo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.weibo.dao.BaseDAO;
import com.weibo.dao.CommentDAO;
import com.weibo.entity.Comments;
import com.weibo.util.Commentpage;

public class CommentServiceimp extends BaseDAO implements CommentService {

	CommentDAO commentdao;
	List<Commentpage> list;
	
	public CommentDAO getCommentdao() {
		return commentdao;
	}
	public void setCommentdao(CommentDAO commentdao) {
		this.commentdao = commentdao;
	}
	public List<Commentpage> getList() {
		return list;
	}
	public void setList(List<Commentpage> list) {
		this.list = list;
	}
	public int findComment(int from,String type,Comments c,String Author){
		List<Comments> lis = commentdao.find(from, type);
		int sum = 0;
		Iterator it = lis.iterator();
		while(it.hasNext()){
			Comments c2 = (Comments) it.next();
			String author = null;
			if(c != null)
				author = c.getAuthor();
			sum+=this.findComment(c2.getId(),"comment",c2,author);
		}
		if(type.equals("comment")){
			Commentpage newitem = new Commentpage(sum,c,Author);
			list.add(newitem);
		}
		return sum+1;
	}
	@Override
	public List<Commentpage> showComment(int from) {
		// TODO Auto-generated method stub
		list = new ArrayList<Commentpage>();
		this.findComment(from, "weibo", null,null);
//		List<Comments> lis = commentdao.find(from, "weibo");
//		Iterator it = lis.iterator();
//		while(it.hasNext()){
//			Comments c2 = (Comments) it.next();
//			Commentpage newitem = new Commentpage(lis.size(),c2,Integer.valueOf(from).toString());
//			list.add(newitem);
//		}
		Collections.sort(list);
		return list;
	}

	@Override
	public void addComment(Comments c) {
		// TODO Auto-generated method stub
		
	}

}
