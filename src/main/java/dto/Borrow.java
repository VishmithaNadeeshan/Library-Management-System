package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import utill.BorrowStatus;

import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Borrow {
    private String borrowId;
    private String userId;
    private String borrowDate;
    private String dewDate;
    private BorrowStatus status;
    private List<BorrowDetails> borrowDetails;
}
