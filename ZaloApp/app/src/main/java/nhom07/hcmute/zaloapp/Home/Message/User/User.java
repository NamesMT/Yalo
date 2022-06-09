package nhom07.hcmute.zaloapp.Home.Message.User;

public class User {
    private int avatar;
    private String displayName;

    public User(int avatar, String displayName) {
        this.avatar = avatar;
        this.displayName = displayName;
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
}
