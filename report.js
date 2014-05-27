var path="http://127.0.0.1:88/resources/";

var run_stamp="20140228041020";

// jsontext =  ajax 请求: http://10.73.72.122:8080/Report/go?run_stamp=20140228041020

var jsontext = 
'{"run_stamp":"20140302023811","result":[{"img_timestamp":["20140302023910","20140302023916","20140302023927","20140302023933","20140302023945","20140302023954","20140302024131","20140302024137","20140302024410","20140302024419","20140302024727","20140302024736","20140302024749","20140302024755","20140302024801","20140302024811"],"device_id":["0123456789ABCDEF"],"url":["http://m.etao.com/","http://m.etao.com/","http://m.etao.com/#!free99.php","http://m.etao.com/#!entry.php","http://m.etao.com/#!free99.php","http://m.etao.com/#!free99.php","http://m.etao.com/","http://m.etao.com/#!search_index.php","http://m.etao.com/","http://m.etao.com/#!search_index.php","http://m.etao.com/","http://m.etao.com/","http://wapa.etao.com/#!search_index.php","http://wapa.etao.com/#!search_index.php","http://wapa.etao.com/#!search_index.php","http://wapa.etao.com/#!search.php?q\u003diphone5s"],"img_name":["httpm.etao.com_20140302023910.jpeg","httpm.etao.com_20140302023916.jpeg","httpm.etao.comfree99.php_20140302023927.jpeg","httpm.etao.comentry.php_20140302023933.jpeg","httpm.etao.comfree99.php_20140302023945.jpeg","httpm.etao.comfree99.php_20140302023954.jpeg","httpm.etao.com_20140302024131.jpeg","httpm.etao.comsearch_index.php_20140302024137.jpeg","httpm.etao.com_20140302024410.jpeg","httpm.etao.comsearch_index.php_20140302024419.jpeg","httpm.etao.com_20140302024727.jpeg","httpm.etao.com_20140302024736.jpeg","httpwapa.etao.comsearch_index.php_20140302024749.jpeg","httpwapa.etao.comsearch_index.php_20140302024755.jpeg","httpwapa.etao.comsearch_index.php_20140302024801.jpeg","httpwapa.etao.comsearch.phpq\u003diphone5s_20140302024811.jpeg"]},{"img_timestamp":["20140302024112","20140302024118","20140302024346","20140302024354","20140302024702","20140302024711"],"device_id":["015d2ea4875ff60a_MTPADB"],"url":["http://m.etao.com/","http://m.etao.com/#!search_index.php","http://m.etao.com/","http://m.etao.com/#!search_index.php","http://m.etao.com/","http://m.etao.com/#!search_index.php"],"img_name":["httpm.etao.com_20140302024112.jpeg","httpm.etao.comsearch_index.php_20140302024118.jpeg","httpm.etao.com_20140302024346.jpeg","httpm.etao.comsearch_index.php_20140302024354.jpeg","httpm.etao.com_20140302024702.jpeg","httpm.etao.comsearch_index.php_20140302024711.jpeg"]},{"img_timestamp":["20140302023811","20140302023821","20140302024030","20140302024037","20140302024214","20140302024224","20140302024238","20140302024245","20140302024253","20140302024304","20140302024537","20140302024547"],"device_id":["022GPLDU3B002044"],"url":["http://m.etao.com/","http://m.etao.com/#!search_index.php","http://m.etao.com/","http://m.etao.com/#!search_index.php","http://m.etao.com/","http://m.etao.com/","http://wapa.etao.com/#!search_index.php","http://wapa.etao.com/#!search_index.php","http://wapa.etao.com/#!search_index.php","http://wapa.etao.com/#!search.php?q\u003diphone5s","http://m.etao.com/","http://m.etao.com/#!search_index.php"],"img_name":["httpm.etao.com_20140302023811.jpeg","httpm.etao.comsearch_index.php_20140302023821.jpeg","httpm.etao.com_20140302024030.jpeg","httpm.etao.comsearch_index.php_20140302024037.jpeg","httpm.etao.com_20140302024214.jpeg","httpm.etao.com_20140302024224.jpeg","httpwapa.etao.comsearch_index.php_20140302024238.jpeg","httpwapa.etao.comsearch_index.php_20140302024245.jpeg","httpwapa.etao.comsearch_index.php_20140302024253.jpeg","httpwapa.etao.comsearch.phpq\u003diphone5s_20140302024304.jpeg","httpm.etao.com_20140302024537.jpeg","httpm.etao.comsearch_index.php_20140302024547.jpeg"]},{"img_timestamp":["20140302023839","20140302023846","20140302024051","20140302024058","20140302024317","20140302024328","20140302024604","20140302024613","20140302024626","20140302024632","20140302024638","20140302024649"],"device_id":["351BBHJN6LVP"],"url":["http://m.etao.com/","http://m.etao.com/#!search_index.php","http://m.etao.com/","http://m.etao.com/#!search_index.php","http://m.etao.com/","http://m.etao.com/#!search_index.php","http://m.etao.com/","http://m.etao.com/","http://wapa.etao.com/#!search_index.php","http://wapa.etao.com/#!search_index.php","http://wapa.etao.com/#!search_index.php","http://wapa.etao.com/#!search.php?q\u003diphone5s"],"img_name":["httpm.etao.com_20140302023839.jpeg","httpm.etao.comsearch_index.php_20140302023846.jpeg","httpm.etao.com_20140302024051.jpeg","httpm.etao.comsearch_index.php_20140302024058.jpeg","httpm.etao.com_20140302024317.jpeg","httpm.etao.comsearch_index.php_20140302024328.jpeg","httpm.etao.com_20140302024604.jpeg","httpm.etao.com_20140302024613.jpeg","httpwapa.etao.comsearch_index.php_20140302024626.jpeg","httpwapa.etao.comsearch_index.php_20140302024632.jpeg","httpwapa.etao.comsearch_index.php_20140302024638.jpeg","httpwapa.etao.comsearch.phpq\u003diphone5s_20140302024649.jpeg"]},{"img_timestamp":["20140302024009","20140302024015","20140302024153","20140302024159","20140302024437","20140302024446","20140302024501","20140302024507","20140302024513","20140302024523","20140302024826","20140302024835","20140302024848","20140302024854","20140302024900","20140302024910"],"device_id":["Coolpad5890-a1a1314a"],"url":["http://m.etao.com/","http://m.etao.com/#!search_index.php","http://m.etao.com/","http://m.etao.com/#!search_index.php","http://m.etao.com/","http://m.etao.com/","http://wapa.etao.com/#!search_index.php","http://wapa.etao.com/#!search_index.php","http://wapa.etao.com/#!search_index.php","http://wapa.etao.com/#!search.php?q\u003diphone5s","http://m.etao.com/","http://m.etao.com/","http://wapa.etao.com/#!search_index.php","http://wapa.etao.com/#!search_index.php","http://wapa.etao.com/#!search_index.php","http://wapa.etao.com/#!search.php?q\u003diphone5s"],"img_name":["httpm.etao.com_20140302024009.jpeg","httpm.etao.comsearch_index.php_20140302024015.jpeg","httpm.etao.com_20140302024153.jpeg","httpm.etao.comsearch_index.php_20140302024159.jpeg","httpm.etao.com_20140302024437.jpeg","httpm.etao.com_20140302024446.jpeg","httpwapa.etao.comsearch_index.php_20140302024501.jpeg","httpwapa.etao.comsearch_index.php_20140302024507.jpeg","httpwapa.etao.comsearch_index.php_20140302024513.jpeg","httpwapa.etao.comsearch.phpq\u003diphone5s_20140302024523.jpeg","httpm.etao.com_20140302024826.jpeg","httpm.etao.com_20140302024835.jpeg","httpwapa.etao.comsearch_index.php_20140302024848.jpeg","httpwapa.etao.comsearch_index.php_20140302024854.jpeg","httpwapa.etao.comsearch_index.php_20140302024900.jpeg","httpwapa.etao.comsearch.phpq\u003diphone5s_20140302024910.jpeg"]}]}';
 

