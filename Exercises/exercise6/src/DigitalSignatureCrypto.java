import java.security.*;
import java.util.Base64;

class DigitalSignatureCrypto {
    private KeyPair keyPair;

    public DigitalSignatureCrypto() throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(2048);
        this.keyPair = keyPairGen.generateKeyPair();
    }

    public String sign(String message, PrivateKey signerPrivateKey) throws Exception {
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(signerPrivateKey);
        signature.update(message.getBytes());

        byte[] signatureBytes = signature.sign();
        return Base64.getEncoder().encodeToString(signatureBytes);
    }

    public boolean verify(String message, String signatureStr, PublicKey signerPublicKey) throws Exception {
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initVerify(signerPublicKey);
        signature.update(message.getBytes());

        byte[] signatureBytes = Base64.getDecoder().decode(signatureStr);
        return signature.verify(signatureBytes);
    }

    public PublicKey getPublicKey() {
        return keyPair.getPublic();
    }

    public PrivateKey getPrivateKey() {
        return keyPair.getPrivate();
    }
}
