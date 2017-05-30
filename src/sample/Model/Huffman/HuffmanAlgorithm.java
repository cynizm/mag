package sample.Model.Huffman;

import sample.Common.Algorithm;

import java.io.File;
import java.util.*;

/**
 * Created by TeTorro on 27.03.2017.
 */
public class HuffmanAlgorithm extends Algorithm<String> {

    private static final String name = "Huffman Base 3 Algorithm";

    private List<String> splitBitInput;

    private Map<String, String> huffmanTreeMap;

    String ternaryResult ="";

    public HuffmanAlgorithm(File file) {
        super(file);
    }

    public HuffmanAlgorithm(){
        super();
        huffmanTreeMap = new HashMap<>();
    }

    @Override
    public void convert() {

        splitBitInput = new ArrayList<>(Arrays.asList(bitRepresentationInput.split("(?<=\\G.{8})")));
        int[] byteFreqs = new int[256];
        Arrays.fill(byteFreqs,0);
        splitBitInput.forEach(b -> byteFreqs[Integer.parseInt(b, 2)]++);
        // build tree
        HuffmanTree tree = buildTree(byteFreqs);
        printCodes(tree, new StringBuffer());
        splitBitInput.forEach(b ->  ternaryResult+= huffmanTreeMap.get(b));
        String prev = "A";
        for (int i = 0; i < ternaryResult.length(); i++){
            String c = ternaryResult.substring(0+i, 1+i);
            String base = RotationMap.getValue(c, prev);
            dnaRepresentationOutput += base;
            prev = base;
        }
    }

    @Override
    public String toString() {
            return name;
        }

    public static HuffmanTree buildTree(int[] charFreqs) {
        PriorityQueue<HuffmanTree> trees = new PriorityQueue<HuffmanTree>();
        // initially, we have a forest of leaves
        // one for each non-empty character
        for (int i = 0; i < charFreqs.length; i++)
            if (charFreqs[i] > 0)
                trees.offer(new HuffmanLeaf(charFreqs[i], "00000000".substring(Integer.toBinaryString(i).length())+Integer.toBinaryString(i)));

        assert trees.size() > 0;
        // loop until there is only one tree left
        while (trees.size() > 1) {
            // two trees with least frequency
            HuffmanTree a = trees.poll();
            HuffmanTree b = trees.poll();
            HuffmanTree c = trees.poll();

            // put into new node and re-insert into queue
            trees.offer(new HuffmanNode(a, b, c));
        }
        return trees.poll();
    }

    public void printCodes(HuffmanTree tree, StringBuffer prefix) {
        assert tree != null;
        if (tree instanceof HuffmanLeaf) {
            HuffmanLeaf leaf = (HuffmanLeaf)tree;
            // print out character, frequency, and code for this leaf (which is just the prefix)
            System.out.println(leaf.value + "   " + prefix.toString());
            huffmanTreeMap.put(leaf.value, prefix.toString());
        } else if (tree instanceof HuffmanNode) {
            HuffmanNode node = (HuffmanNode)tree;
            // traverse left
            prefix.append('0');
            printCodes(node.left, prefix);
            prefix.deleteCharAt(prefix.length()-1);

            prefix.append('1');
            printCodes(node.middle, prefix);
            prefix.deleteCharAt(prefix.length()-1);

            // traverse right
            prefix.append('2');
            printCodes(node.right, prefix);
            prefix.deleteCharAt(prefix.length()-1);
        }


    }


}






