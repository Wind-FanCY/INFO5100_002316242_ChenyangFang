public class MainProgram {
    public static void main(String[] args) throws Exception {
        // Create two objects
        CommunicationObj alice = new CommunicationObj("Alice");
        CommunicationObj bob = new CommunicationObj("Bob");

        // Two scenes
        alice.secureCommunication(bob, "Hi Bob, this is a secret message!");
        bob.secureCommunication(alice, "Received, Alice. Message arrived securely.");
    }
}