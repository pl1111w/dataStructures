package com.pl1111w.datastructures.tree.huffman.HuffmanZipData;

import java.io.*;
import java.util.*;

public class HuffmanZipDataTest {

    public static void main(String[] args) {

//        String msg = "can you can a can as a can cancer can a can.";
//        byte[] bytes = msg.getBytes();
//        byte[] result = huffmanZip(bytes);
//        //解码
//        byte[] newBytes = decode(huffmanCodes, result);
//        System.out.println(new String(newBytes));
        String src="Pictures/test/beauty.png";
        String dst="/Pictures/beauty.zip";

//        try {
//            zipFile(src,dst);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try {
            unZip(dst,src);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    private static byte[] decode(Map<Byte, String> huffmanCodes, byte[] result) {
        //byte 转字符串
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            boolean flag = (i == result.length - 1);
            stringBuilder.append(decode(result[i], !flag));
        }
        System.out.println(stringBuilder.toString());
        Map<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }
        List<Byte> list = new ArrayList<>();
        for (int i = 0; i < stringBuilder.length(); ) {
            int count = 1;
            boolean flag = true;
            while (flag) {
                String key = stringBuilder.substring(i, i + count);
                Byte b = map.get(key);
                if (b == null) {
                    count++;
                } else {
                    flag = false;
                    list.add(b);
                }
            }
            i = i + count;
        }
        System.out.println(list.toString());
        //集合转数组
        byte [] change = new byte[list.size()];
        for (int i = 0; i < list.size(); i++) {
             change[i]=list.get(i);
        }
        return change;
    }

    private static String decode(byte b, boolean flag) {
        int temp = b;
        if (flag) {
            temp |= 256;
        }
        String string = Integer.toBinaryString(temp);
        if (flag) {
            return string.substring(string.length() - 8);
        } else {
            return string;
        }

    }


    private static byte[] huffmanZip(byte[] bytes) {
        List<Node> nodes = new ArrayList();
        Map<Byte, Integer> counts = new HashMap<>();
        //统计每一个byte出现的次数
        for (byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null) {
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            }
        }
        //map转node
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        //创建赫夫曼树
        Node tree = createHuffmanTree(nodes);
        //System.out.println(tree.left);

        //创建赫夫曼编码表  键为字母值， 值为路径
        Map<Byte, String> huffmanCodes = getHuffmanCodes(tree);
        //System.out.println(huffmanCodes);

        //编码
        byte[] bs = zip(bytes, huffmanCodes);
        return bs;
    }

    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {

        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(huffmanCodes.get(b));
        }
        System.out.println(sb.toString());
        int len;
        if (sb.length() / 8 == 0) {
            len = sb.length() / 8;
        } else {
            len = sb.length() / 8 + 1;
        }
        //存储压缩后的bytes
        byte[] by = new byte[len];
        //存储压缩后的bytes下标
        int index = 0;
        for (int i = 0; i < sb.length(); i = i + 8) {
            String strByte;
            if (i + 8 > sb.length()) {
                strByte = sb.substring(i);
            } else {
                strByte = sb.substring(i, i + 8);
            }
            //System.out.println(strByte);
            byte byt = (byte) Integer.parseInt(strByte, 2);
            // System.out.println(strByte + ":" + byt);
            by[index] = byt;
            index++;
        }

        return by;
    }

    static StringBuilder str = new StringBuilder();

    private static Map<Byte, String> getHuffmanCodes(Node tree) {
        if (tree == null) {
            return null;
        }
        getCodes(tree.left, "0", str);
        getCodes(tree.right, "1", str);
        return huffmanCodes;
    }

    static Map<Byte, String> huffmanCodes = new HashMap<>();

    private static void getCodes(Node node, String code, StringBuilder str) {
        StringBuilder builder = new StringBuilder(str);
        builder.append(code);
        if (node.data == null) {
            getCodes(node.left, "0", builder);
            getCodes(node.right, "1", builder);
        } else {
            huffmanCodes.put(node.data, builder.toString());
        }
    }

    private static Node createHuffmanTree(List<Node> nodes) {

        while (nodes.size() > 1) {
            Collections.sort(nodes);
            Node left = nodes.get(nodes.size() - 1);
            Node right = nodes.get(nodes.size() - 2);
            Node parent = new Node(null, left.weight + right.weight);
            parent.left = left;
            parent.right = right;
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    /******************************************************/
    public static void zipFile(String src,String dis) throws IOException {
        InputStream inputStream = new FileInputStream(src);
        //创建一个输入流大小一样的byte数组
        byte[] b  =new byte[inputStream.available()];
        inputStream.read(b);
        inputStream.close();
        byte [] byteZip = huffmanZip(b);
//        System.out.println(b.length);
//        System.out.println(byteZip.length);
        OutputStream outputStream = new FileOutputStream(dis);
        ObjectOutputStream oos = new ObjectOutputStream(outputStream);
        oos.writeObject(byteZip);
        oos.writeObject(huffmanCodes);
        outputStream.close();
    }
    public static void unZip(String src,String dis) throws IOException, ClassNotFoundException {
        InputStream inputStream = new FileInputStream(src);
        ObjectInputStream ois = new ObjectInputStream(inputStream);

        byte[] b = (byte[]) ois.readObject();
        Map<Byte,String> map = (Map<Byte, String>) ois.readObject();
        ois.close();
        inputStream.close();
        byte [] bytes = decode(map,b);
        OutputStream os = new FileOutputStream(dis);
        //写数据
        os.write(bytes);
        os.close();
    }
}
