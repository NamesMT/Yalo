package nhom07.hcmute.zaloapp.UserSearch;

public class UserSearch {
    private int avatar;
    private String displayName;
    private String phoneNumber;
    private Boolean addFriend;

    public UserSearch(int avatar, String displayName, String phoneNumber, Boolean addFriend) {
        this.avatar = avatar;
        this.displayName = displayName;
        this.phoneNumber = phoneNumber;
        this.addFriend = addFriend;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getAddFriend() {
        return addFriend;
    }

    public void setAddFriend(Boolean addFriend) {
        this.addFriend = addFriend;
    }
}
