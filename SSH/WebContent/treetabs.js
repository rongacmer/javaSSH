/**
 * 
 */
$(function () {
    //动态树形菜单数据
    var treeData = [{
    	  text : "学生管理",
    		  attributes:{
            	  url:'manager!M_student.action'
              }
              },{
                  text : "教师管理",
                  attributes:{
                	  url:'manager!M_teacher.action'
                  }
              },
              {
            	  text:"课程管理",
            	  attributes:{
                	  url:'manager!M_course.action'
                  }
              },
              {
            	  text:"学生选课",
            	  attributes:{
            		  url:'manager!M_selectcourse.action'
            	  }
              }
          ];
    //实例化树形菜单
    $("#tree").tree({
        data : treeData,
        lines : false,
        onClick : function (node) {
        	if(node.attributes)
        		{
        		 	Open(node.text,node.attributes.url);
        		}
        }
    });
    //在右边center区域打开菜单，新增tab
    function Open(text, url) {
        if ($("#tabs").tabs('exists', text)) {
            $('#tabs').tabs('select', text);
        } else {
        	var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>'; 
            $('#tabs').tabs('add', {
                title : text,
                closable : true,
                content :content
            })
        }
    }
});