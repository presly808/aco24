package server;

public class Token {

    private String token;

    public Token() {
        this.token = createToken();
    }

    private static final int DEFAULT_TOKEN_LENGTH = 15;

    public static String createToken(){

        StringBuilder token = new StringBuilder();
        char[] arr = {'a', 'b', 'c', 'd', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                      'A', 'B', 'C', 'D', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        for (int i = 0; i < DEFAULT_TOKEN_LENGTH; i++) {
            token.append(arr[(int) (Math.random() * arr.length)]);
        }

        return token.toString();
    }

    public String getToken() {
        return token;
    }

    @Override
    public String toString() {
        return "Token{" +
                "token='" + token + '\'' +
                '}';
    }
}
