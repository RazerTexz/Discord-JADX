package p007b.p195g.p196a.p198b.p200p;

import java.io.IOException;
import java.io.Writer;
import p007b.p195g.p196a.p198b.p204t.BufferRecycler;
import p007b.p195g.p196a.p198b.p204t.TextBuffer;

/* JADX INFO: renamed from: b.g.a.b.p.i, reason: use source file name */
/* JADX INFO: compiled from: SegmentedStringWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SegmentedStringWriter extends Writer {

    /* JADX INFO: renamed from: j */
    public final TextBuffer f4557j;

    public SegmentedStringWriter(BufferRecycler bufferRecycler) {
        this.f4557j = new TextBuffer(bufferRecycler);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(CharSequence charSequence) throws IOException {
        append(charSequence);
        return this;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
    }

    @Override // java.io.Writer
    public void write(char[] cArr) {
        this.f4557j.m1740b(cArr, 0, cArr.length);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(CharSequence charSequence, int i, int i2) throws IOException {
        append(charSequence, i, i2);
        return this;
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        this.f4557j.m1740b(cArr, i, i2);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c) {
        write(c);
        return this;
    }

    @Override // java.io.Writer
    public void write(int i) {
        TextBuffer textBuffer = this.f4557j;
        char c = (char) i;
        if (textBuffer.f4606c >= 0) {
            textBuffer.m1744f(16);
        }
        textBuffer.f4612i = null;
        textBuffer.f4613j = null;
        char[] cArr = textBuffer.f4610g;
        if (textBuffer.f4611h >= cArr.length) {
            textBuffer.m1742d();
            cArr = textBuffer.f4610g;
        }
        int i2 = textBuffer.f4611h;
        textBuffer.f4611h = i2 + 1;
        cArr[i2] = c;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Appendable append(char c) throws IOException {
        write(c);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence) {
        String string = charSequence.toString();
        this.f4557j.m1739a(string, 0, string.length());
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence, int i, int i2) {
        String string = charSequence.subSequence(i, i2).toString();
        this.f4557j.m1739a(string, 0, string.length());
        return this;
    }

    @Override // java.io.Writer
    public void write(String str) {
        this.f4557j.m1739a(str, 0, str.length());
    }

    @Override // java.io.Writer
    public void write(String str, int i, int i2) {
        this.f4557j.m1739a(str, i, i2);
    }
}
