package com.google.android.exoplayer2.upstream;

import androidx.annotation.Nullable;
import java.io.IOException;

/* loaded from: classes3.dex */
public class DataSourceException extends IOException {

    /* renamed from: j */
    public static final /* synthetic */ int f20224j = 0;
    public final int reason;

    public DataSourceException(int i) {
        this.reason = i;
    }

    public DataSourceException(@Nullable Throwable th, int i) {
        super(th);
        this.reason = i;
    }

    public DataSourceException(@Nullable String str, int i) {
        super(str);
        this.reason = i;
    }

    public DataSourceException(@Nullable String str, @Nullable Throwable th, int i) {
        super(str, th);
        this.reason = i;
    }
}
