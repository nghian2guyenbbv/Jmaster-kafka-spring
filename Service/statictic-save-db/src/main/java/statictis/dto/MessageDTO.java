package statictis.dto;

import lombok.Data;

@Data
public class MessageDTO {
    private int id;
    private String to_email;
    private String toName;
    private String subject;
    private String content;
    private boolean status;

   /* public String toString() {
        return this.id + "-" + this.to_email + "-" + this.toName + "-" + this.subject + "-" + this.content;
    }*/
}
