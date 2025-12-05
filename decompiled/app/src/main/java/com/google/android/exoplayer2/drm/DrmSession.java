package com.google.android.exoplayer2.drm;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.UUID;
import p007b.p225i.p226a.p242c.p265v2.CryptoConfig;
import p007b.p225i.p226a.p242c.p266w2.DrmSessionEventListener;

/* loaded from: classes3.dex */
public interface DrmSession {

    public static class DrmSessionException extends IOException {
        public final int errorCode;

        public DrmSessionException(Throwable th, int i) {
            super(th);
            this.errorCode = i;
        }
    }

    /* renamed from: a */
    void mo3606a(@Nullable DrmSessionEventListener.a aVar);

    /* renamed from: b */
    void mo3607b(@Nullable DrmSessionEventListener.a aVar);

    /* renamed from: c */
    UUID mo3608c();

    /* renamed from: d */
    boolean mo3609d();

    /* renamed from: e */
    boolean mo3610e(String str);

    @Nullable
    /* renamed from: f */
    DrmSessionException mo3611f();

    @Nullable
    /* renamed from: g */
    CryptoConfig mo3612g();

    int getState();
}
