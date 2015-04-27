/**
 * 
 */
package solr.index;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author czhcc
 *
 */
public class CreateIndex {
	
	private String readFile(File file) throws Exception
	{
		InputStream is = new FileInputStream(file);
		int length = is.available();
		byte[] data = new byte[length];
		is.read(data);
		is.close();
		String result = new String(data);
		
		return result;
	}
	
	@Test
	public void createFileIndex() throws Exception
	{
		String urlString = "http://localhost:8983/solr/myindex";
		SolrClient solr = new HttpSolrClient(urlString);
		
		File dir = new File("D:\\works\\index_file1");
		int id = 0;
		for(File file :dir.listFiles())
		{
			String content = readFile(file);
			String name = file.getName();
			String path = file.getCanonicalPath();
			System.out.println(path);
			
			SolrInputDocument document = new SolrInputDocument();
			document.addField("id", id++);
			document.addField("name", name);
			document.addField("path", path);
			document.addField("content", content);
			UpdateResponse response = solr.add(document);
		}
		solr.commit();
		
		solr.close();
	}

	@Ignore
	@Test
	public void createIndex() throws Exception
	{
		String urlString = "http://localhost:8983/solr/myindex";
		SolrClient solr = new HttpSolrClient(urlString);
		
		SolrInputDocument document = new SolrInputDocument();
		document.addField("id", "552199");
		document.addField("name", "Gouda cheese wheel");
		document.addField("path", "d:/def/abc.txt");
		document.addField("content", "dkdkdkk dkdk dkdkd dkdkei ");
		UpdateResponse response = solr.add(document);
		System.out.println(response.getStatus());
		 
		solr.commit();
		solr.close();
	}
}
