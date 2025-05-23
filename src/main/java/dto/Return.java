package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Return {
    private String memberId;
    private String bookId;
    private Date borrowDate;
    private Date dewDate;
    private Date returnDate;
    
}
