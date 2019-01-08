package assignment_261118.task1.clientserver;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class ExtMessage implements Serializable {


    private String messText;
    private String sender;
    private UUID msgId;

    public ExtMessage(String sender, String messText, UUID msgId){
        this.sender = sender;
        this.messText = messText;
        this.msgId = msgId;
    }

    public void setMsgId(UUID msgId) {
        this.msgId = msgId;
    }

    public UUID getMsgId() {
        return msgId;
    }

    Set<String> str = new HashSet<>();

    public String getMessText() {
        return messText;
    }

    public void setMessText(String messText) {
        this.messText = messText;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    @Override
    public String toString() {

        return "Msg ID {" + getMsgId() + "} " + "from " + sender + ": "+ messText;
    }

}
