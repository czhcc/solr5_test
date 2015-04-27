/**
 * 
 */
package solr.index;

import java.util.ListIterator;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.junit.Test;

/**
 * @author czhcc
 *
 */
public class QueryIndex
{
	@Test
	public void queryIndex() throws Exception
	{
		String urlString = "http://localhost:8983/solr/myindex";
		SolrClient solr = new HttpSolrClient(urlString);
		
		SolrQuery parameters = new SolrQuery();
		parameters.set("q", "美国");
		QueryResponse response = solr.query(parameters);
		SolrDocumentList list = response.getResults();
		if(!list.isEmpty())
		{
			ListIterator<SolrDocument> listIterator = list.listIterator();
			while(listIterator.hasNext())
			{
				SolrDocument doc = listIterator.next();
				System.out.println(doc.get("id"));
				System.out.println(doc.get("path"));
			}
		}
		
		solr.close();
	}
}
