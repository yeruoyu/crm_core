package com.lodge.crm.core.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.FieldPosition;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

/**
 * Generate 32 bit code only global
 * 
 */
public class RandomUtil extends Object {

    private final static Format dateFormat = new SimpleDateFormat("yyyyMMddHHmmssS");
    private static Random myRand;
    private static SecureRandom mySecureRand;
    private static String s_id;
    public String valueBeforeMD5 = "";
    public String valueAfterMD5 = "";

    static {
        mySecureRand = new SecureRandom();
        long secureInitializer = mySecureRand.nextLong();
        myRand = new Random(secureInitializer);
        try {
            s_id = InetAddress.getLocalHost().toString();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }

    public RandomUtil() throws Exception {
        getRandomGUID(false);
    }

    public RandomUtil(boolean secure) throws Exception {
        getRandomGUID(secure);
    }

    /*
     * Generation GUID randomly
     */
    private void getRandomGUID(boolean secure) throws Exception {
        MessageDigest md5 = null;
        StringBuffer sbValueBeforeMD5 = new StringBuffer();

        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new NoSuchAlgorithmException("MD5 initialization error.");
        }

        try {
            long time = System.currentTimeMillis();
            long rand = 0;

            if (secure) {
                rand = mySecureRand.nextLong();
            } else {
                rand = myRand.nextLong();
            }

            sbValueBeforeMD5.append(s_id);
            sbValueBeforeMD5.append(":");
            sbValueBeforeMD5.append(Long.toString(time));
            sbValueBeforeMD5.append(":");
            sbValueBeforeMD5.append(Long.toString(rand));

            valueBeforeMD5 = sbValueBeforeMD5.toString();
            md5.update(valueBeforeMD5.getBytes());

            byte[] array = md5.digest();
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < array.length; ++j) {
                int b = array[j] & 0xFF;
                if (b < 0x10)
                    sb.append('0');
                sb.append(Integer.toHexString(b));
            }

            valueAfterMD5 = sb.toString();

        } catch (Exception e) {
            throw new Exception("Get the MD5 password error.");
        }
    }

    /**
     * Generate a GUID string
     * 
     * @return GUID
     * @throws Exception
     */
    public static String newGuid() throws Exception {
        return new RandomUtil().toString();
    }

    /*
     * The host serial number, serial number, card board, to ensure that the 32
     * bit code uniqueness
     */
    public String toString() {
        String raw = valueAfterMD5.toUpperCase();
        StringBuffer sb = new StringBuffer();
        sb.append(raw.substring(0, 8));
        sb.append(raw.substring(8, 12));
        sb.append(raw.substring(12, 16));
        sb.append(raw.substring(16, 20));
        sb.append(raw.substring(20));
        return sb.toString();
    }

    /**
     * generate sequence number
     * 
     * @return sequence number
     */
    public static synchronized String generateSequenceNo() {
        Calendar rightNow = Calendar.getInstance();
        StringBuffer sb = new StringBuffer();

        dateFormat.format(rightNow.getTime(), sb, new FieldPosition(0));
        sb.append("-");
        sb.append(getCharAndNumr(10));

        return sb.toString();
    }

    /**
     * generate random number by parameter length
     * 
     * @param length
     * @return
     */
    public static long getRandomNumber(int length) {
        int[] array = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        Random rand = new Random();
        for (int i = 10; i > 1; i--) {
            int index = rand.nextInt(i);
            int tmp = array[index];
            array[index] = array[i - 1];
            array[i - 1] = tmp;
        }
        int result = 0;
        for (int i = 0; i < length; i++)
            result = result * 10 + array[i];

        return result;
    }

    /**
     * generate random number and character by parameter length
     * 
     * @param length
     * @return
     */
    public static String getCharAndNumr(int length) {
        String val = "";

        Random random = new Random();
        for (int i = 0; i < length; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";

            if ("char".equalsIgnoreCase(charOrNum)) {
                int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char) (choice + random.nextInt(26));
            } else if ("num".equalsIgnoreCase(charOrNum)) {
                val += String.valueOf(random.nextInt(10));
            }
        }

        return val;
    }
}