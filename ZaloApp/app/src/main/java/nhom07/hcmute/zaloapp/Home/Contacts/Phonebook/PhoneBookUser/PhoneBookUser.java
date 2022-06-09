package nhom07.hcmute.zaloapp.Home.Contacts.Phonebook.PhoneBookUser;

public class PhoneBookUser {
    private int avatar;
    private String name;
    private String displayName;
    private String phoneNumber;
    private Boolean addFriend;

    public PhoneBookUser(int avatar, String name, String displayName, String phoneNumber, Boolean addFriend) {
        this.avatar = avatar;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
