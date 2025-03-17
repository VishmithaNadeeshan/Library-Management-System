package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BorrowDetailsEntity {
    private String borrowId;
    private String bookId;
    private String borrowDate;
    private String returnDate;
}
