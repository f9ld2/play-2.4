package utils;

import org.apache.http.client.utils.URIBuilder;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import play.mvc.Http;
import play.Play;

@SuppressWarnings("deprecation")
public class Pager {
	private int page;

    private int pageSize;

    private int pageCount;
    
    private int totalCount;
    
    private int frameSize = 5;
    
    private int firstRow;
    
    private int lastRow;
    
    private int start;
    
    private int end;
    
	public Pager(int page, int totalCount) {
        this.init(
    		page, 
    		totalCount, 
    		Play.application().configuration().getInt("setting.pageSize"), 
    		Play.application().configuration().getInt("setting.frameSize")
		);
	}
	
	public Pager(int page, int totalCount, int pageSize) {
        this.init(
    		page, 
    		totalCount, 
    		pageSize, 
    		Play.application().configuration().getInt("setting.frameSize")
		);
	}
	
	public Pager(int page, int totalCount, int pageSize, int frameSize) {
        this.init(
    		page, 
    		totalCount, 
    		pageSize, 
    		frameSize
		);
	}
	
	private void init(int page, int totalCount, int pageSize, int frameSize){
		this.pageSize 	= Math.max(pageSize, 1);
        this.totalCount = Math.max(totalCount, 0);
        
        this.pageCount  = totalCount / this.pageSize 
        					+ (totalCount % this.pageSize == 0 ? 0 : 1);
        
        this.page 		= Math.max(1, Math.min(this.pageCount, page));
        this.firstRow   = this.pageSize * ( this.page - 1 );
        this.lastRow    = Math.min( this.firstRow + this.pageSize, this.totalCount );
        
        this.range();
	}
	
	private void range() {
        this.start = 1;
        
        if ( ( this.page - this.frameSize/2 ) > 0 ) {
            if ( ( this.page + this.frameSize/2 ) > this.pageCount ) {
            	this.start = ( ( this.pageCount - this.frameSize ) > 0 ) ? ( this.pageCount - this.frameSize + 1) : 1;
            } else {
            	this.start = this.page - (int) Math.floor( this.frameSize/2 );
            }
        }
        
        this.end = ((this.start + this.frameSize - 1) < this.pageCount) ? (this.start + this.frameSize - 1) : this.pageCount;
    } 
	
	public int getOffset() {
        if (this.pageSize>0) {
            page = Math.max(1, Math.min(this.pageCount, this.page));
            return this.pageSize * ( page - 1 );
        }
        
        return 0;
    }

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getFrameSize() {
		return frameSize;
	}

	public void setFrameSize(int frameSize) {
		this.frameSize = Math.max( frameSize, 1 );
	}

	public int getFirstRow() {
		return firstRow;
	}

	public void setFirstRow(int firstRow) {
		this.firstRow = firstRow;
	}

	public int getLastRow() {
		return lastRow;
	}

	public void setLastRow(int lastRow) {
		this.lastRow = lastRow;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
	
	public String makeUrl(String path){
		return makeUrl(path, new HashMap<String,String>());
	}
	
	public String makeUrl(Map<String, String> params){
		return makeUrl(Http.Context.current().request().path(), params);
	}
	
	public String makeUrl(String path, Map<String, String> params) {
		Map<String, String[]> query = Http.Context.current().request().queryString();
		
		URIBuilder builder = new URIBuilder();
		builder.setPath(path);
		
		for (Map.Entry<String, String[]> entry : query.entrySet()){
			String key = entry.getKey();
			if(key.endsWith("[]")){
				key = key.substring(0, key.length()-2);
			}
			
			if(!params.containsKey(key) && !params.containsKey(key+"[]")){
				String[] values = entry.getValue();
				for(int i=0; i<values.length; i++){
					builder.addParameter(entry.getKey(), values[i]);
				}
			}
		}
		
		for (Map.Entry<String, String> entry : params.entrySet()){
			builder.addParameter(entry.getKey(), entry.getValue());
		}
		
		try {
			return builder.build().toString();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
