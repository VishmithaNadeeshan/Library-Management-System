package dto.TM;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CartTM {
    private String bookId;
    private String userId;
    private String borrowDate;
    private String dewDate;
}
