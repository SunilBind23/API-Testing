package ResponsePOJO;

public class TagsResponse {
	private String tag;
	private long createdTime;
	private String entity_type;
	private int availableCount;
	   
	
	
	public int getAvailableCount() {
		return availableCount;
	}

	public void setAvailableCount(int availableCount) {
		this.availableCount = availableCount;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public long getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(long createdTime) {
		this.createdTime = createdTime;
	}

	public String getEntity_type() {
		return entity_type;
	}

	public void setEntity_type(String entity_type) {
		this.entity_type = entity_type;
	}

}
