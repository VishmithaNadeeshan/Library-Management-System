package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BookEntity {
    private String id;
    private String ISBN;
    private String title;
    private String author;
    private String genre;
}
