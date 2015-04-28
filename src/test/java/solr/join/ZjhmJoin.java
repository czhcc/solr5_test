/**
 * 
 */
package solr.join;

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
public class ZjhmJoin
{
	@Test
	public void join() throws Exception
	{
		String urlString = "http://192.168.0.239:8983/solr/db1";
		SolrClient solr = new HttpSolrClient(urlString);
		
		long start = System.currentTimeMillis();
		SolrQuery parameters = new SolrQuery();
		parameters.set("q","{!join from=zjhm fromIndex=db2 to=zjhm}*:*");
//		parameters.set("fq","!join fromIndex=db1 toIndex=db2 from=zjhm to=zjhm");
//		parameters.addFacetQuery("!join from=name to=name fromIndex=db2");
		QueryResponse response = solr.query(parameters);
		SolrDocumentList list = response.getResults();
		if(!list.isEmpty())
		{
			/*ListIterator<SolrDocument> listIterator = list.listIterator();
			while(listIterator.hasNext())
			{
				SolrDocument doc = listIterator.next();
				System.out.println(doc.get("id"));
				System.out.println(doc.get("name"));
				System.out.println(doc.get("zjhm"));
			}*/
			System.out.println("size=" + list.getNumFound());
		}
		long end = System.currentTimeMillis();
		System.out.println("time:" + (end-start) + "ms");
		
		solr.close();
	}
}
