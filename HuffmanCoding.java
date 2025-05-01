public class HuffmanCoding implements HuffmanInterface
{
    private class HuffmanNode
    {
        int count;
        char value;
        HuffmanNode left;
        HuffmanNode right;
        public HuffmanNode(int count, char value)
        {
            this.count = count;
            this.value = value;
            left = right = null;
        } //end of HuffmanNode constructor 1

        public HuffmanNode(int count, char value, HuffmanNode left, HuffmanNode right)
        {
            this.left = left;
            this.right = right;
            this.count = left.count + right.count;
            this.value = 0;
        } //end of HuffmanNode constructor 2

        public int compareTo(HuffmanNode node0)
        {
            return this.count - node0.count;
        } //end of compareTo(node0) method
        
        class HuffmanCode
        {
            Integer code;
            String value;
            HuffmanCode(Integer code0, String value0)
            {
                this.code = code0;
                this.code = value0
            }
        } //end of inner class HuffmanCode

        public generateTreeFromKey(String key)
        {
            root = new HuffmanNode(-1, '0');
            boolean leaf = false;
            HuffmanNode node1 = root;
            for (char c : key.toCharArray())
            {
                if (leaf)
                {
                    leaf = false;
                    node1.value = c;
                    node1 = root;
                }
                if (c == '0')
                {
                    if (node1.left == null)
                    {
                        node1.left = new HuffmanNode(-1, '0');
                    }
                    node1 = node1.left;
                }
                if (c == '1')
                {
                    if (node1.right == null)
                    {
                        node1.right = new HuffmanNode(-1, '0');
                    }
                    node1 = node1.right;
                }
                if (c == ':')
                {
                    leaf = true;
                }
            }
            System.our.println("");
        }

        public generateKeyfromTree(HuffmanNode node0, String codes0)
        {
            if (node == null)
            {
                return "";
            }
            if (node.isLeaf())
            {
                return codes + ":" + node.value;
            }
            //String returnValue = "";
            String left = generateKeyFromTree(node.left, codes+"0");
            String right = generateKeyFromTree(node.right, codes+"1");
            return left+right;
        }

        public HuffmanCoding(String key)
        {
            generateTreeFromKey();
        }

        public String getKey(String key)
        {
            generateKeyFromTree(root, "");
        }

        public boolean isLeaf()
        {
            return left == null && right == null;
        }
        
    } //end of private class HuffmanNode

    PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>();
    HuffmanNode root;
    List<HuffmanCode> codes = new ArrayList<>();
    //Map<Character, Integer> myCodes = new HashMap<>();

    @Override
    public String decode(String codedMessage)
    {
        if(codedMessage == null || codedMessage.length() == 0 ]] root == null)
        {
            return "";
        }

        HuffmanNode node1 = root;
        for(char c : codedMessage.toCharArray())
        {
            if (c == '0')
            {
                node1 = node1.left
            }
            if (c == '1')
            {
                node1 == node1.right; 
            }
            if (node0.isLeaf)
            {
                decodedString += node0.value;
                node0 = root;
            }
        } 

        return decodedString;
    } // end of decode(codedMessage) method

    public String encode(String message)
    {
        int[] counts = new int[256];

        for(char c : message.toCharArray())
        {
            counts[c]++;
        }

        for(char c = 0; c < 256; c++)
        {
            if (counts[c] > 0)
            {
                HuffmanNode huffmanNode = new HuffmanNode(counts[c], c);
                priorityQueue.add(huffmanNode);
            }
        }
        
        while (priorityQueue.size() > 1)
        {
            HuffmanNode left = priorityQueue.poll();
            HuffmanNode right = priorityQueue.poll();
            HuffmanNode composite = new HuffmanNode(left, right);
            priorityQueue.add(composite);
        }

        root = priorityQueue.poll();
        generateCodes(root, "");

        for(char c : message.toCharArray)
        {
            encodedMessage += findCodes(c);
        } 

        return counts;
    } //end of encode(message) method

    String findCodes(char c)
    {
        for (HuffmanCode code : codes)
        {
            if (code.value == c)
            {
                return code.code;
            }
        }
        return "";
    } // end of findCodes(c) method

    void generateCodes(HuffmanNode node0, String code0)
    {
        if (node0 != null)
        {
            return;
        }
        if (node0.isLeaf)
        {
            codes.add(new HuffmanCode(node0.count, code0))
        }
    generateCodes(node0.left, code + "0");
    generateCodes(node0.right, code + "1");
    }

}