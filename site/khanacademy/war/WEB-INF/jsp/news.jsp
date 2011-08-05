<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>Khan Academy Israel</title>

<link rel="stylesheet" type="text/css" href="/files/css/main.css"
	media="all" />
<link rel="stylesheet" type="text/css" href="/files/css/layout.css"
	media="all" />

<script type="text/javascript"
	src="https://www.google.com/jsapi?key=ABQIAAAAO3wpC0uwj5Q1sMGWhHs7LxSpY6j3JegbGxS1auK978Lba2TfJRR_ua4aguukER9HuzxBWfAJIF5Yzg"></script>

<script type="text/javascript">
	google.load("feeds", "1");
	google.load("jquery", "1.6.2");

	google.setOnLoadCallback(OnLoad);

	// Our callback function, for when a feed is loaded.
	function feedLoaded(result) {
		if (!result.error) {
			// Grab the container we will put the results into
			var container = $('#news_board');
			container.innerHTML = '';
			// Loop through the feeds, putting the titles onto the page.
			// Check out the result object for a list of properties returned in each entry.
			for ( var i = 0; i < result.feed.entries.length; i++) {
				var entry = result.feed.entries[i];
				var itemWrapper = container.append('<div class="news_item wrapper">').children().slice(i,i+1);
				itemWrapper.append('<span class="news_item title">' + entry.title + '</span>');
				itemWrapper.append('<div class="news_item content">' + entry.content + '</div>');
				itemWrapper.append('<span class="news_item meta">פורסם בתאריך ' + entry.publishedDate + ' </span>');
				itemWrapper.append('<span class="news_item meta">ע"י ' + entry.author + '</span><br>');
				container.append('</div>');
				
			}
		}
	}

	function OnLoad() {
		// Create a feed instance that will grab Digg's feed.
		var feed = new google.feeds.Feed("http://kap-il.blogspot.com/feeds/posts/default");
		feed.setNumEntries(5);

		// Calling load sends the request off.  It requires a callback function.
		feed.load(feedLoaded);
	}
</script>

</head>

<body>
	<div class="wrapper">
		<jsp:include page="nojs.jsp" />
		<!-- HEADER -->
		<jsp:include page="header.jsp"></jsp:include>
		<!-- MAIN -->
		<div class="main">
			<div id="news_board"></div>
			<a href="http://kap-il.blogspot.com/">לארכיון החדשות...</a>
		</div>

		<!-- FOOTER -->
		<jsp:include page="footer.jsp"></jsp:include>

	</div>

</body>
</html>
