package br.com.technovaca.error;

public class ResourceNotFoundDetails {
	private String title;
	private int status;
	private String details;
	private long timestamp;
	private String developMessage;
	
	public ResourceNotFoundDetails(){}
	
	public String getTitle() {
		return title;
	}
	public int getStatus() {
		return status;
	}
	public String getDetails() {
		return details;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public String getDevelopMessage() {
		return developMessage;
	}
	
	public static final class Builder {

		private String title;
		private int status;
		private String details;
		private long timestamp;
		private String developMessage;
		
		public Builder() {
			
		}

		public Builder title(String title) {
			this.title = title;
			return this;
		}

		public Builder status(int status) {
			this.status = status;
			return this;
		}

		public Builder details(String details) {
			this.details = details;
			return this;
		}
		
		public Builder timestamp(long timestamp) {
			this.timestamp = timestamp;
			return this;
		}
		
		public Builder developMessage(String developMessage) {
			this.developMessage = developMessage;
			return this;
		}

		public static Builder newBuilder() {
			return new Builder();
		}
		
		public ResourceNotFoundDetails build() {
			return new ResourceNotFoundDetails(this);
		}

	}

	private ResourceNotFoundDetails(Builder builder) {
		title = builder.title;
		status = builder.status;
		details = builder.details;
		timestamp = builder.timestamp;
		developMessage = builder.developMessage;
	}

}
