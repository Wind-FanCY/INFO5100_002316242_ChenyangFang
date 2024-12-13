public class CommunicationObj {
    private String name;
    private SymmetricCrypto symmetricCrypto;
    private AsymmetricCrypto asymmetricCrypto;
    private DigitalSignatureCrypto signatureCrypto;

    public CommunicationObj(String name) throws Exception {
        this.name = name;
        this.symmetricCrypto = new SymmetricCrypto();
        this.asymmetricCrypto = new AsymmetricCrypto();
        this.signatureCrypto = new DigitalSignatureCrypto();
    }

    public String getName() {
        return name;
    }

    public SymmetricCrypto getSymmetricCrypto() {
        return symmetricCrypto;
    }

    public AsymmetricCrypto getAsymmetricCrypto() {
        return asymmetricCrypto;
    }

    public DigitalSignatureCrypto getSignatureCrypto() {
        return signatureCrypto;
    }

    public void secureCommunication(CommunicationObj receiver, String message) throws Exception {
        System.out.println("\n--- " + name + " starts secure communication with " + receiver.getName() + " ---");

        System.out.println("\n1. Symmetric Encryption");
        String symmetricEncryptedMsg = symmetricCrypto.encrypt(message);
        System.out.println(name + " sends message using symmetric encryption: " + symmetricEncryptedMsg);
        String symmetricDecryptedMsg = receiver.getSymmetricCrypto().decrypt(symmetricEncryptedMsg, symmetricCrypto.getSecretKey());
        System.out.println(receiver.getName() + " decrypts message: " + symmetricDecryptedMsg);

        System.out.println("\n2. Asymmetric Encryption");
        String asymmetricEncryptedMsg = asymmetricCrypto.encrypt(message, receiver.getAsymmetricCrypto().getPublicKey());
        System.out.println(name + " encrypts message using " + receiver.getName() + "'s public key: " + asymmetricEncryptedMsg);
        String asymmetricDecryptedMsg = receiver.getAsymmetricCrypto().decrypt(asymmetricEncryptedMsg, receiver.getAsymmetricCrypto().getPrivateKey());
        System.out.println(receiver.getName() + " decrypts message using private key: " + asymmetricDecryptedMsg);

        System.out.println("\n3. Digital Signature Verification");
        String signature = signatureCrypto.sign(message, signatureCrypto.getPrivateKey());
        System.out.println(name + " signs message: " + signature);

        boolean signatureVerified = receiver.getSignatureCrypto().verify(message, signature, signatureCrypto.getPublicKey());
        System.out.println(receiver.getName() + " signature verification result: " + signatureVerified);

        System.out.println("\n4. Tampered Message Signature Verification");
        boolean tamperedSignatureVerified = receiver.getSignatureCrypto().verify("Tampered message", signature, signatureCrypto.getPublicKey());
        System.out.println(receiver.getName() + " tampered message signature verification result: " + tamperedSignatureVerified);
    }
}