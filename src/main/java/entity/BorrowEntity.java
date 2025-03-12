package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import utill.BorrowStatus;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BorrowEntity {
    private String borrowId;
    private String userId;
    private String bookId;
    private Date borrowDate;
    private Date returnedDate;
    private Date dewDate;
    private BorrowStatus status;
}
