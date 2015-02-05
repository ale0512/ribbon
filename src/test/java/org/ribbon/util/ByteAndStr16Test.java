package org.ribbon.util;

import org.junit.Test;

/**
 * Created by admin on 2015/2/4.
 */
public class ByteAndStr16Test {
   static String s16 = "534D5320525A542F312E300D0A43616C6C65653A203435360D0A526571756573742D49443A2031343233303433303833320D0A5265706C61793A20310D0A436F6E74656E742D547970653A206170706C69636174696F6E2F746578740D0A436F6E74656E742D4C656E6774683A2031310D0A0D0A68656C6C6F20C4E3BAC321";

    public static void str216(){
        String s = ByteAndStr16.toStringHex2(s16);
        System.out.println(s);
    }

    public  static void hex2Str(){
        System.out.println(ByteAndStr16.HexString2Bytes("success"));
    }
    public static  void main(String[] args){
//        ByteAndStr16Test.str216();
        ByteAndStr16Test.hex2Str();
    }
}
