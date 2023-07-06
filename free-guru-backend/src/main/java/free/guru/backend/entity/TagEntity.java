package free.guru.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tag")
public class TagEntity {
    @Id
    private String id;
    private String name;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
