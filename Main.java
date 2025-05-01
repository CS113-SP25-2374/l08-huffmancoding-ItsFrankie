public class Main {
    public static void main(String[] args) 
    {
        HuffmanCoding huffmanCoding = new HuffmanCoding();

        String message = "Frankie <3";

        String encoded = huffmanCoding.encode(message);
        String key = encoder.getKey();
        System.out.println(encoded);
        System.out.println(key);


        HuffmanInterface decoder = new HuffmanCoding(key);
        String decoded = decoder.decode(encoded);
        System.out.println(decoded);
    }
}