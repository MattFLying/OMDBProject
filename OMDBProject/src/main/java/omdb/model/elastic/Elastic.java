package omdb.model.elastic;

import java.net.InetAddress;
import java.net.UnknownHostException;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

public class Elastic {
	private TransportClient client;
	
	
	public Elastic() {
		initialize();
	}
	
	
	private void initialize() {
		try {
			this.client = TransportClient.builder().build()
					.addTransportAddress(
							new InetSocketTransportAddress(
									InetAddress.getByName("localhost"), 9300
							)
			);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	public TransportClient getClient() {
		return client;
	}
	public void createIndexRequest(String index, String type, int id, String json) {
		IndexRequest indexRequest = new IndexRequest(index, type, String.valueOf(id));
		indexRequest.source(json);
		IndexResponse response = client.index(indexRequest).actionGet();
	}
}