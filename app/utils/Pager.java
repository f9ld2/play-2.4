package utils;

import play.Play;

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
	
	private void range()
    {
        this.start = 1;
        
        if ( ( this.page - this.frameSize/2 ) > 0 )
        {
            if ( ( this.page + this.frameSize/2 ) > this.pageCount )
            {
            	this.start = ( ( this.pageCount - this.frameSize ) > 0 ) ? ( this.pageCount - this.frameSize + 1) : 1;
            }
            else
            {
            	this.start = this.page - (int) Math.floor( this.frameSize/2 );
            }
        }
        
        this.end = ((this.start + this.frameSize - 1) < this.pageCount) ? (this.start + this.frameSize - 1) : this.pageCount;
    } 
	
	public int getOffset()
    {
        if (this.pageSize>0) {
            int pages  = (int) Math.ceil(this.totalCount / this.pageSize);
            page = Math.max(1, Math.min(pages, this.page));
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
}
