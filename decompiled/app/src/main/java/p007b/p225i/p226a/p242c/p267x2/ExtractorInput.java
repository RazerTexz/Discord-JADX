package p007b.p225i.p226a.p242c.p267x2;

import java.io.IOException;
import p007b.p225i.p226a.p242c.p257e3.DataReader;

/* compiled from: ExtractorInput.java */
/* renamed from: b.i.a.c.x2.i, reason: use source file name */
/* loaded from: classes3.dex */
public interface ExtractorInput extends DataReader {
    /* renamed from: b */
    long mo3642b();

    /* renamed from: c */
    boolean mo3643c(byte[] bArr, int i, int i2, boolean z2) throws IOException;

    /* renamed from: e */
    boolean mo3644e(byte[] bArr, int i, int i2, boolean z2) throws IOException;

    /* renamed from: f */
    long mo3645f();

    /* renamed from: g */
    void mo3646g(int i) throws IOException;

    long getPosition();

    /* renamed from: h */
    int mo3647h(int i) throws IOException;

    /* renamed from: i */
    int mo3648i(byte[] bArr, int i, int i2) throws IOException;

    /* renamed from: k */
    void mo3649k();

    /* renamed from: l */
    void mo3650l(int i) throws IOException;

    /* renamed from: m */
    boolean mo3651m(int i, boolean z2) throws IOException;

    /* renamed from: o */
    void mo3652o(byte[] bArr, int i, int i2) throws IOException;

    @Override // p007b.p225i.p226a.p242c.p257e3.DataReader
    int read(byte[] bArr, int i, int i2) throws IOException;

    void readFully(byte[] bArr, int i, int i2) throws IOException;
}
