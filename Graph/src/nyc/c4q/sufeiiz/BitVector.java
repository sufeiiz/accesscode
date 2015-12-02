package nyc.c4q.sufeiiz;

/**
 * Created by sufeizhao on 11/24/15.
 */
public class BitVector {

    byte[] array;

    public BitVector(int length) {
        this.array = new byte[(length + 7) / 8];
    }

    public boolean getShift(int index) {
//        int byteChunk = index / 8;
//        int position = index % 8;
//
//        byte chunk = array[byteChunk];
//        byte add = (byte) (1 << 7 - position);
//        return (chunk & add) != 0;

        return (array[index / 8] & (byte) (1 << (index % 8))) != 0;
    }

    public void setShift(int index, boolean value) {
        int byteChunk = index / 8;
        int position = index % 8;
        byte chunk = array[byteChunk];

        if (value) {
            byte mask = (byte) (1 << position);
            array[byteChunk] = (byte) (chunk | mask);
        } else {
            byte mask = (byte) ~(1 << position);
            array[byteChunk] = (byte) (chunk & mask);
        }
    }

    public void set(int index, int value) {
        //if value is already there, do nothing
        int byteChunk = index / 8;
        int position = index % 8;

        byte chunk = array[byteChunk];
        String binary = String.format("%8s", Integer.toBinaryString(chunk)).replace(' ', '0');
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < binary.length(); i++) {
            if (i == position)
                sb.append(Integer.toString(value));
            else
                sb.append(binary.charAt(i));
        }

        byte newByte = Byte.parseByte(sb.toString(), 2);
        array[byteChunk] = newByte;
    }

    public boolean get(int index) {
        int byteChunk = index / 8;
        int position = index % 8;

        byte chunk = array[byteChunk];
        String binary = String.format("%8s", Integer.toBinaryString(chunk)).replace(' ', '0');
        return binary.charAt(position) == '1';
    }
}
