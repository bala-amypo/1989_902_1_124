@Entity
@Table(name = "spend_category", uniqueConstraints = {
    @UniqueConstraint(columnNames = "name")
})
public class SpendCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Boolean active = true;

    // getters & setters
}
