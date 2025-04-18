package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BorrowDetails {
    private String borrowId;
    private String bookId;
    private String borrowDate;
    private String returnDate;
}
