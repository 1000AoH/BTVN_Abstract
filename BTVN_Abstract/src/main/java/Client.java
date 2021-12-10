import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Year;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    private String code, name, place, email, phoneNumber;
    private Sex sex;
    private int birthYear;

    @Override
    public String toString() {
        return "Client{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", place='" + place + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", sex=" + sex +
                ", birthYear=" + birthYear +
                '}'+"\n";
    }

    enum Sex{
        Male{
            @Override
            public String toString() {
                return "Male";
            }
        },
        Female{
            @Override
            public String toString() {
                return "Female";
            }
        };
    }
}
