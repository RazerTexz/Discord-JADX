package com.facebook.imagepipeline.decoder;

import p007b.p109f.p161j.p175j.EncodedImage2;

/* JADX INFO: loaded from: classes.dex */
public class DecodeException extends RuntimeException {
    private final EncodedImage2 mEncodedImage;

    public DecodeException(String str, EncodedImage2 encodedImage2) {
        super(str);
        this.mEncodedImage = encodedImage2;
    }

    /* JADX INFO: renamed from: a */
    public EncodedImage2 m8696a() {
        return this.mEncodedImage;
    }
}
