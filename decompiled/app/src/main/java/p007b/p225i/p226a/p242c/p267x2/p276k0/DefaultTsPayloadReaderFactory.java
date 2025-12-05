package p007b.p225i.p226a.p242c.p267x2.p276k0;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.p267x2.p276k0.TsPayloadReader;
import p007b.p225i.p355b.p356a.Charsets;
import p007b.p225i.p355b.p357b.AbstractIndexedListIterator;
import p007b.p225i.p355b.p357b.ImmutableList2;
import p007b.p225i.p355b.p357b.RegularImmutableList;

/* compiled from: DefaultTsPayloadReaderFactory.java */
/* renamed from: b.i.a.c.x2.k0.l, reason: use source file name */
/* loaded from: classes3.dex */
public final class DefaultTsPayloadReaderFactory implements TsPayloadReader.c {

    /* renamed from: a */
    public final int f8721a;

    /* renamed from: b */
    public final List<Format2> f8722b;

    public DefaultTsPayloadReaderFactory(int i) {
        AbstractIndexedListIterator<Object> abstractIndexedListIterator = ImmutableList2.f12045k;
        ImmutableList2<Object> immutableList2 = RegularImmutableList.f12012l;
        this.f8721a = i;
        this.f8722b = immutableList2;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.TsPayloadReader.c
    @Nullable
    /* renamed from: a */
    public TsPayloadReader mo3764a(int i, TsPayloadReader.b bVar) {
        if (i != 2) {
            if (i == 3 || i == 4) {
                return new PesReader(new MpegAudioReader(bVar.f8677b));
            }
            if (i == 21) {
                return new PesReader(new Id3Reader());
            }
            if (i == 27) {
                if (m3777d(4)) {
                    return null;
                }
                return new PesReader(new H264Reader(new SeiReader(m3776c(bVar)), m3777d(1), m3777d(8)));
            }
            if (i == 36) {
                return new PesReader(new H265Reader(new SeiReader(m3776c(bVar))));
            }
            if (i == 89) {
                return new PesReader(new DvbSubtitleReader(bVar.f8678c));
            }
            if (i != 138) {
                if (i == 172) {
                    return new PesReader(new Ac4Reader(bVar.f8677b));
                }
                if (i == 257) {
                    return new SectionReader(new PassthroughSectionPayloadReader("application/vnd.dvb.ait"));
                }
                if (i == 134) {
                    if (m3777d(16)) {
                        return null;
                    }
                    return new SectionReader(new PassthroughSectionPayloadReader("application/x-scte35"));
                }
                if (i != 135) {
                    switch (i) {
                        case 15:
                            if (!m3777d(2)) {
                                break;
                            }
                            break;
                        case 16:
                            break;
                        case 17:
                            if (!m3777d(2)) {
                                break;
                            }
                            break;
                        default:
                            switch (i) {
                                case 130:
                                    if (!m3777d(64)) {
                                    }
                                    break;
                            }
                            break;
                    }
                    return null;
                }
                return new PesReader(new Ac3Reader(bVar.f8677b));
            }
            return new PesReader(new DtsReader(bVar.f8677b));
        }
        return new PesReader(new H262Reader(new UserDataReader(m3776c(bVar))));
    }

    /* renamed from: b */
    public SparseArray<TsPayloadReader> m3775b() {
        return new SparseArray<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* renamed from: c */
    public final List<Format2> m3776c(TsPayloadReader.b bVar) {
        String str;
        int i;
        if (m3777d(32)) {
            return this.f8722b;
        }
        byte[] bArr = bVar.f8679d;
        int length = bArr.length;
        int i2 = 0;
        ArrayList arrayList = this.f8722b;
        while (length - i2 > 0) {
            int i3 = i2 + 1;
            int i4 = bArr[i2] & 255;
            int i5 = i3 + 1;
            int i6 = (bArr[i3] & 255) + i5;
            boolean z2 = true;
            if (i4 == 134) {
                arrayList = new ArrayList();
                int i7 = i5 + 1;
                int i8 = bArr[i5] & 255 & 31;
                int i9 = 0;
                while (i9 < i8) {
                    String str2 = new String(bArr, i7, 3, Charsets.f11945c);
                    int i10 = i7 + 3;
                    int i11 = i10 + 1;
                    int i12 = bArr[i10] & 255;
                    boolean z3 = (i12 & 128) != 0;
                    if (z3) {
                        i = i12 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i = 1;
                    }
                    int i13 = i11 + 1;
                    byte b2 = (byte) (bArr[i11] & 255);
                    int i14 = i13 + 1;
                    AnimatableValueParser.m531j(i14 >= 0 && i14 <= length);
                    List<byte[]> listSingletonList = null;
                    if (z3) {
                        listSingletonList = Collections.singletonList((b2 & 64) != 0 ? new byte[]{1} : new byte[]{0});
                    }
                    Format2.b bVar2 = new Format2.b();
                    bVar2.f7173k = str;
                    bVar2.f7165c = str2;
                    bVar2.f7161C = i;
                    bVar2.f7175m = listSingletonList;
                    arrayList.add(bVar2.m3277a());
                    i9++;
                    i7 = i14;
                }
            }
            if (i6 < 0 || i6 > length) {
                z2 = false;
            }
            AnimatableValueParser.m531j(z2);
            i2 = i6;
            arrayList = arrayList;
        }
        return arrayList;
    }

    /* renamed from: d */
    public final boolean m3777d(int i) {
        return (i & this.f8721a) != 0;
    }
}
