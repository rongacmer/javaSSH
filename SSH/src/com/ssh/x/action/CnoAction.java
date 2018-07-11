package com.ssh.x.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssh.util.JSON;
import com.ssh.x.entity.Cno;
import com.ssh.x.page.cnopage;
import com.ssh.x.service.CnoService;

@Component("cnobean")
public class CnoAction  extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private CnoService cnoservice;
	private Cno cno;
	
	public CnoService getCnoservice() {
		return cnoservice;
	}
	public void setCnoservice(CnoService cnoservice) {
		this.cnoservice = cnoservice;
	}
	public Cno getCno() {
		return cno;
	}
	public void setCno(Cno cno) {
		this.cno = cno;
	}
	public String output() throws Exception{
		cnopage page = cnoservice.show();
		this.writeJson(page);
		return null;
	}
	public String del() throws Exception{
		System.out.println(cno.getTno());
		cnoservice.del(cno);
		return null;
	}
	public String add() throws Exception{
//		System.out.println(stu.getId());
		JSON json=new JSON();
		cno.setFlag(0);
		try {
			if(cnoservice.add(cno))
			{
				json.setSuccess(true);
				json.setMsg("增加成功");
			}
			else 
			{
				json.setSuccess(false);
				json.setMsg("增加失败");
			}
		
		}catch(Exception e) {
			json.setSuccess(false);
			json.setMsg("增加失败");
		}
		super.writeJson(json);
		return null;
	}
	public String update() throws Exception{
		System.out.println(cno.getTno());
		JSON json=new JSON();
		try {
			if(cnoservice.update(cno))
			{
				json.setSuccess(true);
				json.setMsg("修改成功");
			}
			else 
			{
				json.setSuccess(false);
				json.setMsg("修改失败");
			}
		
		}catch(Exception e) {
			json.setSuccess(false);
			json.setMsg("修改失败");
		}
		super.writeJson(json);
		return null;
	}
}
