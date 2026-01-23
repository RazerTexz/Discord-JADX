package p007b.p225i.p226a.p242c.p267x2.p276k0;

import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.objectweb.asm.Opcodes;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p242c.p259f3.ParsableBitArray;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p259f3.TimestampAdjuster;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p267x2.Extractor;
import p007b.p225i.p226a.p242c.p267x2.ExtractorInput;
import p007b.p225i.p226a.p242c.p267x2.ExtractorOutput;
import p007b.p225i.p226a.p242c.p267x2.PositionHolder;
import p007b.p225i.p226a.p242c.p267x2.SeekMap;
import p007b.p225i.p226a.p242c.p267x2.p276k0.TsPayloadReader;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.h0, reason: use source file name */
/* JADX INFO: compiled from: TsExtractor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class TsExtractor implements Extractor {

    /* JADX INFO: renamed from: a */
    public final int f8635a;

    /* JADX INFO: renamed from: b */
    public final int f8636b;

    /* JADX INFO: renamed from: c */
    public final List<TimestampAdjuster> f8637c;

    /* JADX INFO: renamed from: d */
    public final ParsableByteArray f8638d;

    /* JADX INFO: renamed from: e */
    public final SparseIntArray f8639e;

    /* JADX INFO: renamed from: f */
    public final TsPayloadReader.c f8640f;

    /* JADX INFO: renamed from: g */
    public final SparseArray<TsPayloadReader> f8641g;

    /* JADX INFO: renamed from: h */
    public final SparseBooleanArray f8642h;

    /* JADX INFO: renamed from: i */
    public final SparseBooleanArray f8643i;

    /* JADX INFO: renamed from: j */
    public final TsDurationReader f8644j;

    /* JADX INFO: renamed from: k */
    public TsBinarySearchSeeker f8645k;

    /* JADX INFO: renamed from: l */
    public ExtractorOutput f8646l;

    /* JADX INFO: renamed from: m */
    public int f8647m;

    /* JADX INFO: renamed from: n */
    public boolean f8648n;

    /* JADX INFO: renamed from: o */
    public boolean f8649o;

    /* JADX INFO: renamed from: p */
    public boolean f8650p;

    /* JADX INFO: renamed from: q */
    @Nullable
    public TsPayloadReader f8651q;

    /* JADX INFO: renamed from: r */
    public int f8652r;

    /* JADX INFO: renamed from: s */
    public int f8653s;

    /* JADX INFO: renamed from: b.i.a.c.x2.k0.h0$a */
    /* JADX INFO: compiled from: TsExtractor.java */
    public class a implements SectionPayloadReader {

        /* JADX INFO: renamed from: a */
        public final ParsableBitArray f8654a = new ParsableBitArray(new byte[4]);

        public a() {
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.SectionPayloadReader
        /* JADX INFO: renamed from: a */
        public void mo3752a(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.d dVar) {
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.SectionPayloadReader
        /* JADX INFO: renamed from: b */
        public void mo3753b(ParsableByteArray parsableByteArray) {
            if (parsableByteArray.m3100t() == 0 && (parsableByteArray.m3100t() & 128) != 0) {
                parsableByteArray.m3080F(6);
                int iM3081a = parsableByteArray.m3081a() / 4;
                for (int i = 0; i < iM3081a; i++) {
                    parsableByteArray.m3084d(this.f8654a, 4);
                    int iM3067g = this.f8654a.m3067g(16);
                    this.f8654a.m3073m(3);
                    if (iM3067g == 0) {
                        this.f8654a.m3073m(13);
                    } else {
                        int iM3067g2 = this.f8654a.m3067g(13);
                        if (TsExtractor.this.f8641g.get(iM3067g2) == null) {
                            TsExtractor tsExtractor = TsExtractor.this;
                            tsExtractor.f8641g.put(iM3067g2, new SectionReader(tsExtractor.new b(iM3067g2)));
                            TsExtractor.this.f8647m++;
                        }
                    }
                }
                TsExtractor tsExtractor2 = TsExtractor.this;
                if (tsExtractor2.f8635a != 2) {
                    tsExtractor2.f8641g.remove(0);
                }
            }
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.x2.k0.h0$b */
    /* JADX INFO: compiled from: TsExtractor.java */
    public class b implements SectionPayloadReader {

        /* JADX INFO: renamed from: a */
        public final ParsableBitArray f8656a = new ParsableBitArray(new byte[5]);

        /* JADX INFO: renamed from: b */
        public final SparseArray<TsPayloadReader> f8657b = new SparseArray<>();

        /* JADX INFO: renamed from: c */
        public final SparseIntArray f8658c = new SparseIntArray();

        /* JADX INFO: renamed from: d */
        public final int f8659d;

        public b(int i) {
            this.f8659d = i;
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.SectionPayloadReader
        /* JADX INFO: renamed from: a */
        public void mo3752a(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.d dVar) {
        }

        /* JADX WARN: Removed duplicated region for block: B:47:0x012c  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x0134  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x0141  */
        @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.SectionPayloadReader
        /* JADX INFO: renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void mo3753b(ParsableByteArray parsableByteArray) {
            TimestampAdjuster timestampAdjuster;
            TimestampAdjuster timestampAdjuster2;
            int i;
            int i2;
            int i3;
            TimestampAdjuster timestampAdjuster3;
            int i4;
            if (parsableByteArray.m3100t() != 2) {
                return;
            }
            TsExtractor tsExtractor = TsExtractor.this;
            int i5 = tsExtractor.f8635a;
            if (i5 == 1 || i5 == 2 || tsExtractor.f8647m == 1) {
                timestampAdjuster = tsExtractor.f8637c.get(0);
            } else {
                timestampAdjuster = new TimestampAdjuster(tsExtractor.f8637c.get(0).m2974c());
                TsExtractor.this.f8637c.add(timestampAdjuster);
            }
            if ((parsableByteArray.m3100t() & 128) == 0) {
                return;
            }
            parsableByteArray.m3080F(1);
            int iM3105y = parsableByteArray.m3105y();
            int i6 = 3;
            parsableByteArray.m3080F(3);
            parsableByteArray.m3084d(this.f8656a, 2);
            this.f8656a.m3073m(3);
            int i7 = 13;
            TsExtractor.this.f8653s = this.f8656a.m3067g(13);
            parsableByteArray.m3084d(this.f8656a, 2);
            int i8 = 4;
            this.f8656a.m3073m(4);
            int i9 = 12;
            parsableByteArray.m3080F(this.f8656a.m3067g(12));
            TsExtractor tsExtractor2 = TsExtractor.this;
            int i10 = 21;
            if (tsExtractor2.f8635a == 2 && tsExtractor2.f8651q == null) {
                TsPayloadReader.b bVar = new TsPayloadReader.b(21, null, null, Util2.f6713f);
                TsExtractor tsExtractor3 = TsExtractor.this;
                tsExtractor3.f8651q = tsExtractor3.f8640f.mo3764a(21, bVar);
                TsExtractor tsExtractor4 = TsExtractor.this;
                TsPayloadReader tsPayloadReader = tsExtractor4.f8651q;
                if (tsPayloadReader != null) {
                    tsPayloadReader.mo3754a(timestampAdjuster, tsExtractor4.f8646l, new TsPayloadReader.d(iM3105y, 21, 8192));
                }
            }
            this.f8657b.clear();
            this.f8658c.clear();
            int iM3081a = parsableByteArray.m3081a();
            while (iM3081a > 0) {
                int i11 = 5;
                parsableByteArray.m3084d(this.f8656a, 5);
                int iM3067g = this.f8656a.m3067g(8);
                this.f8656a.m3073m(i6);
                int iM3067g2 = this.f8656a.m3067g(i7);
                this.f8656a.m3073m(i8);
                int iM3067g3 = this.f8656a.m3067g(i9);
                int i12 = parsableByteArray.f6794b;
                int i13 = iM3067g3 + i12;
                int i14 = -1;
                String strTrim = null;
                ArrayList arrayList = null;
                while (parsableByteArray.f6794b < i13) {
                    int iM3100t = parsableByteArray.m3100t();
                    int iM3100t2 = parsableByteArray.f6794b + parsableByteArray.m3100t();
                    if (iM3100t2 > i13) {
                        break;
                    }
                    if (iM3100t == i11) {
                        long jM3101u = parsableByteArray.m3101u();
                        if (jM3101u == 1094921523) {
                            i14 = Opcodes.LOR;
                        } else if (jM3101u == 1161904947) {
                            i14 = Opcodes.I2D;
                        } else if (jM3101u == 1094921524) {
                            i14 = Opcodes.IRETURN;
                        } else if (jM3101u == 1212503619) {
                            i14 = 36;
                        }
                        i3 = iM3105y;
                        timestampAdjuster3 = timestampAdjuster;
                        i4 = iM3067g2;
                    } else {
                        if (iM3100t != 106) {
                            if (iM3100t != 122) {
                                if (iM3100t == 127) {
                                    if (parsableByteArray.m3100t() == i10) {
                                    }
                                } else if (iM3100t == 123) {
                                    i14 = Opcodes.L2D;
                                } else if (iM3100t == 10) {
                                    strTrim = parsableByteArray.m3097q(3).trim();
                                    i3 = iM3105y;
                                    timestampAdjuster3 = timestampAdjuster;
                                    i4 = iM3067g2;
                                } else {
                                    int i15 = 3;
                                    if (iM3100t == 89) {
                                        ArrayList arrayList2 = new ArrayList();
                                        while (parsableByteArray.f6794b < iM3100t2) {
                                            String strTrim2 = parsableByteArray.m3097q(i15).trim();
                                            int iM3100t3 = parsableByteArray.m3100t();
                                            byte[] bArr = new byte[4];
                                            System.arraycopy(parsableByteArray.f6793a, parsableByteArray.f6794b, bArr, 0, 4);
                                            parsableByteArray.f6794b += 4;
                                            arrayList2.add(new TsPayloadReader.a(strTrim2, iM3100t3, bArr));
                                            timestampAdjuster = timestampAdjuster;
                                            iM3105y = iM3105y;
                                            iM3067g2 = iM3067g2;
                                            i15 = 3;
                                        }
                                        i3 = iM3105y;
                                        timestampAdjuster3 = timestampAdjuster;
                                        i4 = iM3067g2;
                                        arrayList = arrayList2;
                                        i14 = 89;
                                    } else {
                                        i3 = iM3105y;
                                        timestampAdjuster3 = timestampAdjuster;
                                        i4 = iM3067g2;
                                        if (iM3100t == 111) {
                                            i14 = 257;
                                        }
                                    }
                                }
                            }
                        }
                        i3 = iM3105y;
                        timestampAdjuster3 = timestampAdjuster;
                        i4 = iM3067g2;
                    }
                    parsableByteArray.m3080F(iM3100t2 - parsableByteArray.f6794b);
                    timestampAdjuster = timestampAdjuster3;
                    iM3105y = i3;
                    iM3067g2 = i4;
                    i11 = 5;
                    i10 = 21;
                }
                int i16 = iM3105y;
                TimestampAdjuster timestampAdjuster4 = timestampAdjuster;
                int i17 = iM3067g2;
                parsableByteArray.m3079E(i13);
                TsPayloadReader.b bVar2 = new TsPayloadReader.b(i14, strTrim, arrayList, Arrays.copyOfRange(parsableByteArray.f6793a, i12, i13));
                if (iM3067g == 6 || iM3067g == 5) {
                    iM3067g = i14;
                }
                iM3081a -= iM3067g3 + 5;
                TsExtractor tsExtractor5 = TsExtractor.this;
                int i18 = tsExtractor5.f8635a == 2 ? iM3067g : i17;
                if (!tsExtractor5.f8642h.get(i18)) {
                    TsExtractor tsExtractor6 = TsExtractor.this;
                    TsPayloadReader tsPayloadReaderMo3764a = (tsExtractor6.f8635a == 2 && iM3067g == 21) ? tsExtractor6.f8651q : tsExtractor6.f8640f.mo3764a(iM3067g, bVar2);
                    if (TsExtractor.this.f8635a == 2) {
                        i2 = i17;
                        if (i2 < this.f8658c.get(i18, 8192)) {
                        }
                    } else {
                        i2 = i17;
                    }
                    this.f8658c.put(i18, i2);
                    this.f8657b.put(i18, tsPayloadReaderMo3764a);
                }
                timestampAdjuster = timestampAdjuster4;
                iM3105y = i16;
                i6 = 3;
                i8 = 4;
                i7 = 13;
                i9 = 12;
                i10 = 21;
            }
            int i19 = iM3105y;
            TimestampAdjuster timestampAdjuster5 = timestampAdjuster;
            int size = this.f8658c.size();
            int i20 = 0;
            while (i20 < size) {
                int iKeyAt = this.f8658c.keyAt(i20);
                int iValueAt = this.f8658c.valueAt(i20);
                TsExtractor.this.f8642h.put(iKeyAt, true);
                TsExtractor.this.f8643i.put(iValueAt, true);
                TsPayloadReader tsPayloadReaderValueAt = this.f8657b.valueAt(i20);
                if (tsPayloadReaderValueAt != null) {
                    TsExtractor tsExtractor7 = TsExtractor.this;
                    if (tsPayloadReaderValueAt != tsExtractor7.f8651q) {
                        ExtractorOutput extractorOutput = tsExtractor7.f8646l;
                        i = i19;
                        TsPayloadReader.d dVar = new TsPayloadReader.d(i, iKeyAt, 8192);
                        timestampAdjuster2 = timestampAdjuster5;
                        tsPayloadReaderValueAt.mo3754a(timestampAdjuster2, extractorOutput, dVar);
                    } else {
                        timestampAdjuster2 = timestampAdjuster5;
                        i = i19;
                    }
                    TsExtractor.this.f8641g.put(iValueAt, tsPayloadReaderValueAt);
                } else {
                    timestampAdjuster2 = timestampAdjuster5;
                    i = i19;
                }
                i20++;
                timestampAdjuster5 = timestampAdjuster2;
                i19 = i;
            }
            TsExtractor tsExtractor8 = TsExtractor.this;
            if (tsExtractor8.f8635a == 2) {
                if (tsExtractor8.f8648n) {
                    return;
                }
                tsExtractor8.f8646l.mo2486j();
                TsExtractor tsExtractor9 = TsExtractor.this;
                tsExtractor9.f8647m = 0;
                tsExtractor9.f8648n = true;
                return;
            }
            tsExtractor8.f8641g.remove(this.f8659d);
            TsExtractor tsExtractor10 = TsExtractor.this;
            int i21 = tsExtractor10.f8635a == 1 ? 0 : tsExtractor10.f8647m - 1;
            tsExtractor10.f8647m = i21;
            if (i21 == 0) {
                tsExtractor10.f8646l.mo2486j();
                TsExtractor.this.f8648n = true;
            }
        }
    }

    static {
        C3078e c3078e = C3078e.f8601a;
    }

    public TsExtractor(int i, int i2, int i3) {
        TimestampAdjuster timestampAdjuster = new TimestampAdjuster(0L);
        DefaultTsPayloadReaderFactory defaultTsPayloadReaderFactory = new DefaultTsPayloadReaderFactory(i2);
        this.f8640f = defaultTsPayloadReaderFactory;
        this.f8636b = i3;
        this.f8635a = i;
        if (i == 1 || i == 2) {
            this.f8637c = Collections.singletonList(timestampAdjuster);
        } else {
            ArrayList arrayList = new ArrayList();
            this.f8637c = arrayList;
            arrayList.add(timestampAdjuster);
        }
        this.f8638d = new ParsableByteArray(new byte[9400], 0);
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        this.f8642h = sparseBooleanArray;
        this.f8643i = new SparseBooleanArray();
        SparseArray<TsPayloadReader> sparseArray = new SparseArray<>();
        this.f8641g = sparseArray;
        this.f8639e = new SparseIntArray();
        this.f8644j = new TsDurationReader(i3);
        this.f8646l = ExtractorOutput.f8501d;
        this.f8653s = -1;
        sparseBooleanArray.clear();
        sparseArray.clear();
        SparseArray<TsPayloadReader> sparseArrayM3775b = defaultTsPayloadReaderFactory.m3775b();
        int size = sparseArrayM3775b.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.f8641g.put(sparseArrayM3775b.keyAt(i4), sparseArrayM3775b.valueAt(i4));
        }
        this.f8641g.put(0, new SectionReader(new a()));
        this.f8651q = null;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* JADX INFO: renamed from: b */
    public boolean mo3633b(ExtractorInput extractorInput) throws IOException {
        boolean z2;
        byte[] bArr = this.f8638d.f6793a;
        extractorInput.mo3652o(bArr, 0, 940);
        for (int i = 0; i < 188; i++) {
            int i2 = 0;
            while (true) {
                if (i2 >= 5) {
                    z2 = true;
                    break;
                }
                if (bArr[(i2 * Opcodes.NEWARRAY) + i] != 71) {
                    z2 = false;
                    break;
                }
                i2++;
            }
            if (z2) {
                extractorInput.mo3650l(i);
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v9 */
    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* JADX INFO: renamed from: e */
    public int mo3635e(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        ?? r0;
        ?? r1;
        boolean z2;
        int i;
        boolean z3;
        boolean z4;
        long jMo3642b = extractorInput.mo3642b();
        int i2 = 1;
        if (this.f8648n) {
            long j = -9223372036854775807L;
            if ((jMo3642b == -1 || this.f8635a == 2) ? false : true) {
                TsDurationReader tsDurationReader = this.f8644j;
                if (!tsDurationReader.f8626d) {
                    int i3 = this.f8653s;
                    if (i3 <= 0) {
                        tsDurationReader.m3763a(extractorInput);
                        return 0;
                    }
                    if (!tsDurationReader.f8628f) {
                        long jMo3642b2 = extractorInput.mo3642b();
                        int iMin = (int) Math.min(tsDurationReader.f8623a, jMo3642b2);
                        long j2 = jMo3642b2 - ((long) iMin);
                        if (extractorInput.getPosition() != j2) {
                            positionHolder.f8992a = j2;
                        } else {
                            tsDurationReader.f8625c.m3075A(iMin);
                            extractorInput.mo3649k();
                            extractorInput.mo3652o(tsDurationReader.f8625c.f6793a, 0, iMin);
                            ParsableByteArray parsableByteArray = tsDurationReader.f8625c;
                            int i4 = parsableByteArray.f6794b;
                            int i5 = parsableByteArray.f6795c;
                            int i6 = i5 - 188;
                            while (true) {
                                if (i6 < i4) {
                                    break;
                                }
                                byte[] bArr = parsableByteArray.f6793a;
                                int i7 = -4;
                                int i8 = 0;
                                while (true) {
                                    if (i7 > 4) {
                                        z4 = false;
                                        break;
                                    }
                                    int i9 = (i7 * Opcodes.NEWARRAY) + i6;
                                    if (i9 < i4 || i9 >= i5 || bArr[i9] != 71) {
                                        i8 = 0;
                                    } else {
                                        i8++;
                                        if (i8 == 5) {
                                            z4 = true;
                                            break;
                                        }
                                    }
                                    i7++;
                                }
                                if (z4) {
                                    long jM449K1 = AnimatableValueParser.m449K1(parsableByteArray, i6, i3);
                                    if (jM449K1 != -9223372036854775807L) {
                                        j = jM449K1;
                                        break;
                                    }
                                }
                                i6--;
                            }
                            tsDurationReader.f8630h = j;
                            tsDurationReader.f8628f = true;
                            i2 = 0;
                        }
                    } else {
                        if (tsDurationReader.f8630h == -9223372036854775807L) {
                            tsDurationReader.m3763a(extractorInput);
                            return 0;
                        }
                        if (tsDurationReader.f8627e) {
                            long j3 = tsDurationReader.f8629g;
                            if (j3 == -9223372036854775807L) {
                                tsDurationReader.m3763a(extractorInput);
                                return 0;
                            }
                            long jM2973b = tsDurationReader.f8624b.m2973b(tsDurationReader.f8630h) - tsDurationReader.f8624b.m2973b(j3);
                            tsDurationReader.f8631i = jM2973b;
                            if (jM2973b < 0) {
                                Log.w("TsDurationReader", outline.m855i(65, "Invalid duration: ", jM2973b, ". Using TIME_UNSET instead."));
                                tsDurationReader.f8631i = -9223372036854775807L;
                            }
                            tsDurationReader.m3763a(extractorInput);
                            return 0;
                        }
                        int iMin2 = (int) Math.min(tsDurationReader.f8623a, extractorInput.mo3642b());
                        long j4 = 0;
                        if (extractorInput.getPosition() != j4) {
                            positionHolder.f8992a = j4;
                        } else {
                            tsDurationReader.f8625c.m3075A(iMin2);
                            extractorInput.mo3649k();
                            extractorInput.mo3652o(tsDurationReader.f8625c.f6793a, 0, iMin2);
                            ParsableByteArray parsableByteArray2 = tsDurationReader.f8625c;
                            int i10 = parsableByteArray2.f6794b;
                            int i11 = parsableByteArray2.f6795c;
                            while (true) {
                                if (i10 >= i11) {
                                    break;
                                }
                                if (parsableByteArray2.f6793a[i10] == 71) {
                                    long jM449K12 = AnimatableValueParser.m449K1(parsableByteArray2, i10, i3);
                                    if (jM449K12 != -9223372036854775807L) {
                                        j = jM449K12;
                                        break;
                                    }
                                }
                                i10++;
                            }
                            tsDurationReader.f8629g = j;
                            tsDurationReader.f8627e = true;
                            i2 = 0;
                        }
                    }
                    return i2;
                }
            }
            if (!this.f8649o) {
                this.f8649o = true;
                TsDurationReader tsDurationReader2 = this.f8644j;
                long j5 = tsDurationReader2.f8631i;
                if (j5 != -9223372036854775807L) {
                    TsBinarySearchSeeker tsBinarySearchSeeker = new TsBinarySearchSeeker(tsDurationReader2.f8624b, j5, jMo3642b, this.f8653s, this.f8636b);
                    this.f8645k = tsBinarySearchSeeker;
                    this.f8646l.mo2477a(tsBinarySearchSeeker.f8030a);
                } else {
                    this.f8646l.mo2477a(new SeekMap.b(j5, 0L));
                }
            }
            if (this.f8650p) {
                z3 = false;
                this.f8650p = false;
                mo3637g(0L, 0L);
                if (extractorInput.getPosition() != 0) {
                    positionHolder.f8992a = 0L;
                    return 1;
                }
            } else {
                z3 = false;
            }
            r1 = 1;
            r1 = 1;
            TsBinarySearchSeeker tsBinarySearchSeeker2 = this.f8645k;
            r0 = z3;
            if (tsBinarySearchSeeker2 != null) {
                r0 = z3;
                if (tsBinarySearchSeeker2.m3614b()) {
                    return this.f8645k.m3613a(extractorInput, positionHolder);
                }
            }
        } else {
            r0 = 0;
            r1 = 1;
        }
        ParsableByteArray parsableByteArray3 = this.f8638d;
        byte[] bArr2 = parsableByteArray3.f6793a;
        if (9400 - parsableByteArray3.f6794b < 188) {
            int iM3081a = parsableByteArray3.m3081a();
            if (iM3081a > 0) {
                System.arraycopy(bArr2, this.f8638d.f6794b, bArr2, r0, iM3081a);
            }
            this.f8638d.m3077C(bArr2, iM3081a);
        }
        while (true) {
            if (this.f8638d.m3081a() >= 188) {
                z2 = true;
                break;
            }
            int i12 = this.f8638d.f6795c;
            int i13 = extractorInput.read(bArr2, i12, 9400 - i12);
            if (i13 == -1) {
                z2 = false;
                break;
            }
            this.f8638d.m3078D(i12 + i13);
        }
        if (!z2) {
            return -1;
        }
        ParsableByteArray parsableByteArray4 = this.f8638d;
        int i14 = parsableByteArray4.f6794b;
        int i15 = parsableByteArray4.f6795c;
        byte[] bArr3 = parsableByteArray4.f6793a;
        int i16 = i14;
        while (i16 < i15 && bArr3[i16] != 71) {
            i16++;
        }
        this.f8638d.m3079E(i16);
        int i17 = i16 + Opcodes.NEWARRAY;
        if (i17 > i15) {
            int i18 = (i16 - i14) + this.f8652r;
            this.f8652r = i18;
            i = 2;
            if (this.f8635a == 2 && i18 > 376) {
                throw ParserException.m8755a("Cannot find sync byte. Most likely not a Transport Stream.", null);
            }
        } else {
            i = 2;
            this.f8652r = r0;
        }
        ParsableByteArray parsableByteArray5 = this.f8638d;
        int i19 = parsableByteArray5.f6795c;
        if (i17 > i19) {
            return r0;
        }
        int iM3086f = parsableByteArray5.m3086f();
        if ((8388608 & iM3086f) != 0) {
            this.f8638d.m3079E(i17);
            return r0;
        }
        int i20 = ((4194304 & iM3086f) != 0 ? 1 : 0) | 0;
        int i21 = (2096896 & iM3086f) >> 8;
        boolean z5 = (iM3086f & 32) != 0;
        TsPayloadReader tsPayloadReader = (iM3086f & 16) != 0 ? this.f8641g.get(i21) : null;
        if (tsPayloadReader == null) {
            this.f8638d.m3079E(i17);
            return r0;
        }
        if (this.f8635a != i) {
            int i22 = iM3086f & 15;
            int i23 = this.f8639e.get(i21, i22 - 1);
            this.f8639e.put(i21, i22);
            if (i23 == i22) {
                this.f8638d.m3079E(i17);
                return r0;
            }
            if (i22 != ((i23 + r1) & 15)) {
                tsPayloadReader.mo3756c();
            }
        }
        if (z5) {
            int iM3100t = this.f8638d.m3100t();
            i20 |= (this.f8638d.m3100t() & 64) != 0 ? 2 : 0;
            this.f8638d.m3080F(iM3100t - r1);
        }
        boolean z6 = this.f8648n;
        if (this.f8635a == i || z6 || !this.f8643i.get(i21, r0)) {
            this.f8638d.m3078D(i17);
            tsPayloadReader.mo3755b(this.f8638d, i20);
            this.f8638d.m3078D(i19);
        }
        if (this.f8635a != i && !z6 && this.f8648n && jMo3642b != -1) {
            this.f8650p = r1;
        }
        this.f8638d.m3079E(i17);
        return r0;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* JADX INFO: renamed from: f */
    public void mo3636f(ExtractorOutput extractorOutput) {
        this.f8646l = extractorOutput;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* JADX INFO: renamed from: g */
    public void mo3637g(long j, long j2) {
        TsBinarySearchSeeker tsBinarySearchSeeker;
        AnimatableValueParser.m426D(this.f8635a != 2);
        int size = this.f8637c.size();
        for (int i = 0; i < size; i++) {
            TimestampAdjuster timestampAdjuster = this.f8637c.get(i);
            boolean z2 = timestampAdjuster.m2975d() == -9223372036854775807L;
            if (!z2) {
                long jM2974c = timestampAdjuster.m2974c();
                z2 = (jM2974c == -9223372036854775807L || jM2974c == 0 || jM2974c == j2) ? false : true;
            }
            if (z2) {
                timestampAdjuster.m2976e(j2);
            }
        }
        if (j2 != 0 && (tsBinarySearchSeeker = this.f8645k) != null) {
            tsBinarySearchSeeker.m3617e(j2);
        }
        this.f8638d.m3075A(0);
        this.f8639e.clear();
        for (int i2 = 0; i2 < this.f8641g.size(); i2++) {
            this.f8641g.valueAt(i2).mo3756c();
        }
        this.f8652r = 0;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    public void release() {
    }
}
