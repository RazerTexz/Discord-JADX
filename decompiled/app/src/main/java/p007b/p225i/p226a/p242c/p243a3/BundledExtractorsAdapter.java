package p007b.p225i.p226a.p242c.p243a3;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.UnrecognizedInputFormatException;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p242c.p257e3.DataReader;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p267x2.DefaultExtractorInput;
import p007b.p225i.p226a.p242c.p267x2.Extractor;
import p007b.p225i.p226a.p242c.p267x2.ExtractorInput;
import p007b.p225i.p226a.p242c.p267x2.ExtractorOutput;
import p007b.p225i.p226a.p242c.p267x2.ExtractorsFactory2;

/* compiled from: BundledExtractorsAdapter.java */
/* renamed from: b.i.a.c.a3.m, reason: use source file name */
/* loaded from: classes3.dex */
public final class BundledExtractorsAdapter implements ProgressiveMediaExtractor {

    /* renamed from: a */
    public final ExtractorsFactory2 f5645a;

    /* renamed from: b */
    @Nullable
    public Extractor f5646b;

    /* renamed from: c */
    @Nullable
    public ExtractorInput f5647c;

    public BundledExtractorsAdapter(ExtractorsFactory2 extractorsFactory2) {
        this.f5645a = extractorsFactory2;
    }

    /* renamed from: a */
    public long m2558a() {
        ExtractorInput extractorInput = this.f5647c;
        if (extractorInput != null) {
            return extractorInput.getPosition();
        }
        return -1L;
    }

    /* renamed from: b */
    public void m2559b(DataReader dataReader, Uri uri, Map<String, List<String>> map, long j, long j2, ExtractorOutput extractorOutput) throws IOException {
        DefaultExtractorInput defaultExtractorInput = new DefaultExtractorInput(dataReader, j, j2);
        this.f5647c = defaultExtractorInput;
        if (this.f5646b != null) {
            return;
        }
        Extractor[] extractorArrMo3631b = this.f5645a.mo3631b(uri, map);
        boolean z2 = true;
        if (extractorArrMo3631b.length == 1) {
            this.f5646b = extractorArrMo3631b[0];
        } else {
            int length = extractorArrMo3631b.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                Extractor extractor = extractorArrMo3631b[i];
                try {
                } catch (EOFException unused) {
                    if (this.f5646b != null || defaultExtractorInput.f8117d == j) {
                    }
                } catch (Throwable th) {
                    if (this.f5646b == null && defaultExtractorInput.f8117d != j) {
                        z2 = false;
                    }
                    AnimatableValueParser.m426D(z2);
                    defaultExtractorInput.f8119f = 0;
                    throw th;
                }
                if (extractor.mo3633b(defaultExtractorInput)) {
                    this.f5646b = extractor;
                    AnimatableValueParser.m426D(true);
                    defaultExtractorInput.f8119f = 0;
                    break;
                } else {
                    boolean z3 = this.f5646b != null || defaultExtractorInput.f8117d == j;
                    AnimatableValueParser.m426D(z3);
                    defaultExtractorInput.f8119f = 0;
                    i++;
                }
            }
            if (this.f5646b == null) {
                int i2 = Util2.f6708a;
                StringBuilder sb = new StringBuilder();
                for (int i3 = 0; i3 < extractorArrMo3631b.length; i3++) {
                    sb.append(extractorArrMo3631b[i3].getClass().getSimpleName());
                    if (i3 < extractorArrMo3631b.length - 1) {
                        sb.append(", ");
                    }
                }
                String string = sb.toString();
                StringBuilder sb2 = new StringBuilder(outline.m841b(string, 58));
                sb2.append("None of the available extractors (");
                sb2.append(string);
                sb2.append(") could read the stream.");
                String string2 = sb2.toString();
                Objects.requireNonNull(uri);
                throw new UnrecognizedInputFormatException(string2, uri);
            }
        }
        this.f5646b.mo3636f(extractorOutput);
    }
}
