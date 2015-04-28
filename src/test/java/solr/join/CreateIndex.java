/**
 * 
 */
package solr.join;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

/**
 * @author czhcc
 *
 */
public class CreateIndex
{
	@Test
	public void createDb1Index() throws Exception
	{
		String urlString = "http://localhost:8983/solr/db1";
		SolrClient solr = new HttpSolrClient(urlString);
		
		for(int i=0;i<100;i++)
		{
			SolrInputDocument document = new SolrInputDocument();
			document.addField("id", Integer.toString(i));
			document.addField("name", "name" + i);
			document.addField("zjhm", "zjhm" + i);
			UpdateResponse response = solr.add(document);
		}
		 
		solr.commit();
		solr.close();
	}
	
	@Test
	public void createDb2Index() throws Exception
	{
		String urlString = "http://localhost:8983/solr/db2";
		SolrClient solr = new HttpSolrClient(urlString);
		
		for(int i=0;i<10;i++)
		{
			SolrInputDocument document = new SolrInputDocument();
			document.addField("id", Integer.toString(i));
			document.addField("name", "name" + i);
			document.addField("zjhm", "zjhm" + i);
			UpdateResponse response = solr.add(document);
		}
		 
		solr.commit();
		solr.close();
	}
}
