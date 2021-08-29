package hrm.modules.core.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import hrm.base.common.ConstSetting.TableName;
import hrm.modules.core.auth.model.Role;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = TableName.USER_DB)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String username;

    @Column()
    private String password;

    @Column
    private String fullname;

    @ManyToOne
    @JoinColumn(name = "role", nullable = true)
    @Schema(hidden = true)
    private Role role;

    @Column(unique = true)
    private String email;

    @Column(unique = true, nullable = true, length = 36)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String code;
}
