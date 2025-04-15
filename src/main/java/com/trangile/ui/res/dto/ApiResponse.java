package com.trangile.ui.res.dto;

import java.util.Objects;

import org.springframework.http.HttpStatus;

import com.trangile.util.AppConstants;

public class ApiResponse <T> {
	
	private Integer code;
	private boolean success;
	private String message;
	private T data;
	private ErrorDetails errorDetails;
	
	public ApiResponse() {
		this.code = 200;
		this.success = true;
		this.message = AppConstants.RESPONSE_MESSAGE;
		
	}

	public ApiResponse(Integer code, boolean success, String message, T data, ErrorDetails errorDetails) {
		this.code = code;
		this.success = success;
		this.message = message;
		this.data = data;
		this.errorDetails = errorDetails;
	}
	
	public ApiResponse(boolean success, String message, T data, ErrorDetails errorDetails) {
		this.code = HttpStatus.INTERNAL_SERVER_ERROR.value();
		this.success = success;
		this.message = message;
		this.data = data;
		this.errorDetails = errorDetails;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public ErrorDetails getErrorDetails() {
		return errorDetails;
	}

	public void setErrorDetails(ErrorDetails errorDetails) {
		this.errorDetails = errorDetails;
	}

	@Override
	public int hashCode() {
		return Objects.hash(code, data, errorDetails, message, success);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ApiResponse other = (ApiResponse) obj;
		return Objects.equals(code, other.code) && Objects.equals(data, other.data)
				&& Objects.equals(errorDetails, other.errorDetails) && Objects.equals(message, other.message)
				&& success == other.success;
	}

	@Override
	public String toString() {
		return "ApiResponse [code=" + code + ", success=" + success + ", message=" + message + ", data=" + data
				+ ", errorDetails=" + errorDetails + "]";
	}


	public static class ErrorDetails {
		private String errorCode;
		private String errorMessage;
		private String field;
		
		public ErrorDetails() {
			
		}

		public ErrorDetails(String errorCode, String errorMessage, String field) {
			this.errorCode = errorCode;
			this.errorMessage = errorMessage;
			this.field = field;
		}

		public String getErrorCode() {
			return errorCode;
		}

		public void setErrorCode(String errorCode) {
			this.errorCode = errorCode;
		}

		public String getErrorMessage() {
			return errorMessage;
		}

		public void setErrorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
		}

		public String getField() {
			return field;
		}

		public void setField(String field) {
			this.field = field;
		}

		@Override
		public int hashCode() {
			return Objects.hash(errorCode, errorMessage, field);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ErrorDetails other = (ErrorDetails) obj;
			return Objects.equals(errorCode, other.errorCode) && Objects.equals(errorMessage, other.errorMessage)
					&& Objects.equals(field, other.field);
		}

		@Override
		public String toString() {
			return "ErrorDetails [errorCode=" + errorCode + ", errorMessage=" + errorMessage + ", field=" + field + "]";
		}
		
	}
	
}
