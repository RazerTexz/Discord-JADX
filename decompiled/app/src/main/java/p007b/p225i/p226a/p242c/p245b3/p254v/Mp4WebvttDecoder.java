package p007b.p225i.p226a.p242c.p245b3.p254v;

import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;
import p007b.p225i.p226a.p242c.p245b3.Cue;
import p007b.p225i.p226a.p242c.p245b3.SimpleSubtitleDecoder2;
import p007b.p225i.p226a.p242c.p245b3.Subtitle;
import p007b.p225i.p226a.p242c.p245b3.p254v.WebvttCueParser;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p259f3.Util2;

/* JADX INFO: renamed from: b.i.a.c.b3.v.c, reason: use source file name */
/* JADX INFO: compiled from: Mp4WebvttDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Mp4WebvttDecoder extends SimpleSubtitleDecoder2 {

    /* JADX INFO: renamed from: n */
    public final ParsableByteArray f6108n;

    public Mp4WebvttDecoder() {
        super("Mp4WebvttDecoder");
        this.f6108n = new ParsableByteArray();
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.SimpleSubtitleDecoder2
    /* JADX INFO: renamed from: j */
    public Subtitle mo2617j(byte[] bArr, int i, boolean z2) throws SubtitleDecoderException {
        Cue cueM2606a;
        ParsableByteArray parsableByteArray = this.f6108n;
        parsableByteArray.f6793a = bArr;
        parsableByteArray.f6795c = i;
        parsableByteArray.f6794b = 0;
        ArrayList arrayList = new ArrayList();
        while (this.f6108n.m3081a() > 0) {
            if (this.f6108n.m3081a() < 8) {
                throw new SubtitleDecoderException("Incomplete Mp4Webvtt Top Level box header found.");
            }
            int iM3086f = this.f6108n.m3086f();
            if (this.f6108n.m3086f() == 1987343459) {
                ParsableByteArray parsableByteArray2 = this.f6108n;
                int i2 = iM3086f - 8;
                CharSequence charSequenceM2715f = null;
                Cue.b bVarM2718a = null;
                while (i2 > 0) {
                    if (i2 < 8) {
                        throw new SubtitleDecoderException("Incomplete vtt cue box header found.");
                    }
                    int iM3086f2 = parsableByteArray2.m3086f();
                    int iM3086f3 = parsableByteArray2.m3086f();
                    int i3 = iM3086f2 - 8;
                    String strM3005m = Util2.m3005m(parsableByteArray2.f6793a, parsableByteArray2.f6794b, i3);
                    parsableByteArray2.m3080F(i3);
                    i2 = (i2 - 8) - i3;
                    if (iM3086f3 == 1937011815) {
                        WebvttCueParser.e eVar = new WebvttCueParser.e();
                        WebvttCueParser.m2714e(strM3005m, eVar);
                        bVarM2718a = eVar.m2718a();
                    } else if (iM3086f3 == 1885436268) {
                        charSequenceM2715f = WebvttCueParser.m2715f(null, strM3005m.trim(), Collections.emptyList());
                    }
                }
                if (charSequenceM2715f == null) {
                    charSequenceM2715f = "";
                }
                if (bVarM2718a != null) {
                    bVarM2718a.f5773a = charSequenceM2715f;
                    cueM2606a = bVarM2718a.m2606a();
                } else {
                    Pattern pattern = WebvttCueParser.f6134a;
                    WebvttCueParser.e eVar2 = new WebvttCueParser.e();
                    eVar2.f6149c = charSequenceM2715f;
                    cueM2606a = eVar2.m2718a().m2606a();
                }
                arrayList.add(cueM2606a);
            } else {
                this.f6108n.m3080F(iM3086f - 8);
            }
        }
        return new Mp4WebvttSubtitle(arrayList);
    }
}
