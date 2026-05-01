package io.github.gavaconnectsdks.http;

public class RetryConfig {
    private final int MAX_RETRIES;
    private final long BACKOFF_IN_MILLISECONDS;
    
    public RetryConfig(int maxRetries,long backoffInMilliseconds){
        this.MAX_RETRIES=maxRetries;
        this.BACKOFF_IN_MILLISECONDS=backoffInMilliseconds;
    } 

    public int getMaxRetries(){
        return  this.MAX_RETRIES;
    }
    public long getBackoffInMilliseconds(){
        return this.BACKOFF_IN_MILLISECONDS;
    }

    public static RetryConfig defaultConfig(){
        return  new RetryConfig(3, 500);
    }

}
