package com.google.android.exoplayer2.extractor.flv;

import b.i.a.c.f3.x;
import b.i.a.c.x2.w;
import com.google.android.exoplayer2.ParserException;

/* loaded from: classes3.dex */
public abstract class TagPayloadReader {
    public final w a;

    public static final class UnsupportedFormatException extends ParserException {
        public UnsupportedFormatException(String str) {
            super(str, null, false, 1);
        }
    }

    public TagPayloadReader(w wVar) {
        this.a = wVar;
    }

    public final boolean a(x xVar, long j) throws ParserException {
        return b(xVar) && c(xVar, j);
    }

    public abstract boolean b(x xVar) throws ParserException;

    public abstract boolean c(x xVar, long j) throws ParserException;
}
