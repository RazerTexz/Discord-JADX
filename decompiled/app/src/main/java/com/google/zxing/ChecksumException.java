package com.google.zxing;

/* loaded from: classes3.dex */
public final class ChecksumException extends ReaderException {

    /* renamed from: l */
    public static final ChecksumException f21663l;

    static {
        ChecksumException checksumException = new ChecksumException();
        f21663l = checksumException;
        checksumException.setStackTrace(ReaderException.f21667k);
    }

    private ChecksumException() {
    }

    /* renamed from: a */
    public static ChecksumException m9259a() {
        return ReaderException.f21666j ? new ChecksumException() : f21663l;
    }
}
