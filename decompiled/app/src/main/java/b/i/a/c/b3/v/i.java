package b.i.a.c.b3.v;

import android.text.TextUtils;
import b.i.a.c.f3.e0;
import b.i.a.c.f3.x;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: WebvttDecoder.java */
/* loaded from: classes3.dex */
public final class i extends b.i.a.c.b3.f {
    public final x n;
    public final e o;

    public i() {
        super("WebvttDecoder");
        this.n = new x();
        this.o = new e();
    }

    /* JADX WARN: Code restructure failed: missing block: B:210:0x0395, code lost:
    
        r0.addAll(r5);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x034e  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0110  */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v4, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r7v6 */
    @Override // b.i.a.c.b3.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b.i.a.c.b3.g j(byte[] bArr, int i, boolean z2) throws SubtitleDecoderException {
        g gVarD;
        String strSubstring;
        String str;
        e eVar;
        String string;
        char c;
        int i2;
        x xVar = this.n;
        xVar.a = bArr;
        xVar.c = i;
        int i3 = 0;
        xVar.f984b = 0;
        ArrayList arrayList = new ArrayList();
        try {
            j.c(this.n);
            while (!TextUtils.isEmpty(this.n.g())) {
            }
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                x xVar2 = this.n;
                int i4 = -1;
                ?? r7 = 1;
                char c2 = 65535;
                int i5 = 0;
                while (c2 == 65535) {
                    i5 = xVar2.f984b;
                    String strG = xVar2.g();
                    c2 = strG == null ? (char) 0 : "STYLE".equals(strG) ? (char) 2 : strG.startsWith("NOTE") ? (char) 1 : (char) 3;
                }
                xVar2.E(i5);
                if (c2 == 0) {
                    return new k(arrayList2);
                }
                if (c2 == 1) {
                    while (!TextUtils.isEmpty(this.n.g())) {
                    }
                } else {
                    if (c2 == 2) {
                        if (!arrayList2.isEmpty()) {
                            throw new SubtitleDecoderException("A style block was found after the first cue.");
                        }
                        this.n.g();
                        e eVar2 = this.o;
                        x xVar3 = this.n;
                        eVar2.d.setLength(i3);
                        int i6 = xVar3.f984b;
                        while (!TextUtils.isEmpty(xVar3.g())) {
                        }
                        eVar2.c.C(xVar3.a, xVar3.f984b);
                        eVar2.c.E(i6);
                        ArrayList arrayList3 = new ArrayList();
                        while (true) {
                            x xVar4 = eVar2.c;
                            StringBuilder sb = eVar2.d;
                            e.c(xVar4);
                            if (xVar4.a() >= 5 && "::cue".equals(xVar4.q(5))) {
                                int i7 = xVar4.f984b;
                                String strB = e.b(xVar4, sb);
                                if (strB != null) {
                                    if ("{".equals(strB)) {
                                        xVar4.E(i7);
                                        strSubstring = "";
                                    } else {
                                        if ("(".equals(strB)) {
                                            int i8 = xVar4.f984b;
                                            int i9 = xVar4.c;
                                            boolean z3 = false;
                                            while (i8 < i9 && !z3) {
                                                int i10 = i8 + 1;
                                                z3 = ((char) xVar4.a[i8]) == ')';
                                                i8 = i10;
                                            }
                                            strSubstring = xVar4.q((i8 - 1) - xVar4.f984b).trim();
                                        } else {
                                            strSubstring = null;
                                        }
                                        if (!")".equals(e.b(xVar4, sb))) {
                                            strSubstring = null;
                                        }
                                    }
                                    if (strSubstring == null || !"{".equals(e.b(eVar2.c, eVar2.d))) {
                                        break;
                                    }
                                    f fVar = new f();
                                    if (!"".equals(strSubstring)) {
                                        int iIndexOf = strSubstring.indexOf(91);
                                        if (iIndexOf != i4) {
                                            Matcher matcher = e.a.matcher(strSubstring.substring(iIndexOf));
                                            if (matcher.matches()) {
                                                String strGroup = matcher.group((int) r7);
                                                Objects.requireNonNull(strGroup);
                                                fVar.d = strGroup;
                                            }
                                            strSubstring = strSubstring.substring(i3, iIndexOf);
                                        }
                                        String[] strArrH = e0.H(strSubstring, "\\.");
                                        String str2 = strArrH[i3];
                                        int iIndexOf2 = str2.indexOf(35);
                                        if (iIndexOf2 != i4) {
                                            fVar.f889b = str2.substring(i3, iIndexOf2);
                                            fVar.a = str2.substring(iIndexOf2 + 1);
                                        } else {
                                            fVar.f889b = str2;
                                        }
                                        if (strArrH.length > r7) {
                                            int length = strArrH.length;
                                            b.c.a.a0.d.j(r7);
                                            b.c.a.a0.d.j(length <= strArrH.length);
                                            fVar.c = new HashSet(Arrays.asList((String[]) Arrays.copyOfRange(strArrH, (int) r7, length)));
                                        }
                                    }
                                    boolean z4 = false;
                                    String str3 = null;
                                    while (!z4) {
                                        x xVar5 = eVar2.c;
                                        int i11 = xVar5.f984b;
                                        String strB2 = e.b(xVar5, eVar2.d);
                                        boolean z5 = strB2 == null || "}".equals(strB2);
                                        if (!z5) {
                                            eVar2.c.E(i11);
                                            x xVar6 = eVar2.c;
                                            StringBuilder sb2 = eVar2.d;
                                            e.c(xVar6);
                                            String strA = e.a(xVar6, sb2);
                                            if (!"".equals(strA) && ":".equals(e.b(xVar6, sb2))) {
                                                e.c(xVar6);
                                                StringBuilder sb3 = new StringBuilder();
                                                boolean z6 = false;
                                                while (true) {
                                                    if (z6) {
                                                        str = strB2;
                                                        eVar = eVar2;
                                                        string = sb3.toString();
                                                        break;
                                                    }
                                                    str = strB2;
                                                    int i12 = xVar6.f984b;
                                                    eVar = eVar2;
                                                    String strB3 = e.b(xVar6, sb2);
                                                    if (strB3 == null) {
                                                        string = null;
                                                        break;
                                                    }
                                                    if ("}".equals(strB3) || ";".equals(strB3)) {
                                                        xVar6.E(i12);
                                                        z6 = true;
                                                    } else {
                                                        sb3.append(strB3);
                                                    }
                                                    strB2 = str;
                                                    eVar2 = eVar;
                                                }
                                                if (string != null && !"".equals(string)) {
                                                    int i13 = xVar6.f984b;
                                                    String strB4 = e.b(xVar6, sb2);
                                                    if (";".equals(strB4)) {
                                                        if (!ModelAuditLogEntry.CHANGE_KEY_COLOR.equals(strA)) {
                                                        }
                                                    } else if ("}".equals(strB4)) {
                                                        xVar6.E(i13);
                                                        if (!ModelAuditLogEntry.CHANGE_KEY_COLOR.equals(strA)) {
                                                            fVar.f = b.i.a.c.f3.i.a(string, true);
                                                            fVar.g = true;
                                                        } else if ("background-color".equals(strA)) {
                                                            fVar.h = b.i.a.c.f3.i.a(string, true);
                                                            fVar.i = true;
                                                        } else if ("ruby-position".equals(strA)) {
                                                            if ("over".equals(string)) {
                                                                fVar.p = 1;
                                                            } else if ("under".equals(string)) {
                                                                fVar.p = 2;
                                                            }
                                                        } else if ("text-combine-upright".equals(strA)) {
                                                            fVar.q = "all".equals(string) || string.startsWith("digits");
                                                        } else if ("text-decoration".equals(strA)) {
                                                            if ("underline".equals(string)) {
                                                                fVar.k = 1;
                                                            }
                                                        } else if ("font-family".equals(strA)) {
                                                            fVar.e = b.i.a.f.e.o.f.u1(string);
                                                        } else if ("font-weight".equals(strA)) {
                                                            if ("bold".equals(string)) {
                                                                fVar.l = 1;
                                                            }
                                                        } else if ("font-style".equals(strA)) {
                                                            if ("italic".equals(string)) {
                                                                fVar.m = 1;
                                                            }
                                                        } else if ("font-size".equals(strA)) {
                                                            Matcher matcher2 = e.f888b.matcher(b.i.a.f.e.o.f.u1(string));
                                                            if (matcher2.matches()) {
                                                                String strGroup2 = matcher2.group(2);
                                                                Objects.requireNonNull(strGroup2);
                                                                int iHashCode = strGroup2.hashCode();
                                                                if (iHashCode == 37) {
                                                                    if (strGroup2.equals("%")) {
                                                                        c = 0;
                                                                    }
                                                                    if (c != 0) {
                                                                    }
                                                                    String strGroup3 = matcher2.group(i2);
                                                                    Objects.requireNonNull(strGroup3);
                                                                    fVar.o = Float.parseFloat(strGroup3);
                                                                } else if (iHashCode != 3240) {
                                                                    c = (iHashCode == 3592 && strGroup2.equals("px")) ? (char) 2 : (char) 65535;
                                                                    if (c != 0) {
                                                                        i2 = 1;
                                                                        if (c == 1) {
                                                                            fVar.n = 2;
                                                                        } else {
                                                                            if (c != 2) {
                                                                                throw new IllegalStateException();
                                                                            }
                                                                            fVar.n = 1;
                                                                        }
                                                                    } else {
                                                                        i2 = 1;
                                                                        fVar.n = 3;
                                                                    }
                                                                    String strGroup32 = matcher2.group(i2);
                                                                    Objects.requireNonNull(strGroup32);
                                                                    fVar.o = Float.parseFloat(strGroup32);
                                                                } else {
                                                                    if (strGroup2.equals("em")) {
                                                                        c = 1;
                                                                    }
                                                                    if (c != 0) {
                                                                    }
                                                                    String strGroup322 = matcher2.group(i2);
                                                                    Objects.requireNonNull(strGroup322);
                                                                    fVar.o = Float.parseFloat(strGroup322);
                                                                }
                                                            } else {
                                                                b.d.b.a.a.i0(string.length() + 22, "Invalid font-size: '", string, "'.", "WebvttCssParser");
                                                            }
                                                        } else {
                                                            continue;
                                                        }
                                                    } else {
                                                        continue;
                                                    }
                                                }
                                            } else {
                                                str = strB2;
                                                eVar = eVar2;
                                            }
                                        }
                                        str3 = str;
                                        eVar2 = eVar;
                                        z4 = z5;
                                    }
                                    e eVar3 = eVar2;
                                    if ("}".equals(str3)) {
                                        arrayList3.add(fVar);
                                    }
                                    i3 = 0;
                                    i4 = -1;
                                    r7 = 1;
                                    eVar2 = eVar3;
                                }
                            }
                        }
                    } else if (c2 == 3) {
                        x xVar7 = this.n;
                        Pattern pattern = h.a;
                        String strG2 = xVar7.g();
                        if (strG2 == null) {
                            gVarD = null;
                        } else {
                            Pattern pattern2 = h.a;
                            Matcher matcher3 = pattern2.matcher(strG2);
                            if (matcher3.matches()) {
                                gVarD = h.d(null, matcher3, xVar7, arrayList);
                            } else {
                                String strG3 = xVar7.g();
                                if (strG3 == null) {
                                    gVarD = null;
                                } else {
                                    Matcher matcher4 = pattern2.matcher(strG3);
                                    if (matcher4.matches()) {
                                        gVarD = h.d(strG2.trim(), matcher4, xVar7, arrayList);
                                    }
                                }
                            }
                        }
                        if (gVarD != null) {
                            arrayList2.add(gVarD);
                        }
                    }
                    i3 = 0;
                }
            }
        } catch (ParserException e) {
            throw new SubtitleDecoderException(e);
        }
    }
}
