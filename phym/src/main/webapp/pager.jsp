<%@ page language="java" pageEncoding="UTF-8"%>

   总共 ${pager.totalCount } 条记录，总共 ${pager.totalNo } 页，当前第${pager.currentNo}页 
           
   <c:if test="${pager.hasPrevious}">
	   <a href="${pager.path}&currentNo=1">      
	           首页  
	    </a> 
   </c:if>
   
   <c:if test="${!pager.hasPrevious}">
	           首页  
   </c:if>
   
   <c:if test="${pager.hasPrevious}">
	   <a href="${pager.path}&currentNo=${pager.currentNo - 1}">       
                  上一页  
       </a>
   </c:if>
   
   <c:if test="${!pager.hasPrevious}">
	         上一页
   </c:if>
             
             
  <c:if test="${pager.hasNext}">
     <a href="${pager.path}&currentNo=${pager.currentNo + 1}">下一页 </a>   
  </c:if>
  
  <c:if test="${!pager.hasNext}">
        下一页 
  </c:if>
  
  <c:if test="${pager.hasNext}">
     <a href="${pager.path}&currentNo=${pager.totalNo}">尾页</a>   
  </c:if>
  
  <c:if test="${!pager.hasNext}">
       尾页
  </c:if>   
