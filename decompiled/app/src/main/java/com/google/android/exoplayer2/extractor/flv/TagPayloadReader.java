package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.ParserException;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p267x2.TrackOutput2;

/* loaded from: classes3.dex */
public abstract class TagPayloadReader {

    /* renamed from: a */
    public final TrackOutput2 f19856a;

    public static final class UnsupportedFormatException extends ParserException {
        public UnsupportedFormatException(String str) {
            super(str, null, false, 1);
        }
    }

    public TagPayloadReader(TrackOutput2 trackOutput2) {
        this.f19856a = trackOutput2;
    }

    /* renamed from: a */
    public final boolean m8837a(ParsableByteArray parsableByteArray, long j) throws ParserException {
        return mo3657b(parsableByteArray) && mo3658c(parsableByteArray, j);
    }

    /* renamed from: b */
    public abstract boolean mo3657b(ParsableByteArray parsableByteArray) throws ParserException;

    /* renamed from: c */
    public abstract boolean mo3658c(ParsableByteArray parsableByteArray, long j) throws ParserException;
}
