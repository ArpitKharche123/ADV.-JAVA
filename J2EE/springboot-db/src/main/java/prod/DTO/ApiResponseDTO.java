package prod.DTO;

import lombok.Data;

@Data
/*
 * Can also be named as :ApiResponse (Most Common), ResponseDTO	,ApiResult, WebResponse
 */
public class ApiResponseDTO<T> {
	// A machine-readable status code (e.g., 200, 404, 500).
	private int statusCode;

	// A human-readable message about the result.
	private String message;

	// The actual business data (generic type T allows it to hold any data).
	private T data;
}
