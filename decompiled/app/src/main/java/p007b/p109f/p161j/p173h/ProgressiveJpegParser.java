package p007b.p109f.p161j.p173h;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p109f.p115d.p119d.Closeables;
import p007b.p109f.p115d.p119d.Throwables;
import p007b.p109f.p115d.p122g.ByteArrayPool;
import p007b.p109f.p115d.p122g.PooledByteArrayBufferedInputStream;
import p007b.p109f.p161j.p175j.EncodedImage2;

/* compiled from: ProgressiveJpegParser.java */
/* renamed from: b.f.j.h.e, reason: use source file name */
/* loaded from: classes.dex */
public class ProgressiveJpegParser {

    /* renamed from: a */
    public int f3873a;

    /* renamed from: b */
    public int f3874b;

    /* renamed from: c */
    public int f3875c;

    /* renamed from: d */
    public int f3876d;

    /* renamed from: e */
    public int f3877e;

    /* renamed from: f */
    public int f3878f;

    /* renamed from: g */
    public boolean f3879g;

    /* renamed from: h */
    public final ByteArrayPool f3880h;

    public ProgressiveJpegParser(ByteArrayPool byteArrayPool) {
        Objects.requireNonNull(byteArrayPool);
        this.f3880h = byteArrayPool;
        this.f3875c = 0;
        this.f3874b = 0;
        this.f3876d = 0;
        this.f3878f = 0;
        this.f3877e = 0;
        this.f3873a = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x00b7, code lost:
    
        if (r11.f3873a == 6) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00bb, code lost:
    
        if (r11.f3877e == r0) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00bd, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:?, code lost:
    
        return false;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m1326a(InputStream inputStream) throws Throwable {
        int i;
        int i2 = this.f3877e;
        while (true) {
            try {
                boolean z2 = false;
                if (this.f3873a == 6 || (i = inputStream.read()) == -1) {
                    break;
                }
                int i3 = this.f3875c + 1;
                this.f3875c = i3;
                if (this.f3879g) {
                    this.f3873a = 6;
                    this.f3879g = false;
                    return false;
                }
                int i4 = this.f3873a;
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 != 2) {
                            if (i4 != 3) {
                                if (i4 == 4) {
                                    this.f3873a = 5;
                                } else if (i4 != 5) {
                                    AnimatableValueParser.m419B(false);
                                } else {
                                    int i5 = ((this.f3874b << 8) + i) - 2;
                                    AnimatableValueParser.m506c2(inputStream, i5);
                                    this.f3875c += i5;
                                    this.f3873a = 2;
                                }
                            } else if (i == 255) {
                                this.f3873a = 3;
                            } else if (i == 0) {
                                this.f3873a = 2;
                            } else if (i == 217) {
                                this.f3879g = true;
                                int i6 = i3 - 2;
                                int i7 = this.f3876d;
                                if (i7 > 0) {
                                    this.f3878f = i6;
                                }
                                this.f3876d = i7 + 1;
                                this.f3877e = i7;
                                this.f3873a = 2;
                            } else {
                                if (i == 218) {
                                    int i8 = i3 - 2;
                                    int i9 = this.f3876d;
                                    if (i9 > 0) {
                                        this.f3878f = i8;
                                    }
                                    this.f3876d = i9 + 1;
                                    this.f3877e = i9;
                                }
                                if (i != 1 && ((i < 208 || i > 215) && i != 217 && i != 216)) {
                                    z2 = true;
                                }
                                if (z2) {
                                    this.f3873a = 4;
                                } else {
                                    this.f3873a = 2;
                                }
                            }
                        } else if (i == 255) {
                            this.f3873a = 3;
                        }
                    } else if (i == 216) {
                        this.f3873a = 2;
                    } else {
                        this.f3873a = 6;
                    }
                } else if (i == 255) {
                    this.f3873a = 1;
                } else {
                    this.f3873a = 6;
                }
                this.f3874b = i;
            } catch (IOException e) {
                Throwables.m972a(e);
                throw new RuntimeException(e);
            }
        }
    }

    /* renamed from: b */
    public boolean m1327b(EncodedImage2 encodedImage2) {
        if (this.f3873a == 6 || encodedImage2.m1344n() <= this.f3875c) {
            return false;
        }
        PooledByteArrayBufferedInputStream pooledByteArrayBufferedInputStream = new PooledByteArrayBufferedInputStream(encodedImage2.m1343f(), this.f3880h.get(16384), this.f3880h);
        try {
            try {
                AnimatableValueParser.m506c2(pooledByteArrayBufferedInputStream, this.f3875c);
                return m1326a(pooledByteArrayBufferedInputStream);
            } catch (IOException e) {
                Throwables.m972a(e);
                throw new RuntimeException(e);
            }
        } finally {
            Closeables.m966b(pooledByteArrayBufferedInputStream);
        }
    }
}
