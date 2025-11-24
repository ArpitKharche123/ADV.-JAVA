package prod.DTO;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ErrorResponseDTO {
	private LocalDateTime timeStamp;
	private int statusCode;
    private String error;
    private String message;
}
