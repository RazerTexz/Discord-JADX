package p007b.p225i.p226a.p242c.p267x2.p271f0;

import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import java.io.IOException;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParserException;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p267x2.Extractor;
import p007b.p225i.p226a.p242c.p267x2.ExtractorInput;
import p007b.p225i.p226a.p242c.p267x2.ExtractorOutput;
import p007b.p225i.p226a.p242c.p267x2.PositionHolder;
import p007b.p225i.p226a.p242c.p267x2.SeekMap;
import p007b.p225i.p226a.p242c.p267x2.TrackOutput2;
import p007b.p225i.p226a.p242c.p267x2.p271f0.MotionPhotoDescription;
import p007b.p225i.p226a.p242c.p267x2.p274i0.Mp4Extractor;
import p007b.p225i.p226a.p242c.p267x2.p274i0.Sniffer2;

/* JADX INFO: renamed from: b.i.a.c.x2.f0.a, reason: use source file name */
/* JADX INFO: compiled from: JpegExtractor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class JpegExtractor implements Extractor {

    /* JADX INFO: renamed from: b */
    public ExtractorOutput f8156b;

    /* JADX INFO: renamed from: c */
    public int f8157c;

    /* JADX INFO: renamed from: d */
    public int f8158d;

    /* JADX INFO: renamed from: e */
    public int f8159e;

    /* JADX INFO: renamed from: g */
    @Nullable
    public MotionPhotoMetadata f8161g;

    /* JADX INFO: renamed from: h */
    public ExtractorInput f8162h;

    /* JADX INFO: renamed from: i */
    public StartOffsetExtractorInput f8163i;

    /* JADX INFO: renamed from: j */
    @Nullable
    public Mp4Extractor f8164j;

    /* JADX INFO: renamed from: a */
    public final ParsableByteArray f8155a = new ParsableByteArray(6);

    /* JADX INFO: renamed from: f */
    public long f8160f = -1;

    /* JADX INFO: renamed from: a */
    public final void m3665a() {
        m3666c(new Metadata.Entry[0]);
        ExtractorOutput extractorOutput = this.f8156b;
        Objects.requireNonNull(extractorOutput);
        extractorOutput.mo2486j();
        this.f8156b.mo2477a(new SeekMap.b(-9223372036854775807L, 0L));
        this.f8157c = 6;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* JADX INFO: renamed from: b */
    public boolean mo3633b(ExtractorInput extractorInput) throws IOException {
        if (m3667d(extractorInput) != 65496) {
            return false;
        }
        int iM3667d = m3667d(extractorInput);
        this.f8158d = iM3667d;
        if (iM3667d == 65504) {
            this.f8155a.m3075A(2);
            extractorInput.mo3652o(this.f8155a.f6793a, 0, 2);
            extractorInput.mo3646g(this.f8155a.m3105y() - 2);
            this.f8158d = m3667d(extractorInput);
        }
        if (this.f8158d != 65505) {
            return false;
        }
        extractorInput.mo3646g(2);
        this.f8155a.m3075A(6);
        extractorInput.mo3652o(this.f8155a.f6793a, 0, 6);
        return this.f8155a.m3101u() == 1165519206 && this.f8155a.m3105y() == 0;
    }

    /* JADX INFO: renamed from: c */
    public final void m3666c(Metadata.Entry... entryArr) {
        ExtractorOutput extractorOutput = this.f8156b;
        Objects.requireNonNull(extractorOutput);
        TrackOutput2 trackOutput2Mo2492p = extractorOutput.mo2492p(1024, 4);
        Format2.b bVar = new Format2.b();
        bVar.f7172j = "image/jpeg";
        bVar.f7171i = new Metadata(entryArr);
        trackOutput2Mo2492p.mo2526e(bVar.m3277a());
    }

    /* JADX INFO: renamed from: d */
    public final int m3667d(ExtractorInput extractorInput) throws IOException {
        this.f8155a.m3075A(2);
        extractorInput.mo3652o(this.f8155a.f6793a, 0, 2);
        return this.f8155a.m3105y();
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* JADX INFO: renamed from: e */
    public int mo3635e(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int i;
        String strM3005m;
        String strM3005m2;
        MotionPhotoDescription motionPhotoDescriptionM3668a;
        long j;
        int i2 = this.f8157c;
        if (i2 == 0) {
            this.f8155a.m3075A(2);
            extractorInput.readFully(this.f8155a.f6793a, 0, 2);
            int iM3105y = this.f8155a.m3105y();
            this.f8158d = iM3105y;
            if (iM3105y == 65498) {
                if (this.f8160f != -1) {
                    this.f8157c = 4;
                } else {
                    m3665a();
                }
            } else if ((iM3105y < 65488 || iM3105y > 65497) && iM3105y != 65281) {
                this.f8157c = 1;
            }
            return 0;
        }
        if (i2 == 1) {
            this.f8155a.m3075A(2);
            extractorInput.readFully(this.f8155a.f6793a, 0, 2);
            this.f8159e = this.f8155a.m3105y() - 2;
            this.f8157c = 2;
            return 0;
        }
        if (i2 != 2) {
            if (i2 != 4) {
                if (i2 != 5) {
                    if (i2 == 6) {
                        return -1;
                    }
                    throw new IllegalStateException();
                }
                if (this.f8163i == null || extractorInput != this.f8162h) {
                    this.f8162h = extractorInput;
                    this.f8163i = new StartOffsetExtractorInput(extractorInput, this.f8160f);
                }
                Mp4Extractor mp4Extractor = this.f8164j;
                Objects.requireNonNull(mp4Extractor);
                int iMo3635e = mp4Extractor.mo3635e(this.f8163i, positionHolder);
                if (iMo3635e == 1) {
                    positionHolder.f8992a += this.f8160f;
                }
                return iMo3635e;
            }
            long position = extractorInput.getPosition();
            long j2 = this.f8160f;
            if (position != j2) {
                positionHolder.f8992a = j2;
                return 1;
            }
            if (extractorInput.mo3644e(this.f8155a.f6793a, 0, 1, true)) {
                extractorInput.mo3649k();
                if (this.f8164j == null) {
                    this.f8164j = new Mp4Extractor(0);
                }
                StartOffsetExtractorInput startOffsetExtractorInput = new StartOffsetExtractorInput(extractorInput, this.f8160f);
                this.f8163i = startOffsetExtractorInput;
                if (Sniffer2.m3730a(startOffsetExtractorInput, false, (this.f8164j.f8420b & 2) != 0)) {
                    Mp4Extractor mp4Extractor2 = this.f8164j;
                    long j3 = this.f8160f;
                    ExtractorOutput extractorOutput = this.f8156b;
                    Objects.requireNonNull(extractorOutput);
                    mp4Extractor2.f8437s = new StartOffsetExtractorOutput(j3, extractorOutput);
                    MotionPhotoMetadata motionPhotoMetadata = this.f8161g;
                    Objects.requireNonNull(motionPhotoMetadata);
                    m3666c(motionPhotoMetadata);
                    this.f8157c = 5;
                } else {
                    m3665a();
                }
            } else {
                m3665a();
            }
            return 0;
        }
        if (this.f8158d == 65505) {
            int i3 = this.f8159e;
            byte[] bArr = new byte[i3];
            extractorInput.readFully(bArr, 0, i3);
            if (this.f8161g == null) {
                MotionPhotoMetadata motionPhotoMetadata2 = null;
                if (i3 + 0 == 0) {
                    strM3005m = null;
                    i = 0;
                } else {
                    i = 0;
                    while (i < i3 && bArr[i] != 0) {
                        i++;
                    }
                    strM3005m = Util2.m3005m(bArr, 0, i + 0);
                    if (i < i3) {
                        i++;
                    }
                }
                if ("http://ns.adobe.com/xap/1.0/".equals(strM3005m)) {
                    if (i3 - i == 0) {
                        strM3005m2 = null;
                    } else {
                        int i4 = i;
                        while (i4 < i3 && bArr[i4] != 0) {
                            i4++;
                        }
                        strM3005m2 = Util2.m3005m(bArr, i, i4 - i);
                    }
                    if (strM3005m2 != null) {
                        long jMo3642b = extractorInput.mo3642b();
                        if (jMo3642b != -1) {
                            try {
                                motionPhotoDescriptionM3668a = XmpMotionPhotoDescriptionParser.m3668a(strM3005m2);
                            } catch (ParserException | NumberFormatException | XmlPullParserException unused) {
                                Log.w("MotionPhotoXmpParser", "Ignoring unexpected XMP metadata");
                                motionPhotoDescriptionM3668a = null;
                            }
                            if (motionPhotoDescriptionM3668a != null && motionPhotoDescriptionM3668a.f8166b.size() >= 2) {
                                long j4 = -1;
                                long j5 = -1;
                                long j6 = -1;
                                long j7 = -1;
                                boolean zEquals = false;
                                for (int size = motionPhotoDescriptionM3668a.f8166b.size() - 1; size >= 0; size--) {
                                    MotionPhotoDescription.a aVar = motionPhotoDescriptionM3668a.f8166b.get(size);
                                    zEquals |= "video/mp4".equals(aVar.f8167a);
                                    if (size == 0) {
                                        j = jMo3642b - aVar.f8169c;
                                        jMo3642b = 0;
                                    } else {
                                        long j8 = jMo3642b - aVar.f8168b;
                                        j = jMo3642b;
                                        jMo3642b = j8;
                                    }
                                    if (zEquals && jMo3642b != j) {
                                        j7 = j - jMo3642b;
                                        j6 = jMo3642b;
                                        zEquals = false;
                                    }
                                    if (size == 0) {
                                        j5 = j;
                                        j4 = jMo3642b;
                                    }
                                }
                                if (j6 != -1 && j7 != -1 && j4 != -1 && j5 != -1) {
                                    motionPhotoMetadata2 = new MotionPhotoMetadata(j4, j5, motionPhotoDescriptionM3668a.f8165a, j6, j7);
                                }
                            }
                        }
                        this.f8161g = motionPhotoMetadata2;
                        if (motionPhotoMetadata2 != null) {
                            this.f8160f = motionPhotoMetadata2.f20011m;
                        }
                    }
                }
            }
        } else {
            extractorInput.mo3650l(this.f8159e);
        }
        this.f8157c = 0;
        return 0;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* JADX INFO: renamed from: f */
    public void mo3636f(ExtractorOutput extractorOutput) {
        this.f8156b = extractorOutput;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* JADX INFO: renamed from: g */
    public void mo3637g(long j, long j2) {
        if (j == 0) {
            this.f8157c = 0;
            this.f8164j = null;
        } else if (this.f8157c == 5) {
            Mp4Extractor mp4Extractor = this.f8164j;
            Objects.requireNonNull(mp4Extractor);
            mp4Extractor.mo3637g(j, j2);
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    public void release() {
        Mp4Extractor mp4Extractor = this.f8164j;
        if (mp4Extractor != null) {
            Objects.requireNonNull(mp4Extractor);
        }
    }
}
