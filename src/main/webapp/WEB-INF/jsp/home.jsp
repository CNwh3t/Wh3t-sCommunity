<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@include file="header.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()
            +path+"/";
%>

<base href="<%=basePath%>"/>
<div id="main">


</div>


<div class="container" id="daily">
    <div class="jscroll-inner">
        <div class="daily">

            <h3 class="date">
                <i class="fa icon-calendar"></i>
                <span>每日消息</span>
                <small>2016-05-24</small>
            </h3>

            <c:forEach var="article" items="${list}">

                <div class="posts">
                    <div class="post">
                        <div class="votebar">
                            <button class="click-like up" aria-pressed="false" title="赞同"><i class="vote-arrow"></i><span class="count">39</span></button>
                            <button class="click-dislike down" aria-pressed="true" title="反对"><i class="vote-arrow"></i>
                            </button>
                        </div>
                        <div class="content" data-url="http://nowcoder.com/posts/5l3hjr">
                            <div class="content-img">
                                <c:set var="fileName" value="/images/img/downloadImages/reduceImages/"/>
                                <img src=${fileName}${article.localName} alt="${article.title}">
                            </div>
                            <div class="content-main">
                                <h3 class="title">
                                    <a target="_blank" rel="external nofollow" href=${article.link}>${article.title}</a>
                                </h3>
                                <div class="meta">
                                    ${article.link}&nbsp;
                                    <span>
                                                <i class="fa icon-comment"></i> 1
                                            </span>
                                </div>
                            </div>
                        </div>
                        <div class="user-info">
                            <div class="user-avatar">
                                <a href="#"><img width="32" class="img-circle" src="http://images.nowcoder.com/images/20141231/622873_1420036789276_622873_1420036771761_%E8%98%91%E8%8F%87.jpg@0e_200w_200h_0c_1i_1o_90Q_1x"></a>
                            </div>

                            <div class="info">
                                <h5>分享者</h5>

                                <a href="http://nowcoder.com/u/251205"><img width="48" class="img-circle" src="http://images.nowcoder.com/images/20141231/622873_1420036789276_622873_1420036771761_%E8%98%91%E8%8F%87.jpg@0e_200w_200h_0c_1i_1o_90Q_1x" alt="Thumb"></a>

                                <h4 class="m-b-xs">${article.author}</h4>
                                <a class="btn btn-default btn-xs" href="http://nowcoder.com/signin"><i class="fa icon-eye"></i> 关注TA</a>
                            </div>
                        </div>

                        <div class="subject-name">来自 <a href="http://nowcoder.com/subjects/127646">${article.author}</a></div>
                    </div>
                </div>
            </c:forEach>

        </div>
    </div>
</div>

<div class="container" id="daily">
    <div class="jscroll-inner">
        <div class="daily">

            <h3 class="date">
                <i class="fa icon-calendar"></i>
                <span>头条资讯</span>
                <small>2016-05-23</small>
            </h3>

            <div class="posts">
                <div class="post">
                    <div class="votebar">
                        <button class="click-like up" aria-pressed="false" title="赞同"><i class="vote-arrow"></i><span class="count">39</span></button>
                        <button class="click-dislike down" aria-pressed="true" title="反对"><i class="vote-arrow"></i>
                        </button>
                    </div>
                    <div class="content" data-url="http://nowcoder.com/posts/5l3hjr">
                        <div class="content-img">
                            <img src="https://images.nowcoder.com/images/20160621/5094668_1466479598631_7C2C60506876716CCF0E706DB13D4511@0e_100w_100h_0c_1i_1o_90Q_1x" alt="">
                        </div>
                        <div class="content-main">
                            <h3 class="title">
                                <a target="_blank" rel="external nofollow" href="http://nowcoder.com/j/5l3hjr">高性能服务器架构思路</a>
                            </h3>
                            <div class="meta">
                                wetest.qq.com&nbsp;
                                <span>
                                            <i class="fa icon-comment"></i> 1
                                        </span>
                            </div>
                        </div>
                    </div>
                    <div class="user-info">
                        <div class="user-avatar">
                            <a href="http://nowcoder.com/u/251205"><img width="32" class="img-circle" src="http://images.nowcoder.com/images/20141231/622873_1420036789276_622873_1420036771761_%E8%98%91%E8%8F%87.jpg@0e_200w_200h_0c_1i_1o_90Q_1x"></a>
                        </div>

                        <div class="info">
                            <h5>分享者</h5>

                            <a href="http://nowcoder.com/u/251205"><img width="48" class="img-circle" src="http://images.nowcoder.com/images/20141231/622873_1420036789276_622873_1420036771761_%E8%98%91%E8%8F%87.jpg@0e_200w_200h_0c_1i_1o_90Q_1x" alt="Thumb"></a>

                            <h4 class="m-b-xs">冰燕</h4>
                            <a class="btn btn-default btn-xs" href="http://nowcoder.com/signin"><i class="fa icon-eye"></i> 关注TA</a>
                        </div>
                    </div>

                    <div class="subject-name">来自 <a href="http://nowcoder.com/subjects/127646">腾讯质量开放平台</a></div>
                </div>

                <div class="alert alert-warning subscribe-banner" role="alert">
                    《头条八卦》日报，每日 Top 3 通过邮件发送给你。      <a class="btn btn-info btn-sm pull-right" href="http://nowcoder.com/account/settings">立即订阅</a>
                </div>
            </div>
        </div>
    </div>
</div>

</div>


<c:if test="${not empty pop}">
<script>
    window.loginpop = ${pop};
</script>
<script type="text/javascript" src="/scripts/main/site/home.js"></script>
</c:if>

<%@include file="footer.jsp"%>