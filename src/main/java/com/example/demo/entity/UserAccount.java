@Entity
@Table(name = "users", uniqueConstraints = {
    @UniqueConstraint(columnNames = "email")
})
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String email;
    private String password;
    private String role = "USER";
    private Instant createdAt;

    @PrePersist
    void created() {
        createdAt = Instant.now();
    }

    // getters & setters
}
