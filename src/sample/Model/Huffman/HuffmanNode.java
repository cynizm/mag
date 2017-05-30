package sample.Model.Huffman;

/**
 * Created by TeTorro on 29.05.2017.
 */
class HuffmanNode extends HuffmanTree {
    public final HuffmanTree left, middle, right; // subtrees

    public HuffmanNode(HuffmanTree l, HuffmanTree m, HuffmanTree r) {
        super((l != null ? l.frequency : 0) + (m != null ? m.frequency : 0) + (r != null ? r.frequency : 0));
        left = l;
        right = r;
        middle = m;
    }
}
