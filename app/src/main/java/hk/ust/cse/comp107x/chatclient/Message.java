package hk.ust.cse.comp107x.chatclient;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


class Message {
    private String fromName, message;
    private boolean fromMe;
    private Date date;

    private static final SimpleDateFormat sdfDate = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault());
    private static final SimpleDateFormat sdfTime = new SimpleDateFormat("h:mm a", Locale.getDefault());

    Message() {
    }

    Message(String fromName, String message, boolean fromMe, Date date) {
        this.fromName = fromName;
        this.message = message;
        this.fromMe = fromMe;
        this.date = date;
    }

    String getFromName() {
        return fromName;
    }

    void setFromName(String fromName) {
        this.fromName = fromName;
    }

    String getMessage() {
        return message;
    }

    void setMessage(String message) {
        this.message = message;
    }

    boolean fromMe() {
        return fromMe;
    }

    void setSelf(boolean fromMe){
        this.fromMe = fromMe;
    }

    void setDate(Date date) {
        this.date = date;

    }

    String getDate() {
        return sdfDate.format(date);

    }

    String getTime() {
        return sdfTime.format(date);

    }

}