package com.google.android.exoplayer2.upstream;

import java.io.IOException;
import p007b.p225i.p226a.p242c.p257e3.DataSpec;

/* JADX INFO: loaded from: classes3.dex */
public final class HttpDataSource$CleartextNotPermittedException extends HttpDataSource$HttpDataSourceException {
    public HttpDataSource$CleartextNotPermittedException(IOException iOException, DataSpec dataSpec) {
        super("Cleartext HTTP traffic not permitted. See https://exoplayer.dev/issues/cleartext-not-permitted", iOException, dataSpec, 2007, 1);
    }
}
