package notification.controller;

import java.util.List;

public class NotificationRequest {
    private String recipient;
    private String message;
    private List<String> channels;

    public NotificationRequest() {}

    public String getRecipient() { return recipient; }
    public void setRecipient(String recipient) { this.recipient = recipient; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public List<String> getChannels() { return channels; }
    public void setChannels(List<String> channels) { this.channels = channels; }
}