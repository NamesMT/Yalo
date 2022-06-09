package nhom07.hcmute.zaloapp.Home.Message.Chat;

import java.io.Serializable;

public class Chat implements Serializable {
    private int avatar;
    private String displayName;
    private String message;
    private String time;
    private String notificationNumber;

    public Chat(int avatar, String displayName, String message, String time, String notificationNumber) {
        this.avatar = avatar;
        this.displayName = displayName;
        this.message = message;
        this.time = time;
        this.notificationNumber = notificationNumber;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNotificationNumber() {
        return notificationNumber;
    }

    public void setNotificationNumber(String notificationNumber) {
        this.notificationNumber = notificationNumber;
    }
}


