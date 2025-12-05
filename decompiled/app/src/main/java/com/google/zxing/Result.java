package com.google.zxing;

import java.util.EnumMap;
import java.util.Map;
import p007b.p225i.p414e.BarcodeFormat;
import p007b.p225i.p414e.ResultMetadataType;
import p007b.p225i.p414e.ResultPoint;

/* loaded from: classes3.dex */
public final class Result {

    /* renamed from: a */
    public final String f21668a;

    /* renamed from: b */
    public final byte[] f21669b;

    /* renamed from: c */
    public ResultPoint[] f21670c;

    /* renamed from: d */
    public final BarcodeFormat f21671d;

    /* renamed from: e */
    public Map<ResultMetadataType, Object> f21672e;

    public Result(String str, byte[] bArr, ResultPoint[] resultPointArr, BarcodeFormat barcodeFormat) {
        System.currentTimeMillis();
        this.f21668a = str;
        this.f21669b = bArr;
        this.f21670c = resultPointArr;
        this.f21671d = barcodeFormat;
        this.f21672e = null;
    }

    /* renamed from: a */
    public void m9261a(Map<ResultMetadataType, Object> map) {
        if (map != null) {
            Map<ResultMetadataType, Object> map2 = this.f21672e;
            if (map2 == null) {
                this.f21672e = map;
            } else {
                map2.putAll(map);
            }
        }
    }

    /* renamed from: b */
    public void m9262b(ResultMetadataType resultMetadataType, Object obj) {
        if (this.f21672e == null) {
            this.f21672e = new EnumMap(ResultMetadataType.class);
        }
        this.f21672e.put(resultMetadataType, obj);
    }

    public String toString() {
        return this.f21668a;
    }

    public Result(String str, byte[] bArr, int i, ResultPoint[] resultPointArr, BarcodeFormat barcodeFormat, long j) {
        this.f21668a = str;
        this.f21669b = bArr;
        this.f21670c = resultPointArr;
        this.f21671d = barcodeFormat;
        this.f21672e = null;
    }
}
