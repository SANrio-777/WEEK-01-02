import java.util.HashMap;

public class Week01_02 {

    static class TokenBucket {
        int tokens;
        long lastRefillTime;
        int maxTokens;
        int refillRate;

        TokenBucket(int maxTokens, int refillRate) {
            this.tokens = maxTokens;
            this.maxTokens = maxTokens;
            this.refillRate = refillRate;
            this.lastRefillTime = System.currentTimeMillis();
        }

        void refill() {
            long now = System.currentTimeMillis();
            long seconds = (now - lastRefillTime) / 1000;
            int refill = (int) seconds * refillRate;
            tokens = Math.min(maxTokens, tokens + refill);
            lastRefillTime = now;
        }

        boolean allowRequest() {
            refill();
            if (tokens > 0) {
                tokens--;
                return true;
            }
            return false;
        }
    }

    HashMap<String, TokenBucket> clients = new HashMap<>();

    public boolean checkRateLimit(String clientId) {
        clients.putIfAbsent(clientId, new TokenBucket(1000, 1));
        return clients.get(clientId).allowRequest();
    }

    public static void main(String[] args) {
        Week01_02 limiter = new Week01_02();

        System.out.println(limiter.checkRateLimit("client1"));
        System.out.println(limiter.checkRateLimit("client1"));
    }
}