<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
<div class="page-bar">
	<c:if test="${currPageNo>1}">
		<a href="javascript:page_nav(${param.formName},1);">首页</a>
		<a href="javascript:page_nav(${param.formName},<c:out value="${currPageNo-1}"/>);">上一页</a>
	</c:if>
	<c:if test="${currPageNo<=1}">
		首页&nbsp;&nbsp;上一页
	</c:if>
	<c:if test="${currPageNo<param.totalPage}">
		<a href="javascript:page_nav(${param.formName},<c:out value="${currPageNo+1}" />);">下一页</a>
		<a href="javascript:page_nav(${param.formName},<c:out value="${param.totalPage}"/>);">最后一页</a>
	</c:if>
	<c:if test="${currPageNo>=param.totalPageCount}">
		下一页&nbsp;&nbsp;尾页
	</c:if>&nbsp;&nbsp;
	&nbsp;&nbsp;第 ${currPageNo}页/共${param.totalPage}页&nbsp;&nbsp;共${param.totalCount }条记录
</div>