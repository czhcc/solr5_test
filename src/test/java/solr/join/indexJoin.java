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
public class indexJoin
{
	/**
	 * 创建两个core，分别为db1和db2，两个都有name字段
	 * select db1.name from db1 join db2 on (db1.name=db2.name)
	 * 
	 * @throws Exception
	 */
	@Test
	public void join() throws Exception
	{
		//http://localhost:3033/solr/QUESTINORE/select?q={!join from=LoadID+to=LoadID+fromIndex=LOAD}DataStreamSubType:34sdf&fq=SourceID:1
		String urlString = "http://localhost:8983/solr/db1";
		SolrClient solr = new HttpSolrClient(urlString);
		
		SolrQuery parameters = new SolrQuery();
		parameters.set("q","*");
		parameters.addFacetQuery("!join from=name fromIndex=db2 to=name");
		QueryResponse response = solr.query(parameters);
		SolrDocumentList list = response.getResults();
		if(!list.isEmpty())
		{
			ListIterator<SolrDocument> listIterator = list.listIterator();
			while(listIterator.hasNext())
			{
				SolrDocument doc = listIterator.next();
				System.out.println(doc.get("id"));
				System.out.println(doc.get("name"));
			}
		}
		
		solr.close();
	}
}
