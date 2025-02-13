package dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Book {
    private String id;
    private String ISBN;
    private String title;
    private String author;
    private String availability;
}
