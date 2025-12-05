package p507d0.p513e0.p514p.p515d.p517m0.p550i;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite;

/* compiled from: AbstractMessageLite.java */
/* renamed from: d0.e0.p.d.m0.i.a, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class AbstractMessageLite implements MessageLite {
    public int memoizedHashCode = 0;

    public void writeDelimitedTo(OutputStream outputStream) throws IOException {
        int serializedSize = getSerializedSize();
        int iComputeRawVarint32Size = CodedOutputStream.computeRawVarint32Size(serializedSize) + serializedSize;
        if (iComputeRawVarint32Size > 4096) {
            iComputeRawVarint32Size = 4096;
        }
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(outputStream, iComputeRawVarint32Size);
        codedOutputStreamNewInstance.writeRawVarint32(serializedSize);
        writeTo(codedOutputStreamNewInstance);
        codedOutputStreamNewInstance.flush();
    }

    /* compiled from: AbstractMessageLite.java */
    /* renamed from: d0.e0.p.d.m0.i.a$a */
    public static abstract class a<BuilderType extends a> implements MessageLite.a {
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        public abstract BuilderType mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException;

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        public /* bridge */ /* synthetic */ MessageLite.a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return mergeFrom(codedInputStream, extensionRegistryLite);
        }

        /* compiled from: AbstractMessageLite.java */
        /* renamed from: d0.e0.p.d.m0.i.a$a$a, reason: collision with other inner class name */
        public static final class C13324a extends FilterInputStream {

            /* renamed from: j */
            public int f24099j;

            public C13324a(InputStream inputStream, int i) {
                super(inputStream);
                this.f24099j = i;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int available() throws IOException {
                return Math.min(super.available(), this.f24099j);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() throws IOException {
                if (this.f24099j <= 0) {
                    return -1;
                }
                int i = super.read();
                if (i >= 0) {
                    this.f24099j--;
                }
                return i;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(long j) throws IOException {
                long jSkip = super.skip(Math.min(j, this.f24099j));
                if (jSkip >= 0) {
                    this.f24099j = (int) (this.f24099j - jSkip);
                }
                return jSkip;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] bArr, int i, int i2) throws IOException {
                int i3 = this.f24099j;
                if (i3 <= 0) {
                    return -1;
                }
                int i4 = super.read(bArr, i, Math.min(i2, i3));
                if (i4 >= 0) {
                    this.f24099j -= i4;
                }
                return i4;
            }
        }
    }
}
