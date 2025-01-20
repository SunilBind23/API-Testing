package RequestPojo;

import java.util.ArrayList;
import java.util.List;

import commonValues.CommonProperty;



public class RootRequest {

	private String star_value;
	public String getStar_value() {
		return star_value;
	}
	public void setStar_value(String star_value) {
		this.star_value = star_value;
	}
	public String getLead_score() {
		return lead_score;
	}
	public void setLead_score(String lead_score) {
		this.lead_score = lead_score;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	public List<CommonProperty> getProperties() {
		return properties;
	}
	public void setProperties(List<CommonProperty> properties) {
		this.properties = properties;
	}
	private String lead_score;
	private List<String> tags;
	private List<CommonProperty> properties;

}
