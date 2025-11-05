package b.i.a.c.b3.v;

import b.i.a.c.b3.b;
import b.i.a.c.b3.v.h;
import b.i.a.c.f3.e0;
import b.i.a.c.f3.x;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

/* compiled from: Mp4WebvttDecoder.java */
/* loaded from: classes3.dex */
public final class c extends b.i.a.c.b3.f {
    public final x n;

    public c() {
        super("Mp4WebvttDecoder");
        this.n = new x();
    }

    @Override // b.i.a.c.b3.f
    public b.i.a.c.b3.g j(byte[] bArr, int i, boolean z2) throws SubtitleDecoderException {
        b.i.a.c.b3.b bVarA;
        x xVar = this.n;
        xVar.a = bArr;
        xVar.c = i;
        xVar.f984b = 0;
        ArrayList arrayList = new ArrayList();
        while (this.n.a() > 0) {
            if (this.n.a() < 8) {
                throw new SubtitleDecoderException("Incomplete Mp4Webvtt Top Level box header found.");
            }
            int iF = this.n.f();
            if (this.n.f() == 1987343459) {
                x xVar2 = this.n;
                int i2 = iF - 8;
                CharSequence charSequenceF = null;
                b.C0093b c0093bA = null;
                while (i2 > 0) {
                    if (i2 < 8) {
                        throw new SubtitleDecoderException("Incomplete vtt cue box header found.");
                    }
                    int iF2 = xVar2.f();
                    int iF3 = xVar2.f();
                    int i3 = iF2 - 8;
                    String strM = e0.m(xVar2.a, xVar2.f984b, i3);
                    xVar2.F(i3);
                    i2 = (i2 - 8) - i3;
                    if (iF3 == 1937011815) {
                        h.e eVar = new h.e();
                        h.e(strM, eVar);
                        c0093bA = eVar.a();
                    } else if (iF3 == 1885436268) {
                        charSequenceF = h.f(null, strM.trim(), Collections.emptyList());
                    }
                }
                if (charSequenceF == null) {
                    charSequenceF = "";
                }
                if (c0093bA != null) {
                    c0093bA.a = charSequenceF;
                    bVarA = c0093bA.a();
                } else {
                    Pattern pattern = h.a;
                    h.e eVar2 = new h.e();
                    eVar2.c = charSequenceF;
                    bVarA = eVar2.a().a();
                }
                arrayList.add(bVarA);
            } else {
                this.n.F(iF - 8);
            }
        }
        return new d(arrayList);
    }
}
