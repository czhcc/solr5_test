# solr5_test

sharedTo:"foo" OR sharedTo:"bar"
sharedTo IN ('foo', 'bar')
sharedTo:('foo' 'bar')

org.apache.solr.client.solrj.impl.HttpSolrClient$RemoteSolrException: Error from server at http://192.168.0.239:8983/solr/db1: Expected mime type application/octet-stream but got text/html. <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<title>Error 500 Server Error</title>
</head>
<body><h2>HTTP ERROR 500</h2>
<p>Problem accessing /solr/db1/select. Reason:
<pre>    Server Error</pre></p><h3>Caused by:</h3><pre>java.lang.OutOfMemoryError: Java heap space
	at java.util.Arrays.copyOf(Arrays.java:2319)
	at org.apache.solr.search.SolrIndexSearcher.getDocSet(SolrIndexSearcher.java:1221)
	at org.apache.solr.search.JoinQuery$JoinQueryWeight.getDocSet(JoinQParserPlugin.java:456)
	at org.apache.solr.search.JoinQuery$JoinQueryWeight.scorer(JoinQParserPlugin.java:306)
	at org.apache.lucene.search.Weight.bulkScorer(Weight.java:127)
	at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:711)
	at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:428)
	at org.apache.solr.search.SolrIndexSearcher.buildAndRunCollectorChain(SolrIndexSearcher.java:201)
	at org.apache.solr.search.SolrIndexSearcher.getDocListNC(SolrIndexSearcher.java:1660)
	at org.apache.solr.search.SolrIndexSearcher.getDocListC(SolrIndexSearcher.java:1479)
	at org.apache.solr.search.SolrIndexSearcher.search(SolrIndexSearcher.java:556)
	at org.apache.solr.handler.component.QueryComponent.process(QueryComponent.java:518)
	at org.apache.solr.handler.component.SearchHandler.handleRequestBody(SearchHandler.java:222)
	at org.apache.solr.handler.RequestHandlerBase.handleRequest(RequestHandlerBase.java:143)
	at org.apache.solr.core.SolrCore.execute(SolrCore.java:1984)
	at org.apache.solr.servlet.SolrDispatchFilter.execute(SolrDispatchFilter.java:829)
	at org.apache.solr.servlet.SolrDispatchFilter.doFilter(SolrDispatchFilter.java:446)
	at org.apache.solr.servlet.SolrDispatchFilter.doFilter(SolrDispatchFilter.java:220)
	at org.eclipse.jetty.servlet.ServletHandler$CachedChain.doFilter(ServletHandler.java:1419)
	at org.eclipse.jetty.servlet.ServletHandler.doHandle(ServletHandler.java:455)
	at org.eclipse.jetty.server.handler.ScopedHandler.handle(ScopedHandler.java:137)
	at org.eclipse.jetty.security.SecurityHandler.handle(SecurityHandler.java:557)
	at org.eclipse.jetty.server.session.SessionHandler.doHandle(SessionHandler.java:231)
	at org.eclipse.jetty.server.handler.ContextHandler.doHandle(ContextHandler.java:1075)
	at org.eclipse.jetty.servlet.ServletHandler.doScope(ServletHandler.java:384)
	at org.eclipse.jetty.server.session.SessionHandler.doScope(SessionHandler.java:193)
	at org.eclipse.jetty.server.handler.ContextHandler.doScope(ContextHandler.java:1009)
	at org.eclipse.jetty.server.handler.ScopedHandler.handle(ScopedHandler.java:135)
	at org.eclipse.jetty.server.handler.ContextHandlerCollection.handle(ContextHandlerCollection.java:255)
	at org.eclipse.jetty.server.handler.HandlerCollection.handle(HandlerCollection.java:154)
	at org.eclipse.jetty.server.handler.HandlerWrapper.handle(HandlerWrapper.java:116)
	at org.eclipse.jetty.server.Server.handle(Server.java:368)
</pre>
<hr /><i><small>Powered by Jetty://</small></i><br/>                                                
<br/>                                                
<br/>                                                
<br/>                                                
<br/>                                                
<br/>                                                
<br/>                                                
<br/>                                                
<br/>                                                
<br/>                                                
<br/>                                                
<br/>                                                
<br/>                                                
<br/>                                                
<br/>                                                
<br/>                                                
<br/>                                                
<br/>                                                
<br/>                                                
<br/>                                                

</body>
</html>

	at org.apache.solr.client.solrj.impl.HttpSolrClient.executeMethod(HttpSolrClient.java:525)
	at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:233)
	at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:225)
	at org.apache.solr.client.solrj.SolrRequest.process(SolrRequest.java:135)
	at org.apache.solr.client.solrj.SolrClient.query(SolrClient.java:943)
	at org.apache.solr.client.solrj.SolrClient.query(SolrClient.java:958)
	at solr.join.ZjhmJoin.join(ZjhmJoin.java:33)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:47)
	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:44)
	at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
	at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:271)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:70)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:50)
	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:238)
	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:63)
	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:236)
	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:53)
	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:229)
	at org.junit.runners.ParentRunner.run(ParentRunner.java:309)
	at org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:50)
	at org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:467)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:683)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:390)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:197)


