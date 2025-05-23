package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import util.BorrowStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class BorrowDetails {
    private String borrowId;
    private String bookId;
    private String borrowDate;
    private String returnDate;
    private BorrowStatus status;

}
