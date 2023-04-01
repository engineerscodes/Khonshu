package com.engineerscodes.app.Algo;

import java.security.*;
import java.security.spec.ECGenParameterSpec;

public class Main {

    public static void  main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        System.out.println(Security.getProvider("SunEC").getService("AlgorithmParameters", "EC").getAttribute("SupportedCurves"));
        KeyPairGenerator g = KeyPairGenerator.getInstance("EC","SunEC");
        ECGenParameterSpec ecsp = new ECGenParameterSpec("secp521r1");
        g.initialize(ecsp);
        KeyPair kp = g.genKeyPair();
        PrivateKey privKey = kp.getPrivate();
        PublicKey pubKey = kp.getPublic();
        System.out.println("Public Key : "+pubKey+" \n "+"Private Key : "+privKey);

    }
}

//https://infosecwriteups.com/elliptic-curve-signatures-and-how-to-use-them-in-your-java-application-b88825f8e926