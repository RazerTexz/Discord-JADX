package com.google.android.gms.internal.measurement;

import java.io.IOException;
import p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3612c6;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* loaded from: classes3.dex */
public class zzij extends IOException {

    /* renamed from: j */
    public static final /* synthetic */ int f20634j = 0;
    private InterfaceC3612c6 zza;

    public zzij(String str) {
        super(str);
        this.zza = null;
    }

    /* renamed from: a */
    public static zzij m9103a() {
        return new zzij("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    /* renamed from: b */
    public static zzij m9104b() {
        return new zzij("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* renamed from: c */
    public static zzij m9105c() {
        return new zzij("Protocol message contained an invalid tag (zero).");
    }

    /* renamed from: d */
    public static zzij m9106d() {
        return new zzij("Failed to parse the message.");
    }

    /* renamed from: e */
    public static zzij m9107e() {
        return new zzij("Protocol message had invalid UTF-8.");
    }
}
