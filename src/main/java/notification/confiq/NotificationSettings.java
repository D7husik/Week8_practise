package notification.confiq;

public class NotificationSettings {
    private int maxRetries;
    private long retryDelayMs;
    private boolean enableLogging;


    public int getMaxRetries() { return maxRetries; }
    public void setMaxRetries(int maxRetries) { this.maxRetries = maxRetries; }
    public long getRetryDelayMs() { return retryDelayMs; }
    public void setRetryDelayMs(long retryDelayMs) { this.retryDelayMs = retryDelayMs; }
    public boolean isEnableLogging() { return enableLogging; }
    public void setEnableLogging(boolean enableLogging) { this.enableLogging = enableLogging; }
}