/********************************************************************************************************************/
 
var report=JSON.parse(jsontext);
// alert(report.run_stamp);
// alert(report.result.length);
// alert(report.result[0].img_timestamp.length);
// alert(report.result[0].url[0]);
// alert(report.result[0].device_id);

var bodyContent="<table style=\"table-layout:fixed\" border=\"0\">";
/*表格总开始*/

// 遍历DeviceID
for (var i = 0; i < report.result.length; i++) {

	bodyContent=bodyContent+"<tr><th width=\"80\" scope=\"col\">deviceId/urls</th>";
	for (var j = 0; j < report.result[i].img_timestamp.length; j++) {
		
		bodyContent = bodyContent+"<th style=\"word-break : break-all; overflow:hidden;\" width=\"100\" scope=\"col\">"+report.result[i].url[j]+"</th>";
		
	}

	bodyContent = bodyContent+"</tr>";
		/*以上是urls行*/

		/*下面是imgsrc行*/
	bodyContent = bodyContent+ "<tr><th scope=\"row\">"+report.result[i].device_id + "</th>";
	for (var j = 0; j < report.result[i].img_timestamp.length; j++) {
			bodyContent = bodyContent+ "<td><img src=\"" + path+report.run_stamp+"/"+report.result[i].device_id+"/"+report.result[i].img_name[j]+ "\" width=\"200\" height=\"300\"></td>";
	}
	bodyContent = bodyContent+"</tr>";	
};



/********************************************************************************************************************/

/*总表格结束*/

bodyContent=bodyContent+"</table>";

/*输出总的报告*/

document.write("<html><head><title>适配测试报告 " + report.run_stamp + "</title></head><body>" + bodyContent);
document.write("</body></html>");
 
 